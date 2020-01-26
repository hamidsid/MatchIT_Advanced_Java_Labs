package Wooram;

public class PositionGetter {

    private int direction;
    private Position currentPosition;
    private Position[][] positions;

    public PositionGetter(int row, int col, int x, int y) {
        positions = new Position[row][col];
        currentPosition = new Position(x, y);
        direction = 360;

        for (int r = 0; r < row; r++){
            for (int c = 0; c < col; c++) {
                positions[c][r] = new Position(c, r);
            }
        }
    }

    public Position getCurrentPosition(){
        if(currentPosition.getX() < 0 || currentPosition.getX() > positions.length ||
        currentPosition.getY() < 0 || currentPosition.getY() > positions.length){
            currentPosition.setX(-1);
            currentPosition.setY(-1);
        }
        return currentPosition;
    }

    public void moveWithCommand(int command) {
        switch (command){
            case 1:
                moveForward();
                break;
            case 2:
                moveBackward();
                break;
            case 3:
                changeDirection(90);
                break;
            case 4:
                changeDirection(-90);
                break;
        }
    }

    private void moveBackward(){
        changeDirection(180);
        moveForward();
        changeDirection(180);
    }

    private void moveForward(){
        switch (getDirection()){
            case 0:
                currentPosition.setY(currentPosition.getY()-1);
                break;
            case 90:
                currentPosition.setX(currentPosition.getX()+1);
                break;
            case 180:
                currentPosition.setY(currentPosition.getY()+1);
                break;
            case 270:
                currentPosition.setX(currentPosition.getX()-1);
                break;
        }
    }

    private void changeDirection(int degree){
        direction += degree;
    }

    private int getDirection(){
        return direction %360;
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int r=0; r < positions.length; r++){
            for (int c=0; c < positions[r].length; c++){
                Position p = positions[c][r];
                sb.append(p);
            }
            sb.append("\n");
        }
        return sb.toString();
    }


}
