package br.com.jrgt.services;

import br.com.jrgt.domain.Cliente;
import br.com.jrgt.exceptions.DAOException;
import br.com.jrgt.exceptions.TipoChaveNaoEncontradaException;
import br.com.jrgt.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

//	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
	Cliente buscarPorCPF(Long cpf) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
