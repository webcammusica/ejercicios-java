/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common_utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Clase que contiene los  métodos de inferencia de Sisconvaut
 * @author caronte
 */
public class MotorInferencia {
	private BaseDConocim BC;
	public MotorInferencia (){
		BC = new BaseDConocim();
	}

	/**
	 * Método que busca una respuesta predefinida e "inmutable"
	 * @param String introducido
	 * @return respuesta predefinida o "" si no encuentra el String en la base
	 * de conocimiento
	 */
	public String buscarRespuestaEnPersonalidad(String str) {
		String result = "";
		for(int i = 0; i < BC.personalidad.length; ++i) {
			if(BC.personalidad[i][0].equalsIgnoreCase(str)) {
				result = BC.personalidad[i][1];
				break;
			}
		}

		return result;
	}

	/**
	 * Este método busca conceptos aprendidos en archivos
	 * @param pregunta
	 * @return retorna la respuesta por palabra clave y si no la encuentra
	 * retorna el String "decidirAleatoriamente"
	 */


	public String buscarAprendidasEnArchivo(String pregunta, File archivo) throws FileNotFoundException, IOException{
		ManipuladorDArchivos mani = new ManipuladorDArchivos();
		String[][] CONO =  mani.crearMatrizdeArchivo(archivo);
		for (int i = 0; i < CONO.length; i++) {
			if(pregunta.toUpperCase().indexOf(CONO[i][0])!=-1){
				return CONO[i][1];
			}
		}
		return "decidirAleatoriamente";
	}

	/**
	 * Este método inicializa la base del conocimiento
	 * luego muestra en la consola un indicador de que MEGAN esta conversando
	 * -->
	 * procede a leer una linea de entrada de la consola
	 * busca una de la base de conocimientos una rerspuesta inmediata
	 * sino intenta por palabra clave
	 * si ninguna de las anteriores funciona llama al método Decidir()
	 * @throws IOException
	 */
	public void comenzar(File archivo) throws IOException{

		while(true) {
			System.out.print("-->:");
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String Strentrada = in.readLine();
			inferir(archivo, Strentrada);
		}
	}

	/**
	 * Este método llama a otro como verificarAcciones,buscarRespuesta,e imprime
	 * la respuesta por consola
	 * @param archivo
	 * @param cadena
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void inferir(File archivo, String cadena) throws FileNotFoundException, IOException{
		verificarAcciones(cadena);
		String respuesta = buscarRespuesta(cadena,archivo);
		System.out.println(respuesta);
	}

	/**
	 *Este método hace que Sisconvaut decida de forma aleatoria si quiere aprender o
	 * no.
	 * @throws IOException
	 */
	public String decidir(File archivo) throws IOException {
		String respuesta = null;
		Random generator = new Random();
		boolean decision = generator.nextBoolean();
		if(decision){
			aprender(archivo);
		}else if (decision == false){
			respuesta = "Ese tema no me parece tan intersante";
			return respuesta;
		}return "";
	}
	/**
	 * Permite enseñarle nuevos conceptos a Sisconvaut, estos se escribe en un
	 * archivo. El usuario puede decidir si quiere enseñarle o no.
	 * @throws IOException
	 */
	public  void aprender(File archivo) throws IOException {
		boolean aprendiendo = false;
		System.out.print("Me parece interesante. Pero no conozco el tema \n"
				+ " ¿Deseas enseñarme sobre eso?:");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String decision = in.readLine();
		if(decision.equalsIgnoreCase("si")){
			aprendiendo = true;
			System.out.println("Dime cuál es la palabra clave"
					+ "de lo que me vas a enseñar:");
			String palClave = in.readLine();
			System.out.println("ok ahora dime en consiste o con"
					+ " que se relaciona");
			String conceptos = in.readLine();
			ManipuladorDArchivos mani = new ManipuladorDArchivos();
			mani.escribir(archivo, palClave, conceptos);
			System.out.println("¡Aprendido!");
		}
		if(decision.equalsIgnoreCase("no") && !aprendiendo){
			System.out.println("ok no hay problema");
		}else if (!aprendiendo){
			System.out.println("por fa responde si o no");
			aprender(archivo);
		}
	}
	/**
	 * Se encarga de verificar si la cadena introducida es un comando reconocido
	 * por Sisconvaut y lo ejecuta.
	 * @param cadena
	 */
	private void verificarAcciones(String cadena) {
		if(cadena.equalsIgnoreCase("adios")||cadena.equalsIgnoreCase("chao")||
				cadena.equalsIgnoreCase("hasta luego")){
			System.exit(0);
		}

	}
	/**
	 * Busca una de la base de conocimientos una rerspuesta inmediata
	 * sino intenta por conocimientos aprendidos en un archivo
	 * si ninguna de las anteriores funciona llama al método Decidir()
	 * @param cadena
	 * @param archivo
	 * @return respuesta de MEGAN
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String buscarRespuesta(String cadena,File archivo) throws FileNotFoundException, IOException {
		String respuesta = buscarEnPersonaliadad(cadena);
		if(respuesta.equals("buscar en aprendidas")==false){
			return respuesta;
		}
		if(respuesta.equals("buscar en aprendidas")){
			respuesta = buscarAprendidasEnArchivo(cadena, archivo);
		}
		if(respuesta.equals("decidirAleatoriamente")==false){
			return respuesta;
		}
		if(respuesta.equals("decidirAleatoriamente")){
			return decidir(archivo);
		}
		return "";
	}
	/**
	 * Busca una respuesta en la "personalidad" de MEGAN
	 * @param cadena
	 * @return respuesta (campo de la matriz personalidad)
	 */
	public String buscarEnPersonaliadad(String cadena){
		for (int i = 0; i < BaseDConocim.personalidad.length; i++) {
			String res = BaseDConocim.personalidad[i][0];
			if(cadena.toUpperCase().indexOf(BaseDConocim.personalidad[i][0])!=-1){
				return BaseDConocim.personalidad[i][1];
			}
		}
		return "buscar en aprendidas";
	}

}
