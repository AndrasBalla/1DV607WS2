package view;

import model.Member;

import java.util.ArrayList;
import java.util.Scanner;

public class Console {

    String[] menuItems = {"add user", "add boat"};

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
        System.out.println("4. View member compact");
        System.out.println("5. View members verbose");
        System.out.println("6. Register boat");
        System.out.println("7. Delete boat");
        System.out.println("8. Change boat");
        int menuAlternative = in.nextInt();
        return menuAlternative;
    }

    public String presentAddName() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter member name:");
        String name = in.nextLine();
        return name;
    }

    public String presentAddPersonalNumber() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter members personal number/n use the following format YYMMDD-XXXX");
        String personalNumber = in.next();
        return personalNumber;
    }

    public boolean wantsToQuit() {
        return GetInputChar() == 'q';
    }

    public void presentMembers(ArrayList<Member> members) {
        //members.forEach(System.out::println);
        System.out.println("Members:");
        for (int i = 0; i < members.size(); i++) {
            System.out.println(i + 1 + ". " + members.get(i).getM_name() + " " + members.get(i).getM_personalNumber() + " MemberID: " + members.get(i).getM_memberID() + " Boats: " + members.get(i).getM_boats().size());
        }
        System.out.println("---------------------------------------------");
    }

    public int presentDeleteMember() {
        System.out.println("Choose a user to delete by entering the corresponding number:");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public int presentChangeMember() {
        System.out.println("Choose a member to change by entering the corresponding number:");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public int presentRegisterBoat() {
        System.out.println("Choose a member to register boat for by entering the corresponding number:");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public String presentAddBoatName() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter boat name:");
        String name = in.nextLine();
        return name;
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

    public void presentMembersVerbose(ArrayList<Member> members) {
        System.out.println("Members:");
        for (int i = 0; i < members.size(); i++) {
            System.out.println(i + 1 + ". " + members.get(i).getM_name() + " " + members.get(i).getM_personalNumber() + " " + members.get(i).getM_memberID() + "Boats: " + members.get(i).getM_boats().size());
            for (int j = 0; j < members.get(i).getM_boats().size(); j++) {
                System.out.println(members.get(i).getM_boats().get(j));
            }
        }
        System.out.println("---------------------------------------------");

    }
}