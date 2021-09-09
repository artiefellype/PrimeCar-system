package model.vo;

import java.util.UUID;

public class ClienteVO {
	private String name;
	private String endereco;
	private String cpf;
	private UUID id;
	
	
	// ------------------- ID do cliente ----------------------------
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		if(id == null) {
			
		}else {
			this.id = id;
		}
		
	}
	//----------------------Nome do cliente---------------------------------
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name == null || name.isBlank()) {
			
		}else {
			this.name = name;
		}
		
	}
	//-----------------------Endereço do cliente--------------------------------
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		if(endereco == null || endereco.isBlank()) {
			
		}else {
			this.endereco = endereco;
		}
		
	}
	//-----------------------CPF do cliente--------------------------------
	public String getCPF() {
		return cpf;
	}
	public void setCPF(String cpf) {
		 if(cpf == null || cpf.isBlank()) {
			 
		 }else {
			 //Caso o numero de cpf tenha números iguais é considerado erro, assim como ter mais de
			 //	10 digitos
			 //if (cpf.matches("\\d{10}") || (cpf.length() >= 11)) {
				 
			// }else {
				 this.cpf = cpf;
			 //}
		 }
	}
	
	
}
