import inherit.matrix.*;
import inherit.exceptions.MatrixException;

public class Main {
    public static void main(String[] args) {
        try {
            SquareMatrix A = new SquareMatrix(2);
            SquareMatrix B = new SquareMatrix(2);
            
            A.setElement(0, 1, 5);
            B.setElement(1, 0, 5);

            System.out.println("Matrix A:\n" + A);
            System.out.println("Matrix B:\n" + B);
            
            System.out.println("C = A + B:\n");
            Matrix C = A.sum(B);
            System.out.println("Matrix C:\n" + C);

            Matrix F = new Matrix(2, 1);
            F.setElement(0, 0, 3);
            System.out.println("Matrix F:\n" + F);
            
            System.out.println("D = A + F:\n");
            Matrix D = A.sum(F);
            System.out.println("Matrix D:\n" + D);

        } catch (MatrixException e) {
            System.out.println(e.getMessage());
        }
    }
}
