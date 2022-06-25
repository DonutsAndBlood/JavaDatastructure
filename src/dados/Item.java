package dados;

public class Item {
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private Double saldo;

	public Item(String nome, String cpf, String telefone, String email, Double saldo) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.saldo = saldo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Item [nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", email=" + email + ", saldo="
				+ saldo + "]";
	}









}
