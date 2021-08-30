package com.webcammusica.ejercicio4.UsoDeLosDosPuntos;

public class UsoDeLosDosPuntos {

	public void usoDeLosDosPuntos(int x) {

		/**
		 * etiqueta de salto
		 */

		etiqueta: for (int i = 0; i < x; i++) {
			for (int j = 0; j < i; j++) {
				if (i > 0 && j > 20)
					break etiqueta; // salta fuera de "etiqueta"
			}
		} // salta hasta aqu�

		/**
		 * condici�n teraria. si b < 4, a es igual 7, sino a es igual a 8.
		 */

		int b = 8;

		int a = (b < 4) ? 7 : 8;

		/**
		 * bucle For-Each primera iteraci�n: imprime "hola" segunda iteraci�n: imprime
		 * "compa�ero"
		 */

		String palabras[] = { "hola", "compa�ero" };

		for (String s : palabras) {
			System.out.println(s);
		}

		/**
		 * afirmaci�n evalua que el factorial no es menor que cero, si la evaluaci�n es
		 * "false" se detiene la ejecuci�n del programa.
		 */
		int c = factorial(b);
		assert b >= 0 : "ningún factorial es menor que 0";

		/**
		 * condicional Switch
		 */

		String expresion = "";
		switch (expresion) {
		// declaración case
		// los valores deben ser del mismo tipo de la expresión
		case "":
			// Declaraciones
			break; // break es opcional

		case "uno":
			// Declaraciones
			break; // break es opcional

		// Podemos tener cualquier n�mero de declaraciones de casos o case
		// debajo se encuentra la declaración predeterminada, que se usa cuando ninguno
		// de los casos es verdadero.
		// No se necesita descanso en el case default
		default:
			// Declaraciones
		}
	}

	public int factorial(int number) {
		int factorial = 1;
		if (number == 0) {
			factorial = 1;
			return factorial;
		}
		for (int i = 1; i <= number; i++) {
			factorial *= i;
		}
		return factorial;
	}

}
