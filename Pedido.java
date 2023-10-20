import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private Funcionario funcionario;

	private Departamentos departamento;

	private String dataPedido;

	private String dataFechamento;

	private String status;

	private List<Item> itens;

	private List<Pedido> pedidosFechados = new ArrayList<>();;

	private int numero;

	private double total=0;

	public Pedido(Funcionario funcionario, Departamentos departamento, String dataPedido, String dataFechamento, String status, int numero){
		this.funcionario=funcionario;
		this.departamento=departamento;
		this.dataPedido=dataPedido;
		this.dataFechamento=dataFechamento;
		this.status=status;
		this.numero=numero;
		itens=new ArrayList<>();
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public Departamentos getDepartamento() {
		return departamento;
	}

	public String getDataPedido() {
		return dataPedido;
	}

	public void setDataFechamento(String dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public String getDataFechamento() {
		return dataFechamento;
	}

	public String getStatus() {
		return status;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setStatus(String status){
		this.status=status;
	}

	public void adicionaItens(Item item){
		itens.add(item);
		total+=item.getValorTotal();
	}

	public void removeItens(Item item){
		itens.remove(item);
	}

	public int getNumeroPedido(){
		return numero;
	}

	public double Total(){
//		for (Item i:
//			 itens) {
//			total+=i.getValorTotal();
//		}
		return total;
	}

//	@Override
//	public String toString() {
//		return "Pedido{" +
//				"funcionario=" + funcionario +
//				", departamento=" + departamento +
//				", dataPedido='" + dataPedido + '\'' +
//				", dataFechamento='" + dataFechamento + '\'' +
//				", status='" + status + '\'' +
//				", itens=" + itens +
//				", pedidosFechados=" + pedidosFechados +
//				", numero=" + numero +
//				", total=" + total +
//				'}';
//	}
@Override
public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("Pedido{");
	sb.append("funcionario=").append(funcionario.getNome()); // Imprime o nome do funcionário
	sb.append(", departamento=").append(departamento.getNome()); // Imprime o nome do departamento
	sb.append(", dataPedido='").append(dataPedido).append('\'');
	sb.append(", dataFechamento='").append(dataFechamento).append('\'');
	sb.append(", status='").append(status).append('\'');

	sb.append("\nItens:");
	for (Item item : itens) {
		sb.append("\n - ").append(item.getDescricao()); // Imprime a descrição do item
	}

	sb.append(", numero=").append(numero);
	sb.append(", total=").append(total);
	sb.append('}');
	return sb.toString();
}
}
