package jogo;

import java.util.ArrayList;
import java.util.Collections;


/**
 * A class <code>Baralho</code> representa o baralho que vai ser utilizado no jogo do UNO.
 * � constituido por 108 cartas:
 * <ul>
 * 	<li>4 cores (vermelhas, amarelas, verdes, azuis)</li>
 * 	<li>3 tipos (ActionCards, WildCards e CartasNumero)</li>
 *  <li>76 CartasNumero</li>
 *  <li>24 ActionCard</li>
 *  <li>8 WildCards</li>  
 * </ul> 
 * @author Jo�o Rafael
 * @version 1.0
 */
public class Baralho {

	private ArrayList<Carta> baralho = new ArrayList<Carta>();
	
	
	
	/**
	 * Baralha as cartas do baralho, alterando aleatoriamente a sua ordem.
	 */
	public void baralhar() {
		Collections.shuffle(this.baralho);
	}
	
	
	
	/**
	 * Recebe um array de cartas e substitui o atual baralho.
	 * @param baralho
	 */
	public void setBaralho(ArrayList<Carta> baralho) {
		this.baralho = baralho;
	}
	
	
	
	/**
	 * M�todo de acesso (leitura) ao baralho.
	 * @return Array de cartas (baralho)
	 */
	public ArrayList<Carta> getBaralho() {
		return this.baralho;
	}
	
	
	/**
	 * M�todo utilizado para tranferir a pilha do jogo para o baralho e depois baralhar o baralho.
	 * @param pilha
	 */
	public void transferirPilha(ArrayList<Carta> pilha) {
		setBaralho(pilha);
		baralhar();
			
	}
	
	/**
	 * Retira a primeira carta do baralho.
	 * @return carta
	 */
	public Carta tirarCarta() {
		Carta carta = baralho.get(0);
		baralho.remove(0);
		return carta;
		
	}
	
	
	/**
	 * Utiliza o m�todo <code>tirarCarta()</code> para retirar uma quantidade especifica de cartas.
	 * @param quantidade
	 * @return Array de cartas
	 */
	public ArrayList<Carta> tirarCartas(int quantidade){
		ArrayList<Carta> retiradas = new ArrayList<Carta>();
		for(int i = 0;i<quantidade;i++) {
			retiradas.add(tirarCarta());
		}
		
		return retiradas;
	}
	
	/**
	 * Recebe uma carta e insere essa carta no fim do baralho.
	 * @param carta
	 */
	private void devolverCarta(Carta carta) {
		baralho.add(carta);
	}
	
	/**
	 * M�todo utilizado para verificar se a primeira carta do baralho � uma <code>CartaNumero</code>.
	 */
	protected void validarPrimeiraCarta() {
		Carta carta= baralho.get(0);
		while (!(carta instanceof CartaNumero)) {
			Carta primeiraCarta = baralho.get(0);
			devolverCarta(primeiraCarta);
			baralho.remove(0);
			carta = baralho.get(0);
		}
	}
	
	/**
	 * Cria as 108 cartas do baralho.
	  * <ul>
	  * 	<li>2x N�meros (do 1 ao 9), para cada cor</li>
	  * 	<li>1x N�meros 0, para cada cor</li>
	  * 	<li>2x ActionCard (Mais_2, proibido, inverte_sentido), para cada cor</li>
	  * 	<li>4x MudaCor e Mais_4</li>   
	  * </ul> 
	 */
	private void gerarCartas() {
		//for COR
		for(int i=0;i<4;i++) {
			//for Carta exceto 0
			for(int j = 0;j<2;j++) {
				// for CartaNumero -- cor ENUM
				for(int l = 1;l<10;l++) {
					Carta carta = new CartaNumero(l, Cor.values()[i]);
					baralho.add(carta);
				}
				//for ActionCard -- tipo + cor ENUM
				for(int m = 0;m<3;m++) {
					Carta carta = new ActionCard(Tipo.values()[m], Cor.values()[i]);
					baralho.add(carta);
				}
				
				
			}
			
			//for WildCard -- tipo ENUM
			for(int n=3; n<5;n++) {
				Carta carta = new WildCard(Tipo.values()[n]);
				baralho.add(carta);
			}
			
			//for CartaNumero 0 -- cor ENUM
			Carta carta0 = new CartaNumero(0, Cor.values()[i]);
			baralho.add(carta0);
		}
	}
	
	/**
	 * Construtor da classe baralho vai <code>gerarCartas()</code> e
	 * <code>baralhar()</code> quando � instanciado.
	 */
	public Baralho() {
		gerarCartas();
		baralhar();
	}

}