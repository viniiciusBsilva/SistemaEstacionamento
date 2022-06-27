package model;

public class Usuario {
	private Long id;
	private String nome;
	private String usuario;
	private String Senha;
	
	public Usuario() {
		
	}
	
	public Usuario(Long id, String nome, String usuario, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		Senha = senha;
	}

	public Usuario(String nome, String usuario, String senha) {
		super();
		this.nome = nome;
		this.usuario = usuario;
		Senha = senha;
	}

	public void setId(long id2) {
		this.id = id2;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public String getSenha() {
		return Senha;
	}	
	
	
}
