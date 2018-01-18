import java.util.Scanner;

//Dados dois numeros inteiros A e B, crie um terceiro inteiro C seguindo as seguintes
//regras:
//- O primeiro n�mero de C � o primeiro n�mero de A;
//- O segundo n�mero de C � o primeiro n�mero de B;
//- O terceiro n�mero de C � o segundo n�mero de A;
//- O quarto n�mero de C � o segundo n�mero de B;
//Assim sucessivamente�
//- Caso os n�meros de A ou B sejam de tamanhos diferentes, completar C com o restante
//dos n�meros do inteiro maior. Ex: A = 10256, B = 512, C deve ser 15012256.
//- Caso C seja maior que 1.000.000, retornar -1

public class NumIntercalado {
	private static String a, b, c;
	private static int conta = 0, contb = 0;
	private static Scanner ent;
	
	public static void main(String[] args) {
		try {
			ent = new Scanner(System.in);
			System.out.println("Digite o valor de A:\n");
			a = ent.nextLine(); 
			System.out.println("Digite o valor de B:\n\t");
			b = ent.nextLine(); 
			c = new String();
			
			for (int i = 0; i <= a.length(); i++) {
				if (conta == a.length()) {
					numB(contb);
					break;
				}
				c = c + a.charAt(i);
				numB(i);
				conta++;
			}
			Integer n = 1000000;
			Integer cnum = 0;
			cnum = Integer.valueOf(c);
			
			if(cnum > n) {
				System.out.println("Valor de 'C' > 1.000.000:" + -1);
			} else {
				System.out.println("N�meros intercalados:" + c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void numB(Integer num) {
		if (contb == b.length()) {
			return;
		}else {
			if(conta == a.length()) {
				for (int i = num; i < b.length(); i++) {
					c = c + b.charAt(num);
				}
			} else {
				c = c + b.charAt(num);
			}
		}
		contb++;

	}

}
