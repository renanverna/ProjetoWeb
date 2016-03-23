package classenegocio;

import dataacessobject.ProdutoDAO;
import transferobject.ProdutoTO;

public class Produto {
	
	private int id;
	private String descricao;
	private double valor_compra;
	private double valor_venda;
	private int quantidade_estoque;
		
	
	public Produto(){}
	
	public Produto(String descricao, double valor_compra, double valor_venda, int quantidade_estoque){
		this.descricao = descricao;
		this.valor_compra = valor_compra;
		this.valor_venda = valor_venda;
		this.quantidade_estoque = quantidade_estoque;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor_compra() {
		return valor_compra;
	}
	public void setValor_compra(double valor_compra) {
		this.valor_compra = valor_compra;
	}
	public double getValor_venda() {
		return valor_venda;
	}
	public void setValor_venda(double valor_venda) {
		this.valor_venda = valor_venda;
	}
	public int getQuantidade_estoque() {
		return quantidade_estoque;
	}

	public void setQuantidade_estoque(int quantidade_estoque) {
		this.quantidade_estoque = quantidade_estoque;
	}
	
	public void criar()	{
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = new ProdutoTO();		
		to.setDescricao(descricao);
		to.setValor_compra(valor_compra);
		to.setValor_venda(valor_venda);
		to.setQuantidade_estoque(quantidade_estoque);
		dao.incluir(to);
		this.id = to.getId();	
	}
	
	public void atualizar()	{

		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = new ProdutoTO();		
		to.setDescricao(descricao);
		to.setValor_compra(valor_compra);
		to.setValor_venda(valor_venda);
		to.setQuantidade_estoque(quantidade_estoque);
		to.setId(id);
		dao.atualizar(to);
	}
	
	public void excluir()	{
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = new ProdutoTO();		
		to.setId(id);
		dao.excluir(to);
	}
		
	public void carregar()	{
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = dao.carregar(id);
		descricao = to.getDescricao();
		valor_compra = to.getValor_compra();
		valor_venda = to.getValor_venda();
		quantidade_estoque = to.getQuantidade_estoque();
	}
	
	@Override
	public String toString() {
	return "Produto [id=" + id + ", descricao=" + descricao + ",  Valor compra=" + valor_compra + ", Valor Venda=" + valor_venda +
			", Quantidade estoque=" + quantidade_estoque +  "]";
	}

	

}
