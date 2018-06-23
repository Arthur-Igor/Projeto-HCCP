/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetohccp;

import data.Cadastros;

/**
 *
 * @author Artu
 */
public class ProjetoHCCP {

    /**
     * @param args the command line arguments
     */
    //
    public static void main(String[] args) {
        // TODO code application logic here
        Cadastros c = new Cadastros();
                boolean contador = true;
                System.err.println("!=======================!HOTEL CAMPINA CONFORT PREMIUM:!=======================!\n");
        while (contador) {
        System.err.println("!=======================!Menu principal:!=======================!\n");
        System.err.println("Hospede:(1)\nServicos:(2)\nCheckOut(3)\nDigite '0' para SAIR");
        int m1 = c.verifica();
        switch (m1) {//menu principal
            case 1://menu de hospede
                System.err.println("!=======================!Hospede:!=======================!\n");
                System.err.println("Cadastrar novo Hospede:(1)\nEditar Hospede:(2)\nListar Hospedes Cadastrados:(3)\nReabrir Contratos:(4)\nMostrar fatura final:(5)\n");

                int m2 = c.verifica();
                switch (m2) {//menu dos servicos de hospede
                    case 1://cadastrar hospede
                        c.cadastrarHospedes();
                        break;
                    case 2://editar hospede
                        c.editarHospede();
                        break;
                    case 3://listar hospedes
                        c.listarHospedes();
                        break;
                    case 4://reabrir contratos
                        c.reabrirContrato();
                        break;
                    case 5://mostrar fatura
                        c.mostrarFatura();
                        break;
                }

                break;

            case 2://Servicos
                System.err.println("!=======================!Servicos:!=======================!\n");
                System.err.println("Adicionar Servicos:(1)\nCadastrar Servicos:(2)\nListar Servicos:(3)\nRemover Servicos(4)\n");
                int m3 = c.verifica();
                switch (m3) {//menu ara servicos
                    case 1://adicionar servicos
                        c.adicionarServicos();
                        break;
                    case 2://cadastrar serviços
                        System.err.println("!=======================!Cadastrar Servicos:!=======================!\n");
                        System.err.println("Cadastrar Quarto:(1)\nCadastrar Carro:(2)\n");
                        int m4 = c.verifica();
                        switch (m4) {//menu para cadastrar servicos
                            case 1://cadastrar quarto
                                c.cadastrarQuartos();
                                break;
                            case 2://cadastrar carro
                                c.cadastrarCarro();
                                break;
                        }
                        break;
                    case 3://listar servicos
                        System.err.println("!=======================!Listar Servicos:!=======================!\n");
                        System.err.println("Listar Quarto:(1)\nListar Carro:(2)\n");
                        int m5 = c.verifica();
                        switch (m5) {//menu para listar servicos
                            case 1://listar quarto
                                c.listarQuartos();
                                break;
                            case 2://listar carro
                                c.listarCarros();
                                break;
                        }
                        break;
                    case 4://removar servicos
                        System.err.println("!=======================!Remover Servicos:!=======================!\n");
                        System.err.println("Remover Quarto:(1)\nRemover Carro:(2)\n");
                        int m6 = c.verifica();
                        switch (m6) {//menu para remover servicos
                            case 1://remover quarto
                                c.removerQuarto();
                                break;
                            case 2://remover carros
                                c.removerCarro();
                                break;
                        }
                        break;

                }

                break;
            case 3://Checkout
                System.err.println("!=======================!CheckOut:!====================!");
                c.chekOut();
                break;
        }
                    if (m1 == 0) {
                System.out.println("Bye");
                contador = false;
            }

    }
    }
}
