package br.com.jrgt;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.jrgt.dao.IProdutoDAO;
import br.com.jrgt.dao.ProdutoDaoMock;
import br.com.jrgt.domain.Produto;
import br.com.jrgt.exceptions.DAOException;
import br.com.jrgt.exceptions.TipoChaveNaoEncontradaException;
import br.com.jrgt.services.IProdutoService;
import br.com.jrgt.services.ProdutoService;

public class ProdutoServiceTest {

	private IProdutoService produtoService;
	
	private Produto produto;
	
	public ProdutoServiceTest() {
		IProdutoDAO dao = new ProdutoDaoMock();
		produtoService = new ProdutoService(dao);
	}
	
	@Before
	public void init() {
		produto = new Produto();
		produto.setCodigo("A1");
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(BigDecimal.TEN);
	}
	
	@Test
	public void pesquisar() throws DAOException {
		Produto produtor = this.produtoService.consultar(produto.getCodigo());
		Assert.assertNotNull(produtor);
	}
	
	@Test
	public void salvar() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = produtoService.cadastrar(produto);
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluir() throws DAOException {
		produtoService.excluir(produto.getCodigo());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		produto.setNome("Josué Rogério");
		produtoService.alterar(produto);
		
		Assert.assertEquals("Josué Rogério", produto.getNome());
	}
}
