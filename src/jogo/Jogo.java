package jogo;

import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {
	ArrayList<Jogador> jogadores;
	ArrayList<Carta> pilha;
	Baralho baralho;
	Estado estado;
	Sentido sentido;
	int indiceJogadorAtual;

	private int indiceProximoJogador() {
		int indexJogador=indiceJogadorAtual;
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
		indiceJogadorAtual=indiceProximoJogador();
		Jogador jogador=jogadores.get(indiceJogadorAtual);
		return jogador;
	}
	
	public void jogar() {
		começarJogo();
		Jogador jogadorAtual;
		Carta carta;
		do {
			jogadorAtual = proximoJogador();
			jogadorAtual.verificarJogaveis(estado);
			while (jogadorAtual.getJogaveis().size() <= 0) {
				jogadorAtual.receberCarta(baralho.tirarCarta());
				jogadorAtual.verificarJogaveis(estado);
			}
			carta = jogadorAtual.jogarCarta(estado);
			pilha.add(carta);
			estado.setCarta(carta);
			System.out.println(jogadorAtual.getNome() + " jogou " + pilha.get(0).toString());
			if (!(carta instanceof CartaNumero)) {
				Jogador proximoJogador=jogadores.get(indiceProximoJogador());
				try {
					((CartaEspecial) carta).açao();
				} catch (Mais_4 m4) {
					mandarBuscar(jogadorAtual, proximoJogador, 4);
				} catch (Mais_2 m2) {
					mandarBuscar(jogadorAtual, proximoJogador, 2);
				} catch (Proibido proibir) {
					mandarBuscar(jogadorAtual, proximoJogador, 2);
				} catch (Inverter_Sentido inverter_Sentido) {
					trocarSentido();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} while (jogadorAtual.getMao().size() >= 0&& jogadorAtual.getJogaveis().size() >= 0);
		System.out.println("O jogo acabou!!");
	}

	private void mandarBuscar(Jogador jogadorAtual, Jogador proximoJogador, int quantas) {
		proximoJogador.receberCartas(baralho.tirarCartas(quantas));
		proibirProximo();
		System.out.println("O jogador " + jogadorAtual.getNome() + " mandou o jogador " + proximoJogador.getNome()
				+ " ir buscar 4 cartas");
	}

	private void proibirProximo() {
		Jogador proximoJogador = jogadores.get(indiceProximoJogador());
		proximoJogador.setProibido(true);
		System.out.println("O jogador "+jogadorAtual.getNome()+" mandou o jogador "+proximoJogador.getNome()+" ir buscar 4 cartas");
	}

	private void trocarSentido() {
		if(sentido==Sentido.DIREITA) {
			sentido=Sentido.ESQUERDA;
		}else {
			sentido=Sentido.DIREITA;
		}
	}
	
	private void começarJogo() {
		sentido = Sentido.DIREITA;
		baralho = new Baralho();
		Scanner scan = new Scanner(System.in);
		int quantos;
		do {
			System.out.println("Quantos jogadores v�o jogar ?");
			quantos = scan.nextInt();
			if (quantos <= 1 || quantos >10) {
				System.out.println("O numero de jogadores tem de ser maior que 1 e menor que 10");
			}
		} while (quantos <= 1 || quantos >10);
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
		baralho.validarPrimeiraCarta();
		pilha = new ArrayList<Carta>();
		pilha.add(baralho.tirarCarta());
		estado = new Estado(jogadores.get(indiceJogadorAtual), pilha.get(pilha.size() - 1), sentido, baralho);
		System.out.println(estado.toString());
		indiceJogadorAtual = -1;
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
