package jogo;

public class WildCard extends Carta {

	private String tipo;

	public WildCard(String tipo) {
		super();
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	private void mudarCor() {
		System.out.println("Mudaste de cor");
	}
	
	public void açao() {
		System.out.println("Usaste uma carta " + tipo);
		mudarCor();
	}
	
}
