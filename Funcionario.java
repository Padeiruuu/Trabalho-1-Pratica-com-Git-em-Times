import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Usuario {

	private Departamentos departamento;
	private List<Pedido> pedidos;

	public Funcionario(int id, String nome, String iniciais, Departamentos departamento) {
		super(id, nome, iniciais);
		this.departamento = departamento;
		pedidos = new ArrayList<>();
	}

	public Departamentos getDepartamento() {
		return departamento;
	}

	public void addPedido(Pedido p){
		pedidos.add(p);
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void removePedido(Pedido p){
		pedidos.remove(p);
	}


	@Override
	public String toString() {
		return "Funcionario{" +
				"departamento=" + departamento.getNome() +
				", pedidos=" + pedidos +
				'}';
	}
}
