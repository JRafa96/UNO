package jogo;

import java.util.ArrayList;

public class Jogo{
	ArrayList<Jogador> jogadores;
	ArrayList<Carta> pilha;
	Baralho baralho;
	Estado estado;
	
	public void jogar() {
		começarJogo();
	}
	
	private void começarJogo() {
		baralho = new Baralho();
		estado = new Estado();
		ArrayList<Carta> pilha = new ArrayList<Carta>();
		Estado estado = new Estado();
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
