package jogo;

import java.util.Scanner;

/**
 * A classe <code>ActionCard</code> � constituida por um tipo e uma a��o que vai
 * ser determinada de acordo com o seu tipo.
 * @author Jo�o Rafael
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
	 * M�todo de acesso (leitura) ao tipo da carta.
	 * @return
	 */
	public Tipo getTipo() {
		return tipo;
	}

	/**
	 * M�todo chamado pelo jogo que vai pedir ao utilizador para introduzir uma cor.
	 * @return cor
	 */
	private Cor mudarCor() {
		String escolha;
		do {
			System.out.println("Escolha uma cor");
			Scanner LerS = new Scanner(System.in);
			escolha = LerS.next();
		} while (Cor.stringToCor(escolha) == null);
		
		return Cor.stringToCor(escolha);
		
	}


	/**
	 * A��o que a carta vai realizar no <code>jogo</code>.
	 * 
	 * @throws Mais_4 se a carta for do tipo MAIS_4
	 * @throws MudaCor se a carta for do tipo MudaCor
	 */
	@Override
	public void açao() throws Exception{
		Cor cor=mudarCor();
		if(tipo == Tipo.MAIS_4) {
			throw new Mais_4(cor);
		}else {
			throw new MudaCor(cor);
		}
		
	}

	@Override
	public String toString() {
		return tipo.name();
	}

}
