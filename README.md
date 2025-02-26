Jerónimo Restrepo Cardona
Clase miércoles 7309
Windows 11, se utilizó java como lenguaje, https://www.geeksforgeeks.org/minimization-of-dfa/?ref=gcse_outind, JFLAP, entre otras herramientas como Autómata Tutor https://automata-tutor.model.in.tum.de/.

Instrucciones:
Descargar Java, poner el código en un IDE, guardar el código en un archivo main, compilar y ejecutar el código, y finalmente escribir por teclado los que nos piden en pantalla acerca del autómata que queremos minimizar.




Explicación del código:
Estructura del programa:

Esta es una implementación en Java del algoritmo de minimización del Autómata Finito Determinista (DFA).
Contiene una clase Main con dos métodos: minimizarDFA  y main.

Método minimizarDFA:

Toma el número de estados (n), el tamaño del alfabeto (m), una matriz de transición y un conjunto de estados finales.
Inicialización: Construye una matriz booleana different[n][n] donde diferente[i][j] será verdadero si los estados i y j son distinguibles (no idénticos).
Primera fase: Marca como diferentes los pares donde un estado es final y el otro no.
Fase iterativa: Repetidamente en un bucle, continúa marcando pares de estados como diferentes si sus transiciones van a estados que están marcados como diferentes.
Terminación: Continúa hasta que no se descubran nuevas diferencias).
Devuelve una lista de pares de estados coincidentes en formato "(sX, sY)". Dados estados x y y.

Método principal

Inicio: Crea un Scanner para tomar la entrada del usuario.
Casos de prueba: Solicita la cantidad de casos a ejecutar.
Para cada caso:

Solicita la cantidad de estados.
Solicita el alfabeto (símbolos separados por espacios).
Lee los estados finales.
Construye la tabla de transición estado por estado. Llama a minimizarDFA con los datos anteriores.

Almacena el resultado en una lista.

Salida: Muestra todos los resultados al final.

Base teórica: El algoritmo emplea el método visto en la lectura 14 del libro Dexter C. Kozen - Automata and Computability de minimización de DFA. Se basa en el principio de equivalencia de estados: dos estados son equivalentes si no es posible diferenciar su comportamiento para ninguna cadena de entrada. Estos estados se pueden fusionar sin alterar el lenguaje aceptado por el autómata.
