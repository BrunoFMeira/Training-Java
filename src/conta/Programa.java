package conta;

import javax.swing.JOptionPane;

import conta.Conta;
import conta.Auxx;

@SuppressWarnings("unused")
public class Programa {
	public static void main(String[] args) {
		Auxx auxx = new Auxx();
		JOptionPane.showMessageDialog(null, "Bem-vindo ao nosso sistema de contas bancarias");
		auxx.Aplicacao();

	}

}
