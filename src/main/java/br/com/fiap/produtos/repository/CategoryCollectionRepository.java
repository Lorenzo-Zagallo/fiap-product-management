package br.com.fiap.produtos.repository;

import br.com.fiap.produtos.model.Category;

import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class CategoryCollectionRepository {
    
    private static final List<Category> CATEGORIES;
    
    static {
        
        CATEGORIES = new Vector<>();

        Category electronics = new Category(1L, "Electronics");
        Category smartphones = new Category(2L, "Smartphones");
        Category books = new Category(3L, "Books");
        
        CATEGORIES.add(electronics);
        CATEGORIES.add(smartphones);
        CATEGORIES.add(books);
        
    }
    
    public static List<Category> findAll() {
        return CATEGORIES;
    }
    
    public static Category findById(Long id) {
        return CATEGORIES.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    public static List<Category> findByName(String nome) {
        return CATEGORIES.stream()
                .filter(c -> c.getName().equalsIgnoreCase(nome))
                .collect(Collectors.toList());
    }
    
    public static Category save(Category category) {
        if (!CATEGORIES.contains(category)) {
            category.setId((long) CATEGORIES.size() + 1);
            CATEGORIES.add(category);
            return category;
        } else {
            JOptionPane.showMessageDialog(null,
                    "The informed category already exists.");
            return null;
        }
    }
}
