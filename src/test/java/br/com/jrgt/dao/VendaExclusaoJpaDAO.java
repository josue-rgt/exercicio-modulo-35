package br.com.jrgt.dao;

import br.com.jrgt.dao.generic.jpa.GenericJpaDAO;
import br.com.jrgt.dao.jpa.IVendaJpaDAO;
import br.com.jrgt.domain.jpa.VendaJpa;
import br.com.jrgt.exceptions.DAOException;
import br.com.jrgt.exceptions.TipoChaveNaoEncontradaException;

/**
 * Classe utilizada somente no teste para fazer a exclusão das vendas
 *
 */
public class VendaExclusaoJpaDAO extends GenericJpaDAO<VendaJpa, Long> implements IVendaJpaDAO {

	public VendaExclusaoJpaDAO() {
		super(VendaJpa.class);
	}

	@Override
	public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public VendaJpa consultarComCollection(Long id) {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}
}