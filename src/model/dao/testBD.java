package model.dao;

//import java.util.List;

import model.vo.AutoVO;
import model.vo.ClienteVO;
//import model.vo.ServicosVO;



public class testBD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseDAO base = new BaseDAO();
		System.out.println(base.getConnection());
		
		/* // ---------------TESTE CLIENTEDAO --------------------
		ClienteDAO clientD = new ClienteDAO();
		ClienteVO clientV = new ClienteVO();
		
		
		clientV.setName("felipe de caia");
		clientV.setCPF("123.222.433-28");
		clientV.setEndereco("Rua marimar");
		clientV.setId(clientD.getIdFromBD());
		
		clientD.inserir(clientV);
		
	
		
		//clientD.editar(clientV);
		//clientD.removeByCPF(clientV);
		//System.out.println("---------------------");
		//System.out.println(clientD.getIdFromBD());
		//System.out.println("---------------------");
		
		
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
		
		AutoDAO autoD = new AutoDAO();
		AutoVO autoV = new AutoVO();
		
		autoV.setMarca("chevrolet");
		autoV.setCor("cinza");
		autoV.setPlaca("BRA2E19");
		autoV.setAno(2019);
		autoV.setQuilometragem(21783.7);
		//autoV.setId(autoD.getIdFromBD());
		
		autoD.inserir(autoV);
		/*
		List<ServicosVO> servico = servicosD.listar();
		
		for(ServicosVO servicosShow : servico) {
			System.out.println(servicosShow.getId());
			System.out.println(servicosShow.getTipo());
			System.out.println(servicosShow.getValor());
			System.out.println("Finalizado:" + servicosShow.getFinalizado());
			
		}
		
		*/
		
		
		
	}

}
