import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexao 
{
public static Connection conectar () throws SQLException
{
	try {
		Class.forName ("org.postgresql.Driver");
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432,BDhotelaria/","postgres","123");
	} catch (ClassNotFoundException e) {
		
		throw new SQLException(e.getException());
		
	}
	
	
}


}
