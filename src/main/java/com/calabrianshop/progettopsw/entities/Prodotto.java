package com.calabrianshop.progettopsw.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Prodotto {
    private int id;
    private String nome;
    private String categoria;
    private int quantita;
    private double prezzo;
    private String venditore;
    private String imagePath;
    private String descrizione;
    private Collection<ProdottoInCarrello> prodottoInCarrello;
    private Collection<OrdineProdotto> ordineProdottoCol;
    private int version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "categoria")
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Basic
    @Column(name = "quantita")
    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    @Basic
    @Column(name = "prezzo")
    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    @Basic
    @Column(name = "venditore")
    public String getVenditore() {
        return venditore;
    }

    public void setVenditore(String venditore) {
        this.venditore = venditore;
    }

    @Basic
    @Column(name = "imagepath")
    public String getImagePath(){
        return imagePath;
    }

    public void setImagePath(String s){
        this.imagePath=s;
    }

    @Basic
    @Column(name = "descrizione")
    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prodotto prodotto = (Prodotto) o;
        return id == prodotto.id &&
                quantita == prodotto.quantita &&
                Double.compare(prodotto.prezzo, prezzo) == 0 &&
                Objects.equals(nome, prodotto.nome) &&
                Objects.equals(categoria, prodotto.categoria) &&
                Objects.equals(venditore, prodotto.venditore);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nome, categoria, quantita, prezzo, venditore);
    }

    @JsonIgnore
    @OneToMany( mappedBy = "prodotto")
    public Collection<ProdottoInCarrello> getProdottoInCarrello() {
        return prodottoInCarrello;
    }

    public void setProdottoInCarrello(Collection<ProdottoInCarrello> prodottoInCarrello) {
        this.prodottoInCarrello = prodottoInCarrello;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "prodotto")
    public Collection<OrdineProdotto> getOrdineProdottoCol() {
        return ordineProdottoCol;
    }

    public void setOrdineProdottoCol(Collection<OrdineProdotto> ordineProdottoCol) {
        this.ordineProdottoCol = ordineProdottoCol;
    }

    @Version
    @Column(name = "version")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
