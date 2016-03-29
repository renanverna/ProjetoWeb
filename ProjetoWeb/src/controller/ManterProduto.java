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

@WebServlet("/ManterProduto.do")
public class ManterProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pAcao = request.getParameter("acao");
		String pDescricao = request.getParameter("descricao");
		String pValorCompra = request.getParameter("valor_compra");
		String pValorVenda = request.getParameter("valor_venda");
		
		double valorCompra = Double.parseDouble(pValorCompra);
		double valorVenda = Double.parseDouble(pValorVenda);
		
		Produto produto = new Produto(pDescricao, valorCompra, valorVenda, 20);
		
		if(pAcao.equals("Inserir")){
			produto.criar();
		}
		produto.carregar();
	
		
		ProdutoTO to = new ProdutoTO();
		System.out.println(produto.getId());
		
		to.setId(produto.getId());
		to.setDescricao(produto.getDescricao());
		to.setValor_compra(produto.getValor_compra());
		to.setValor_venda(produto.getValor_venda());
		
		RequestDispatcher view = 
				request.getRequestDispatcher("Produto.jsp");
	view.forward(request, response);
	}

}
