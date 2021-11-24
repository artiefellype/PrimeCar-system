package model.bo;

import java.util.List;

import model.vo.AdminVO;
import model.vo.AutoVO;
import model.vo.ClienteVO;

public class testeBO {
	
	public static void main (String[] args) throws Exception {
		
		AutoBO<AutoVO> autoB = new AutoBO<AutoVO>();
		AutoVO autoV = new AutoVO();
		
		ClienteVO clientV = new ClienteVO();
		ClienteBO<ClienteVO> clientB = new ClienteBO<ClienteVO>();
		
		clientV.setName("Joao Amerildo");
		clientV.setCPF("714.640.450-11");
		clientV.setEndereco("Rua dos indigentes");
		clientV.setId(16);
		
		
		autoV.setAno(1999);
		autoV.setMarca("Fiat Uno da firma");
		autoV.setCor("Cinza");
		autoV.setPlaca("LIG3I40");
		autoV.setQuilometragem(23455.80);
		autoV.setProprietario(clientV);
		//autoB.inserirBO(autoV);
		//clientB.listarBO();
		autoB.listarBO();
		
		
		
		//clientB.listarByCPF(clientV);
		
		/*
		AdminBO adminB = new AdminBO();
		AdminVO adminV = new AdminVO();
		
		adminV.setName("grande Irineu");
		adminV.setSenha("senhafortona123");
		adminV.setEmail("irineudasmenina@outonuck.com");
		
		//adminB.findByName(adminV);
		
		adminB.listar();
		*/
		

		
	}
	
	
	

}
