import controller.Controller;
import view.Console;

public class Program {
    public static void main(String[] a_args) {

        Controller m = new Controller();
        Console v = new Console();
        //PlayGame c = new PlayGame();

        m.Show(v);

    }
}