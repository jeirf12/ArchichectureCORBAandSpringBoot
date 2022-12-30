package common.entities;

import java.time.LocalDateTime;

/**
 *
 * @author fallen
 */
public class Buy {
    private String idType;
    private int numberId;
    private double priceBuy;
    private String placeBuy;
    private String paymentMethod;
    private String dateBuy;
    private int nitCompany;
    
    public Buy() {}
    
    public Buy(int numberId, String idType, double priceBuy, String placeBuy, String paymentMethod, String dateBuy, int nitCompany) {
        this.idType = idType;
        this.numberId = numberId;
        this.priceBuy = priceBuy;
        this.placeBuy = placeBuy;
        this.paymentMethod = paymentMethod;
        this.dateBuy = dateBuy;
        this.nitCompany = nitCompany;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public int getNumberId() {
        return numberId;
    }

    public void setNumberId(int numberId) {
        this.numberId = numberId;
    }

    public double getPriceBuy() {
        return priceBuy;
    }

    public void setPriceBuy(double priceBuy) {
        this.priceBuy = priceBuy;
    }

    public String getPlaceBuy() {
        return placeBuy;
    }

    public void setPlaceBuy(String placeBuy) {
        this.placeBuy = placeBuy;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getDateBuy() {
        return dateBuy;
    }

    public void setDateBuy(String dateBuy) {
        this.dateBuy = dateBuy;
    }

    public int getNitCompany() {
        return nitCompany;
    }

    public void setNitCompany(int nitCompany) {
        this.nitCompany = nitCompany;
    }
}
