package dataacessobject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import factory.ConnectionFactory;
import transferobject.ProdutoTO;

public class ProdutoDAO {
	public void incluir(ProdutoTO to) {
		String sqlInsert = "INSERT INTO produtos (descricao, valor_compra, valor_venda, quantidade_estoque) VALUES (?,?,?,?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);) {
			 stm.setString(1, to.getDescricao());
	         stm.setDouble(2, to.getValor_compra());
	         stm.setDouble(3, to.getValor_venda());
	         stm.setInt(4, to.getQuantidade_estoque());
	         stm.execute();
	     
	         ResultSet retorno = stm.getGeneratedKeys();
	         retorno.next();	      
	         to.setId(retorno.getInt(1));
	                  
	   } catch (SQLException e) {
		e.printStackTrace();
	   }	
		}
	
		public void atualizar(ProdutoTO to) {		
		String sqlUpdate = "UPDATE produtos SET descricao = ?, valor_compra = ?, valor_venda = ?, quantidade_estoque = ? WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			 stm.setString(1, to.getDescricao());
	         stm.setDouble(2, to.getValor_compra());
	         stm.setDouble(3, to.getValor_venda());
	         stm.setInt(4, to.getQuantidade_estoque());
	         stm.setInt(5, to.getId());
		stm.execute();
		} catch (Exception e) {
		e.printStackTrace();
		}
		}
		
		
		public void excluir(ProdutoTO to) {
		String sqlDelete = "DELETE FROM produtos WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
		stm.setInt(1, to.getId());
		stm.execute();
		} catch (Exception e) {
		e.printStackTrace();
		}
		}
		
		
		public ProdutoTO carregar(int id) {
			ProdutoTO to = new ProdutoTO();
			String sqlSelect = "SELECT * FROM produtos WHERE produtos.id = ?";
			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
					stm.setInt(1,  id);
					try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						to.setId(rs.getInt("id"));
			            to.setDescricao(rs.getString("descricao"));
			            to.setValor_compra(rs.getDouble("valor_compra"));
	 		            to.setValor_venda(rs.getDouble("valor_venda"));
			            to.setQuantidade_estoque(rs.getInt("quantidade_estoque"));
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
