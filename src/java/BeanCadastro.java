

public class BeanCadastro {
	
	private String nome;
	private String email;
	private String senha;
	private String cpf
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
		
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
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String cadastrar() {
		cadastro.cadastrar(nome, email, senha, cpf);
		
		return "/index.xhtml?faces-redirect=true";
	}


}
