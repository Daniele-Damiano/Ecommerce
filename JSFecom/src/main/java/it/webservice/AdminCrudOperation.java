/**
 *
 * @author Daniele Damiano  31-lug-2017 19.28.30
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.webservice;

import it.entity.Articoli;
import java.net.URI;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/admin")
@Stateless
public class AdminCrudOperation {

    @Inject
    private EntityManager em;

    @POST
    @Path("inserisci")
    @Consumes(MediaType.APPLICATION_XML)
    public Response inserisciArticolo(Articoli articoli) {
        em.persist(articoli);
        return Response.created(URI.create("/" + articoli.getTipo())).build();
    }
    
}

