package model.bo;

import java.util.List;

import model.dao.AutoDAO;
import model.dao.ClienteDAO;
import model.dao.OrcamentoDAO;
import model.vo.AutoVO;
import model.vo.ClienteVO;
import model.vo.OrcamentoVO;


public class OrcamentoBO<VO extends OrcamentoVO> {
	
	OrcamentoDAO<OrcamentoVO> orcamento = new OrcamentoDAO<OrcamentoVO>();
	ClienteDAO<ClienteVO> client = new ClienteDAO<ClienteVO>();
	AutoDAO<AutoVO> auto = new AutoDAO<AutoVO>();
	
	public void cadastrar(VO orm) throws Exception {
		
		try {
			orcamento.inserir(orm);
			System.out.println("Orcamento cadastrado");
		}catch(Exception e) {
			System.out.println("Desista n�o, pegue outro ERRO: " + e.getMessage());
		}
	}
	
	public void editar(VO orm) throws Exception {
		
		try {
			orcamento.editar(orm);
			System.out.println("Orcamento editado");
		}catch(Exception e) {
			System.out.println("Desista n�o, pegue outro ERRO: " + e.getMessage());
		}
	}
	
	public void remover(VO orm) throws Exception {
		try {
			orcamento.remover(orm);
			System.out.println("Orcamento removido");
		}catch(Exception e) {
			System.out.println(" Desista n�o, pegue outro ERRO: " + e.getMessage());
		}
	}
	
	public List<OrcamentoVO> listarBO() {
		
		
		return orcamento.listar();
	}
	
	public List<OrcamentoVO> findByAuto(VO orm) throws Exception{
		if(this.auto.findByPlaca(orm.getAuto().getPlaca()) == null) {
			throw new Exception ("Automovel n�o encontrado");
		}
		
			return orcamento.findByAuto(orm);
		
	}
	
	public void findByClient(VO orm) throws Exception{
		if(this.client.findByCPF(orm.getClientName().getCPF()) == null) {
			throw new Exception ("Cliente n�o encontrado");
		}
		try {
			orcamento.findByCliente(orm);
		}catch(Exception e) {
			System.out.println("Desista n�o, pegue outro ERRO: " + e.getMessage());
		}
	}
	
	public void findByData(VO orm, String dataOne, String dataTwo) throws Exception {
		try {
			orcamento.findByData(orm, dataOne , dataTwo);
		}catch(Exception e){
			System.out.println("Desista n�o, pegue outro ERRO: " + e.getMessage());
		}
	}

}
