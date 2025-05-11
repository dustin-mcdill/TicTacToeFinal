//New file for the game log

package tictactoe;

import java.io.FileWriter;
import java.io.IOException;

public class GameLog {
    private int xWin;
    private int oWin;
    private int tie;

    public void recordAwin(char player) {
        if (player == 'X') xWin++;
        else if (player == 'O') oWin++;
    }

    public void recordAtie(){
        tie++;
    }

    public void printStat() {
        System.out.println("Stats so far:");
        System.out.println("Player X Stats: " + xWin);
        System.out.println("Player O Stats: " + oWin);
        System.out.println();
    }

    public void saveFile() {
        try (FileWriter writer = new FileWriter("game_log.txt")){
            writer.write("Game End Stats:\n");
            writer.write("Player X Wins: " + xWin + "\n");
            writer.write("Player O Wins: " + oWin + "\n");
            writer.write("Number of Ties: " + tie + "\n");
        } catch (IOException e){
            System.out.println("Error");
        }
    }
}
