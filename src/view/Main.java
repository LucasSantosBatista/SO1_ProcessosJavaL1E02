/**
 * 
 */
package view;

import javax.swing.JOptionPane;

import controller.KillController;

/**
 * @author Lucas Batista
 * 10 de mar. de 2024
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KillController kCont = new KillController();
		
		int choice;
        do {
            Object[] options = {"Listar Processos", "Matar processo por PID",
            		"Matar processo por Nome", "Encerrar"};

            choice = JOptionPane.showOptionDialog(null, "Escolha uma opção para executar:",
                    "Opções", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, options, options[0]);

            switch (choice) {
                case 0:
                    kCont.listaProcessos();
                    break;
                case 1:
                    int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um PID: "));
                    kCont.mataPID(num);
                    break;
                case 2:
                	String nome = JOptionPane.showInputDialog(null, "Digite um nome: ");
                    kCont.mataNome(nome);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Programa encerrado.");
                    break;
            }
        } while (choice != 3);
		
	}

}
