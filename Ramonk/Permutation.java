/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.durango.codesessions;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author RAMON
 */
public class Permutation {
    public static void main(String[] args) {
        String string1 = "unouno";
        String string2 = "onuono";
        boolean isPermutation = true;
        Map <String, Integer> dictionary = new HashMap();
        for (int i = 0; i < string1.length(); i++) {
            String var = String.valueOf(string1.charAt(i));
            if (dictionary.containsKey(var)){
                Integer value = dictionary.get(var);
                dictionary.remove(var);
                dictionary.put(var, value+1);
            }
            else
                dictionary.put(var, 1);
        }
        for (int i = 0; i < string2.length(); i++) {
            String var = String.valueOf(string2.charAt(i));
            if (dictionary.containsKey(var)){
                Integer value = dictionary.get(var);
                dictionary.remove(var);
                dictionary.put(var, value-1);
            }
            else{
                isPermutation = false;
                break;
            }                
        }
        
        if (isPermutation){
            for (Map.Entry<String, Integer> entrySet : dictionary.entrySet()) {                
                if (entrySet.getValue() != 0){
                    isPermutation = false;
                    break;
                }                  
            }
        }
        
        System.out.println(string1 + " is permutation of " + string2 + "?: " + isPermutation);
    }
}
