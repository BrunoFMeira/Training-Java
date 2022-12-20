package conta;

import javax.swing.JOptionPane;

public class Auxx {
	int contascriadas;
	Conta contas1[] = new Conta[7];

	// Organização da Interface
	public void Aplicacao() {
		int funcao = Integer
				.parseInt(JOptionPane.showInputDialog("Insira o valor referente ao serviço \n1 - Criar Conta,"
						+ " 2 - Checar Saldos, 3 - Depositar, 4 - Sacar, 5 - Criar Multiplas Contas, 6 - Sair"));

		switch (funcao) {
		case 1:
			CriarConta();
			Aplicacao();
			break;
		case 2:
			ChecarSaldos();
			Aplicacao();
			break;
		case 3:
			Deposito();
			Aplicacao();
			break;
		case 4:
			Saque();
			Aplicacao();
			break;
		case 5:
			CriarMultiplasContas();
			Aplicacao();
			break;
		case 6:
			System.exit(0);
		default:
			JOptionPane.showMessageDialog(null, "Opção Invalida Tente Novamente");
			Aplicacao();
		}
	}

	// Metodos para Visualização
	private void CriarMultiplasContas() {
		JOptionPane.showMessageDialog(null, "Criando Contas");
		while (contascriadas < 5) {
			JOptionPane.showMessageDialog(null, "Conta Criada");
			contas1[contascriadas] = new Conta(contascriadas, contascriadas + 10);
			contascriadas++;
			if (JOptionPane.showConfirmDialog(null, "Criar outra conta?") == 1) {
				break;
			}
		}

	}

	private void ChecarSaldos() {
		for (int a = 0; a < contascriadas; a++) {
			contas1[a].imprimirSaldo();
		}
	}

	public void CriarConta() {
		int id, codigoCliente;
		if (contascriadas < 7) {
			JOptionPane.showMessageDialog(null, "Criando Conta");
			id = Integer.parseInt(JOptionPane.showInputDialog("Insira ID:"));
			codigoCliente = Integer.parseInt(JOptionPane.showInputDialog("Insira seu Codigo:"));
			contas1[contascriadas] = new Conta(id, codigoCliente);
			contas1[contascriadas].Depositar(Double.parseDouble(JOptionPane.showInputDialog("Insira seu saldo:")));
			contascriadas++;
		} else {
			JOptionPane.showMessageDialog(null, "Limite de Contas Alcançado");
		}
	}

	public void Deposito() {
		String[] options = new String[contascriadas];
		for (int a = 0; a < contascriadas; a++) {
			options[a] = Integer.toString(contas1[a].getId());
		}
		int aux2 = JOptionPane.showOptionDialog(null, "Escolha a conta:", "Click a button", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		contas1[aux2].Depositar(Integer.parseInt(JOptionPane.showInputDialog("Insira o valor a ser depositado:")));
	}

	public void Saque() {
		String[] options = new String[contascriadas];
		for (int a = 0; a < contascriadas; a++) {
			options[a] = Integer.toString(contas1[a].getId());
		}
		int aux2 = JOptionPane.showOptionDialog(null, "Escolha a conta:", "Click a button", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		contas1[aux2].Sacar(Integer.parseInt(JOptionPane.showInputDialog("Insira o valor a ser depositado:")));
	}
}
