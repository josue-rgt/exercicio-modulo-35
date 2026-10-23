package br.com.jrgt.dao.jpa;

import br.com.jrgt.dao.generic.jpa.GenericJpaDAO;
import br.com.jrgt.domain.jpa.ClienteJpa;

public class ClienteJpaDAO extends GenericJpaDAO<ClienteJpa, Long> implements IClienteJpaDAO {

	public ClienteJpaDAO() {
		super(ClienteJpa.class);
	}
}
