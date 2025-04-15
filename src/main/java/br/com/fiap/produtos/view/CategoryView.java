package br.com.fiap.produtos.view;

import br.com.fiap.produtos.model.Category;
import br.com.fiap.produtos.repository.CategoryCollectionRepository;

import javax.swing.*;

public class CategoryView {

    static CategoryCollectionRepository repository;

    public static Category select(Category category) {
        // @formatter:off
        Category ret = (Category) JOptionPane.showInputDialog(
                null, // componente pai. como não temos, será null
                "Selecione uma categoria",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null, // icone
                repository.findAll().toArray(), // número da opção
                category == null ? 1 : category /* função exibida por padrão */);
        return ret;
        // @formatter:on
    }

    public void success() {
        JOptionPane.showMessageDialog(null,
                "Categoria salva com sucesso!");
    }

    public void success(Category category) {
        JOptionPane.showMessageDialog(null,
                "Categoria " + category.getName() + " salva com sucesso!");
    }

    public static Category form(Category category) {
        String name = JOptionPane.showInputDialog(null,
                "Informe o nome da categoria", category != null ? category.getName() : "");
        return new Category(name);
    }
}
