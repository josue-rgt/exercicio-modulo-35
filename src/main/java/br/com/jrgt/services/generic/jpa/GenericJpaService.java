package br.com.jrgt.services.generic.jpa;

import java.io.Serializable;
import java.util.Collection;

import br.com.jrgt.dao.Persistente;
import br.com.jrgt.dao.generic.IGenericDAO;
import br.com.jrgt.exceptions.DAOException;
import br.com.jrgt.exceptions.MaisDeUmRegistroException;
import br.com.jrgt.exceptions.TableException;
import br.com.jrgt.exceptions.TipoChaveNaoEncontradaException;

public abstract class GenericJpaService<T extends Persistente, E extends Serializable> 
	implements IGenericJpaService<T, E> {
	
	protected IGenericDAO<T,E> dao;
	
	public GenericJpaService(IGenericDAO<T,E> dao) {
		this.dao = dao;
	}

	@Override
	public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
		return this.dao.cadastrar(entity);
	}

	@Override
	public void excluir(E valor) throws DAOException {
		this.dao.excluir(valor);
	}

	@Override
	public void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
		this.dao.alterar(entity);
	}

	@Override
	public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException {
		return this.dao.consultar(valor);
	}

	@Override
	public Collection<T> buscarTodos() throws DAOException {
		return this.dao.buscarTodos();
	}
}
