package view;
import controller.KillController;
import javax.swing.JOptionPane;

public class Kill 
{
 public static void main(String Args[])
 {
	 KillController matarHaha = new KillController(); 
	 matarHaha.os();
	 String valor = JOptionPane.showInputDialog("Digite o processo que deseja matar hahaha");
	 matarHaha.matarProcess(valor);
 }
}

