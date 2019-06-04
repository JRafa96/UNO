package jogo;

import java.util.ArrayList;

public class Baralho {

	ArrayList<Carta> baralho;
	
	public void baralhar() {
		
	}
	
	public void setBaralho(ArrayList<Carta> baralho) {
		this.baralho = baralho;
	}
	
	public void transferirPilha(ArrayList<Carta> pilha) {
		setBaralho(pilha);
		baralhar();
			
	}
	
	
	public Baralho() {
		// TODO Auto-generated constructor stub
	}

}
