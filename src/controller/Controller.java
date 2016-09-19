package controller;

import model.Data;
import view.Console;

public class Controller {

    public void Show(Console a_view, Data a_data) {
        while (1 == 1) {
            int menuNumber = a_view.presentMainMenu();
            Database database = new Database();
            //Load in Array from the xml file.
            a_data = database.readXml();

            if (menuNumber == 1) {
                String name = a_view.presentAddName();
                String personalNumber = a_view.presentAddPersonalNumber();
                a_data.addMember(name, personalNumber);
                database.writeXml(a_data);
            }
            if (menuNumber == 2) {
                a_view.presentMembers(a_data.getMembers());
                int memberToDelete = a_view.presentDeleteMember();
                a_data.deleteMember(memberToDelete - 1);
                database.writeXml(a_data);
            }
            if (menuNumber == 3) {
                a_view.presentMembers(a_data.getMembers());
                int memberToChange = a_view.presentChangeMember();
                String name = a_view.presentAddName();
                String personalNumber = a_view.presentAddPersonalNumber();
                a_data.changeMember(memberToChange, name, personalNumber);
                database.writeXml(a_data);
            }
            if (menuNumber == 4) {
                a_view.presentMembers(a_data.getMembers());
            }
        }
    }
}