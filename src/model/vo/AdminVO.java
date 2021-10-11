package model.vo;

public class AdminVO {
	private Integer id;
	private String name;
	private String email;
	private String senha;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		if(id == null) {
			
		}{
			this.id = id;
		}
		
	}
	// ------------------ Email de recuperação ---------------------
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email == null || email.isBlank()) {
			
		}else {
			this.email = email;
		}
		
	}
	//-------------------Nome do admin------------------------------
	public String getName() {
		
		return name;
	}
	
	public void setName(String name) {
		if(name == null || name.isBlank()) {
			
		}else {
			this.name = name;
		}
		
	}
	//--------------------Senha do Admin------------------------------
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		
		if(senha == null || senha.isBlank()) {
			
		}else {
				this.senha = senha;
			}
		
	}
	
	
}
