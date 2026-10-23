package br.com.jrgt;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.jrgt.dao.ClienteDaoMock;
import br.com.jrgt.dao.IClienteDAO;
import br.com.jrgt.domain.Cliente;
import br.com.jrgt.exceptions.DAOException;
import br.com.jrgt.exceptions.TipoChaveNaoEncontradaException;
import br.com.jrgt.services.ClienteService;
import br.com.jrgt.services.IClienteService;

public class ClienteServiceTest {
	
	private IClienteService clienteService;
	
	private Cliente cliente;
	
	public ClienteServiceTest() {
		IClienteDAO dao = new ClienteDaoMock();
		clienteService = new ClienteService(dao);
	}
	
	@Before
	public void init() {
		cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Josué");
		cliente.setCidade("Barão de Antonina");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		
	}
	
	@Test
	public void pesquisarCliente() throws DAOException {
		Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = clienteService.cadastrar(cliente);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() throws DAOException {
		clienteService.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		cliente.setNome("Josué Rogério");
		clienteService.alterar(cliente);
		
		Assert.assertEquals("Josué Rogério", cliente.getNome());
	}
}
