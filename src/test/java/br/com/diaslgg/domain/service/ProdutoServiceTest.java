package br.com.diaslgg.domain.service;

import br.com.diaslgg.domain.dao.interfaces.IProdutoDAO;
import br.com.diaslgg.domain.daotest.ProdutoDaoMock;
import br.com.diaslgg.domain.entity.Produto;
import br.com.diaslgg.domain.exceptions.DAOException;
import br.com.diaslgg.domain.exceptions.TipoChaveNaoEncontradaException;
import br.com.diaslgg.domain.exceptions.TipoElementoNaoConhecidoException;
import br.com.diaslgg.domain.service.interfaces.IProdutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoServiceTest {

    private IProdutoService produtoService;

    private Produto produto;

    public ProdutoServiceTest() {
        IProdutoDAO dao = new ProdutoDaoMock();
        produtoService = new ProdutoService(dao);
    }

    @BeforeEach
    public void init() {
        produto = new Produto();
        produto.setCodigo("A1");
        produto.setDescricao("Produto 1");
        produto.setNome("Produto 1");
        produto.setValor(BigDecimal.TEN);
        produto.setEstoque(true);
    }

    @Test
    public void pesquisar() throws DAOException {
        Produto produtor = this.produtoService.consultar(produto.getCodigo());
        assertNotNull(produtor);
    }

    @Test
    public void salvar() throws TipoChaveNaoEncontradaException, DAOException, TipoElementoNaoConhecidoException {
        Boolean retorno = produtoService.cadastrar(produto);
        assertTrue(retorno);
    }

    @Test
    public void excluir() throws DAOException {
        produtoService.excluir(produto.getCodigo());
    }

}