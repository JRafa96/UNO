package jogo;

/**
 * Uma classe que define o estado do jogo.
 * Verifica qual é o jogador atual, qual a carta que está em jogo, qual o sentido atual do jogo e tem o baralho.
 * @author Bernardo
 *
 */
public class Estado {

	Jogador jogadorAtual;
	Carta cartaAtual;
	Sentido sentidoAtual;
	Baralho baralhoAtual;
	
	
	
	public Jogador getJogadorAtual() {
		return jogadorAtual;
	}

	public void setJogadorAtual(Jogador jogadorAtual) {
		this.jogadorAtual = jogadorAtual;
	}

	public Sentido getSentidoAtual() {
		return sentidoAtual;
	}

	public void setSentidoAtual(Sentido sentidoAtual) {
		this.sentidoAtual = sentidoAtual;
	}

	public Baralho getBaralhoAtual() {
		return baralhoAtual;
	}

	public void setBaralhoAtual(Baralho baralhoAtual) {
		this.baralhoAtual = baralhoAtual;
	}

	public Carta getCartaAtual() {
		return cartaAtual;
	}

	/**
	 * Método que vai receber a carta jogada e alterar a carta atual.
	 * @param carta
	 */
	public void setCarta(Carta carta) {
		if (carta instanceof WildCard) {
			cartaAtual=new WildCard(((WildCard) carta).getTipo());
		}else if (carta instanceof CartaNumero) {
			cartaAtual=new CartaNumero(((CartaNumero) carta).getNumero(), ((CartaNumero) carta).getCor());
		}else if (carta instanceof ActionCard) {
			cartaAtual=new ActionCard(((ActionCard) carta).getTipo(), ((ActionCard) carta).getCor());
		}
	}

	@Override
	public String toString() {
		return 	"\n+--------------------------------------------+\n" +
				"O jogador atual é o " + jogadorAtual.getNome() +
				"\nA carta em jogo é o " + cartaAtual.toString() + 
				"\nO jogo está a rodar para a " + sentidoAtual.name() + 
				"\nRestam " + baralhoAtual.getBaralho().size()+  " cartas no baralho\n"; 
	}
	
	/**
	 * Construtor que recebe os seguintes parâmetros:
	 * @param jogadorAtual
	 * @param cartaAtual
	 * @param sentidoAtual
	 * @param baralhoAtual
	 */
	public Estado(Jogador jogadorAtual, Carta cartaAtual, Sentido sentidoAtual, Baralho baralhoAtual) {
		this.jogadorAtual = jogadorAtual;
		this.cartaAtual = cartaAtual;
		this.sentidoAtual = sentidoAtual;
		this.baralhoAtual = baralhoAtual;
	
	}

}
