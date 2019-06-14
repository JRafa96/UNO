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

	private int indexProximoJogador() {
		int indexJogador=jogadorAtual;
		int nextI = sentido.ordinal();
		if (indexJogador + nextI < 0) {
			indexJogador = jogadores.size() - 1;
		} else if (indexJogador + nextI >= jogadores.size()) {
			indexJogador = 0;
		} else {
			indexJogador += nextI;

		}
		return indexJogador;
	}

	private Jogador proximoJogador() {
		jogadorAtual=indexProximoJogador();
		Jogador jogador=jogadores.get(jogadorAtual);
		return jogador;
	}
	
	public void jogar() {
		começarJogo();
		Jogador jAtual;
		Carta carta;
		do {
			jAtual = proximoJogador();
			jAtual.verificarJogaveis(estado);
			while (jAtual.getJogaveis().size() <= 0) {
				jAtual.receberCarta(baralho.tirarCarta());
				jAtual.verificarJogaveis(estado);
			}

			carta = jAtual.jogarCarta(estado);
			if (!(carta instanceof CartaNumero)) {
				try {
					((CartaEspecial) carta).açao();
				} catch (Mais_4 m4) {
					System.out.println("mais4");
				} catch (Mais_2 m2) {
					// TODO Auto-generated catch block
					System.out.println("mais4");
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			pilha.add(carta);
			System.out.println(jAtual.getNome() + " jogou " + pilha.get(0).toString());
		} while (jAtual.getMao().size() == 0);
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
		pilha = new ArrayList<Carta>();
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
