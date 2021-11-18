package model.bo;


import model.vo.AutoVO;
import model.dao.AutoDAO;
import java.util.List;

public class AutoBO<VO extends AutoVO> {
	
	AutoDAO<AutoVO> autd = new AutoDAO<>();
	public void inserirBO(VO auto) {
		autd.inserir(auto);
	}
	public int getIdFromBD() {
		return autd.getIdFromBD();
	}
	
	public void removerBO(VO auto) {
		autd.remover(auto);
	}
	
	public void editarBO(VO auto) {
		autd.editar(auto);
	}
	
	public List<AutoVO> listarBO(){
		List<AutoVO> automoveis = autd.listar();	
		for(AutoVO aut : automoveis) {
			System.out.println(aut.getId());
			System.out.println(aut.getMarca());
			System.out.println(aut.getCor());
			System.out.println(aut.getAno());
			System.out.println(aut.getQuilometragem());
			System.out.println(aut.getProprietario().getCPF());
		}
		
		return automoveis;
	}
	
	public void listarByMarcaBO(VO auto){
		String marca = auto.getMarca();
		List<AutoVO> l = autd.findByMarca(marca);	
		for(AutoVO aut : l) {
			System.out.println(aut.getId());
			System.out.println(aut.getMarca());
			System.out.println(aut.getCor());
			System.out.println(aut.getAno());
			System.out.println(aut.getQuilometragem());
			System.out.println(aut.getProprietario());
		}
	}
	
	public void listarByCorBO(VO auto){
		String cor = auto.getCor();
		List<AutoVO> l = autd.findByCor(cor);	
		for(AutoVO aut : l) {
			System.out.println(aut.getId());
			System.out.println(aut.getMarca());
			System.out.println(aut.getCor());
			System.out.println(aut.getAno());
			System.out.println(aut.getQuilometragem());
			System.out.println(aut.getProprietario());
		}
	}
	
	public List<AutoVO> listarByPlacaBO(VO auto){
		String placa = auto.getPlaca();
		System.out.println("@>>>porcaria" + placa);
		return autd.findByPlaca(placa);
	}
	
	public AutoVO findByPlacaBO(VO auto){
		String placa = auto.getPlaca();
		AutoVO result = null;
		if(placa == null) {
			System.out.println("NNULO");
		}else {
			result = autd.findByPlaca(placa).get(0);
		}
		return result;
		
	}
	
	public void listarByAnoBO(VO auto){
		Integer ano = auto.getAno();
		List<AutoVO> l = autd.findByAno(ano);	
		for(AutoVO aut : l) {
			System.out.println(aut.getId());
			System.out.println(aut.getMarca());
			System.out.println(aut.getCor());
			System.out.println(aut.getAno());
			System.out.println(aut.getQuilometragem());
			System.out.println(aut.getProprietario());
		}
	}
	
	public void listarByKmBO(VO auto){
		Double km = auto.getQuilometragem();
		List<AutoVO> l = autd.findByQuilom(km);	
		for(AutoVO aut : l) {
			System.out.println(aut.getId());
			System.out.println(aut.getMarca());
			System.out.println(aut.getCor());
			System.out.println(aut.getAno());
			System.out.println(aut.getQuilometragem());
			System.out.println(aut.getProprietario());
		}
	}
	
	public List<AutoVO> listarByClienteBO(VO cliente){
		
		Integer id = cliente.getProprietario().getId();
		return autd.findByCliente(id);	
		
	}

}
