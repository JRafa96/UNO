package jogo;

import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {
	ArrayList<Jogador> jogadores;
	ArrayList<Carta> pilha;
	Baralho baralho;
	Estado estado;
	Sentido sentido;
	int jogadorAtual;

	public Jogador proximoJogador() {
		Jogador jogador;
		int nextI = sentido.ordinal();
		if (jogadorAtual + nextI < 0) {
			System.out.println("recuar para o ultimo");
			jogadorAtual = jogadores.size() - 1;
		} else if (jogadorAtual + nextI >= jogadores.size()) {
			System.out.println("avançar para o primeiro");
			jogadorAtual = 0;
		} else {
			jogadorAtual += nextI;
			System.out.println("avançar normal");
			
		}
		System.out.println("O Jogador atual é "+jogadorAtual);
		if (jogadores.get(jogadorAtual).isProibido()) {
			System.out.println("Saltar Jogador " + jogadores.get(jogadorAtual).isProibido());
			jogadores.get(jogadorAtual).setProibido(false);
			jogador = proximoJogador();
		}
		jogador = jogadores.get(jogadorAtual);
		return jogador;
	}

	public void jogar() {
		começarJogo();
		Jogador jAtual;
		int i = 0;
		do {
			i++;
			jAtual = proximoJogador();
			pilha.add(jAtual.jogarCarta(estado));
			System.out.println(jAtual.getNome()+" jogou "+pilha.get(0).toString());
		} while (i < 10);
	}

	private void começarJogo() {
		sentido = Sentido.DIREITA;
		baralho = new Baralho();
		Scanner scan = new Scanner(System.in);
		int quantos;
		do {
			System.out.println("Quantos jogadores vão jogar ?");
			quantos = scan.nextInt();
			if (quantos <= 1) {
				System.out.println("O numero de jogadores tem de ser maior que 1");
			}
		} while (quantos <= 1);
		jogadores = new ArrayList<>();
		String nome;
		Jogador jogador;
		for (int i = 0; i < quantos; i++) {
			System.out.println("Introduza o nome do Jogador " + (i + 1));
			nome = scan.next();
			jogador = new Jogador(nome);
			jogador.receberCartas(baralho.tirarCartas(7));
			jogadores.add(jogador);
		}
		ArrayList<Carta> pilha = new ArrayList<Carta>();
		pilha.add(baralho.tirarCarta());
		estado = new Estado(jogadores.get(jogadorAtual), pilha.get(pilha.size() - 1), sentido, baralho);
		System.out.println(estado.toString());
		jogadorAtual = -1;
	}

	public Carta distribuirCarta() {
		return baralho.tirarCarta();
	}

	public ArrayList<Carta> distribuirCartas(int quantas) {
		ArrayList<Carta> tiradas = new ArrayList<Carta>();
		for (int i = 0; i < quantas; i++) {
			tiradas.add(distribuirCarta());
		}
		return tiradas;
	}

}
