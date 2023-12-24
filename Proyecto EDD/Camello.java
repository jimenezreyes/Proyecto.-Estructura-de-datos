import java.util.Random;

/**
 * Clase Camello
 * @author Juan Daniel San Martin Macias, 318181637
 * @author Jimenez Reyes Abraham, 318230577
 * @version 5 de octubre 2022.
 * @since Estructuras de datos 2023-1.
 */
public class Camello{
	/* El resultado del dado */
	private int resultadoDado;
	/*El color del camello */
	private String color;
	/*Movimiento del camello hacia alado */
	private int posicionX = 0;
	/* El movimiento del camello cuando esta en el tope */
	private int posicionY = 0;
	/* La antigua posicion */
	private int posicionYA = 0;
	/*El camello que esta en el tope */
	private Camello tope = null;

	/*La pila de apuestas */
	private Stack<Integer> pilaApuesta = new Stack<Integer>();
	/*Lista de las apuestas */
	public DoubleLinkedList<String> pilaRonda = new DoubleLinkedList<String>();
	public DoubleLinkedList<String> pilaCarreraG = new DoubleLinkedList<String>();
	public DoubleLinkedList<String> pilaCarreraP = new DoubleLinkedList<String>();
	/**
	 * Constructor de Camellos
	 * @param color el color del camello a crear, debe ser una Strign del tipo 
	 * definido para cambair color al momento de imprimir en terminal (cambiar el fondo).
	 */
	public Camello(String color){
		this.color = color;
	}

	/*
	 * Metodo que indica que camello va ganando la carrera
	 * @param ca1 es el primer camello
	 * @param ca2 es el segundo camello
	 * @param ca3 es el tercer camello
	 * @param c4 es el cuarto camello
	 * @return false
	 */
	public boolean vaPrimero(Camello ca1, Camello ca2, Camello ca3, Camello ca4){
		if (this.posicionX >= ca1.getPosicionX() && this.getPosicionY() > ca1.getPosicionY()) {
			if (this.posicionX >= ca2.getPosicionX() && this.getPosicionY() > ca2.getPosicionY()) {
				if (this.posicionX >= ca3.getPosicionX() && this.getPosicionY() > ca3.getPosicionY()) {
					if (this.posicionX >= ca4.getPosicionX() && this.getPosicionY() > ca4.getPosicionY()) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/*
	 * Metodo que indica que camello va perdiendo
	 * @param ca1 el primer camello
	 * @param ca2 el segundo camello
	 * @param ca3 el tercer camello
	 * @param ca4 el cuarto camello
	 * return false
	 */
	public boolean vaUltimo(Camello ca1, Camello ca2, Camello ca3, Camello ca4){
		if (this.posicionX <= ca1.getPosicionX() && this.getPosicionY() < ca1.getPosicionY()) {
			if (this.posicionX <= ca2.getPosicionX() && this.getPosicionY() < ca2.getPosicionY()) {
				if (this.posicionX <= ca3.getPosicionX() && this.getPosicionY() < ca3.getPosicionY()) {
					if (this.posicionX <= ca4.getPosicionX() && this.getPosicionY() < ca4.getPosicionY()) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Método que se encarga de tirar un resultado al azar entre 1, 2 y 3
	 * @return el número que avanzará el Camello
	 */
	public int tirarDado(){
		this.resultadoDado = 0;
		DoubleLinkedList<Integer> posiblesResultados = new DoubleLinkedList<Integer>();
		posiblesResultados.add(0, 1);
		posiblesResultados.add(1, 2);
		posiblesResultados.add(2, 3);
		Random numero = new Random();
		this.resultadoDado = posiblesResultados.get(numero.nextInt(posiblesResultados.size()));
		this.setPosicionX(resultadoDado);
		return resultadoDado;
	}

	/* 
	 * Metodo que regresa la pila de apuesta de los camellos
	 * @retrun la pila de apuesta 
	 */
	public Stack<Integer> getPilaApuesta(){
		return this.pilaApuesta;
	}

	/*
	 * Metodo para imprimir la pila
	 * @return pila acomodada
	 */
	public void imprimirPila(){
		System.out.print("[ " +this.toString() + " :");
		if(this.pilaApuesta.isEmpty()){
			System.out.print("- ]");
		}
		else{
			this.pilaApuesta.show();
			System.out.print(" ]");
		}
	}

	/**
	 * Método que regresa al camello del color dado en forma de cadena
	 * @return el Camello en forma de cadena, con el color dado desde un inicio.
	 */
	public String toString(){
		return this.color +  "🐫 " +"\u001B[0m";
	}
	/*
	 * Metodo que regresa la posicionx de los lados
	 * @return la posicionx de los lados
	 */
	public int getPosicionX(){
		return this.posicionX;
	}

	/*
	 * Metodo que asigna la posicion del camello a los lados
	 * @param posicion, la posicion que se movio
	 * @return posicion avanzada
	 */
	public void setPosicionX(int posicion){
		if (this.posicionX + posicion >= 17) {
			this.posicionX = 17;
		}else{
			this.posicionX += posicion;
		}
	}

	/*
	 * Metodo que asigana la posicion cuando un camello esta en el tope
	 * @param posicion, la posicion que avanza
	 * @return posicion que avanzo
	 */
	public void setPosicionTope(int posicion){
		this.posicionX = posicion;
	}

	/*
	 * Metodo que regresa la posicion de un camello arriba de otro
	 * @return posicionY
	 */
	public int getPosicionY(){
		return this.posicionY;
	}

	/*
	 * Metodo para saber que camello esta en el tope
	 * @param t, el tablero donde se encuentran
	 * @param caAzul, el camello azul
	 * @param caRojo, el camello rojo
	 * @param caAmarrillo, el camello amarillo
	 * @param caVerde, el camello verde
	 * @param caMorado, el camello morado
	 * @return el tope 
	 */
	public Camello getTope(Tablero t, Camello caAzul, Camello caRojo, Camello caAmarillo, Camello caVerde, Camello caMorado){
		regresaTope(t, caAzul,  caRojo, caAmarillo,caVerde,caMorado);	
		return this.tope;
	}

	/*
	 * Metodo que regresa al tope
	 * @param t, el tablero donde se encuentran
	 * @param caAzul, el camello azul
	 * @param caRojo, el camello rojo
	 * @param caAmarillo, el camello amarillo
	 * @param caVerde, el camello verde
	 * @param caMorado, el camello morado
	 * @return el camello que se encuentre en ese instante
	 */
	private void regresaTope(Tablero t, Camello caAzul, Camello caRojo, Camello caAmarillo, Camello caVerde, Camello caMorado){
    	String [][] pista = t.getPista();
    	if (this.tope != null) {
    	   	this.setTope(null);	
    	}
		if(this.getPosicionX() > 0 && this.getPosicionY() < 7){
			String posicion = pista[this.getPosicionX()- 1][this.getPosicionY() + 1];
    	    
    	 	        switch(posicion){
				        case "\u001B[41m" +  "🐫 " +"\u001B[0m": //Caso en el que se rojo
					        this.setTope(caRojo);
					        break;
				        case "\u001B[42m" +  "🐫 " +"\u001B[0m": //Caso en el que se verde
					        this.setTope(caVerde);
		        	        break;
				        case "\u001B[43m" +  "🐫 " +"\u001B[0m": //Caso en el que se amarillo
					        this.setTope(caAmarillo);
					        break;
				        case "\u001B[44m" +  "🐫 " +"\u001B[0m": //Caso en el que se azul
					        this.setTope(caAzul);
	  		                break;
				        case "\u001B[45m" +  "🐫 " +"\u001B[0m": //Caso en el que se morado
					        this.setTope(caMorado);
					        break;
					    case "   ":
					    	this.setTope(null);
					    	break;
		    }
		}
    }

	/*
	 * Metodo que asigna el tope del camello
	 * @param tope
	 * @return el tope del camello 
	 */
	public void setTope(Camello tope){
		this.tope = tope;
	}

	/*
	 * Metodo que asigna la posicion encima de los camellos
	 * @param posicion
	 * @return posicion encima de un camello
	 */
	public void setPosicionY(int posicion){
		this.posicionY = posicion;
	}

	/*
	 * Metodo que asigna la posicion antigua de un camello
	 * @param posicion, la posicion antigua de un camello
	 * @return posicion, la posicion donde estaba el camello
	 */
	public void setPosicionYAntigua(int posicion){
		this.posicionYA = posicion;
	}
	/*
	 * Metodo que se encarga de regresar la posicion antigua del camello
	 * @return la posicion antigua del camello
	 */
	public int getPosicionYAntigua(){
		return this.posicionYA;
	}

	/**
	 * Método que se encarga de regresar el color del Camello
	 * @return el color del Camello
	 */
	public String getColor(){
		return this.color;
	}

}