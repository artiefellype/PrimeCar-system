package model.bo;

import java.sql.SQLException;


import model.dao.PecasDAO;
import model.vo.PecasVO;

public class PecaBO {
	
	PecasDAO<PecasVO> pec = new PecasDAO<PecasVO>();
	
	public void inserir(PecasVO peca) throws SQLException {
		try {
			pec.inserir(peca);
			System.out.println("Peca inserida!");
		}catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public void editar(PecasVO peca) throws SQLException{
		try {
			pec.editar(peca);
			System.out.println("Peca editada");
		}catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public void findByName(PecasVO peca) throws SQLException {
		try {
			
			pec.findByNome(peca);
			
		}catch(Exception e){
			System.out.println("ERRO: " + e.getMessage());
		}
		
	}
	
	public void findByFab(PecasVO peca) throws SQLException {
		try {
			pec.findByFabricante(peca);
		}catch(Exception e){
			System.out.println("ERRO: " + e.getMessage());
			
		}
	}
	public void listar() throws SQLException{
		
		try{
			pec.listar();
		}catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
		
	}
	
	public void remove(PecasVO peca) throws SQLException {
		try {
			pec.remover(peca);
			System.out.println("Peca removida !");
		}catch(Exception e){
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	

}
