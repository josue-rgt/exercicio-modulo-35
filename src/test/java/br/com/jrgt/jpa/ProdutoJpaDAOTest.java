package br.com.jrgt.jpa;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.com.jrgt.dao.jpa.IProdutoJpaDAO;
import br.com.jrgt.dao.jpa.ProdutoJpaDAO;
import br.com.jrgt.domain.jpa.ProdutoJpa;
import br.com.jrgt.exceptions.DAOException;
import br.com.jrgt.exceptions.MaisDeUmRegistroException;
import br.com.jrgt.exceptions.TableException;
import br.com.jrgt.exceptions.TipoChaveNaoEncontradaException;

public class ProdutoJpaDAOTest {
	
	private IProdutoJpaDAO produtoDAO;

	public ProdutoJpaDAOTest() {
		this.produtoDAO = new ProdutoJpaDAO();
	}
	
	@After
	public void end() throws DAOException {
		Collection<ProdutoJpa> list = produtoDAO.buscarTodos();
		list.forEach(prod -> {
			try {
				produtoDAO.excluir(prod);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	@Test
	public void pesquisar() throws MaisDeUmRegistroException, TableException, DAOException, TipoChaveNaoEncontradaException {
		ProdutoJpa produto = criarProduto("A1");
		Assert.assertNotNull(produto);
		
		ProdutoJpa produtoDB = this.produtoDAO.consultar(produto.getId());
		Assert.assertNotNull(produtoDB);
	}
	
	@Test
	public void salvar() throws TipoChaveNaoEncontradaException, DAOException {
		ProdutoJpa produto = criarProduto("A2");
		Assert.assertNotNull(produto);
	}
	
	@Test
	public void excluir() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
		ProdutoJpa produto = criarProduto("A3");
		Assert.assertNotNull(produto);
		
		this.produtoDAO.excluir(produto);
		
		ProdutoJpa produtoBD = this.produtoDAO.consultar(produto.getId());
		assertNull(produtoBD);
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
		ProdutoJpa produto = criarProduto("A4");
		produto.setNome("Josué Rogério");
		
		produtoDAO.alterar(produto);
		
		ProdutoJpa produtoBD = this.produtoDAO.consultar(produto.getId());
		assertNotNull(produtoBD);
		Assert.assertEquals("Josué Rogério", produtoBD.getNome());
	}
	
	@Test
	public void buscarTodos() throws DAOException, TipoChaveNaoEncontradaException {
		criarProduto("A5");
		criarProduto("A6");
		Collection<ProdutoJpa> list = produtoDAO.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);
		
		for (ProdutoJpa prod : list) {
			this.produtoDAO.excluir(prod);
		}
		
		list = produtoDAO.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 0);
	}
	
	private ProdutoJpa criarProduto(String codigo) throws TipoChaveNaoEncontradaException, DAOException {
		ProdutoJpa produto = new ProdutoJpa();
		produto.setCodigo(codigo);
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(BigDecimal.TEN);
		produtoDAO.cadastrar(produto);
		return produto;
	}
}
