package jogo;

public class ActionCard extends CartaEspecial {

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

	@Override
	public void açao() throws Exception{
		if(tipo == Tipo.MAIS_2) {
			throw new Mais_2();
		} else if (tipo == Tipo.INVERTER_SENTIDO) {
			throw new Inverter_Sentido();
		} else if (tipo == Tipo.PROIBIDO) {
			throw new Proibido();
		}
	}
	
	@Override
	public String toString() {
		return tipo.name()+" "+cor.name();
	}
}
