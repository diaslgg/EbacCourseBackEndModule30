package br.com.diaslgg.domain.service;

import br.com.diaslgg.domain.dao.interfaces.IProdutoDAO;
import br.com.diaslgg.domain.entity.Produto;
import br.com.diaslgg.domain.service.interfaces.IProdutoService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
