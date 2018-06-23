/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Artu
 */
public class Restaurante {
    Double valor;
    double valorFinal;

    public Restaurante( Double valor) {
        this.valor = valor;
    }


    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valorFinal = valor+valorFinal;
    }

    @Override
    public String toString() {
        return "Restaurante{" + " valor=" + valorFinal + '}';
    }
}
