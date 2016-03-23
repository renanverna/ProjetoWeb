package dataacessobject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import factory.ConnectionFactory;
import transferobject.LoginTO;

public class LoginDAO {
		public LoginTO carregar(int id) {
		LoginTO to = new LoginTO();
		String sqlSelect = "SELECT * FROM login WHERE id = ? ";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1,  id);
				
				try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setId(rs.getInt("id"));
					to.setUsuario(rs.getString("usuario"));
					to.setSenha(rs.getString("senha"));}
				} catch (SQLException e) {
				e.printStackTrace();
				}
				} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
				}
				return to;
		}
}