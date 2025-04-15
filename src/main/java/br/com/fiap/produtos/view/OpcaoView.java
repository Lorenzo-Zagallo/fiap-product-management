package br.com.fiap.produtos.view;

import javax.swing.*;

public class OpcaoView {

    public static Opcao select() {

        Opcao ret = (Opcao) JOptionPane.showInputDialog(
                null, // componente pai. como não temos, será null
                "Selecione uma opção",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null, // icone
                Opcao.values(), // número da opção
                Opcao.CADASTRAR_PRODUTO /* função exibida por padrão */);

        return ret != null ? ret : Opcao.ENCERRAR_SISTEMA;
    }

}
