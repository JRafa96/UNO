package jogo;

public class ActionCard extends Carta {

	private Tipo tipo;
	private char cor;

	public ActionCard(Tipo tipo, char cor) {
		super();
		this.tipo = tipo;
		this.cor = cor;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public char getCor() {
		return cor;
	}

	public void açao() {
		System.out.println("Usaste uma carta " + tipo);
	}
}
