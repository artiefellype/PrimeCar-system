package model.vo;

public class AdminVO {
	private String name;
	private String senha;
	private Integer id;
	
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
