package br.com.fiap.produtos.view;

import br.com.fiap.produtos.model.Category;
import br.com.fiap.produtos.model.Product;
import br.com.fiap.produtos.repository.ProductCollectionRepository;

import javax.swing.*;
import java.time.LocalDateTime;

public class ProductView {


    public static Product form(Product product) {

        Category category = null;
        do {
            category = CategoryView.select(product.getCategory());
        } while (category == null);


        String name = "";
        do {
            name = JOptionPane.showInputDialog(null,
                    "Informe o nome do produto", product.getName());
        } while (name.equals(""));


        String description = "";
        do {
            description = JOptionPane.showInputDialog(null,
                    "Informe a descrição do produto", product.getDescription());
        } while (description.isEmpty());

        double price = 0;
        do {
            try {
                price = Double.parseDouble(JOptionPane.showInputDialog(null,
                        "Informe o preço do produto", product.getPrice()));
            } catch (Exception e) {
                price = 0;
            }
        } while (price <= 0);


        Product ret = product;

        ret.setCategory(category)
                .setName(name)
                .setDescription(description)
                .setRegistrationDate(LocalDateTime.now())
                .setPrice(price);

        return ret;
    }

    public static void success() {
        JOptionPane.showMessageDialog(null,
                "Produto salvo com sucesso!");
    }

    public static void success(Product product) {
        JOptionPane.showMessageDialog(null,
                "Produto " + product.getName() + " salva com sucesso!");
    }

    public static Product select(Product product) {
        // @formatter:off
        Product ret = (Product) JOptionPane.showInputDialog(
                null, // componente pai. como não temos, será null
                "Selecione um produto",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null, // icone
                ProductCollectionRepository.findAll().toArray(), // número da opção
                product == null ? 1 : product /* função exibida por padrão */);
        return ret;
        // @formatter:on
    }

    public static void update(Product product) {
        form(product);
        success(product);
        show(product);
    }

    public static void show(Product product) {
        System.out.println(product);
        
        String textoFormatado = String.format("PRODUTO: " + product.getName() + System.lineSeparator() 
                + "DESCRIÇÃO: " + product.getDescription() + System.lineSeparator() 
                + "CATEGORIA: " + product.getCategory().toString() + System.lineSeparator() 
                + "PREÇO: %,.2f", product.getPrice());
        
        JOptionPane.showMessageDialog(null, textoFormatado);
    }
    
}
