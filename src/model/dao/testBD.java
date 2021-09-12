package model.dao;

import model.vo.ClienteVO;
import java.util.List;

public class testBD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseDAO client = new BaseDAO();
		System.out.println(client.getConnection());
		
		
		ClienteDAO clientD = new ClienteDAO();
		ClienteVO clientV = new ClienteVO();
		
		
		clientV.setName("mais uma vez pinto ");
		clientV.setCPF("123.9-23");
		clientV.setEndereco("Rusdsdsrr");
		
		
		
		//clientD.inserir(clientV);
		//clientD.editar(clientV);
		//clientD.removeByCPF(clientV);
		
		List<ClienteVO> clientes = clientD.listar();
		
		for(ClienteVO clientesShow : clientes) {
			System.out.println(clientesShow.getId());
			System.out.println(clientesShow.getName());
			System.out.println(clientesShow.getEndereco());
			System.out.println(clientesShow.getCPF());
			
		}
		
		
	}

}
