package ex35;
import java.util.Scanner;
public class Sistema {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		char possuiContaBancaria;
		int id;
		String nome;
		int idade;
		String email;
		ContaBancaria conta;
		char atualizaEmail;
		String agencia;
		String numero;
		Double saldo;
		
		Cliente[] listaClientes = new Cliente[5];
		for(int i=0;i<=4;i++) {
			
			System.out.printf("Digite o id do cliente: ");
			id = ler.nextInt();
			
			System.out.printf("Digite o nome do cliente: ");
			nome = ler.next();
			
			System.out.printf("Digite a idade do cliente: ");
			idade = ler.nextInt();
			
			System.out.printf("Digite o email do cliente: ");
			email = ler.next();
			 
			System.out.printf("Possui conta bancaria? (S/N)");
			possuiContaBancaria = ler.next().charAt(0);
			
			if (possuiContaBancaria == 'S') {
				ContaBancaria ct = new ContaBancaria();
			
				
				System.out.printf("Digite a ag�ncia da conta: ");
				agencia = ler.next();
				ct.setAgencia(agencia);
				System.out.printf("Digite o n�mero da conta: ");
				numero = ler.next();
				ct.setNumero(numero);
				System.out.printf("Digite o saldo da conta: ");
				saldo = ler.nextDouble();
				ct.setSaldo(saldo);
				
				conta = ct;
			}else{
				conta=null;
			}
			Cliente c = new Cliente(id, nome, idade, email, conta);
			listaClientes[i]=c;
		}
		for(int i=0;i<=4;i++) {
			System.out.printf("\n%S", listaClientes[i].exibirNomeIdade());
			System.out.printf("\n%S", listaClientes[i].exibirDadosConta());
			System.out.printf("\nGostaria de atualizar o email? (S/N)");
			atualizaEmail = ler.next().charAt(0);
			
			if (atualizaEmail == 'S') {
				System.out.printf("Digite o email: ");
				email=ler.next();
				listaClientes[i].atualizarEmail(email);
				System.out.printf("Email atualizado com sucesso! Novo email: %s",listaClientes[i].getEmail());
			}
		}
		ler.close();
	}
}
