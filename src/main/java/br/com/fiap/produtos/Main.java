package br.com.fiap.produtos;

import br.com.fiap.produtos.model.Category;
import br.com.fiap.produtos.model.Product;
import br.com.fiap.produtos.repository.CategoryCollectionRepository;
import br.com.fiap.produtos.repository.ProductCollectionRepository;
import br.com.fiap.produtos.view.CategoryView;
import br.com.fiap.produtos.view.Opcao;
import br.com.fiap.produtos.view.OpcaoView;
import br.com.fiap.produtos.view.ProductView;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {
    
    public static void main(String[] args) {
        
       /* 
        Category category = new Category();
        category.setName("Computing");
        // category.setId(1L).setName("Electronics");
        
        Category savedCategory = CategoryCollectionRepository.save(category);

        System.out.println("Category: " + savedCategory);
        
        Product product = new Product();
        product.setId(1L)
                .setName("Kindle")
                .setDescription("e-reader")
                .setCategory(CategoryCollectionRepository.findByName("electronics").get(0))
                .setRegistrationDate(LocalDateTime.now())
                .setPrice(800.0);
        
        Product product1 = ProductCollectionRepository.save(product);

        List<Product> product2 = ProductCollectionRepository.findAll();

        assert product1 != null;
        System.out.println("ID: " + product1.getId() + " Product name: " + product1.getName());

        System.out.println(product2);
        */

        Opcao opcao = null;

        do {
            opcao = OpcaoView.select();
            switch (opcao) {
                case CADASTRAR_CATEGORIA -> cadastrarCategoria();
                case CADASTRAR_PRODUTO -> cadastrarProduto();
                case ALTERAR_PRODUTO -> alterarProduto();
                case CONSULTAR_PRODUTO_POR_ID -> consultarProdutoPorID();
                case CONSULTAR_PRODUTO_POR_CATEGORIA -> consultarProdutoPorCategoria();
                case ENCERRAR_SISTEMA -> encerrarSistema();
            }

        } while (opcao != Opcao.ENCERRAR_SISTEMA);

    }

    private static void encerrarSistema() {
        System.exit(0);
    }

    private static void cadastrarCategoria() {
        CategoryView view = new CategoryView();
        Category category = view.form(new Category());
        CategoryCollectionRepository.save(category);
        view.success(category);
    }

    private static void cadastrarProduto() {
        ProductView view = new ProductView();
        Product product = view.form(new Product());
        ProductCollectionRepository.save(product);
        view.success(product);
    }

    private static void alterarProduto() {
        Product product = ProductView.select(null);
        ProductView.update(product);
    }
    
    private static void consultarProdutoPorID() {
        
        Long id = -1L;
        
        do {
            try {
                String input = JOptionPane.showInputDialog("Digite o ID do produto: ");
                if (input == null) return; // usuario cancelou
                
                id = Long.valueOf(input);
                Product product = ProductCollectionRepository.findById(id);
                
                if (product == null) {
                    JOptionPane.showMessageDialog(null,
                            "Nenhum produto encontrado com o ID: " + id);
                } else {
                    ProductView.show(product);
                    System.out.println(product); // exibe no console também
                }
                
                break; // sai do loop
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "ID inválido. Por favor, insira um número válido.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Erro ao buscar o produto: " + e.getMessage());
            }
            
        } while (true);
    }

    private static void consultarProdutoPorCategoria() {
        Category category = CategoryView.select(null);
        
        List<Product> products = ProductCollectionRepository.findByCategory(category);
        
        if (products.isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                    "Não encontramos produtos com a categoria: " + category.getName());
        } else {
            products.forEach(ProductView::show); // esse :: infere que a cada volta desse 
            // laço eu vou ter um produto, e depois vai mostrando o produto numa caixa 
            // de mensagem para o usuário
            products.forEach(System.out::println); // chama o método toString a cada volta do laço de repetição
        }
    }
}
