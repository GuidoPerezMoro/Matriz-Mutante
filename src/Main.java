// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String[][] mutantDna = {
                {"A", "A", "A", "A", "C", "G"},
                {"C", "A", "G", "T", "G", "C"},
                {"T", "T", "A", "T", "G", "T"},
                {"A", "G", "A", "A", "G", "G"},
                {"C", "C", "C", "C", "T", "A"},
                {"T", "C", "A", "C", "T", "G"}
        };
        String[][] nonMutantDna = {
                {"A", "T", "G", "C", "G", "A"},
                {"C", "A", "G", "T", "T", "C"},
                {"T", "T", "A", "T", "G", "T"},
                {"A", "G", "C", "A", "G", "G"},
                {"C", "C", "T", "A", "T", "A"},
                {"T", "C", "A", "C", "T", "G"}
        };
        mutantAnalysis(mutantDna);
        mutantAnalysis(nonMutantDna);
    }

    public static void mutantAnalysis(String[][] matrix) {
        try {
            Gestor gestor = new Gestor();
            System.out.println("La siguiente matriz:");
            showMatrix(matrix);
            if (gestor.isMutant(matrix))
                System.out.println("Es mutante\n");
            else
                System.out.println("No es mutante\n");
            } catch (InvalidMatrixException e) {
                System.out.println("Invalid matrix: " + e.getMessage());
        }
    }

    public static void showMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}