package controller;

import model.Data;
import model.Member;
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
                a_data.deleteMember(a_data.getMembers().get(memberToDelete - 1));
                database.writeXml(a_data);
            }
            if (menuNumber == 3) {
                Member memberToChange = a_view.presentChangeMember(a_data.getMembers());
                String name = a_view.presentAddName();
                String personalNumber = a_view.presentAddPersonalNumber();
                a_data.changeMember(memberToChange, name, personalNumber);
                database.writeXml(a_data);
            }
            if (menuNumber == 4) {
                a_view.presentMembers(a_data.getMembers());
            }

            if (menuNumber == 5) {
                a_view.presentMembersVerbose(a_data.getMembers());
            }

            if (menuNumber == 6) {
                a_view.presentMembers(a_data.getMembers());
                int memberToView = a_view.presentViewMember();
                a_view.presentMemberVerbose(a_data.getMembers().get(memberToView - 1));
            }

            if (menuNumber == 7) {
                a_view.presentMembers(a_data.getMembers());
                int memberToAddBoatTo = a_view.presentRegisterBoat();
                String boatName = a_view.presentAddBoatName();
                String boatType = a_view.presentAddBoatType();
                int boatLength = a_view.presentAddBoatLength();
                String boatLengthUnit = a_view.presentAddBoatLengthUnit();
                a_data.addBoat(memberToAddBoatTo, boatName, boatLength, boatLengthUnit, boatType);
                database.writeXml(a_data);
            }
            if (menuNumber == 8) {
                a_view.presentMembers(a_data.getMembers());
                int memberToDeleteBoatFrom = a_view.presentMemberToDeleteBoatFrom();
                a_view.presentMemberVerbose(a_data.getMembers().get(memberToDeleteBoatFrom-1));
                int boatToDelete = a_view.presentDeleteBoat();
                a_data.deleteBoat(memberToDeleteBoatFrom, boatToDelete);
                database.writeXml(a_data);
            }
            if (menuNumber == 9) {
                a_view.presentMembers(a_data.getMembers());
                int memberToChangeBoatOn = a_view.presentMemberToChangeBoatOn();
                a_view.presentMemberVerbose(a_data.getMembers().get(memberToChangeBoatOn-1));
                int boatToChange = a_view.presentChangeBoat();
                String boatName = a_view.presentAddBoatName();
                String boatType = a_view.presentAddBoatType();
                int boatLength = a_view.presentAddBoatLength();
                String boatLengthUnit = a_view.presentAddBoatLengthUnit();
                a_data.changeBoat(memberToChangeBoatOn, boatToChange, boatName, boatLength, boatLengthUnit, boatType);
                database.writeXml(a_data);
            }
        }
    }
}