package br.com.jrgt.dao.jpa;

import br.com.jrgt.dao.generic.jpa.GenericJpaDAO;
import br.com.jrgt.domain.jpa.ProdutoJpa;

public class ProdutoJpaDAO extends GenericJpaDAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

	public ProdutoJpaDAO() {
		super(ProdutoJpa.class);
	}
}