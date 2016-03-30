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
		String pAcao = null, pId = null, pDescricao = null, pValorCompra = null, pValorVenda = null, pQuantidadeEstoque = null; 
		int idp = -1, QntEstoque = -1;
		double valorCompra = 0.0, valorVenda = 0.0;
		
		 pAcao = request.getParameter("acao");
		 pId = request.getParameter("iid");
		 pDescricao = request.getParameter("idesc");
		 pValorCompra = request.getParameter("ivcompra");
		 pValorVenda = request.getParameter("ivvenda");
		 pQuantidadeEstoque = request.getParameter("iqnt");
						 
		if (pValorCompra != null){
		 valorCompra = Double.parseDouble(pValorCompra);
		}
		if (pValorVenda != null){
		valorVenda = Double.parseDouble(pValorVenda);
		}
		if (pId != null){
		 idp = Integer.parseInt(pId);
		}
		
		if (pQuantidadeEstoque != null){
		QntEstoque = Integer.parseInt(pQuantidadeEstoque);
		}
		
			Produto produto = new Produto(pDescricao, valorCompra, valorVenda, QntEstoque);
		 if("inserir".equals(pAcao)){
			produto.criar();
			}else if("excluir".equals(pAcao)){
				if ((idp >= 0) && (pDescricao == null || pValorCompra == null || pValorVenda == null)) {
					produto.setId(idp);
					produto.excluir();
				}else{
				produto.excluir();}
			}else if("alterar".equals(pAcao)){
				produto.setId(idp);
				produto.setDescricao(pDescricao);
				produto.setValor_compra(valorCompra);
				produto.setValor_venda(valorVenda);
				produto.setQuantidade_estoque(QntEstoque);
				produto.atualizar();				
			}else if("consultar".equals(pAcao)){
				produto.setId(idp);
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
}
