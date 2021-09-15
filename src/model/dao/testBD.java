package model.dao;

import java.util.List;

import model.vo.AutoVO;
import model.vo.ClienteVO;
//import model.vo.ServicosVO;



public class testBD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseDAO base = new BaseDAO();
		System.out.println(base.getConnection());
		
		
		 // ---------------TESTE CLIENTEDAO --------------------
		ClienteDAO clientD = new ClienteDAO();
		ClienteVO clientV = new ClienteVO();
		
		
		clientV.setName("editado");
		clientV.setCPF("123.9-23");
		clientV.setEndereco("Rua chico freire");
		clientV.setId(clientD.getIdFromBD());
		
		
		//List<ClienteVO> clientes = clientD.findByName(clientV.getName());
		//List<ClienteVO> clientes = clientD.findByCPF(clientV.getCPF());
		List<ClienteVO> clientes = clientD.findByEndereco(clientV.getEndereco());
		
		
		for(ClienteVO clientesShow : clientes) {
			System.out.println(clientesShow.getId());
			System.out.println(clientesShow.getName());
			System.out.println(clientesShow.getEndereco());
			System.out.println(clientesShow.getCPF());
		}
		
		
		
		
		
		//clientD.inserir(clientV);
		
	
		
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
		
		/* -------------TESTE SERVIÇODAO------------------
		ServicosDAO servicosD = new ServicosDAO();
		ServicosVO servicosV = new ServicosVO();
		
		servicosV.setTipo("troca de vidraça");
		servicosV.setValor(120.60);
		servicosV.setFinalizado(false);
		servicosV.setId(servicosD.getIdFromBD());
		
		//servicosD.inserir(servicosV);
		
		List<ServicosVO> servico = servicosD.listar();
		
		for(ServicosVO servicosShow : servico) {
			System.out.println(servicosShow.getId());
			System.out.println(servicosShow.getTipo());
			System.out.println(servicosShow.getValor());
			System.out.println("Finalizado:" + servicosShow.getFinalizado());
			
		}
		*/
		
		/*
		 //-------------TESTE AUTOMOVELDAO---------------------
		AutoDAO autoD = new AutoDAO();
		AutoVO autoV = new AutoVO();
		
		
		autoV.setMarca("toyota");
		autoV.setCor("azul");
		autoV.setPlaca("BRA1Z14");
		autoV.setAno(2019);
		autoV.setQuilometragem(2873823.0);// atenção para 0km
		autoV.setProprietario(clientV);
		autoV.setId(autoD.getIdFromBD());
		
		//autoD.inserir(autoV);
		
		
		
		List<AutoVO> auto = autoD.listar();
		
		for(AutoVO automovelShow : auto) {
			System.out.println(automovelShow.getId());
			//System.out.println(automovelShow.getMarca());
			//System.out.println(automovelShow.getCor());
			System.out.println(automovelShow.getPlaca());
			//System.out.println(automovelShow.getAno());
			//System.out.println(automovelShow.getQuilometragem());
			//System.out.println(automovelShow.getProprietario().getId());
			System.out.println("-------------------------------------------");
			
		}
		
		*/
		//autoD.removeByCor(autoV);
		
		
		
		
		
	}

}
