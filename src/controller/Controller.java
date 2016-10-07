package controller;

import model.Boat;
import model.Registry;
import model.Member;
import view.Console;

public class Controller {

    public void Show(Console a_view, Registry a_registry) {
        while (1 == 1) {
            int menuNumber = a_view.presentMainMenu();
            Database Database = new Database();
            ErrorHandling check = new ErrorHandling();
            //Load in Array from the xml file.
            a_registry = Database.readXml();

            if (menuNumber == 1) {
                String name = a_view.presentAddName();
                while (check.checkName(name)){
                    name = a_view.presentAddName();
                }
                String personalNumber = a_view.presentAddPersonalNumber();
                while (!(check.checkPnr(personalNumber))){
                    personalNumber = a_view.presentAddPersonalNumber();
                }
                a_registry.addMember(name, personalNumber);
                Database.writeXml(a_registry);
            }
            if (menuNumber == 2) {
                Member memberToDelete = a_view.presentDeleteMember(a_registry.getMembers());
                a_registry.deleteMember(memberToDelete);
                Database.writeXml(a_registry);
            }
            if (menuNumber == 3) {
                Member memberToChange = a_view.presentChangeMember(a_registry.getMembers());
                String name = a_view.presentAddName();
                while (check.checkName(name)){
                    name = a_view.presentAddName();
                }
                String personalNumber = a_view.presentAddPersonalNumber();
                while (!(check.checkPnr(personalNumber))){
                    personalNumber = a_view.presentAddPersonalNumber();
                }
                a_registry.changeMember(memberToChange, name, personalNumber);
                Database.writeXml(a_registry);
            }
            if (menuNumber == 4) {
                a_view.presentMembers(a_registry.getMembers());
            }

            if (menuNumber == 5) {
                a_view.presentMembersVerbose(a_registry.getMembers());
            }

            if (menuNumber == 6) {
                Member memberToView = a_view.presentViewMember(a_registry.getMembers());
                a_view.presentMemberVerbose(memberToView);
            }

            if (menuNumber == 7) {
                Member memberToAddBoatTo = a_view.presentRegisterBoat(a_registry.getMembers());
                String boatName = a_view.presentAddBoatName();
                while (check.checkName(boatName)){
                    boatName = a_view.presentAddName();
                }
                String boatType = a_view.presentAddBoatType();
                String boatLength = a_view.presentAddBoatLength();
                a_registry.addBoat(memberToAddBoatTo, boatName, boatLength, boatType);
                Database.writeXml(a_registry);
            }
            if (menuNumber == 8) {
                Member memberToDeleteBoatFrom = a_view.presentMemberToDeleteBoatFrom(a_registry.getMembers());
                Boat boatToDelete = a_view.presentDeleteBoat(memberToDeleteBoatFrom);
                a_registry.deleteBoat(memberToDeleteBoatFrom, boatToDelete);
                Database.writeXml(a_registry);
            }
            if (menuNumber == 9) {
                Member memberToChangeBoatOn = a_view.presentMemberToChangeBoatOn(a_registry.getMembers());
                Boat boatToChange = a_view.presentChangeBoat(memberToChangeBoatOn);
                String boatName = a_view.presentAddBoatName();
                String boatType = a_view.presentAddBoatType();
                String boatLength = a_view.presentAddBoatLength();
                a_registry.changeBoat(memberToChangeBoatOn, boatToChange, boatName, boatLength, boatType);
                Database.writeXml(a_registry);
            }
        }
    }
}