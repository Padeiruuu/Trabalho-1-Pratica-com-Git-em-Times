public class Empresa {

	public void setPedidos() {

	}

	public void avaliarPedidos() {

	}

	public void menuUsuário() {

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

}
