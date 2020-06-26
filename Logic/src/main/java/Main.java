import java.io.IOException;

//To do tylko do testowania, potem wywalić
public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        /*try {
            board.getLightsController().saveConfig();
        }
        catch (IOException ex){
            System.out.println("IOException!!!");
        }*/
        //board.saveBoard();
        board.loadBoard();
        System.out.println(board.toStringDoTestow());
    }

}
