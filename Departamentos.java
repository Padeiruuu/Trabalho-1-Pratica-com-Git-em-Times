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
	
	public void removeFuncionarios(Funcionario funcionario) {
		if(funcionarios.isEmpty())
			System.out.println("Não foi possível remover pois o departamento ja está vazio");
		else{
			funcionarios.remove(funcionario);
			System.out.println("Funcionário removido!  "+getNome());}
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

//	@Override
//	public String toString() {
//		return "Departamentos " +
//				"\nValor Máximo por pedido= " + valorMaximo +
//				"\nNome= " + nome +
//				"\nFuncionarios=" + funcionarios;
//	}
}
