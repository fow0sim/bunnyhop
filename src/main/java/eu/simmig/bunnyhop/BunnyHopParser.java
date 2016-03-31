package eu.simmig.bunnyhop;

import eu.simmig.turtle.Location;
import eu.simmig.turtle.Turtle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BunnyHopParser {
    private Turtle turtle;

    public BunnyHopParser() {

    }

    public void parse(String fileName) {
        turtle = new Turtle();
        turtle.setDirection(Location.DIRECTION_E);
        int skip = 5;
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                count += 1;
                if (count <= skip) {
                    continue;
                }
                StringTokenizer st = new StringTokenizer(line);
                if (st.hasMoreElements()) {
                    String cmd = st.nextToken();
                    int arg = 0;
                    if (st.hasMoreElements()) {
                        arg = Integer.parseInt(st.nextToken());
                    }
                    execute(cmd, arg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[][] getArray() {
        return turtle.toArray();
    }

    public void plot() {
        int[][] array = getArray();
        String str;
        for (int i = 0; i < array.length; i += 1) {
            str = "";
            for (int j = 0; j < array[0].length; j += 1) {
                str += (array[i][j] == 1) ? "\u2588\u2588" : "  ";
            }
            System.out.println(str);
        }
    }

    private void execute(String cmd, int arg) {
//        System.out.println(cmd + " " + arg);
        if (cmd.equalsIgnoreCase("lineofeggs")) {
            lineOfEggs(arg);
        } else if (cmd.equalsIgnoreCase("hop")) {
            turtle.walk(arg / 10);
        } else if (cmd.equalsIgnoreCase("egg")) {
            turtle.paint();
        } else if (cmd.equalsIgnoreCase("right")) {
            turtle.turn(arg / 45);
        } else if (cmd.equalsIgnoreCase("left")) {
            turtle.turn(-(arg / 45));
        } else {
            System.out.println("Invalid command: " + cmd + " " + arg);
        }
    }

    private void lineOfEggs(int steps) {
        turtle.paint();
        turtle.draw(steps - 1);
    }

}
