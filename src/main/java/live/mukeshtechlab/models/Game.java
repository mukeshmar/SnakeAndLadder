package live.mukeshtechlab.models;

import java.util.LinkedList;
import java.util.Queue;

public class Game {
    private Board board;
    private Queue<Player> players;
    private Queue<Player> winners;
    private int dimension;

    public Game(int dimension, Queue<Player> players){
        this.dimension = dimension;
        this.players = players;
        this.winners = new LinkedList<>();
        this.board = new Board(dimension);
    }

    // Getter & Setter
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Queue<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Queue<Player> players) {
        this.players = players;
    }

    public Queue<Player> getWinners() {
        return winners;
    }

    public void setWinners(Queue<Player> winners) {
        this.winners = winners;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
}
