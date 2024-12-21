package br.com.diaslgg.domain.service;

import br.com.diaslgg.domain.dao.interfaces.IClienteDAO;
import br.com.diaslgg.domain.daotest.ClienteDaoMock;
import br.com.diaslgg.domain.entity.Cliente;
import br.com.diaslgg.domain.exceptions.DAOException;
import br.com.diaslgg.domain.exceptions.TipoChaveNaoEncontradaException;
import br.com.diaslgg.domain.exceptions.TipoElementoNaoConhecidoException;
import br.com.diaslgg.domain.service.interfaces.IClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteServiceTest {

    private IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTest() {
        IClienteDAO dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);
    }

    @BeforeEach
    public void init() {
        cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Luis");
        cliente.setCidade("São Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
        cliente.setSobrenome("Dias");

    }

    @Test
    public void pesquisarCliente() throws DAOException {
        Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
        assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException, DAOException, TipoElementoNaoConhecidoException {
        Boolean retorno = clienteService.cadastrar(cliente);

        assertTrue(retorno);
    }

    @Test
    public void excluirCliente() throws DAOException {
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
        cliente.setNome("Luis");
        clienteService.alterar(cliente);

        assertEquals("Luis", cliente.getNome());
    }

}