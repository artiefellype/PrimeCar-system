package model.bo;

import java.sql.SQLException;
import java.util.List;

import model.dao.PecasDAO;
import model.vo.PecasVO;

public class PecaBO<VO extends PecasVO> {
	
	PecasDAO<PecasVO> pec = new PecasDAO<PecasVO>();
	
	public void inserir(VO peca) throws SQLException {
		try {
			pec.inserir(peca);
			System.out.println("Peca inserida!");
		}catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public void editar(VO peca) throws SQLException{
		try {
			pec.editar(peca);
			System.out.println("Peca editada");
		}catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public void findByName(VO peca) throws SQLException {
		try {
			
			pec.findByNome(peca);
			
		}catch(Exception e){
			System.out.println("ERRO: " + e.getMessage());
		}
		
	}
	
	public void findByFab(VO peca) throws SQLException {
		try {
			pec.findByFabricante(peca);
		}catch(Exception e){
			System.out.println("ERRO: " + e.getMessage());
			
		}
	}
	public List<PecasVO> listarBO(){
		
		return pec.listar();
		
	}
	
	public void remove(VO peca) throws SQLException {
		try {
			pec.remover(peca);
			System.out.println("Peca removida !");
		}catch(Exception e){
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	

}
