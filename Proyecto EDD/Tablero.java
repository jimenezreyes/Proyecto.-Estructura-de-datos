/**
 * Clase Tablero
 * @author Juan Daniel San Martin Macias, 318181637
 * @author Jimenez Reyes Abraham, 318230577
 * @version 5 de octubre 2022.
 * @since Estructuras de datos 2023-1.
 */
public class Tablero {
	/* La pista para el tablero */
	private String pista [][] = new String[17][8];

	/**
	 * Constructor de Tableros
	 */
	public Tablero(){

		for (int k = 0; k < pista.length ;k++) {
			pista[k][1] = " ■ ";
		}

		for (int l = 0; l < pista.length ;l++) {
			String s = String.valueOf(l+1);
			if (l < 9) {
			    pista[l][0] = "  " + s;
			}else {
				pista[l][0] = " " + s;
			}
		}

		for (int i = 0; i < pista.length ;i++) {
			for (int j = 2; j < pista[i].length; j++) {
				pista[i][j] = "   ";
			}
		}

		pista[16][0] = " 🏁";
	}

	/**
	 * Metodo que imprime el tablero en el formato que se necesita
	 */
	public void imprimirPista(){
		for (int i = pista[0].length - 1; i >= 0; i--) {
			for (int j = 0; j < pista.length; j++) {
				System.out.print("|" + pista[j][i] + "|");
			}
			System.out.println(" ");
		}
	}

	/**
	 * Regresa el arreglo bidimensional que cosntruye el tablero
	 * @return el arreglo bidimensional que cosntruye el tablero
	 */
	public String[][] getPista(){
		return this.pista;
	}
}