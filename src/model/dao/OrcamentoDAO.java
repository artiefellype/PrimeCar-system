package model.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

import model.vo.OrcamentoVO;
import model.vo.ClienteVO;
import model.vo.ServicosVO;
import model.vo.AutoVO;


public class OrcamentoDAO extends BaseDAO {
	public void inserir(OrcamentoVO orc) {
		conect = getConnection();
		String sql = "insert into orcamentos (idcliente, idservico, idauto, custo, data) values (?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			
			ptst = conect.prepareStatement(sql);		
			ptst.setInt(1, orc.getClientName().getId());
			ptst.setInt(2, orc.getServicos().getId());
			ptst.setInt(3, orc.getAuto().getId());
			ptst.setDouble(4, orc.getCusto());
			ptst.setDate(5, new java.sql.Date(orc.getData().getTimeInMillis()));
			ptst.execute();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Integer getIdFromBD() { // RETORNA O ID DO REGISTRO MAIS RECENTE DO BANCO DE DADOS
		conect = getConnection();
		String sql = "select * from orcamentos order by idorm desc limit 1";
		Statement st;
		ResultSet rs;
		int id = 0;
		try {
			OrcamentoVO orc = new OrcamentoVO();
			st = conect.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
			orc.setId(rs.getInt("idorm"));
			}
			id = orc.getId();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
		
	}
	
	public void remover(OrcamentoVO orc) {
		conect = getConnection();
		String sql = "delete from orcamentos where idorc = ?";
		PreparedStatement ptst;
		try {
			
			ptst = conect.prepareStatement(sql);		
			ptst.setInt(1, orc.getId());
			ptst.executeUpdate();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<OrcamentoVO> listar() {
		conect = getConnection();
		String sql = "select * from orcamentos";
		Statement st;
		ResultSet rs;
		List<OrcamentoVO> orc = new ArrayList<OrcamentoVO>();
		
		try {
			st = conect.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				OrcamentoVO orcamento = new OrcamentoVO();
				ClienteVO cliente = new ClienteVO();
				ServicosVO servico = new ServicosVO();
				AutoVO auto = new AutoVO();
				Calendar data = Calendar.getInstance();
				
				data.setTimeInMillis(rs.getDate("data").getTime());
				cliente.getId();
				servico.getId();
				auto.getId();
				
				orcamento.setCusto(rs.getDouble("custo"));
				orcamento.setData(data);
				orcamento.setId(rs.getInt("idorm"));
				orcamento.setClientName(cliente);
				orcamento.setServicos(servico);
				orcamento.setAuto(auto);
				orc.add(orcamento);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orc;
	}
	
	public List<OrcamentoVO> findByCliente(OrcamentoVO orca) {
		conect = getConnection();
		String sql = "select * from orcamentos where idcliente like'" + orca.getClientName().getId() + "%'";
		Statement st;
		ResultSet rs;
		List<OrcamentoVO> orc = new ArrayList<OrcamentoVO>();
		
		try {
			st = conect.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				OrcamentoVO orcamento = new OrcamentoVO();
				ClienteVO cliente = new ClienteVO();
				ServicosVO servico = new ServicosVO();
				AutoVO auto = new AutoVO();
				Calendar data = Calendar.getInstance();
				
				data.setTimeInMillis(rs.getDate("data").getTime());
				cliente.getId();
				servico.getId();
				auto.getId();
				
				orcamento.setCusto(rs.getDouble("custo"));
				orcamento.setData(data);
				orcamento.setId(rs.getInt("idorm"));
				orcamento.setClientName(cliente);
				orcamento.setServicos(servico);
				orcamento.setAuto(auto);
				orc.add(orcamento);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orc;
	}
	
	public List<OrcamentoVO> findByAuto(OrcamentoVO orca) {
		conect = getConnection();
		String sql = "select * from orcamentos where idauto like'" + orca.getAuto().getId() + "%'";
		Statement st;
		ResultSet rs;
		List<OrcamentoVO> orc = new ArrayList<OrcamentoVO>();
		
		try {
			st = conect.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				OrcamentoVO orcamento = new OrcamentoVO();
				ClienteVO cliente = new ClienteVO();
				ServicosVO servico = new ServicosVO();
				AutoVO auto = new AutoVO();
				Calendar data = Calendar.getInstance();
				data.setTimeInMillis(rs.getDate("data").getTime());
				
				cliente.getId();
				servico.getId();
				auto.getId();
				orcamento.setCusto(rs.getDouble("custo"));
				orcamento.setData(data);
				orcamento.setId(rs.getInt("idorm"));
				orcamento.setClientName(cliente);
				orcamento.setServicos(servico);
				orcamento.setAuto(auto);
				orc.add(orcamento);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orc;
	}
	
	public void editarCliente(OrcamentoVO orc) {
		conect = getConnection();
		String sql = "update orcamentos set nomeCliente = ? where idorm= ?";
		PreparedStatement ptst;
		try {
			
			ptst = conect.prepareStatement(sql);		
			ptst.setString(1, orc.getClientName().getName());
			ptst.setInt(2, orc.getId());
			ptst.executeUpdate();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


