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

import it.entity.Casa;
import it.entity.Cliente;
import it.entity.Elettrodomestici;
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
    private Casa cc1,cc2,cc3,cc4,cc5,cc6,cc7,cc8,cc9,cc10;
    
    
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
        
        e1 = new Elettrodomestici("Frigorifero", "Samsung", "f10014", "Ottimo elettrodomestico", 100, "100x100",100);
        e2 = new Elettrodomestici("Frigorifero", "Samsung", "f015", "Ottimo elettrodomestico", 233, "100x200",200);
        e3 = new Elettrodomestici("Frigorifero", "Brondi", "f016", "Ottimo elettrodomestico", 1000, "100x600",500);
        e4 = new Elettrodomestici("Lavastoviglie", "Brondi", "a016", "Ottimo elettrodomestico", 403, "100x600",450);
        e5 = new Elettrodomestici("Lavastoviglie", "Brondi", "a014", "Ottimo elettrodomestico", 456, "100x205",151);
        e6 = new Elettrodomestici("Forni", "LG", "a015", "Ottimo elettrodomestico", 677, "100x45",600);
        e7 = new Elettrodomestici("Forni", "LG", "a012", "Ottimo elettrodomestico", 888, "100x45",545);
        e8 = new Elettrodomestici("Tv", "LG", "fg012", "Ottimo elettrodomestico", 234, "100x684",65);
        e9 = new Elettrodomestici("Tv", "Nokia", "fg017", "Ottimo elettrodomestico", 23, "100x78521",654);
        e10 = new Elettrodomestici("Tv", "Nokia", "fg018", "Ottimo elettrodomestico", 10, "100x785",87);
        e11 = new Elettrodomestici("Lavatrici", "Nokia", "rt018", "Ottimo elettrodomestico", 60, "100x785",654);
        e12 = new Elettrodomestici("Lavatrici", "Folletto", "rt019", "Ottimo elettrodomestico", 40, "100x500",654);
        e13 = new Elettrodomestici("Aspirapolvere", "Folletto", "rt23", "Ottimo elettrodomestico", 698, "100x500",68);
        e14 = new Elettrodomestici("Aspirapolvere", "Folletto", "rt26", "Ottimo elettrodomestico", 1000, "100x250",1);
        e15 = new Elettrodomestici("Climatizzatore", "Folletto", "f012", "Ottimo elettrodomestico", 345, "100x250",354);
        e16 = new Elettrodomestici("Climatizzatore", "Samsung", "f013", "Ottimo elettrodomestico", 775, "100x650",41);
        
        System.out.println("ELETTRODOMESTICI CREATI");
        
        System.out.println("CREAZIONE ARTICOLI CASA");
        
        cc1 = new Casa("Cuscino", "MemoryFoam", "ak2", "Ottimo Modello", 110, "100x100",123);
        cc2 = new Casa("Panno", "Vileda", "ak245", "Ottimo Modello", 250, "100x32",7);
        cc3 = new Casa("Tavolo", "Ikea", "ae245", "Ottimo Modello", 548, "100x11",867);
        cc4 = new Casa("Stiro", "Ponti", "ad245", "Ottimo Modello", 1000, "100x567",33);
        cc5 = new Casa("Pentole", "Bialetti", "fd245", "Ottimo Modello", 215, "100x433",11);
        cc6 = new Casa("Piatto", "Boch", "fd245", "Ottimo Modello", 698, "100x876",216);
        cc7 = new Casa("Asse Stiro", "Rowenta", "vc245", "Ottimo Modello", 900, "000x200",500);
        cc8 = new Casa("Bicchieri Plastica", "Dopla", "bn245", "Ottimo Modello", 458, "100x200",400);
        cc9 = new Casa("Bicchieri Vetro", "RGMania", "ftr44", "Ottimo Modello", 20, "1000x200",100);
        cc10 = new Casa("Divano", "Divani&Divani", "ak1", "Ottimo Modello", 300, "100x800",54);
        
        System.out.println("ARTICOLI CASA CREATI");
        
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
        
        em.persist(cc1);
        em.persist(cc2);
        em.persist(cc3);
        em.persist(cc4);
        em.persist(cc5);
        em.persist(cc6);
        em.persist(cc7);
        em.persist(cc8);
        em.persist(cc9);
        em.persist(cc10);
        
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
        
        em.remove(cc1);
        em.remove(cc2);
        em.remove(cc3);
        em.remove(cc4);
        em.remove(cc5);
        em.remove(cc6);
        em.remove(cc7);
        em.remove(cc8);
        em.remove(cc9);
        em.remove(cc10);
      
        System.out.println("RIMOSSE TUTTE LE ENTITà");
    }
}
