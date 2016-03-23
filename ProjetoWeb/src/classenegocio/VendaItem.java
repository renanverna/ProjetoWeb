package classenegocio;

import dataacessobject.VendaItemDAO;
import transferobject.VendaItemTO;

public class VendaItem {
	
	private Venda venda;
	private Produto idproduto;
	private int quantidade;
	
	public VendaItem(){
	this.venda = new Venda();
	this.idproduto = new Produto();
	this.quantidade = 0;		
	}
	
	public VendaItem(Venda venda, Produto produto, int quantidade){
		this.venda = venda;
		this.idproduto = produto;
		this.quantidade = quantidade;
	}

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
		
	
	public void criar(){
		VendaItemDAO dao = new VendaItemDAO();
		VendaItemTO to = new VendaItemTO();
		to.setVenda(venda);
		to.setIdproduto(idproduto);
		to.setQuantidade(quantidade);
		dao.incluir(to);
	}	
	
	
	public String toString() {
		return "VendaItem [id item=" + venda + ", id produto=" + idproduto + ",  quantidade=" + quantidade  + "]";
		}

}
