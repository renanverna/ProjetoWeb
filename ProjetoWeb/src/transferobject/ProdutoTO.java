package transferobject;

public class ProdutoTO {
	private int id;
	private String descricao;
	private double valor_compra;
	private double valor_venda;
	private int quantidade_estoque;
		
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


}
