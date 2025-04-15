package br.com.fiap.produtos.view;

public enum Opcao {
    
    CADASTRAR_CATEGORIA(1, "Cadastrar Category"),
    CADASTRAR_PRODUTO(2, "Cadastrar Product"),
    ALTERAR_PRODUTO(3, "Alterar Product"),
    CONSULTAR_PRODUTO_POR_ID(5, "Consultar Product por ID"),
    CONSULTAR_PRODUTO_POR_CATEGORIA(6, "Consultar Product por Category"),
    ENCERRAR_SISTEMA(6, "Encerrar o Sistema");
    
    int id;
    String nome;

    Opcao(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public Opcao setId(int id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Opcao setNome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public String toString() {
        return nome.toUpperCase();
    }
}
