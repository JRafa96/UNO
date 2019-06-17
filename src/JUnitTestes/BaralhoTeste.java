package JUnitTestes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import jogo.*;

class BaralhoTeste {

	@BeforeEach
	void setUp() throws Exception {
		Baralho B1 = new Baralho();
	}

	@Test
	@DisplayName("╯°□°）╯ Quantas Cartas")
	void Testar_total_Cartas() {
		Baralho B1 = new Baralho();
		assertEquals(108, B1.getBaralho().size());
	}

	@Test
	@DisplayName("╯°□°）╯ Quantas Cartas de Cada Tipo")
	void Testar_total_tipo() {
		Baralho B1 = new Baralho();
		Carta instancia;
		int cartanumero = 0;
		int cartaacao = 0;
		int cartawild = 0;
		for (int i = 0; i < 108; i++) {
			instancia = B1.getBaralho().get(i);
			if (instancia instanceof CartaNumero) {
				cartanumero++;
			} else if (instancia instanceof ActionCard) {
				cartaacao++;
			} else if (instancia instanceof WildCard) {
				cartawild++;
			}
		}
		assertEquals(76, cartanumero, "total de Cartas Numero:" + cartanumero);
		assertEquals(24, cartaacao, "total de Cartas Ação:" + cartaacao);
		assertEquals(8, cartawild, "total de Wildcards" + cartawild);
	}

	@Test
	@DisplayName("╯°□°）╯ Quantas Cartas da mesma cor")
	void Testar_total_mesma_cor() {
		Baralho B1 = new Baralho();
		Carta instancia;
		int amarelo = 0;
		int vermelho = 0;
		int verde = 0;
		int azul = 0;
		for (int i = 0; i < 108; i++) {
			instancia = B1.getBaralho().get(i);
			if (instancia instanceof CartaNumero) {
				switch (((CartaNumero) instancia).getCor()) {
				case AMARELO:
					amarelo++;
					break;
				case VERMELHO:
					vermelho++;
					break;
				case VERDE:
					verde++;
					break;
				case AZUL:
					azul++;
				}
			} else if (instancia instanceof ActionCard) {
				switch (((ActionCard) instancia).getCor()) {
				case AMARELO:
					amarelo++;
					break;
				case VERMELHO:
					vermelho++;
					break;
				case VERDE:
					verde++;
					break;
				case AZUL:
					azul++;
				}
			}
		}
		assertEquals(25, amarelo, "total de Cartas Numero:" + amarelo);
		assertEquals(25, vermelho, "total de Cartas Ação:" + vermelho);
		assertEquals(25, verde, "total de Cartas Numero:" + verde);
		assertEquals(25, azul, "total de Cartas Ação:" + azul);
	}

	@Test
	@DisplayName("╯°□°）╯ Quantas Cartas iguais")
	void Testar_total_iguais() {
		Baralho B1 = new Baralho();
		Carta instancia;
		int[] expected = new int[] { 4, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 4, 4 };
		int[] quantas = new int[15];
		 for (int i = 0; i < 108; i++) {

			instancia = B1.getBaralho().get(i);
			if (instancia instanceof CartaNumero) {
				switch (((CartaNumero) instancia).getNumero()) {
				case 0:
					quantas[0] += 1;
					break;
				case 1:
					quantas[1] += 1;
					break;
				case 2:
					quantas[2] += 1;
					break;
				case 3:
					quantas[3] += 1;
					break;
				case 4:
					quantas[4] += 1;
					break;
				case 5:
					quantas[5] += 1;
					break;
				case 6:
					quantas[6] += 1;
					break;
				case 7:
					quantas[7] += 1;
					break;
				case 8:
					quantas[8] += 1;
					break;
				case 9:
					quantas[9] += 1;
					break;
				}
			} else if (instancia instanceof ActionCard) {
				switch (((ActionCard) instancia).getTipo()) {
				case INVERTER_SENTIDO:
					quantas[10] += 1;
					break;
				case MAIS_2:
					quantas[11] += 1;
					break;
				case PROIBIDO:
					quantas[12] += 1;
				}
			}else if (instancia instanceof WildCard) {
			switch (((WildCard) instancia).getTipo()) {
			case MAIS_4:
				quantas[13] += 1;
				break;
			case MUDAR_COR:
				quantas[14] += 1;
				break;
			}
		}
		}
		assertArrayEquals(expected, quantas);
	}
	@Test
	@DisplayName("╯°□°）╯ Quantas Cartas iguais")
	void Testar_cartas() {
		Baralho B1 = new Baralho();
		Carta instancia;		   /*R,G,Y,B*/
		int[][] expected = new int[][] {{1,2,2,2,2,2,2,2,2,2,2,2,2},{1,2,2,2,2,2,2,2,2,2,2,2,2},{1,2,2,2,2,2,2,2,2,2,2,2,2},{1,2,2,2,2,2,2,2,2,2,2,2,2}};
		int[][] reality = new int[4][13];
		/*
		for (int i = 0; i < 108; i++) {
			
			instancia = B1.getBaralho().get(i);
			if (instancia instanceof CartaNumero) {
				switch (((CartaNumero) instancia).getNumero()) {
				case 0:
					[0] += 1;
					break;
				case 1:
					quantas[1] += 1;
					break;
				case 2:
					quantas[2] += 1;
					break;
				case 3:
					quantas[3] += 1;
					break;
				case 4:
					quantas[4] += 1;
					break;
				case 5:
					quantas[5] += 1;
					break;
				case 6:
					quantas[6] += 1;
					break;
				case 7:
					quantas[7] += 1;
					break;
				case 8:
					quantas[8] += 1;
					break;
				case 9:
					quantas[9] += 1;
					break;
				}
			} else if (instancia instanceof ActionCard) {
				switch (((ActionCard) instancia).getTipo()) {
				case INVERTER_SENTIDO:
					quantas[10] += 1;
					break;
				case MAIS_2:
					quantas[11] += 1;
					break;
				case PROIBIDO:
					quantas[12] += 1;
				}
			}
		}*/
		assertArrayEquals(expected, reality);
	}

}
