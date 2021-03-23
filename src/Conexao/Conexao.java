package Conexao;

//import com.mysql.jdbc.Connection;
import java.sql.Connection;

public class Conexao {
	private Connection conexao;
	
	public Connection abrirConexao() {
		try {
			
//			Class.forName("org.gjt.mm.mysql.Driver");
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
//			conexao = (Connection) java.sql.DriverManager.getConnection("jdbc:mysql://localhost/sala_arco_iris", "root", "root");
			
			conexao = java.sql.DriverManager.getConnection("jdbc:mysql://localhost/sala_arco_iris?"
					+"user=root&password=root&useTimezone=true&serverTimezone=UTC");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Não conectou com banco!!!");
		}
		return conexao;
	}
	
	public void fecharConexao() {
		try {
			conexao.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
