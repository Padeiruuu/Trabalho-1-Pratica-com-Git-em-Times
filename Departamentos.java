import java.util.ArrayList;
public class Departamentos {

	private int valorMaximo;
	private String nome;
	private ArrayList<Funcionario> funcionarios;

	public Departamentos(String nome, int valorMaximo) {
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

	public int getValorMaximo() {
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
		return "Departamentos " +
				"\nValor Máximo por pedido= " + valorMaximo +
				"\nNome= " + nome +
				"\nFuncionarios=" + funcionarios;
	}
}
