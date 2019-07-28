package clienteweb;


public class User {
	
	private int id;
	private String Nome;
	private String email;
	private String senha;
	private String status;
	
	public User(int id, String nome, String email, String senha, String status) {
		super();
		this.id = id;
		Nome = nome;
		this.email = email;
		this.senha = senha;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", Nome=" + Nome + ", email=" + email + ", senha=" + senha + ", status=" + status
				+ "]";
	}
	
	
	
	
}