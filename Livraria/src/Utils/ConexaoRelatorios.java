package Utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoRelatorios {
	public static Connection getConnection(){
		//conectando ao servidor MySQL
		  try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/trabalho_prime_faces","root","00teste");
		  }catch (Exception e) {
			   e.printStackTrace();
		}
		return null;
	}
}
