package dataacessobject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import factory.ConnectionFactory;
import transferobject.VendaTO;


public class VendaDAO {

	public void incluir(VendaTO to) {
		String sqlInsert = "INSERT INTO venda (id, data, idlogin) VALUES (?,?,?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);) {
			java.sql.Date dataSql = new java.sql.Date(to.getData().getTime());
			 stm.setInt(1, to.getId());
			 stm.setDate(2, dataSql);
			 stm.setInt(3, to.getLogin());
	         stm.execute();
	         
	         
	         ResultSet retorno = stm.getGeneratedKeys();
	         retorno.next();	      
	         to.setId(retorno.getInt(1));
	     
	                  
	   } catch (SQLException e) {
		e.printStackTrace();
	   }	
		}
	
	public VendaTO carregar(int id) {
		VendaTO to = new VendaTO();
		String sqlSelect = "SELECT * FROM venda WHERE venda.id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, id);
				try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setId(rs.getInt("id"));
		            to.setData(rs.getDate("data"));
		            to.setLogin(rs.getInt("idlogin"));
				}
				} catch (SQLException e) {
				e.printStackTrace();
				}
				} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
				}
				return to;
				}	
}
