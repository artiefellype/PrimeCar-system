package model.dao;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import model.vo.AdminVO;
import model.vo.AutoVO;
import model.vo.ClienteVO;
import model.vo.OrcamentoVO;
import model.vo.PecasVO;
import model.vo.ServicosVO;



public class testBD {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AdminDAO<AdminVO> admin = new AdminDAO<AdminVO>();
		AdminVO adminV = new AdminVO();
		
		adminV.setName("superMalvadao");
		adminV.setSenha("senhaforte");
		adminV.setEmail("chamacommalvadao@gsail.com");
		adminV.setId(admin.getIdFromBD());
		
		//admin.inserir(adminV);
		/*
		List<AdminVO> clientes = admin.listar();
		
		for(AdminVO clientesShow : clientes) {
			System.out.println(clientesShow.getId());
			System.out.println(clientesShow.getName());
			System.out.println(clientesShow.getSenha());
			System.out.println(clientesShow.getEmail());
		}
		*/
		 // ---------------TESTE CLIENTEDAO --------------------
		ClienteDAO<ClienteVO> clientD = new ClienteDAO<ClienteVO>();
		ClienteVO clientV = new ClienteVO();
		
		
		clientV.setName("islania satna");
		clientV.setCPF("12102428427");
		clientV.setEndereco("Rua oleo de agua");
		clientV.setId(clientD.getIdFromBD());
		
		//clientD.inserir(clientV);
		//System.out.println("tudo ok");
		
		/*
		
		//List<ClienteVO> clientes = clientD.findByName(clientV.getName());
		//List<ClienteVO> clientes = clientD.findByCPF(clientV.getCPF());
		//List<ClienteVO> clientes = clientD.findByEndereco(clientV.getEndereco());
		
		
		for(ClienteVO clientesShow : clientes) {
			System.out.println(clientesShow.getId());
			System.out.println(clientesShow.getName());
			System.out.println(clientesShow.getEndereco());
			System.out.println(clientesShow.getCPF());
		}
		
		
		*/
		
		
		
		
	
		
		//clientD.editar(clientV);
		//clientD.removeByCPF(clientV);
		//System.out.println("---------------------");
		//System.out.println(clientD.getIdFromBD());
		//System.out.println("---------------------");
		
		/*
		
		List<ClienteVO> clientes = clientD.listar();
		
		for(ClienteVO clientesShow : clientes) {
			System.out.println(clientesShow.getId());
			System.out.println(clientesShow.getName());
			System.out.println(clientesShow.getEndereco());
			System.out.println(clientesShow.getCPF());
			
		}
		
	*/
		
		
		 //-------------TESTE AUTOMOVELDAO---------------------
		AutoDAO<AutoVO> autoD = new AutoDAO<AutoVO>();
		AutoVO autoV = new AutoVO();
		
		
		autoV.setMarca("Corsinha");
		autoV.setCor("bege");
		autoV.setPlaca("BRA9J34");
		autoV.setAno(1989);
		autoV.setQuilometragem(23440.506);// aten��o para 0km
		autoV.setProprietario(clientV);
		autoV.setId(autoD.getIdFromBD());
		
		//autoD.inserir(autoV);
		
		
		
		List<AutoVO> auto = autoD.listar();
		
		for(AutoVO automovelShow : auto) {
			System.out.println(automovelShow.getId());
			System.out.println(automovelShow.getMarca());
			System.out.println(automovelShow.getCor());
			System.out.println(automovelShow.getPlaca());
			System.out.println(automovelShow.getAno());
			System.out.println(automovelShow.getQuilometragem());
			System.out.println(automovelShow.getProprietario().getId());
			System.out.println(automovelShow.getProprietario().getCPF());
			System.out.println("-------------------------------------------");
			
		}
		//autoD.removeByCor(autoV);
		
			
		 
		//--------------TESTE DE PECADAO-------------------
		PecasDAO<PecasVO> pecaD = new PecasDAO<PecasVO>();
		PecasVO pecaV = new PecasVO();
		
		
		pecaV.setName("Rebinboca do inferno");
		pecaV.setFabricante("Luci uncle corp");
		pecaV.setPreco(340.90);
		pecaV.setId(pecaD.getIdFromBD());
		
		//pecaD.inserir(pecaV);
		
		 
		/*
		
		List<PecasVO> auto = pecaD.findByNome(pecaV);
		
		for(PecasVO automovelShow : auto) {
			System.out.println(automovelShow.getId());
			System.out.println(automovelShow.getName());
			System.out.println(automovelShow.getFabricante());
			System.out.println(automovelShow.getPreco());
			System.out.println("-------------------------------------------");
			
		}
		*/
		
		
		// -------------TESTE SERVI�ODAO------------------
		ServicosDAO<ServicosVO> servicosD = new ServicosDAO<ServicosVO>();
		ServicosVO servicosV = new ServicosVO();
		
		servicosV.setTipo("instala��o de retrovisor");
		servicosV.setValor(220.60);
		servicosV.setFinalizado(true);
		servicosV.setAuto(autoV);
		//servicosV.setPeca(pecaV);
		servicosV.setId(servicosD.getIdFromBD());
		
		//servicosD.inserir(servicosV);
		
		/*
		List<ServicosVO> servico = servicosD.listar();
		
		for(ServicosVO servicosShow : servico) {
			System.out.println(servicosShow.getId());
			System.out.println(servicosShow.getTipo());
			System.out.println(servicosShow.getAuto().getId());
			System.out.println(servicosShow.getPeca().getId());
			System.out.println(servicosShow.getValor());
			System.out.println("Finalizado:" + servicosShow.getFinalizado());
			
		}
		*/
		
		/*
		 //-------------------TESTE ORCAMENTODAO-----------------
		OrcamentoVO orcV = new OrcamentoVO();
		OrcamentoDAO orcD = new OrcamentoDAO();
		
		Calendar data = Calendar.getInstance();
		Calendar data01 = Calendar.getInstance();
		Calendar data02 = Calendar.getInstance();
		
		SimpleDateFormat formatData = new SimpleDateFormat("yyyy-MM-dd");
		
		data.set(2013, 6, 12);
		data.setTimeInMillis(data.getTimeInMillis());
		
		orcV.setClientName(clientV);
		orcV.setServicos(servicosV);
		orcV.setAuto(autoV);
		orcV.setData(data);
		orcV.setCusto(459.90);
		
		
		
		data01.set(2020, 3, 21);
		data02.set(2012, 6, 2);
		//orcD.inserir(orcV);
		System.out.println(formatData.format(data01.getTime()));
		System.out.println(orcV.getClientName().getId());
		//orcD.findByData(orcV, formatO.format(data01.getTime()));
		/*
		List<OrcamentoVO> orc = orcD.findByData(orcV, formatData.format(data02.getTime()), formatData.format(data01.getTime()) );
		//List<OrcamentoVO> orc = orcD.listar();
		
		for(OrcamentoVO dataShow : orc) {
			System.out.println(dataShow.getId());
			System.out.println(dataShow.getClientName().getId());
			System.out.println(dataShow.getServicos().getId());
			System.out.println(dataShow.getCusto());
			System.out.println(dataShow.getData().getTime());
			System.out.println("-------------------------------------------");
			
			}
			*/
		
	}
}
