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
	}

	public void removeItens(Item item){
		itens.remove(item);
	}

	public int getNumeroPedido(){
		return numero;
	}

	public double Total(){
		for (Item i:
			 itens) {
			total+=i.getValorTotal();
		}
		return total;
	}

	@Override
	public String toString() {
		return "Pedido{" +
				"funcionario=" + funcionario +
				", departamento=" + departamento +
				", dataPedido='" + dataPedido + '\'' +
				", dataFechamento='" + dataFechamento + '\'' +
				", status='" + status + '\'' +
				", itens=" + itens +
				", pedidosFechados=" + pedidosFechados +
				", numero=" + numero +
				", total=" + total +
				'}';
	}
}
