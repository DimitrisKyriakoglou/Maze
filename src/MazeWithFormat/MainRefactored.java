package MazeWithFormat;

import MazeWithoutFormat.Position;

import java.util.LinkedList;

public class MainRefactored {
    static int[][] mazeData = {
            //0 = Wall
            //1 = path
            //2 = destination
            {2, 0, 1, 1},
            {1, 1, 0, 1},
            {0, 1, 1, 1}
    };

    //Stack Path
    static LinkedList<Position> path = new LinkedList<>();


    public static void main(String[] args) {
        solveMaze(new Position(0,3));


    }
    private static void solveMaze(Position myNewPosition){

        //Put my first MazeWithoutFormat.Position in path list
        path.push(myNewPosition);


        while (true) {

            //This is my starting position, peek is used for the first element of the list

            //y for row
            int y = path.peek().y;
            //x for column
            int x = path.peek().x;


            assert path.peek() != null;
            //After starting it makes my starting point 0
            mazeData[y][x] = 0;


            if (isValid(y + 1, x)) {
                //Move down
                if (mazeData[y + 1][x] == 2) {
                    System.out.println("Down You wonr!");
                    return;
                } else if (mazeData[y + 1][x] == 1) {
                    System.out.println("Moved Down");
                    path.push(new Position(y + 1, x));
                    continue;

                }
            }
            if (isValid(y, x - 1)) {
                //Move Left
                if (mazeData[y][x - 1] == 2) {
                    System.out.println("Left You wonr!");
                    return;
                } else if (mazeData[y][x - 1] == 1) {
                    System.out.println("Moved Left");
                    path.push(new Position(y, x - 1));
                    continue;

                }
            }

            if (isValid(y - 1, x)) {
                //Move Up
                if (mazeData[y - 1][x] == 2) {
                    System.out.println("Up You won!r");
                    return;
                } else if (mazeData[y - 1][x] == 1) {
                    System.out.println("Moved Up");
                    path.push(new Position(y - 1, x));
                    continue;

                }
            }
            if (isValid(y, x + 1)) {
                //Move Right
                if (mazeData[y][x + 1] == 2) {
                    System.out.println(" Right You won!r");
                    return;
                } else if (mazeData[y][x + 1] == 1) {
                    System.out.println("Moved Right");
                    path.push(new Position(y, x + 1));
                    continue;

                }
            }

            //Has nowhere to go so go back to previous spot (return to the element of the list)
            path.pop();
            System.out.println("Moved Back");

            //Has nowhere to go and has passed again from all previous spots
            if (path.size() <= 0) {
                System.out.println("No Path");
                return;
            }


        }


    }

    //Checks if next move is inside array boundaries
    public static boolean isValid(int y, int x) {
        //Checking  boundaries
        //Check y if exceeds upper or lower boundaries
        //Check x if exceeds left or right  boundaries
        if (y < 0 || y >= mazeData.length
                || x < 0 || x >= mazeData[y].length) {
            return false;
        }
        return true;
    }

}