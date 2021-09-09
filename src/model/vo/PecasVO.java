package model.vo;

import java.util.UUID;

public class PecasVO {
	private UUID id;
	private String name;
	private String fabricante;
	private Double preco;
	
	// ------------------- ID da peça ----------------------------
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		if(id == null) {
			
		}else {
			this.id = id;
		}
		
	}
	
	//-----------------------Nome da peça--------------------------
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name == null || name.isBlank()) {
			
		}else {
			this.name = name;
		}
		
	}
	//-----------------------Fabricante da peça--------------------------------------
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		if(fabricante == null || fabricante.isBlank()) {
			
		}else {
			this.fabricante = fabricante;
		}
		
	}
	//------------------------Valor da peça------------------------------------
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		if(preco == null || preco.equals("")) {
			
		}else {
			if(preco > 0) // Não existe preço negativo
				this.preco = preco;
		}
		
	}
	
	
	
}
