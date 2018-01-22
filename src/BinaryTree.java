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
		System.out.println("Digite o total de vértices[Nós da árvore]:\n");

		if (isNumeric(entrada.next(), false)) {
			if (n <= 1) {
				System.out.println("Número inválido: Número de vértices deve ser >= 2\n");
			} else {
				for (int i = 0; i < n; i++) {
					System.out.println("Digite um número:\n");

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
					System.out.println("A soma dos nós subsequentes a partir do nó raiz é:\n" + SomaNo(tree, cont));

				}
			}

		}

	}

	public static BinaryTree inserir(BinaryTree auxTree, int num) {
		if (auxTree == null) { // Seta o nó raiz
			auxTree = new BinaryTree();
			auxTree.valor = num;
			auxTree.left = null;
			auxTree.right = null;
		} else if (num < auxTree.valor) { // valor a inserir < valor do nó raiz atual
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
			System.out.println("Valor do Nó:" + auxTree.valor);
			imprimir(auxTree.right);
		}
	}

	// Soma dos nós subsequentes
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
			System.out.println("Valor(es) informado não é um número:\n");
			return false;
		}
	}

}
