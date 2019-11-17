package com.example.listviewpianeti.model;

public class Pianeta {

    // nome
    public String nome;

    // distanza dal sole in UA
    public double distanzaSole;

    // volume rapportato alla terra
    public double volumeTerra;

    // numero satelliti naturali
    public int numeroSatelliti;

    public String simbolo;

    public Pianeta(String nome, double distanzaSole, double volumeTerra, int numeroSatelliti, String simbolo) {
        this.nome = nome;
        this.distanzaSole = distanzaSole;
        this.volumeTerra = volumeTerra;
        this.numeroSatelliti = numeroSatelliti;
        this.simbolo = simbolo;
    }
}
