package server.core.repository;

import common.entities.Buy;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fallen
 */
@Service
public class BuyRepository implements IBuyRepository {
    @Autowired
    private List<Buy> listBuys;
    
    @Override
    public boolean saveBuy(Buy objBuy) {
        return listBuys.add(objBuy);
    }   

    @Override
    public List<Buy> getBuys() {
        return listBuys;
    }
}