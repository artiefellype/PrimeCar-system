package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.AutoVO;
import model.vo.ClienteVO;


public class AutoDAO<VO extends AutoVO> extends BaseDAO<VO>{
	public void inserir(VO automovel) {
		conect = getConnection();
		String sql = "insert into auto (marca, cor, placa, ano, quilometragem, idcliente) values (?, ?, ?, ?, ?, ?)";
		PreparedStatement ptst;
		try {
			
			ptst = conect.prepareStatement(sql);		
			ptst.setString(1, automovel.getMarca());
			ptst.setString(2, automovel.getCor());
			ptst.setString(3, automovel.getPlaca());
			ptst.setInt(4, automovel.getAno());
			ptst.setDouble(5, automovel.getQuilometragem());
			ptst.setInt(6, automovel.getProprietario().getId());
			ptst.execute();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Integer getIdFromBD() { // RETORNA O ID DO REGISTRO MAIS RECENTE DO BANCO DE DADOS
		conect = getConnection();
		String sql = "select * from auto order by idauto desc limit 1";
		Statement st;
		ResultSet rs;
		int id = 0;
		try {
			AutoVO auto = new AutoVO();
			st = conect.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
			auto.setId(rs.getInt("idauto"));
			}
			id = auto.getId();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
		
	}
	
	public void remover(VO automovel) {
		conect = getConnection();
		String sql = "delete from auto where idauto = ?";
		PreparedStatement ptst;
		try {
			ptst = conect.prepareStatement(sql);
			ptst.setInt(1, automovel.getId());
			ptst.executeUpdate();
			} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	
	
	public List<AutoVO> listar() {
		conect = getConnection();
		String sql = "select * from auto";
		Statement st;
		ResultSet rs;
		List<AutoVO> auto = new ArrayList<AutoVO>();
		
		try {
			st = conect.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				AutoVO automovel = new AutoVO();
				
				automovel.setId(rs.getInt("idauto"));
				automovel.setMarca(rs.getString("marca"));
				automovel.setCor(rs.getString("cor"));
				automovel.setPlaca(rs.getString("placa"));
				automovel.setAno(rs.getInt("ano"));
				automovel.setQuilometragem(rs.getDouble("quilometragem"));
				automovel.getProprietario().setId(rs.getInt("idcliente"));
				auto.add(automovel);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return auto;
	}
	
	public List<AutoVO> findByMarca(String marca){
		conect = getConnection();
		String sql = "select * from auto where marca like '" + marca + "%'" ;
		ResultSet rs;
		PreparedStatement ptst;
		
		List<AutoVO> auto = new ArrayList<AutoVO>();
		
		try {
			ptst = conect.prepareStatement(sql);
			rs = ptst.executeQuery();
			while(rs.next()) {
				AutoVO automovel = new AutoVO();
				ClienteVO client = new ClienteVO();
				
				client.setId(rs.getInt("idcliente"));
				automovel.setId(rs.getInt("idauto"));
				automovel.setMarca(rs.getString("marca"));
				automovel.setCor(rs.getString("cor"));
				automovel.setPlaca(rs.getString("placa"));
				automovel.setAno(rs.getInt("ano"));
				automovel.setQuilometragem(rs.getDouble("quilometragem"));
				automovel.setProprietario(client);
				auto.add(automovel);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return auto;
		
	}
	public List<AutoVO> findByCor(String cor){
		conect = getConnection();
		String sql = "select * from auto where cor like '" + cor + "%'" ;
		ResultSet rs;
		PreparedStatement ptst;
		
		List<AutoVO> auto = new ArrayList<AutoVO>();
		
		try {
			ptst = conect.prepareStatement(sql);
			rs = ptst.executeQuery();
			while(rs.next()) {
				AutoVO automovel = new AutoVO();
				ClienteVO client = new ClienteVO();
				
				client.setId(rs.getInt("idcliente"));
				automovel.setId(rs.getInt("idauto"));
				automovel.setMarca(rs.getString("marca"));
				automovel.setCor(rs.getString("cor"));
				automovel.setPlaca(rs.getString("placa"));
				automovel.setAno(rs.getInt("ano"));
				automovel.setQuilometragem(rs.getDouble("quilometragem"));
				automovel.setProprietario(client);
				auto.add(automovel);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return auto;
		
	}
	public List<AutoVO> findByPlaca(String placa){
		conect = getConnection();
		String sql = "select * from auto where placa like '" + placa + "%'" ;
		ResultSet rs;
		PreparedStatement ptst;
		
		List<AutoVO> auto = new ArrayList<AutoVO>();
		
		try {
			ptst = conect.prepareStatement(sql);
			rs = ptst.executeQuery();
			while(rs.next()) {
				AutoVO automovel = new AutoVO();
				ClienteVO client = new ClienteVO();
				
				client.setId(rs.getInt("idcliente"));
				automovel.setId(rs.getInt("idauto"));
				automovel.setMarca(rs.getString("marca"));
				automovel.setCor(rs.getString("cor"));
				automovel.setPlaca(rs.getString("placa"));
				automovel.setAno(rs.getInt("ano"));
				automovel.setQuilometragem(rs.getDouble("quilometragem"));
				automovel.setProprietario(client);
				auto.add(automovel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return auto;
		
	}
	public List<AutoVO> findByAno(Integer ano){
		conect = getConnection();
		String sql = "select * from auto where ano like '" + ano + "%'" ;
		ResultSet rs;
		PreparedStatement ptst;
		
		List<AutoVO> auto = new ArrayList<AutoVO>();
		
		try {
			ptst = conect.prepareStatement(sql);
			rs = ptst.executeQuery();
			while(rs.next()) {
				AutoVO automovel = new AutoVO();
				ClienteVO client = new ClienteVO();
				
				client.setId(rs.getInt("idcliente"));
				automovel.setId(rs.getInt("idauto"));
				automovel.setMarca(rs.getString("marca"));
				automovel.setCor(rs.getString("cor"));
				automovel.setPlaca(rs.getString("placa"));
				automovel.setAno(rs.getInt("ano"));
				automovel.setQuilometragem(rs.getDouble("quilometragem"));
				automovel.setProprietario(client);
				auto.add(automovel);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return auto;
		
	}
	public List<AutoVO> findByQuilom(Double km){
		conect = getConnection();
		String sql = "select * from auto where quilometragem like '" + km + "%'" ;
		ResultSet rs;
		PreparedStatement ptst;
		
		List<AutoVO> auto = new ArrayList<AutoVO>();
		
		try {
			ptst = conect.prepareStatement(sql);
			rs = ptst.executeQuery();
			while(rs.next()) {
				AutoVO automovel = new AutoVO();
				ClienteVO client = new ClienteVO();
				
				client.setId(rs.getInt("idcliente"));
				automovel.setId(rs.getInt("idauto"));
				automovel.setMarca(rs.getString("marca"));
				automovel.setCor(rs.getString("cor"));
				automovel.setPlaca(rs.getString("placa"));
				automovel.setAno(rs.getInt("ano"));
				automovel.setQuilometragem(rs.getDouble("quilometragem"));
				automovel.setProprietario(client);
				auto.add(automovel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return auto;
		
	}
	public List<AutoVO> findByCliente(Integer idClient){
		conect = getConnection();
		String sql = "select * from auto where idcliente like '" + idClient + "%'" ;
		ResultSet rs;
		PreparedStatement ptst;
		
		List<AutoVO> auto = new ArrayList<AutoVO>();
		
		try {
			ptst = conect.prepareStatement(sql);
			rs = ptst.executeQuery();
			while(rs.next()) {
				AutoVO automovel = new AutoVO();
				ClienteVO client = new ClienteVO();
				
				client.setId(rs.getInt("idcliente"));
				automovel.setId(rs.getInt("idauto"));
				automovel.setMarca(rs.getString("marca"));
				automovel.setCor(rs.getString("cor"));
				automovel.setPlaca(rs.getString("placa"));
				automovel.setAno(rs.getInt("ano"));
				automovel.setQuilometragem(rs.getDouble("quilometragem"));
				automovel.setProprietario(client);
				auto.add(automovel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return auto;
		
	}
	public void editar(VO automovel) {
		conect = getConnection();
		String sql = "update auto set tipo = ? where idauto= ?";
		PreparedStatement ptst;
		
		try {
			ptst = conect.prepareStatement(sql);
			ptst.setString(1, automovel.getMarca());
			ptst.setInt(2, automovel.getId());
			ptst.execute();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
