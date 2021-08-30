package com.webcammusica.ejercicio4.lamdasystreams;

import java.util.ArrayList;

public class ConstructorCarrito {

	ArrayList<Integer> precios = new ArrayList<Integer>();

	/**
	 * Construye un carrito del tama�o dado con precios aleatorios
	 * 
	 * @param size
	 */
	public ConstructorCarrito(int size) {

		for (int i = 0; i < size; i++) {

			Double random = Math.random() * 100 + 1;
			precios.add(random.intValue());
		}
	}

	/**
	 * Construye un carrito del tama�o dado con precios iguales al valor dado
	 * 
	 * @param size
	 * @param value
	 */
	public ConstructorCarrito(int size, int value) {

		for (int i = 0; i < size; i++) {

			precios.add(value);
		}
	}

	/**
	 * Crea un nuevo CarritoDeCompras con los precios actuales
	 * 
	 * @return
	 */
	public CarritoDeCompras construir() {

		return new CarritoDeCompras(this.precios);
	}

	/**
	 * Agrega un valor dado a la lista de precios.
	 * 
	 * @param nuevoValor
	 * @return
	 */
	public ConstructorCarrito agregarItem(Integer nuevoValor) {

		precios.add(nuevoValor);
		return this;
	}

	/**
	 * 
	 * @param size
	 * @param value
	 * @return
	 */
	public ConstructorCarrito agregarItems(int size, int value) {

		for (int i = 0; i < size; i++) {

			precios.add(value);
		}

		return this;
	}
}