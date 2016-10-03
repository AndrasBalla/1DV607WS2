package controller;

import model.Boat;
import model.Data;
import model.Member;
import view.Console;

public class Controller {

    public void Show(Console a_view, Data a_data) {
        while (1 == 1) {
            int menuNumber = a_view.presentMainMenu();
            Database database = new Database();
            ErrorHandling check = new ErrorHandling();
            //Load in Array from the xml file.
            a_data = database.readXml();

            if (menuNumber == 1) {
                String name = a_view.presentAddName("");
                while (check.checkName(name)){
                    name = a_view.presentAddName("Please provide a name.");
                }
                String personalNumber = a_view.presentAddPersonalNumber("");
                while (!(check.checkPnr(personalNumber))){
                    personalNumber = a_view.presentAddPersonalNumber("Please enter a valid personal number");
                }
                a_data.addMember(name, personalNumber);
                database.writeXml(a_data);
            }
            if (menuNumber == 2) {
                Member memberToDelete = a_view.presentDeleteMember(a_data.getMembers());
                a_data.deleteMember(memberToDelete);
                database.writeXml(a_data);
            }
            if (menuNumber == 3) {
                Member memberToChange = a_view.presentChangeMember(a_data.getMembers());
                String name = a_view.presentAddName("");
                while (check.checkName(name)){
                    name = a_view.presentAddName("Please provide a name.");
                }
                String personalNumber = a_view.presentAddPersonalNumber("");
                while (!(check.checkPnr(personalNumber))){
                    personalNumber = a_view.presentAddPersonalNumber("Please enter a valid personal number");
                }
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
                Member memberToView = a_view.presentViewMember(a_data.getMembers());
                a_view.presentMemberVerbose(memberToView);
            }

            if (menuNumber == 7) {
                Member memberToAddBoatTo = a_view.presentRegisterBoat(a_data.getMembers());
                String boatName = a_view.presentAddBoatName();
                while (check.checkName(boatName)){
                    boatName = a_view.presentAddName("Please provide a boat name.");
                }
                String boatType = a_view.presentAddBoatType();
                while (check.checkName(boatType)){
                    boatType = a_view.presentAddName("Please provide a boat type.");
                }
                String boatLength = a_view.presentAddBoatLength();
                a_data.addBoat(memberToAddBoatTo, boatName, boatLength, boatType);
                database.writeXml(a_data);
            }
            if (menuNumber == 8) {
                Member memberToDeleteBoatFrom = a_view.presentMemberToDeleteBoatFrom(a_data.getMembers());
                Boat boatToDelete = a_view.presentDeleteBoat(memberToDeleteBoatFrom);
                a_data.deleteBoat(memberToDeleteBoatFrom, boatToDelete);
                database.writeXml(a_data);
            }
            if (menuNumber == 9) {
                Member memberToChangeBoatOn = a_view.presentMemberToChangeBoatOn(a_data.getMembers());
                Boat boatToChange = a_view.presentChangeBoat(memberToChangeBoatOn);
                String boatName = a_view.presentAddBoatName();
                String boatType = a_view.presentAddBoatType();
                String boatLength = a_view.presentAddBoatLength();
                a_data.changeBoat(memberToChangeBoatOn, boatToChange, boatName, boatLength, boatType);
                database.writeXml(a_data);
            }
        }
    }
}