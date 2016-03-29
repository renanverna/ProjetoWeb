package Controller;

import java.io.IOException;

import classenegocio.Produto;
import transferobject.ProdutoTO;




@WebServlet("/ManterProduto")
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
		double pValorCompra = request.getParameter("valor_compra");
		double pValorVenda = request.getParameter("valor_venda");
		
		Produto produto = new Produto(pDescricao, pValorCompra, pValorVenda, 20);
		
		if(pAcao.equals("Inserir")){
			produto.criar();
		}
		produto.carregar();
		
		ProdutoTO to = new ProdutoTO();
		to.setId(produto.getId());
		to.setDescricao(produto.getDescricao());
		to.setValor_compra(produto.getValor_compra());
		to.setValor_venda(produto.getValor_venda());
		
		RequestDispatcher view = 
				request.getRequestDispatcher("Cliente.jsp");
	view.forward(request, response);
	}

}
