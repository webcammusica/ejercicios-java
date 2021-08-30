package com.webcammusica.ejercicio4.lamdasystreams;

import java.util.Collection;

public class CarritoDeCompras {

	private Collection<Integer> precios;

	/**
	 * Constructor de la clase
	 * 
	 * @param precios
	 */
	public CarritoDeCompras(Collection<Integer> precios) {

		this.precios = precios;
	}

	/**
	 * Calcula la sumatoria de todos los precios dentro del objeto Collection
	 * mediante programación imperativa
	 * 
	 * @return
	 */
	public int calcularPrecioTotal() {

		int precioTotal = 0;

		for (Integer precio : precios) {

			precioTotal += precio;

		}
		return precioTotal;
	}

	/**
	 * Calcula el descuento total del 5% del parámetro para cada item que sea igual
	 * a superior al valor del parámetro usando pprogramación imperativa con un
	 * bucle "for" y un condicional "if".
	 * 
	 * @param cantidadConDescuento
	 * @return descuentoTotal
	 */
	public long calcularDescuentoTotal(int cantidadConDescuento) {

		long descuentoTotal = 0;

		for (Integer precio : precios) {
			if (precio >= cantidadConDescuento) {
				descuentoTotal += (cantidadConDescuento * 5) / 100;
			}
		}
		return descuentoTotal;
	}

	/**
	 * Retorna el tamaño del objeto Collection
	 * 
	 * @return
	 */
	public int contarNumeroDeProductos() {

		return precios.size();
	}

	/**
	 * Calcula el precio total mediante programación funcional con un lambda pasado
	 * como predicado al método stream().mapToInt() del objeto Collection "precios".
	 * Estos métodos fueron incluidos por primera vez en Java 8 en el año 2014.
	 * 
	 * El lambda podría sustituirse por una llamada al método así: int precioTotal =
	 * this.precios.stream() .mapToInt(Integer::intValue) .sum();
	 */
	public int calcularPrecioTotalLambda() {
		int precioTotal = this.precios.stream().mapToInt(precio -> precio.intValue()).sum();
		return precioTotal;
	}

	/**
	 * Calcula el precio total mediante programación funcional con un lambda pasado
	 * como predicado al método stream().filter() del objeto Collection "precios" y
	 * luego usa el método count() de la clase Stream. Estos métodos fueron
	 * incluidos por primera vez en Java 8 en el año 2014.
	 * 
	 * @param cantidadConDescuento
	 * @return descuentoTotal
	 */
	public long calcularDescuentoTotalLambda(int cantidadConDescuento) {

		long descuentoTotal = 0;

		Long numeroDeDescuentos = this.precios.stream().filter(precio -> precio.intValue() >= cantidadConDescuento)
				.count();

		descuentoTotal = cantidadConDescuento * 5 / 100 * numeroDeDescuentos;

		return descuentoTotal;
	}

	/**
	 * Detecta si existe un precio negativo lo cual es un error usando programación
	 * imperativa.
	 * 
	 * @return negativoEncontrado
	 */
	public boolean detectarError() {

		boolean negativoEncontrado = false;

		for (int precio : precios) {

			if (precio < 0) {

				negativoEncontrado = true;
			}
		}

		return negativoEncontrado;
	}

	public boolean detectarErrorFindAny() {

		boolean negativoEncontrado = false;
		negativoEncontrado = this.precios.stream().filter(precio -> precio.intValue() < 0).findAny().isPresent();
		return negativoEncontrado;
	}

	public boolean detectarErrorFindFirst() {

		boolean negativoEncontrado = false;
		negativoEncontrado = this.precios.stream().filter(precio -> precio.intValue() < 0).findFirst().isPresent();
		return negativoEncontrado;
	}

	/**
	 * Streams en paralelo
	 */
	public boolean detectarErrorAnyMatchParallel() {
		boolean negativoEncontrado = false;
		negativoEncontrado = this.precios.parallelStream().anyMatch(precio -> precio.intValue() < 0);
		return negativoEncontrado;
	}

	public boolean detectarErrorFindAnyParallel() {
		boolean negativoEncontrado = false;
		negativoEncontrado = this.precios.parallelStream().filter(precio -> precio.intValue() < 0).findAny()
				.isPresent();
		return negativoEncontrado;

	}

	public boolean detectarErrorFindFirstParallel() {

		boolean negativoEncontrado = false;
		negativoEncontrado = this.precios.parallelStream().filter(precio -> precio.intValue() < 0).findFirst()
				.isPresent();
		return negativoEncontrado;
	}

}