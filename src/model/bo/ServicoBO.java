package model.bo;

import model.dao.AutoDAO;
import model.dao.PecasDAO;
import model.dao.ServicosDAO;
import model.vo.AutoVO;
import model.vo.PecasVO;
import model.vo.ServicosVO;

public class ServicoBO {

	ServicosDAO<ServicosVO> services = new ServicosDAO<ServicosVO>();
	AutoDAO<AutoVO> auto = new AutoDAO<AutoVO>();
	PecasDAO<PecasVO> peca = new PecasDAO<PecasVO>();
	
	public void inserir(ServicosVO serv) throws Exception {
		try {
			services.inserir(serv);
			System.out.println("Servico inserida!");
			
		}catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public void editar(ServicosVO serv) throws Exception{
		try {
			services.editar(serv);
			System.out.println("Servico editado");
		}catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public void remover(ServicosVO serv) throws Exception {
		try {
			services.remover(serv);
			System.out.println("Servico removido");
		}catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public void findByTipo(ServicosVO serv) throws Exception {
		try {
			services.findByTipo(serv);
		}catch(Exception e){
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public void findByAuto(AutoVO auto) throws Exception {
		if(this.auto.findByPlaca(auto.getPlaca()) == null) {
			throw new Exception("Automovel não encontrado");
		}
		try {
			services.findByAuto(auto);
		}catch(Exception e){
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public void findByPeca(PecasVO peca) throws Exception {
		if(this.peca.findByNome(peca) == null) {
			throw new Exception("Peca não encontrada");
		}
		
		try {
			services.findByPeca(peca);
		}catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public void findByFinished(ServicosVO serv) throws Exception {
		
		try {
			services.findByFinalizado(serv);
		}catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public void listar() throws Exception {
		try {
			services.listar();
		}catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
}
