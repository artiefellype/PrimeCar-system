package model.bo;


import java.util.List;

import model.dao.AdminDAO;
import model.vo.AdminVO;
import model.vo.ClienteVO;

public class AdminBO<VO extends AdminVO> {
	AdminDAO<AdminVO> admin = new AdminDAO<AdminVO>();
	
	public boolean cadastrar(VO admin) throws Exception{
        try {
        	
            if(!this.admin.findByEmail(admin).isEmpty() ) {
                throw new Exception("Ja existe um administrador com esse email");
            }
            	this.admin.inserir(admin); 
            	return true;
            
        	

            
        } catch(Exception err) {
            //Handle exception.
        	System.out.println(err.getMessage());
            return false;
        }
    }
	
	public void editar(VO admin) throws Exception {
		try {
			this.admin.editarSenha(admin);
			System.out.println("Administrador editado");
		}catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public void findByName(VO admin) throws Exception {
		try {
			this.admin.findByName(admin);
		}catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
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
