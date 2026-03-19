package org.suai.lab3;

import org.suai.lab3.exceptions.*;
import org.suai.lab3.matrix.*;

public class Main {
    public static void main(String[] args) {
        SparseMatrix sm1 = new SparseMatrix(3, 3);
        sm1.setElement(1, 1, 2);
        sm1.setElement(1, 2, 2);

        SparseMatrix sm2 = new SparseMatrix(3, 3);
        sm2.setElement(1, 1, 2);
        sm2.setElement(1, 2, 2);

        System.out.println(sm1);
        System.out.println(sm2);
        System.out.println(sm2.sum(sm1));
    }
}
