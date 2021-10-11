package model.vo;

import java.util.InputMismatchException;

public class ClienteVO {
	private Integer id;
	private String name;
	private String endereco;
	private String cpf;
	
	
	// ------------------- ID do cliente ----------------------------
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		if(id == null) {
			
		}else {
			this.id = id;
		}
		
	}
	//----------------------Nome do cliente---------------------------------
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name == null || name.isBlank()) {
			
		}else {
			this.name = name;
		}
		
	}
	//-----------------------Endereço do cliente--------------------------------
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		if(endereco == null || endereco.isBlank()) {
			
		}else {
			this.endereco = endereco;
		}
		
	}
	//-----------------------CPF do cliente--------------------------------
	public String getCPF() {
		return cpf;
	}
	public void setCPF(String cpf) {
		 if(cpf == null || cpf.isBlank()) {
			 
		 }else {
			 //Caso o numero de cpf tenha números iguais é considerado erro
			 if (cpf.equals("00000000000") ||
			            cpf.equals("11111111111") ||
			            cpf.equals("22222222222") || cpf.equals("33333333333") ||
			            cpf.equals("44444444444") || cpf.equals("55555555555") ||
			            cpf.equals("66666666666") || cpf.equals("77777777777") ||
			            cpf.equals("88888888888") || cpf.equals("99999999999") ||
			            (cpf.length() != 11)) {
				 
				 System.out.println("CPF inválido");
			 }else {
				 char dig10, dig11;
			        int sm, i, r, num, peso;

			        try {
			        // ------------ Calculo do 1o. Digito Verificador -----------------
			            sm = 0;
			            peso = 10;
			            for (i=0; i<9; i++) {
			            	// converte o i-esimo caractere do CPF em um numero:
			            	// por exemplo, transforma o caractere '0' no inteiro 0
			            	// (48 eh a posicao de '0' na tabela ASCII)
			            	
			            num = (int)(cpf.charAt(i) - 48);
			            sm = sm + (num * peso);
			            peso = peso - 1;
			            }

			            r = 11 - (sm % 11);
			            if ((r == 10) || (r == 11))
			                dig10 = '0';
			            else dig10 = (char)(r + 48);

			        // ------------- Calculo do 2o. Digito Verificador ------------------
			            sm = 0;
			            peso = 11;
			            for(i=0; i<10; i++) {
			            num = (int)(cpf.charAt(i) - 48);
			            sm = sm + (num * peso);
			            peso = peso - 1;
			            }

			            r = 11 - (sm % 11);
			            if ((r == 10) || (r == 11))
			                 dig11 = '0';
			            else dig11 = (char)(r + 48);

			        // Verifica se os digitos informados estão de acordo.
			            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
			            			this.cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." +
						            cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
			            			System.out.println("tudo ok");
			            } else {
			            	System.out.println("Digitos inválidos");
			            }
			                } catch (InputMismatchException erro) {
			                System.out.println(erro);
			            }

			 }
			 
			 
		 }

		        
				 
			 
	}
}
	
	

