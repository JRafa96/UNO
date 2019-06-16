package jogo;

import java.util.ArrayList;
import java.util.Scanner;

public class Jogador {
	private String nome;
	private ArrayList<Carta> mao = new ArrayList<Carta>();
	private ArrayList<Carta> jogaveis = new ArrayList<Carta>();
	private boolean proibido;

	public boolean isProibido() {
		return proibido;
	}

	public void setProibido(boolean proibido) {
		this.proibido = proibido;
	}

	public String getNome() {
		return nome;
	}

	public ArrayList<Carta> getMao() {
		return mao;
	}

	public ArrayList<Carta> getJogaveis() {
		return jogaveis;
	}

	public Jogador() {
	}

	public Jogador(String nome) {
		this.nome = nome;

	}

	private String getJogaveisString() {
		return jogaveis.toString();
	}

	public Carta jogarCarta(Estado estado) {
		verificarJogaveis(estado);
		System.out.println(getJogaveisString());
		System.out.println("Que carta quer jogar?");
		Scanner LerS = new Scanner(System.in);
		int n = LerS.nextInt();
		Carta carta = jogaveis.get(n);
		jogaveis.remove(n);
		mao.addAll(jogaveis);
		return carta;
	}

	public void receberCarta(Carta carta) {
		mao.add(carta);
	}

	public void receberCartas(ArrayList<Carta> cartas) {
		mao.addAll(cartas);
	}

	public boolean isVazia() {
		if (mao.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	private void moverJogaveis(int pos) {
		jogaveis.add(mao.get(pos));
		mao.remove(pos);
	}
	
	public void verificarJogaveis(Estado estado) {
		mao.addAll(jogaveis);
		jogaveis.clear();
		for (int j = 0; j < mao.size(); j++) {
			if (mao.get(j) instanceof ActionCard) {
				if (estado.cartaAtual instanceof ActionCard) {
					if (((ActionCard) mao.get(j)).getCor() == ((ActionCard) estado.cartaAtual).getCor()) {
						moverJogaveis(j);
						j--;
					} else if (((ActionCard) mao.get(j)).getTipo() == ((ActionCard) estado.cartaAtual).getTipo()) {
						moverJogaveis(j);
						j--;
					}
				} else if (estado.cartaAtual instanceof CartaNumero) {
					if (((ActionCard) mao.get(j)).getCor().ordinal() == ((CartaNumero) estado.cartaAtual).getCor().ordinal()) {
						moverJogaveis(j);
						j--;
					}
				}

			} else if (mao.get(j) instanceof CartaNumero) {
				if (estado.cartaAtual instanceof CartaNumero) {
					if (((CartaNumero) mao.get(j)).getCor().ordinal() == ((CartaNumero) estado.cartaAtual).getCor().ordinal()) {
						moverJogaveis(j);
						j--;
					} else if (((CartaNumero) mao.get(j)).getNumero() == ((CartaNumero) estado.cartaAtual)
							.getNumero()) {
						moverJogaveis(j);
						j--;
					}
				} else if (estado.cartaAtual instanceof ActionCard) {
					if (((CartaNumero) mao.get(j)).getCor().ordinal() == ((ActionCard) estado.cartaAtual).getCor().ordinal()) {
						moverJogaveis(j);
						j--;
					}
				}

			} else if (mao.get(j) instanceof WildCard) { // instanceof verifica se é uma classe daquele tipo
				moverJogaveis(j);
				j--;
			}
		}
	}
}
