# Projeto_POO

Nome: Rander Augusto Dias Lemos
Curso: Engenharia de Software
Matricula: 639

Foi utilizado IA? - Sim
IA utilizada: Gemini

Abaixo os prompts utilizados:

- Estou começando um projeto de POO, mas estou na duvida para utilizar pacotes, poderia me ajudar?

<img width="512" height="329" alt="image" src="https://github.com/user-attachments/assets/4547fef9-eaac-4584-aa36-50f62412a7dc" />
- Nesse caso, nao quero que vc faça o codigo, mas poderia me falar como saber qual pacote criar, o nome da main e etc?

- -na foto temos alguns losangos em aberto e fechados(agregação e composição). tambem temos alguns asteriscos, poderia me informar o que é cada um, por favor?

- mas eu preciso colocar em tudo, tipo, se fosse um projeto real eu erraria se nao colocasse por exemplo nas variaveis

- Como utilizo composição e agregação mesmo?

- quando sei que preciso usar um construtor?

- o ideal seria criar um coinstrutor para cada agregação ou um somente para o Computador?

- nesse nao preciso colocar quais atributos do hardware basico vou utilizar?

- mas calma, vou te fornecer o arquivo para me ajudar melhor. Mas como sei a quantidade que vou colocar no array?

*ARQUIVO DO TRABALHO*
- segue arquivo

- mas o construtor do computador vai ser do computador no geral, ai coloco todas as informações de uma vez tanto do SO como do HB, ou faço um para o HB e outro para o SO?

- mas ó, como ja sei que o HB vai ter 3 coisas, porque eu ja nao deixo o array com esse tamanho?

- posso deixar a linha 8 do jeuito que esta entao?

<img width="512" height="333" alt="image" src="https://github.com/user-attachments/assets/fad967a0-adf7-4627-8486-d30c740bd4d9" />
- pq as linhas estao com erro sendo que o tipo que elas tem que receber no 'tipoSO' é int?

- Coloquei as opçoes dentro de computador, pois faz mais sentido para POO do que deixar na main, mas pq está dando erro?

- com o projeto em maos, poderia fazê-lo para eu ver como ficaria, por favor?

- Tenho algumas duvidas



1° - Para que serve: for (HardwareBasico h : hb)



2° -  // Método para preencher o array de hardware (posições 0, 1 e 2)

    public void addHardware(int i, String nome, float cap) {

        if (i >= 0 && i < hb.length) {

            this.hb[i] = new HardwareBasico(nome, cap);

        }

    }

Pq estou usando If ao inves de for?



3° - switch (opcao) {

                case 1:

                    pc = new Computador("Apple", 1300 + matricula, "macOS", 64);

                    pc.addHardware(0, "Pentium Core i3", 2200);

                    pc.addHardware(1, "RAM", 8);

                    pc.addHardware(2, "HD", 500);

                    pc.addMemoriaUSB(new MemoriaUSB("Pendrive", 16));

                    break;

                case 2:

                    pc = new Computador("Samsung", 2200 + matricula, "Windows", 64);

                    pc.addHardware(0, "Pentium Core i5", 3370);

                    pc.addHardware(1, "RAM", 16);

                    pc.addHardware(2, "HD", 1000);

                    pc.addMemoriaUSB(new MemoriaUSB("Pendrive", 32));

                    break;

                case 3:

                    pc = new Computador("Dell", 4800 + matricula, "Linux", 64);

                    pc.addHardware(0, "Pentium Core i7", 4500);

                    pc.addHardware(1, "RAM", 32);

                    pc.addHardware(2, "HD", 2000);

                    pc.addMemoriaUSB(new MemoriaUS

- Pode conferir se a alteração que eu fiz está correta?

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

            Computador.opcoesPromo(opcao, matricula);

            opcao = entrada.nextInt();

            Computador pc = null;

            Computador.opcaoEscolhida(opcao,matricula,pc);
            
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

package br.inatel.cdg.compraPC;

public class Computador {

    private String marca;
    private float preco;
    private SistemaOperacional so;
    private HardwareBasico hb[] = new HardwareBasico[3];
    private MemoriaUSB musb;

    public Computador(String marca, float preco, String nomeSO, int tipoSO){

        this.marca = marca;
        this.preco = preco;
        this.so = new SistemaOperacional(nomeSO,tipoSO);

    }

    public void mostraPCConfigs(){

        System.out.println("Marca: " + marca);
        System.out.println("Sistema Operacional: " + so.getNome() + "(" + so.getTipo() + " bits)");

        for (HardwareBasico h : hb){
            if (h != null){
                System.out.println("- " + h.getNome() + " : " + h.getCapacidade());
            }
        }
        if (musb != null){
            System.out.println("Acompanha um " + musb.getNome() + " com capacidade de " + musb.getCapacidade() + " Gb");
        }
        System.out.println("Preço total:R$ " + preco);

    }

    public void addMemoriaUSB(MemoriaUSB musb){
        this.musb = musb;
    }

    public float getPreco() {
        return preco;
    }

    public void addHardware(int i, String nome, float capacidade){
        if (i >= 0 && i < hb.length) {
            this.hb[i] = new HardwareBasico(nome, capacidade);
        }
    }
    public static void opcoesPromo(int opcao, int matricula){


        if(opcao == -1){
            System.out.println("Confira as promocoes disponiveis para voce: ");
            System.out.println("[1] primeira promo: ");
            System.out.println("- Marca: Apple");
            System.out.println("- Preço: " + matricula);
            System.out.println("- Pentium Core i3 (2200 Mhz)");
            System.out.println("- 8 Gb de RAM");
            System.out.println("- 500 Gb de HD");
            System.out.println("- Sistema Operacional: macOS Sequoia (64)");
            System.out.println("-----------------------------------------------------");
            System.out.println("[2] primeira promo: ");
            System.out.println("- Marca: Samsung");
            System.out.println("- Preço: " + (1234 + matricula));
            System.out.println("- Pentium Core i5 (3370 Mhz)");
            System.out.println("- 16 Gb de RAM");
            System.out.println("- 1 Tb de HD");
            System.out.println("- Sistema Operacional: Windows 8 (64)");
            System.out.println("-----------------------------------------------------");
            System.out.println("[3] primeira promo: ");
            System.out.println("- Marca: Dell");
            System.out.println("- Preço: " + (5678 + matricula));
            System.out.println("- Pentium Core i7 (4500 Mhz)");
            System.out.println("- 32 Gb de RAM");
            System.out.println("- 2 Tb de HD");
            System.out.println("- Sistema Operacional: Windows 10 (64)");
            System.out.println("-----------------------------------------------------");
            System.out.println("[0] caso queira sair");
            System.out.println("Qual opcao deseja selecionar?: ");
        }else{
            System.out.println("Deseja selecionar mais alguma opcao?");
            System.out.println("[1] primeira promo");
            System.out.println("[2] primeira promo");
            System.out.println("[3] primeira promo");
            System.out.println("[0] caso queira sair");
        }

    }

    public static void opcaoEscolhida(int opcao, int matricula, Computador pc){
        switch (opcao){

            case 1:
                pc = new Computador("Apple", matricula, "macOS Sequoia", 64);
                pc.addHardware(0, "Pentium Core i3", 2200);
                pc.addHardware(1, "RAM", 8);
                pc.addHardware(2, "HD", 500);
                pc.addMemoriaUSB(new MemoriaUSB("Pendrive", 16));
                break;
            case 2:
                pc = new Computador("Samsung", 1234 + matricula, "Windows 8", 64);
                pc.addHardware(0, "Pentium Core i5", 3370);
                pc.addHardware(1, "RAM", 16);
                pc.addHardware(2, "HD", 1000);
                pc.addMemoriaUSB(new MemoriaUSB("Pendrive", 32));
                break;
            case 3:
                pc = new Computador("Dell", 5678 + matricula, "Windows 10", 64);
                pc.addHardware(0, "Pentium Core i7", 4500);
                pc.addHardware(1, "RAM", 32);
                pc.addHardware(2, "HD", 2000);
                pc.addMemoriaUSB(new MemoriaUSB("HD Externo", 1000));
                break;
        }
    }
}

- E agora?

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
            

            Computador.opcaoEscolhida(opcao,matricula,pc);
            
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

- pq colocou null?

- mas pq ele estava falando para inicializar? o inicializar nao seria colocar new Computador?
