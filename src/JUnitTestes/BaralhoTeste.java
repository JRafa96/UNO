package JUnitTestes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

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
				quantas[((CartaNumero) instancia).getNumero()]++;
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
			} else if (instancia instanceof WildCard) {
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
	@DisplayName("╯°□°）╯ Quantas Cartas iguais da mesma cor")
	void Testar_cartas() {
		Baralho B1 = new Baralho();
		Carta instancia;
		int[][] expected = new int[][] { { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 },
				{ 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 }, { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 },
				{ 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 } };

		int[][] reality = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 108; j++) {
				instancia = B1.getBaralho().get(j);
				if (instancia instanceof CartaNumero) {
					if (((CartaNumero) instancia).getCor().ordinal() == i) {
						reality[i][(((CartaNumero) instancia).getNumero())] += 1;
					}
				} else if (instancia instanceof ActionCard) {
					if (((ActionCard) instancia).getCor().ordinal() == i) {
						switch (((ActionCard) instancia).getTipo()) {
						case INVERTER_SENTIDO:
							reality[i][10] += 1;
							break;
						case MAIS_2:
							reality[i][11] += 1;
							break;
						case PROIBIDO:
							reality[i][12] += 1;
							break;
						}
					}
				}
			}
		}
		assertArrayEquals(expected, reality);
	}

	@Test
	@DisplayName("╯°□°）╯ Primeira Carta Baralho Valida")
	void Testar_n1_valida() {
		Carta c1;
		Baralho B1 = new Baralho();
		c1 = B1.tirarCarta();
		assertTrue(c1 instanceof CartaNumero == true);
	}

	@Test
	@DisplayName("╯°□°）╯ quantas Wildcards ")
	void teste_wildcards() {
		Baralho B1 = new Baralho();
		Carta c1;
		int mais4 = 0;
		int mudacor = 0;
		for (int i = 0; i < 108; i++) {
			c1 = B1.getBaralho().get(i);
			if (c1 instanceof WildCard) {
				switch (((WildCard) c1).getTipo()) {
				case MAIS_4:
					mais4 += 1;
					break;
				case MUDAR_COR:
					mudacor += 1;
					break;
				}

			}

		}
	}
}