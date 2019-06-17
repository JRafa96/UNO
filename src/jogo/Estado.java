package jogo;

public class Estado {

	Jogador jogadorAtual;
	Carta cartaAtual;
	Sentido sentidoAtual;
	Baralho baralhoAtual;
	
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
				"\nRestam " + baralhoAtual.getBaralho().size()+ " cartas no baralho"; 
	}
	
	public Estado(Jogador jogadorAtual, Carta cartaAtual, Sentido sentidoAtual, Baralho baralhoAtual) {
		this.jogadorAtual = jogadorAtual;
		this.cartaAtual = cartaAtual;
		this.sentidoAtual = sentidoAtual;
		this.baralhoAtual = baralhoAtual;
	
	}

}
