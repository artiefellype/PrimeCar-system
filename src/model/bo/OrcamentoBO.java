package model.bo;

import model.dao.AutoDAO;
import model.dao.ClienteDAO;
import model.dao.OrcamentoDAO;
import model.vo.AutoVO;
import model.vo.ClienteVO;
import model.vo.OrcamentoVO;


public class OrcamentoBO {
	
	OrcamentoDAO<OrcamentoVO> orcamento = new OrcamentoDAO<OrcamentoVO>();
	ClienteDAO<ClienteVO> client = new ClienteDAO<ClienteVO>();
	AutoDAO<AutoVO> auto = new AutoDAO<AutoVO>();
	
	public void cadastrar(OrcamentoVO orm) throws Exception {
		
		try {
			orcamento.inserir(orm);
			System.out.println("Orcamento cadastrado");
		}catch(Exception e) {
			System.out.println("Desista não, pegue outro ERRO: " + e.getMessage());
		}
	}
	
	public void editar(OrcamentoVO orm) throws Exception {
		
		try {
			orcamento.editar(orm);
			System.out.println("Orcamento editado");
		}catch(Exception e) {
			System.out.println("Desista não, pegue outro ERRO: " + e.getMessage());
		}
	}
	
	public void remover(OrcamentoVO orm) throws Exception {
		try {
			orcamento.remover(orm);
			System.out.println("Orcamento removido");
		}catch(Exception e) {
			System.out.println(" Desista não, pegue outro ERRO: " + e.getMessage());
		}
	}
	
	public void listar() throws Exception {
		try {
			orcamento.listar();
			
		}catch(Exception e) {
			System.out.println(" Desista não, pegue outro ERRO: " + e.getMessage());
		}
	}
	
	public void findByAuto(OrcamentoVO orm) throws Exception{
		if(this.auto.findByPlaca(orm.getAuto().getPlaca()) == null) {
			throw new Exception ("Automovel não encontrado");
		}
		try {
			orcamento.findByAuto(orm);
		}catch(Exception e) {
			System.out.println("Desista não, pegue outro ERRO: " + e.getMessage());
		}
	}
	
	public void findByClient(OrcamentoVO orm) throws Exception{
		if(this.client.findByCPF(orm.getClientName().getCPF()) == null) {
			throw new Exception ("Cliente não encontrado");
		}
		try {
			orcamento.findByCliente(orm);
		}catch(Exception e) {
			System.out.println("Desista não, pegue outro ERRO: " + e.getMessage());
		}
	}
	
	public void findByData(OrcamentoVO orm, String dataOne, String dataTwo) throws Exception {
		try {
			orcamento.findByData(orm, dataOne , dataTwo);
		}catch(Exception e){
			System.out.println("Desista não, pegue outro ERRO: " + e.getMessage());
		}
	}

}
