public class Usuario {

	private int identificador;
	private String nome;
	private String iniciais;
	private boolean isAdmin;

	public Usuario(int identificador, String nome, String iniciais) {
		this.identificador = identificador;
		this.nome = nome;
		this.iniciais = iniciais;
	}

	public int getIdentificador() {
		return this.identificador;
	}

	public String getNome() {
		return this.nome;
	}

	public String getIniciais() {
		return this.iniciais;
	}

	public boolean isAdmin() {
		return this.isAdmin;
	}

}
