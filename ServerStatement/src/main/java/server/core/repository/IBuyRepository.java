package server.core.repository;

import common.entities.Buy;
import java.util.List;

/**
 *
 * @author fallen
 */
public interface IBuyRepository {
    public boolean saveBuy(Buy objBuy);
    public List<Buy> getBuys();
}