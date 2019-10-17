package br.edu.ifsul.model;

import java.util.ArrayList;
import java.util.List;


public class Navio extends Personagem implements ArmamentoVip{
    private int quantidade;
    private String tipo;

    public Navio() {
    }
    public Navio(int id){}

    public Navio(int id, int pontuacao, boolean abatido) {
        super(id, pontuacao, abatido);
    }

    @Override
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
    public List<Personagem> gerar(int quantidade, int size) {
        List<Personagem> navios = new ArrayList<>();
        int count = size;
        for(int i = 0; i< quantidade; i++){
            Navio navio = new Navio(++count, 50, false);
            navios.add(navio);
        }
        return navios;
    }

    @Override
    public int anexar(int quantidade, String tipo) {
        this.quantidade = quantidade;
        this.tipo = tipo;
        return this.quantidade;
    }

    @Override
    public String toString() {
        return "\nNavio{" +
                "quantidade=" + quantidade +
                ", tipo='" + tipo + '\'' +
                ", id=" + id +
                ", pontuacao=" + pontuacao +
                ", abatido=" + abatido +
                '}';
    }
}
