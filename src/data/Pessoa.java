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
public class Pessoa {
    private int idpessoa;
    private String nome;
    private int cpf;
    private String email;


    public Pessoa(int idpessoa, String nome, int cpf, String email) {
        this.idpessoa = idpessoa;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(int idpessoa) {
        this.idpessoa = idpessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "\nPessoa{" + "id=" + idpessoa + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + '}';
    }

    
    
    
    
  
}
