package br.edu.ifsul.model;

import java.util.ArrayList;
import java.util.List;

public class Tanque extends Personagem {

    public Tanque() {
        super();
    }

    public Tanque(int id, int pontuacao, boolean abatido) {
        super(id, pontuacao, abatido);
    }

    public Tanque(int i) {
    }

    @Override
    public String toString() {
        return "\nTanque{" +
                "id=" + id +
                ", pontuacao=" + pontuacao +
                ", abatido=" + abatido +
                '}';
    }

    @Override
    public List<Personagem> gerar(int quantidade, int size) {
        List<Personagem> tanques = new ArrayList<>();
        int count = size;
        for(int i = 0; i< quantidade; i++){
            Tanque tanque = new Tanque(++count);
            tanques.add(tanque);
        }
        return tanques;
    }
}
