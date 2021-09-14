package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.AutoVO;


public class AutoDAO extends BaseDAO{
	public void inserir(AutoVO automovel) {
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
	
	public void removeByMarca(AutoVO automovel) {
		conect = getConnection();
		String sql = "delete from auto where marca = ?";
		PreparedStatement ptst;
		try {
			ptst = conect.prepareStatement(sql);
			ptst.setString(1, automovel.getMarca());
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
				
				automovel.setMarca(rs.getString("marca"));
				automovel.setCor(rs.getString("cor"));
				automovel.setPlaca(rs.getString("placa"));
				automovel.setAno(rs.getInt("ano"));
				automovel.setQuilometragem(rs.getDouble("quilometragem"));
				automovel.getProprietario().setId(rs.getInt("idcliente"));
				automovel.setId(rs.getInt("idauto"));
				auto.add(automovel);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return auto;
	}
	
	public void editar(AutoVO automovel) {
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
