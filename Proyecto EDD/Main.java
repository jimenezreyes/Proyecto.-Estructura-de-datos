import java.util.Scanner;
import java.util.Random;

/**
 * Clase Principal
 * @author Juan Daniel San Martin Macias, 318181637
 * @author Jimenez Reyes Abraham, 318230577
 * @version 5 de octubre 2022.
 * @since Estructuras de datos 2023-1.
 */
public class Main{

	/*Crea un nuevo tablero */
	private static Tablero t = new Tablero();
	/*Crea una nueva pista */
	private static String [][] pista = t.getPista();
	
	//Camellos por colores 
	private static Camello caAzul = new Camello("\u001B[44m");
	private static Camello caAmarillo = new Camello("\u001B[43m");
	private static Camello caRojo = new Camello("\u001B[41m");
	private static Camello caVerde = new Camello("\u001B[42m");
	private static Camello caMorado = new Camello("\u001B[45m");

	public static void main(String[] args) {
		System.out.println("***Bienvenido a Camel UP***");
		System.out.println("Número de jugadores");
		int opcionJugadores = auxiliar(2,6);
		Scanner in = new Scanner(System.in);
		int flag;
		String nombre;
		switch(opcionJugadores){
			case 2:
			    Jugador J21 = new Jugador();
			    Jugador J22 = new Jugador();
			    Jugador jugadores2 [] = {J21, J22};
			    flag = 1;
			    for (Jugador j : jugadores2) {
			    	System.out.println("Ingresa el nombre del jugador " + flag);
			    	nombre = in.nextLine();
			    	j.setNombre(nombre);
			    	j.setEtiqueta("J"+ flag);
			    	flag++;
			    }
			    partida(jugadores2);	
				break;

			case 3:	
			    Jugador J31 = new Jugador();
			    Jugador J32 = new Jugador();
			    Jugador J33 = new Jugador();
			    Jugador jugadores3 [] = {J31, J32, J33};
			    flag = 1;
			    for (Jugador j : jugadores3) {
			    	System.out.println("Ingresa el nombre del jugador " + flag);
			    	nombre = in.nextLine();
			    	j.setNombre(nombre);
			    	j.setEtiqueta("J"+ flag);
			    	flag++;
			    }
			    partida(jugadores3);					
				break;

			case 4:	
			    Jugador J41 = new Jugador();
			    Jugador J42 = new Jugador();
			    Jugador J43 = new Jugador();
			    Jugador J44 = new Jugador();
			    Jugador jugadores4 [] = {J41, J42, J43,J44};
			    flag = 1;
			    for (Jugador j : jugadores4) {
			    	System.out.println("Ingresa el nombre del jugador " + flag);
			    	nombre = in.nextLine();
			    	j.setNombre(nombre);
			    	j.setEtiqueta("J"+ flag);
			    	flag++;
			    }
			    partida(jugadores4);				
				break;

			case 5:	
			    Jugador J51 = new Jugador();
			    Jugador J52 = new Jugador();
			    Jugador J53 = new Jugador();
			    Jugador J54 = new Jugador();
			    Jugador J55 = new Jugador();
			    Jugador jugadores5 [] = {J51, J52, J53,J54,J55};
			    flag = 1;
			    for (Jugador j : jugadores5) {
			    	System.out.println("Ingresa el nombre del jugador " + flag);
			    	nombre = in.nextLine();
			    	j.setNombre(nombre);
			    	j.setEtiqueta("J"+ flag);
			    	flag++;
			    }
			    partida(jugadores5);						
				break;

			case 6:
				Jugador J61 = new Jugador();
			    Jugador J62 = new Jugador();
			    Jugador J63 = new Jugador();
			    Jugador J64 = new Jugador();
			    Jugador J65 = new Jugador();
			    Jugador J66 = new Jugador();
			    Jugador jugadores6 [] = {J61, J62, J63,J64,J65,J66};
			    flag = 1;
			    for (Jugador j : jugadores6) {
			    	System.out.println("Ingresa el nombre del jugador " + flag);
			    	nombre = in.nextLine();
			    	j.setNombre(nombre);
			    	j.setEtiqueta("J"+ flag);
			    	flag++;
			    }
			    partida(jugadores6);
			}
			/* 
			Jugador j1 = new Jugador();
			j1.setNombre("a");
			j1.setEtiqueta("J1");
			Jugador j2 = new Jugador();
			j2.setNombre("b");
			j2.setEtiqueta("J2");
			Jugador [] jugadores = {j1, j2};
			partida(jugadores);
			*/
	}

	/**
	 * Método que se encargade isntanciar las cosas necesarias para la partida
	 * @param jugadores arreglo de los jugadores de la partida
	 */
	private static void partida(Jugador jugadores []){

		//Creación de arreglo donde se pondrá los tiros de la ronda
		String arregloDeTiros [] = new String[5];

		//Creación de la lista donde se escogerá al azar el dado del camello
		Camello[] arregloDeCamellos = new Camello[5];
		//************************************************************************Afuera de la ronda para no estar inicializando siempre lo sucedido**************

		//Inicio de la partida
		arregloDeCamellos[0] = caAzul;
		arregloDeCamellos[1] = caAmarillo;
		arregloDeCamellos[2] = caRojo;
		arregloDeCamellos[3] = caVerde;
		arregloDeCamellos[4] = caMorado;
		rondaUno(arregloDeCamellos, arregloDeTiros);

		while (pista[16][2].equals("   ")) {
			for (Jugador jug : jugadores) {
				jug.setBanderaPuesta(false);
			}
			for (int i = 0; i < pista.length ; i++) {
				pista[i][1] = " ■ ";
			}
			/*Cartas de apuesta para el camello rojo */
		    caRojo.getPilaApuesta().clear();
		    caRojo.pilaRonda.clear();
		    caRojo.getPilaApuesta().push(-1);
		    caRojo.getPilaApuesta().push(1);
		    caRojo.getPilaApuesta().push(2);
		    caRojo.getPilaApuesta().push(5);

			/*Cartas de apuesta para el camello verde */
		    caVerde.getPilaApuesta().clear();
		    caVerde.pilaRonda.clear();
		    caVerde.getPilaApuesta().push(-1);
		    caVerde.getPilaApuesta().push(1);
		    caVerde.getPilaApuesta().push(2);
		    caVerde.getPilaApuesta().push(5);

			/*Cartas de apuesta para el camello amarillo */
		    caAmarillo.getPilaApuesta().clear();
		    caAmarillo.pilaRonda.clear();
		    caAmarillo.getPilaApuesta().push(-1);
		    caAmarillo.getPilaApuesta().push(1);
		    caAmarillo.getPilaApuesta().push(2);
		    caAmarillo.getPilaApuesta().push(5);

			/*Cartas de apuesta para el camello azul */
		    caAzul.getPilaApuesta().clear();
		    caAzul.pilaRonda.clear();
		    caAzul.getPilaApuesta().push(-1);
		    caAzul.getPilaApuesta().push(1);
		    caAzul.getPilaApuesta().push(2);
		    caAzul.getPilaApuesta().push(5);


			/*Cartas de apuesta para el camello morado */
		    caMorado.getPilaApuesta().clear();
		    caMorado.pilaRonda.clear();
		    caMorado.getPilaApuesta().push(-1);
		    caMorado.getPilaApuesta().push(1);
		    caMorado.getPilaApuesta().push(2);
		    caMorado.getPilaApuesta().push(5);




			Jugador jugadoresInvertido [] = new Jugador [jugadores.length];
			int indice = 0;
			for (int j = jugadores.length - 1;j > -1 ;j--) {
				jugadoresInvertido[indice] = jugadores[j];
				indice++;
			}

			Turno(jugadoresInvertido,arregloDeCamellos, arregloDeTiros);

			for (int h = 0;h < jugadores.length ;h++) {
				jugadoresInvertido[h] = jugadores[h];
			}

		}
		darRecompensasPartida(jugadores);
		darRecompensasPartidaPerdida(jugadores);
		for (int k = 0; k < jugadores.length ; k++) {
			System.out.println(" ");
			System.out.println("Número de monedas de "+ jugadores[k].getNombre() + " al final de la partida: " + jugadores[k].getMonedas());
			System.out.println(" ");
		}
		System.out.println("El ganador es: " + jugadores[regresaGanador(jugadores)]);
	}

	/**
	 * Método que se encarga de instanciar la ronda Uno de la partida
	 * @param arregloDeCamellos arreglo de los camellos de la partida
	 * @param arregloDeTiros arreglo que tiene los tiros de los camellos
	 */
	private static void rondaUno(Camello[] arregloDeCamellos, String arregloDeTiros []){
		for (int i = 0;i <=  arregloDeCamellos.length; i++) {
			Camello ca = elegirCamelloRandom(arregloDeCamellos);
			agregaDadosTirados(ca, arregloDeTiros);	
			
		}
		imprimeDadosTirados(arregloDeTiros);
		t.imprimirPista();
	}

	/**
	 * Método que se encarga de preguntar a los jugadores sus movimientos
	 * @param jugadores arreglo de los jugadores en la partida
	 * @param arregloDeCamellos arreglo de los camellos de la partida
	 * @param t el tablero donde se está jugando
	 * @param arregloDeTiros arreglo que tiene los tiros de los camellos
	 */
	private static void Turno(Jugador[] jugadores, Camello [] arregloDeCamellos, String arregloDeTiros []){

		for (int i = 0; i < arregloDeTiros.length; i++) {
			arregloDeTiros[i] = null;
		}

		if (ceroCamellosDisponibles(arregloDeCamellos)) {
			arregloDeCamellos[0] = caAzul;
			arregloDeCamellos[1] = caAmarillo;
			arregloDeCamellos[2] = caRojo;
			arregloDeCamellos[3] = caVerde;
			arregloDeCamellos[4] = caMorado;
		}

		int bandera = 0;
		while(bandera < 5){
			if (pista[16][2].equals("   ")) {
				for (Jugador j: jugadores ) {
					System.out.println(" ");
					System.out.println("Turno de " + j.getEtiqueta() + ": " + j.getNombre());
					System.out.println(j.toString());
					System.out.println(" ");
					System.out.println("Elige una opción: ");
					System.out.println("1- Tirar un dado");
					System.out.println("2- Colocar modificador");
					System.out.println("3- Apostar ganador de la ronda");
					System.out.println("4- Apostar ganador de la carrera");
					System.out.println("5- Apostar perdedor de la carrera");
					int opcion = auxiliar(1,5);
					if (opcion == 1) {
						bandera++;
					}
					Camello ca;
					switch (opcion) {
					case 1:
						ca = elegirCamelloRandom(arregloDeCamellos);
						agregaDadosTirados(ca, arregloDeTiros);
						imprimeDadosTirados(arregloDeTiros);
						System.out.print("Apuestas Restantes: (");
				        imprimirApuestasRestantes();
						t.imprimirPista();
						System.out.println(" ");
						System.out.println(j.getNombre() + " recibió una moneda");
						System.out.println(" ");
						j.setMonedas(j.getMonedas() + 1);	
						break;
					case 2:
						System.out.println("¿Qué tipo de modificador quieres poner?");
						System.out.println("1- Avance");
						System.out.println("2- retroceso");
						int modi = auxiliar(1,2);
						System.out.println(" ");
						System.out.println("¿En qué posición quieres colocarlo?");
						int pos = auxiliar(1,16);
						System.out.println(" ");
						boolean chequeo = j.colocarModificador(modi, t, pos -1);
						t.imprimirPista();
						break;
					case 3:
						apostar(j, 1);
						break;
					case 4:
						if (j.noCartas()) {
							System.out.println("Ya no tienes cartas disponibles");
						}else{
							apostar(j, 2);
						}
						break;
					case 5:
						if (j.noCartas()) {
							System.out.println("Ya no tienes cartas disponibles");
						}else{
							apostar(j, 3);
						}
						break;
					}
				}	
			}
			else{
				darRecompensas(jugadores);
				break;
			}
		}
		if (pista[16][2].equals("   ")) {
			darRecompensas(jugadores);
		}
	}
	private static void darRecompensasPartidaPerdida(Jugador[] jugadores){
		for (Jugador j : jugadores) {
			if(caRojo.vaUltimo(caAzul, caAmarillo,caVerde,caMorado)){
				for (int i = 0; i < caRojo.pilaCarreraP.size() ; i++) {
					if (caRojo.pilaCarreraP.get(i).equals(j.getEtiqueta())) {
						switch (i) {
						case 0:
							j.setMonedas(j.getMonedas() + 8);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 8 monedas");
							System.out.println(" ");
							break;
						case 1:
							j.setMonedas(j.getMonedas() + 5);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 5 monedas");
							System.out.println(" ");
							break;
						case 2:
							j.setMonedas(j.getMonedas() + 3);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 3 monedas");
							System.out.println(" ");
							break;
						case 3:
							j.setMonedas(j.getMonedas() + 2);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 2 monedas");
							System.out.println(" ");
							break;
						default:
							j.setMonedas(j.getMonedas() + 1);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 1 moneda");
							System.out.println(" ");
							break;

						}
					}
				}
				quitarRecompensasPartidaP(j, caAzul,caAmarillo,caVerde,caMorado);

			}else if(caVerde.vaUltimo(caAzul,  caRojo, caAmarillo,caMorado)){
				for (int i = 0; i < caVerde.pilaCarreraP.size() ; i++) {
					if (caVerde.pilaCarreraP.get(i).equals(j.getEtiqueta())) {
						switch (i) {
						case 0:
							j.setMonedas(j.getMonedas() + 8);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 8 monedas");
							System.out.println(" ");
							break;
						case 1:
							j.setMonedas(j.getMonedas() + 5);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 5 monedas");
							System.out.println(" ");
							break;
						case 2:
							j.setMonedas(j.getMonedas() + 3);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 3 monedas");
							System.out.println(" ");
							break;
						case 3:
							j.setMonedas(j.getMonedas() + 2);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 2 monedas");
							System.out.println(" ");
							break;
						default:
							j.setMonedas(j.getMonedas() + 1);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 1 moneda");
							System.out.println(" ");
							break;

						}
					}
				}
				quitarRecompensasPartidaP(j, caAzul,  caRojo, caAmarillo,caMorado);

			}else if(caAmarillo.vaUltimo(caAzul,  caRojo,caVerde,caMorado)){
				for (int i = 0; i < caAmarillo.pilaCarreraP.size() ; i++) {
					if (caAmarillo.pilaCarreraP.get(i).equals(j.getEtiqueta())) {
						switch (i) {
						case 0:
							j.setMonedas(j.getMonedas() + 8);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 8 monedas");
							System.out.println(" ");
							break;
						case 1:
							j.setMonedas(j.getMonedas() + 5);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 5 monedas");
							System.out.println(" ");
							break;
						case 2:
							j.setMonedas(j.getMonedas() + 3);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 3 monedas");
							System.out.println(" ");
							break;
						case 3:
							j.setMonedas(j.getMonedas() + 2);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 2 monedas");
							System.out.println(" ");
							break;
						default:
							j.setMonedas(j.getMonedas() + 1);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 1 moneda");
							System.out.println(" ");
							break;

						}
					}
				}
				quitarRecompensasPartidaP(j,caAzul,  caRojo,caVerde,caMorado);

			}else if(caAzul.vaUltimo(caRojo, caAmarillo,caVerde,caMorado)){
				for (int i = 0; i < caAzul.pilaCarreraP.size() ; i++) {
					if (caAzul.pilaCarreraP.get(i).equals(j.getEtiqueta())) {
						switch (i) {
						case 0:
							j.setMonedas(j.getMonedas() + 8);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 8 monedas");
							System.out.println(" ");
							break;
						case 1:
							j.setMonedas(j.getMonedas() + 5);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 5 monedas");
							System.out.println(" ");
							break;
						case 2:
							j.setMonedas(j.getMonedas() + 3);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 3 monedas");
							System.out.println(" ");
							break;
						case 3:
							j.setMonedas(j.getMonedas() + 2);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 2 monedas");
							System.out.println(" ");
							break;
						default:
							j.setMonedas(j.getMonedas() + 1);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 1 moneda");
							System.out.println(" ");
							break;

						}
					}
				}
				quitarRecompensasPartidaP(j,caRojo, caAmarillo,caVerde,caMorado);

			}else if(caMorado.vaUltimo(caAzul,  caRojo, caAmarillo,caVerde)){
				for (int i = 0; i < caMorado.pilaCarreraP.size() ; i++) {
					if (caMorado.pilaCarreraP.get(i).equals(j.getEtiqueta())) {
						switch (i) {
						case 0:
							j.setMonedas(j.getMonedas() + 8);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 8 monedas");
							System.out.println(" ");
							break;
						case 1:
							j.setMonedas(j.getMonedas() + 5);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 5 monedas");
							System.out.println(" ");
							break;
						case 2:
							j.setMonedas(j.getMonedas() + 3);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 3 monedas");
							System.out.println(" ");
							break;
						case 3:
							j.setMonedas(j.getMonedas() + 2);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 2 monedas");
							System.out.println(" ");
							break;
						default:
							j.setMonedas(j.getMonedas() + 1);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 1 moneda");
							System.out.println(" ");
							break;

						}
					}
				}
				quitarRecompensasPartidaP(j,caAzul,  caRojo, caAmarillo,caVerde);
			}
		}
	}

	private static int regresaGanador(Jugador[] jugadores){
		int auxiliar = 0;
		int indice = 0;
		for (int i = 0; i < jugadores.length ; i++ ) {
			if (i == 0) {
				auxiliar = jugadores[i].getMonedas();
			}else{
				if (auxiliar <= jugadores[i].getMonedas()) {
					auxiliar = jugadores[i].getMonedas();
					indice = i;
				}
			}
		}
		return indice;
	}

	private static void quitarRecompensasPartidaP(Jugador j, Camello ca1, Camello ca2, Camello ca3, Camello ca4){
		for (int i = 0; i < ca1.pilaCarreraP.size() ; i++) {
			if (ca1.pilaCarreraP.get(i).equals(j.getEtiqueta())) {
				j.setMonedas(j.getMonedas() - 1);
				System.out.println(" ");
				System.out.println(j.getNombre() + " perdió 1 moneda");
				System.out.println(" ");
			}
		}

		for (int i1 = 0; i1 < ca2.pilaCarreraP.size() ; i1++) {
			if (ca2.pilaCarreraP.get(i1).equals(j.getEtiqueta())) {
				j.setMonedas(j.getMonedas() - 1);
				System.out.println(" ");
				System.out.println(j.getNombre() + " perdió 1 moneda");
				System.out.println(" ");
			}
		}

		for (int i2 = 0; i2 < ca3.pilaCarreraP.size() ; i2++) {
			if (ca3.pilaCarreraP.get(i2).equals(j.getEtiqueta())) {
				j.setMonedas(j.getMonedas() - 1);
				System.out.println(" ");
				System.out.println(j.getNombre() + " perdió 1 moneda");
				System.out.println(" ");
			}
		}

		for (int i3 = 0; i3 < ca4.pilaCarreraP.size() ; i3++) {
			if (ca4.pilaCarreraP.get(i3).equals(j.getEtiqueta())) {
				j.setMonedas(j.getMonedas() - 1);
				System.out.println(" ");
				System.out.println(j.getNombre() + " perdió 1 moneda");
				System.out.println(" ");
			}
		}
	}

	private static void darRecompensasPartida(Jugador[] jugadores){
		for (Jugador j : jugadores) {
			if(caRojo.vaPrimero(caAzul, caAmarillo,caVerde,caMorado)){
				for (int i = 0; i < caRojo.pilaCarreraG.size() ; i++) {
					if (caRojo.pilaCarreraG.get(i).equals(j.getEtiqueta())) {
						switch (i) {
						case 0:
							j.setMonedas(j.getMonedas() + 8);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 8 monedas");
							System.out.println(" ");
							break;
						case 1:
							j.setMonedas(j.getMonedas() + 5);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 5 monedas");
							System.out.println(" ");
							break;
						case 2:
							j.setMonedas(j.getMonedas() + 3);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 3 monedas");
							System.out.println(" ");
							break;
						case 3:
							j.setMonedas(j.getMonedas() + 2);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 2 monedas");
							System.out.println(" ");
							break;
						default:
							j.setMonedas(j.getMonedas() + 1);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 1 moneda");
							System.out.println(" ");
							break;

						}
					}
				}
				quitarRecompensasPartidaG(j, caAzul,caAmarillo,caVerde,caMorado);

			}else if(caVerde.vaPrimero(caAzul,  caRojo, caAmarillo,caMorado)){
				for (int i = 0; i < caVerde.pilaCarreraG.size() ; i++) {
					if (caVerde.pilaCarreraG.get(i).equals(j.getEtiqueta())) {
						switch (i) {
						case 0:
							j.setMonedas(j.getMonedas() + 8);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 8 monedas");
							System.out.println(" ");
							break;
						case 1:
							j.setMonedas(j.getMonedas() + 5);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 5 monedas");
							System.out.println(" ");
							break;
						case 2:
							j.setMonedas(j.getMonedas() + 3);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 3 monedas");
							System.out.println(" ");
							break;
						case 3:
							j.setMonedas(j.getMonedas() + 2);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 2 monedas");
							System.out.println(" ");
							break;
						default:
							j.setMonedas(j.getMonedas() + 1);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 1 moneda");
							System.out.println(" ");
							break;

						}
					}
				}
				quitarRecompensasPartidaG(j, caAzul,  caRojo, caAmarillo,caMorado);

			}else if(caAmarillo.vaPrimero(caAzul,  caRojo,caVerde,caMorado)){
				for (int i = 0; i < caAmarillo.pilaCarreraG.size() ; i++) {
					if (caAmarillo.pilaCarreraG.get(i).equals(j.getEtiqueta())) {
						switch (i) {
						case 0:
							j.setMonedas(j.getMonedas() + 8);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 8 monedas");
							System.out.println(" ");
							break;
						case 1:
							j.setMonedas(j.getMonedas() + 5);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 5 monedas");
							System.out.println(" ");
							break;
						case 2:
							j.setMonedas(j.getMonedas() + 3);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 3 monedas");
							System.out.println(" ");
							break;
						case 3:
							j.setMonedas(j.getMonedas() + 2);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 2 monedas");
							System.out.println(" ");
							break;
						default:
							j.setMonedas(j.getMonedas() + 1);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 1 moneda");
							System.out.println(" ");
							break;

						}
					}
				}
				quitarRecompensasPartidaG(j,caAzul,  caRojo,caVerde,caMorado);

			}else if(caAzul.vaPrimero(caRojo, caAmarillo,caVerde,caMorado)){
				for (int i = 0; i < caAzul.pilaCarreraG.size() ; i++) {
					if (caAzul.pilaCarreraG.get(i).equals(j.getEtiqueta())) {
						switch (i) {
						case 0:
							j.setMonedas(j.getMonedas() + 8);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 8 monedas");
							System.out.println(" ");
							break;
						case 1:
							j.setMonedas(j.getMonedas() + 5);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 5 monedas");
							System.out.println(" ");
							break;
						case 2:
							j.setMonedas(j.getMonedas() + 3);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 3 monedas");
							System.out.println(" ");
							break;
						case 3:
							j.setMonedas(j.getMonedas() + 2);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 2 monedas");
							System.out.println(" ");
							break;
						default:
							j.setMonedas(j.getMonedas() + 1);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 1 moneda");
							System.out.println(" ");
							break;

						}
					}
				}
				quitarRecompensasPartidaG(j,caRojo, caAmarillo,caVerde,caMorado);

			}else if(caMorado.vaPrimero(caAzul,  caRojo, caAmarillo,caVerde)){
				for (int i = 0; i < caMorado.pilaCarreraG.size() ; i++) {
					if (caMorado.pilaCarreraG.get(i).equals(j.getEtiqueta())) {
						switch (i) {
						case 0:
							j.setMonedas(j.getMonedas() + 8);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 8 monedas");
							System.out.println(" ");
							break;
						case 1:
							j.setMonedas(j.getMonedas() + 5);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 5 monedas");
							System.out.println(" ");
							break;
						case 2:
							j.setMonedas(j.getMonedas() + 3);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 3 monedas");
							System.out.println(" ");
							break;
						case 3:
							j.setMonedas(j.getMonedas() + 2);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 2 monedas");
							System.out.println(" ");
							break;
						default:
							j.setMonedas(j.getMonedas() + 1);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 1 moneda");
							System.out.println(" ");
							break;

						}
					}
				}
				quitarRecompensasPartidaG(j,caAzul,  caRojo, caAmarillo,caVerde);
			}
		}
	}

	private static void quitarRecompensasPartidaG(Jugador j, Camello ca1, Camello ca2, Camello ca3, Camello ca4){
		for (int i = 0; i < ca1.pilaCarreraG.size() ; i++) {
			if (ca1.pilaCarreraG.get(i).equals(j.getEtiqueta())) {
				j.setMonedas(j.getMonedas() - 1);
				System.out.println(" ");
				System.out.println(j.getNombre() + " perdió 1 moneda");
				System.out.println(" ");
			}
		}

		for (int i1 = 0; i1 < ca2.pilaCarreraG.size() ; i1++) {
			if (ca2.pilaCarreraG.get(i1).equals(j.getEtiqueta())) {
				j.setMonedas(j.getMonedas() - 1);
				System.out.println(" ");
				System.out.println(j.getNombre() + " perdió 1 moneda");
				System.out.println(" ");
			}
		}

		for (int i2 = 0; i2 < ca3.pilaCarreraG.size() ; i2++) {
			if (ca3.pilaCarreraG.get(i2).equals(j.getEtiqueta())) {
				j.setMonedas(j.getMonedas() - 1);
				System.out.println(" ");
				System.out.println(j.getNombre() + " perdió 1 moneda");
				System.out.println(" ");
			}
		}

		for (int i3 = 0; i3 < ca4.pilaCarreraG.size() ; i3++) {
			if (ca4.pilaCarreraG.get(i3).equals(j.getEtiqueta())) {
				j.setMonedas(j.getMonedas() - 1);
				System.out.println(" ");
				System.out.println(j.getNombre() + " perdió 1 moneda");
				System.out.println(" ");
			}
		}
	}

	private static void darRecompensas(Jugador[] jugadores){
		for (Jugador j : jugadores) {
			if(caRojo.vaPrimero(caAzul, caAmarillo,caVerde,caMorado)){
				for (int i = 0; i < caRojo.pilaRonda.size() ; i++) {
					if (caRojo.pilaRonda.get(i).equals(j.getEtiqueta())) {
						switch (i) {
						case 0:
							j.setMonedas(j.getMonedas() + 5);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 5 monedas");
							System.out.println(" ");
							break;
						case 1:
							j.setMonedas(j.getMonedas() + 2);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 2 monedas");
							System.out.println(" ");
							break;
						case 2:
							j.setMonedas(j.getMonedas() + 1);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 1 moneda");
							System.out.println(" ");
							break;
						case 3:
							j.setMonedas(j.getMonedas() - 1);
							System.out.println(" ");
							System.out.println(j.getNombre() + " perdió 1 moneda");
							System.out.println(" ");
							break;
						default:
							j.setMonedas(j.getMonedas() - 1);
							System.out.println(" ");
							System.out.println(j.getNombre() + " perdió 1 moneda");
							System.out.println(" ");
							break;

						}
					}
				}
				quitarRecompensas(j, caAzul,caAmarillo,caVerde,caMorado);

			}else if(caVerde.vaPrimero(caAzul,  caRojo, caAmarillo,caMorado)){
				for (int i = 0; i < caVerde.pilaRonda.size() ; i++) {
					if (caVerde.pilaRonda.get(i).equals(j.getEtiqueta())) {
						switch (i) {
						case 0:
							j.setMonedas(j.getMonedas() + 5);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 5 monedas");
							System.out.println(" ");
							break;
						case 1:
							j.setMonedas(j.getMonedas() + 2);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 2 monedas");
							System.out.println(" ");
							break;
						case 2:
							j.setMonedas(j.getMonedas() + 1);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 1 moneda");
							System.out.println(" ");
							break;
						case 3:
							j.setMonedas(j.getMonedas() - 1);
							System.out.println(" ");
							System.out.println(j.getNombre() + " perdió 1 moneda");
							System.out.println(" ");
							break;
						default:
							j.setMonedas(j.getMonedas() - 1);
							System.out.println(" ");
							System.out.println(j.getNombre() + " perdió 1 moneda");
							System.out.println(" ");
							break;

						}
					}
				}
				quitarRecompensas(j, caAzul,  caRojo, caAmarillo,caMorado);

			}else if(caAmarillo.vaPrimero(caAzul,  caRojo,caVerde,caMorado)){
				for (int i = 0; i < caAmarillo.pilaRonda.size() ; i++) {
					if (caAmarillo.pilaRonda.get(i).equals(j.getEtiqueta())) {
						switch (i) {
						case 0:
							j.setMonedas(j.getMonedas() + 5);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 5 monedas");
							System.out.println(" ");
							break;
						case 1:
							j.setMonedas(j.getMonedas() + 2);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 2 monedas");
							System.out.println(" ");
							break;
						case 2:
							j.setMonedas(j.getMonedas() + 1);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 1 moneda");
							System.out.println(" ");
							break;
						case 3:
							j.setMonedas(j.getMonedas() - 1);
							System.out.println(" ");
							System.out.println(j.getNombre() + " perdió 1 moneda");
							System.out.println(" ");
							break;
						default:
							j.setMonedas(j.getMonedas() - 1);
							System.out.println(" ");
							System.out.println(j.getNombre() + " perdió 1 moneda");
							System.out.println(" ");
							break;

						}
					}
				}
				quitarRecompensas(j,caAzul,  caRojo,caVerde,caMorado);

			}else if(caAzul.vaPrimero(caRojo, caAmarillo,caVerde,caMorado)){
				for (int i = 0; i < caAzul.pilaRonda.size() ; i++) {
					if (caAzul.pilaRonda.get(i).equals(j.getEtiqueta())) {
						switch (i) {
						case 0:
							j.setMonedas(j.getMonedas() + 5);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 5 monedas");
							System.out.println(" ");
							break;
						case 1:
							j.setMonedas(j.getMonedas() + 2);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 2 monedas");
							System.out.println(" ");
							break;
						case 2:
							j.setMonedas(j.getMonedas() + 1);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 1 moneda");
							System.out.println(" ");
							break;
						case 3:
							j.setMonedas(j.getMonedas() - 1);
							System.out.println(" ");
							System.out.println(j.getNombre() + " perdió 1 moneda");
							System.out.println(" ");
							break;
						default:
							j.setMonedas(j.getMonedas() - 1);
							System.out.println(" ");
							System.out.println(j.getNombre() + " perdió 1 moneda");
							System.out.println(" ");
							break;

						}
					}
				}
				quitarRecompensas(j,caRojo, caAmarillo,caVerde,caMorado);

			}else if(caMorado.vaPrimero(caAzul,  caRojo, caAmarillo,caVerde)){
				for (int i = 0; i < caMorado.pilaRonda.size() ; i++) {
					if (caMorado.pilaRonda.get(i).equals(j.getEtiqueta())) {
						switch (i) {
						case 0:
							j.setMonedas(j.getMonedas() + 5);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 5 monedas");
							System.out.println(" ");
							break;
						case 1:
							j.setMonedas(j.getMonedas() + 2);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 2 monedas");
							System.out.println(" ");
							break;
						case 2:
							j.setMonedas(j.getMonedas() + 1);
							System.out.println(" ");
							System.out.println(j.getNombre() + " recibió 1 moneda");
							System.out.println(" ");
							break;
						case 3:
							j.setMonedas(j.getMonedas() - 1);
							System.out.println(" ");
							System.out.println(j.getNombre() + " perdió 1 moneda");
							System.out.println(" ");
							break;
						default:
							j.setMonedas(j.getMonedas() - 1);
							System.out.println(" ");
							System.out.println(j.getNombre() + " perdió 1 moneda");
							System.out.println(" ");
							break;

						}
					}
				}
				quitarRecompensas(j,caAzul,  caRojo, caAmarillo,caVerde);

			}
		}
	}

	private static void quitarRecompensas(Jugador j, Camello ca1, Camello ca2, Camello ca3, Camello ca4){
		for (int i = 0; i < ca1.pilaRonda.size() ; i++) {
			if (ca1.pilaRonda.get(i).equals(j.getEtiqueta())) {
				j.setMonedas(j.getMonedas() - 1);
				System.out.println(" ");
				System.out.println(j.getNombre() + " perdió 1 moneda");
				System.out.println(" ");
			}
		}

		for (int i1 = 0; i1 < ca2.pilaRonda.size() ; i1++) {
			if (ca2.pilaRonda.get(i1).equals(j.getEtiqueta())) {
				j.setMonedas(j.getMonedas() - 1);
				System.out.println(" ");
				System.out.println(j.getNombre() + " perdió 1 moneda");
				System.out.println(" ");
			}
		}

		for (int i2 = 0; i2 < ca3.pilaRonda.size() ; i2++) {
			if (ca3.pilaRonda.get(i2).equals(j.getEtiqueta())) {
				j.setMonedas(j.getMonedas() - 1);
				System.out.println(" ");
				System.out.println(j.getNombre() + " perdió 1 moneda");
				System.out.println(" ");
			}
		}

		for (int i3 = 0; i3 < ca4.pilaRonda.size() ; i3++) {
			if (ca4.pilaRonda.get(i3).equals(j.getEtiqueta())) {
				j.setMonedas(j.getMonedas() - 1);
				System.out.println(" ");
				System.out.println(j.getNombre() + " perdió 1 moneda");
				System.out.println(" ");
			}
		}
	}

	private static void apostar(Jugador j , int chequeo){
		switch (chequeo) {
			case 1:
				System.out.println("¿A qúe camello quieres apostar?");
				System.out.println("1- Rojo");
				System.out.println("2- Verde");
				System.out.println("3- Amarillo");
				System.out.println("4- Azul");
				System.out.println("5- Morado");
				int opcion = auxiliar(1,5);
				switch (opcion) {
					case 1:
						caRojo.pilaRonda.add(caRojo.pilaRonda.size() ,j.getEtiqueta());;
						if (caRojo.getPilaApuesta().top() == -1) {
							caRojo.getPilaApuesta().top();
						}else{
							caRojo.getPilaApuesta().pop();
						}
						System.out.print("Apuestas Restantes: (");
				        imprimirApuestasRestantes();
						break;
					case 2:
						caVerde.pilaRonda.add(caVerde.pilaRonda.size(),j.getEtiqueta());
						if (caVerde.getPilaApuesta().top() == -1) {
							caVerde.getPilaApuesta().top();
						}else{
							caVerde.getPilaApuesta().pop();
						}
						System.out.print("Apuestas Restantes: (");
				        imprimirApuestasRestantes();
						break;
					case 3:
						caAmarillo.pilaRonda.add(caAmarillo.pilaRonda.size(),j.getEtiqueta());
						if (caAmarillo.getPilaApuesta().top() == -1) {
							caAmarillo.getPilaApuesta().top();
						}else{
							caAmarillo.getPilaApuesta().pop();
						}
						System.out.print("Apuestas Restantes: (");
				        imprimirApuestasRestantes();
						break;
					case 4: 
						caAzul.pilaRonda.add(caAzul.pilaRonda.size(),j.getEtiqueta());
						if (caAzul.getPilaApuesta().top() == -1) {
							caAzul.getPilaApuesta().top();
						}else{
							caAzul.getPilaApuesta().pop();
						}
						System.out.print("Apuestas Restantes: (");
				        imprimirApuestasRestantes();
						break;
					case 5:
						caMorado.pilaRonda.add(caMorado.pilaRonda.size(),j.getEtiqueta());
						if (caMorado.getPilaApuesta().top() == -1) {
							caMorado.getPilaApuesta().top();
						}else{
							caMorado.getPilaApuesta().pop();
						}
						System.out.print("Apuestas Restantes: (");
				        imprimirApuestasRestantes();
						break;
				}
				break;

			case 2:
				System.out.println("¿A qúe camello quieres apostar como ganador de la carrera?");
				System.out.println("1- Rojo");
				System.out.println("2- Verde");
				System.out.println("3- Amarillo");
				System.out.println("4- Azul");
				System.out.println("5- Morado");
				int opcion1 = auxiliar(1,5);
				boolean bandera = false;
				switch (opcion1) {
					case 1:
						for (int i = 0; i < j.cartasDeCamello.length ; i++) {
							if (j.cartasDeCamello[i].equals(caRojo.toString())) {
								j.cartasDeCamello[i] = "";
								bandera = true;
								caRojo.pilaCarreraG.add(caRojo.pilaCarreraG.size() - 1,j.getEtiqueta());
								break;
							}
						}
						if (bandera == false) {
							System.out.println("Ya apostaste esa carta, escoge otro");
							apostar(j, 2);
						}
						break;
					case 2:
						for (int i = 0; i < j.cartasDeCamello.length ; i++) {
							if (j.cartasDeCamello[i].equals(caVerde.toString())) {
								j.cartasDeCamello[i] = "";
								bandera = true;
								caVerde.pilaCarreraG.add(caVerde.pilaCarreraG.size(),j.getEtiqueta());
								break;
							}
						}
						if (bandera == false) {
							System.out.println("Ya apostaste esa carta, escoge otro");
							apostar(j, 2);
						}
						break;
					case 3:
						for (int i = 0; i < j.cartasDeCamello.length ; i++) {
							if (j.cartasDeCamello[i].equals(caAmarillo.toString())) {
								j.cartasDeCamello[i] = "";
								bandera = true;
								caAmarillo.pilaCarreraG.add(caAmarillo.pilaCarreraG.size(),j.getEtiqueta());
								break;
							}
						}
						if (bandera == false) {
							System.out.println("Ya apostaste esa carta, escoge otro");
							apostar(j, 2);
						}
						break;
					case 4: 
						for (int i = 0; i < j.cartasDeCamello.length ; i++) {
							if (j.cartasDeCamello[i].equals(caAzul.toString())) {
								j.cartasDeCamello[i] = "";
								bandera = true;
								caAzul.pilaCarreraG.add(caAzul.pilaCarreraG.size(),j.getEtiqueta());
								break;
							}
						}
						if (bandera == false) {
							System.out.println("Ya apostaste esa carta, escoge otro");
							apostar(j, 2);
						}
						break;
					case 5:
						for (int i = 0; i < j.cartasDeCamello.length ; i++) {
							if (j.cartasDeCamello[i].equals(caMorado.toString())) {
								j.cartasDeCamello[i] = "";
								bandera = true;
								caMorado.pilaCarreraG.add(caMorado.pilaCarreraG.size(),j.getEtiqueta());
								break;
							}
						}
						if (bandera == false) {
							System.out.println("Ya apostaste esa carta, escoge otro");
							apostar(j, 2);
						}
						break;
				}
				break;
			case 3:
				System.out.println("¿A qué camello quieres apostar como perdedor de la carrera?");
				System.out.println("1- Rojo");
				System.out.println("2- Verde");
				System.out.println("3- Amarillo");
				System.out.println("4- Azul");
				System.out.println("5- Morado");
				int opcion2 = auxiliar(1,5);
				boolean bandera1 = false;
				switch (opcion2) {
					case 1:
						for (int i = 0; i < j.cartasDeCamello.length ; i++) {
							if (j.cartasDeCamello[i].equals(caRojo.toString())) {
								j.cartasDeCamello[i] = "";
								bandera1 = true;
								caRojo.pilaCarreraP.add(caRojo.pilaCarreraP.size(),j.getEtiqueta());
								break;
							}
						}
						if (bandera1 == false) {
							System.out.println("Ya apostaste esa carta, escoge otro");
							apostar(j, 3);
						}
						break;
					case 2:
						for (int i = 0; i < j.cartasDeCamello.length ; i++) {
							if (j.cartasDeCamello[i].equals(caVerde.toString())) {
								j.cartasDeCamello[i] = "";
								bandera1 = true;
								caVerde.pilaCarreraP.add(caVerde.pilaCarreraP.size(),j.getEtiqueta());
								break;
							}
						}
						if (bandera1 == false) {
							System.out.println("Ya apostaste esa carta, escoge otro");
							apostar(j, 3);
						}
						break;
					case 3:
						for (int i = 0; i < j.cartasDeCamello.length ; i++) {
							if (j.cartasDeCamello[i].equals(caAmarillo.toString())) {
								j.cartasDeCamello[i] = "";
								bandera1 = true;
								caAmarillo.pilaCarreraP.add(caAmarillo.pilaCarreraP.size(),j.getEtiqueta());
								break;
							}
						}
						if (bandera1 == false) {
							System.out.println("Ya apostaste esa carta, escoge otro");
							apostar(j, 3);
						}
						break;
					case 4: 
						for (int i = 0; i < j.cartasDeCamello.length ; i++) {
							if (j.cartasDeCamello[i].equals(caAzul.toString())) {
								j.cartasDeCamello[i] = "";
								bandera1 = true;
								caAzul.pilaCarreraP.add(caAzul.pilaCarreraP.size(),j.getEtiqueta());
								break;
							}
						}
						if (bandera1 == false) {
							System.out.println("Ya apostaste esa carta, escoge otro");
							apostar(j, 3);
						}
						break;
					case 5:
						for (int i = 0; i < j.cartasDeCamello.length ; i++) {
							if (j.cartasDeCamello[i].equals(caMorado.toString())) {
								j.cartasDeCamello[i] = "";
								bandera1 = true;
								caMorado.pilaCarreraP.add(caMorado.pilaCarreraP.size(),j.getEtiqueta());
								break;
							}
						}
						if (bandera1 == false) {
							System.out.println("Ya apostaste esa carta, escoge otro");
							apostar(j, 3);
						}
						break;
				}
				break;
		}
	}

	private static void imprimirApuestasRestantes(){
		caRojo.imprimirPila();
		caVerde.imprimirPila();
		caAmarillo.imprimirPila();
		caAzul.imprimirPila();
		caMorado.imprimirPila();
		System.out.print(" )");
		System.out.println(" ");
	}
	/**
	 * Método que regresa un camello randome del arreglo de Camellos
	 * @param arregloDeCamellos arreglo de los camellos de la partida
	 * @return el camello seleccionado del arreglo, null si ya no hay Camellos en la lista
	 */
	private static Camello elegirCamelloRandom(Camello[] arregloDeCamellos){
		int bandera = 0;
		for (Camello c : arregloDeCamellos) {
			if (c == null) {
				bandera++;
			}
		}
		if (bandera == arregloDeCamellos.length) {
			return null;
		}
		else{
			Camello auxiliar;
			Random numero = new Random();
			for (int i = 0; i < arregloDeCamellos.length; i++){
				int indice = numero.nextInt(arregloDeCamellos.length);
				if (arregloDeCamellos[indice] != null) {
					auxiliar = arregloDeCamellos[indice];
					arregloDeCamellos[indice] = null;
					return auxiliar;
				}else{
					i--;
				}
			}
			return null;
		}
	}

	/**
	 * Método que imprime los dados tirados
	 * @param arregloDeTiros arreglo que tiene los tiros de los camellos
	 */
	private static void imprimeDadosTirados(String arregloDeTiros []){
		System.out.println(" ");
		System.out.print("Tiradas iniciales: ");
		for (String s: arregloDeTiros) {
			if (s != null) {
				System.out.print(s);	
			}
		}
		System.out.println("  ");
	}

	/**
	 * Método que agrega al arreglo de tiros le tiro de un camello, además mueve al Camello
	 * las posiciones que salga su tiro y checa si tiene camellos encima para tambien moverlos
	 * @param ca el Camello que tirará su dado
	 * @param arregloDeTiros arreglo que tiene los tiros de los camellos
	 */
	private static void agregaDadosTirados(Camello ca, String arregloDeTiros []){
		if (ca != null) {
			Camello tope = ca.getTope(t, caAzul,  caRojo, caAmarillo,caVerde,caMorado);

			//SI no tiene camellos arriba
			if (tope == null) {
				if (ca.getPosicionX() > 0) {
					ca.setPosicionYAntigua(ca.getPosicionY());
					eliminarMarca(ca, 0);
					int posicion = ca.tirarDado();
					moverCamello(ca);
					String s = String.valueOf(posicion);
					String agregar = ca.getColor() + "["+ s + "]" + "\u001B[0m";

					for (int i = 0; i < arregloDeTiros.length; i++ ) {
						if (arregloDeTiros[i] == null) {
							arregloDeTiros[i] = agregar;
							break;
						}
					}
				}else{
					int posicion = ca.tirarDado();
					moverCamello(ca);
					String s = String.valueOf(posicion);
					String agregar = ca.getColor() + "["+ s + "]" + "\u001B[0m";
					for (int i = 0; i < arregloDeTiros.length; i++ ) {
						if (arregloDeTiros[i] == null) {
							arregloDeTiros[i] = agregar;
							break;
						}
					}
				}
			}

			else{
				if (ca.getPosicionX() > 0) {
					int posicion = ca.tirarDado();
					ca.setPosicionYAntigua(ca.getPosicionY());
					moverCamello(ca);

					for(int i = ca.getPosicionYAntigua() + 1; i < pista[0].length ; i++){
						switch (pista[ca.getPosicionX() - 1 - posicion][i]) {
							case "\u001B[41m" +  "🐫 " +"\u001B[0m": //Caso en el que se rojo
								caRojo.setPosicionTope(ca.getPosicionX());
								caRojo.setPosicionYAntigua(caRojo.getPosicionY());
								moverCamello(caRojo);
								break;
					        case "\u001B[42m" +  "🐫 " +"\u001B[0m": //Caso en el que se verde
					        	caVerde.setPosicionTope(ca.getPosicionX());
					        	caVerde.setPosicionYAntigua(caVerde.getPosicionY());
					        	moverCamello(caVerde);
					        	break;
							case "\u001B[43m" +  "🐫 " +"\u001B[0m": //Caso en el que se amarillo
								caAmarillo.setPosicionTope(ca.getPosicionX());
								caAmarillo.setPosicionYAntigua(caAmarillo.getPosicionY());
								moverCamello(caAmarillo);
								break;
							case "\u001B[44m" +  "🐫 " +"\u001B[0m": //Caso en el que se azul
								caAzul.setPosicionTope(ca.getPosicionX());
								caAzul.setPosicionYAntigua(caAzul.getPosicionY());
								moverCamello(caAzul);
								break;
							case "\u001B[45m" +  "🐫 " +"\u001B[0m": //Caso en el que se morado
								caMorado.setPosicionTope(ca.getPosicionX());
								caMorado.setPosicionYAntigua(caMorado.getPosicionY());
								moverCamello(caMorado);
								break;
							default:
								break;
							}	
						}

						eliminarMarca(ca, posicion);
						for(int i = ca.getPosicionYAntigua() + 1; i < pista[0].length; i++){
							switch (pista[ca.getPosicionX() - 1 - posicion][i]) {
							case "\u001B[41m" +  "🐫 " +"\u001B[0m": //Caso en el que se rojo
								eliminarMarca(caRojo, posicion);
								break;
					        case "\u001B[42m" +  "🐫 " +"\u001B[0m": //Caso en el que se verde
					        	eliminarMarca(caVerde, posicion);
					        	break;
							case "\u001B[43m" +  "🐫 " +"\u001B[0m": //Caso en el que se amarillo
								eliminarMarca(caAmarillo, posicion);
								break;
							case "\u001B[44m" +  "🐫 " +"\u001B[0m": //Caso en el que se azul
								eliminarMarca(caAzul, posicion);
								break;
							case "\u001B[45m" +  "🐫 " +"\u001B[0m": //Caso en el que se morado
								eliminarMarca(caMorado, posicion);
								break; 	
							}
						}

						String s = String.valueOf(posicion);
						String agregar = ca.getColor() + "["+ s + "]" + "\u001B[0m";
						for (int i = 0; i < arregloDeTiros.length; i++ ) {
							if (arregloDeTiros[i] == null) {
								arregloDeTiros[i] = agregar;
								break;
							}
						}
					}
				}	
			}
		}

    private static void eliminarMarca(Camello ca, int posicion){
    	int i = ca.getPosicionX() - 1;
    	pista[i - posicion][ca.getPosicionYAntigua()] = "   ";
    }

	/**
	 * Método que mueve al camello en el arreglo bidimensional y lo coloca
	 * @param ca el camello a mover
	 * @param posicion la posicion a mover el camello
	 * @param t el tablero donde se colocará al camello
	 */
	private static void moverCamello(Camello ca){
		String camello = ca.toString();
		for (int i = 2; i < pista[0].length; i++) {
				if (pista[ca.getPosicionX() - 1][i].equals("   ")) {
					pista[ca.getPosicionX() - 1][i] = camello;
					ca.setPosicionY(i);
					break;
			}
		}
	}


	/**
	 * Método que se encarga de verificar si hay tiros disponibles o no
	 * @param arregloDeCamellos verifica si hay algún elemento que no sea Null
	 * @return True si todos los elementos en arregloDeCamellos son null, false en cualquier otro caso
	 */
	private static boolean ceroCamellosDisponibles(Camello[] arregloDeCamellos){
		int bandera = 0;
		for (Camello ca: arregloDeCamellos ) {
			if (ca == null) {
				bandera++;
			}
		}
		return bandera == arregloDeCamellos.length;
	}

	/**
    * Declaración del método que se encarga de controlar excepciones al momento de leer desde terminal
    * estando acotada por arriba y por abajo.
    * @param inicio Cota inferior para la lectura del entero
    * @param fin COta superior para la lectura del entero
    * @throws NumberFormatException si se ingresa un dígito que no sea un entero
    **/
	private static int auxiliar(int inicio, int fin)throws NumberFormatException{
		Scanner sc = new Scanner(System.in);
		int opcion = -100;
		boolean bandera = false;

		do{
			try {
				System.out.print("---> ");
				String opcionUsuario = sc.nextLine();
				opcion = Integer.parseInt(opcionUsuario);
				if (opcion >= inicio && opcion <= fin) {
				    break;	
				}
				else{
					System.out.println("Ingresa una opción válida");
				}
			}catch (NumberFormatException ex){
				System.out.println("Ingresa un NUMERO valido");
			}		
		}while(bandera == false);
		return opcion;
	}
}