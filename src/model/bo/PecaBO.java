package model.bo;

import java.sql.SQLException;
import java.util.List;

import model.dao.PecasDAO;
import model.vo.AutoVO;
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
	public Integer getIdFromBd(){
		
			return pec.getIdFromBD();
		
	}
	
	public void editar(VO peca) throws SQLException{
		try {
			pec.editar(peca);
			System.out.println("Peca editada");
		}catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public List<PecasVO> findByName(VO peca) {
		
		return pec.findByNome(peca);
	}
	
	public List<PecasVO> findByFab(VO peca) {
		
			return pec.findByFabricante(peca);
		
	}
	public List<PecasVO> findByAuto(VO peca) throws Exception{
		try {
			return pec.findByAuto(peca);
		}catch(Exception e) {
			System.out.println("ERRO@>> " + e);
		}
		return null;
	
    }
    public List<PecasVO> findByAutopl(AutoVO pl) {
		
    	try {
			return pec.findByAutoPl(pl);
		}catch(Exception e) {
			System.out.println("ERRO@>> " + e);
		}
		return null;
		
		
    }
 public List<PecasVO> findByPreco(VO pl) {
		
    	try {
			return pec.findByPreco(pl);
		}catch(Exception e) {
			System.out.println("ERRO@>> " + e);
		}
		return null;
		
		
    }
	public List<PecasVO> listarBO(){
		
		return pec.listar();
		
	}
	
	public void remove(VO peca){
		try {
			pec.remover(peca);
			System.out.println("Peca removida !");
		}catch(Exception e){
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	

}
