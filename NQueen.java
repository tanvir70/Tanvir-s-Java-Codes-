import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();

        solveNQueens(0, n, new ArrayList<>(), results);

        return results;
    }

    private void solveNQueens(int row, int n, List<Integer> colPlacements, List<List<String>> results) {
        if (row == n) {
            results.add(generateBoard(colPlacements, n));
            return;
        }
        for (int colum = 0; colum < n; colum++) {
            colPlacements.add(colum);

            if (isValid(colPlacements)) {
                solveNQueens(row + 1, n, colPlacements, results);
            }
            colPlacements.remove(colPlacements.size() - 1);
        }
    }

    private boolean isValid(List<Integer> columPlacements) {
        int rowWeAreValidatingOn = columPlacements.size() - 1;

        for (int ithQueenRow = 0; ithQueenRow < rowWeAreValidatingOn; ithQueenRow++) {

            int absoluteColumDistance = Math.abs(columPlacements.get(ithQueenRow) - columPlacements.get(rowWeAreValidatingOn));
            int rowDistance = rowWeAreValidatingOn - ithQueenRow;

            if (absoluteColumDistance == 0 || absoluteColumDistance == rowDistance) {
                return false;
            }
        }
        return true;
    }

    private List<String> generateBoard(List<Integer> columPlacements, int n) {
        List<String> board = new ArrayList<>();
        int totalItemPlaced = columPlacements.size();

        for (int row = 0; row < totalItemPlaced; row++) {
            StringBuilder sb = new StringBuilder();

            for (int colum = 0; colum < n; colum++) {
                if (colum == columPlacements.get(row)) {
                    sb.append('Q');
                } else {
                    sb.append('-');
                }
            }
            board.add(sb.toString());
        }
        return board;
    }


    public static void main(String[] args) {
        NQueen n = new NQueen();
        List<List<String>> results = n.solveNQueens(4);
        for (List<String> result : results) {
            for (String row : result) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

}
