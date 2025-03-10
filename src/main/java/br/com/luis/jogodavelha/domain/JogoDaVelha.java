package br.com.luis.jogodavelha.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JogoDaVelha {
    private char[][] tabuleiro = new char[3][3];
    private char pecaJogador1;
    private char pecaJogador2;
}
