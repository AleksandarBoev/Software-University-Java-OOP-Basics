package classes;

public abstract class BloodCell extends Cell {
    public BloodCell(String id, int health, int positionRow, int positionCol) {
        super(id, health, positionRow, positionCol);
    }

    @Override
    public String getCellType() {
        return "BloodCell";
    }


    //When Blood cell meets another Blood cell or Microbe, it assimilates it and takes all of its health.
    // The other cell is assimilated and disappears. The moving cell continues its way.
}
