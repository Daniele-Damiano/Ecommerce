/**
 *
 * @author Daniele Damiano  27-lug-2017 12.10.42
 */

package it.beanweb;

import it.entity.Articoli;
import it.entity.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@Named
@RequestScoped
public class ControllerServlet {

    private FacesContext faces;
    private Articoli articoli;
    private Cliente cliente;
    private List<Cliente> cli;
    private Client client;
    private final String URI = "http://localhost:8080/JSFecom/rs/cliente/login/";
    private final String URI1 = "http://localhost:8080/JSFecom/rs/admin/inserisci";

    
    @PostConstruct
    private void init(){
        client = ClientBuilder.newClient();
        cliente = new Cliente();
        cli = new ArrayList<>();
        articoli = new Articoli();
        faces = FacesContext.getCurrentInstance();
    }
   
    @PreDestroy
    private void relase() {
        client.close();
    }

//    public String callGetClientes() {
//        System.out.println("Entrato navigazionaPagine()");
//        String navigation;
//
//        cli = client.target(URI).path("/mostracliente").request().get(new GenericType<List<Cliente>>() {
//        });// new GenericType costruisce Lisy<Cliente> un costruttore vuoto 
//
//        if (cli == null) {
//            navigation = "error";
//        } else {
//            navigation = "success";
//        }
//        return navigation;
//    }

    /**
     * Per il login chiama il metodo login della classe WebServizio
     * 
     * @return Se trova il cliente va a List.xhtml Se non lo trova visualizza messaggio di errore, se sei l'admin ti porta
     * ad admin_page.xhtml.
     * 
     */
    public String callLogin() {
        System.out.println("ENTRATO IN CALLLOGIN()");
        String navigation = "ClientFound";
       

        if (cliente.getEmail().equalsIgnoreCase("")) {
            System.out.println("IL CAMPO EMAIL E NULL");
            faces.addMessage("loginform:email", new FacesMessage(FacesMessage.SEVERITY_WARN, "Email Obbligatoria", "Inserisci Email"));
            return null;
        }
        if (cliente.getPassword().equalsIgnoreCase("")) {
            System.out.println("IL CAMPO PASSWORD E NULL");
            faces.addMessage("loginform:password", new FacesMessage(FacesMessage.SEVERITY_WARN, "Password Obbligatoria", "Inserisci Password"));
            return null;
        }
       
        if (cliente.getEmail().equalsIgnoreCase("admin") && cliente.getPassword().equalsIgnoreCase("admin")) {
            System.out.println("TRUE");
            navigation = "adminPage";
            return navigation;
        }
       /**
        * Chiama il metodo login tramite L'url definita nella stringa URI e i parametri del metodo definiti in path
        */
        cliente = client.target(URI).path(cliente.getEmail()).path(cliente.getPassword()).request().get(Cliente.class);
        if(cliente == null){
            return "ClientNotFound";
        }
         cli.add(cliente);//viene inserito nell arraylist per la durata della sessione
         return navigation;
    }

    
    
    
    
    /**
     * Fare il controllo dei campi 
     */
    public void callInserisciArticolo(){
       
        System.out.println("INIZIO INVOCAZIONE METODO CALL-INSERISCI-ARTICOLO");
        
        WebTarget risorsa = client.target(URI1);
        if(risorsa == null)
            System.out.println("WEBTARGET E NULL");
        Response resp = risorsa.request().post(Entity.xml(articoli), Response.class);
        if(resp.getStatus() == 201){
            System.out.println("ARTICOLO CREATO");
            faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Articolo Creato", "Articolo Creato"));
           
        }else{
            System.out.println("ARTICOLO NON CREATO");
            faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Problema", "Problema")); 
        }
        System.out.println("INVOCAZIONE mETODO TERMINATA");
    }

    
    
    
    
    
    
    
    
    
    
    
    public Articoli getArticoli() {
        return articoli;
    }

    public void setArticoli(Articoli articoli) {
        this.articoli = articoli;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getCli() {
        return cli;
    }

    public void setCli(List<Cliente> cli) {
        this.cli = cli;
    }

}
