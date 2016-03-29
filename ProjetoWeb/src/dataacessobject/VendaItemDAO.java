package dataacessobject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import classenegocio.Produto;
import classenegocio.Venda;
import factory.ConnectionFactory;
import transferobject.VendaItemTO;

public class VendaItemDAO {
	
	public void incluir(VendaItemTO to) {
		String sqlInsert = "INSERT INTO venda_itens (idvenda, idproduto, quantidade) VALUES (?,?,?)";
		Produto p = new Produto();
		Venda v = new Venda();
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);) {
				 stm.setInt(1, v.getId());	 
				 stm.setInt(2, p.getId());				 
				 stm.setInt(3, to.getQuantidade());
		         stm.execute();
		     
		                  
		   } catch (SQLException e) {
			e.printStackTrace();
		   }	
			}
	
/*/
	
	public VendaItemTO carregar(int id) {
		VendaItemTO to = new VendaItemTO();
		String sqlSelect = "SELECT * FROM venda_itens WHERE venda_itens.id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, id);
				try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setVenda(rs.getVenda("idvenda"));
		            to.setIdproduto(rs.getIdproduto("idproduto"));
		            to.setQuantidade(rs.getInt("quantidade"));
				}
				} catch (SQLException e) {
				e.printStackTrace();
				}
				} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
				}
				return to;
				}	
	
	
/*/
	
	
	}
	
