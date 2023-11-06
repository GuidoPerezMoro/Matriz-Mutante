public class Gestor {
    public boolean isMutant(String[] dna) throws InvalidMatrixException {
        int n = dna.length;
        if (n == 0) {
            throw new InvalidMatrixException("La matriz no puede estar vacía");
        }
        for (int i = 0; i < n; i++) {
            if (dna[i].length() != n) {
                throw new InvalidMatrixException("La matriz debe ser cuadrada");
            }
            for (int j = 0; j < n; j++) {
                char c = dna[i].charAt(j);
                if (c != 'A' && c != 'C' && c != 'G' && c != 'T') {
                    throw new InvalidMatrixException("La matriz contiene caracteres inválidos");
                }
            }
        }
        int count = 0;
        count += countHorizontal(dna);
        count += countVertical(dna);
        count += countDiagonal(dna);
        return count >= 2;
    }

    private int countHorizontal(String[] dna) {
        int count = 0;
        for (int i = 0; i < dna.length; i++) {
            for (int j = 0; j < dna[i].length() - 3; j++) {
                if (dna[i].charAt(j)==dna[i].charAt(j+1) && dna[i].charAt(j)==dna[i].charAt(j+2) && dna[i].charAt(j)==dna[i].charAt(j+3)) {
                    count++;
                }
            }
        }
        return count;
    }

    private int countVertical(String[] dna) {
        int count = 0;
        for (int i = 0; i < dna.length - 3; i++) {
            for (int j = 0; j < dna[i].length(); j++) {
                if (dna[i].charAt(j)==dna[i+1].charAt(j) && dna[i].charAt(j)==dna[i+2].charAt(j) && dna[i].charAt(j)==dna[i+3].charAt(j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private int countDiagonal(String[] dna) {
        int count = 0;
        count += countDiagonalTopLeftToBottomRight(dna);
        count += countDiagonalBottomLeftToTopRight(dna);
        return count;
    }

    private int countDiagonalTopLeftToBottomRight(String[] dna) {
        int count = 0;
        for (int i = 0; i < dna.length - 3; i++) {
            for (int j = 0; j < dna[i].length() - 3; j++) {
                if (dna[i].charAt(j)==dna[i+1].charAt(j+1) && dna[i].charAt(j)==dna[i+2].charAt(j+2) && dna[i].charAt(j)==dna[i+3].charAt(j+3)) {
                    count++;
                }
            }
        }
        return count;
    }

    private int countDiagonalBottomLeftToTopRight(String[] dna) {
        int count = 0;
        for (int i = 3; i < dna.length; i++) {
            for (int j = 0; j < dna[i].length() - 3; j++) {
                if (dna[i].charAt(j)==dna[i-1].charAt(j+1) && dna[i].charAt(j)==dna[i-2].charAt(j+2) && dna[i].charAt(j)==dna[i-3].charAt(j+3)) {
                    count++;
                }
            }
        }
        return count;
    }
}
