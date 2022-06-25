package arvore;
import java.util.Scanner;
import dados.Item;
public class ArvoreMain {
	static Scanner scan =new Scanner(System.in);
	public static void main(String[] args) {
		Arvore arvore = new Arvore();
		
		String nome;
		String cpf;
		String telefone;
		String email;
		Double saldo;
		String mensagem;
		Double media;
		
		
		
		Item [] vetor= new Item[10];//limite de elemento para esta �rvore
		
		
		char opcao;
		
		
		do {
			System.out.println("Escolha uma Op��o:\n" +
					"1. Inserir No na Arvore\n"+
					"2. Mostrar dados\n"+
					"3. Mostrar nos em ordem alfabética\n" +
					"4. Exibir media de saldo\n" +
					"5. Mostrar maior saldo\n"+
					"6. Sair");
			opcao = scan.next().charAt(0);
			scan.nextLine();
			switch (opcao){
			case '1':
				System.out.println("Insira o nome:");
				nome = scan.nextLine();
				System.out.println("Insira o cpf:");
				cpf = scan.nextLine();
				System.out.println("Insira o telefone:");
				telefone = scan.nextLine();
				System.out.println("Insira o e-mail:");
				email = scan.nextLine();
				System.out.println("Insira o saldo:");
				saldo = scan.nextDouble();
				
				if (arvore.inserir(new Item(nome,cpf,telefone,email,saldo))){
					
					System.out.println("insercao efetuada com sucesso");
					
				}else{
					
					System.out.println("inserção não efetuada, "+
							"valor já existe");
					
				}
				break;
				
			case '2':
				
				
				System.out.println("Insira o nome do cliente: ");
				nome = scan.nextLine();
				
				mensagem = arvore.mostrarDados(nome);
				
				System.out.println(mensagem);
				
				
				
				
				break;
				
				
			case '3':
				
				mensagem = Arvore.ordenarAlfabetico(arvore);
				
				System.out.println(mensagem);
				
				break;
				
			case '4':
				
				media = Arvore.mediaAritimetica(arvore);
				
				System.out.println("A média de saldo é de: "+media);
				
				break;
				
			case '5':
				
				mensagem = Arvore.maiorSaldo(arvore);
				System.out.println(mensagem);
				
				break;
				
			case '6':
				System.out.println("Encerrando");
				break;
				
			default: 
				System.out.println("Entrada inválida, tente novamente");
			}
		} while (opcao!='6');
		
		System.exit(0);
		
	}
}
