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
public class RotateMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2},{ 3,4}};
                         
        for (int[] matrix1 : matrix) {
            for (int y = 0; y < matrix1.length; y++) {
                System.out.print(matrix1[y]);
                System.out.print(" ");
            }
            System.out.println();
        }
        
        int[][] matrix90 = RotateMatrix(matrix);
                
        for (int[] matrix1 : matrix90) {
            for (int y = 0; y < matrix1.length; y++) {
                System.out.print(matrix1[y]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    public static int[][] RotateMatrix(int[][] matrix){
        int h = matrix.length;
        int w = matrix[0].length;
        int[][] matrix90 =new int [w][h];
        int xcount = 0;
        int ycount = 0;
        for (int x = matrix.length-1; x >= 0; x--) {
            for (int y = 0; y < matrix[x].length; y++) {                
                matrix90[xcount][ycount] = matrix[x][y];
                xcount++;
            } 
            xcount = 0;
            ycount++;
        }
        return matrix90;
    }
}
