package jogo;

/**
 * É uma exceção que é lançada quando um jogador joga uma carta do tipo proibido.  
 * @author Bernardo
 *
 */
public class Proibido extends Exception{

	public Proibido() {
		super("Proibido jogar");
	}

}
