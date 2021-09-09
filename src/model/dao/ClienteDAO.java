package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.ClienteVO;

public class ClienteDAO extends BaseDAO{
	
	public void inserir(ClienteVO client) {
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
	
	public void removeByName(ClienteVO client) {
		conect = getConnection();
		String sql = "delete from clientes where nome = ?";
		PreparedStatement ptst;
		try {
			ptst = conect.prepareStatement(sql);
			ptst.setString(1, client.getName());
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
				client.add(cliente);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
		
		
		
	}
}
