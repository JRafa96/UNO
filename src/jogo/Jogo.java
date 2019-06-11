package jogo;

import java.util.ArrayList;

public class Jogo{
	ArrayList<Jogador> jogadores;
	ArrayList<Carta> pilha;
	Baralho baralho;
	Estado estado;
	Sentido sentido;
	int jogadorAtual;
	
	public void jogar() {
		começarJogo();
	}
	
	private void começarJogo() {
		sentido = Sentido.DIREITA;
		baralho = new Baralho();
		estado = new Estado(jogadores.get(jogadorAtual), pilha.get(pilha.size()-1), sentido, baralho);
		ArrayList<Carta> pilha = new ArrayList<Carta>();
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
