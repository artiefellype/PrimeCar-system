package model.vo;


import model.vo.PecasVO;

public class ServicosVO {
	private Integer id;
	private String tipo;
	private Double valor;
	private Boolean finalizado;
	private AutoVO auto;
	private PecasVO peca;
	
	// ------------------- ID do Serviço ----------------------------
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		if(id == null) {
			
		}else{
			this.id = id;
		}
		
	}

	//------------------Tipo do serviço-----------------------
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		if(tipo == null || tipo.isBlank()) {
			
		}else {
			this.tipo = tipo;
		}
		
	}
	
	//-------------------Valor do serviço------------------------------------
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
	
	public AutoVO getAuto() {
		return auto;
	}
	public void setAuto(AutoVO auto) {
		if(auto == null) {
			
		}else {
			this.auto = auto;
		}
		
	}
	
	
	public PecasVO getPeca() {
		return peca;
	}
	public void setPeca(PecasVO peca) {
		if(peca == null) {
			
		}else {
			this.peca = peca;
		}
		
	}
	//------------------ Verificação ----------------------------------------
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
