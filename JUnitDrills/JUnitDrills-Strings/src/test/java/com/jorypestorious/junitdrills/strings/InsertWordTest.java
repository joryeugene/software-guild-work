
package com.jorypestorious.junitdrills.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class InsertWordTest {

//insertWord("<<>>", "Yay") -> "<<Yay>>"
//insertWord("<<>>", "WooHoo") -> "<<WooHoo>>"
//insertWord("[[]]", "word") -> "[[word]]"

    @Test
    public void testInsertWord() {
        System.out.println("insertWord");
        String container = "<<>>";
        String word = "Yay";
        InsertWord instance = new InsertWord();
        String expResult = "<<Yay>>";
        String result = instance.insertWord(container, word);
        assertEquals(expResult, result);
        
        container = "<<>>";
        word = "WooHoo";
        expResult = "<<WooHoo>>";
        result = instance.insertWord(container, word);
        assertEquals(expResult, result);
        
        container = "[[]]";
        word = "word";
        expResult = "[[word]]";
        result = instance.insertWord(container, word);
        assertEquals(expResult, result);
    }

}