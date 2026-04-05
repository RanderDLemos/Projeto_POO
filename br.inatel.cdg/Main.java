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

        int opcao = -1;
        while(opcao != 0){

            System.out.println("Confira as promocoes disponiveis para voce: ");
            System.out.println("[1] primeira promo: ");
            System.out.println("[2] primeira promo: ");
            System.out.println("[3] primeira promo: ");
            System.out.println("[0] caso queira sair");
            System.out.println("Qual opcao deseja selecionar?: ");
            opcao = entrada.nextInt();

            Computador pc = null;

            switch (opcao){

                case 1:
                    pc = new Computador("Apple", 1300 + matricula, "macOS Sequoia", 64);
                    pc.addHardware(0, "Pentium Core i3", 2200);
                    pc.addHardware(1, "RAM", 8);
                    pc.addHardware(2, "HD", 500);
                    pc.addMemoriaUSB(new MemoriaUSB("Pendrive", 16));
                    break;
                case 2:
                    pc = new Computador("Samsung", 2200 + matricula, "Windows 8", 64);
                    pc.addHardware(0, "Pentium Core i5", 3370);
                    pc.addHardware(1, "RAM", 16);
                    pc.addHardware(2, "HD", 1000);
                    pc.addMemoriaUSB(new MemoriaUSB("Pendrive", 32));
                    break;
                case 3:
                    pc = new Computador("Dell", 4800 + matricula, "Windows 10", 64);
                    pc.addHardware(0, "Pentium Core i7", 4500);
                    pc.addHardware(1, "RAM", 32);
                    pc.addHardware(2, "HD", 2000);
                    pc.addMemoriaUSB(new MemoriaUSB("HD Externo", 1000));
                    break;
            }
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
