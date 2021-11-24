package model.bo;

import model.vo.ClienteVO;
import model.dao.ClienteDAO;
import java.util.List;


public class ClienteBO<VO extends ClienteVO> {
	ClienteDAO<ClienteVO> cli = new ClienteDAO<>();
	
	public void inserirBO(VO client) {
		cli.inserir(client);
		System.out.println("cliente Inserido");
	}
	
	public void editarBO(VO client) {
		cli.editar(client);
		System.out.println("cliente editado");
	}
	
	public void removerBO(VO client) {
		cli.remover(client);
		System.out.println("cliente removido");
	}
	
	public List<ClienteVO> listarBO() {
		return cli.listar();
	}
	
	public List<ClienteVO> listarByNome(VO client) {
		String nome = client.getName();
		
		return cli.findByName(nome);
		
	}
	
	public ClienteVO listarByCPF(VO client) {
		List<ClienteVO> clientes = cli.findByCPF(client.getCPF());
		
		return clientes.get(0);
	}
	public List<ClienteVO> findByCPF(VO client) {
		System.out.println("CPFLISTA@>>>>>" + cli.findByCPF(client.getCPF()));
		return cli.findByCPF(client.getCPF());
	}
	
	public List<ClienteVO> listarByEndereco(VO client) {
		String endereco = client.getEndereco();
		List<ClienteVO> clientes = cli.findByEndereco(endereco);
		return clientes;
		
		
	}
	
}
