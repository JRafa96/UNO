package jogo;

/**
 * A classe <code>ActionCard</code> � constituida por um tipo 
 * (Mais_2, Inverter_Sentido e Proibido), uma cor e uma a��o que � determinada pelo tipo.
 * @author Jo�o Rafael
 *
 */
public class ActionCard extends CartaEspecial {

	private Tipo tipo;
	private Cor cor;

	/**
	 * Construtor da <code>ActionCard</code>, recebe um tipo e uma cor.
	 * @param tipo
	 * @param cor
	 */
	public ActionCard(Tipo tipo, Cor cor) {
		super();
		this.tipo = tipo;
		this.cor = cor;
	}

	/**
	 * M�todo de acesso (leitura) ao tipo da carta.
	 * @return tipo
	 */
	public Tipo getTipo() {
		return tipo;
	}

	/**
	 * M�todo de acesso (leitura) � cor da carta.
	 * @return cor
	 */
	public Cor getCor() {
		return cor;
	}

	/**
	 *A��o que a carta vai realizar no <code>jogo</code>.
	 * 
	 *@throws Mais_2 se a carta for do tipo MAIS_2
	 *@throws Inverter_Sentido se a carta for do tipo INVERTER_SENTIDO
	 *@throws Proibido se a carta for do tipo PROIBIDO
	 */
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
		String nome=tipo==Tipo.COR?"":tipo.name();
		return nome+" "+cor.name();
	}
}
