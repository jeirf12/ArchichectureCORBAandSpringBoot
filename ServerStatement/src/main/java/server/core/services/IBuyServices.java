package server.core.services;

import common.entities.Buy;
import java.util.List;

/**
 *
 * @author fallen
 */
public interface IBuyServices {
    public boolean registerBuy(Buy objBuy);
    public List<Buy> getBuys();
}