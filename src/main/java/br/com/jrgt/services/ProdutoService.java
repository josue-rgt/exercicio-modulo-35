package br.com.jrgt.services;

import br.com.jrgt.dao.IProdutoDAO;
import br.com.jrgt.domain.Produto;
import br.com.jrgt.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
