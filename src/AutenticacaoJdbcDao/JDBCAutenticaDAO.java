package AutenticacaoJdbcDao;

import java.sql.Connection;
//import com.mysql.jdbc.Connection;
import java.sql.ResultSet;

import ArmzanaDadosUsuario.ArmaDadosUsuario;

public class JDBCAutenticaDAO {
	private Connection conexao;
	public JDBCAutenticaDAO(Connection conexao) {
		//TODO Auto-generated constructor stub
		this.conexao = conexao;
	}
	
	public boolean consultar (ArmaDadosUsuario dadosautentica) {
		try {
			String comando = "SELECT * FROM adm_usuario WHERE emailUsuario ='"+dadosautentica.getUsuario()+"' and senhaUsuario = '"+dadosautentica.getSenha()+"'";
		
		java.sql.Statement stmt = conexao.createStatement();
		ResultSet rs = stmt.executeQuery(comando);
		System.out.println(comando);
		if(rs.next()) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
}
