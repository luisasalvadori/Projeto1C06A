import br.inatel.cliente.Cliente;
import br.inatel.computador.Computador;
import br.inatel.loja.Loja;
import br.inatel.processarpedido.ProcessarPedido;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner valorTeclado = new Scanner(System.in); // leitura da entrada do cliente

        Cliente cliente = new Cliente("Luísa", "53094373801"); // criação do cliente que realizará a compra dos computadores
        Loja loja = new Loja(); // instanciação da loja (cria os computadores disponíveis)
        Computador[] comps = loja.getComps(); // obtém os computadores disponíveis

        int opcao; // escolha do usuário

        // loop do menu do usuário
        do{
            System.out.println("Seja bem-vindo(a) à loja PCMania! Indique quais computadores você quer comprar:");
            System.out.println("1: Apple");
            System.out.println("2: Samsung");
            System.out.println("3: Dell");
            System.out.println("Caso não queira comprar mais computadores, selecione '0'\n");

            opcao = valorTeclado.nextInt();

            //estrutura de decisão (qual computador entrará no carrinho)
            switch (opcao){
                case 1:
                    cliente.compraComputador(comps[0]);
                    System.out.println("Computador da Apple adicionado ao carrinho!\n");
                    break;
                case 2:
                    cliente.compraComputador(comps[1]);
                    System.out.println("Computador da Samsung adicionado ao carrinho!\n");
                    break;
                case 3:
                    cliente.compraComputador(comps[2]);
                    System.out.println("Computador da Dell adicionado ao carrinho!\n");
                    break;
                case 0:
                    System.out.println("Compra finalizada.\n");
                    break;
                default:
                    System.out.println("Opção inválida.\n");
            }
        }while(opcao != 0); // enquanto o usuário não seleciona 0, o loop continua

        cliente.infoCliente(); // chama o metodo da classe cliente para mostrar as informações de compra

        // metodo utilitario (helper)
        ProcessarPedido.processar(cliente.getComputadores());
    }
}