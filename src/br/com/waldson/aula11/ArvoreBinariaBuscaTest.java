package br.com.waldson.aula11;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArvoreBinariaBuscaTest {
    ArvoreBinariaBusca arvore = null;

    @Before
    public void init(){
        arvore = new ArvoreBinariaBusca();
    }

    @Test
    public void getRaiz() {
        //Act
        arvore.insert(10);

        //Assert
        assertSame(arvore.search(10), arvore.getRaiz());
        assertEquals(10, arvore.getRaiz().getValue());
    }

    @Test
    public void isEmpty() {
        //Arrange

        //Act

        //Assert
        assertTrue(arvore.isEmpty());
        arvore.insert(10);
        assertFalse(arvore.isEmpty());

    }

    @Test
    public void isBalanced(){
        // Arrange
        arvore = new ArvoreBinariaBusca();
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



        assertTrue(arvore.isBalanced(arvore.getRoot()));
    }

    @Test
    public void getRoot() {
        //Arrange

        //Act
        arvore.insert(10);

        //Assert
        assertSame(arvore.search(10), arvore.getRoot());
        assertEquals(10, arvore.getRoot().getValue());
    }

    @Test
    public void insert() {
        //Arrange

        //Act
        arvore.insert(10);
        arvore.insert(2);
        arvore.insert(11);

        //Assert
        assertSame(arvore.search(10), arvore.getRoot());
        assertSame(arvore.getRoot().getLeft(), arvore.search(2));
        assertEquals(arvore.getRoot().getRight().getValue(), arvore.search(11).getValue());
    }

    @Test
    public void testInsert() {
        //Act
        arvore.insert(20);
        arvore.insert(10);
        arvore.insert(21);

        //Assert
        assertSame(arvore.getRoot(), arvore.search(20));
        assertSame(arvore.getRoot().getLeft(), arvore.search(10));
        assertSame(arvore.getRoot().getRight(), arvore.search(21));
    }

    @Test
    public void search() {
        //Act

        //Assert
        assertNull(arvore.search(10));
        arvore.insert(10);
        assertNotNull(arvore.search(10));
        assertEquals(10, arvore.search(10).getValue());
    }

    @Test
    public void remover() {
        //Arrange
        arvore.insert(10);
        arvore.insert(13);
        arvore.insert(8);
        arvore.insert(7);
        arvore.insert(9);

        //Act
        arvore.remover(arvore.getRoot(), 13);
        arvore.remover(arvore.getRoot(), 8);


        //Assert
        assertNull(arvore.getRoot().getRight());
        assertEquals(arvore.getRoot().getLeft().getValue(), 9);
        assertNull(arvore.remover(null, 8));

    }
}