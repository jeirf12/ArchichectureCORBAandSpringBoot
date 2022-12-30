package server.repository;

import common.utilities.Console;
import java.util.ArrayList;
import java.util.List;
import soap_server_notify.IControllerNotifyPackage.BuyDTO;

/**
 *
 * @author fallen
 */
public class DeclarationRepository implements IDeclarationRepository {
    private List<BuyDTO> objBuys;
    
    public DeclarationRepository(){
        this.objBuys = new ArrayList<BuyDTO>();
    }
    
    @Override
    public boolean registerDeclaration(BuyDTO ojbDeclaration) {
        boolean flag = false;
        flag = objBuys.add(ojbDeclaration);
        return flag;
    }

    @Override
    public List<BuyDTO> getDeclarations() {
        return this.objBuys;
    }
}