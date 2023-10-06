public class Funcionario extends Usuario {

	private Departamentos departamento;

	public Funcionario(int id, String nome, String iniciais, Departamentos departamento) {
		super(id, nome, iniciais, false);
		this.departamento = departamento;
	}

	public Departamentos getDepartamento() {
		return departamento;
	}
}
