package live.mukeshtechlab.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Board {
    private int dimension;
    private int cellCount;
    private Map<Integer, BoardEntity> boardEntityMap;
    private static final Random random = new Random();

    public Board(int dimension){
        this.dimension = dimension;
        this.cellCount = dimension * dimension;
        this.boardEntityMap = new HashMap<>();
        addSnakesAndLadders();
    }

    private void addSnakesAndLadders() {
        // Add N = dimension Snakes Randomly
        addSnake();

        // Add N = dimension Ladders Randomly
        addLadder();
    }
    private void addSnake(){
        // Snake => Start > End
        int numberOfSnakeToAdd = dimension;

        do {
            // Range where we can add Snake in Board
            int low = 2;
            int high = cellCount - 1;

            int start = random.nextInt(high - low + 1) + low;

            // Now End's High will be start - 1
            high = start - 1;

            int end = random.nextInt(high - low + 1) + low;

            // Check if there's no snake or ladder at the start position
            if (!hasSnakeOrLadder(start) && start > end) {
                // Add snake only if the start is greater than the end (Snake goes down)
                boardEntityMap.put(start, new Snake(start, end));
                numberOfSnakeToAdd--;  // Successfully added a snake
            }
        } while (numberOfSnakeToAdd > 0);
    }

    private boolean hasSnakeOrLadder(int start) {
        return boardEntityMap.containsKey(start);
    }

    private void addLadder(){
        // Ladder => Start < End
        int numberOfLadderToAdd = dimension;

        do{
            int low = 2;
            int high = cellCount - 1;

            int end = random.nextInt(high - low + 1) + low;

            // Start's high will be < end
            high = end - 1;
            int start = random.nextInt(high - low + 1) + low;

            // Ensure valid ladder placement (no overlap and start < end)
            if (!hasSnakeOrLadder(start) && start < end) {
                boardEntityMap.put(start, new Ladder(start, end));
                numberOfLadderToAdd--;
            }
        }
        while (numberOfLadderToAdd > 0);
    }

    // Getter & Setter
    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public int getCellCount() {
        return cellCount;
    }

    public void setCellCount(int cellCount) {
        this.cellCount = cellCount;
    }

    public Map<Integer, BoardEntity> getBoardEntityMap() {
        return boardEntityMap;
    }

    public void setBoardEntityMap(Map<Integer, BoardEntity> boardEntityMap) {
        this.boardEntityMap = boardEntityMap;
    }
}
