package controller;
import view.Console;

public class Controller {

    public void Show(Console a_view) {

        int menuNumber = a_view.presentMainMenu();
        if(menuNumber == 1) {
            a_view.presentAddUser();
        }



    }
}