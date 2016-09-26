package view;

import controller.ErrorHandling;
import model.Member;

import java.util.ArrayList;
import java.util.Scanner;

public class Console {

    String[] menuItems = {"add user", "add boat"};
    ErrorHandling error = new ErrorHandling();

    private int GetInputChar() {
        try {
            int c = System.in.read();
            while (c == '\r' || c == '\n') {
                c = System.in.read();
            }
            return c;
        } catch (java.io.IOException e) {
            System.out.println("" + e);
            return 0;
        }
    }

    public int presentMainMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("1. Add member");
        System.out.println("2. Delete member");
        System.out.println("3. Change member");
        System.out.println("4. View members compact");
        System.out.println("5. View members verbose");
        System.out.println("6. View member");
        System.out.println("7. Register boat");
        System.out.println("8. Delete boat");
        System.out.println("9. Change boat");
        int menuAlternative = in.nextInt();
        return menuAlternative;
    }

    //Add member functions

    public String presentAddName() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter member name:");
        String name = in.nextLine();
        if (error.checkName(name)){
            return name;
        }else {
            System.out.println("Please provide a name.");
            presentAddName();
        }
        return null;
    }

    public String presentAddPersonalNumber() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter members personal number/n use the following format YYMMDD-XXXX");
        String personalNumber = in.next();
        if (error.checkPnr(personalNumber)) {
            return personalNumber;
        }else {
            System.out.println("Please enter a valid personal number");
            presentAddPersonalNumber();
        }
        return null;
    }

    //Show members

    public void presentMembers(ArrayList<Member> members) {
        //members.forEach(System.out::println);
        System.out.println("Members:");
        for (int i = 0; i < members.size(); i++) {
            System.out.println(i + 1 + ". " + members.get(i).getM_name() + " " + members.get(i).getM_personalNumber() + " MemberID: " + members.get(i).getM_memberID() + " Boats: " + members.get(i).getM_boats().size());
        }
        System.out.println("---------------------------------------------");
    }

    public void presentMembersVerbose(ArrayList<Member> members) {
        System.out.println("Members:");
        for (int i = 0; i < members.size(); i++) {
            System.out.println(i + 1 + ". " + members.get(i).getM_name() + " " + members.get(i).getM_personalNumber() + " MemberID: " + members.get(i).getM_memberID());
            for (int j = 0; j < members.get(i).getM_boats().size(); j++) {
                System.out.println("     " + (j + 1) + ". Name:" + members.get(i).getM_boats().get(j).getM_boatName());
                System.out.println("        Type:" + members.get(i).getM_boats().get(j).getM_boatType());
                System.out.println("        Length:" + members.get(i).getM_boats().get(j).getM_length() + " " + members.get(i).getM_boats().get(j).getM_lengthUnit());
            }
        }
        System.out.println("---------------------------------------------");
    }

    public void presentMemberVerbose(Member member) {
        System.out.println("Member:");
        System.out.println(member.getM_name() + " " + member.getM_personalNumber() + " " + member.getM_memberID() + "Boats: " + member.getM_boats().size());
        for (int j = 0; j < member.getM_boats().size(); j++) {
            System.out.println("     " + (j + 1) + ". Name:" + member.getM_boats().get(j).getM_boatName());
            System.out.println("        Type:" + member.getM_boats().get(j).getM_boatType());
            System.out.println("        Length:" + member.getM_boats().get(j).getM_length() + " " + member.getM_boats().get(j).getM_lengthUnit());
        }
        System.out.println("---------------------------------------------");
    }

    //Delete member

    public int presentDeleteMember() {
        System.out.println("Choose a user to delete by entering the corresponding number:");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    //Change member

    public int presentChangeMember() {
        System.out.println("Choose a member to change by entering the corresponding number:");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public int presentViewMember() {
        System.out.println("Choose a member to view by entering the corresponding number:");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    //Register boat

    public int presentRegisterBoat() {
        System.out.println("Choose a member to register boat for by entering the corresponding number:");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    //Register and change boat

    public String presentAddBoatName() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter boat name:");
        String name = in.nextLine();
        if (error.checkName(name)){
            return name;
        }else {
            System.out.println("Please provide a name.");
            presentAddBoatName();
        }
        return null;
    }

    public String presentAddBoatType() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose boat type");
        String type = in.nextLine();
        return type;
    }

    public int presentAddBoatLength() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Boat length:");
        int length = in.nextInt();
        return length;
    }

    public String presentAddBoatLengthUnit() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose unit to enter length in");
        String unit = in.nextLine();
        return unit;
    }

    //Delete boat

    public int presentDeleteBoat() {
        System.out.println("Choose boat to delete by entering the corresponding number:");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public int presentMemberToDeleteBoatFrom() {
        System.out.println("Choose a member to delete boat from by entering the corresponding number:");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    //Change boat

    public int presentChangeBoat() {
        System.out.println("Choose boat to change by entering the corresponding number:");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public int presentMemberToChangeBoatOn() {
        System.out.println("Choose a member to change boat on by entering the corresponding number:");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
}