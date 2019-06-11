package jogo;

import java.util.ArrayList;
import java.util.Scanner;

public class Jogador {
	private String nome;
	private ArrayList<Carta> mao = new ArrayList<Carta>();
	private ArrayList<Carta> jogaveis = new ArrayList<Carta>();
	private boolean proibido;

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

	public Carta jogarCarta(Estado estado) {
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

	public boolean isVazia() {
		if (mao.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void verificarJogaveis(Estado estado) {
		jogaveis.clear();
		for (int j = 0; j <= mao.size(); j++) {
			if (mao.get(j) instanceof ActionCard) {
				if (((ActionCard) mao.get(j)).getCor() == ((ActionCard)estado.cartaAtual).getCor()) {
					jogaveis.add(mao.get(j));
					mao.remove(j);
					break;
				}
				if (((ActionCard) mao.get(j)).getTipo() == ((ActionCard)estado.cartaAtual).getTipo()) {
					jogaveis.add(mao.get(j));
					mao.remove(j);
					break;
				}
			} else if (mao.get(j) instanceof CartaNumero) {
				if (((CartaNumero) mao.get(j)).getNumero() == ((CartaNumero)estado.cartaAtual).getNumero()) {
						jogaveis.add(mao.get(j));
						mao.remove(j);
						break;
					}
				}
				if (((CartaNumero) mao.get(j)).getCor() == ((CartaNumero)estado.cartaAtual).getCor()) {
					jogaveis.add(mao.get(j));
					mao.remove(j);
			} else {
				if (mao.get(j) instanceof WildCard) { // instanceof verifica se é uma classe daquele tipo
					jogaveis.add(mao.get(j));
					mao.remove(j);
				} else {

				}
			}
		}
	}
}
