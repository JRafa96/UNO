package jogo;

public class Estado {

	Jogador jogadorAtual;
	Carta cartaAtual;
	Sentido sentidoAtual;
	Baralho baralhoAtual;
	
	
	@Override
	public String toString() {
		return "O jogador atual é o " + jogadorAtual.getNome() +
				"\nA carta em jogo é o " + cartaAtual.toString() + 
				"\nO jogo está a rodar para a " + sentidoAtual.name() + 
				"\nRestam " + baralhoAtual.getBaralho().size()+ " cartas no baralho"; 
	}i
	
	public Estado(Jogador jogadorAtual, Carta cartaAtual, Sentido sentidoAtual, Baralho baralhoAtual) {
		this.jogadorAtual = jogadorAtual;
		this.cartaAtual = cartaAtual;
		this.sentidoAtual = sentidoAtual;
		this.baralhoAtual = baralhoAtual;
	
	}

}
