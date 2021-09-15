package model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

import model.vo.OrcamentoVO;


public class OrcamentoDAO extends BaseDAO {
	public void inserir(OrcamentoVO orc) {
		conect = getConnection();
		String sql = "insert into orcamentos (idcliente, idservico, custo, data) values (?,?,?,?)";
		PreparedStatement ptst;
		try {
			Date is = null;
			ptst = conect.prepareStatement(sql);		
			ptst.setInt(1, orc.getClientName().getId());
			ptst.setInt(2, orc.getServicos().getId());
			ptst.setDouble(3, orc.getCusto());
			ptst.setDate(4, is ,orc.getData());
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
				Calendar data = Calendar.getInstance();
				data.setTimeInMillis(rs.getDate("data").getTime());
				
				
				orcamento.getClientName().setName(rs.getString("nome"));
				orcamento.getServicos().setTipo(rs.getString("tipo"));
				orcamento.setCusto(rs.getDouble("custo"));
				orcamento.setData(data);
				orcamento.setId(rs.getInt("idorm"));
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
		String sql = "update orcamentos set nomeCliente = ? where id = ?";
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


