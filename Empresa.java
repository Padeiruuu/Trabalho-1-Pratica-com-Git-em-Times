import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Empresa {

	Departamentos depto1;
	Departamentos depto2;
	Departamentos depto3;
	Departamentos depto4;
	Departamentos depto5;

	Funcionario func1;
	Funcionario func2;
	Funcionario func3;
	Funcionario func4;
	Funcionario func5;
	Funcionario func6;
	Funcionario func7;
	Funcionario func8;
	Funcionario func9;
	Funcionario func10;
	Funcionario func11;
	Funcionario func12;
	Funcionario func13;
	Funcionario func14;
	Funcionario func15;

	private List<Pedido> pedidos; //= new ArrayList<>();
	private List<Pedido> pedidosFechados;// = new ArrayList<>();
	private List<Pedido> pedidosReprovados;
	private List<Departamentos> departamentos; // = new ArrayList<>();
	public Empresa(){
		pedidos = new ArrayList<>();
		pedidosFechados = new ArrayList<>();
		pedidosReprovados = new ArrayList<>();
		departamentos = new ArrayList<>();
		depto1 = new Departamentos("RH", 10000);
		depto2 = new Departamentos("Financeiro",10000);
		depto3 = new Departamentos("Tecnologia",10000);
		depto4 = new Departamentos("Arquitetura",10000);
		depto5 = new Departamentos("Administração",10000);
		func1 = new Funcionario(12345,"Carla","Car",depto1);
		func2 = new Funcionario(12346,"Carlos","Car",depto1);
		func3 = new Funcionario(12347,"Maria","Mar",depto1);
		func4 = new Funcionario(15345,"Cristina","Cri",depto2);
		func5 = new Funcionario(12645,"Roberta","Rob",depto2);
		func6 = new Funcionario(12745,"Ronaldo","Ron",depto2);
		func7 = new Funcionario(12845,"Jack","Jac",depto3);
		func8 = new Funcionario(12325,"Joana","Joa",depto3);
		func9 = new Funcionario(13545,"Alberto","Alb",depto3);
		func10 = new Funcionario(23345,"Jackson","Jac",depto4);
		func11 = new Funcionario(22345,"Rickson","Ric",depto4);
		func12 = new Funcionario(42345,"Jonas","Jon",depto4);
		func13 = new Funcionario(32345,"Maria","Mar",depto5);
		func14 = new Funcionario(72345,"Ricardo","Ric",depto5);
		func15 = new Funcionario(92345,"Vitor","Vit",depto5);
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
	public void operacoes(Scanner in){
		//Scanner in = new Scanner(System.in);
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

								System.out.printf("\nData de entrega: ");
								String dataFechamento = in.next();

								System.out.printf("\nStatus: ");
								String status = in.next();

								System.out.println("\nCódigo do produto: ");
								int c = in.nextInt();

								if(!pedidos.isEmpty()) {
									boolean repetido = false;
									for (Pedido w :
											pedidos) {
										if (w.getNumeroPedido() == c) {
											System.out.println("Pedido já existente: ");
											repetido = true;
											break;
										}
									}

									if (repetido) {
										break;
									}
								}


								for (Departamentos d:
									 departamentos) {
									System.out.println(d);
								}

								System.out.printf("\nNome do funcionário: ");
								String nomeFuncionario = in.next();
								Pedido novoPedido=null;
								boolean funEncont = false;
								Funcionario h=null;

								for (Departamentos dep : departamentos ) {
									for ( Funcionario f : dep.getFuncionarios()) {
										if(f.getNome().equalsIgnoreCase(nomeFuncionario)){
											h = f;
											funEncont=true;
											break;
										}
									}
								}
								if(!funEncont){
									System.out.println("Não há funcionário com esse nome");
									break;
								}
								novoPedido = new Pedido(h, h.getDepartamento(), dataPedido, dataFechamento, status, c);
								h.addPedido(novoPedido);
								pedidos.add(novoPedido);



								System.out.println("Quantos itens deseja adicionar? ");
								int i = in.nextInt();
								boolean pedidoUltrapassaMaximo=false;
								for (int x=0;x<i;x++){
									System.out.println("Informe a descrição: ");
									String descricao = in.next();
									System.out.println("Informe o valor unitário: ");
									double valorUnitario = in.nextDouble();
									System.out.println("Informe a quantidade: ");
									int quantidade = in.nextInt();
									double valorTotal = valorUnitario * quantidade;

									if(novoPedido.Total()+valorTotal<novoPedido.getDepartamento().getValorMaximo()){
										Item item = new Item(descricao, valorUnitario, quantidade, valorTotal);
										novoPedido.adicionaItens(item);
									}else{
										System.out.println("Pedido ultrapassa valor máximo. Impossível adicionar tal item.");
										pedidoUltrapassaMaximo=true;
										break;
									}

									if (!pedidoUltrapassaMaximo) {
										System.out.println("Itens adicionados ao pedido com sucesso!");
									}
								}

								break;
							case 2:
								System.out.println("Exclusão de aquisição: ");
								System.out.println("\nNome do funcionário: ");
								for (Departamentos d:
										departamentos) {
									System.out.println(d);
								}
								String nomeFunc = in.next();
								boolean fEncontrado = false;
								for (Departamentos dep : departamentos ) {
									for ( Funcionario f : dep.getFuncionarios()) {
										if(f.getNome().equalsIgnoreCase(nomeFunc)){
											fEncontrado = true;
											if(f.getPedidos().isEmpty()){
												System.out.println("O funcionário não possui pedidos");
												break;
											}
											for (Pedido g:
												 f.getPedidos()) {
												System.out.println(g);
											}
											System.out.printf("\nDigite o número do pedido que você deseja excluir: ");
											int numPedido = in.nextInt();
											boolean pedidoRemovido = false;
//
											Iterator<Pedido> iterator = pedidos.iterator();
											while (iterator.hasNext()) {
												Pedido pedido = iterator.next();
												if (pedido.getNumeroPedido() == numPedido) {
													iterator.remove();
													f.removePedido(pedido);
													pedidoRemovido = true;
												}
											}
											if (pedidoRemovido) {
												System.out.println("Pedido removido com sucesso.");
											}else {
												System.out.println("Pedido não encontrado");
											}
											break;
										}
									}
								}
								if(!fEncontrado){
									System.out.println("Funcionário não encontrado");
								}
								break;
							case 3:

								if(pedidos.size()==0){
									System.out.println("Não há pedidos registrados");
									break;
								}
								for (Pedido ped : pedidos) {
									System.out.println(ped);
								}
								System.out.printf("\nDigite o número do pedido que você deseja fechar: ");
								int numPedido = in.nextInt();
								List<Pedido> pedidosARemover = new ArrayList<>();
								Iterator<Pedido> iterator = pedidos.iterator();
								while (iterator.hasNext()) {
									Pedido pedido = iterator.next();
									if (pedido.getNumeroPedido() == numPedido) {
										if (pedido.getStatus().equals("APROVADO")) {
											System.out.println("Digite a data em que o pedido foi fechado: ");
											String f = in.next();
											pedido.setDataFechamento(f);
											pedidosARemover.add(pedido);
											pedidosFechados(pedido);
										} else {
											System.out.println("Pedido ainda não foi aprovado.");
										}
									}
								}

								pedidos.removeAll(pedidosARemover);
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

								System.out.printf("\nData do pedido: ");
								String dataPedido = in.next();

								System.out.printf("\nData de entrega: ");
								String dataFechamento = in.next();

								System.out.printf("\nStatus: ");
								String status = in.next();

								System.out.println("\nCódigo do produto: ");
								int c = in.nextInt();

								if(!pedidos.isEmpty()) {
									boolean repetido = false;
									for (Pedido w :
											pedidos) {
										if (w.getNumeroPedido() == c) {
											System.out.println("Pedido já existente: ");
											repetido = true;
											break;
										}
									}

									if (repetido) {
										break;
									}
								}


								for (Departamentos d:
										departamentos) {
									System.out.println(d);
								}

								System.out.printf("\nNome do funcionário: ");
								String nomeFuncionario = in.next();
								Pedido novoPedido=null;
								boolean funEncont = false;
								Funcionario h=null;

								for (Departamentos dep : departamentos ) {
									for ( Funcionario f : dep.getFuncionarios()) {
										if(f.getNome().equalsIgnoreCase(nomeFuncionario)){
											h = f;
											funEncont=true;
											break;
										}
									}
								}
								if(!funEncont){
									System.out.println("Não há funcionário com esse nome");
									break;
								}
								novoPedido = new Pedido(h, h.getDepartamento(), dataPedido, dataFechamento, status, c);
								h.addPedido(novoPedido);
								pedidos.add(novoPedido);



								System.out.println("Quantos itens deseja adicionar? ");
								int i = in.nextInt();
								boolean pedidoUltrapassaMaximo=false;
								for (int x=0;x<i;x++){
									System.out.println("Informe a descrição: ");
									String descricao = in.next();
									System.out.println("Informe o valor unitário: ");
									double valorUnitario = in.nextDouble();
									System.out.println("Informe a quantidade: ");
									int quantidade = in.nextInt();
									double valorTotal = valorUnitario * quantidade;

									if(novoPedido.Total()+valorTotal<novoPedido.getDepartamento().getValorMaximo()){
										Item item = new Item(descricao, valorUnitario, quantidade, valorTotal);
										novoPedido.adicionaItens(item);
									}else{
										System.out.println("Pedido ultrapassa valor máximo. Impossível adicionar tal item.");
										pedidoUltrapassaMaximo=true;
										break;
									}

									if (!pedidoUltrapassaMaximo) {
										System.out.println("Itens adicionados ao pedido com sucesso!");
									}
								}

								break;
							case 2:

								if(pedidos.size()==0){
									System.out.println("Não há pedidos registrados");
									break;
								}
								System.out.println("-------< PEDIDOS >-------");
								for (Pedido p:
									 pedidos) {
									System.out.println(p);
								}
								System.out.println("Digite o pedido a ser avaliado: ");
								int pedid = in.nextInt();
								List<Pedido> pedidoRemove = new ArrayList<>();
								for (Pedido p : pedidos) {
									if (p.getNumeroPedido() == pedid) {
										System.out.println(p);
										System.out.println("Qual a avaliação do pedido:\n\nAprovado\nReprovado\n");
										String s = in.next().toUpperCase();
										p.setStatus(s);
										if (p.getStatus().equalsIgnoreCase("reprovado")) {
											pedidosReprovados(p);
											pedidoRemove.add(p);
										}
									}
								}
								pedidos.removeAll(pedidoRemove);
								break;
							case 3:
								System.out.println("Digite a data de início: ");
								String di = in.next();
								System.out.println("Digite a data de fim: ");
								String df = in.next();
								if(pedidos.size()==0){
									System.out.println("Não há pedidos registrados");
									break;
								}
								System.out.println("-------< PEDIDOS >-------");
								for (Pedido q:
									 pedidosEntreDatas(di,df)) {
									System.out.println(q);
								}
								break;
							case 4:
								System.out.println("Digite o nome do funcionário solicitante: ");
								String f = in.next();
								Boolean achado = false;
								for (Departamentos dep : departamentos ) {
									for (Funcionario fun : dep.getFuncionarios()) {
										if(fun.getNome().equalsIgnoreCase(f)){
											achado=true;
											if(fun.getPedidos().isEmpty()){
												System.out.println("Funcionário não possui pedidos");
												break;
											}else{
												System.out.println(fun.getPedidos());
											}
										}
									}
								}
								if(!achado){
									System.out.println("Não há funcionário com esse nome");
								}
								for (Pedido p: pedidos) {
									if(p.getFuncionario().getNome().equals(f)){
										System.out.println(p);
									}
								}
								break;
							case 5:
								System.out.printf("Digite a descrição do item: ");
								String descricao = in.next();
								if(!pedidoPorDescricao(descricao).isEmpty()){
									for (Pedido pedido: pedidoPorDescricao(descricao)){
										System.out.println(pedido);
									}
								}else{
									System.out.println("Nenhum pedido encontrado com a descrição inserida.");
								}
								break;
							case 6:
								System.out.println("Estatísticas Gerais\n");
								System.out.println("Pedidos Totais:");
								if(!(pedidos.isEmpty() && pedidosFechados.isEmpty() && pedidosReprovados.isEmpty())) {
									System.out.print("Número de pedidos:");
									int num = pedidos.size()+pedidosFechados.size() + pedidosReprovados.size();
									System.out.println(num+"\n");

									for (Pedido pedido : pedidos) {
										System.out.println(pedido);
									}

									System.out.println("-----< APROVADOS >-----");
									for (Pedido pedi : pedidos) {
										if(pedi.getStatus().equalsIgnoreCase("aprovado")) {
											System.out.println(pedi);
										}
									}
									for (Pedido pedi : pedidosFechados) {
										if(pedi.getStatus().equalsIgnoreCase("aprovado")) {
											System.out.println(pedi);
										}
									}

									System.out.println("\nNúmero de pedidos nos últimos 30 dias e o valor médio");

									System.out.println("-------< PEDIDOS >-------");
									String din = "20/09/2023";
									String dfi = "10/10/2023";
									for (Pedido q:
											pedidosEntreDatas(din,dfi)) {
										System.out.println(q);
									}
									System.out.println("-------< VALOR MÉDIO >-------");
									double soma=0;
									int count=0;
									for (Pedido q:
											pedidosEntreDatas(din,dfi)) {
										soma+=q.Total();
										count++;
									}
									double media = soma/count;
									System.out.println(media);

									System.out.println("\nValor total de cada categoria nos ultimos 30 dias");

									double somaAp = 0;

									for (Pedido pedi : pedidos) {
										if(pedi.getStatus().equalsIgnoreCase("aprovado")) {
											somaAp+=pedi.Total();
										}
									}
									System.out.println("Total Abertos: " + somaAp);
									double somaFe = 0;
									for (Pedido pedi : pedidosFechados) {
										somaFe+=pedi.Total();
									}
									System.out.println("Total Fechados: " + somaFe);
									double somaRe = 0;
									for (Pedido pedi : pedidosReprovados) {
										somaRe+=pedi.Total();
									}
									System.out.println("Total Reprovados: " + somaRe);
									System.out.println("\nPedido 'ABERTO' de maior valor");
									Pedido pedidoMaiorValor = null;
									double maiorValor = Double.MIN_VALUE;

									for (Pedido pedido : pedidos) {
										if (pedido.Total() > maiorValor) {
											maiorValor = pedido.Total();
											pedidoMaiorValor = pedido;
										}
									}
									System.out.println(pedidoMaiorValor);

								}else{
									System.out.println("Não há pedidos cadastrados");
								}

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

	public void pedidosReprovados(Pedido p){
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
