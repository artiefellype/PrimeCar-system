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
		if(clientName.getName() == null || clientName.getName().isBlank()) {
			
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
			if(orcamento > 0) // Não existe orçamento menor que 0
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
			if(custo > 0)  // Não existe custo negativo
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
