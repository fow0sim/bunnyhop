package eu.simmig.bunnyhop;

public class BunnyHopApplication {
    public static void main(String args[]) {
        final BunnyHopScreen screen = new BunnyHopScreen();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                screen.run();
            }
        });
    }

/*
    public static void main(String args[]) {
        BunnyHopParser parser = new BunnyHopParser();
        parser.parse("bunnyhop.txt");
        parser.plot();
    }
*/

}
