package model.bo;

import java.util.List;

import model.dao.AutoDAO;
import model.dao.PecasDAO;
import model.dao.ServicosDAO;
import model.vo.AutoVO;
import model.vo.PecasVO;
import model.vo.ServicosVO;

public class ServicoBO<VO extends ServicosVO> {

	ServicosDAO<ServicosVO> services = new ServicosDAO<ServicosVO>();
	AutoDAO<AutoVO> auto = new AutoDAO<AutoVO>();
	PecasDAO<PecasVO> peca = new PecasDAO<PecasVO>();
	
	public void inserir(VO serv) throws Exception {
		try {
			services.inserir(serv);
			System.out.println("Servico inserida!");
			
		}catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public void editar(VO serv) throws Exception{
		try {
			services.editar(serv);
			System.out.println("Servico editado");
		}catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public void remover(VO serv) {
		
			services.remover(serv);
			System.out.println("Servico removido");
		
	}
	
	public List<ServicosVO> findByTipo(VO serv) {
		
			return services.findByTipo(serv);
		
	}
	
	public List<ServicosVO> findByAuto(AutoVO auto) throws Exception {
		if(this.auto.findByPlaca(auto.getPlaca()) == null) {
			throw new Exception("Automovel n�o encontrado");
		}
	
			return services.findByAuto(auto);
		
	}
	/*
	public void findByPeca(PecasVO peca) throws Exception {
		if(this.peca.findByNome(peca) == null) {
			throw new Exception("Peca n�o encontrada");
		}
		
		try {
			services.findByPeca(peca);
		}catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	*/
	public void findByFinished(VO serv) throws Exception {
		
		try {
			services.findByFinalizado(serv);
		}catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public List<ServicosVO> listarBO() {
		
		return services.listar();
		
	}
}
