package jogo;

public class ActionCard extends Carta {

	private Tipo tipo;
	private Cor cor;

	public ActionCard(Tipo tipo, Cor cor) {
		super();
		this.tipo = tipo;
		this.cor = cor;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public Cor getCor() {
		return cor;
	}

	public void açao() {
		System.out.println("Usaste uma carta " + tipo);
	}
	
	@Override
	public String toString() {
		return tipo.name()+" "+cor.name();
	}
}
