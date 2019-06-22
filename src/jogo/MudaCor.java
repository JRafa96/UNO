package jogo;

/**
 * É uma exceção que é lançada quando um jogador joga uma carta para mudar de cor.
 * @author Bernardo
 *
 */
public class MudaCor extends Exception{

private Cor cor;
	
	public Cor getCor() {
		return cor;
	}
	
	public MudaCor(Cor cor) {
		super("Muda de cor");
		this.cor = cor;
	}

}
