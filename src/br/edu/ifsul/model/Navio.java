package br.edu.ifsul.model;

import java.util.List;

public class Navio extends Personagem implements ArmamentoVip{

    public Navio() {
    }

    public Navio(int id, int pontuacao, boolean abatido) {
        super(id, pontuacao, abatido);
    }

    @Override
    public String toString() {
        return "Navio{" +
                "id=" + id +
                ", pontuacao=" + pontuacao +
                ", abatido=" + abatido +
                '}';
    }

    @Override
    public List<Personagem> gerar(int quantidade, int size) {
        return null;
    }

    @Override
    public int anexar(int quantidade, String tipo) {
        return 0;
    }
}
