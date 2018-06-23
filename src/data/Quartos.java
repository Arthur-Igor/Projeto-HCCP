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
public class Quartos {

    private int tipo;
    private Double valor;
    private int numero;
    private Boolean estado;
    private int dias;
        /**
     *
     * @param tipo
     * @param numero
     * @param estado
     * @param valor
     */

    public Quartos(int tipo, int numero, Boolean estado,double valor) {
        this.tipo = tipo;
        this.numero = numero;
        this.estado = estado;
        this.valor = valor;
    }
 

    public Double getValor() {

        return valor*dias;
    }


    public void setValor(Double valor) {
        this.valor = valor;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    @Override
    public String toString() {
        String esta;
        if(estado){
            esta = "Fechado";
        }else{
            esta = "Aberto";
        }
        return ("\nQuartos{" + "numero=" + numero + ", estado=" + esta + ",Dias = "+dias+'}');
    }

}
