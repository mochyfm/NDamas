import javax.xml.stream.FactoryConfigurationError;

public class Board {

    final private int INNITIAL_SIZE = 8;

    final private int ROW_INNITIAL_CAPACITY = INNITIAL_SIZE;
    final private int COLUMN_INITIAL_CAPACITY = INNITIAL_SIZE;

    final int INITIAL_ROW_POSITION = (int) (Math.random() * INNITIAL_SIZE);
    final int INITIAL_COLUMN_POSITION = (int) (Math.random() * INNITIAL_SIZE);
    private Queen board[][] = new Queen[ROW_INNITIAL_CAPACITY][COLUMN_INITIAL_CAPACITY];

    public Board() {

        for (int i = 0; i < ROW_INNITIAL_CAPACITY; i++) {
            for (int j = 0; j < COLUMN_INITIAL_CAPACITY; j++) {
                board[i][j] = null;
            }
        }
    }


    public void showContent() {
        String result = "";
        for (int i = 0; i < board.length; i++) {
            result += "\n| " + i + " | ";
            for (int j = 0; j < board[0].length; j++) {
                result += " [" + board[i][j] + "]";
            }
        }
        System.out.println("\n" + result + "\n");
    }

    public String showBoard() {

        String output = "\t \n - - - \t Tablero Ajedrez \t - - - \n\n";

        for (int i = 0; i < board.length; i++) {
            output += "| " + (i + 1) + " |";
            for (int j = 0; j < board[0].length; j++) {

                Object resultValue = (board[i][j] == null) ? "   " : board[i][j];

                if ((i % 2) == 0)
                    if ((j % 2) == 0) output += FontStyle.BACKGROUND_WHITE + FontStyle.ANSI_BLACK + resultValue + FontStyle.RESET;
                    else output += FontStyle.BACKGROUND_BLACK + FontStyle.ANSI_WHITE + resultValue + FontStyle.RESET;
                else
                    if ((j % 2) == 0) output += FontStyle.BACKGROUND_BLACK + FontStyle.ANSI_WHITE + resultValue + FontStyle.RESET;
                    else output += FontStyle.BACKGROUND_WHITE + FontStyle.ANSI_BLACK + resultValue + FontStyle.RESET;

            }

            output += "\n";
        }

        return output;
    }

    public void startGame(int Ndamas) {

        System.out.println("\n" + "- - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println("Este es el estado Inicial de nuestro tablero");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - ");

        System.out.println(this.showBoard());

        System.out.println("Vamos a crear un grupo de damas según el que" + "\n" + "nos has asignado " +
                "como parámetro: " + FontStyle.ITALIC + Ndamas + FontStyle.RESET + " damas");



        System.out.println("\n" + "Ponemos una dama aleatoria en una posición " + "\n" + "del tablero " +
                "para así demostrar que no está parametrizado.");

        System.out.println(this.showBoard());
        System.out.println("Posición Aleatoria: [" + (INITIAL_ROW_POSITION)  + "," + (INITIAL_COLUMN_POSITION) + "] " + "\n");

        board[INITIAL_ROW_POSITION][INITIAL_COLUMN_POSITION] = new Queen();

        System.out.println(board[INITIAL_ROW_POSITION][INITIAL_COLUMN_POSITION]);

        this.showContent();

        System.out.println(this.showBoard());

        for (int i = 0; i < ROW_INNITIAL_CAPACITY; i++) {
            for (int j = 0; j < COLUMN_INITIAL_CAPACITY; j++) {
                if (checkPosition(i, j)) board[i][j] = new Queen();
            }
        }
    }

    public void locateQueen() {

        System.out.println("Hay damas en las siguientes posiciones: ");

        for (int i = 0; i < ROW_INNITIAL_CAPACITY; i++) {
            for (int j = 0; j < COLUMN_INITIAL_CAPACITY; j++) {
                if (board[i][j] != null) System.out.println("[ " + i + " ] " + "[ " + j + " ]");
            }
        }

    }


    /**
     *
     * @param posRow corresponde a la fila que se quiere comprobar
     * @param posColumn corresponde a la columna que se quiere comprobar
     *
     * El valor que devuelve depende de las siguientes situaciones:
     *
     * True: Ha encontrado una posición libre en la que puede colocar una pieza
     * False: Ha encontrado una pieza que choca en alguna de las direcciones disponibles
     *
     * **/

    public boolean checkPosition(int posRow, int posColumn) {

        boolean free_horizontal = true;
        boolean free_vertical = true;
        boolean free_diagonal = true;

        /* Checking for horizontal_rows */

        for (int i = 0; i < INNITIAL_SIZE; i++) {
            if (board[posRow][i] != null) free_horizontal = false;
        }

        /* Checking for vertical_rows */

        for (int i = 0; i < INNITIAL_SIZE; i++) {
            if (board[i][posColumn] != null) free_vertical = false;
        }

        for (int diagonal = 0; diagonal < 5; diagonal++) {
            if (diagonal == 1) {
                for (int i = posRow - 1; i >= 0; i--) {
                    for (int j = posColumn - 1; j >= 0; j++) {

                    }
                }
            }
            if (diagonal == 2) {

            } else if (diagonal == 3) {

            } else if (diagonal == 4) {

            }
        }



        return free_vertical && free_horizontal && free_diagonal == true ? true : false;

    }

    @Override
    public String toString() {
        return showBoard();
    }
}
