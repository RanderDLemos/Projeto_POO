import br.inatel.cdg.Pedido.ProcessarPedido;
import br.inatel.cdg.compraPC.Cliente;
import br.inatel.cdg.compraPC.Computador;
import br.inatel.cdg.compraPC.MemoriaUSB;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);

        String nome;
        String cpf;
        int matricula;

        System.out.println("Olá, bem vindo a PC Mania, vamos preparar seu pedido?");
        System.out.println("Poderia digitar seu nome e seu CPF para começarmos?");
        System.out.print("Nome: ");
        nome = entrada.next();
        System.out.print("CPF: ");
        cpf = entrada.next();

        Cliente cliente = new Cliente(nome, cpf);

        System.out.print("Para continuarmos, poderia digitar sua matrícula para vermos os preços, por favor: ");
        matricula = entrada.nextInt();
        System.out.println();

        Computador pc = null;
        int opcao = -1;

        while(opcao != 0){

            Computador.opcoesPromo(opcao, matricula);

            opcao = entrada.nextInt();

            pc = Computador.opcaoEscolhida(opcao,matricula);

            if(pc != null){
                cliente.comprar(pc);
                System.out.println("PC adicionado ao carrinho!");
            }

        }
        cliente.resumoCompra();
        ProcessarPedido.exibirTotal(cliente.calculaTotalCompra());
        entrada.close();
    }
}
