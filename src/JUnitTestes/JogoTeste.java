package JUnitTestes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;

import jogo.*;

class JogoTeste {
	    	static Jogador pl1 = new Jogador("Player 1");
			static Jogador pl2 = new Jogador("Player 2");
			static ArrayList<Jogador> jogadores;
	        ArrayList<Carta> pilha;
			static Baralho baralho = new Baralho();
			Estado estado;
			static Sentido sentido;
			int indiceJogadorAtual;
			

	static ArrayList<Jogador> setUP_Jogador() {
		jogadores = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				pl1.receberCartas(baralho.tirarCartas(7));
				jogadores.add(pl1);
			} else {
				pl1.receberCartas(baralho.tirarCartas(7));
				jogadores.add(pl2);
			}
		}
		return jogadores;
	}
	
		
	@ParameterizedTest
	@MethodSource("setUP_Jogador")
	@DisplayName("╯°□°）╯ ||____|| jogador foi buscar cartas depois de +2 ")
	void test1() {
		sentido=Sentido.DIREITA;
		pilha = new  ArrayList<Carta>();
		indiceJogadorAtual=0;
		System.out.println(jogadores.get(0).getNome());
		Carta primeira_amarela = new CartaNumero(1, Cor.values()[0]);
 		Carta c1 = new ActionCard(Tipo.values()[0], Cor.values()[0]);
		pilha.add(primeira_amarela);
		estado = new Estado(jogadores.get(indiceJogadorAtual), pilha.get(pilha.size() - 1), sentido, baralho);
		System.out.println(estado.toString());
		indiceJogadorAtual = 0;
	    // Inicio de todos Junit +/-
		// Apenas varia pilha.add e o criar cartas
		int antes =pl2.getMao().size();
		estado.setCarta(c1);
		if (!(c1 instanceof CartaNumero)) {
			Jogador proximoJogador=jogadores.get(1);
			try {
				((CartaEspecial) c1).açao();
			} catch (Mais_2 m2) {
				proximoJogador.receberCartas(baralho.tirarCartas(4));
				proximoJogador.setProibido(true);
				System.out.println("O jogador "+pl1.getNome()+" mandou o jogador "+proximoJogador.getNome()+" ir buscar 4 cartas");
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		assertEquals(antes+2, pl2.getMao().size(),"Total de Cartas na Mao"+ pl2.getMao().size());
	}

	@Test
	@DisplayName("╯°□°）╯ ||____||  Troca de jogador sentido normal")
	void test2() {

	}

	@Test
	@DisplayName("╯°□°）╯ ||____||  Troca de jogador apos inverte sentido")
	void test3() {

	}

	@Test
	@DisplayName("╯°□°）╯ ||____||  Tentar jogar Carta nao jogavel")
	void test4() {

	}

	@Test
	@DisplayName("╯°□°）╯ ||____||  Cada jogador tem quantas cartas")
	void test5() {

	}

	@Test
	@DisplayName("╯°□°）╯ ||____||  jogador depois de proibido volta a trocar estado")
	void test6() {

	}

	@Test
	@DisplayName("╯°□°）╯ ||____||  jogador so vai buscar ate ter carta jogavel")
	void test7() {

	}

	@Test
	@DisplayName("╯°□°）╯ ||____||  jogador so vai buscar ate ter carta jogavel")
	void test8() {

	}

}
