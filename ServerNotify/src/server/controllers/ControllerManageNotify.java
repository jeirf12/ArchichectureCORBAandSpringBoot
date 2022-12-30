package server.controllers;

import common.utilities.Console;
import server.repository.IDeclarationRepository;
import soap_server_notify.IControllerNotifyPOA;
import soap_server_notify.IControllerNotifyPackage.BuyDTO;

/**
 *
 * @author fallen
 */
public class ControllerManageNotify extends IControllerNotifyPOA {
    private IDeclarationRepository objDeclaration;
    
    public ControllerManageNotify(IDeclarationRepository objDeclaration){
        this.objDeclaration = objDeclaration;
    }
    
    @Override
    public boolean notifyAlert(BuyDTO objBuy) {
        boolean flag = false;
        flag = this.objDeclaration.registerDeclaration(objBuy);
        if(flag) showData(objBuy.numberId);
        return flag;
    }
    
    private void showData(int id) {
        Console.writeJumpLine("\n*****  N U E V A  N O T I F I C A C I Ó N  *****", false);
        for (BuyDTO objBuy : this.objDeclaration.getDeclarations()) {
            if(objBuy.numberId == id) {
                Console.writeJumpLine(
                        "\nNo Identificacion: " + objBuy.numberId
                        + "\nTipo Identificacion: " + objBuy.idType,
                        false);
                System.out.printf("Valor de Compra: %,2f", objBuy.priceBuy);
                Console.writeJumpLine(
                        "\nLugar de la Compra: " + objBuy.placeBuy
                        + "\nFecha y hora de Compra: " + objBuy.dateBuy
                        + "\nMedio de pago: " + objBuy.paymentMethod
                        + "\nNit empresa: " + objBuy.nitCompany,
                        false);
            }
        }
    }
}