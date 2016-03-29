package classetestes;

import java.text.ParseException;

import classenegocio.Produto;
import transferobject.ProdutoTO;

public class ProdutoTeste {

	public static void main(String[] args) throws ParseException {
		//Produto produto = new Produto("SMINORF", 1.0 ,1.0, 800);
		Produto produto = new Produto();
		

		produto.carregar();
			
		//produto.setDescricao("SWmiNorf");
	    //produto.setValor_compra(10.5);
		//produto.setValor_venda(11.95);
		//produto.setQuantidade_estoque(9600);
		//produto.criar();
		//Venda v = new Venda();
		//v.criar();
		
		System.out.println(produto.getId());
		
		
		//Produto produto = new Produto();
	
			
		
		//VendaItem vi = new VendaItem(v, produto, 500);
		//vi.criar();
		//produto.carregar();
		//System.out.println(produto);
		//produto.setId(10);
		//produto.setQuantidade_estoque(5);
		//produto.atualizar();
		//vi.carregar();
		//System.out.println(vi);	
		//produto.excluir();
		//produto.carregar();
		//System.out.println(produto);	
	}

}
