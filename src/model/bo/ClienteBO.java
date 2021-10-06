package model.bo;

import model.vo.ClienteVO;
import model.dao.ClienteDAO;
import java.util.List;


public class ClienteBO {
	ClienteDAO<ClienteVO> cli = new ClienteDAO<>();
	
	public void inserirBO(ClienteVO client) {
		cli.inserir(client);
	}
	
	public void editarBO(ClienteVO client) {
		cli.editar(client);
	}
	
	public void removerBO(ClienteVO client) {
		cli.remover(client);
	}
	
	public void listarBO() {
		List<ClienteVO> clientes = cli.listar();
		
		for(ClienteVO clientesShow : clientes) {
			System.out.println(clientesShow.getId());
			System.out.println(clientesShow.getName());
			System.out.println(clientesShow.getEndereco());
			System.out.println(clientesShow.getCPF());
			
		}
	}
	
	public void listarByNome(ClienteVO client) {
		String nome = client.getName();
		List<ClienteVO> clientes = cli.findByName(nome);
		
		for(ClienteVO clientesShow : clientes) {
			System.out.println(clientesShow.getId());
			System.out.println(clientesShow.getName());
			System.out.println(clientesShow.getEndereco());
			System.out.println(clientesShow.getCPF());
			
		}
	}
	
	public void listarByCPF(ClienteVO client) {
		String cpf = client.getName();
		List<ClienteVO> clientes = cli.findByName(cpf);
		
		for(ClienteVO clientesShow : clientes) {
			System.out.println(clientesShow.getId());
			System.out.println(clientesShow.getName());
			System.out.println(clientesShow.getEndereco());
			System.out.println(clientesShow.getCPF());
			
		}
	}
	
	public void listarByEndereco(ClienteVO client) {
		String endereco = client.getName();
		List<ClienteVO> clientes = cli.findByName(endereco);
		
		for(ClienteVO clientesShow : clientes) {
			System.out.println(clientesShow.getId());
			System.out.println(clientesShow.getName());
			System.out.println(clientesShow.getEndereco());
			System.out.println(clientesShow.getCPF());
			
		}
	}
	
}
