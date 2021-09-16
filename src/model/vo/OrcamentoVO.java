package model.vo;


import java.util.Calendar;
import model.vo.ClienteVO;
import model.vo.ServicosVO;
import model.vo.AutoVO;

public class OrcamentoVO {
	private Integer id;
	private ClienteVO clientName;
	private ServicosVO servicos;
	private AutoVO auto;
	private Double custo;
	private Calendar data;

	// ------------------- ID do orçamento ----------------------------
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		if(id == null) {
			
		}else {
			this.id = id;
		}
		
	}
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
    //-------------------Serviços prestados --------------------------------------------
	public ServicosVO getServicos() {
		return servicos;
	}
	public void setServicos(ServicosVO servicos) {
		if(servicos.getTipo() == null) {
			
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
			if(custo > 0)  // Não existe custo negativo
				this.custo = custo;
		}
	}
	// ------------------------ data de orçamento ----------------------------
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
		if (auto.getPlaca() == null) {
			
		}else {
			this.auto = auto;
		}
	}
	
	
}
