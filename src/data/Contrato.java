/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Artu
 */
public class Contrato {

    private int idcontrato;
    private double ContaFinal;
    private Date DataInicial;
    private long DataFinal;
    private boolean situacao;
    private ArrayList<Carro> carrosCadastrados = new ArrayList<>();
    private double contaFinalCarros;
    private double contaFinalQuartos;
    private double contaFinalRestaurante;
    private ArrayList<Quartos> quartosCadastrados = new ArrayList<>();
//    private ArrayList<Restaurante> restaurantesCadastrados = new ArrayList<>();
    private double valorRestaurante;
    private double horasBaby;

    public Contrato(int idcontrato, Date DataInicial, boolean situacao) {
        this.idcontrato = idcontrato;
        this.DataFinal = DataFinal;
        this.situacao = situacao;
    }

    public int getIdcontrato() {
        return idcontrato;
    }

    public void setIdcontrato(int idcontrato) {
        this.idcontrato = idcontrato;
    }

    public void setContaFinal(double aux) {
        this.ContaFinal = ContaFinal + aux;
    }

    public Date getDataInicial() {
        return DataInicial;
    }

    public void setDataInicial(Date DataInicial) {
        this.DataInicial = DataInicial;
    }

    public long getDataFinal() {
        return DataFinal;
    }

    public void setDataFinal(long DataFinal) {
        this.DataFinal = DataFinal;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public ArrayList<Carro> getCarrosCadastrados() {
        return carrosCadastrados;
    }

    public void setCarrosCadastrados(ArrayList<Carro> carrosCadastrados) {
        this.carrosCadastrados = carrosCadastrados;
    }

    public ArrayList<Quartos> getQuartosCadastrados() {
        return quartosCadastrados;
    }

    public void setQuartosCadastrados(ArrayList<Quartos> quartosCadastrados) {
        this.quartosCadastrados = quartosCadastrados;
    }

    public void setCarros(Carro carros) {
        this.carrosCadastrados.add(carros);
    }

    public void setQuartos(Quartos quarto) {
        this.quartosCadastrados.add(quarto);
    }

    public double getContaFinalCarros() {
        double aux = 0.0;
        if (carrosCadastrados == null) {
            return 0.0;
        } else {
            for (Carro a : carrosCadastrados) {
                aux = aux + (a.getValor());
            }
            return contaFinalCarros + aux;
        }

    }

    public void setContaFinalCarros(Double contaFinalCarros) {
        this.contaFinalCarros = contaFinalCarros;
    }

    public double getContaFinalQuartos() {
        double aux = 0.0;
        if (quartosCadastrados == null) {
            return 0.0;
        } else {
            for (Quartos a : quartosCadastrados) {
                aux = aux + (a.getValor());
            }
            return contaFinalQuartos + aux;
        }

    }

    public void setContaFinalQuartos(double contaFinalQuartos) {
        this.contaFinalQuartos = contaFinalQuartos;
    }

    public void setContaFinalRestaurante(double contaFinalRestaurante) {
        this.contaFinalRestaurante = contaFinalRestaurante;
    }

    public double getHorasBaby() {
        return horasBaby * 45;
    }

    public void setHorasBaby(double horasBaby) {
        this.horasBaby = horasBaby;
    }

    public double getValorRestaurante() {
        return valorRestaurante;
    }

    public void setValorRestaurante(double valorRestaurante) {
        this.valorRestaurante = valorRestaurante;
    }

    public void zerar() {
        this.carrosCadastrados = null;
        this.contaFinalCarros = 0.0;
        this.contaFinalQuartos = 0.0;
        this.contaFinalRestaurante = 0.0;
        this.quartosCadastrados = null;
        this.valorRestaurante = 0.0;
        this.horasBaby = 0.0;
        setSituacao(false);
    }

    public double getContaFinal() {

        return ContaFinal + (getContaFinalCarros()) + (getContaFinalQuartos()) + (getValorRestaurante()) + (getHorasBaby());
    }

}
