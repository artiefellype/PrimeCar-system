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


public class OrcamentoDAO extends BaseDAO {
	public void inserir(OrcamentoVO orc) {
		conect = getConnection();
		String sql = "insert into orcamentos (nomeCliente, tipoServico, custo, data) values (?,?,?,?)";
		PreparedStatement ptst;
		try {
			
			ptst = conect.prepareStatement(sql);		
			ptst.setString(1, orc.getClientName().getName());
			ptst.setString(2, orc.getServicos().getTipo());
			ptst.setDouble(3, orc.getCusto());
			ptst.setDate(4, orc.getData());
			ptst.execute();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
				orcamento.setClientName(rs.getString("nomeCliente"));
				orcamento.setServicos(rs.getString("tipoServico"));
				orcamento.setCusto(rs.getDouble("custo"));
				orcamento.setData(rs.getDate("data"));
				orcamento.setId(rs.getInt("id"));
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


