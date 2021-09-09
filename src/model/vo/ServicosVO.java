package model.vo;
import java.util.UUID;

public class ServicosVO {
	private UUID id;
	private String tipo;
	private Double valor;
	private Boolean finalizado;
	
	// ------------------- ID do Servi�o ----------------------------
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		if(id == null) {
			
		}else{
			this.id = id;
		}
		
	}

	//------------------Tipo do servi�o-----------------------
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		if(tipo == null || tipo.isBlank()) {
			
		}else {
			this.tipo = tipo;
		}
		
	}
	
	//-------------------Valor do servi�o------------------------------------
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		if(valor == null || valor.equals("")) {
			
		}else {
			if(valor > 0)
				this.valor = valor;
		}
		
	}
	//------------------ Verifica��o ----------------------------------------
	public Boolean getFinalizado() {
		return finalizado;
	}
	
	public void setFinalizado(Boolean finalizado) {
		if(finalizado == null) {
			
		}else {
			this.finalizado = finalizado;
		}
		
	}
	
	
}
