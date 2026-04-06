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

    public static Computador opcaoEscolhida(int opcao, int matricula){
        Computador tempPC = null;
        switch (opcao){
            case 1:
                tempPC = new Computador("Apple", matricula, "macOS Sequoia", 64);
                tempPC.addHardware(0, "Pentium Core i3", 2200);
                tempPC.addHardware(1, "RAM", 8);
                tempPC.addHardware(2, "HD", 500);
                tempPC.addMemoriaUSB(new MemoriaUSB("Pendrive", 16));
                break;
            case 2:
                tempPC = new Computador("Samsung", 1234 + matricula, "Windows 8", 64);
                tempPC.addHardware(0, "Pentium Core i5", 3370);
                tempPC.addHardware(1, "RAM", 16);
                tempPC.addHardware(2, "HD", 1000);
                tempPC.addMemoriaUSB(new MemoriaUSB("Pendrive", 32));
                break;
            case 3:
                tempPC = new Computador("Dell", 5678 + matricula, "Windows 10", 64);
                tempPC.addHardware(0, "Pentium Core i7", 4500);
                tempPC.addHardware(1, "RAM", 32);
                tempPC.addHardware(2, "HD", 2000);
                tempPC.addMemoriaUSB(new MemoriaUSB("HD Externo", 1000));
                break;
        }
        return tempPC;
    }
}
