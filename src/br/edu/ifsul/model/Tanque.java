package br.edu.ifsul.model;

import java.util.List;

public class Tanque extends Personagem {

    public Tanque() {
        super();
    }

    public Tanque(int id, int pontuacao, boolean abatido) {
        super(id, pontuacao, abatido);
    }

    @Override
    public String toString() {
        return "Tanque{" +
                "id=" + id +
                ", pontuacao=" + pontuacao +
                ", abatido=" + abatido +
                '}';
    }

    @Override
    public List<Personagem> gerar(int quantidade, int size) {
        return null;
    }
}
