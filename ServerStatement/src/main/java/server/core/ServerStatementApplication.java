package server.core;

import common.entities.Buy;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import server.core.utilities.UtilitiesRegisterClient;
import soap_server_notify.IControllerNotify;

@SpringBootApplication
public class ServerStatementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerStatementApplication.class, args);
    }
    
    @Bean
    public IControllerNotify getInstance() {
        String[] arrayDataLocationNS = {"-ORBInitialHost", "localhost", "-ORBInitialPort", "3030" };
        return UtilitiesRegisterClient.obtenerObjRemoto(arrayDataLocationNS, "idObjetoRemoto");
    }
    
    @Bean
    public List<Buy> getList() {
        return new ArrayList<>();
    }
}
