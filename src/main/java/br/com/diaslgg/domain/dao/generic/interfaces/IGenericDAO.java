package br.com.diaslgg.domain.dao.generic.interfaces;

import br.com.diaslgg.domain.dao.interfaces.Persistente;
import br.com.diaslgg.domain.exceptions.*;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericDAO<T extends Persistente, E extends Serializable>{

    Boolean cadastrar(T entity) throws TipoElementoNaoConhecidoException, DAOException;

    void excluir(E valor) throws DAOException;

    void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException;

    Collection<T> buscarTodos() throws DAOException;

}
