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
		return jogaveis.get(n);
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
		for (int j = 0; j <= mao.size(); j++) {
			if (mao.get(j).getCor() == estado.getCor()) {
				jogaveis.add(e);
			} else {
				if (mao.get(j).getNumero() == estado.getNumero()) {
					jogaveis.add(e);
				} else {
					if (mao.get(j) instanceof Wildcard) { // instanceof verifica se é uma classe daquele tipo
						jogaveis.add(e);
					}
				}
			}
		}
	}

}
