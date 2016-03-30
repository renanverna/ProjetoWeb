package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classenegocio.Produto;
import transferobject.ProdutoTO;

@WebServlet("/ManterController.do")
public class ManterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pAcao = request.getParameter("acao");
		String pId = request.getParameter("iid");
		String pDescricao = request.getParameter("idesc");
		String pValorCompra = request.getParameter("ivcompra");
		String pValorVenda = request.getParameter("ivvenda");
		String pQuantidadeEstoque = request.getParameter("iqnt");

		int id = Integer.parseInt(pId);
	
		double valorCompra = Double.parseDouble(pValorCompra);
		double valorVenda = Double.parseDouble(pValorVenda);
		int QntEstoque = Integer.parseInt(pQuantidadeEstoque);
		
		Produto produto = new Produto(pDescricao, valorCompra, valorVenda, QntEstoque);
		
		if("Inserir".equals(pAcao)){
			produto.criar();
			
			
			produto.carregar();
			
			ProdutoTO to = new ProdutoTO();
			
			to.setId(produto.getId());
			to.setDescricao(produto.getDescricao());
			to.setValor_compra(produto.getValor_compra());
			to.setValor_venda(produto.getValor_venda());
			to.setQuantidade_estoque(produto.getQuantidade_estoque());
			
			request.setAttribute("Produto", to);
			
			RequestDispatcher view = 
					request.getRequestDispatcher("Produto.jsp");
		view.forward(request, response);
			
			
		}else if("Alterar".equals(pAcao)){
			produto.setId(id);
			produto.setDescricao(pDescricao);
			produto.setValor_compra(valorCompra);
			produto.setValor_venda(valorVenda);
			produto.setQuantidade_estoque(QntEstoque);
			
			produto.atualizar();
		
			request.setAttribute("Produto", produto);
			
			RequestDispatcher view = 
					request.getRequestDispatcher("Produto.jsp");
		view.forward(request, response);
			
		}else if("Excluir".equals(pAcao)){
				
			produto.setId(id);
			produto.excluir();	
			
		}else if("Consultar".equals(pAcao)){
		produto.carregar();
		
		ProdutoTO to = new ProdutoTO();
		
		to.setId(produto.getId());
		to.setDescricao(produto.getDescricao());
		to.setValor_compra(produto.getValor_compra());
		to.setValor_venda(produto.getValor_venda());
		to.setQuantidade_estoque(produto.getQuantidade_estoque());
		
		request.setAttribute("Produto", to);
		
		RequestDispatcher view = 
				request.getRequestDispatcher("Produto.jsp");
	view.forward(request, response);
		}
		
		produto.carregar();
ProdutoTO to = new ProdutoTO();
		
		to.setId(produto.getId());
		to.setDescricao(produto.getDescricao());
		to.setValor_compra(produto.getValor_compra());
		to.setValor_venda(produto.getValor_venda());
		to.setQuantidade_estoque(produto.getQuantidade_estoque());
		
		request.setAttribute("Produto", to);
		
		RequestDispatcher view = 
				request.getRequestDispatcher("Produto.jsp");
	view.forward(request, response);
		
		
		
		
		
	}
}
