package model.bo;

import java.util.List;

import model.vo.AdminVO;
import model.vo.ClienteVO;

public class testeBO {
	
	public static void main (String[] args) throws Exception {
		
		ClienteBO clientB = new ClienteBO();
		ClienteVO clientV = new ClienteVO();
		/*
		clientV.setName("joao");
		clientV.setCPF("345.634.326-34");
		clientV.setEndereco("Rua amado batista");
		
		clientB.listarByCPF(clientV);
		*/
		
		AdminBO adminB = new AdminBO();
		AdminVO adminV = new AdminVO();
		
		adminV.setName("grande Irineu");
		adminV.setSenha("senhafortona123");
		adminV.setEmail("irineudasmenina@outonuck.com");
		
		//adminB.findByName(adminV);
		
		adminB.listar();
		
		

		
	}
	
	
	

}
