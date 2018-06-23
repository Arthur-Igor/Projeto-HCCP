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
public class Carro {
    private int id;
    private double valor;
    private int tipo;
    private Boolean estado;
    private Boolean tanque;
    private Boolean seguro;
    private double valorDoTipo[];

    public Carro(int id,int tipo, Boolean tanque, Boolean seguro, Boolean estado,double valor) {
        this.id = id;
        this.tipo = tipo;
        this.tanque = tanque;
        this.seguro = seguro;
        this.estado = estado;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Boolean getTanque() {
        return tanque;
    }

    public void setTanque(Boolean tanque) {
        this.tanque = tanque;
    }

    public Boolean getSeguro() {
        return seguro;
    }

    public void setSeguro(Boolean seguro) {
        this.seguro = seguro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        String esta;
        if(estado){
            esta = "Fechado";
        }else{
            esta = "Aberto";
        }
        return "\nCarro{" + "id=" + id + ", tipo=" + tipo + ", estado=" + esta + ", tanque=" + tanque + ", seguro=" + seguro + '}';
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    
}
