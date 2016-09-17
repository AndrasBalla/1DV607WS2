package controller;
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

        }

            if(menuNumber == 4) {

            a_data.getMembers().forEach(System.out::println);

            }


        }
    }
}