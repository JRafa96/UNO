package jogo;

import java.util.ArrayList;
import java.util.Collections;

public class Baralho {

	private ArrayList<Carta> baralho = new ArrayList<Carta>();
	
	public void baralhar() {
		Collections.shuffle(this.baralho);
	}
	
	public void setBaralho(ArrayList<Carta> baralho) {
		this.baralho = baralho;
	}
	
	public void transferirPilha(ArrayList<Carta> pilha) {
		setBaralho(pilha);
		baralhar();
			
	}
	
	public Carta tirarCarta() {
		Carta carta = baralho.get(0);
		baralho.remove(0);
		return carta;
		
	}
	
	
	public ArrayList<Carta> tirarCartas(int quantidade){
		ArrayList<Carta> retiradas = new ArrayList<Carta>();
		for(int i = 0;i<quantidade;i++) {
			retiradas.add(tirarCarta());
		}
		
		return retiradas;
	}
	
	private void devolverCarta(Carta carta) {
		baralho.add(carta);
	}
	
	protected void validarPrimeiraCarta() {
		Carta carta = baralho.get(0);
		do {
			devolverCarta(carta);
			baralho.remove(0);
		}while (!(carta instanceof CartaNumero));
	}
	
	private void gerarCartas() {
		//for COR
		for(int i=0;i<4;i++) {
			//for Carta exceto 0
			for(int j = 0;i<2;j++) {
				// for CartaNumero -- cor ENUM
				for(int l = 1;l<10;l++) {
					Carta carta = new CartaNumero(l, i);
					baralho.add(carta);
				}
				//for ActionCard -- tipo + cor ENUM
				for(int m = 0;m<4;m++) {
					Carta carta = new ActionCard(m, i);
					baralho.add(carta);
				}
				//for WildCard -- tipo ENUM
				for(int n=3; n<5;n++) {
					Carta carta = new WildCard(n);
					baralho.add(n);
				}
				
			}
			
			//for CartaNumero 0 -- cor ENUM
			Carta carta0 = new CartaNumero(0, i);
			baralho.add(carta0);
		}
	}
	public Baralho() {
		// TODO Auto-generated constructor stub
	}

}