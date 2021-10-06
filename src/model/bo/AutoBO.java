package model.bo;


import model.vo.AutoVO;
import model.dao.AutoDAO;
import java.util.List;

public class AutoBO {
	
	AutoDAO<AutoVO> autd = new AutoDAO<>();
	public void inserirBO(AutoVO auto) {
		autd.inserir(auto);
	}
	
	public void removerBO(AutoVO auto) {
		autd.remover(auto);
	}
	
	public void editarBO(AutoVO auto) {
		autd.editar(auto);
	}
	
	public void listarBO(){
		List<AutoVO> l = autd.listar();	
		for(AutoVO aut : l) {
			System.out.println(aut.getId());
			System.out.println(aut.getMarca());
			System.out.println(aut.getCor());
			System.out.println(aut.getAno());
			System.out.println(aut.getQuilometragem());
			System.out.println(aut.getProprietario().getId());
		}
	}
	
	public void listarByMarcaBO(AutoVO auto){
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
	
	public void listarByCorBO(AutoVO auto){
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
	
	public void listarByPlacaBO(AutoVO auto){
		String placa = auto.getPlaca();
		List<AutoVO> l = autd.findByPlaca(placa);	
		for(AutoVO aut : l) {
			System.out.println(aut.getId());
			System.out.println(aut.getMarca());
			System.out.println(aut.getCor());
			System.out.println(aut.getAno());
			System.out.println(aut.getQuilometragem());
			System.out.println(aut.getProprietario());
		}
	}
	
	public void listarByAnoBO(AutoVO auto){
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
	
	public void listarByKmBO(AutoVO auto){
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
	
	public void listarByClienteBO(AutoVO cliente){
		
		Integer id = cliente.getProprietario().getId();
		List<AutoVO> l = autd.findByCliente(id);	
		for(AutoVO aut : l) {
			System.out.println(aut.getId());
			System.out.println(aut.getMarca());
			System.out.println(aut.getCor());
			System.out.println(aut.getAno());
			System.out.println(aut.getQuilometragem());
			System.out.println(aut.getProprietario());
		}
	}

}
