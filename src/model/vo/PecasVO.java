package model.vo;



public class PecasVO {
	private Integer id;
	private String name;
	private String fabricante;
	private Double preco;
	private AutoVO auto;
	
	
	// ------------------- ID da pe�a ----------------------------
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		if(id == null) {
			
		}else {
			this.id = id;
		}
		
	}
	
	//-----------------------Nome da pe�a--------------------------
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name == null || name.isBlank()) {
			
		}else {
			this.name = name;
		}
		
	}
	//-----------------------Fabricante da pe�a--------------------------------------
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		if(fabricante == null || fabricante.isBlank()) {
			
		}else {
			this.fabricante = fabricante;
		}
		
	}
	//------------------------Valor da pe�a------------------------------------
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		if(preco == null || preco.equals("")) {
			
		}else {
			if(preco > 0) // N�o existe pre�o negativo
				this.preco = preco;
		}
		
	}
	// ------------------------ placa do veiculo ----------------------
	public AutoVO getAuto() {
		return auto;
	}
	public void setAuto(AutoVO auto) {
		if(auto == null) {
			
		}else {
			this.auto = auto;
		}
	}
	
	
	
}
