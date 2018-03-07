/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.durango.codesessions;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author QG
 */
public class UnitTests {
    
    public UnitTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void IsUnique(){
        assertEquals(true, IsUnique.IsUnique(""));
        assertEquals(true, IsUnique.IsUnique("a"));
        assertEquals(true, IsUnique.IsUnique("abc"));
        assertEquals(true, IsUnique.IsUnique("qwertyuiopasdfghjklzxcvbnm"));
        assertEquals(false, IsUnique.IsUnique("aa"));
        assertEquals(false, IsUnique.IsUnique("qwertyuiopasdfghjklzxcvbnq"));
        assertEquals(false, IsUnique.IsUnique("qwertyuiopasdfghjklzxcvbnzuythe"));
        assertEquals(false, IsUnique.IsUnique("qwertyhnbgfdsabzxc"));
    }
    
    @Test
    public void Permutation (){
        assertEquals(true, Permutation.Permutation("", ""));
        assertEquals(true, Permutation.Permutation("a", "a"));
        assertEquals(true, Permutation.Permutation("zzzzzzz" , "zzzzzzz"));
        assertEquals(true, Permutation.Permutation("abcd", "dcba"));
        assertEquals(true, Permutation.Permutation("qwertty", "tqweryt"));
        assertEquals(false, Permutation.Permutation("a", "b"));
        assertEquals(false, Permutation.Permutation("a", "aa"));
        assertEquals(false, Permutation.Permutation("aaaaa", "aa"));
        assertEquals(false, Permutation.Permutation("qwerty", "qwerti"));
        assertEquals(false, Permutation.Permutation("miridso", "miridsd"));
    }
    
    @Test
    public void URLify(){
        assertEquals("a%20b", URLify.URLify("a b"));
        assertEquals("a%20b%20", URLify.URLify("a b "));
        assertEquals("a%20%20%20%20b", URLify.URLify("a    b"));
        assertEquals("%20%20%20", URLify.URLify("   "));
        assertEquals("www%20google%20a%20com%20search%20", URLify.URLify("www google a com search "));
    }
    
    
     @Test
     public void OneWay() {
          assertEquals(true, OneWay.OneWay("", ""));
          assertEquals(true, OneWay.OneWay("aa", "aa"));
          assertEquals(true, OneWay.OneWay("", "a"));
          assertEquals(true, OneWay.OneWay("a", ""));
          assertEquals(true, OneWay.OneWay("a", "b"));
          assertEquals(true, OneWay.OneWay("q", "qq"));
          assertEquals(true, OneWay.OneWay("qq", "q"));
          assertEquals(false, OneWay.OneWay("ba", ""));
          assertEquals(false, OneWay.OneWay("word", "dwor"));
          assertEquals(false, OneWay.OneWay("ab", "ba"));
          assertEquals(false, OneWay.OneWay("a", "aaa"));
          assertEquals(false, OneWay.OneWay("qwer", "qrwe"));
     }
     
     @Test
     public void Compression(){
         assertEquals("", Compression.Compression(""));
         assertEquals("a", Compression.Compression("a"));
         assertEquals("aa", Compression.Compression("aa"));
         assertEquals("a3", Compression.Compression("aaa"));
         assertEquals("a3b3c3", Compression.Compression("aaabbbccc"));
         assertEquals("abcdefgh", Compression.Compression("abcdefgh"));
         assertEquals("a2b1g3a1r3a2t4", Compression.Compression("aabgggarrraatttt"));
         assertEquals("aabgggarrraatt", Compression.Compression("aabgggarrraatt"));
     }
     
     @Test
     public void RotateMatrix (){
        int[][] matrix = {{1, 2},{3, 4}};
        int[][] matrixresult = {{3, 1},{4, 2}};
        assertArrayEquals(matrixresult, RotateMatrix.RotateMatrix(matrix));       
     }
}
