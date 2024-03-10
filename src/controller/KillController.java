/**
 * 
 */
package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Lucas Batista 10 de mar. de 2024
 */
public class KillController {

	/**
	 * 
	 */
	public KillController() {
		super();
	}

	private String os(String osNome) {
		osNome = System.getProperty("os.name");
		return osNome;
	}

	public void listaProcessos() {
		String osNome = "";
		osNome = os(osNome);
		
		String process = "";
		if (osNome.contains("Windows")) {
			process = "TASKLIST /FO TABLE";
		} else {
			process = "ps -ef";
		}
		
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);

			String linha = buffer.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param n
	 */
	public void mataPID(int PID) {
		String osNome = "";
		osNome = os(osNome);
		
		String process = "";
		if (osNome.contains("Windows")) {
			process = "TASKKILL /PID ";
		} else {
			process = "kill -9 ";
		}
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(process);
		buffer.append(" ");
		buffer.append(PID);
		
		try {
			Runtime.getRuntime().exec(buffer.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void mataNome(String nome) {
		String osNome = "";
		osNome = os(osNome);
		
		String process = "";
		if (osNome.contains("Windows")) {
			process = "TASKKILL /PID ";
		} else {
			process = "kill -9 ";
		}
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(process);
		buffer.append(" ");
		buffer.append(nome);
		
		try {
			Runtime.getRuntime().exec(buffer.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
