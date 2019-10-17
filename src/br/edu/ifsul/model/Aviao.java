package br.edu.ifsul.model;

import java.util.ArrayList;
import java.util.List;

public class Aviao extends Personagem implements ArmamentoVip{
    private int quantidade;
    private String tipo;

    public Aviao() {
    }

    public Aviao(int id, int pontuacao, boolean abatido) {
        super(id, pontuacao, abatido);
    }

    public Aviao(int i) {
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    @Override
    public List<Personagem> gerar(int quantidade, int size){
        List<Personagem> avioes = new ArrayList<>();
        int count = size;
        for(int i = 0; i< quantidade; i++){
            Aviao aviao = new Aviao(++count, 50, false);
            avioes.add(aviao);
        }
        return avioes;
    }

    @Override
    public int anexar(int quantidade, String tipo) {
        this.quantidade = quantidade;
        this.tipo = tipo;
        return this.quantidade;
    }

    @Override
    public String toString() {
        return "\nAviao{" +
                "quantidade=" + quantidade +
                ", tipo='" + tipo + '\'' +
                ", id=" + id +
                ", pontuacao=" + pontuacao +
                ", abatido=" + abatido +
                '}';
    }
}
