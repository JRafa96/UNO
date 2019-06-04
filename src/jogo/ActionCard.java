package jogo;

public class ActionCard extends Carta {

	private String tipo;
	private char cor;

	public ActionCard(String tipo, char cor) {
		super();
		this.tipo = tipo;
		this.cor = cor;
	}

	public String getTipo() {
		return tipo;
	}

	public char getCor() {
		return cor;
	}

	public void açao() {
		System.out.println("Usaste uma carta " + tipo);
	}
}
