/**
 *
 * @author Daniele Damiano  26-lug-2017 20.17.29
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.webservice;

import it.entity.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/mostracliente")
@Produces(MediaType.APPLICATION_XML)
public class WebServizio {

    @Inject
    private EntityManager em;

    @GET
    public List<Cliente> getClientes() {
        System.out.println("Entrato in getClientes");
        Query query = em.createNamedQuery("allClient");
        List<Cliente> c = query.getResultList();
        return c;
    }

    @POST
    @Path("insert")
    @Consumes(MediaType.TEXT_PLAIN)
    public void insertCliente() {
        System.out.println("CIao");
    }

}
