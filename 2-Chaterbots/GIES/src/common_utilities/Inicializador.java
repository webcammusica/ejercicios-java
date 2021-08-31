package common_utilities;

import java.io.File;
import java.io.IOException;
import java.util.Formatter;

public class Inicializador {
	
	MotorInferencia mot;
	final File file;
	/**
	 * Este método instancia el motor de inferencia y llama al método de
	 * esa clase comenzar
	 * @throws IOException
	 */
	public Inicializador(){
		this.mot = new MotorInferencia();
		this.file = new File ("src/java.txt");
		checkKnowledgeFile();
	}
	
	public void checkKnowledgeFile(){
		if (!this.file.exists()){
			createFile();
		}
		try{
			mot.comenzar(this.file);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void createFile(){
		try{
			final Formatter formatter = new Formatter(file.toString());
		}catch(Exception e){
			System.out.println("File"+file.toString()+"does not exist.");
		}
	}


}
