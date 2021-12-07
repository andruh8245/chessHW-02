public class Horse extends ChessPiece{

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return  this.color;
    }

    @Override
    public String getSymbol() {
        return "H";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if(checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn)) {
            if(line != toLine && column != toColumn &&
                    (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color))
                    && chessBoard.board[line][column]!= null) {

                if (!chessBoard.board[line][column].equals(this)) {
                    return false;
                }

                int[][] postions = new int[][]{
                        {line - 2, column - 1}, {line - 2, column + 1},
                        {line + 2, column - 1}, {line + 2, column + 1},
                        {line - 1, column - 2}, {line - 1, column + 2},
                        {line + 1, column - 2}, {line + 1, column + 2}};

                for (int i = 0; i < postions.length; i++) {
                    if (postions[i][0] == toLine && postions[i][1] == toColumn)
                        return true;
                }
            }
        } else return false;
        return false;
    }
}
