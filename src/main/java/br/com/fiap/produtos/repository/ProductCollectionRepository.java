package br.com.fiap.produtos.repository;

import br.com.fiap.produtos.model.Category;
import br.com.fiap.produtos.model.Product;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

public class ProductCollectionRepository {
    
    private static final List<Product> PRODUCTS;
    
    static {
        PRODUCTS = new Vector<>();
        
        Product smartphones = new Product();

        smartphones.setName("Iphone 14 Pro Max")
                .setDescription("Apple smartphone")
                .setCategory(CategoryCollectionRepository.findById(2L))
                .setRegistrationDate(LocalDateTime.now())
                .setPrice(12000.0);
        
        save(smartphones);
    }

    public static List<Product> findAll() {
        return PRODUCTS;
    }

    public static Product save(Product product) {
        if (!PRODUCTS.contains(product)) {
            product.setId((long) PRODUCTS.size() + 1);
            PRODUCTS.add(product);
            return product;
        } else {
            JOptionPane.showMessageDialog(null,
                    "The informed product already exists.");
            return null;
        }
    }
    
    public static Product findById(Long id) {
        return PRODUCTS.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static List<Product> findByCategory(Category category) {
        return PRODUCTS.stream().filter(p -> p.getCategory().equals(category)).toList();
    }
    
}
