package model.dao;

import java.util.List;

import model.vo.AutoVO;
import model.vo.ClienteVO;
import model.vo.PecasVO;
import model.vo.ServicosVO;



public class testBD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseDAO base = new BaseDAO();
		System.out.println(base.getConnection());
		
		
		 // ---------------TESTE CLIENTEDAO --------------------
		ClienteDAO clientD = new ClienteDAO();
		ClienteVO clientV = new ClienteVO();
		
		
		clientV.setName("mariazinha");
		clientV.setCPF("345.673.456-34");
		clientV.setEndereco("Rua chico anizio");
		clientV.setId(clientD.getIdFromBD());
		
		//clientD.inserir(clientV);
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
		AutoDAO autoD = new AutoDAO();
		AutoVO autoV = new AutoVO();
		
		
		autoV.setMarca("Chevrolet chevete");
		autoV.setCor("bege");
		autoV.setPlaca("BRA9J34");
		autoV.setAno(1989);
		autoV.setQuilometragem(28209883.0);// atenção para 0km
		autoV.setProprietario(clientV);
		autoV.setId(autoD.getIdFromBD());
		
		//autoD.inserir(autoV);
		
		
		/*
		List<AutoVO> auto = autoD.findByMarca(autoV.getMarca());
		
		for(AutoVO automovelShow : auto) {
			System.out.println(automovelShow.getId());
			System.out.println(automovelShow.getMarca());
			System.out.println(automovelShow.getCor());
			System.out.println(automovelShow.getPlaca());
			System.out.println(automovelShow.getAno());
			System.out.println(automovelShow.getQuilometragem());
			System.out.println(automovelShow.getProprietario().getId());
			System.out.println("-------------------------------------------");
			
		}
		//autoD.removeByCor(autoV);
		
			*/
		//--------------TESTE DE PECADAO-------------------
		PecasDAO pecaD = new PecasDAO();
		PecasVO pecaV = new PecasVO();
		
		
		pecaV.setName("Parafuso da parafuzeta");
		pecaV.setFabricante("Tesla companies");
		pecaV.setPreco(22.50);
		pecaV.setId(pecaD.getIdFromBD());
		
		//pecaD.inserir(pecaV);
		
		// -------------TESTE SERVIÇODAO------------------
		ServicosDAO servicosD = new ServicosDAO();
		ServicosVO servicosV = new ServicosVO();
		
		servicosV.setTipo("instalação de retrovisor");
		servicosV.setValor(220.60);
		servicosV.setFinalizado(true);
		servicosV.setAuto(autoV);
		servicosV.setPeca(pecaV);
		servicosV.setId(servicosD.getIdFromBD());
		
		//servicosD.inserir(servicosV);
		
		
		List<ServicosVO> servico = servicosD.listar();
		
		for(ServicosVO servicosShow : servico) {
			System.out.println(servicosShow.getId());
			System.out.println(servicosShow.getTipo());
			System.out.println(servicosShow.getAuto().getId());
			System.out.println(servicosShow.getPeca().getId());
			System.out.println(servicosShow.getValor());
			System.out.println("Finalizado:" + servicosShow.getFinalizado());
			
		}
		
		
		
		
		
	}

}
