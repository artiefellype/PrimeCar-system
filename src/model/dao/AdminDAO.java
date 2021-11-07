package model.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.AdminVO;

public class AdminDAO<VO extends AdminVO> extends BaseDAO<VO> {  
	
	public void inserir(VO admin) {
		conect = getConnection();
		String sql = "insert into admin (nome, senha, email) values (?,?,?)";
		PreparedStatement ptst;
		try {
		
			ptst = conect.prepareStatement(sql);		
			ptst.setString(1, admin.getName());
			ptst.setString(2, admin.getSenha());
			ptst.setString(3, admin.getEmail());
			ptst.execute();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Integer getIdFromBD() { // RETORNA O ID DO REGISTRO MAIS RECENTE DO BANCO DE DADOS
		conect = getConnection();
		String sql = "select * from admin order by idadmin desc limit 1";
		Statement st;
		ResultSet rs;
		int id = 0;
		try {
			AdminVO admin = new AdminVO();
			st = conect.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
			admin.setId(rs.getInt("idadmin"));
			}
				if(admin.getId() == null) {
					id = 1;
				}else {
					id = admin.getId();
				}
				
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
		
	}
	//adm.setSenha(rs.getString("senha"));
	public List<AdminVO> findByName(VO name){
		conect = getConnection();
		String sql = "select * from admin where nome like '" + name.getName() + "%'" ;
		ResultSet rs;
		PreparedStatement ptst;
		
		List<AdminVO> admin = new ArrayList<AdminVO>();
		
		try {
			ptst = conect.prepareStatement(sql);
			rs = ptst.executeQuery();
			while(rs.next()) {
				AdminVO adm = new AdminVO();
				adm.setId(rs.getInt("idadmin"));
				adm.setName(rs.getString("nome"));
				adm.setSenha(rs.getString("senha"));
				adm.setEmail(rs.getString("email"));
				admin.add(adm);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;
		
	}
	
	
	public List<AdminVO> findByEmail(VO email){
		conect = getConnection();
		String sql = "select * from admin where email like '" + email.getEmail() + "%'" ;
		ResultSet rs;
		PreparedStatement ptst;
		
		List<AdminVO> admin = new ArrayList<AdminVO>();
		
		try {
			ptst = conect.prepareStatement(sql);
			rs = ptst.executeQuery();
			while(rs.next()) {
				AdminVO adm = new AdminVO();
				adm.setId(rs.getInt("idadmin"));
				adm.setName(rs.getString("nome"));
				adm.setSenha(rs.getString("senha"));
				adm.setEmail(rs.getString("email"));
				admin.add(adm);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;
		
	}
	
	
	
	public void remover(VO admin) {
		conect = getConnection();
		String sql = "delete from admin where idadmin = ?";
		PreparedStatement ptst;
		try {
			
			ptst = conect.prepareStatement(sql);		
			ptst.setInt(1, admin.getId());
			ptst.executeUpdate();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<AdminVO> listar(){
		conect = getConnection();
		String sql = "select * from admin";
		Statement st;
		ResultSet rs;
		List<AdminVO> admin = new ArrayList<AdminVO>();
		
		try {
			st = conect.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				AdminVO adm = new AdminVO();
	
				adm.setId(rs.getInt("idadmin")); 
				adm.setName(rs.getString("nome"));
				adm.setSenha(rs.getString("senha")); 
				adm.setEmail(rs.getString("email"));
			
				
				admin.add(adm);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;
	}
	
	public void editarSenha(VO admin){
		conect = getConnection();
		String sql = "update admin set nome = ?, set senha = ?, set email = ? where id = ?";
		PreparedStatement ptst;
		try {
			
			ptst = conect.prepareStatement(sql);
			ptst.setString(1, admin.getName());
			ptst.setString(2, admin.getSenha());
			ptst.setString(3, admin.getEmail());
			ptst.setInt(4, admin.getId());
			ptst.executeUpdate();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}