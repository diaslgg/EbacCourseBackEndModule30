package br.com.diaslgg.domain.entity;

import br.com.diaslgg.domain.annotations.ColunaTabela;
import br.com.diaslgg.domain.annotations.Tabela;
import br.com.diaslgg.domain.annotations.TipoChave;
import br.com.diaslgg.domain.dao.interfaces.Persistente;

import java.math.BigDecimal;

@Tabela("TB_PRODUTO")
public class Produto implements Persistente {

    @ColunaTabela(dbName = "id", setJavaName = "setId")
    private Long id;

    @TipoChave("getCodigo")
    @ColunaTabela(dbName = "codigo", setJavaName = "setCodigo")
    private String codigo;

    @ColunaTabela(dbName = "nome", setJavaName = "setNome")
    private String nome;

    @ColunaTabela(dbName = "descricao", setJavaName = "setDescricao")
    private String descricao;

    @ColunaTabela(dbName = "valor", setJavaName = "setValor")
    private BigDecimal valor;

    @ColunaTabela(dbName = "estoque", setJavaName = "setEstoque")
    private Boolean estoque;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Boolean getEstoque() {return estoque;}

    public void setEstoque(Boolean estoque) {this.estoque = estoque;}

    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }

}
