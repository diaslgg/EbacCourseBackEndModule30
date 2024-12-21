package br.com.diaslgg.domain.dao;

import br.com.diaslgg.domain.dao.interfaces.IProdutoDAO;
import br.com.diaslgg.domain.entity.Produto;
import br.com.diaslgg.domain.exceptions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoDAOTest {

    private IProdutoDAO produtoDao;

    public ProdutoDAOTest() {
        produtoDao = new ProdutoDAO();
    }

    @AfterEach
    public void end() throws DAOException {
        Collection<Produto> list = produtoDao.buscarTodos();
        list.forEach(prod -> {
            try {
                produtoDao.excluir(prod.getCodigo());
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    private Produto criarProduto(String codigo) throws TipoChaveNaoEncontradaException, DAOException, TipoElementoNaoConhecidoException {
        Produto produto = new Produto();
        produto.setCodigo(codigo);
        produto.setDescricao("Produto 1");
        produto.setNome("Produto 1");
        produto.setValor(BigDecimal.TEN);
        produto.setEstoque(true);
        produtoDao.cadastrar(produto);
        return produto;
    }

    @Test
    public void pesquisar() throws MaisDeUmRegistroException, TableException, DAOException, TipoChaveNaoEncontradaException, TipoElementoNaoConhecidoException {
        Produto produto = criarProduto("A1");
        assertNotNull(produto);
        Produto produtoDB = this.produtoDao.consultar(produto.getCodigo());
        assertNotNull(produtoDB);
    }

    @Test
    public void salvar() throws TipoChaveNaoEncontradaException, DAOException, TipoElementoNaoConhecidoException {
        Produto produto = criarProduto("A2");
        assertNotNull(produto);
    }

    @Test
    public void excluir() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, TipoElementoNaoConhecidoException {
        Produto produto = criarProduto("A3");
        assertNotNull(produto);
        produtoDao.excluir(produto.getCodigo());
        Produto produtoBD = this.produtoDao.consultar(produto.getCodigo());
        assertNull(produtoBD);
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException, TipoElementoNaoConhecidoException {
        Produto produto = criarProduto("A4");
        produto.setNome("Luis");
        produtoDao.alterar(produto);
        Produto produtoBD = this.produtoDao.consultar(produto.getCodigo());
        assertNotNull(produtoBD);
        assertEquals("Luis", produtoBD.getNome());

        produtoDao.excluir(produto.getCodigo());
        Produto produtoBD1 = this.produtoDao.consultar(produto.getCodigo());
        assertNull(produtoBD1);
    }

    @Test
    public void buscarTodos() throws DAOException, TipoChaveNaoEncontradaException, TipoElementoNaoConhecidoException {
        criarProduto("A5");
        criarProduto("A6");
        Collection<Produto> list = produtoDao.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 2);

        for (Produto prod : list) {
            produtoDao.excluir(prod.getCodigo());
        }

        list = produtoDao.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 0);

    }

}