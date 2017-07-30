/**
 *
 * @author Daniele Damiano  26-lug-2017 20.24.26
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.database;

import it.entity.Cliente;
import it.entity.eletrodomestici.Elettrodomestici;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Singleton
@Startup
@DataSourceDefinition(
        className = "org.apache.derby.jdbc.EmbeddedDataSource",
        databaseName = "ProvaWebService",
        name = "java:global/jdbc/WebServiceDS",
        user = "app",
        password = "app",
        properties = {"connectionAttributes=;create=true"})
public class ConnectDatabase {

    @Inject
    private EntityManager em;

    private Cliente c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
    private Elettrodomestici e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16;
   
    
    
    @PostConstruct
    private void init() {
        System.out.println("INIZIO CREAZIONE CLIENTI");
        c1 = new Cliente("Daniele", "Damiano","danieledamiano@gmail.com","danieledamiano");
        c2 = new Cliente("Salvatore", "Damiano","salvatoredamiano@gmail.com","salvatoredamiano");
        c3 = new Cliente("Silvana", "Cercola","silvanacercola@gmail.com","silvanacercola");
        c4 = new Cliente("Teresa", "Di Lorenzo","teresadilorenzo@gmail.com","teresadilorenzo");
        c5 = new Cliente("Francesco", "Di Lorenzo","francescodilorenzo@gmail.com","francescodilorenzo");
        c6 = new Cliente("Maria", "Truvolo","mariatruvolo@gmail.com","mariatruvolo");
        c7 = new Cliente("Viktoryia", "Macri","viktoryiamacri@gmail.com","viktoryiamacri");
        c8 = new Cliente("Antonio", "Baldo","antoniobaldo@gmail.com","antoniobaldo");
        c9 = new Cliente("Luca", "De Cristofaro","lucadecristofaro@gmail.com","lucadecristofaro");
        c10 = new Cliente("Gabriella", "Di Marzo","gabrielladimarzo@gmail.com","gabrielladimarzo");
       
        System.out.println("CLIENTI CREATI");
        
        System.out.println("CREAZIONE ELETTRODOMESTICI");
        
        e1 = new Elettrodomestici("Frigorifero", "Samsung", "f10014", "Ottimo elettrodomestico", 100, "100x100");
        e2 = new Elettrodomestici("Frigorifero", "Samsung", "f015", "Ottimo elettrodomestico", 233, "100x200");
        e3 = new Elettrodomestici("Frigorifero", "Brondi", "f016", "Ottimo elettrodomestico", 1000, "100x600");
        e4 = new Elettrodomestici("Lavastoviglie", "Brondi", "a016", "Ottimo elettrodomestico", 403, "100x600");
        e5 = new Elettrodomestici("Lavastoviglie", "Brondi", "a014", "Ottimo elettrodomestico", 456, "100x205");
        e6 = new Elettrodomestici("Forni", "LG", "a015", "Ottimo elettrodomestico", 677, "100x45");
        e7 = new Elettrodomestici("Forni", "LG", "a012", "Ottimo elettrodomestico", 888, "100x45");
        e8 = new Elettrodomestici("Tv", "LG", "fg012", "Ottimo elettrodomestico", 234, "100x684");
        e9 = new Elettrodomestici("Tv", "Nokia", "fg017", "Ottimo elettrodomestico", 23, "100x78521");
        e10 = new Elettrodomestici("Tv", "Nokia", "fg018", "Ottimo elettrodomestico", 10, "100x785");
        e11 = new Elettrodomestici("Lavatrici", "Nokia", "rt018", "Ottimo elettrodomestico", 60, "100x785");
        e12 = new Elettrodomestici("Lavatrici", "Folletto", "rt019", "Ottimo elettrodomestico", 40, "100x500");
        e13 = new Elettrodomestici("Aspirapolvere", "Folletto", "rt23", "Ottimo elettrodomestico", 698, "100x500");
        e14 = new Elettrodomestici("Aspirapolvere", "Folletto", "rt26", "Ottimo elettrodomestico", 1000, "100x250");
        e15 = new Elettrodomestici("Climatizzatore", "Folletto", "f012", "Ottimo elettrodomestico", 345, "100x250");
        e16 = new Elettrodomestici("Climatizzatore", "Samsung", "f013", "Ottimo elettrodomestico", 775, "100x650");
        
        
        System.out.println("ELETTRODOMESTICI CREATI");
        
       
        
        System.out.println("INIZIO PERSIST NEL DASTABSE");
        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        em.persist(c4);
        em.persist(c5);
        em.persist(c6);
        em.persist(c7);
        em.persist(c8);
        em.persist(c9);
        em.persist(c10);

        em.persist(e1);
        em.persist(e2);
        em.persist(e3);
        em.persist(e4);
        em.persist(e5);
        em.persist(e6);
        em.persist(e7);
        em.persist(e8);
        em.persist(e9);
        em.persist(e10);
        em.persist(e11);
        em.persist(e12);
        em.persist(e13);
        em.persist(e14);
        em.persist(e15);
        em.persist(e16);
       
       
        System.out.println("PERSIST COMPLETATO");
    }

    @PreDestroy
    private void relase() {
        System.out.println("INIZIO RIMOZIONE ENTITà");
        em.remove(c1);
        em.remove(c2);
        em.remove(c3);
        em.remove(c4);
        em.remove(c5);
        em.remove(c6);
        em.remove(c7);
        em.remove(c8);
        em.remove(c9);
        em.remove(c10);
        
        em.remove(e1);
        em.remove(e2);
        em.remove(e3);
        em.remove(e4);
        em.remove(e5);
        em.remove(e6);
        em.remove(e7);
        em.remove(e8);
        em.remove(e9);
        em.remove(e10);
        em.remove(e11);
        em.remove(e12);
        em.remove(e13);
        em.remove(e14);
        em.remove(e15);
        em.remove(e16);
      
        System.out.println("RIMOSSE TUTTE LE ENTITà");
    }
}
