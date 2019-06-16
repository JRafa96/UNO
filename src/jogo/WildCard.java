package jogo;

import java.util.Scanner;

/**
 * A classe <code>ActionCard</code> é constituida por um tipo e uma ação que vai
 * ser determinada de acordo com o seu tipo.
 * @author João Rafael
 *
 */
public class WildCard extends CartaEspecial {

	private Tipo tipo;

	/**
	 * Construtor da <code>WildCard</code>, recebe um tipo.
	 * @param tipo
	 */
	public WildCard(Tipo tipo) {
		super();
		this.tipo = tipo;
	}

	/**
	 * Método de acesso (leitura) ao tipo da carta.
	 * @return
	 */
	public Tipo getTipo() {
		return tipo;
	}

	/**
	 * Método chamado pelo jogo que vai pedir ao utilizador para introduzir uma cor.
	 * @return cor
	 */
	private Cor mudarCor() {
		String escolha;
		do {
			Scanner LerS = new Scanner(System.in);
			escolha = LerS.next();
		} while (Cor.stringToCor(escolha) == null);
		
		return Cor.stringToCor(escolha);
		
	}


	/**
	 * Ação que a carta vai realizar no <code>jogo</code>.
	 * 
	 * @throws Mais_4 se a carta for do tipo MAIS_4
	 */
	@Override
	public void açao() throws Exception{
		mudarCor();
		if(tipo == Tipo.MAIS_4) {
			throw new Mais_4();
		}
		
	}

	@Override
	public String toString() {
		return tipo.name();
	}

}
