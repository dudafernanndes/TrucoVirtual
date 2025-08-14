package com.example;

public class Jogo {
    protected Monte monte = new Monte();
    protected Jogador jogador = new Jogador();
    protected Computador computador = new Computador();

    public Jogo() {
        monte.embaralhar();
    }

    public Carta distribuirCartaParaJogador(Jogador jogador) {
        var carta = monte.virar();
        if (jogador.parou() == false){
            jogador.receberCarta(carta);
            return carta;
        }
        return null;
    }

    public boolean acabou(){
        var osDoisPararam = jogador.parou() && computador.parou();
        return osDoisPararam || estourou(jogador) || estourou(computador);
    }

    public String resultado(){
        if(estourou(jogador) && estourou(computador) || jogador.getPontos() == computador.getPontos()){
            return "Empatou";
        }
        if(estourou(computador) || jogador.getPontos() > computador.getPontos()){
            return "Você ganhou";
        }
        return "Você perdeu";
    }

    private boolean estourou(Jogador jogador){
        return jogador.getPontos() > 21;
    }
}