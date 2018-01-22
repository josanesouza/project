import java.util.Random;
import java.util.Scanner;

public class Matriz {

	public static Scanner ent;
	public static int[][] matx;
	public static int ordem, numMin = -100, numMax = 100, numRand, contP, contS;

	public static void main(String[] args) {

		ent = new Scanner(System.in);

		System.out.println("Digite a Ordem da Matriz:\n");
		if (isNumeric(ent.next())) {
			if (ordem < 1) {
				System.out.println("Matriz quadrada inicia: 1 x 1");
			} else {
				diffDiagonal(matx, ordem);
			}
		} else {
			System.out.println("Valor informado não é um número:\n");
		}

	}

	public static int diffDiagonal(int[][] mtrx, int n) {
		try {
			matx = new int[n][n]; // Definindo a ordem da matriz
			int auxP, auxS = 0;

			for (int i = 0; i < matx.length; i++) {
				for (int j = 0; j < matx[i].length; j++) {
					numRand = numMin + geradorRandom(numMax - numMin); // Gera números aleatórios.
					matx[i][j] = numRand; // seta o numero no matriz[i, j]

					if (matx[i] == matx[j]) {

						auxP = matx[i][j];
						contP = contP + auxP;
						System.out.println("i,j:" + i + j + " = " + matx[i][j]); // diagonal principal
					}
					if ((i + j) == (n - 1)) {

						auxS = matx[i][j];
						contS = contS + auxS;
						System.out.println("i,j:" + i + j + " = " + matx[i][j]); // diagonal secundaria

					}

				}

			}
			// saida
			if (n == 1) {
				System.out.println("Matriz ordem 1: (" + contP + ")");
			} else {
				System.out.println("(" + contP + ")" + " - " + "(" + contS + ")" + " = " + (contP - contS));
			}

		} catch (Exception e) {
			System.out.println("Ocorreu" + e.getMessage());
		}

		return 0;

	}

	// Gerador de numeros aleatórios
	public static int geradorRandom(int num) {
		Random random = new Random();
		return random.nextInt(num);
	}

	// validar numero
	public static boolean isNumeric(String s) {
		try {
			Long.parseLong(s);
			ordem = Integer.parseInt(s);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

}
