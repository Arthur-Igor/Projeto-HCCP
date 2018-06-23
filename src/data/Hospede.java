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
public class Hospede extends Pessoa{
    private Contrato contrato;

    public Hospede(int idpessoa, String nome, int cpf, String email) {
        super(idpessoa, nome, cpf, email);
    }
    
    private String codigo_cliente;



    public String getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
    public String teste(){
        return "\nPessoa{" + "idpessoa=" + getIdpessoa() + ", nome=" + getNome() + ", cpf=" + getCpf() + ", email=" + getEmail() + '}';
    }

    @Override
    public String toString() {
//        String esta = super.toString();
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}