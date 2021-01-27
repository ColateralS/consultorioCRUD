package consultorioCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {

	public static void main(String[] args) {

		String url = "jdbc:oracle:thin:@(description= (retry_count=20)(retry_delay=3)(address=(protocol=tcps)(port=1522)(host=adb.us-ashburn-1.oraclecloud.com))(connect_data=(service_name=hu4f2e1pfne7mhz_consultoriodb_high.adb.oraclecloud.com))(security=(ssl_server_cert_dn=\"CN=adwc.uscom-east-1.oraclecloud.com,OU=Oracle BMCS US,O=Oracle Corporation,L=Redwood City,ST=California,C=US\")))";
		String user = "STEEVENORTEGA";
		String password = "St33v3nfix14!";
		
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			
			String sql = "SELECT * FROM CLIENTE";
			
			Statement statement = connection.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			int count = 0;
			
			while (result.next()) {
				count ++;
				int id = result.getInt(1);
				String cedula = result.getString(2);
				String nombre = result.getString(3);
				String apellido = result.getString(4);
				String celular = result.getString(5);
				String email = result.getString(6);
				System.out.println("Se ha encontrado " + count + " registro/s. Los registros de Clientes son: \n");
				System.out.println("ID de Usuario: " + id + "\nNumero de Cedula: " + cedula + "\nNombre: " + nombre + "\nApellido: " + apellido + "\nCelular: " + celular + "\nCorreo Electrónico: " + email);
			}
			
			connection.close();
			
		}catch (SQLException e) {
			System.out.println("Error!");
			e.printStackTrace();
		}
	}
}
