/**
 *
 * @author Daniele Damiano  31-lug-2017 21.08.33
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Articoli implements Serializable{

    @Id@GeneratedValue
    private int id;
    
       
    @Column(length = 30)
    private String tipo;
   
    @Column(length = 30)
    private String marca;
    
    @Column(length = 30)
    private String modello;
    
    @Column(length = 100)
    private String descrizione;
    
    @Column(length = 30)
    private int prezzo;
    
    @Column(length = 30)
    private String dimensioni;
   
    @Column(length = 30)
    private int giacenza;

    public Articoli() {
    }

    public Articoli(String tipo, String marca, String modello, String descrizione, int prezzo, String dimensioni, int giacenza) {
        this.tipo = tipo;
        this.marca = marca;
        this.modello = modello;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.dimensioni = dimensioni;
        this.giacenza = giacenza;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

   
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public String getDimensioni() {
        return dimensioni;
    }

    public void setDimensioni(String dimensioni) {
        this.dimensioni = dimensioni;
    }

    public int getGiacenza() {
        return giacenza;
    }

    public void setGiacenza(int giacenza) {
        this.giacenza = giacenza;
    }

    @Override
    public String toString() {
        return "Prezzo="+this.prezzo+"Giacenza="+this.giacenza+"Id="+this.id+"Descrizione="+this.descrizione+"Dimensioni="+this.dimensioni+"Marca="+this.marca+"Modello="+this.modello+"Tipo="+this.tipo;
    }
    
    
}
