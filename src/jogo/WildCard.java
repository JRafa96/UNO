package jogo;

import java.util.Scanner;

public class WildCard extends Carta {

	private Tipo tipo;

	public WildCard(Tipo tipo) {
		super();
		this.tipo = tipo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	private Cor mudarCor() {
		String escolha;
		do {
			Scanner LerS = new Scanner(System.in);
			escolha = LerS.next();
		} while (Cor.stringToCor(escolha) == null);
		
		return Cor.stringToCor(escolha);
		
	}



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
