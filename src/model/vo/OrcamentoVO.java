package model.vo;

public class OrcamentoVO {
	private ClienteVO clientName;
	private Double orcamento;
	private Double custo;
	private Double balanco;
	
	//--------------------Nome do cliente a qual pertence o orçamento---------------------------
	public ClienteVO getClientName() {
		return clientName;
	}
	public void setClientName(ClienteVO clientName) {
		if(clientName == null || clientName.equals("")) {
			
		}else {
			this.clientName = clientName;
		}
		
	}
	//--------------------Orçamento  do cliente---------------------------------------
	public Double getOrcamento() {
		return orcamento;
	}
	public void setOrcamento(Double orcamento) {
		if(orcamento == null || orcamento.equals("")) {
			
		}else {
			this.orcamento = orcamento;
		}
	}
	//--------------------custos------------------------
	public Double getCusto() {
		return custo;
	}
	public void setCusto(Double custo) {
		if(custo == null || custo.equals("")) {
			
		}else {
			this.custo = custo;
		}
	}
	//--------------------Balanço--------------------------------
	public Double getBalanco() {
		return balanco;
	}
	public void setBalanco(Double balanco) {
		if(balanco == null || balanco.equals("")) {
			
		}else {
			this.balanco = balanco;
		}
	}
	
	
	
}
