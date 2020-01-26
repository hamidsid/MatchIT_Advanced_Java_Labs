package Wooram;

import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("size? -> width [space] height");
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("Please input correct value");
        }

        int width = scan.nextInt();
        int height = scan.nextInt();

        System.out.println("position? -> x [space] y");
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("Please input correct value");
        }

        int x = scan.nextInt();
        int y = scan.nextInt();

        PositionGetter positionGetter = new PositionGetter(width,height,x,y);

        Scanner s = new Scanner(System.in);
        System.out.println("please input command:");

        int command = -1;
        while (command != 0){
            String commandLine = s.nextLine();
            String[] splitLine = commandLine.split(",");
            for (int i = 0; i < splitLine.length; i++){
                command = Integer.parseInt(splitLine[i]);
                positionGetter.moveWithCommand(command);
            }
        }
        System.out.println(positionGetter);
        System.out.println(positionGetter.getCurrentPosition());

    }

}
