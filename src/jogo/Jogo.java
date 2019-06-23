package jogo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe que executa o jogo em si, quer seja trocar jogadores, dizer ao jogador para tirar cartas, 
 * @author Bernardo
 *
 */
public class Jogo {
	ArrayList<Jogador> jogadores;
	ArrayList<Carta> pilha;
	Baralho baralho;
	Estado estado;
	Sentido sentido;
	int indiceJogadorAtual;

	/**
	 * Construtor do jogo.
	 * <ul>
	 * <li>jogadores: cria um arraylist de jogadores.</li>
	 * <li>baralho: cria uma lista com todas as cartas do baralho.</li>
	 * <li>pilha: cria um arraylist com as cartas jogadas durante o jogo.</li>
	 * <li>sentido: define o sentido em que o jogo ocorre.</li>
	 * <li>indiceJogadorAtual: define qual é o jogador atual. </li>
	 * </ul>
	 */
	public Jogo() {
		jogadores = new ArrayList<>();
		baralho = new Baralho();
		pilha = new ArrayList<Carta>();
		sentido = Sentido.DIREITA;
		indiceJogadorAtual = 0;
	}

	/**
	 * Método que é chamado cada vez que um jogador joga, e verifica se o próximo jogador está proibido.
	 */
	private void avancarJogador() {
		indiceJogadorAtual = indiceProximoJogador();
		if (jogadores.get(indiceJogadorAtual).isProibido()) {
			jogadores.get(indiceJogadorAtual).setProibido(false);
			indiceJogadorAtual = indiceProximoJogador();
		}
	}

	/**
	 * Método que verifica o sentido atual do jogo e define qual será o próximo jogador a jogar. 
	 * @return
	 */
	private int indiceProximoJogador() {
		int indexJogador = indiceJogadorAtual;
		int nextI = sentido.getnSentido();
		if (indexJogador + nextI < 0) {
			return jogadores.size() - 1;
		} else if (indexJogador + nextI >= jogadores.size()) {
			return 0;
		} else {
			return indexJogador + nextI;

		}
	}

	/**
	 * Método que retorna o próximo jogador do arraylist jogadores.
	 * @return
	 */
	private Jogador proximoJogador() {
		indiceJogadorAtual = indiceProximoJogador();
		return jogadores.get(indiceJogadorAtual);
	}

	public void jogar() {
		começarJogo();
		Jogador jogadorAtual;
		Carta carta;
		do {
			avancarJogador();
			jogadorAtual = jogadores.get(indiceJogadorAtual);
			estado.setJogadorAtual(jogadorAtual);
			jogadorAtual.verificarJogaveis(estado);
			while (jogadorAtual.getJogaveis().size() <= 0) {
				jogadorAtual.receberCarta(distribuirCarta());
				jogadorAtual.verificarJogaveis(estado);
			}
			System.out.println(estado.toString());
			if (!(jogadorAtual.isProibido())) {

				carta = jogadorAtual.jogarCarta(estado);
				pilha.add(carta);
				System.out.println(jogadorAtual.getNome() + " jogou " + pilha.get(pilha.size() - 1).toString());
				if (!(carta instanceof CartaNumero)) {
					Jogador proximoJogador = jogadores.get(indiceProximoJogador());
					try {
						((CartaEspecial) carta).açao();
					} catch (Mais_4 m4) {
						mandarBuscar(jogadorAtual, proximoJogador, 4);
						mudarCor(m4.getCor());
					} catch (Mais_2 m2) {
						mandarBuscar(jogadorAtual, proximoJogador, 2);
					} catch (Proibido proibir) {
						proximoJogador();
					} catch (Inverter_Sentido inverter_Sentido) {
						trocarSentido();
					} catch (MudaCor mudaCor) {
						mudarCor(mudaCor.getCor());
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
				if (!(carta instanceof WildCard)) {
					estado.setCarta(carta);
				}
				estado.setBaralhoAtual(baralho);
				estado.setSentidoAtual(sentido);

			}
			jogadorAtual.setProibido(false);
		} while (!(jogadorAtual.getMao().size() == 0 && jogadorAtual.getJogaveis().size() == 0));
		System.out.println("O jogo acabou!!");
	}

	/**
	 * Método que é chamado quando um jogador manda o próximo jogador ir buscar cartas e proibe o jogador que foi buscar as cartas. 
	 * @param jogadorAtual
	 * @param proximoJogador
	 * @param quantas
	 */
	private void mandarBuscar(Jogador jogadorAtual, Jogador proximoJogador, int quantas) {
		proximoJogador.receberCartas(distribuirCartas(quantas));
		System.out.println("O jogador " + jogadorAtual.getNome() + " mandou o jogador " + proximoJogador.getNome()
				+ " ir buscar " + quantas + " cartas.\n");
		proibirProximo();
	}

	/**
	 * Método que é chamado quando o jogador atual joga uma carta que proibe o jogador seguinte.
	 */
	private void proibirProximo() {
		Jogador proximoJogador = jogadores.get(indiceProximoJogador());
		proximoJogador.setProibido(true);
		System.out.println("\nO jogador " + jogadores.get(indiceJogadorAtual).getNome() + " proibiu o jogador "
				+ proximoJogador.getNome() + " de jogar!\n");
	}


	/**
	 * Método que é chamado quando o jogador atual joga uma carta que permite mudar de cor.
	 * @param cor
	 */
	private void mudarCor(Cor cor) {
		estado.setCarta(new ActionCard(Tipo.COR, cor));
	}

	private void trocarSentido() {
		if (jogadores.size() == 2)
			proibirProximo();
		if (sentido == Sentido.DIREITA) {
			sentido = Sentido.ESQUERDA;
		} else {
			sentido = Sentido.DIREITA;
		}
		System.out.println(jogadores.get(indiceJogadorAtual).getNome() + " alterou o sentido do Jogo");
	}

	private void começarJogo() {
		Scanner scan = new Scanner(System.in);
		int quantos;
		do {
			System.out.println("Quantos jogadores vão jogar ?");
			quantos = scan.nextInt();
			if (quantos <= 1 || quantos > 10) {
				System.out.println("O numero de jogadores tem de ser maior que 1 e menor que 10");
			}
		} while (quantos <= 1 || quantos > 10);
		String nome;
		Jogador jogador;
		for (int i = 0; i < quantos; i++) {
			System.out.println("Introduza o nome do Jogador " + (i + 1));
			nome = scan.next();
			jogador = new Jogador(nome);
			jogador.receberCartas(distribuirCartas(7));
			jogadores.add(jogador);
		}
		baralho.validarPrimeiraCarta();
		pilha.add(baralho.tirarCarta());
		estado = new Estado(jogadores.get(indiceJogadorAtual), pilha.get(pilha.size() - 1), sentido, baralho);
		// System.out.println(estado.toString());
		indiceJogadorAtual = jogadores.size();
	}

	private Carta distribuirCarta() {
		if (baralho.getBaralho().size() <= 1)
			baralho.transferirPilha(pilha);
		return baralho.tirarCarta();
	}

	private ArrayList<Carta> distribuirCartas(int quantas) {
		if (baralho.getBaralho().size() <= quantas)
			baralho.transferirPilha(pilha);
		return baralho.tirarCartas(quantas);
	}

}
