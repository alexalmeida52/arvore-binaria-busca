package br.com.waldson.aula11;

import javax.swing.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
        arvore.insert(30);
        arvore.insert(5);
        arvore.insert(4);
        arvore.insert(3);
        arvore.insert(7);
        arvore.insert(6);
        arvore.insert(8);
        arvore.insert(9);
        arvore.insert(30);
        arvore.insert(32);
        arvore.insert(31);
        arvore.insert(33);
        arvore.insert(34);

        /*Random random = new Random();
        for (int i = 0; i < 30; i++) {
            arvore.insert(
                new Node(i)
            );
        }*/

        //arvore.remover(arvore.search(10), 13);

        JFrame frame = new JFrame("Visualizador de ABB");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        ArvoreBinariaBuscaView view = new ArvoreBinariaBuscaView(arvore);
        frame.add(view);

        frame.setVisible(true);
    }
}
