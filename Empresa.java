import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Empresa {

	private List<Pedido> pedidos = new ArrayList<>();
	private List<Pedido> pedidosFechados = new ArrayList<>();
	private List<Departamentos> departamentos = new ArrayList<>();

	public Empresa(){
		Departamentos depto1 = new Departamentos("RH", 10000);
		Departamentos depto2 = new Departamentos("Financeiro",10000);
		Departamentos depto3 = new Departamentos("Tecnologia",10000);
		Departamentos depto4 = new Departamentos("Arquitetura",10000);
		Departamentos depto5 = new Departamentos("Administração",10000);

		Funcionario func1 = new Funcionario(12345,"Carla","Car",depto1);
		Funcionario func2 = new Funcionario(12346,"Carlos","Car",depto1);
		Funcionario func3 = new Funcionario(12347,"Maria","Mar",depto1);
		Funcionario func4 = new Funcionario(15345,"Cristina","Cri",depto2);
		Funcionario func5 = new Funcionario(12645,"Roberta","Rob",depto2);
		Funcionario func6 = new Funcionario(12745,"Ronaldo","Ron",depto2);
		Funcionario func7 = new Funcionario(12845,"Jack","Jac",depto3);
		Funcionario func8 = new Funcionario(12325,"Joana","Joa",depto3);
		Funcionario func9 = new Funcionario(13545,"Alberto","Alb",depto3);
		Funcionario func10 = new Funcionario(23345,"Jackson","Jac",depto4);
		Funcionario func11 = new Funcionario(22345,"Rickson","Ric",depto4);
		Funcionario func12 = new Funcionario(42345,"Jonas","Jon",depto4);
		Funcionario func13 = new Funcionario(32345,"Maria","Mar",depto5);
		Funcionario func14 = new Funcionario(72345,"Ricardo","Ric",depto5);
		Funcionario func15 = new Funcionario(92345,"Vitor","Vit",depto5);
		depto1.addFuncionarios(func1);
		depto1.addFuncionarios(func2);
		depto1.addFuncionarios(func3);
		depto2.addFuncionarios(func4);
		depto2.addFuncionarios(func5);
		depto2.addFuncionarios(func6);
		depto3.addFuncionarios(func7);
		depto3.addFuncionarios(func8);
		depto3.addFuncionarios(func9);
		depto4.addFuncionarios(func10);
		depto4.addFuncionarios(func11);
		depto4.addFuncionarios(func12);
		depto5.addFuncionarios(func13);
		depto5.addFuncionarios(func14);
		depto5.addFuncionarios(func15);
		departamentos.add(depto1);
		departamentos.add(depto2);
		departamentos.add(depto3);
		departamentos.add(depto4);
		departamentos.add(depto5);
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

								System.out.printf("\nData do pedido: ");
								String dataPedido = in.next();

								System.out.printf("\nData de fechamento: ");
								String dataFechamento = in.next();

								System.out.printf("\nStatus: ");
								String status = in.next();

								System.out.println("\nCódigo do produto: ");
								int c = in.nextInt();
								for ( Pedido w:
										pedidos) {
									if(w.getNumeroPedido()==c){
										System.out.println("Pedido já existente: ");
										break;
									}
								}

								System.out.printf("\nNome do funcionário: ");
								System.out.println(departamentos);
								String nomeFuncionario = in.next();
								Pedido novoPedido=null;
								for (Departamentos dep : departamentos ) {
									for ( Funcionario f : dep.getFuncionarios()) {
										if(f.getNome().equals(nomeFuncionario)){
											novoPedido = new Pedido(f, f.getDepartamento(), dataPedido, dataFechamento, status, c);
											f.addPedido(novoPedido);
										}else{
											System.out.println("Não há funcionário com esse nome");
											break;
										}
									}
								}

								System.out.println("Quantos itens deseja adicionar? ");
								int i = in.nextInt();
								for (int x=0;x<i;x++){
									if(novoPedido.Total()<novoPedido.getDepartamento().getValorMaximo()){
										System.out.println("Informe a descrição: ");
										String descricao = in.next();
										System.out.println("Informe o valor unitário: ");
										double valorUnitario = in.nextDouble();
										System.out.println("Informe a quantidade: ");
										int quantidade = in.nextInt();
										System.out.println("Informe o valor total: ");
										double valorTotal = in.nextDouble();
										Item item = new Item(descricao, valorUnitario, quantidade, valorTotal);
										novoPedido.adicionaItens(item);
									}else{
										System.out.println("Pedido ultrapassa valor máximo. Impossível adicionar tal item.");
										break;
									}
								}




								break;
							case 2:
								System.out.println("Exclusão de aquisição: ");
								System.out.printf("\nDigite o número do pedido que você deseja excluir: ");
								int numPedido = in.nextInt();

								boolean pedidoRemovido = false;

								for(Pedido pedido : pedidos){
									if(pedido.getNumeroPedido() == numPedido){
										pedidos.remove(pedido);
										pedidoRemovido = true;
									}
								}
								if (pedidoRemovido) {
									System.out.println("Pedido removido com sucesso.");
								}else {
									System.out.println("Pedido não encontrado");
								}
								break;
							case 3:
								System.out.println("Você escolheu fechar um pedido.");
								for (Pedido ped : pedidos) {
									System.out.println(ped);
								}
								System.out.printf("\nDigite o número do pedido que você deseja fechar: ");
								int numPedid = in.nextInt();
								for (Pedido ped : pedidos) {
									if (ped.getNumeroPedido()==numPedid){
										pedidos.remove(ped);
										pedidosFechados(ped);
									}else{
										System.out.println("Pedido não encontrado.");
									}
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
								for (Departamentos dep : departamentos ) {
									System.out.println(dep.getFuncionarios());
								}
								String nomeFuncionario = in.next();
								Funcionario fu=null;
								for (Departamentos dep : departamentos ) {
									for ( Funcionario f : dep.getFuncionarios()) {
										if(f.getNome().equals(nomeFuncionario)){
											fu = new Funcionario(f.getIdentificador(),f.getNome(),f.getIniciais(),f.getDepartamento());
										}
									}
								}

								System.out.printf("\nData do pedido: ");
								String dataPedido = in.next();

								System.out.printf("\nData de fechamento");
								String dataFechamento = in.next();

								System.out.printf("\nStatus");
								String status = in.next();

								System.out.println("\nCódigo do produto: ");
								int c = in.nextInt();
								for ( Pedido w:
									 pedidos) {
									if(w.getNumeroPedido()==c){
										System.out.println("Pedido já existente: ");
										break;
									}
								}

								Pedido novoPedido = new Pedido(fu, fu.getDepartamento(), dataPedido, dataFechamento, status, c);

								System.out.println("Quantos itens deseja adicionar? ");
								int i = in.nextInt();
								for (int x=0;x<i;x++){
									System.out.println("Informe a descrição: ");
									String descricao = in.next();
									System.out.println("Informe o valor unitário: ");
									double valorUnitario = in.nextDouble();
									System.out.println("Informe a quantidade: ");
									int quantidade = in.nextInt();
									System.out.println("Informe o valor total: ");
									double valorTotal = in.nextDouble();
									Item item = new Item(descricao,valorUnitario,quantidade,valorTotal);
									novoPedido.adicionaItens(item);
								}
								break;
							case 2:
								for (Pedido p:
									 pedidos) {
									System.out.println(p);
								}
								System.out.println(pedidos);
								System.out.println("Digite o pedido a ser avaliado: ");
								int pedid = in.nextInt();
								for (Pedido p : pedidos) {
									if(p.getNumeroPedido()==pedid){
										System.out.println("Status atual " + p.getStatus());
										System.out.println("Qual a avaliação do pedido:\n1 - Aprovado\n2 - Reprovado\n3 - Pendente\n");
										String s = in.next();
										p.setStatus(s);
										break;
									}
								}
								break;
							case 3:
								System.out.println("Digite a data de início: ");
								String di = in.next();
								System.out.println("Digite a data de fim: ");
								String df = in.next();
								for (Pedido q:
									 pedidosEntreDatas(di,df)) {
									System.out.println(q);
								}
								break;
							case 4:
								System.out.println("Digite o nome do funcionário solicitante: ");
								String f = in.next();
								for (Pedido p: pedidos) {
									if(p.getFuncionario().getNome()==f){
										System.out.println(p);
									}
								}
								break;
							case 5:
								System.out.printf("Digite a descrição do item: ");
								String descricao = in.next();
								if(!pedidoPorDescricao(descricao).isEmpty()){
									System.out.println("Descrições encontradas");
									for (Pedido pedido: pedidoPorDescricao(descricao)){
										System.out.println("O número do pedido é: "+pedido.getNumeroPedido());
									}
								}else{
									System.out.println("Nenhum pedido encontrado com a descrição inserida.");
								}
								break;
							case 6:
								System.out.println("Estatisticas Gerais");
								System.out.println("Pedidos:");
								int pedidoTotal = in.nextInt();
								for (Pedido pedido: pedidos){
									 pedidoTotal = pedido.getNumeroPedido();
								}
								if(pedidoTotal <= 0){
									System.out.println("Não ocorreram pedidos.");
								}else{
									System.out.println("O número de pedidos total é: "+pedidoTotal);
								}

								System.out.println("Numero de pedidos nos ultimos 30 dias e o valor medio");
								//COMO FAZ PRA VERIFCIAR A DATAAAAAAAA

								System.out.println("Valor total de cada categoria nos ultimos 30 dias");
								//Não faço ideia de como fazer isso;

								System.out.println("Pedido de aquisição");
								//A gente nao tem nenhum metodo que fala sobre pedidos abertos, aprovados, reprovados
								//então nao sei o que fazer

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

	public void pedidosFechados(Pedido p){
		pedidosFechados.add(p);
	}

	public ArrayList<Pedido> pedidoPorDescricao(String descricao) {
		ArrayList<Pedido> pedidosPorDescricao = new ArrayList<>();
		for(Pedido pedido : pedidos) {
			ArrayList<Item> itens = (ArrayList<Item>) pedido.getItens();
			for(Item item : itens) {
				if(item.getDescricao().equals(descricao)) {
					pedidosPorDescricao.add(pedido);
				}
			}
		}
		return pedidosPorDescricao;
	}

	public ArrayList<Pedido> pedidosEntreDatas(String dataInicial, String dataFinal) {
		ArrayList<Pedido> pedidosEntreDatas = new ArrayList<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Date inicio = dateFormat.parse(dataInicial);
			Date fim = dateFormat.parse(dataFinal);

			for (Pedido pedido : pedidos) {
				Date dataPedido = dateFormat.parse(pedido.getDataPedido());

				if (dataPedido.compareTo(inicio) >= 0 && dataPedido.compareTo(fim) <= 0) {
					pedidosEntreDatas.add(pedido);
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return pedidosEntreDatas;
	}
//	public void removePedido(int numPedido, int quantidade) {
//		if(aberta && numPedido >= 1 && numPedido <= listaPedido.size() && quantidade > 0){
//			Pedido pedido = listaPedido.get(numPedido - 1);
//			if(quantidade < pedido.getQuantidade()){
//				pedido.setQuantidade(pedido.getQuantidade() - quantidade);
//			} else{
//				listaPedido.remove(pedido);
//			}
//		}
//	}
//	public void fechaPedido(Pedido pedido) {
//
//		boolean pedidoEncontrado = false;
//
//		for(Pedido p : listaPedidos){
//			if(p.equals(pedido)){
//				pedidoEncontrado = true;
//				p.setStatus("Pedido Fechado");
//				getPedidosDescricao();
//			}
//		}
//		if(!pedidoEncontrado){
//			System.out.println("Pedido não encontrado. Não foi possível fechá-lo.");
//		}
//	}

}
