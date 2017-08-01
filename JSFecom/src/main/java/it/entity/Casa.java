/**
 *
 * @author Daniele Damiano  31-lug-2017 9.34.44
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "selectAllCasa", query = "SELECT c FROM Casa c"),
    @NamedQuery(name = "selectCasaFromid", query = "SELECT c FROM Casa c WHERE c.id = :id"),
    @NamedQuery(name = "selectCasaFromMarca", query = "SELECT c FROM Casa c WHERE c.marca = :marca"),
    @NamedQuery(name = "selectCasaFromTipo", query = "SELECT c FROM Casa c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "selectCasaFromPrezzo10", query = "SELECT c FROM Casa c WHERE c.prezzo BETWEEN 10 and 100"),
    @NamedQuery(name = "selectCasaFromPrezzo100", query = "SELECT c FROM Casa c WHERE c.prezzo BETWEEN 100 and 500"),
    @NamedQuery(name = "selectCasaFromPrezzo600", query = "SELECT c FROM Casa c WHERE c.prezzo BETWEEN 600 and 1000")
})
public class Casa implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column(length = 30)
    private String tipo;
    @Column(length = 20)
    private String marca;
    @Column(length = 10)
    private String modello;
    private String descrizione;
    @Column(length = 10)
    private int prezzo;
    @Column(length = 12)
    private String dimensioni;
    @Column(length = 10)
    private int giacenza;

    public Casa() {
    }

    public Casa(String tipo, String marca, String modello, String descrizione, int prezzo, String dimensioni, int giacenza) {
        this.tipo = tipo;
        this.marca = marca;
        this.modello = modello;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.dimensioni = dimensioni;
        this.giacenza = giacenza;
    }

    public int getGiacenza() {
        return giacenza;
    }

    public void setGiacenza(int giacenza) {
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

}
