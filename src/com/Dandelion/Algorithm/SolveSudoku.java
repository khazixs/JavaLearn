package com.Dandelion.Algorithm;

import javax.print.attribute.standard.Destination;
import java.util.ArrayList;
import java.util.List;

public class SolveSudoku {
    final int N = 9;
    int [][] rowsLimit = new int[N][N];
    int [][] columnsLimit = new int[N][N];
    int [][] boxesLimit = new int[N][N];
    List<String[]> destination = new ArrayList<>();

    public static void main(String[] args) {
        String[] str1 =new String[]{"5","3","0","0","7","0","0","0","0"};
        String[] str2 =new String[]{"6","0","0","1","9","5","0","0","0"};
        String[] str3 =new String[]{"0","9","8","0","0","0","0","6","0"};
        String[] str4 =new String[]{"8","0","0","0","6","0","0","0","3"};
        String[] str5 =new String[]{"4","0","0","8","0","3","0","0","1"};
        String[] str6 =new String[]{"7","0","0","0","2","0","0","0","6"};
        String[] str7 =new String[]{"0","6","0","0","0","0","2","8","0"};
        String[] str8 =new String[]{"0","0","0","4","1","9","0","0","5"};
        String[] str9 =new String[]{"0","0","0","0","8","0","0","7","9"};
        SolveSudoku sudoku = new SolveSudoku();
        sudoku.destination.add(str1);
        sudoku.destination.add(str2);
        sudoku.destination.add(str3);
        sudoku.destination.add(str4);
        sudoku.destination.add(str5);
        sudoku.destination.add(str6);
        sudoku.destination.add(str7);
        sudoku.destination.add(str8);
        sudoku.destination.add(str9);
        for (int i=0;i<9;i++){
            System.out.print("[");
            for (int j=0;j<9;j++){
                System.out.print((sudoku.destination.get(i))[j]);
                System.out.print("      ");
                if((j+1)%3 == 0&&j!=8){
                    System.out.print("|");
                    System.out.print("      ");
                }
            }
            System.out.println("]");
            if((i+1)%3 == 0){
                System.out.println("------------------------------------------------------------");
            }else{
                System.out.println();
            }
        }

    }

}

