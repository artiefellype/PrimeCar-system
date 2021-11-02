package model.bo;

import model.vo.ClienteVO;
import model.dao.ClienteDAO;
import java.util.List;


public class ClienteBO<VO extends ClienteVO> {
	ClienteDAO<ClienteVO> cli = new ClienteDAO<>();
	
	public void inserirBO(VO client) {
		cli.inserir(client);
	}
	
	public void editarBO(VO client) {
		cli.editar(client);
	}
	
	public void removerBO(VO client) {
		cli.remover(client);
	}
	
	public List<ClienteVO> listarBO() {
		List<ClienteVO> clientes = cli.listar();
		
		for(ClienteVO clientesShow : clientes) {
			System.out.println(clientesShow.getId());
			System.out.println(clientesShow.getName());
			System.out.println(clientesShow.getEndereco());
			System.out.println(clientesShow.getCPF());
			
		}
		
		return clientes;
	}
	
	public void listarByNome(VO client) {
		String nome = client.getName();
		List<ClienteVO> clientes = cli.findByName(nome);
		
		for(ClienteVO clientesShow : clientes) {
			System.out.println(clientesShow.getId());
			System.out.println(clientesShow.getName());
			System.out.println(clientesShow.getEndereco());
			System.out.println(clientesShow.getCPF());
			
		}
	}
	
	public void listarByCPF(VO client) {
		String cpf = client.getCPF();
		List<ClienteVO> clientes = cli.findByCPF(cpf);
		
		for(ClienteVO clientesShow : clientes) {
			System.out.println(clientesShow.getId());
			System.out.println(clientesShow.getName());
			System.out.println(clientesShow.getEndereco());
			System.out.println(clientesShow.getCPF());
			
		}
	}
	
	public void listarByEndereco(VO client) {
		String endereco = client.getEndereco();
		List<ClienteVO> clientes = cli.findByEndereco(endereco);
		
		for(ClienteVO clientesShow : clientes) {
			System.out.println(clientesShow.getId());
			System.out.println(clientesShow.getName());
			System.out.println(clientesShow.getEndereco());
			System.out.println(clientesShow.getCPF());
			
		}
	}
	
}
