import java.util.ArrayList;
public class Departamentos {

	private double valorMaximo;
	private String nome;
	private ArrayList<Funcionario> funcionarios;

	public Departamentos(String nome, double valorMaximo) {
		this.valorMaximo = valorMaximo;
		this.nome = nome;
		this.funcionarios = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public double getValorMaximo() {
		return valorMaximo;
	}

	public void addFuncionarios(Funcionario funcionario) {
			funcionarios.add(funcionario);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Departamentos ");
		sb.append("\nValor Máximo por pedido= ").append(valorMaximo);
		sb.append("\nNome= ").append(nome);

		sb.append("\nFuncionarios:");
		for (Funcionario funcionario : funcionarios) {
			sb.append("\n - ").append(funcionario.getNome());
		}

		return sb.toString();
	}
}
