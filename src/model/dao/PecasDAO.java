package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.PecasVO;

public class PecasDAO extends BaseDAO {
	public void inserir(PecasVO peca) {
		conect = getConnection();
		String sql = "insert into pecas (nome, fabricante, preco) values (?,?,?)";
		PreparedStatement ptst;
		try {
			
			ptst = conect.prepareStatement(sql);		
			ptst.setString(1, peca.getName());
			ptst.setString(2, peca.getFabricante());
			ptst.setDouble(3, peca.getPreco());
			ptst.execute();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void remover(PecasVO peca) {
		conect = getConnection();
		String sql = "delete from pecas where idpeca = ?";
		PreparedStatement ptst;
		try {
			
			ptst = conect.prepareStatement(sql);
			ptst.setInt(1, peca.getId());
			ptst.executeUpdate();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<PecasVO> listar() {
		conect = getConnection();
		String sql = "select * from pecas";
		Statement st;
		ResultSet rs;
		List<PecasVO> pecas = new ArrayList<PecasVO>();
		
		try {
			st = conect.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				PecasVO peca = new PecasVO();
				peca.setName(rs.getString("nome"));
				peca.setFabricante(rs.getString("fabricante"));
				peca.setPreco(rs.getDouble("preco"));
				peca.setId(rs.getInt("id"));
				pecas.add(peca);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pecas;
	}
	public void editNome(PecasVO peca) {
		conect = getConnection();
		String sql = "update peca set nome = ? where idpeca = ?";
		PreparedStatement ptst;
		try {
			
			ptst = conect.prepareStatement(sql);		
			ptst.setString(1, peca.getName());
			ptst.setInt(2, peca.getId());
			ptst.execute();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
