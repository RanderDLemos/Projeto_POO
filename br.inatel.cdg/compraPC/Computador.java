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
}
