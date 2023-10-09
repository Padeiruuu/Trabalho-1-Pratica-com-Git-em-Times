import java.util.*;
public class Empresa {

	public Empresa(){
		Departamentos depto1 = new Departamentos();
		Departamentos depto2 = new Departamentos();
		Departamentos depto3 = new Departamentos();
		Departamentos depto4 = new Departamentos();
		Departamentos depto5 = new Departamentos();
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
								break;
							case 2:
								break;
							case 3:
								break;
							case 4:
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
								break;
							case 2:
								break;
							case 3:
								break;
							case 4:
								break;
							case 5:
								break;
							case 6:
								break;
							case 7:
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
		if(aberta && numPedido >= 1 && numPedido <= listPedido.size() && quantidade > 0){
			Pedido pedido = listPedido.get(numPedido - 1);
			if(quantidade < pedido.getQuantidade()){
				pedido.setQuantiade(pedido.getQuantiade() - quantidade);
			} else{
				listPedido.remove(pedido);
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
}
