import java.util.*;
public class Empresa {

	private List<Pedido> pedidos = new ArrayList<>();

	public Empresa(){
		Departamentos depto1 = new Departamentos();
		Departamentos depto2 = new Departamentos();
		Departamentos depto3 = new Departamentos();
		Departamentos depto4 = new Departamentos();
		Departamentos depto5 = new Departamentos();
	}

	public void menuFuncionario(){
		String menuFuncionario = """
    			1. Registrar um novo pedido de aquisição
    			2. Excluir pedido de aquisição
    			3. Fechar pedido de aquisição
    			4. Sair
				""";
		System.out.println(menuFuncionario);
	}

	public void menuAdministrador(){
		String menuAdministrador = """
    			1. Registrar um novo pedido de aquisição 
    			2. Avaliar pedido de aquisição
    			3. Visualizar pedidos entre duas datas
    			4. Buscar pedidos por funcionário solicitante
    			5. Buscar pedidos pela descrição de um item
    			6. Visualizar estatísticas gerais
    			7. Sair
				""";
		System.out.println(menuAdministrador);
	}
	public void operacoes(){
		Scanner in = new Scanner(System.in);
		int option=0;
		int opt=0;
		int o=0;
		do{
			menuUsuario();
			System.out.println("Digite a opção: ");
			option = in.nextInt();
			switch(option){
				case 1:
					do {
						menuFuncionario();
						opt = in.nextInt();
						switch (opt) {
							case 1:
								System.out.println("Para registrar um novo pedido de aquisição informe: ");

								System.out.printf("\nNome do funcionário: ");
								String nomeFuncionario = in.nextLine();

								System.out.printf("\nNome do departamento: ");
								String nomeDepartamento = in.nextLine();

								System.out.printf("\nData do pedido: ");
								String dataPedido = in.nextLine();

								System.out.printf("\nData de fechamento");
								String dataFechamento = in.nextLine();

								System.out.printf("\nStatus");
								String status = in.nextLine();

								Funcionario funcionario = new Funcionario(nomeFuncionario);
								Departamentos departamentos = new Departamentos(nomeDepartamento);

								Pedido novoPedido = new Pedido(funcionario, departamentos, dataPedido, dataFechamento, status);

								break;
							case 2:
								System.out.println("Exclusão de aquisição: ");
								System.out.printf("\nDigite o número do pedido que você deseja excluir: ");
								int numPedido = in.nextInt();

								boolean pedidoRemovido = false;

								for(Pedido pedido : pedidos){
									if(pedido.getNumeroPedido() == numPedido){
										pedido.remove();
										pedidoRemovido = true;
										break;
									}
								}
								if (pedidoRemovido) {
									System.out.println("Pedido removido com sucesso.");
								}else {
									System.out.println("Pedido não encontrado");
								}
								break;
							case 3:
								System.out.println("Você escolheu fechar uma pedido.");
								System.out.printf("\nDigite o número do pedido que você deseja fechar: ");
								numPedido = in.nextInt();
								if (!pedidos.isEmpty() && numPedido >= 1 && numPedido <= pedidos.size()){
									Pedido pedidoAtual = pedidos.get(numPedido);
									if(!pedidoAtual.isFechada()){
										pedidoAtual.fecharPedido();
									}else{
										System.out.println("O pedido já está fechado.");
									}
								}else{
									System.out.println("Venda não encontrada.");
								}
								break;
							case 4:
								System.out.println("Voltando ao menu principal.");
								break;
							default:
								System.out.println("ERRO");
								break;
						}
					}while(opt!=4);
					break;
				case 2:
					do {
						menuAdministrador();
						o = in.nextInt();
						switch (o) {
							case 1:
								System.out.println("Para registrar um novo pedido de aquisição informe: ");

								System.out.printf("\nNome do funcionário: ");
								String nomeFuncionario = in.nextLine();

								System.out.printf("\nNome do departamento: ");
								String nomeDepartamento = in.nextLine();

								System.out.printf("\nData do pedido: ");
								String dataPedido = in.nextLine();

								System.out.printf("\nData de fechamento");
								String dataFechamento = in.nextLine();

								System.out.printf("\nStatus");
								String status = in.nextLine();

								Funcionario funcionario = new Funcionario(nomeFuncionario);
								Departamentos departamentos = new Departamentos(nomeDepartamento);

								Pedido novoPedido = new Pedido(funcionario, departamentos, dataPedido, dataFechamento, status);
								break;
							case 2:
								System.out.println(pedidos);
								System.out.println("Digite o pedido a ser excluído: ");
								p = in.nextInt();
								for (Pedido p : pedidos) {
									if(p.getCodigo==p){
										System.out.println("Status atual " + p.getStatus());
										System.out.println("Qual a avaliação do pedido:\n1 - Aprovado\n2 - Reprovado\n3 - Pendente\n");
										String s = in.next();
										p.setStatus(s);
									}
								}
								break;
							case 3:
								System.out.println("Digite a data de início: (Apenas números");
								int di = in.nextInt();
								System.out.println("Digite a data de fim: (Apenas números");
								int df = in.nextInt();
								//verificação
								//printa
								break;
							case 4:
								System.out.println("Digite o nome do funcionário solicitante: ");]
								f = in.nextLine();
								for (Pedido p: pedidos) {
									if(p.getFuncionario()==f){

									}
								}
								break;
							case 5:
								break;
							case 6:
								break;
							case 7:
								System.out.println("Voltando ao menu principal.");
								break;
							default:
								System.out.println("ERRO");
								break;
						}
					}while(o!=7);
					break;
				case 3:
					System.out.println("FIM");
					break;
				default:
					System.out.println("ERRO");
					break;
			}

		}while(option!=3);

	}

	public void setPedidos() {

	}

	public void avaliarPedidos() {

	}

	public void menuUsuario() {
		String menuUsuario = """
       			Digite o usuário:
       			
    			1. Funcionário
    			2. Administrador
    			3. Sair
    	
				""";
		System.out.println(menuUsuario);
	}

	public void getPedidos() {

	}

	public void getPedidosFuncionario() {

	}

	public void getPedidosDescricao() {

	}


	public void removePedido(int numPedido, int quantidade) {
		if(aberta && numPedido >= 1 && numPedido <= listaPedido.size() && quantidade > 0){
			Pedido pedido = listaPedido.get(numPedido - 1);
			if(quantidade < pedido.getQuantidade()){
				pedido.setQuantidade(pedido.getQuantidade() - quantidade);
			} else{
				listaPedido.remove(pedido);
			}
		}
	}
	public void fechaPedido(Pedido pedido) {

		boolean pedidoEncontrado = false;

		for(Pedido p : listaPedidos){
			if(p.equals(pedido)){
				pedidoEncontrado = true;
				p.setStatus("Pedido Fechado");
				getPedidosDescricao();
			}
		}
		if(!pedidoEncontrado){
			System.out.println("Pedido não encontrado. Não foi possível fechá-lo.");
		}
	}

	public void getEstatisticas() {

	}
}
