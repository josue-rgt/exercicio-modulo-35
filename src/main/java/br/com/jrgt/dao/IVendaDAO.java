package br.com.jrgt.dao;

import br.com.jrgt.dao.generic.IGenericDAO;
import br.com.jrgt.domain.Venda;
import br.com.jrgt.exceptions.DAOException;
import br.com.jrgt.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
