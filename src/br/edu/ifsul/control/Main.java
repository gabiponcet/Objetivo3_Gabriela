package br.edu.ifsul.control;

import br.edu.ifsul.model.*;
import sun.plugin2.util.AppletEnumeration;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        Tanque t1 = new Tanque(1,10,false);
        Tanque t2 = new Tanque(2, 5, true);
        Tanque t3 = new Tanque(3,6,false);


        Navio n1 = new Navio(4,18,false);
        Navio n2 = new Navio(5,2,true);
        Navio n3 = new Navio(6,33,false);

        Aviao a1 = new Aviao(7,34,false);
        Aviao a2 = new Aviao(8,2,true);
        Aviao a3 = new Aviao(9,0,true);

        List<Personagem> personagens = new ArrayList<>();
        List<ArmamentoVip> armas = new ArrayList<>();

        personagens.add(t1);
        personagens.add(t2);
        personagens.add(t3);
        personagens.add(n1);
        personagens.add(n2);
        personagens.add(n3);
        personagens.add(a1);
        personagens.add(a2);
        personagens.add(a3);

        armas.add(n1);
        armas.add(n2);
        armas.add(n3);
        armas.add(a1);
        armas.add(a2);
        armas.add(a3);

        personagens.addAll(n1.gerar(3,personagens.size()));
        personagens.addAll(a1.gerar(3, personagens.size()));


        System.out.println("-----------Lista de personagens: --------------" + personagens);

        System.out.println("--------------Armamento VIP: ----------" +armas);


        personagens.forEach(p->{
            if(p instanceof Navio){
                if(p.isAbatido() == false){
                    ((Navio) p).anexar(1,"míssil teleguiado");
                    p.setPontuacao((p.getPontuacao()*2));
                }
            }
            if(p instanceof Aviao){
                if(p.isAbatido() == false){
                    ((Aviao)p).anexar(1, "míssil teleguiado");
                    p.setPontuacao(p.getPontuacao()*2);
                }
            }
        });

        System.out.println("---------------Personagens + pontuação do com armamento VIP" + personagens);

        AtomicInteger c = new AtomicInteger();
        personagens.forEach(m->{
            if(m instanceof Navio && m.isAbatido() == false){
                m.setAbatido(true);
            }
            if(m instanceof Aviao && m.isAbatido() == false){
                m.setAbatido(true);
            }
            c.addAndGet(m.getPontuacao());
        });

        System.out.println("-------------LISTA AVIÕES E NAVIOS ABATIDOS ---------------"+ personagens);
        System.out.println("------pontuação acumulada: -----"+ c);

        List<Personagem> listaPontuacao = personagens;

        listaPontuacao.sort((p1,p2)->{
            if(p1.getPontuacao()<p2.getPontuacao()){
                return 1;
            }
            if(p1.getPontuacao()>p2.getPontuacao()){
                return -1;
            }
            else{
                return 0;
            }
        });

        System.out.println("------------Lista por pontuação: -------------"+ listaPontuacao);

        System.out.println("-----------Abatidos: ------------");
        List<Personagem> listaAbatidos = listaPontuacao;

        int size = listaAbatidos.size();

        for(int i =0; i< size; i++){
            if(listaAbatidos.get(i).isAbatido()){
                System.out.println(listaAbatidos.get(i));
            }
        }

        System.out.println("-----------------Lista avião, ordem pontuação decrescente--------- ");
        List<Personagem> listaDecrescente = personagens;

        listaDecrescente.sort((p1,p2)->{
            if(p1.getPontuacao()<p2.getPontuacao()){
                return 1;
            }
            if(p1.getPontuacao()>p2.getPontuacao()){
                return -1;
            }
            else{
                return 0;
            }
        });

        listaDecrescente.forEach(personagem -> {
            if(personagem instanceof Aviao){
                System.out.println(personagem);
            }
        });

        List<ArmamentoVip> listArmamentoDecrescente = armas;

        listArmamentoDecrescente.sort((o1,o2)-> {
                    if (o1 instanceof Navio || o1 instanceof Aviao && o2 instanceof Navio || o2 instanceof Aviao) {
                        if (((Personagem) o1).getPontuacao() < ((Personagem) o2).getPontuacao()) {
                            return 1;
                        }
                        if (((Personagem) o1).getPontuacao() > ((Personagem) o2).getPontuacao()) {
                            return -1;
                        }
                        else{
                            return 0;
                        }
                    }
            return 0;
        });

        listArmamentoDecrescente.forEach(o->{
            if (o.getQuantidade() > 0) {
                if(o instanceof Navio || o instanceof  Aviao){
                    System.out.println(o);
                }
            }
        });




    }
}
