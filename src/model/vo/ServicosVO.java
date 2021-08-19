package model.vo;

public class ServicosVO {
	private String tipo;
	private Double valor;
	
	//------------------Tipo do servi�o-----------------------
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		if(tipo.isBlank()) {
			
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
	
	
}
