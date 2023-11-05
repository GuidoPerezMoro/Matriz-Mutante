public class Gestor {
    public boolean isMutant(String[][] dna) throws InvalidMatrixException {
        int n = dna.length;
        if (n == 0) {
            throw new InvalidMatrixException("Input matrix is empty");
        }
        for (int i = 0; i < n; i++) {
            if (dna[i].length != n) {
                throw new InvalidMatrixException("Input matrix is not square");
            }
            for (int j = 0; j < n; j++) {
                if (!dna[i][j].matches("[ATCG]")) {
                    throw new InvalidMatrixException("Input matrix contains invalid characters");
                }
            }
        }
        int count = 0;
        count += countHorizontal(dna);
        count += countVertical(dna);
        count += countDiagonal(dna);
        return count >= 2;
    }

    private int countHorizontal(String[][] dna) {
        int count = 0;
        for (int i = 0; i < dna.length; i++) {
            for (int j = 0; j < dna[i].length - 3; j++) {
                if (dna[i][j].equals(dna[i][j+1]) && dna[i][j].equals(dna[i][j+2]) && dna[i][j].equals(dna[i][j+3])) {
                    count++;
                }
            }
        }
        return count;
    }

    private int countVertical(String[][] dna) {
        int count = 0;
        for (int i = 0; i < dna.length - 3; i++) {
            for (int j = 0; j < dna[i].length; j++) {
                if (dna[i][j].equals(dna[i+1][j]) && dna[i][j].equals(dna[i+2][j]) && dna[i][j].equals(dna[i+3][j])) {
                    count++;
                }
            }
        }
        return count;
    }

    private int countDiagonal(String[][] dna) {
        int count = 0;
        count += countDiagonalTopLeftToBottomRight(dna);
        count += countDiagonalBottomLeftToTopRight(dna);
        return count;
    }

    private int countDiagonalTopLeftToBottomRight(String[][] dna) {
        int count = 0;
        for (int i = 0; i < dna.length - 3; i++) {
            for (int j = 0; j < dna[i].length - 3; j++) {
                if (dna[i][j].equals(dna[i+1][j+1]) && dna[i][j].equals(dna[i+2][j+2]) && dna[i][j].equals(dna[i+3][j+3])) {
                    count++;
                }
            }
        }
        return count;
    }

    private int countDiagonalBottomLeftToTopRight(String[][] dna) {
        int count = 0;
        for (int i = 3; i < dna.length; i++) {
            for (int j = 0; j < dna[i].length - 3; j++) {
                if (dna[i][j].equals(dna[i-1][j+1]) && dna[i][j].equals(dna[i-2][j+2]) && dna[i][j].equals(dna[i-3][j+3])) {
                    count++;
                }
            }
        }
        return count;
    }
}
