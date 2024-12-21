package br.com.diaslgg.domain.service;

import br.com.diaslgg.domain.dao.interfaces.IClienteDAO;
import br.com.diaslgg.domain.entity.Cliente;
import br.com.diaslgg.domain.exceptions.DAOException;
import br.com.diaslgg.domain.exceptions.MaisDeUmRegistroException;
import br.com.diaslgg.domain.exceptions.TableException;
import br.com.diaslgg.domain.service.interfaces.IClienteService;


public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
	
	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
	}

	@Override
	public Cliente buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			e.printStackTrace();
		}
		return null;
	}
}
