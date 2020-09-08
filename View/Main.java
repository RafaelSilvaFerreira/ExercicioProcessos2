package View;

import java.util.Scanner;

import Controller.RedesController;

public class Main {

public static void main(String[] args){

	Scanner sc = new Scanner(System.in);
	RedesController redes = new RedesController();

	int opt = 0;

	while (opt != 9) {

		System.out.println(
			"Escolha a opção desejada: "+
			"\n 1 - Exibir processos ativos"+
			"\n 2 - Matar processo por nome"+
			"\n 3 - Matar processo por PID"+
			"\n 9 - Finalizar Programa");
			
		opt = sc.nextInt();

		switch (opt) {

		case 1:
			 redes.ProcessosAtivos(redes.IdSO());
		break;

		case 2:
			sc.nextLine();
			System.out.print("insira o PID do processo: ");
			System.out.println();
			String pid = sc.nextLine();
			redes.MatarPID(pid, redes.IdSO());
		break;
		
		case 3:
			sc.nextLine();
			System.out.print("Insira o nome do processo: ");
			System.out.println();
			String processo = sc.nextLine();
			redes.MatarNome(processo, redes.IdSO());
		break;
		
		case 9:

			System.out.println("Processo Finalizado com sucesso.");
			opt = sc.nextInt();
		break;

			default:
				System.out.println("Opção Inválida!");
		break;
			}
		}
		sc.close();
	}

}