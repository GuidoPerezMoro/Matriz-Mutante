import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        BancoMatrices matrices = new BancoMatrices();

        for (String[] m : matrices.getBancoMatrices()) {
            mutantAnalysis(m);
        }

        //Matriz creada por el usuario
        //mutantAnalysis();

    }

    //Verificar una matriz creada por el usuario
    public static void mutantAnalysis() {
        String[] matrix = fillMatrix();
        Gestor gestor = new Gestor();
        try {
            if (gestor.isMutant(matrix)) {
                System.out.println("La siguiente matriz:");
                showMatrix(matrix);
                System.out.println("Es mutante\n");
            } else {
                System.out.println("No es mutante\n");
                System.out.println("La siguiente matriz:");
                showMatrix(matrix);
            }
        } catch (InvalidMatrixException e) {}
    }

    //Verificar una matriz dada
    public static void mutantAnalysis(String[] matrix) {
        try {
            Gestor gestor = new Gestor();
            System.out.println("La siguiente matriz:");
            showMatrix(matrix);
            if (gestor.isMutant(matrix))
                System.out.println("Es mutante\n");
            else
                System.out.println("No es mutante\n");
        } catch (InvalidMatrixException e) {
            System.out.println("Matriz inválida: " + e.getMessage());
        }
    }

    public static void showMatrix(String[] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length(); j++) {
                System.out.print(matrix[i].charAt(j) + " ");
            }
            System.out.println("");
        }
    }

    //Crear matriz por el usuario
    public static String[] fillMatrix() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> rows = new ArrayList<>();
        int n = 0;
        try {
            System.out.print("Ingrese la fila 1: ");
            String row = scanner.nextLine();
            verifyRow(row);
            rows.add(row);
            n = row.length();
            if (n == 0)
                throw new InvalidMatrixException("La matriz no puede estar vacía");
            for (int i = 2; i <= n; i++) {
                System.out.print("Ingrese la fila " + i + ": ");
                row = scanner.nextLine();
                if (row.length() != n) {
                    throw new InvalidMatrixException("La matriz debe ser cuadrada");
                }
                verifyRow(row);
                rows.add(row);
            }
        } catch (InvalidMatrixException e){
            System.out.println("Matriz inválida: " + e.getMessage());
        }
        String[] matrix = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (String r : rows) {
                sb.append(r.charAt(i));
            }
            matrix[i] = sb.toString();
        }
        return matrix;
    }

    public static void verifyRow(String row) throws InvalidMatrixException {
        for (int i = 0; i < row.length(); i++) {
            char c = row.charAt(i);
            if (c != 'A' && c != 'C' && c != 'G' && c != 'T') {
                throw new InvalidMatrixException("Error: La matriz contiene caracteres inválidos");
            }
        }
    }
}