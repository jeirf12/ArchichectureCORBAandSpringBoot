package server.services;

import common.utilities.Console;
import server.controllers.ControllerManageNotify;
import server.repository.DeclarationRepository;
import server.utilities.UtilitiesRegisterServer;

/**
 *
 * @author fallen
 */
public class ServerObject {

    public static void main(String[] args) {
        try {
            String[] vectorDatosLocalizarNS = new String[4];//almacena la información para localizar el ns
            vectorDatosLocalizarNS[0] = "-ORBInitialHost";
            // vectorDatosLocalizarNS[1] = Console.read("Ingrese la dirección IP donde escucha el n_s: ", "",false);
            vectorDatosLocalizarNS[1] = "localhost";
            vectorDatosLocalizarNS[2] = "-ORBInitialPort";
            vectorDatosLocalizarNS[3] = "3030";
            // vectorDatosLocalizarNS[3] = String.valueOf(Console.read("Ingrese el puerto donde escucha el n_s: ", 0,false));

            DeclarationRepository objRepository = new DeclarationRepository();
            ControllerManageNotify objRemotoGestionCanciones = new ControllerManageNotify(objRepository);

            UtilitiesRegisterServer.registerObjectRemoto(vectorDatosLocalizarNS, objRemotoGestionCanciones, "idObjetoRemoto");
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace(System.out);
        }
    }
}
