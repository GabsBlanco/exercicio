public class Sudoku {
	private int[][] matriz = new int[9][9];

	public boolean definir(int linha, int coluna, int valor) {
		boolean ok = false;
		
		if (matriz[linha - 1][coluna - 1] == 0 
			&& valor > 0 
			&& valor < 10 
			&& validarLinha(linha, valor) 
			&& validarColuna(coluna, valor)
			&& validarRegiao(valor)) {
			matriz[linha - 1][coluna - 1] = valor;
			ok = true;
		}
		
		return ok;
	}
	
	public boolean validarLinha(int linha, int valor) {
		for(int i = 0; i < matriz[linha - 1].length; i++){
			if(matriz[linha - 1][i] == valor) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean validarColuna(int coluna, int valor) {
		for(int i = 0; i < matriz.length; i++){
			if(matriz[i][coluna - 1] == valor) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean validarRegiao(int valor) {
		for(int linha = 0; linha < 3; linha++) {
			for(int coluna = 0; coluna < 3; coluna++) {
				for(int i = 0 + (linha * 3); i < 3 + (linha * 3); i++ ){
					for(int j = 0 + (coluna * 3); j < 3 + (coluna * 3); j++) {
						if(matriz[i][j] == valor) {
							return false;
						}
					}
				}
			}
		}
		
		return true;
	}
	
	public void definirLinha(int linha, int[] colunas) {
		matriz[linha - 1] = colunas;
	}
	
	public int pegarValor(int linha, int coluna) {
		return matriz[linha - 1][coluna - 1];
	}
	
	public void imprimir() {
		System.out.println();
		for(int linha = 0; linha < matriz.length; linha++) {
			for(int coluna = 0; coluna < matriz[linha].length; coluna++) {
				System.out.print(matriz[linha][coluna] + " ");
			}
			System.out.println();
		}
	}
}
