public class Usuario {

	private int identificador;
	private String nome;
	private String iniciais;
	private boolean isAdmin;

	public Usuario(int identificador, String nome, String iniciais, boolean isAdmin) {
		this.identificador = identificador;
		this.nome = nome;
		this.iniciais = iniciais;
		this.isAdmin = isAdmin;
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
