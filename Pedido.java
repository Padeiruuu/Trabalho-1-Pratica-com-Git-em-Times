public class Pedido {

	private Funcionario funcionario;

	private Departamentos departamento;

	private String dataPedido;

	private String dataFechamento;

	private String status;

	private Item item;

	public Pedido(){

	}
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public Departamentos getDepartamento() {
		return departamento;
	}

	public int getDataPedido() {
		return 0;
	}

	public void getDataFechamento() {

	}

	public void getStatus() {

	}

	public void getItens() {

	}

	public void setStatus(String status){
		this.status=status;
	}
}
