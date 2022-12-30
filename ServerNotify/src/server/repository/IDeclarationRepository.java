package server.repository;

import java.util.List;
import soap_server_notify.IControllerNotifyPackage.BuyDTO;

/**
 *
 * @author fallen
 */
public interface IDeclarationRepository {
    public boolean registerDeclaration(BuyDTO ojbDeclaration);
    public List<BuyDTO> getDeclarations();
}