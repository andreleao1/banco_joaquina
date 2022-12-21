package conta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BancoJoaquinaMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Conta> contas = new ArrayList<>();
		
		while (true) {
			System.out.println(
					"---- Bem Vindo(a) ao Banco Joaquina ---- \nDigite: \n\n1 - Abrir conta \n2 - Depósito \n3 - Saque \n4 - Transferência \n5 - Consultar saldo \n6 - Encerrar");
			int opcaoSelecionada = scanner.nextInt();

			switch (opcaoSelecionada) {
			case 1:
				Conta conta = new Conta();
				if(contas.isEmpty()) {
					conta.setNumeroConta("1");
				} else {
					Integer numeroConta = contas.size() + 1;
					conta.setNumeroConta(numeroConta.toString());
				}
				contas.add(conta);
				break;
			case 2:
				System.out.println("Depósito selecionado");
				break;
			case 3:
				System.out.println("Saque selecionado");
				break;
			case 4:
				System.out.println("Informe a conta de origem:");
				String numContaOrigem = scanner.next();
				boolean verificaConta = false;				
				Conta contaOrigem = null;
				Conta contaDestino =null;
				
				for(int i=0; i< contas.size(); i++) {
					Conta conta1= contas.get(i);				
					if(numContaOrigem.equalsIgnoreCase(conta1.getNumeroConta())) {
						verificaConta = true;						
						contaOrigem = conta1;						
					}
				}
				if(!verificaConta) {				
					System.out.println("A conta não existe!");
					break;
				}
				verificaConta=false;
				System.out.println("Informe a conta de destino:");				
				String numContaDestino = scanner.next();
				for(int i=0; i< contas.size(); i++) {
					Conta conta2= contas.get(i);
					if(numContaDestino.equalsIgnoreCase(conta2.getNumeroConta())) {
						verificaConta = true;
						contaDestino = conta2;
					}
				}
				if(!verificaConta) {				
					System.out.println("A conta não existe!");
					break;
				}
				
				System.out.println("Informe o valor da transferência:");				
				Double valorTransferencia = scanner.nextDouble();
				
					if(contaOrigem.getSaldo()>=valorTransferencia) {
						contaOrigem.setSaldo(contaOrigem.getSaldo()-valorTransferencia);
						contaDestino.setSaldo(contaDestino.getSaldo()+valorTransferencia);
						System.out.println("Operação realizada com sucesso");
						
					}else {
						System.out.println("Saldo insuficiente!");
						break;
					}
					for(int i=0; i< contas.size(); i++) {
						System.out.println((contas.get(i)).toString());
					}				
				break;
			case 5:
				System.out.println("Consultar saldo selecionado.");
				break;
			case 6:
				System.out.println("Obrigado pela preferência!");
				System.exit(0);
				break;
			default:
				System.out.println("Opção inválida");
				break;
			}
		}
	}
}
