package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.AutoVO;
import model.vo.PecasVO;
import model.vo.ServicosVO;

public abstract class ServicosDAO<VO extends ServicosVO> extends BaseDAO<VO> {

	public void inserir(ServicosVO servicos) {
		conect = getConnection();
		String sql = "insert into servicos (tipo, valor, finalizado, idauto, idpeca ) values (?,?,?,?,?)";
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
	
	public void remove(ServicosVO servicos) {
		conect = getConnection();
		String sql = "delete from servicos where idservico = ?";
		PreparedStatement ptst;
		try {
			ptst = conect.prepareStatement(sql);
			ptst.setInt(1, servicos.getId());
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
				PecasVO peca = new PecasVO();
				
				auto.setId(rs.getInt("idauto"));
				peca.setId(rs.getInt("idpeca"));
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
	
	public List<ServicosVO> findByTipo(String tipo) {
		conect = getConnection();
		String sql = "select * from servicos where tipo like '" + tipo + "%'";
		Statement st;
		ResultSet rs;
		List<ServicosVO> servico = new ArrayList<ServicosVO>();
		
		try {
			st = conect.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ServicosVO servicos = new ServicosVO();
				AutoVO auto = new AutoVO();
				PecasVO peca = new PecasVO();
				
				auto.setId(rs.getInt("idauto"));
				peca.setId(rs.getInt("idpeca"));
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
	
	public List<ServicosVO> findByFinalizado(Boolean value) {
		conect = getConnection();
		String sql = "select * from servicos where finalizado like '" + value+ "%'";
		Statement st;
		ResultSet rs;
		List<ServicosVO> servico = new ArrayList<ServicosVO>();
		
		try {
			st = conect.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ServicosVO servicos = new ServicosVO();
				AutoVO auto = new AutoVO();
				PecasVO peca = new PecasVO();
				
				auto.setId(rs.getInt("idauto"));
				peca.setId(rs.getInt("idpeca"));
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
	
	public List<ServicosVO> findByAuto(AutoVO auto) {
		conect = getConnection();
		String sql = "select * from servicos where idauto like '" + auto.getId() + "%'";
		Statement st;
		ResultSet rs;
		List<ServicosVO> servico = new ArrayList<ServicosVO>();
		
		try {
			st = conect.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ServicosVO servicos = new ServicosVO();
				AutoVO autoV = new AutoVO();
				PecasVO peca = new PecasVO();
				
				autoV.setId(rs.getInt("idauto"));
				peca.setId(rs.getInt("idpeca"));
				servicos.setTipo(rs.getString("tipo"));
				servicos.setValor(rs.getDouble("valor"));
				servicos.setFinalizado(rs.getBoolean("finalizado"));
				servicos.setId(rs.getInt("idservico"));
				servicos.setAuto(autoV);
				servicos.setPeca(peca);
				servico.add(servicos);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return servico;
	}
	
	public List<ServicosVO> findByPeca(PecasVO peca) {
		conect = getConnection();
		String sql = "select * from servicos where idpeca like '" + peca.getId() + "%'";
		Statement st;
		ResultSet rs;
		List<ServicosVO> servico = new ArrayList<ServicosVO>();
		
		try {
			st = conect.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ServicosVO servicos = new ServicosVO();
				AutoVO auto = new AutoVO();
				PecasVO pecaV = new PecasVO();
				
				auto.setId(rs.getInt("idauto"));
				pecaV.setId(rs.getInt("idpeca"));
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
