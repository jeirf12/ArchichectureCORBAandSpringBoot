package client.view;

import client.services.ClientService;
import common.entities.Buy;
import common.utilities.Console;
import common.utilities.Menu;
import java.time.LocalDateTime;

/**
 *
 * @author fallen
 */
public class MenuClient extends Menu {
    private ClientService clientService;
    
    public MenuClient(String title, String []options) {
        super(title, options);
        this.clientService = new ClientService();
        this.repeatedMenu();
    }
    
    @Override
    public void processOption() {
        switch (option) {
            case 1: {
                this.registerBuy();
                break;
            }
            case 2: {
                Console.writeJumpLine("Salir...", false);
                break;
            }
        }
    }
    
    private void registerBuy(){
        int numId = 0, nitCompany = 0;
        double priceBuy = 0;
        String idType = "", placeBuy = "", paymentMethod = "", message;
        Console.writeJumpLine("*****  R E G I S T R O  D E  C O M P R A   *****", false);
        idType = Console.read("Digite el tipo de identificacion: ", idType, false);
        numId = Console.read("Digite el numero de identificacion: ", numId, false);
        priceBuy = Console.read("Digite el precio de la compra: ", priceBuy, false);
        placeBuy = Console.read("Digite el lugar de la compra: ", placeBuy, false);
        paymentMethod = Console.read("Digite el metodo de pago: ", paymentMethod, false);
        nitCompany = Console.read("Digite el nit de la empresa: ", nitCompany, false);
        Buy objBuyRegister = new Buy(numId, idType, priceBuy, placeBuy, paymentMethod, LocalDateTime.now().toString(), nitCompany);
        Buy objBuy = clientService.registerBuy(objBuyRegister);
        message = (objBuy != null)
                ? "El registro de la compra se pudo completar exitosamente!" 
                : "El registro de la compra no se pudo completar exitosamente!";
        Console.writeJumpLine(message, false);
    }
}
