import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ListadeMenu {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException{
		Scanner scanner = new Scanner(System.in);
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		boolean rodando = true;
		while(rodando) {
			System.out.println("[1] - Cadastrar de Cliente");
			System.out.println("[2] - Listar todos Cliente cadastrados");
			System.out.println("[3] - Procurar usuario por Nome");
			System.out.println("[4] - Alterar dados de um Cliente");
			System.out.println("[5] - Excluir Cliente");
			System.out.println("[6] - Gravar em arquivo");
			System.out.println("[7] - Consultar arquivo");
			System.out.println("[8] - Sair");
			System.out.println("Digite a opçao: *");
			String opcao = scanner.nextLine();
			
			switch(opcao) {
				case "1": {
					System.out.println("===== CADASTRO DE CLIENTE =====");
					System.out.print("Digite o nome: ");
					String nome = scanner.nextLine();
					System.out.print("Digite o sobrenome: ");
					String sobrenome = scanner.nextLine();
					System.out.print("Digite o seu idade: ");
					String idade = scanner.nextLine();
					System.out.print("Digite lista de endereço: ");
					String endereco = scanner.nextLine();
					System.out.print("Digite seu saldo: ");
					Double saldo = scanner.nextDouble();
					Cliente c = new Cliente();
					c.setNome(nome);
					c.setSobrenome(sobrenome);
					c.setIdade(idade);
					c.setEndereco(endereco);
					c.setSaldo(saldo);
					
					
					clientes.add(c);
					break;
				}
				case "2": {
					System.out.println("===== CLIENTES CADASTRADOS =====");
					for (int i = 0; i < clientes.size(); i++) {
						Cliente uTemp = clientes.get(i);
						System.out.println("Cliente: " + i);
						System.out.println("\tNome: " + clientes.get(i).getNome());
						System.out.println("\tSobrenome: " + clientes.get(i).getSobrenome());
						System.out.println("\tIdade: " + clientes.get(i).getIdade());
						System.out.println("\tEndereço: " + clientes.get(i).getEndereco());
						System.out.println("\tSaldo: " + uTemp.getSaldo());
					}
					break;
				}
				case "3": {
					System.out.println("===== PROCURAR CLIENTE POR Nome =====");
					System.out.print("Digite o nome: ");
					String nome = scanner.nextLine();
					boolean encontrado = false;
					for (int i = 0; i < clientes.size(); i++) {
						Cliente uTemp = clientes.get(i);
						
						if( nome.equals(uTemp.getNome())) {
							System.out.println("Cliente encontrado");
							System.out.println("Cliente: " + i);
							System.out.println("\tNome: " + clientes.get(i).getNome());
							System.out.println("\tSobrenome: " + clientes.get(i).getSobrenome());
							System.out.println("\tIdade: " + clientes.get(i).getIdade());
							System.out.println("\tEndereço: " + clientes.get(i).getEndereco());
							System.out.println("\tSaldo: " + uTemp.getSaldo());
							encontrado = true;
							break;
						} 
					}
					
					if (!encontrado) {
						System.out.println("Não foi encontrado nenhum cliente com esse nome");
					}
					break;
				}
				case "4": {
					System.out.println("===== ATUALIZAÇÃO DE CLIENTE =====");
					
					for (int i = 0; i < clientes.size(); i++) {
						
						Cliente uTemp = clientes.get(i);
						
						System.out.println("[" + i + "} " + uTemp.getNome());
					}
					
					System.out.print("Digite o valor de referência: ");
					int referencia = scanner.nextInt();
					scanner.nextLine();
					
					System.out.print("Digite o novo nome: ");
					String novoNome = scanner.nextLine();

					System.out.print("Digite a nova sobrenome: ");
					String novoSobrenome = scanner.nextLine();

					System.out.print("Digite a nova idade: ");
					String novoIdade = scanner.nextLine();
					
					System.out.print("Digite a nova endereço: ");
					String novoEndereco = scanner.nextLine();

					System.out.print("Digite a nova saldo: ");
					Double novoSaldo = scanner.nextDouble();
					
					Cliente c = clientes.get(referencia);
					c.setNome(novoNome);
					c.setSobrenome(novoSobrenome);
					c.setIdade(novoIdade);
					c.setEndereco(novoEndereco);
					c.setSaldo(novoSaldo);
					break;
				}
				case "5": {
					System.out.println("===== REMOVER CLIENTE =====");
					
					for (int i = 0; i < clientes.size(); i++) {
						Cliente uTemp = clientes.get(i);

						System.out.println("[" + i + "} " + uTemp.getNome());
					}
					
					System.out.print("Digite o valor de referência: ");
					int referencia = scanner.nextInt();
					scanner.nextLine();
					
					clientes.remove(referencia);
					break;
				}
				case "6": {
					FileWriter arquivo = new FileWriter("C:\\arquivo.txt");
					PrintWriter gravarArquivo = new PrintWriter(arquivo);
					
					for (int i = 0; i < clientes.size(); i++) {
						Cliente uTemp = clientes.get(i);
						
						for(int registros=0; registros<3; ) {
							gravarArquivo.printf("Informações de Clientes%n%n");
							gravarArquivo.printf("\tNome: " + uTemp.getNome());
							gravarArquivo.printf("\tSobrenome: " + uTemp.getSobrenome());
							gravarArquivo.printf("\tIdade: " + uTemp.getIdade());
							gravarArquivo.printf("\tEndereço: " + uTemp.getEndereco());
							gravarArquivo.printf("\tSaldo: " + uTemp.getSaldo());
							break;
						} 
					}
					arquivo.close();
					System.out.println("Gravado na arquivo");
					System.out.println("Local salvo é: C:\\arquivo.txt");
					break;
				}
				case "7": {  
				    String mostra="";
				    String nomeArq = "c:\\arquivo.txt"; 
				    String linha = "";
				    File arq = new File(nomeArq);
				 
				    if (arq.exists()){ 
				      mostra="Arquivo - '"+nomeArq+"', aberto com sucesso!\n";
				      mostra+="Tamanho do arquivo "+Long.toString(arq.length())+"\n";
				      try{
				        FileReader reader = new FileReader(nomeArq);
				        BufferedReader leitor = new BufferedReader(reader);
				        while(true){
				          linha=leitor.readLine();
				          if(linha==null)
				            break;
				          mostra+=linha +"\n";
				          System.out.println(linha);
		 
				        }
				      }
				      catch(Exception erro) {}
				      JOptionPane.showMessageDialog(null,mostra,"Arquivo...",1);
				    }
				    else
				      JOptionPane.showMessageDialog(null,"Arquivo nao existe!","Erro",0);
					break;
			}
				case "8": {
					System.out.print("Sair");
					rodando = false;
					break;
				}
				default:
					System.out.println("Opção Inválida!!!");
			}
			
		}
	}

}
