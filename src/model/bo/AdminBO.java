package model.bo;


import java.util.List;

import model.dao.AdminDAO;
import model.vo.AdminVO;

public class AdminBO<VO extends AdminVO> {
	AdminDAO<AdminVO> admin = new AdminDAO<AdminVO>();
	
	public boolean cadastrar(VO admin) throws Exception{
        try {
        	
            if(!this.admin.findByEmail(admin).isEmpty() || !this.admin.findByName(admin).isEmpty()) {
                throw new Exception("Ja existe um administrador com esse nome ou email");
            }else {
            	this.admin.inserir(admin); 
            	return true;
            }
            	
            
        } catch(Exception err) {
            //Handle exception.
        	System.out.println(err.getMessage());
            return false;
        }
    }
	
	public boolean login(VO admin){
		try {
			AdminBO<VO> adminFind = new AdminBO<VO>();
			List<AdminVO> findAdm = this.admin.findByName(admin);
			if(!findAdm.isEmpty()){
				if( admin.getSenha().equals(adminFind.findByPass(admin).getSenha())) {
					return true;
				}
			}else {
				return false;
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public void editar(VO admin) throws Exception {
		try {
			this.admin.editarSenha(admin);
			System.out.println("Administrador editado");
		}catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public List<AdminVO> findByName(VO admin) throws Exception {
		
		return this.admin.findByName(admin);
	}
	public List<AdminVO> findByEmail(VO admin) throws Exception {
		
		return this.admin.findByEmail(admin);
	}
	
	public AdminVO findByPass(VO admin) {
		
            AdminVO findedUser = new AdminVO();
            
            List<AdminVO> findAdmin = this.admin.findByName(admin);
            
            findedUser = findAdmin.get(0);
            
            if(findedUser == null) {
            	return null;
            }else {
            	return findedUser;
            }
     
	}
	
	public void remover(VO admin) throws Exception {
		try {
			this.admin.remover(admin);
			System.out.println("Administrador removido");
		}catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
		
	}
	
	public void listar() throws Exception {
		try {
			List<AdminVO> clientes = this.admin.listar();
			
			for(AdminVO clientesShow : clientes) {
				System.out.println(clientesShow.getId());
				System.out.println(clientesShow.getName());
				System.out.println(clientesShow.getEmail());
				
			}
		}catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	
	
	
	
	
}
