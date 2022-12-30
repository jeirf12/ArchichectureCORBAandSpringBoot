package server.core.controllers;

import common.entities.Buy;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import server.core.services.IBuyServices;
import soap_server_notify.IControllerNotify;
import soap_server_notify.IControllerNotifyPackage.BuyDTO;

/**
 *
 * @author fallen
 */
@RestController
@RequestMapping("/buy")
public class ControllerManageDeclaration {
    @Autowired
    private IControllerNotify objRemote;
    
    @Autowired
    private IBuyServices buyService;
    
    Logger logger = LoggerFactory.getLogger(ControllerManageDeclaration.class);
    
    @PostMapping("/register/")
    public Buy saveDeclaration(@RequestParam("nid") Integer numberId, @RequestParam("tid") String typeId, @RequestBody Buy objBuy) {
        logger.info("Guardando Compra...");
        boolean flag = false;
        String message = "La compra no se guardo";
        objBuy.setNumberId(numberId);
        objBuy.setIdType(typeId);
        flag = buyService.registerBuy(objBuy);
        if (flag) {
            message = "La compra se guardo con exito";
        }
        logger.info(message);
        if (verifiedBuys(numberId)) {
            BuyDTO objBuyDTO = new BuyDTO(numberId, typeId, objBuy.getPriceBuy(), objBuy.getPlaceBuy(), objBuy.getPaymentMethod(), objBuy.getDateBuy(), objBuy.getNitCompany());
            logger.info("Notificando al servidor de declaraciones....");
            this.objRemote.notifyAlert(objBuyDTO);
        }
        return objBuy;
    }
    @GetMapping("/")
    public List<Buy> getBuys() {
        return this.buyService.getBuys();
    }
    
    private boolean verifiedBuys(int id){
        List<Buy> buys = buyService.getBuys();
        int total = 0;
        for (Buy buy : buys) {
            if(buy.getNumberId() == id) total += buy.getPriceBuy();
        }
        if(total > 45000000) return true;
        return false;
    }
}
