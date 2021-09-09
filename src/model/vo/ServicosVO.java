package model.vo;

public class ServicosVO {
	private String tipo;
	private Double valor;
	private Integer idServico;
	private Integer idAuto;
	private Integer idpeca;
	private Boolean finalizado;
	
	public Integer getIdServico() {
		return idServico;
	}
	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}
	public Integer getIdAuto() {
		return idAuto;
	}
	public void setIdAuto(Integer idAuto) {
		this.idAuto = idAuto;
	}
	public Integer getIdpeca() {
		return idpeca;
	}
	public void setIdpeca(Integer idpeca) {
		this.idpeca = idpeca;
	}
	public Boolean getFinalizado() {
		return finalizado;
	}
	public void setFinalizado(Boolean finalizado) {
		if(finalizado == null) {
			
		}else {
			this.finalizado = finalizado;
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
	
	
}
