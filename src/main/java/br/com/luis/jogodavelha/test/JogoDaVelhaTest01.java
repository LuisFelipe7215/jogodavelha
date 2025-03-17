package br.com.luis.jogodavelha.test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class JogoDaVelhaTest01 {
    private static final char[][] tabuleiro = new char[3][3];
    public static final int ZERO = 0;
    public static final int UM = 1;
    public static final int DOIS = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        iniciaJogo();
        char simboloJogador = simboloJogador();

        boolean jogadaCerta = false;
        int jogador = UM;
        while (!fimDoJogo(jogador, simboloJogador)) {

            if (jogadaCerta) {
                jogador++;
                jogador = jogador % DOIS == ZERO ? DOIS : UM;
                simboloJogador = simboloJogador == 'X' ? 'O' : 'X';
            }

            System.out.printf("Vez do jogador %d com o símbolo '%c'%n", jogador, simboloJogador);

            jogadaCerta = menu(simboloJogador, sc, jogadaCerta);
        }

        sc.close();
    }

    private static boolean menu(char simboloJogador, Scanner sc, boolean jogadaCerta) {
        int coluna;
        int linha;
        try {
            System.out.println("Insira a posição da linha (1 até 3) onde será colocado o símbolo");
            linha = sc.nextInt() - UM;

            System.out.println("Insira a posição da coluna (1 até 3) onde será colocado o símbolo");
            coluna = sc.nextInt() - UM;

            jogadaCerta = adiciona(linha, coluna, simboloJogador);
        } catch (Exception e) {
            System.out.println("Insira uma posição que seja um número de 1 a 3.");
            sc.nextLine();
        }
        return jogadaCerta;
    }

    private static boolean fimDoJogo(int jogador, char simboloJogador) {
        if (vencedorLinhaReta(simboloJogador) || vencedorColunaReta(simboloJogador) || vencedorDiagonal(simboloJogador)) {
            System.out.printf("O jogador %d venceu a partida!%n", jogador);
            System.out.println("Fim de jogo!");
            return true;
        } else if (empate()) {
            System.out.println("O jogo deu empate!");
            System.out.println("Fim de jogo!");
            return true;
        }
        return false;
    }

    private static boolean vencedorLinhaReta(char simboloJogador) {
        return tabuleiro[ZERO][ZERO] == simboloJogador && tabuleiro[ZERO][UM] == simboloJogador && tabuleiro[ZERO][DOIS] == simboloJogador ||
                tabuleiro[UM][ZERO] == simboloJogador && tabuleiro[UM][UM] == simboloJogador && tabuleiro[UM][DOIS] == simboloJogador ||
                tabuleiro[DOIS][ZERO] == simboloJogador && tabuleiro[DOIS][UM] == simboloJogador && tabuleiro[DOIS][DOIS] == simboloJogador;
    }

    private static boolean vencedorColunaReta(char simboloJogador) {
        return tabuleiro[ZERO][ZERO] == simboloJogador && tabuleiro[UM][ZERO] == simboloJogador && tabuleiro[DOIS][ZERO] == simboloJogador ||
                tabuleiro[ZERO][UM] == simboloJogador && tabuleiro[UM][UM] == simboloJogador && tabuleiro[DOIS][UM] == simboloJogador ||
                tabuleiro[ZERO][DOIS] == simboloJogador && tabuleiro[UM][DOIS] == simboloJogador && tabuleiro[DOIS][DOIS] == simboloJogador;
    }

    private static boolean vencedorDiagonal(char simboloJogador) {
        return tabuleiro[ZERO][ZERO] == simboloJogador && tabuleiro[UM][UM] == simboloJogador && tabuleiro[DOIS][DOIS] == simboloJogador ||
                tabuleiro[ZERO][DOIS] == simboloJogador && tabuleiro[UM][UM] == simboloJogador && tabuleiro[DOIS][ZERO] == simboloJogador;
    }

    private static boolean empate() {
        for (char[] chars : tabuleiro) {
            for (char c : chars) {
                if (c == ' ') {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean adiciona(int linha, int coluna, char simboloJogador) {
        if (!(tabuleiro[linha][coluna] == 'X' || tabuleiro[linha][coluna] == 'O')) {
            tabuleiro[linha][coluna] = simboloJogador;
            imprime();
            return true;
        }
        System.out.println("----------------------------------------");
        System.out.printf("A posição selecionada já está marcada com simbolo '%c'%n", tabuleiro[linha][coluna]);
        imprime();
        System.out.println("Entre com outra linha ou coluna para continuar o jogo");
        System.out.println("----------------------------------------");
        return false;
    }

    private static char simboloJogador() {
        System.out.println("----------------------------------------");
        System.out.println("O simbolos dos jogadores serão aleatórios (X ou O)");
        char simbolo = ThreadLocalRandom.current().nextInt(ZERO, DOIS) == UM ? 'X' : 'O';
        System.out.printf("O símbolo escolhido para o jogador 1 é o %c%n", simbolo);
        System.out.printf("O símbolo escolhido para o jogador 2 é o %c%n", simbolo == 'X' ? 'O' : 'X');
        System.out.println("----------------------------------------");

        return simbolo;
    }


    private static void iniciaJogo() {
        for (char[] chars : tabuleiro) {
            Arrays.fill(chars, ' ');
        }
    }

    private static void imprime() {
        int pos = 1;
        System.out.println("   1  2  3");
        for (char[] simbolos : tabuleiro) {
            System.out.printf("%d ", pos++);
            for (char simbolo : simbolos) {
                System.out.printf("|%c|", simbolo);
            }
            System.out.println();
        }
    }


}
