package br.com.luis.jogodavelha.service;

import br.com.luis.jogodavelha.domain.JogoDaVelha;

public class JogoDaVelhaService {

    private final JogoDaVelha jogoDaVelha = new JogoDaVelha();

    public void opcaoJogador(int opcao) {
        jogoDaVelha.setPecaJogador1(opcao == 1 ? 'X' : 'O');
        jogoDaVelha.setPecaJogador2(jogoDaVelha.getPecaJogador1() == 'X' ? 'O' : 'X');
        System.out.println("A peça do jogador 1 é " + jogoDaVelha.getPecaJogador1());
        System.out.println("A peça do jogador 2 é " + jogoDaVelha.getPecaJogador2());
    }

}
