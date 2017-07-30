/**
 *
 * @author Daniele Damiano  30-lug-2017 22.30.31
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.entity.eletrodomestici;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@NamedQueries({
    @NamedQuery(name = "selectAllElettrodomestici", query = "SELECT c FROM Elettrodomestici c"),
    @NamedQuery(name = "selectElettrodomesticiFromid", query = "SELECT c FROM Elettrodomestici c WHERE c.id = :id"),
    @NamedQuery(name = "selectElettrodomesticiFromMarca", query = "SELECT c FROM Elettrodomestici c WHERE c.marca = :marca"),
    @NamedQuery(name = "selectElettrodomesticiFromTipo", query = "SELECT c FROM Elettrodomestici c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "selectElettrodomesticiFromPrezzo10", query = "SELECT c FROM Elettrodomestici c WHERE c.prezzo BETWEEN 10 and 100"),
    @NamedQuery(name = "selectElettrodomesticiFromPrezzo100", query = "SELECT c FROM Elettrodomestici c WHERE c.prezzo BETWEEN 100 and 500"),
    @NamedQuery(name = "selectElettrodomesticiFromPrezzo600", query = "SELECT c FROM Elettrodomestici c WHERE c.prezzo BETWEEN 600 and 1000")
})
public class Elettrodomestici implements Serializable{
   
    @Id @GeneratedValue
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
    @Column(length = 8)
    private String dimensioni;

    public Elettrodomestici() {
    }

    public Elettrodomestici(String tipo, String marca, String modello, String descrizione, int prezzo, String dimensioni) {
        this.tipo = tipo;
        this.marca = marca;
        this.modello = modello;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.dimensioni = dimensioni;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public String getDimensioni() {
        return dimensioni;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public void setDimensioni(String dimensioni) {
        this.dimensioni = dimensioni;
    }
    
    
}
