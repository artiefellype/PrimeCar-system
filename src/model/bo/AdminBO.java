package model.bo;


import model.dao.AdminDAO;
import model.vo.AdminVO;

public class AdminBO {
	AdminDAO<AdminVO> admin = new AdminDAO<AdminVO>();
	
	public boolean cadastrar(AdminVO admin) throws Exception{
        try {
            if(this.admin.findByName(admin) != null) {
                throw new Exception("Ja existe um administrador com esse nome");
            }

            this.admin.inserir(admin);  

            return true;
        } catch(Exception err) {
            //Handle exception.
        	System.out.println(err.getMessage());

            return false;
        }
    }
	
	public void editar(AdminVO admin) throws Exception {
		try {
			this.admin.remover(admin);
			System.out.println("Administrador removido");
		}catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public void findByName(AdminVO admin) throws Exception {
		try {
			this.admin.findByName(admin);
		}catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
		
	}
	
	public void remover(AdminVO admin) throws Exception {
		try {
			this.admin.remover(admin);
		}catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
		
	}
	
	public void listar(AdminVO admin) throws Exception {
		try {
			this.admin.listar();
		}catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	
	
	
	
	
}
