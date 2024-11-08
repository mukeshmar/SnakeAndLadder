package live.mukeshtechlab.models;

public abstract class BoardEntity {
    private int start;
    private int end;
    private BoardEntityType boardEntityType;

    public BoardEntity(int start, int end, BoardEntityType boardEntityType){
        this.start = start;
        this.end = end;
        this.boardEntityType = boardEntityType;
    }

    // Getter & Setter

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public BoardEntityType getBoardEntityType() {
        return boardEntityType;
    }

    public void setBoardEntityType(BoardEntityType boardEntityType) {
        this.boardEntityType = boardEntityType;
    }
}
