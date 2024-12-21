package br.com.diaslgg.domain.dao.interfaces;

import br.com.diaslgg.domain.dao.generic.interfaces.IGenericDAO;
import br.com.diaslgg.domain.entity.Venda;
import br.com.diaslgg.domain.exceptions.DAOException;
import br.com.diaslgg.domain.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

    void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}