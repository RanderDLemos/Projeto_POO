package br.inatel.cdg.compraPC;

public class SistemaOperacional {

    String nome;
    int tipo;

    public SistemaOperacional(String nome, int tipo) {

        this.nome = nome;
        this.tipo = tipo;

    }

    public String getNome() {
        return nome;
    }

    public int getTipo() {
        return tipo;
    }
}
