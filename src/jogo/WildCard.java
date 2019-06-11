package jogo;

public class WildCard extends Carta {

	private Tipo tipo;

	public WildCard(Tipo tipo) {
		super();
		this.tipo = tipo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	private void mudarCor() {
		System.out.println("Mudaste de cor");
	}
	
	public void açao() {
		System.out.println("Usaste uma carta " + tipo);
		mudarCor();
	}
	
	@Override
	public String toString() {
		return tipo.name();
	}
	
}
