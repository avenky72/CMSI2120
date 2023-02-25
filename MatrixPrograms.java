import java.util.Scanner;

public class MatrixPrograms {

    public static void main(String[] args) {
        System.out.println("Please enter the rows in the matrix");
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        System.out.println("Please enter the columns in the matrix");
        int column = sc.nextInt();

        int[][] first = new int[row][column];
        int[][] second = new int[row][column];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                System.out.println(String.format("Enter first[%d][%d] integer", r, c));
                first[r][c] = sc.nextInt();
            }
        }

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                System.out.println(String.format("Enter second[%d][%d] integer", r, c));
                second[r][c] = sc.nextInt();
            }
        }


        // close the scanner
        sc.close();

        // print both matrices
        System.out.println("First Matrix:\n");
        print2dArray(first);

        System.out.println("Second Matrix:\n");
        print2dArray(second);

        // sum of matrices
        sum(first, second);
        subtractMatrix(first, second);
        System.out.println();
        System.out.println("First Matrix:\n");
        print2dArray(first);
        System.out.println("Remove the second row:\n");
        removeRow(first,1);
        System.out.println("Remove the second col:\n");
        removeColumn(second,1);
        System.out.println();
        System.out.println("Remove the second row and move up:\n");
        deleteRowSetZero(first, 1);


    }

    // below code doesn't take care of exceptions
    private static void sum(int[][] first, int[][] second) {
        int row = first.length;
        int column = first[0].length;
        int[][] sum = new int[row][column];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                sum[r][c] = first[r][c] + second[r][c];
            }
        }

        System.out.println("\nSum of Matrices:\n");
        print2dArray(sum);
    }

    private static void print2dArray(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                System.out.print(matrix[r][c] + "\t");
            }
            System.out.println();
        }
    }


    // moves rows after a deleted row up
    private static int[][] moveUp(int[][]mat, int row) {
        int[][] copy = new int[mat.length][mat[0].length];
        int count = 0;
        boolean found = false;
        int[] temp = new int[mat.length];

        if (row == mat.length-1) {
            return mat;
        }


        // Save the row data
        for (int i = 0; i < mat[0].length; i++) {
            temp[i] = mat[row][i];
        }

        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                if (row > r) {
                    copy[r][c] = mat[r][c];
                }
                if (row == r) {
                    // copy the row data
                    found = true;
                    copy[r][c] = mat[r+1][c];
                    break;
                }
                if ( found == true && row != r) {
                    copy[r-1][c] = mat[r][c];
                }
                if (r == mat[0].length-1){
                    copy[r][c] = temp[c];
                }
            }
        }
        return copy;
    }

    private static void removeRow(int[][] mat, int row)
    {
        int[][] realCopy = new int[mat.length-1][mat[0].length];
        int count = 0;
        if(row==mat.length-1)
        {
            for(int r=0; r<mat.length-1; r++)
            {
                for(int c=0; c<mat[0].length; c++)
                {
                    if(row==r)
                        r++;
                    realCopy[count][c]= mat[r][c];
                }
                count++;
            }
        }
        else
        {
            for(int r=0; r<mat.length; r++)
            {
                for(int c=0; c<mat[0].length; c++)
                {
                    if(row==r)
                        r++;
                    realCopy[count][c]= mat[r][c];
                }
                count++;
            }
        }
        print2dArray(realCopy);
    }

    // makes the last row zero
    private static int[][] PutRowToZero(int[][]mat, int row){
        for(int c=0; c<mat[0].length; c++)
        {
            mat[mat.length-1][c]= 0;
        }
        return mat;
    }

    // deletes a row
    private static void deleteRowSetZero(int[][]mat, int row) {
        int[][] copy = new int[mat.length][mat[0].length - 1];
        int count = 0;
        int new_mat[][] = moveUp(mat, row);
        int result_mat[][] = PutRowToZero(new_mat, row);
        print2dArray(result_mat);
    }

    private static void removeColumn(int[][]mat, int col) {
        int[][] copy = new int[mat.length][mat[0].length - 1];
        int count = 0;

        if (col == mat.length - 1) {
            System.out.println("Here");
            for (int c = 0; c < mat.length - 1; c++) {
                for (int r = 0; r < mat[0].length; r++) {
                    if (col == c)
                        c++;
                    copy[r][count] = mat[r][c];
                }
                count++;
            }
        } else {
            for (int c = 0; c < mat.length; c++) {
                for (int r = 0; r < mat[0].length; r++) {
                    if (col == c)
                        c++;
                    copy[r][count] = mat[r][c];
                }
                count++;
            }
        }
        print2dArray(copy);
    }

    private static void subtractMatrix(int[][] first, int[][] second) {
        int row = first.length;
        int column = first[0].length;
        int[][] diff = new int[row][column];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                diff[r][c] = first[r][c] - second[r][c];
            }
        }

        System.out.println("\nDifference of Matrices:\n");
        print2dArray(diff);
    }
}
