package controller;
import view.Console;

public class Controller {

    public void Show(Console a_view) {

        int menuLineNumber = a_view.presentMainMenu();

        if (menuLineNumber == 1) {
            a_view.presentAddUser();
        }



    }
}