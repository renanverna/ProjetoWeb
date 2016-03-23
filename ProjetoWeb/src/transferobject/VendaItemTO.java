package transferobject;

import classenegocio.Produto;
import classenegocio.Venda;

public class VendaItemTO {
	
	private Venda venda;
	private Produto idproduto;
	private int quantidade;
	
	
	
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getIdproduto() {
		return idproduto;
	}
	public void setIdproduto(Produto idproduto) {
		this.idproduto = idproduto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	
	
	

}
