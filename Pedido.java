import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private Funcionario funcionario;

	private Departamentos departamento;

	private String dataPedido;

	private String dataFechamento;

	private String status;

	private List<Item> itens;

	public Pedido(Funcionario funcionario, Departamentos departamento, String dataPedido, String dataFechamento, String status){
		this.funcionario=funcionario;
		this.departamento=departamento;
		this.dataPedido=dataPedido;
		this.dataFechamento=dataFechamento;
		this.status=status;
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

	}

	public void removeItens(Item item){

	}
}
