package br.inatel.cliente;

import br.inatel.computador.Computador;

public class Cliente {
    private String nome;
    private String cpf;
    private Computador[] computadores; // array de computadores comprados
    private int qtdcomp; // quantidade de computadores adicionados ao carrinho


    //construtor da classe Cliente
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;

        this.computadores = new Computador[10];
        this.qtdcomp = 0;
    }


    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Computador[] getComputadores() {
        return computadores;
    }

    public int getQtdcomp() {
        return qtdcomp;
    }

    // adiciona um computador ao carrinho
    public void compraComputador(Computador comp) {
        if(qtdcomp < computadores.length){
            computadores[qtdcomp] = comp;
            qtdcomp++;
        }
    }

    // calcula o valor total da compra
    public float calculaTotalCompra(){
        float total = 0;
        for(int i=0; i<qtdcomp; i++){
            total = total + computadores[i].getPreco();
        }
        return total;
    }

    // exibe as informações do cliente e da compra
    public void infoCliente(){
        System.out.println("Cliente");
        System.out.println(" -> Nome: " + this.getNome());
        System.out.println(" -> CPF: " + this.getCpf());
        System.out.println("\nCarrinho");
        System.out.println(" -> Quantidade de computadores comprados: " + this.getQtdcomp());
        for(int i=0; i<getQtdcomp(); i++)
        {
            System.out.println();
            computadores[i].mostraPCConfigs();

        }
        System.out.println("\n -> Preço total da compra: R$ " + this.calculaTotalCompra());
    }
}