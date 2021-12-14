package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import entity.Categoria;
import entity.Imagem;
import entity.Produto;
import entity.Usuario;
import entity.dao.CategoriaDAO;
import entity.dao.ProdutoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class ProdutoServlet
 */
@MultipartConfig
public class ProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ProdutoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = (String) request.getParameter("nomeInput");
		String descricao = (String) request.getParameter("descInput");
		
		String categoriaId = (String) request.getParameter("selectInput");
		Categoria categoria = CategoriaDAO.procurarCategoria(Long.parseLong(categoriaId));
		
		Integer quantidade = null;
		Double preco = null;
		try {
			quantidade = Integer.parseInt(request.getParameter("quantidadeInput"));
			preco = Double.parseDouble(request.getParameter("preco"));
		} catch (Exception e) {
			e.printStackTrace();		
		}
		
		Part imagemInputPart = request.getPart("imagemInput");
		File file = File.createTempFile("imagem", LocalDateTime.now().toString());
		imagemInputPart.write(file.getPath());
		
		Imagem imagem = new Imagem(
			imagemInputPart.getSubmittedFileName(), 
			imagemInputPart.getContentType(), 
			Files.readAllBytes(file.toPath())
		);
		
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuarioValidado");
		
		Produto produto = new Produto(descricao, nome, quantidade, preco, categoria, imagem, usuario);
		System.out.println(produto);
		
		boolean success;
		try {
			success = ProdutoDAO.cadastrarProduto(produto);
		} catch (Exception e) {
			success = false;
		}
		
		if (success) {
			String msgSuccess = "Produto cadastrado com sucesso";
			response.sendRedirect("index.jsp?success=" + msgSuccess);
		} else {
			String msgError = "Erro ao cadastrar o produto";
			String referer = request.getHeader("Referer");
			response.sendRedirect(referer + "?error=" + msgError);
		}
	}

}
