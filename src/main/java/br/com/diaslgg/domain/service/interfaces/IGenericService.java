package br.com.diaslgg.domain.service.interfaces;

import br.com.diaslgg.domain.dao.interfaces.Persistente;
import br.com.diaslgg.domain.exceptions.DAOException;
import br.com.diaslgg.domain.exceptions.TipoChaveNaoEncontradaException;
import br.com.diaslgg.domain.exceptions.TipoElementoNaoConhecidoException;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericService <T extends Persistente, E extends Serializable> {
	
    Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException, TipoElementoNaoConhecidoException;

    void excluir(E valor) throws DAOException;

    void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    T consultar(E valor) throws DAOException;

    Collection<T> buscarTodos() throws DAOException;

}
