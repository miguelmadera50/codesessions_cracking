/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.durango.codesessions;

/**
 *
 * @author RAMON
 */
public class URLify {
    public static void main(String[] args) {
        String url = " hola uno";
        String urlFormed = "";        
        for (int i = 0; i < url.length(); i++) {  
            String var = String.valueOf(url.charAt(i));
             if (" ".equals(var))
                 urlFormed += "%20";
             else 
                 urlFormed += var;                     
        }
        System.out.println("Url formed: " + urlFormed);
    }
}
