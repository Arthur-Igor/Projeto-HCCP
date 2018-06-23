/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.text.ChoiceFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Artu
 */
public class Cadastros {

    ArrayList<Hospede> hospedesCadastrados = new ArrayList<>();
    ArrayList<Quartos> quartosCadastrados = new ArrayList<>();
    ArrayList<Carro> carrosCadastrados = new ArrayList<>();
    Contrato contratosCadastrados;
    private Scanner ler;
    private int id = 0;

    public void idd() {//incrementa o id
        id++;
    }

    public void cadastrarCarro() {//cadastra um carro

        ler = new Scanner(System.in);

        System.out.println("digite o tipo do carro automóvel luxo(1): automóvel executivo(2) \n");
        int tipo = verifica();
        System.out.println("O carro possui tanque cheio?: (true)-para sim/ (false)-para nao \n");
        boolean tanque = ler.nextBoolean();
        System.out.println("O carro possui seguro?: (true)-para sim/ (false)-para nao \n");
        boolean seguro = ler.nextBoolean();
        idd();
        int idCarro = id;
            double valor = verificaValorCarro(tipo);
            Carro carro = new Carro(idCarro, tipo, tanque, seguro, false, valor);
            carrosCadastrados.add(carro);
            System.out.println("CADASTRO CONCLU�DO! \n");


    }

    public void cadastrarQuartos() {
        ler = new Scanner(System.in);
//String tipo, int numero
        System.out.println("digite o tipo do quarto(PRESIDENCIAL (1), LUXO_SIMPLES(2), LUXO_DUPLO(3),\n"
                + "LUXO_TRIPLO(4), EXECUTIVO_SIMPLES(5),EXECUTIVO_DUPLO(6), EXECUTIVO_TRIPLO(7  ): \n");
        int tipo = verifica();

        System.out.println("digite o numero do quarto: \n");
        int numero = verifica();

        boolean verificar = false;
        for (Iterator<Quartos> it = quartosCadastrados.iterator(); it.hasNext();) {//iterator para pegar todos os quartos cadastrados
            Quartos a = it.next();
            if (a.getNumero() == numero) {
                System.out.println("Quarto já existe!");//caso já exista quartos com o numero cadastrado
                verificar = true;//caso já exista quartos com o numero cadastrado o verificador fica true e nao passa para o cadastro do quarto
                break;
            }
        }
        if (verificar == false) {//cadastro do quarto
            double valor = verificaValorQuarto(tipo);

            Quartos quarto = new Quartos(tipo, numero, false, valor);
            quartosCadastrados.add(quarto);

            System.out.println("Quarto cadastrado!");
        }
    }

    public void cadastrarHospedes() {//cadastra hospedes
        if (quartosCadastrados.isEmpty()) {//para nao deixar hospedes serem cadastrados sem haver quartos antes

            System.err.println("Não existem quartos cadastrados, por favor cadastre ao menos 1 quarto para\n"
                    + " que seja possivel cadastrar um hospede");

        } else {
            ler = new Scanner(System.in);
            //int idpessoa, String nome, String cpf, String email
            System.out.println("digite o nome: \n");
            String nome = ler.next();
            System.out.println("digite o cpf: \n");
            int cpf = verifica();
            System.out.println("digite o e-mail: \n");
            String email = ler.next();
            //int a = 0; // int para interromper a verifica��o do cadastro
            idd();
            int idhospede = id;

            boolean verificar = true;
            for (Iterator<Hospede> it = hospedesCadastrados.iterator(); it.hasNext();) {//roda os hospedes cadastracos
                Hospede a = it.next();
                if (a.getCpf() == cpf) {//verifica se ja existe um hospede com o cpf digitado
                    System.out.println("Já existe um hospede com esse cpf!");
                    verificar = false;
                    break;
                }
            }
            if (verificar) {//cadastra o hospede e cria o contrato ao mesmo tempo
                idd();
                int idContrato = id;
                Date dataInicial = new Date();

                //              long dataFinal = Date.UTC(ano, mes, dia, x, x, x);//ano mes dia
                contratosCadastrados = new Contrato(idContrato, dataInicial, true);

                System.out.println("Contrato cadastrado! \n");

                Hospede hospedew = new Hospede(idhospede, nome, cpf, email);
                hospedew.setContrato(contratosCadastrados);
                hospedesCadastrados.add(hospedew);
                System.out.println("Hospede cadastrado! \n");

            }
        }

        // }
    }//Quando cria hospede tambem cria o seu contrato
    //para criar um hospede vc vai ter que criar um contrato pra ele, cria uma classe criarcontrato, cria e associa ele 
    //ao hospede
    //pra criar o contrato é necessário cadastrar os quartos e os servocos antes

    public void removerHospede() {//inutil, nao é necessario remover hospedes
        ler = new Scanner(System.in);
        System.out.println("Digite o cpf do hospede que deseja excluir");

        int cpf = verifica();

        if (hospedesCadastrados.size() > 0) {
            for (int i = 0; i < hospedesCadastrados.size(); i++) {
                if (hospedesCadastrados.get(i).getCpf() == cpf) {//pega o indice i do objeo pessoa, pega o id da pessoa e compara com o id da pessoa digitada
                    hospedesCadastrados.remove(i); //Remove a pessoa do tipo cpf com o indice i
                    System.err.println("cadastro removido");
                }
            }
        } else {
            System.err.println("Não existem hospedes cadastrados");
        }
//remove all remove todas as pessoas com tal nome	
    }

    public void removerQuarto() {//remove quartos cadastrados
        if (quartosCadastrados.size() > 0) {//verifica se existem quartos cadastrados
            listarQuartos();
            System.out.println("Digite o numero do quarto que deseja excluir:\n");
            int numero = verifica();
            for (int i = 0; i < quartosCadastrados.size(); i++) {
                if (quartosCadastrados.get(i).getNumero() == numero) {
                    if (quartosCadastrados.get(i).getEstado()) {//para verificar se o querto está sendo ocupado
                        System.err.println("O quarto está sendo utilizado por um hospede nesse momento");
                    } else {
                        quartosCadastrados.remove(i);
                        System.err.println("cadastro removido");
                    }
                }

            }
        } else {
            System.err.println("Não existem quartos cadastrados");
        }
    }

    public void removerCarro() {//remover um carro cadastrado

        if (carrosCadastrados.size() > 0) {//verifica se existem carros cadastrados
            listarCarros();
            System.out.println("Digite o id do carro que deseja excluir");
            int idCarro = verifica();
            for (int i = 0; i < carrosCadastrados.size(); i++) {
                if (carrosCadastrados.get(i).getId() == idCarro) {
                    if (carrosCadastrados.get(i).getEstado()) {//para verificar se o querto está sendo ocupado
                        System.err.println("O carrp está sendo utilizado por um hospede nesse momento");
                    } else {
                        carrosCadastrados.remove(i);
                        System.err.println("cadastro removido");
                    }
                }

            }
        } else {
            System.err.println("Não existem carros cadastrados");
        }
    }

    public void listarHospedes() { //funcao para listar hospedes cadastrados
        System.out.println("Hospedes: \n");
        if (hospedesCadastrados.isEmpty()) {
//            String esta = hospedesCadastrados.toString();
//            System.out.println(esta);
            System.err.println("Não existem hospedes cadastrados");
        } else {
            String esta = hospedesCadastrados.toString();
            System.out.println(esta);
            //                       System.out.println(Arrays.toString(hospedesCadastrados.toArray()));
        }

    }

    public void listarQuartos() { //funcao para listar os quartos cadastrados
        System.out.println("Quartos: \n");

        if (quartosCadastrados.size() > 0) {
            String esta = quartosCadastrados.toString();
            System.out.println(esta);
        } else {
            System.err.println("Não existem quartos cadastrados");
        }

    }

    public void listarCarros() {//lista os carros cadastrados
        System.err.println("Carros: \n");
        if (carrosCadastrados.isEmpty()) {
            System.err.println("Nao existem carros cadastrados");
        } else {
            System.err.println(Arrays.toString(carrosCadastrados.toArray()));
        }
    }

    public void adicionarServicos() {//adicionar servicos adicionais ao contrato do cliente
        int i;
        if (hospedesCadastrados.isEmpty()) {
            System.err.println("Não existem hospedes cadastrados!\n");
        } else {

            System.err.println("Digite o cpf do hospede que deseja adicionar servicos:");
            listarHospedes();
            int cpf = verifica();
            for (i = 0; i < hospedesCadastrados.size(); i++) {
                if (hospedesCadastrados.get(i).getCpf() == cpf) {//pega o indice i do objeo pessoa, pega o id da pessoa e compara com o id da pessoa digitada
                    if (hospedesCadastrados.get(i).getContrato().isSituacao()) {//verifica se a situaçao do contrato ainda está aberta para esse hospede

                        System.err.println("O que deseja editar do contrato\n");
                        //adicionar carro, trocar de quarto, adicionar conta de restaurante,
                        //encerrar contrato

                        System.err.println("Adicionar carro (1):\nAdicionar restaurante (2):\n"
                                + "Adicionar horas de BabySitter (3):\nAdicionar quarto(4):\n");
                        int caso = verifica();
                        switch (caso) {
                            case 1://carro
                                if (carrosCadastrados.isEmpty()) {
                                    System.err.println("Nao existem carros cadastrados!\n");
                                } else {
                                    listarCarros();
                                    System.err.println("Digite o id do carro que deseja contratar:\n");
                                    int idCarro = verifica();

                                    for (int j = 0; j < carrosCadastrados.size(); j++) {
                                        if (carrosCadastrados.get(j).getId() == idCarro) {
                                            if (carrosCadastrados.get(j).isEstado()) {
                                                System.err.println("Esse carro já está cadastrado.\n");
                                            } else {
                                                hospedesCadastrados.get(i).getContrato().setCarros(carrosCadastrados.get(j));
                                                carrosCadastrados.get(j).setEstado(true);
                                            }
                                        }
                                    }
                                }
                                break;

                            case 2://restaurante
                                System.err.println("Digite o quanto deseja gastar no restaurente\n");
                                double valorRestaurante = ler.nextDouble();
//                                idd();
//                                int idRestaurante = id;
//                                Restaurante restaurante = new Restaurante(idRestaurante, valorRestaurante);
                                hospedesCadastrados.get(i).getContrato().setValorRestaurante(valorRestaurante);
                                break;
                            case 3://babysitter
                                System.err.println("Digite o tempo gasto no BabySytter em horas\n");
                                double tempoBaby = ler.nextDouble();
                                hospedesCadastrados.get(i).getContrato().setHorasBaby(tempoBaby);
                                break;
                            case 4://quartos

                                if (quartosCadastrados.isEmpty()) {

                                } else {
                                    System.err.println("Digite o numero do quarto que deseja contratar:\n");
                                    listarQuartos();
                                    int num = verifica();
                                    System.err.println("Digite a quantidade de dis que pretente alugar o quarto:\n");
                                    int dias = verifica();
                                    for (int j = 0; j < quartosCadastrados.size(); j++) {
                                        if (num == quartosCadastrados.get(j).getNumero()) {//verifica se o numero digitado é igual ao numero do quarto do laco
                                            if (quartosCadastrados.get(j).getEstado()) {//verifica se o estado do quarto está como true
                                                System.err.println("Este quarto já está cadastrado em um contrato");
                                            } else {//se o estado tiver em true é porque o quarto ja está cadastrado

                                                hospedesCadastrados.get(i).getContrato().setQuartos(quartosCadastrados.get(j));
                                                hospedesCadastrados.get(i).getContrato().getQuartosCadastrados().get(j).setDias(dias);
                                                hospedesCadastrados.get(i).getContrato().getQuartosCadastrados().get(j).setEstado(true);//seta o estado do quarto como ocupado
                                                System.err.println("Quarto cadastrado!\n");
                                            }

                                        }

                                    }

//remove all remove todas as pessoas com tal nome	
                                }
                                break;

                        }
                    } else {
                        System.err.println("O contrato deste Hospede encontra-se encerrado");
                        break;
                    }
                }
            }
        }
    }

    public void chekOut() {//faz checkout dos servicos e limpa as disponibilidades dos mesmos
        int i;
        System.err.println("CheckOut do contrato:\n");

        if (hospedesCadastrados.isEmpty()) {
            System.err.println("Nao existe hospedes cadastrados\n");

        } else {
            System.err.println("Digite o cpf do hospede á fazer checkout:\n");

            listarHospedes();
            int cpf = verifica();
            for (i = 0; i < hospedesCadastrados.size(); i++) {
                if (hospedesCadastrados.get(i).getCpf() == cpf) {//hospede
                    if (hospedesCadastrados.get(i).getContrato().isSituacao()) {

                        System.err.println("Nome do hospede:" + hospedesCadastrados.get(i).getNome());
                        System.err.println("CPF:" + hospedesCadastrados.get(i).getCpf() + "\n");
                        System.err.println("Servicos pedidos:\nCarros:");
                        if (!(hospedesCadastrados.get(i).getContrato().getCarrosCadastrados() == null)) {
                            System.err.println(hospedesCadastrados.get(i).getContrato().getCarrosCadastrados().toString());
                            System.err.println("Total do serviço de aluguel de carros R$:" + hospedesCadastrados.get(i).getContrato().getContaFinalCarros() + "\n");//;
                        } else {
                            System.err.println("\nO hospede nao possui carros cadastrados!\n");
                        }//aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa

                        System.err.println("Quartos:");
                        if (!(hospedesCadastrados.get(i).getContrato().getQuartosCadastrados() == null)) {
                            System.err.println(hospedesCadastrados.get(i).getContrato().getQuartosCadastrados().toString());
                            System.err.println("Total do servico de quartos R$:" + hospedesCadastrados.get(i).getContrato().getContaFinalQuartos() + "\n");//;
                        } else {
                            System.err.println("\nO hospede nao possui Quartos cadastrados!\n");
                        }//aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
//                        System.err.println("Servicos pedidos:\nCarros:" + hospedesCadastrados.get(i).getContrato().getCarrosCadastrados().toString());
//                        System.err.println("Total do serviço de aluguel de carros R$:" + hospedesCadastrados.get(i).getContrato().getContaFinalCarros() + "\n");//;
//                        System.err.println("Servicos de aluguel de Quartos:" + hospedesCadastrados.get(i).getContrato().getQuartosCadastrados().toString());
//                        System.err.println("Total do servico de quartos R$:" + hospedesCadastrados.get(i).getContrato().getContaFinalQuartos() + "\n");
                        System.err.println("Restaurante: ");
                        System.err.println("Total do servico de restaurante R$: " + hospedesCadastrados.get(i).getContrato().getValorRestaurante() + "\n");
                        System.err.println("Total de horas de BabySitter contratatas:" + hospedesCadastrados.get(i).getContrato().getHorasBaby() / 45 + "\n"
                                + "Total do servico de BabySitter R$:" + hospedesCadastrados.get(i).getContrato().getHorasBaby() + "\n");
                        System.err.println("Total Fatura final: R$" + hospedesCadastrados.get(i).getContrato().getContaFinal());
                        //para limpar as disponibilidades dos servicos
                        //carros, quarto, contrato e hospede
                        //é necessario remover o hospede?

                        if (hospedesCadastrados.get(i).getContrato().getCarrosCadastrados() == null) {//limpa os carros cadastrados
                        } else {
                            for (int k = 0; k < hospedesCadastrados.get(i).getContrato().getCarrosCadastrados().size(); k++) {
                                hospedesCadastrados.get(i).getContrato().getCarrosCadastrados().get(k).setEstado(false);
                                System.err.println("Teste de estado do carro");

                            }

                        }
                        if (hospedesCadastrados.get(i).getContrato().getQuartosCadastrados() == null) {//limpa os quartoscadastrados
                        } else {
                            for (int k = 0; k < hospedesCadastrados.get(i).getContrato().getQuartosCadastrados().size(); k++) {
                                hospedesCadastrados.get(i).getContrato().getQuartosCadastrados().get(k).setEstado(false);
                            }

                        }//else quartos

                        hospedesCadastrados.get(i).getContrato().zerar();//zera os dados do hospede

                    } else {
                        System.err.println("O contrato desse hospede já encontrasse encerrado");
                    }
                }
            }
        }
    }

    public void editarHospede() {//edita um hospede existente
        int i;
        if (hospedesCadastrados.isEmpty()) {
            System.err.println("Nao existe hospedes cadastrados\n");
        } else {
            listarHospedes();
            int cpf = verifica();
            for (i = 0; i < hospedesCadastrados.size(); i++) {
                if (hospedesCadastrados.get(i).getCpf() == cpf) {//hospede
                    System.err.println("O que deseja editar:\n Nome(1)\n"
                            + "Cpf(2)\nE-MAIL(3)");
                    int a = verifica();
                    switch (a) {
                        case 1:
                            System.err.println("Digite o novo nome do hospede:\n");
                            String nome = ler.next();
                            hospedesCadastrados.get(i).setNome(nome);
                            System.err.println("Atualzacao concluida!\n");
                            break;
                        case 2:
                            System.err.println("Digite o novo CPF do hospede:\n");
                            int cpf1 = verifica();
                            hospedesCadastrados.get(i).setCpf(cpf1);
                            System.err.println("Atualzacao concluida!\n");
                            break;
                        case 3:
                            System.err.println("Digite o novo E-MAIL do hospede:\n");
                            String email = ler.next();
                            hospedesCadastrados.get(i).setEmail(email);
                            System.err.println("Atualzacao concluida!\n");
                            break;
                    }

                } else if (hospedesCadastrados.size() == i) {
                    System.err.println("Nao existem hospedes com esse cpf cadastrados!\n");
                }
            }
        }
    }

    public void reabrirContrato() {//para reabrir contratos fechados anteriormente
        int i;
        if (hospedesCadastrados.isEmpty()) {
            System.err.println("Nao existe hospedes cadastrados\n");
        } else {
            listarHospedes();
            int cpf = verifica();
            for (i = 0; i < hospedesCadastrados.size(); i++) {
                if (hospedesCadastrados.get(i).getCpf() == cpf) {//hospede
                    if (hospedesCadastrados.get(i).getContrato().isSituacao()) {//verifica se o contrato já estpa aberto
                        System.err.println("O contrado desse hospede já encontra-se aberto");

                    } else {//caso o contrato encontre-se fechado
                        hospedesCadastrados.get(i).getContrato().setSituacao(true);
                        System.err.println("Contrato reaberto, agora voce pode reusufruir de nossos servicos!");
                    }
                }
            }
        }
    }

    public static double verificaValorQuarto(int tipo) {//verifica  o preco do carro pelo tipo
        double valor = 0;
        switch (tipo) {
            case 1:
                return valor + 1200;
            case 2:
                return valor + 520;
            case 3:
                return valor + 570;
            case 4:
                return valor + 620;
            case 5:
                return valor + 360;
            case 6:
                return valor + 385;
            case 7:
                return valor + 440;
            default:
                break;
        }
        return valor;
    }

    public static double verificaValorCarro(int tipo) {//verifica o valor do carro pelo tipo
        double valor = 0;
        switch (tipo) {
            case 1:
                return valor + 1200;
            case 2:
                return valor + 520;
            default:
                break;

        }
        return valor;
    }

    public void mostrarFatura() {//mostra a fatura do hospede

        int i;
        System.err.println("Fatura do contrato:\n");

        if (hospedesCadastrados.isEmpty()) {//caso nao existam hospedes
            System.err.println("Nao existe hospedes cadastrados\n");

        } else {
            System.err.println("Digite o cpf do hospede:\n");

            listarHospedes();
            int cpf = verifica();
            for (i = 0; i < hospedesCadastrados.size(); i++) {//roda os hospedes cadastrados
                if (hospedesCadastrados.get(i).getCpf() == cpf) {//pega o hospede pelo cpf
                    if (hospedesCadastrados.get(i).getContrato().isSituacao()) {//caso a situacao do contrato ainda estaja ativa

                        System.err.println("Nome do hospede:" + hospedesCadastrados.get(i).getNome());
                        System.err.println("CPF:" + hospedesCadastrados.get(i).getCpf() + "\n");
                        System.err.println("Servicos pedidos:\nCarros:");
                        if (!(hospedesCadastrados.get(i).getContrato().getCarrosCadastrados() == null)) {
                            System.err.println(hospedesCadastrados.get(i).getContrato().getCarrosCadastrados().toString());
                            System.err.println("Total do serviço de aluguel de carros R$:" + hospedesCadastrados.get(i).getContrato().getContaFinalCarros() + "\n");//;
                        } else {
                            System.err.println("\nO hospede nao possui carros cadastrados!\n");
                        }
                        System.err.println("Quartos:");
                        if (!(hospedesCadastrados.get(i).getContrato().getQuartosCadastrados() == null)) {
                            System.err.println(hospedesCadastrados.get(i).getContrato().getQuartosCadastrados().toString());
                            System.err.println("Total do servico de quartos R$:" + hospedesCadastrados.get(i).getContrato().getContaFinalQuartos() + "\n");//;
                        } else {
                            System.err.println("\nO hospede nao possui Quartos cadastrados!\n");
                        }
                        System.err.println("Restaurante:");
                        System.err.println("Total do servico de restaurante R$: " + hospedesCadastrados.get(i).getContrato().getValorRestaurante() + "\n");
                        System.err.println("Total de horas de BabySitter contratatas:" + hospedesCadastrados.get(i).getContrato().getHorasBaby() / 45 + "\n"
                                + "Total do servico de BabySitter R$:" + hospedesCadastrados.get(i).getContrato().getHorasBaby() + "\n");
                        System.err.println("Total Fatura final: R$" + hospedesCadastrados.get(i).getContrato().getContaFinal());
                        //para limpar as disponibilidades dos servicos
                        //carros, quarto, contrato e hospede
                        //é necessario remover o hospede?
//                  

                    } else {//caso o contrato esteja fechado
                        System.err.println("O hospede encontra-se com o contrato fechado!");
                    }
                }

            }
        }
    }

    public static int verifica() {//verifica se os dados digitados sao do tipo double
        boolean naoEInt = true;
        int valor = 0;
        while (naoEInt) {
            Scanner leitor = new Scanner(System.in);
            System.out.println("=====================");
            try {
                valor = leitor.nextInt();
                naoEInt = false;
            } catch (Exception e) {
                System.out.println("Os dados digitados não são válidos!");
            }
        }
        return valor;
    }

}
