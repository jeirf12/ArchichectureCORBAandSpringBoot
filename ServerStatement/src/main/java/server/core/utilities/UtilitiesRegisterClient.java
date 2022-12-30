package server.core.utilities;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import soap_server_notify.IControllerNotify;
import soap_server_notify.IControllerNotifyHelper;

/**
 *
 * @author fallen
 */
public class UtilitiesRegisterClient {
    public static IControllerNotify obtenerObjRemoto(String[] vectorDatosNS, String idObjetoRemoto) {

        IControllerNotify ref = null;
        try {
            ORB orb = ORB.init(vectorDatosNS, null);

            // se obtiene un link al name service
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // *** Resuelve la referencia del objeto en el N_S ***            
            ref = IControllerNotifyHelper.narrow(ncRef.resolve_str(idObjetoRemoto));
        } catch (Exception e) {
            System.out.println("Error al localizar el objeto remoto");
        }

        return ref;
    }
}