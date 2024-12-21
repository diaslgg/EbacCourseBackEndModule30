package br.com.diaslgg.domain.daotest;

import br.com.diaslgg.domain.dao.interfaces.IProdutoDAO;
import br.com.diaslgg.domain.entity.Produto;
import br.com.diaslgg.domain.exceptions.TipoChaveNaoEncontradaException;
import br.com.diaslgg.domain.exceptions.TipoElementoNaoConhecidoException;

import java.util.Collection;

public class ProdutoDaoMock implements IProdutoDAO {

	@Override
	public Boolean cadastrar(Produto entity) throws TipoElementoNaoConhecidoException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void excluir(String valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Produto entity) throws TipoChaveNaoEncontradaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produto consultar(String valor) {
		Produto produto = new Produto();
		produto.setCodigo(valor);
		return produto;
	}

	@Override
	public Collection<Produto> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
