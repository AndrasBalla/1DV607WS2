package controller;
import model.Boat;
import model.Data;
import model.Member;
import view.Console;

import java.util.UUID;

public class Controller {

    public void Show(Console a_view, Data a_data) {
        while(1==1){
        int menuNumber = a_view.presentMainMenu();

        if(menuNumber == 1) {
            String name = a_view.presentAddName();
            String personalNumber = a_view.presentAddPersonalNumber();
            System.out.println(name + " " + personalNumber);
            String uniqueID = UUID.randomUUID().toString();

            Member member = new Member(name, uniqueID, personalNumber);
            System.out.println(member.toString());
            a_data.addMember(member);
            Member testMember = new Member("Andras","", "900923-2354");
            Boat testBoat = new Boat("A","b",2,"m");
            Boat testBoatTwo = new Boat("A","b",2,"m");
            testMember.addBoat(testBoat);
            testMember.addBoat(testBoatTwo);
            a_data.addMember(testMember);
            Database test = new Database();
            test.writeXml(a_data);
            test.readXml();

        }

            if(menuNumber == 4) {

            a_data.getMembers().forEach(System.out::println);

            }


        }
    }
}