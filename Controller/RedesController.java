package Controller;
 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	public RedesController() {
		super();
	}
	
public String IdSO() {
		return System.getProperty("os.name");
	}


public void ProcessosAtivos(String opSys) {
	String command;
	if (opSys.contains("Windows")){
		command= ("tasklist");
	}
	else if (opSys.contains("Linux")){
		command= ("ps");
	}
	else {
		System.out.println("SO não suportado!");
	return;
	}

	try {
	
		Process processo = Runtime.getRuntime().exec(command);
			InputStream fluxo = processo.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
			}
				
			System.out.println();
			buffer.close();
			leitor.close();
			fluxo.close();

		} 
		catch (Exception e) {
				String msgErro = e.getMessage();
				System.err.println(msgErro);
		}
}
		public void MatarNome(String processo, String opSys) {
		String cmd;
		if (opSys.contains("Windows")) {
			cmd = "TASKKILL /IM";
		}
		else if (opSys.contains("Linux")) {
			cmd = "pkill";
		} 
		else {
			System.out.println("SO não suportado!");
		return;
		}
		
		StringBuffer buffer = new StringBuffer();
		try {
				buffer.append(cmd);
				buffer.append(" ");
				buffer.append(processo);

				try {					Runtime.getRuntime().exec(buffer.toString());
				} 
				catch (IOException except) {
					System.out.println("Não foi possível matar o processo!");
					return;
				}
				finally {
				System.out.println("Processo morto com sucesso!");
				}
		}
		finally{
		return;
		}
}

public void MatarPID(String processo, String opSys) {
		String cmd;
		if (opSys.contains("Windows")) {
			cmd = "TASKKILL /PID";
		}
		else if (opSys.contains("Linux")) {
			 cmd = "kill";
		} 
		else {
			System.out.println("SO não suportado!");
		return;
		}
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append(cmd);
		buffer.append(" ");
		buffer.append(processo);

		try {					Runtime.getRuntime().exec(buffer.toString());
		} 
		catch (IOException except) {
			System.out.println("Não foi possível matar o processo!");
			return;
		}
		System.out.println("Processo morto com sucesso!");
	}
}
