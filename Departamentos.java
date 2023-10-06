import java.util.ArrayList;
public class Departamentos {

	private int valorMaximo;
	private String nome;
	private ArrayList<Funcionario> funcionarios;

	public Departamentos(String nome, int valorMaximo){
		this.valorMaximo=valorMaximo;
		this.nome=nome;
		this.funcionarios = new ArrayList<>();
	}
	public String getNome() {
		return nome;
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void addFuncionarios(Funcionario funcionario) {
		funcionarios.add(funcionario);
		System.out.println("Funcionário cadastrado no departamento "+getNome());
	}

	public void removeFuncionarios(Funcionario funcionario) {
		funcionarios.remove(funcionario);
		System.out.println("Não foi possível cadastrar o funcionário no departamento "+getNome());
	}

}
