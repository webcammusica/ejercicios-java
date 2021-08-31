/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common_utilities;

import java.io.*;
import java.util.StringTokenizer;

/**
 *Clase que permite a Sisconvaut leer y esccribi en archivos
 * @author caronte
 */
public class ManipuladorDArchivos {

	/**
	 * Constructor de la clase ManipuladorDArchivos
	 */
	public ManipuladorDArchivos() {
	}


	/**
	 * Permite escribir en un archivo dividiendo palabras claves y
	 * conceptos por un token
	 * @param archivo
	 * @param palClave
	 * @param conceptos
	 */
	public void escribir(File archivo, String palClave,String conceptos){
		FileWriter fichero = null;
		PrintWriter pw = null;
		try
		{
			fichero = new FileWriter(archivo,true);
			pw = new PrintWriter(fichero);

			pw.println(palClave.toUpperCase() +"1128068"+conceptos+"1128068");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	/**
	 * Crea una matriz con el estilo de la base de conocimiento a partir de
	 * un archivo dado
	 * @param archivo
	 * @return Matriz tipo BC
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String [][]crearMatrizdeArchivo(File archivo) throws FileNotFoundException, IOException {
		String cadena = convertirEnString(archivo);
		return convertirEnMatriz(cadena);

	}

	/**
	 * Conierte el contenido de un archivo en un String
	 * @param archivo
	 * @return Un string con el contenido del archivo
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	public String convertirEnString(File archivo) throws FileNotFoundException, IOException{
		FileReader lector = new FileReader(archivo);
		BufferedReader bufLec = new BufferedReader(lector);
		String linea = "";
		String total = "";
		while((linea=bufLec.readLine())!=null){
			total = total + linea;
		}
		return total;
	}

	/**
	 * Convierte un String generado en una matriz tipo String, utilizando el
	 * token definido para separar las cadenas. La matriz tiene un tamaño de
	 * numeroDeCadenas/2 X 2
	 * @param cadena
	 * @return matriz String
	 */

	public String [][] convertirEnMatriz(String cadena){
		StringTokenizer tokens=new StringTokenizer(cadena, "1128068");
		int nDatos=tokens.countTokens();
		String[][] matrizGenerada=new String[nDatos/2][2];
		//System.out.println(nDatos);
		for(int i = 0;i<(nDatos/2);i++){

		}
		int fila=0;
		int columna=0;
		while(tokens.hasMoreTokens()){
			String str=tokens.nextToken();
			//System.out.println(str);
			//System.out.println("fila:"+fila+"columna:"+columna);
			matrizGenerada[fila][columna]=str;
			if(columna == 1){
				fila++;
			}
			if(columna == 1){
				columna = 0;
			}else if(columna == 0){
				columna = 1;
			}
		}
		return matrizGenerada;
	}

}


