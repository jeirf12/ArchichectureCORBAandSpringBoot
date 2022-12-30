package server.core.services;

import common.entities.Buy;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.core.repository.BuyRepository;

/**
 *
 * @author fallen
 */
@Service
public class BuyServices implements IBuyServices {
    @Autowired
    private BuyRepository repositoryBuy;

    @Override
    public boolean registerBuy(Buy objBuy) {
        return repositoryBuy.saveBuy(objBuy);
    }

    @Override
    public List<Buy> getBuys() {
        return repositoryBuy.getBuys();
    }
}