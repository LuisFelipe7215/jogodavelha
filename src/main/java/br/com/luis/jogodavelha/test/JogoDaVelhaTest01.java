package br.com.luis.jogodavelha.test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class JogoDaVelhaTest01 {
    private static char[][] tabuleiro = new char[3][3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        iniciaJogo();
        char simboloJogador = simboloJogador();

        boolean fimDoJogo = false;
        int linha, coluna;
        int jogador = 1;
        while (!fimDoJogo) {
            jogador = jogador % 2 == 0 ? 2 : 1;
            System.out.printf("Vez do jogador %d com o símbolo '%c'%n", jogador++, simboloJogador);
            System.out.printf("Insira a posição da linha do %c (1 até 3)%n", simboloJogador);
            linha = sc.nextInt() - 1;
            System.out.printf("Insira a posição da coluna do %c (1 até 3)%n", simboloJogador);
            coluna = sc.nextInt() - 1;

            adiciona(linha, coluna, simboloJogador);

            simboloJogador = simboloJogador == 'X' ? 'O' : 'X';
        }
    }

    private static void adiciona(int linha, int coluna, char simboloJogador) {
        tabuleiro[linha][coluna] = simboloJogador;
        imprime();
    }

    private static char simboloJogador() {
        System.out.println("O primeiro símbolo será sorteado aleatoriamente (X ou O)");
        char simbolo = ThreadLocalRandom.current().nextInt(0, 2) == 1 ? 'X' : 'O';
        System.out.printf("O símbolo do jogador 1 é o %c%n", simbolo);
        System.out.printf("O símbolo do jogador 2 é o %c%n", simbolo == 'X' ? 'O' : 'X');

        return simbolo;
    }


    private static void iniciaJogo() {
        for (char[] chars : tabuleiro) {
            Arrays.fill(chars, ' ');
        }
    }

    private static void imprime() {
        for (char[] simbolos : tabuleiro) {
            for (char simbolo : simbolos) {
                System.out.printf("|%c|", simbolo);
            }
            System.out.println();
        }
    }


}
