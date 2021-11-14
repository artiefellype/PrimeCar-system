package model.vo;


import java.util.Calendar;

public class OrcamentoVO {
	private Integer id;
	private ClienteVO clientName;
	private ServicosVO servicos;
	private AutoVO auto;
	private Double custo;
	private Calendar data;

	// ------------------- ID do or�amento ----------------------------
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		if(id == null) {
			
		}else {
			this.id = id;
		}
		
	}
	//--------------------Nome do cliente a qual pertence o or�amento---------------------------
	public ClienteVO getClientName() {
		return clientName;
	}
	public void setClientName(ClienteVO clientName) {
		if(clientName == null || clientName.equals("")) {
			
		}else {
			this.clientName = clientName;
		}
		
	}
    //-------------------Servi�os prestados --------------------------------------------
	public ServicosVO getServicos() {
		return servicos;
	}
	public void setServicos(ServicosVO servicos) {
		if(servicos == null || servicos.equals(" ")) {
			
		}else {
			this.servicos = servicos;
		}
		
	}
	//--------------------custos------------------------
	public Double getCusto() {
		return custo;
	}
	public void setCusto(Double custo) {
		if(custo == null || custo.equals("")) {
			
		}else { 
			if(custo > 0)  // N�o existe custo negativo
				this.custo = custo;
		}
	}
	// ------------------------ data de or�amento ----------------------------
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		if(data == null) {
			
		}else {
			this.data = data;
		}
		
	}
	
	public AutoVO getAuto() {
		return auto;
	}
	public void setAuto(AutoVO auto) {
		if (auto == null || auto.equals(" ")) {
			
		}else {
			this.auto = auto;
		}
	}
	
	
}