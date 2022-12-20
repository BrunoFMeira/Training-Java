package conta;

import java.util.Random;

import javax.swing.JOptionPane;

public class Conta {
	// Atributos
	private int id, codigoCliente, numeroConta, digitoVerificador;
	private double saldo;

	// Construtores
	public Conta() {
	}

	public Conta(int id, int codigoCliente) {
		setId(id);
		setCodigocliente(codigoCliente);
		Random aleatorio = new Random();
		setNumeroconta(aleatorio.nextInt(99999) + 1);
		criarDigitoVerificador();

	}

	public Conta(int id, int codigoCliente, int numeroConta) {
		setId(id);
		setCodigocliente(codigoCliente);
		setNumeroconta(numeroConta);
		criarDigitoVerificador();
	}

	// Metodos
	public void Sacar(double saque) {
		setSaldo(getSaldo() - saque);

	}

	public void Depositar(double deposito) {
		setSaldo(getSaldo() + deposito);

	}

	public void imprimirSaldo() {
		JOptionPane.showMessageDialog(null, "Id: " + getId() + "\nCodigo: " + getCodigocliente() + "\nDigito: "
				+ getDigitoverificador() + "\nNumero da Conta: " + getNumeroconta() + "\nSaldo: " + getSaldo());

	}

	public void criarDigitoVerificador() {
		int aux = numeroConta;
		int s = 1;
		int a = 1;
		int b = 1;
		int c = 1;
		if (numeroConta > 10000) {
			s = aux / 10000;
			aux = aux % 10000;
		}
		if (numeroConta >= 1000) {
			a = aux / 1000;
			aux = aux % 1000;
		}
		if (numeroConta >= 100) {
			b = aux / 100;
			aux = aux % 100;
		}
		if (numeroConta >= 10) {
			c = aux / 10;
		}
		aux = aux % 10;

		setDigitoverificador((s * a * b * c * aux) % 11);
	}

	// Getters & Setters
	public int getId() {
		return id;
	}

	public int getCodigocliente() {
		return codigoCliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public int getDigitoverificador() {
		return digitoVerificador;
	}

	public int getNumeroconta() {
		return numeroConta;
	}

	private void setId(int id) {
		this.id = id;
	}

	private void setCodigocliente(int codigocliente) {
		this.codigoCliente = codigocliente;
	}

	private void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	private void setDigitoverificador(int digitoverificador) {
		if (digitoverificador <= 9 && digitoverificador >= 0) {
			this.digitoVerificador = digitoverificador;
		} else {
			this.digitoVerificador = 0;
		}
	}

	private void setNumeroconta(int numeroconta) {
		if (numeroconta <= 99999) {
			this.numeroConta = numeroconta;
		} else {
			Random aleatorio = new Random();
			this.numeroConta = aleatorio.nextInt(99999) + 1;
		}
	}

}
