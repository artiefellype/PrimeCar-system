package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.ClienteVO;

public class ClienteDAO<VO extends ClienteVO> extends BaseDAO<VO>{
	
	
	public void inserir(VO client) {
		conect = getConnection();
		String sql = "insert into clientes (nome, endereco, cpf) values (?,?,?)";
		PreparedStatement ptst;
		try {
			
			ptst = conect.prepareStatement(sql);		
			ptst.setString(1, client.getName());
			ptst.setString(2, client.getEndereco());
			ptst.setString(3, client.getCPF());
			ptst.execute();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Integer getIdFromBD() { // RETORNA O ID DO REGISTRO MAIS RECENTE DO BANCO DE DADOS
		conect = getConnection();
		String sql = "select * from clientes order by idcliente desc limit 1";
		Statement st;
		ResultSet rs;
		int id = 0;
		try {
			ClienteVO cli = new ClienteVO();
			st = conect.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
			cli.setId(rs.getInt("idcliente"));
			}
			id = cli.getId();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
		
	}
	
	public void remover(VO client) {
		conect = getConnection();
		String sql = "delete from clientes where idcliente = ?";
		PreparedStatement ptst;
		try {
			ptst = conect.prepareStatement(sql);
			ptst.setInt(1, client.getId());
			ptst.executeUpdate();
			} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	
	public List<ClienteVO> listar() {
		conect = getConnection();
		String sql = "select * from clientes";
		Statement st;
		ResultSet rs;
		List<ClienteVO> client = new ArrayList<ClienteVO>();
		
		try {
			st = conect.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ClienteVO cliente = new ClienteVO();
				cliente.setName(rs.getString("nome"));
				cliente.setCPF(rs.getString("cpf"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setId(rs.getInt("idcliente"));
				client.add(cliente);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
	}
	
	public List<ClienteVO> findByName(String name){
		conect = getConnection();
		String sql = "select * from clientes where nome like '" + name + "%'" ;
		ResultSet rs;
		PreparedStatement ptst;
		
		List<ClienteVO> client = new ArrayList<ClienteVO>();
		
		try {
			ptst = conect.prepareStatement(sql);
			rs = ptst.executeQuery();
			while(rs.next()) {
				ClienteVO cliente = new ClienteVO();
				cliente.setName(rs.getString("nome"));
				cliente.setCPF(rs.getString("cpf"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setId(rs.getInt("idcliente"));
				client.add(cliente);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
		
	}
	
	public List<ClienteVO> findByCPF(String cpf){
		conect = getConnection();
		String sql = "select * from clientes where cpf like '" + cpf + "%'" ;
		ResultSet rs;
		PreparedStatement ptst;
		
		List<ClienteVO> client = new ArrayList<ClienteVO>();
		
		try {
			ptst = conect.prepareStatement(sql);
			rs = ptst.executeQuery();
			while(rs.next()) {
				ClienteVO cliente = new ClienteVO();
				cliente.setName(rs.getString("nome"));
				cliente.setCPF(rs.getString("cpf"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setId(rs.getInt("idcliente"));
				client.add(cliente);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
		
	}
	
	public List<ClienteVO> findByEndereco(String ende){
		conect = getConnection();
		String sql = "select * from clientes where endereco like '" + ende + "%'" ;
		ResultSet rs;
		PreparedStatement ptst;
		
		List<ClienteVO> client = new ArrayList<ClienteVO>();
		
		try {
			ptst = conect.prepareStatement(sql);
			rs = ptst.executeQuery();
			while(rs.next()) {
				ClienteVO cliente = new ClienteVO();
				cliente.setName(rs.getString("nome"));
				cliente.setCPF(rs.getString("cpf"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setId(rs.getInt("idcliente"));
				client.add(cliente);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
		
	}
	
	public void editar(VO client) {
		conect = getConnection();
		String sql = "update clientes set nome = ? where idcliente= ?";
		PreparedStatement ptst;
		
		try {
			ptst = conect.prepareStatement(sql);
			ptst.setString(1, client.getName());
			ptst.setInt(2, client.getId());
			ptst.execute();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
