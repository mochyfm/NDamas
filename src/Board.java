import java.util.ArrayList;

public class Board {

    final private int INNITIAL_CAPACITY = 8;

    private ArrayList<ArrayList<Queen>> board = new ArrayList<>(INNITIAL_CAPACITY);

    public Board() {

        ArrayList<Queen> pattern = new ArrayList<>(INNITIAL_CAPACITY);

        for (int i = 0; i < INNITIAL_CAPACITY; i++) {

            board.add(i, pattern);
            board.get(i).add(i, null);

            }
        }


    public void showContent() {
        String result = "";
        for (int i = 0; i < board.size(); i++) {
            result += "\n| " + i + " | ";
            for (int j = 0; j < board.get(i).size(); j++) {
                result += " [" + board.get(i).get(j) + "]";
            }
        }
        System.out.println("\n" + result + "\n");
    }

    public String showBoard() {

        String output = "\t \n - - - \t Tablero Ajedrez \t - - - \n\n";

        for (int i = 0; i < board.size(); i++) {
            output += "| " + (i + 1) + " |";
            for (int j = 0; j < board.get(i).size(); j++) {

                Object resultValue = (board.get(i).get(j) == null) ? "   " : board.get(i).get(j);

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

        int posicionA = (int) (Math.random() * INNITIAL_CAPACITY);
        int posicionB = (int) (Math.random() * INNITIAL_CAPACITY);

        System.out.println("\n" + "Ponemos una dama aleatoria en una posición " + "\n" + "del tablero " +
                "para así demostrar que no está parametrizado.");

        System.out.println(this.showBoard());
        System.out.println("Posición Aleatoria: [" + (posicionA)  + "," + (posicionB) + "] " + "\n");

        System.out.println(board.get(posicionA).get(posicionB));

        this.showContent();

        System.out.println(this.showBoard());
    }

    @Override
    public String toString() {
        return showBoard();
    }
}
