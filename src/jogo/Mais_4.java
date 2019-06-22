package jogo;

/**
 * É uma exceção que é lançada quando um jogador joga uma carta do tipo Mais_4.
 * @author Bernardo
 *
 */
public class Mais_4 extends Exception{

	private Cor cor;
	
	public Cor getCor() {
		return cor;
	}
	
	public Mais_4(Cor cor) {
		super("Bisca 4 cartas e muda de cor");
		this.cor=cor;
	}

}
