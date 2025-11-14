# Nano FIAP: Gestão de Produtos

Projeto de aplicação console-based (utilizando Swing para diálogos) para gerenciamento de produtos e categorias. Este sistema foi desenvolvido como projeto de conclusão para o curso de Java da FIAP.

A aplicação permite realizar operações básicas de CRUD (Criar, Ler, Atualizar) para produtos, associando-os a categorias, com todos os dados persistidos em memória durante a execução.

## 🚀 Funcionalidades Principais

  * ✅ **Cadastro de Categorias**: Adicionar novas categorias de produtos.
  * 📦 **Cadastro de Produtos**: Adicionar novos produtos e associá-los a uma categoria existente.
  * ✏️ **Alteração de Produtos**: Modificar dados de um produto já cadastrado.
  * 🔎 **Consulta de Produtos por ID**: Buscar um produto específico pelo seu identificador.
  * 🗂️ **Consulta de Produtos por Categoria**: Listar todos os produtos pertencentes a uma categoria selecionada.
  * 🚪 **Encerrar**: Sair da aplicação.

## 💻 Tecnologias Utilizadas

  * **Java**: O projeto utiliza Java (configurado no `pom.xml` para compilar na versão 14).
  * **Maven**: Usado para o gerenciamento de dependências e build do projeto.
  * **Java Swing (`JOptionPane`)**: A interface com o usuário é totalmente baseada em caixas de diálogo do Swing, sem a necessidade de uma GUI complexa.

## 📁 Estrutura do Projeto

O projeto segue uma arquitetura simples, separando as responsabilidades em pacotes:

  * `br.com.fiap.produtos`
      * `Main.java`: Ponto de entrada da aplicação, contém o loop principal do menu.
  * `br.com.fiap.produtos.model`
      * `Product.java`: Entidade (POJO) que representa um produto.
      * `Category.java`: Entidade (POJO) que representa uma categoria.
  * `br.com.fiap.produtos.repository`
      * `ProductCollectionRepository.java`: Simula a camada de persistência para Produtos, armazenando os dados em um `Vector` estático.
      * `CategoryCollectionRepository.java`: Simula a camada de persistência para Categorias, armazenando os dados em um `Vector` estático com dados iniciais.
  * `br.com.fiap.produtos.view`
      * `Opcao.java` / `OpcaoView.java`: Controlam a exibição e seleção das opções do menu principal.
      * `ProductView.java`: Responsável por exibir formulários (`JOptionPane`) para entrada de dados do produto.
      * `CategoryView.java`: Responsável por exibir formulários (`JOptionPane`) para entrada de dados da categoria.

## ▶️ Como Executar o Projeto

### Pré-requisitos

  * Java JDK (versão 14 ou superior).
  * Apache Maven.

### Execução

1.  **Abra o projeto em sua IDE favorita** (IntelliJ, Eclipse, VS Code com Java) que suporte projetos Maven.
2.  **Sincronize as dependências do Maven.**
3.  **Localize e execute o método `main`** na classe `br.com.fiap.produtos.Main.java`.

**Alternativamente, via linha de comando:**

1.  Navegue até a pasta raiz do projeto (onde o `pom.xml` está localizado).
2.  Compile o projeto:
    ```bash
    mvn clean compile
    ```
3.  Execute o projeto:
    ```bash
    mvn exec:java -Dexec.mainClass="br.com.fiap.produtos.Main"
    ```

-----
