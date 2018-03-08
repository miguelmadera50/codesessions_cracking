/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.durango.codesessions;

/**
 *
 * @author QG
 */
public class ZeroMatrix {

    public static void main(String[] args) {
        //int[][] matrix = {{1, 1, 2, 3}, {2, 9, 0, 1}, {6,6,6,2}, {0,6,5,1}, {7,3,1,1}};
        //int[][] matrix = {{1, 2, 3}, {4,0,6}, {7,8,9}};
        int[][] matrix = {{1,0}, {0,4}};
        
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                System.out.print(matrix[x][y]);
                System.out.print(" ");
                if (matrix[x][y] == 0) {                    
                }
            }
            System.out.println();
        } 
                               
        System.out.println();
        
        matrix = ZeroMatrix(matrix);

        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                System.out.print(matrix[x][y]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    public static int[][] ZeroMatrix (int[][] matrix){
        int h = matrix.length;
        int w = matrix[0].length;

        int[] xs = new int[h];
        int[] ys = new int[w];
        
        int count = 0;
        
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {               
                if (matrix[x][y] == 0) {
                    xs[count] = x;
                    ys[count] = y;
                    count++;
                }
            }           
        } 
        
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < matrix[xs[i]].length; j++) {
                matrix[xs[i]][j] = 0;
            }
        }

        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < count; i++) {
                matrix[j][ys[i]] = 0;
            }
        }
        
        return matrix;
    }

}
