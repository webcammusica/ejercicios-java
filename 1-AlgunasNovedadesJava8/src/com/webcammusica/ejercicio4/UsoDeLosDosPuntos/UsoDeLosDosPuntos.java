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
		} // salta hasta aquí

		/**
		 * condición teraria. si b < 4, a es igual 7, sino a es igual a 8.
		 */

		int b = 8;

		int a = (b < 4) ? 7 : 8;

		/**
		 * bucle For-Each primera iteración: imprime "hola" segunda iteración: imprime
		 * "compañero"
		 */

		String palabras[] = { "hola", "compañero" };

		for (String s : palabras) {
			System.out.println(s);
		}

		/**
		 * afirmación evalua que el factorial no es menor que cero, si la evaluación es
		 * "false" se detiene la ejecución del programa.
		 */
		int c = factorial(b);
		assert b >= 0 : "ningÃºn factorial es menor que 0";

		/**
		 * condicional Switch
		 */

		String expresion = "";
		switch (expresion) {
		// declaraciÃ³n case
		// los valores deben ser del mismo tipo de la expresiÃ³n
		case "":
			// Declaraciones
			break; // break es opcional

		case "uno":
			// Declaraciones
			break; // break es opcional

		// Podemos tener cualquier número de declaraciones de casos o case
		// debajo se encuentra la declaraciÃ³n predeterminada, que se usa cuando ninguno
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
