import java.util.Scanner;

public class BusStation {

	public static void main(String[] args) {
		entrada();
		imprime();
		System.exit(0);
	}
	

	private static int soma, n; // quantidade de grupos, 1<=N <=100000
	public static int[] matxpessoas, saida; // quantidade de pessoas no grupo, 1 <= n <=10000
	private static Scanner ent;

	public static void entrada() {
		try {
			ent = new Scanner(System.in);
			System.out.println("Digite o a quantidade de grupos de amigos: \n");
			n = ent.nextInt();

			validaLimite();
			matxpessoas = new int[n];

			for (int i = 0; i < n; i++) {

				System.out.println("Digite o valor de a" + (i + 1) + "\n");
				matxpessoas[i] = validaLimitePessoa(ent.nextInt());
				soma = soma + matxpessoas[i];

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void validaLimite() {
		if (n > 0 && n > 100000) {
			System.out.println("ultrapassou limite de grupo! \n");
			System.exit(0);
		}
	}

	public static int validaLimitePessoa(int qtde) {
		if (qtde > 0 && qtde > 10000) {
			System.out.println("ultrapassou limite de pessoas! \n");
			System.exit(0);
		}
		return qtde;
	}

	public static void imprime() {

		if (n == 1 || n == 2) { //viagens não é valida

			System.out.printf(" %2d \n", soma);
		} else {
			saida = new int[n / 2];
			for (int i = 0; i < (n / 2); i++) {// divide o total na metade

				if (soma % (i + 1) == 0) { // lista somatorio pessoas, divisao do tamanho do onibus

					saida[i] = soma / (i + 1);

				}

			}
			asc();
		}

	}

	public static void asc() {
		for (int j = saida.length - 1; j >= 0; j--) {
			if (soma % (j + 1) == 0) {
				System.out.printf(" %2d \n", saida[j]);
			}
		}

	}

}
