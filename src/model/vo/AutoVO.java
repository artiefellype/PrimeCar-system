package model.vo;

public class AutoVO {
	private String marca;
	private String cor;
	private String placa;
	private Integer ano;
	private Double quilometragem;
	private ClienteVO proprietario;
	
	//-----------------------Marca do automóvel------------------------------------
	public String getMarca() {
		return marca;
		
	}
	public void setMarca(String marca) {
		if(marca.isBlank()) {
			
		}else {
			this.marca = marca;
		}
	}
	//----------------------Cor do automóvel-------------------------------------
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		if(cor.isBlank()) {
			
		}else {
			this.cor = cor;
		}
	}
	//----------------------placa do automóvel-------------------------------------
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		if(placa.isBlank()) {
			
		}else {
			this.placa = placa;
		}
	}
	//-----------------------Ano do automóvel------------------------------------
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		if(ano == null || ano.equals("")) {
			
		}else {
			if (ano > 1920) {  // Não deve existir carros antes dessa década
				this.ano = ano;
			}
		}
	}
	//-----------------------Quilometragem do automóvel------------------------------------
	public Double getQuilometragem() {
		return quilometragem;
	}
	public void setQuilometragem(Double quilometragem) {
		if(quilometragem == null || quilometragem.equals("")) {
			
		}else {
			if (quilometragem > 0) {
				this.quilometragem = quilometragem;
			}
		}
	}
	//-----------------------Proprietario do automóvel-----------------------------------
	public ClienteVO getProprietario() {
		return proprietario;
	}
	public void setProprietario(ClienteVO proprietario) {
		
		if(proprietario == null || proprietario.equals("")) {
			
		}else {
			this.proprietario = proprietario;
		}
		
	}
	
	
	
	
	
	
	
}
