package client.services;

import common.entities.Buy;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 *
 * @author fallen
 */
public class ClientService {
    private String endPoint;
    private Client requestBuy;
    
    public ClientService() {
        this.endPoint = "http://localhost:5000/buy";
        this.requestBuy = ClientBuilder.newClient().register(new JacksonFeature());
    }
    
    public Buy registerBuy(Buy objBuyRegister) {
        Buy objBuy = new Buy();
        WebTarget tarjet = this.requestBuy.target(this.endPoint+"/register/?nid="+objBuyRegister.getNumberId()+"&tid="+objBuyRegister.getIdType());
        Entity<Buy> data = Entity.entity(objBuyRegister, MediaType.APPLICATION_JSON_TYPE);
        Builder objRequest = tarjet.request(MediaType.APPLICATION_JSON_TYPE);
        objBuy = objRequest.post(data, Buy.class);
        return objBuy;
    }
    
    public List<Buy> listBuys() {
        List<Buy> buys = new ArrayList<Buy>();
        WebTarget tarjet = this.requestBuy.target(this.endPoint+"/");
        Builder objRequest = tarjet.request(MediaType.APPLICATION_JSON_TYPE);
        buys = objRequest.get(new GenericType<List<Buy>>(){});
        return buys;
    }
}
