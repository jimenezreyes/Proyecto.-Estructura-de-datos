# Sobre el Proyecto
### Escuela: Facultad de ciencias, UNAM

### Integrantes:
    San MArtin Macias Juan Daniel, 318181637
    Jimenez Reyes Abraham, 318230577     
          
## Proyecto. Juego de mesa Camel Up.


Este proyecto se trata de la realizacion de un juego de mesa llamado Camel Up.
Donde tenemos 5 camellos de diferentes colores e iremos apostando por el camello ganador o perdedor.

Para este proyecto realizamos 8 clases, 3 de ellas sobre estructuras como listas y pilas, una clase Jugador, una clase tablero, una clase Camello y la clase Main que es la que compilaremos.
Tenemos en la clase jugador la estructura de los camellos, jugadores, metodos set y get, y nuestro metodo de colocarModificador.
En la clase camello tenemos los colores y los movimientos ya sea en el tablero o cuando estan encima, tambien tenemos nuestro metodo de tirar dado.
En la clase tablero, tenemos una estructura para el tablero con sus 16 casillas 
Y en la clase main tenemos las opciones para nuestro jugadores, algunos metodos para su funcion.

Para ejecutar este proyecto necesitamos tener todos los archivos a la misma altura, esto para evitar errores entre clases, al igual es conveniente tener alguna distribucion de linux ya que utilizamos caracteres que en windows no estan permitidos.

### Ejecución del Proyecto

Para ejecutar el proyecto, sigue estos pasos desde tu terminal:

1. Asegúrate de estar en la carpeta del proyecto, por ejemplo, "Proyecto EDD".
2. Compila el archivo principal ejecutando el siguiente comando:
    ```bash
    $ javac Main.java
    ```
   Esto compilará el código.

3. Después de compilar, ejecuta el programa con el siguiente comando:
    ```bash
    $ java Main
    ```
   Al ejecutarlo, recibirás un mensaje de bienvenida y se te pedirá ingresar el número de jugadores (entre 2 y 6) junto con sus respectivos nombres.

Nos apareceran las tiradas iniciales y un tablero simulando el juego de mesa con los camellos, el juego nos dira de quien es el turno para jugar, en este el jugador elegira entre 5 opciones despues le seguira al siguiente jugador hasta que un camello llegue a la meta.
