package model.vo;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.regex.Pattern;

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
	//-----------------------Endere�o do cliente--------------------------------
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
			 
			 //this.cpf = cpf;
			 String[] Mesclado = cpf.split(Pattern.quote("."));
			String cpfMesclado =  String.join("", Mesclado);
			Mesclado = cpfMesclado.split("-");
			cpfMesclado = String.join("", Mesclado);
			 //Caso o numero de cpf tenha n�meros iguais � considerado erro
			 if (cpfMesclado.equals("00000000000") ||
			            cpfMesclado.equals("11111111111") ||
			            cpfMesclado.equals("22222222222") || cpfMesclado.equals("33333333333") ||
			            cpfMesclado.equals("44444444444") || cpfMesclado.equals("55555555555") ||
			            cpfMesclado.equals("66666666666") || cpfMesclado.equals("77777777777") ||
			            cpfMesclado.equals("88888888888") || cpfMesclado.equals("99999999999") ||
			            (cpfMesclado.length() != 11)) {
				 System.out.println(cpfMesclado);
				 System.out.println("CPF inv�lido");
			 }else {
				 
				 //this.cpf = cpf;
	
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
			            	
			            num = (int)(cpfMesclado.charAt(i) - 48);
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
			            num = (int)(cpfMesclado.charAt(i) - 48);
			            sm = sm + (num * peso);
			            peso = peso - 1;
			            }

			            r = 11 - (sm % 11);
			            if ((r == 10) || (r == 11))
			                 dig11 = '0';
			            else dig11 = (char)(r + 48);

			        // Verifica se os digitos informados est�o de acordo.
			            if ((dig10 == cpfMesclado.charAt(9)) && (dig11 == cpfMesclado.charAt(10))) {
			            			this.cpf = cpfMesclado.substring(0, 3) + "." + cpfMesclado.substring(3, 6) + "." +
						            cpfMesclado.substring(6, 9) + "-" + cpfMesclado.substring(9, 11);
			            			System.out.println("tudo ok");
			            } else {
			            	System.out.println("Digitos inv�lidos");
			            }
			                } catch (InputMismatchException erro) {
			                System.out.println(erro);
			            }

			 } // fim do segundo if else
			 
			 
		 }
		 
		        
				 
			 
	}
}
	
	

