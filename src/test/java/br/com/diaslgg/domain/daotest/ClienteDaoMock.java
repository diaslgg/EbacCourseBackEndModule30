package br.com.diaslgg.domain.daotest;

import br.com.diaslgg.domain.dao.interfaces.IClienteDAO;
import br.com.diaslgg.domain.entity.Cliente;
import br.com.diaslgg.domain.exceptions.TipoChaveNaoEncontradaException;
import br.com.diaslgg.domain.exceptions.TipoElementoNaoConhecidoException;

import java.util.Collection;

public class ClienteDaoMock implements IClienteDAO {

	@Override
	public Boolean cadastrar(Cliente entity) throws TipoElementoNaoConhecidoException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void excluir(Long valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Cliente entity) throws TipoChaveNaoEncontradaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente consultar(Long valor) {
		Cliente cliente = new Cliente();
		cliente.setCpf(valor);
		return cliente;
	}

	@Override
	public Collection<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}


}
