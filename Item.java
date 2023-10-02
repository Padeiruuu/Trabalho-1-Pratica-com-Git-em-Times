public class Item {

	private String descricao;

	private double valorUnitario;

	private int quantidade;

	private double valorTotal;

	public Item(String descricao, double valorUnitario, int quantidade, double valorTotal){
		this.descricao=descricao;
		this.valorUnitario=valorUnitario;
		this.quantidade=quantidade;
		this.valorTotal=valorTotal;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public String getDescricao() {
		return descricao;
	}

}
