package combatmap;

public class GridPoint {

    private Row row;
    private Column column;

    public GridPoint(Row row, Column column) {
        this.row = row;
        this.column = column;
    }


    public Column getColumn() {
        return column;
    }

    public void setColumn(Column column) {
        this.column = column;
    }

    public Row getRow() {
        return row;
    }

    public void setRow(Row row) {
        this.row = row;
    }

    @Override
    public String toString(){
        return "GridPoint: [" + this.row.name() + "/" + this.column.name() + "]";
    }
}
