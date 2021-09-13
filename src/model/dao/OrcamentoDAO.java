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
			ptst.setString(1, orc.getClienteVO().getName());
			ptst.setString(2, orc.getServicosVO().getTipo());
			ptst.setString(3, orc.getCusto());
			ptst.setInt(4, orc.getData());
			ptst.execute();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remover(OrcamentoVO orc) {
		conect = getConnection();
		String sql = "delete from orcamentos where id = ?";
		PreparedStatement ptst;
		try {
			
			ptst = conect.prepareStatement(sql);		
			ptst.setString(1, orc.getId());
			ptst.executeUpdate();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<OrcamentosVO> listar() {
		conect = getConnection();
		String sql = "select * from automnoveis";
		Statement st;
		ResultSet rs;
		List<OrcamentosVO> orc = new ArrayList<OrcamentosVO>();
		
		try {
			st = conect.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				AutoVO orcamento = new AutoVO();
				orcamento.setClienteVO().setName(rs.getString("nomeCliente"));
				orcamento.setServicosVO().setTipo(rs.getString("tipoServico"));
				orcamento.setCusto(rs.getString("custo"));
				orcamento.setData(rs.getInt("data"));
				orcamento.setId(rs.getInt("id"));
				orc.add(orcamento);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
	}
	
	public void editarCliente(OrcamentoVO orc) {
		conect = getConnection();
		String sql = "update orcamentos set nomeCliente = ? where id = ?";
		PreparedStatement ptst;
		try {
			
			ptst = conect.prepareStatement(sql);		
			ptst.setString(1, orc.getClienteVO().getName());
			ptst.setString(2, orc.Id());
			ptst.executeUpdate();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


