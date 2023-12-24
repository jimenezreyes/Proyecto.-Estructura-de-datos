/**
 * Clase Jugador
 * @author Juan Daniel San Martin Macias, 318181637
 * @author Jimenez Reyes Abraham, 318230577
 * @version 5 de octubre 2022.
 * @since Estructuras de datos 2023-1.
 */
public class Jugador{
	
	/* El nombre del jugador */
	private String nombre;
	/* Monedas para los jugadores */
	private int monedas;
	/*Modificador para colocar en una casilla */
	private String modificador;
	/*Arreglo de cartas de camello */
	public String[] cartasDeCamello = new String[5];
	/*Modificador colocado en una casilla */
	private boolean modificadorPuesto = false;
	/*Arreglo de cartas de apuesta */
	private String[] cartasDeApuesta = new String[5];
	/*Etiqueta del jugador */
	private String etiqueta;

	/**
	 * Constuctor de los jugadores
	 */
	public Jugador(){
		this.monedas = 3;
		
		String camelloRojo =  "\u001B[41m" + "🐫 " +"\u001B[0m";
		String camelloVerde = "\u001B[42m"+ "🐫 " +"\u001B[0m";
		String camelloAmarillo = "\u001B[43m"+ "🐫 " +"\u001B[0m";
		String camelloAzul = "\u001B[44m"+ "🐫 " +"\u001B[0m";
		String camelloMorado = "\u001B[45m"+ "🐫 " +"\u001B[0m";
		cartasDeCamello[0] = camelloRojo;
		cartasDeCamello[1] = camelloVerde;
		cartasDeCamello[2] = camelloAmarillo;
		cartasDeCamello[3] = camelloAzul;
		cartasDeCamello[4] = camelloMorado;

		cartasDeApuesta[0] = camelloRojo;
		cartasDeApuesta[1] = camelloVerde;
		cartasDeApuesta[2] = camelloAmarillo;
		cartasDeApuesta[3] = camelloAzul;
		cartasDeApuesta[4] = camelloMorado;

	}

	/**
	 * Metodo que verifica si tenemos cartas de camello 
	 * @return true or false
	 */
	public boolean noCartas(){
		int bandera = 0;
		for (int i = 0; i < cartasDeCamello.length; i++) {
			if (cartasDeCamello[i].equals("")) {
				bandera++;
			}
		}
		return bandera == cartasDeCamello.length - 1;
	}

	/**
	 * Método que se encarga de regresar las monedas del Jugador
	 * @return las monedas del jugador
	 */
	public int getMonedas(){
		return this.monedas;
	}

	/**
	 * Método que se encarga de asignar las nuevas monedas del jugador
	 * @param monedas las nuevas monedas del Jugador
	 */
	public void setMonedas(int monedas){
		if (this.monedas + monedas < 0) {
			this.monedas = 0;
		}else{
			this.monedas = monedas;
		}
	}

	/**
	 * Método que se encarga de regresar la etiqueta del jugador
	 * @return la etiqueta del Jugador
	 */
	public String getEtiqueta(){
		return this.etiqueta;
	}

	/**
	 * Método que se encarga de asignar la nueva etiqueta del jugador
	 * @param etiqueta la nueva etiqueta del Jugador
	 */
	public void setEtiqueta(String etiqueta){
		this.etiqueta = etiqueta;
	}

	/**
	 * Método que se encarga de regresar el nombre del jugador
	 * @return el nombre del Jugador
	 */
	public String getNombre(){
		return this.nombre;
	}

	/**
	 * Método que se encarga de regresar el modificador del jugador
	 * @return la etiqueta del Jugador
	 */
	public String getModificador(){
		return this.modificador;
	}

	/**
	 * Método que se encarga de regresar la bandera que verifica si está puesto el modificador o no
	 * @return True si está puesta, false en otro caso.
	 */
	public boolean getBanderaModificador(){
		return this.modificadorPuesto;
	}

	/**
	 * Método que se encarga de asignar true cuando el modificador esté puesto
	 * @param bandera el nuevo estado del modificador, true si está puesto, false en otro caso.
	 */
	public void setBanderaPuesta(boolean bandera){
		this.modificadorPuesto = bandera;
	}

    /**
	 * Método que se encarga de asignar el nombre del jugador
	 * @param nombre el nuevo nombre del Jugador
	 */
	public String setNombre (String nombre){
		return this.nombre = nombre;
	}

	/**
	 * Método que se encarga de asignar el nuevo modificador del jugador
	 * @param modificador el nuevo modificador del Jugador
	 */
	public String setModificador(String modificador){
		return this.modificador = modificador;
	}

	/**
	 * Método encargado de regresar de una forma acomodada una arreglo
	 * @param arreglo el arreglo a acomodar
	 * @return el arreglo en forma de String
	 */
	private String auxiliarArreglo(String[] arreglo){
		String aux = "[ ";
		for (String s: arreglo) {
			if (s != null) 
				aux += s + " ";
		}
		return aux + "]";
	}

	/**
	 * Método que coloca el modificador del Jugador
	 * @param opcion opcion del modificador, es decir, si es de avance o retroceso
	 * @param t el tablero donde se colocará el modificador
	 * @param posicion la posicion donde se pondrá el modificador
	 * @return true si el modificador se puso, false en cualquier otro caso
	 */
	public boolean colocarModificador(int opcion, Tablero t, int posicion){
		if (this.modificadorPuesto) {
			System.out.println("********YA COLOCASTE TU MODIFICADOR********");
			System.out.println(" ");
			return false;
		}
		else{
			//Identificar si se pone un modificador de avance o retroceso dependiendo de opcion
			if (opcion == 1) {
				this.setModificador(this.getEtiqueta() + "→" );
			}
			else{
				this.setModificador("←" + this.getEtiqueta());
			}

			String[][] pista = t.getPista();


			//Si se colocará el modificador en la primer casilla
			if (posicion == 0) {
				if (pista[posicion][1].equals(" ■ ") && pista[posicion +1][1].equals(" ■ ") && pista[posicion][2].equals("   ") && pista[posicion +1][2].equals("   ") ) {
					pista[posicion][1] = this.getModificador();
					this.modificadorPuesto = true;
					return true;
				}else{
					System.out.println("********NO SE PUEDE COLOCAR UN MODIFICADOR AHI********");
					return false;
				}
			}

			//Si se colocará el modificador en la última casilla
			else if(posicion == pista.length - 1){
				if (pista[posicion][1].equals(" ■ ") && pista[posicion - 1][1].equals(" ■ ") && pista[posicion][2].equals("   ") && pista[posicion - 1][2].equals("   ") ) {
					pista[posicion][1] = this.getModificador();
					this.modificadorPuesto = true;
					return true;
				}else{
					System.out.println("********NO SE PUEDE COLOCAR UN MODIFICADOR AHI********");
					return false;
				}
			}

			//Si no es ni la primera ni última casilla donde se colocará el modificador
			else{
				if (pista[posicion - 1][1].equals(" ■ ") && pista[posicion][1].equals(" ■ ") && pista[posicion +1][1].equals(" ■ ")) {
					pista[posicion][1] = this.getModificador();
					this.modificadorPuesto = true;
					return true;
				}else{
					System.out.println("********NO SE PUEDE COLOCAR UN MODIFICADOR AHI********");
					return false;
				}
			}
		}
	}

	/**
	 * Método que regresa los atributos del Jugador en forma de cadena
	 * @return la cadena de los atributos
	 */
	public String toString(){
		return "monedas = " + this.monedas + "\n" +
		       "Cartas de Camello disponibles: " + auxiliarArreglo(this.cartasDeCamello);
	}
}