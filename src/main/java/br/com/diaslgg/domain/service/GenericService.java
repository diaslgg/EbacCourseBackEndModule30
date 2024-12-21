package br.com.diaslgg.domain.service;

import br.com.diaslgg.domain.dao.generic.interfaces.IGenericDAO;
import br.com.diaslgg.domain.dao.interfaces.Persistente;
import br.com.diaslgg.domain.exceptions.*;
import br.com.diaslgg.domain.service.interfaces.IGenericService;

import java.io.Serializable;
import java.util.Collection;

public abstract class GenericService<T extends Persistente, E extends Serializable>
	implements IGenericService<T, E> {
	
	protected IGenericDAO<T,E> dao;
	
	public GenericService(IGenericDAO<T,E> dao) {
		this.dao = dao;
	}

	@Override
	public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException, TipoElementoNaoConhecidoException {
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
	public T consultar(E valor) throws DAOException {
		try {
			return this.dao.consultar(valor);
		} catch (MaisDeUmRegistroException | TableException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Collection<T> buscarTodos() throws DAOException {
		return this.dao.buscarTodos();
	}

}
