package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.ServicosVO;
import model.vo.AutoVO;
import model.vo.PecasVO;

public class ServicosDAO extends BaseDAO {

	public void inserir(ServicosVO servicos) {
		conect = getConnection();
		String sql = "insert into servicos (tipo, valor, idauto, idpeca, finalizado) values (?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			
			ptst = conect.prepareStatement(sql);		
			ptst.setString(1, servicos.getTipo());
			ptst.setDouble(2, servicos.getValor());
			ptst.setBoolean(3, servicos.getFinalizado());
			ptst.setInt(4, servicos.getAuto().getId());
			ptst.setInt(5, servicos.getPeca().getId());
			ptst.execute();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Integer getIdFromBD() { // RETORNA O ID DO REGISTRO MAIS RECENTE DO BANCO DE DADOS
		conect = getConnection();
		String sql = "select * from servicos order by idservico desc limit 1";
		Statement st;
		ResultSet rs;
		int id = 0;
		try {
			ServicosVO serv = new ServicosVO();
			st = conect.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
			serv.setId(rs.getInt("idservico"));
			}
			id = serv.getId();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
		
	}
	
	public void removeByTipo(ServicosVO servicos) {
		conect = getConnection();
		String sql = "delete from servicos where tipo = ?";
		PreparedStatement ptst;
		try {
			ptst = conect.prepareStatement(sql);
			ptst.setString(1, servicos.getTipo());
			ptst.executeUpdate();
			} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	public void removeByAuto(ServicosVO servicos) {
		conect = getConnection();
		String sql = "delete from servicos where idauto = ?";
		PreparedStatement ptst;
		try {
			ptst = conect.prepareStatement(sql);
			ptst.setInt(1, servicos.getAuto().getId());
			ptst.executeUpdate();
			} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	public void removeByPeca(ServicosVO servicos) {
		conect = getConnection();
		String sql = "delete from servicos where idpeca = ?";
		PreparedStatement ptst;
		try {
			ptst = conect.prepareStatement(sql);
			ptst.setInt(1, servicos.getPeca().getId());
			ptst.executeUpdate();
			} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	public void removeByFinalizado(ServicosVO servicos) {
		conect = getConnection();
		String sql = "delete from servicos where finalizado = ?";
		PreparedStatement ptst;
		try {
			ptst = conect.prepareStatement(sql);
			ptst.setBoolean(1, servicos.getFinalizado());
			ptst.executeUpdate();
			} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	
	
	public List<ServicosVO> listar() {
		conect = getConnection();
		String sql = "select * from servicos";
		Statement st;
		ResultSet rs;
		List<ServicosVO> servico = new ArrayList<ServicosVO>();
		
		try {
			st = conect.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ServicosVO servicos = new ServicosVO();
				AutoVO auto = new AutoVO();
				PecasVO peca = new PecaVO();
				auto.getId(rs.getInt("idauto"));
				peca.getId(rs.getInt("idpeca"));
				servicos.setTipo(rs.getString("tipo"));
				servicos.setValor(rs.getDouble("valor"));
				servicos.setFinalizado(rs.getBoolean("finalizado"));
				servicos.setId(rs.getInt("idservico"));
				servicos.setAuto(auto);
				servicos.setPeca(peca);
				servico.add(servicos);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return servico;
	}
	
	public List<ServicosVO> findByTipo() {
		conect = getConnection();
		String sql = "select from servicos where tipo = ?";
		Statement st;
		ResultSet rs;
		List<ServicosVO> servico = new ArrayList<ServicosVO>();
		
		try {
			st = conect.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ServicosVO servicos = new ServicosVO();
				AutoVO auto = new AutoVO();
				PecasVO peca = new PecaVO();
				auto.getId(rs.getInt("idauto"));
				peca.getId(rs.getInt("idpeca"));
				servicos.setTipo(rs.getString("tipo"));
				servicos.setValor(rs.getDouble("valor"));
				servicos.setFinalizado(rs.getBoolean("finalizado"));
				servicos.setId(rs.getInt("idservico"));
				servicos.setAuto(auto);
				servicos.setPeca(peca);
				servico.add(servicos);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return servico;
	}
	
	public List<ServicosVO> findByFinalizado() {
		conect = getConnection();
		String sql = "select from servicos where finalizado = ?";
		Statement st;
		ResultSet rs;
		List<ServicosVO> servico = new ArrayList<ServicosVO>();
		
		try {
			st = conect.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ServicosVO servicos = new ServicosVO();
				AutoVO auto = new AutoVO();
				PecasVO peca = new PecaVO();
				auto.getId(rs.getInt("idauto"));
				peca.getId(rs.getInt("idpeca"));
				servicos.setTipo(rs.getString("tipo"));
				servicos.setValor(rs.getDouble("valor"));
				servicos.setFinalizado(rs.getBoolean("finalizado"));
				servicos.setId(rs.getInt("idservico"));
				servicos.setAuto(auto);
				servicos.setPeca(peca);
				servico.add(servicos);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return servico;
	}
	
	public void editar(ServicosVO servicos) {
		conect = getConnection();
		String sql = "update servicos set tipo = ? where idservico= ?";
		PreparedStatement ptst;
		
		try {
			ptst = conect.prepareStatement(sql);
			ptst.setString(1, servicos.getTipo());
			ptst.setInt(2, servicos.getId());
			ptst.execute();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
