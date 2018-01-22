import java.util.Scanner;

public class BinaryTree {

	int valor;
	BinaryTree left;
	BinaryTree right;
	static int n = 0, nums;

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		BinaryTree tree = null;
		boolean imprimir = true;
		System.out.println("Digite o total de v�rtices[N�s da �rvore]:\n");

		if (isNumeric(entrada.next(), false)) {
			if (n <= 1) {
				System.out.println("N�mero inv�lido: N�mero de v�rtices deve ser >= 2\n");
			} else {
				for (int i = 0; i < n; i++) {
					System.out.println("Digite um n�mero:\n");

					if (isNumeric(entrada.next(), true)) {
						tree = inserir(tree, nums);
					} else {
						imprimir = false;
						break;
					}

				}
				if (imprimir == true) {
					imprimir(tree);
					int cont = 0;
					System.out.println("A soma dos n�s subsequentes a partir do n� raiz �:\n" + SomaNo(tree, cont));

				}
			}

		}

	}

	public static BinaryTree inserir(BinaryTree auxTree, int num) {
		if (auxTree == null) { // Seta o n� raiz
			auxTree = new BinaryTree();
			auxTree.valor = num;
			auxTree.left = null;
			auxTree.right = null;
		} else if (num < auxTree.valor) { // valor a inserir < valor do n� raiz atual
			auxTree.left = inserir(auxTree.left, num);
		} else {
			auxTree.right = inserir(auxTree.right, num);
		}
		return auxTree;
	}

	// Imprime em ordem crescente
	public static void imprimir(BinaryTree auxTree) {
		if (auxTree != null) {
			imprimir(auxTree.left);
			System.out.println("Valor do N�:" + auxTree.valor);
			imprimir(auxTree.right);
		}
	}

	// Soma dos n�s subsequentes
	public static int SomaNo(BinaryTree auxTree, int n) {

		if (auxTree != null) {
			n = n + auxTree.valor + SomaNo(auxTree.left, n) + SomaNo(auxTree.right, n);
		}

		return n;
	}

	// validar numero
	public static boolean isNumeric(String s, boolean status) {
		try {
			Long.parseLong(s);
			if (status == false) {
				n = Integer.parseInt(s);
			} else {
				nums = Integer.parseInt(s);
			}

			return true;
		} catch (NumberFormatException ex) {
			System.out.println("Valor(es) informado n�o � um n�mero:\n");
			return false;
		}
	}

}
