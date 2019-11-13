package br.edu.ifsul.control;

import br.edu.ifsul.model.*;
import sun.plugin2.util.AppletEnumeration;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;


public class Main {
    public static int c=0;
    public static void main(String[] args) {
        //a
        System.out.println("--------A-------");
        Tanque t1 = new Tanque(1,10,false);
        Tanque t2 = new Tanque(2, 10, false);
        Tanque t3 = new Tanque(3,10,false);


        Navio n1 = new Navio(4,100,false);
        Navio n2 = new Navio(5,100,false);
        Navio n3 = new Navio(6,100,false);

        Aviao a1 = new Aviao(7,50,false);
        Aviao a2 = new Aviao(8,50,false);
        Aviao a3 = new Aviao(9,50,false);

        //b
        System.out.println("--------B------");
        List<Personagem> personagens = new ArrayList<>();

        personagens.add(t1);
        personagens.add(t2);
        personagens.add(t3);
        personagens.add(n1);
        personagens.add(n2);
        personagens.add(n3);
        personagens.add(a1);
        personagens.add(a2);
        personagens.add(a3);

        System.out.println("Lista Personagens"+personagens);

       //c
        System.out.println("-------C-------");
        personagens.addAll(n1.gerar(3,personagens.size()));
        personagens.addAll(a1.gerar(3, personagens.size()));
        System.out.println("-----------Lista de personagens: --------------" + personagens);

        //d
        System.out.println("------D------");
        personagens.forEach(p->{
            if(p.getId()>9){
                p.setAbatido(true);
            }
            c += p.getPontuacao();
        });
        System.out.println(personagens);
        System.out.println("pontuação acumulada: "+c);

        //e
        System.out.println("------E------");
        personagens.forEach(p->{
            if(p instanceof ArmamentoVip){
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
            }

        });

        System.out.println("---------------Personagens + pontuação do com armamento VIP" + personagens);

        //f
        System.out.println("------F-------");
        c=0;
        personagens.forEach(m->{

            if(m instanceof Navio && m.isAbatido() == false){
                m.setAbatido(true);
                c += m.getPontuacao();
            }
            if(m instanceof Aviao && m.isAbatido() == false){
                m.setAbatido(true);
                c += m.getPontuacao();
            }

        });

        System.out.println("-------------LISTA AVIÕES E NAVIOS ABATIDOS ---------------"+ personagens);
        System.out.println("------pontuação acumulada: -----"+ c);

        //g

        System.out.println("-----G-------");
        personagens.sort(Comparator.comparingInt(Personagem::getPontuacao).reversed());

        /*personagens.sort((p1,p2)->{
            if(p1.getPontuacao()<p2.getPontuacao()){
                return 1;
            }
            if(p1.getPontuacao()>p2.getPontuacao()){
                return -1;
            }
            else{
                return 0;
            }
        });*/

        System.out.println("------------Lista por pontuação: -------------"+ personagens);

        //h
        System.out.println("------H--------");
        personagens.forEach(p->{
            if(p.isAbatido()){
                System.out.println(p);
            }
        });

        //i
        System.out.println("-------I---------");
        personagens.forEach(personagem -> {
            if(personagem instanceof Aviao){
                System.out.println(personagem);
            }
        });

        //j
        System.out.println("-------J--------");
        personagens.forEach(p->{
            if(p instanceof ArmamentoVip){
                if(((ArmamentoVip) p).getTipo() != null){
                    System.out.println(p);
                }
            }
        });


    }
}
