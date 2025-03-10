package br.com.luis.jogodavelha.test;

import br.com.luis.jogodavelha.service.JogoDaVelhaService;

import java.util.Scanner;

public class JogoDaVelhaTest01 {

    private static JogoDaVelhaService jogoDaVelhaService = new JogoDaVelhaService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        opcaoJogador(sc);

    }

    private static void opcaoJogador(Scanner sc) {
        System.out.println("Escolha uma opção de letra para o jogador 1:");
        System.out.println("1. X");
        System.out.println("2. O");
        jogoDaVelhaService.opcaoJogador(sc.nextInt());
    }
}
