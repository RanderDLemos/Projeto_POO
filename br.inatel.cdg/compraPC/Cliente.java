package br.inatel.cdg.compraPC;

public class Cliente {

    private String nome;
    private String cpf;
    private Computador[] carrinho = new Computador[10];

    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public float calculaTotalCompra(){
        float total = 0;
        for(Computador pc : carrinho){
            if(pc != null){
                total += pc.getPreco();
            }
        }

        return total;
    }

    public void comprar(Computador pc){
        for(int i = 0; i < carrinho.length; i++){
            if(carrinho[i] == null){
                carrinho[i] = pc;
                break;
            }
        }
    }

    public void resumoCompra(){
        System.out.println("Resumo da compra do cliente: " + nome + ", com o CPF: " + cpf + ".");
        for(Computador pc : carrinho){
            if(pc != null){
                pc.mostraPCConfigs();
            }
        }
    }

}
