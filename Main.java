import inherit.matrix.*;
import inherit.exceptions.*;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("--- TEST 1: Basic Operations and SquareMatrix ---");
            SquareMatrix A = new SquareMatrix(2);
            A.setElement(0, 0, 1); A.setElement(0, 1, 5);
            A.setElement(1, 0, 0); A.setElement(1, 1, 1);
            
            SquareMatrix B = new SquareMatrix(2);
            B.setElement(0, 0, 1); B.setElement(0, 1, 0);
            B.setElement(1, 0, 5); B.setElement(1, 1, 1);

            System.out.println("Matrix A:\n" + A);
            System.out.println("Matrix B:\n" + B);
            System.out.println("A + B (Sum):\n" + A.sum(B));
            System.out.println("A * B (Product):\n" + A.product(B));

            System.out.println("MirrorMatrixHor---");
            MirrorMatrixHor mirror = new MirrorMatrixHor(4, 2);
            mirror.setElement(0, 0, 10);
            mirror.setElement(0, 1, 20);
            mirror.setElement(1, 0, 30);
            mirror.setElement(1, 1, 40);

            System.out.println("Mirror Matrix (4x2):\n" + mirror); // print full
            
            int val0_0 = mirror.getElement(0, 0);
            int val3_0 = mirror.getElement(3, 0);
            System.out.println("Element (0,0): " + val0_0);
            System.out.println("Element (3,0) [Mirror of (0,0)]: " + val3_0);
            
            if (val0_0 == val3_0) {
                System.out.println("Mirroring SUCCESS: Rows 0 and 3 are linked.");
            } else {
                System.out.println("Mirroring FAILED!");
            }

            System.out.println("\nEquality ---");

            Matrix normal = new Matrix(4, 2);
            normal.setElement(0, 0, 10); normal.setElement(0, 1, 20);
            normal.setElement(1, 0, 30); normal.setElement(1, 1, 40);
            // normal.setElement(2, 0, 30); normal.setElement(2, 1, 40); 
            // normal.setElement(3, 0, 10); normal.setElement(3, 1, 20); 

            System.out.println("Mirror Matrix equals Normal Matrix: " + mirror.equals(normal));

            System.out.println("\nError Handling ---");
            try {
                Matrix F = new Matrix(2, 1);
                System.out.println("Attempting to sum 2x2 and 2x1 matrices:");
                A.sum(F);
            } catch (BadMatrixSizesException e) {
                System.out.println("Caught expected exception: " + e.getMessage());
            }

            try {
                System.out.println("Attempting to access out-of-bounds index (4,0) in 4x2 matrix:");
                mirror.getElement(4, 0);
            } catch (BadMatrixSizesException e) {
                System.out.println("Caught expected exception: " + e.getMessage());
            }

        } catch (BadMatrixSizesException e) {
            System.out.println("Unexpected Critical Error: " + e.getMessage());
        }
    }
}
