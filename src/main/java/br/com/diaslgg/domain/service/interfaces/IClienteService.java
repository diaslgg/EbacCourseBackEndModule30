package br.com.diaslgg.domain.service.interfaces;

import br.com.diaslgg.domain.entity.Cliente;
import br.com.diaslgg.domain.exceptions.DAOException;

public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf) throws DAOException;

}
