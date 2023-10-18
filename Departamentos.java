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

	public void addFuncionarios(Funcionario funcionario) {
		if (funcionarios.size() == valorMaximo) {
			System.out.println("Não foipossível adicionar pois o departamento já está lotado!");
		} else{
			funcionarios.add(funcionario);
		    System.out.println("Funcionário cadastrado no departamento " + getNome());
		}
	}
	
	public void removeFuncionarios(Funcionario funcionario) {
		if(funcionarios.isEmpty()){
			System.out.println("Não foi possível remover pois o departamento ja está vazio");
		}else{
			funcionarios.remove(funcionario);
			System.out.println("Não foi possível cadastrar o funcionário no departamento "+getNome());}
	}

	@Override
	public String toString() {
		return "Departamentos " +
				"\nValor Máximo de funcionários= " + valorMaximo +
				"\nNome= " + nome +
				"\nFuncionarios=" + funcionarios;
	}
}
