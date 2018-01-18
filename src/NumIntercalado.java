import java.util.Scanner;

//Dados dois numeros inteiros A e B, crie um terceiro inteiro C seguindo as seguintes
//regras:
//- O primeiro número de C é o primeiro número de A;
//- O segundo número de C é o primeiro número de B;
//- O terceiro número de C é o segundo número de A;
//- O quarto número de C é o segundo número de B;
//Assim sucessivamente…
//- Caso os números de A ou B sejam de tamanhos diferentes, completar C com o restante
//dos números do inteiro maior. Ex: A = 10256, B = 512, C deve ser 15012256.
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
				System.out.println("Números intercalados:" + c);
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
