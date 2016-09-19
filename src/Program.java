import controller.Controller;
import model.Data;
import view.Console;

public class Program {
    public static void main(String[] a_args) {

        Controller m = new Controller();
        Console v = new Console();
        Data d = new Data();


        m.Show(v, d);

    }
}