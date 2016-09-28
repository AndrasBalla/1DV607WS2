package view;

import controller.ErrorHandling;
import model.Boat;
import model.Member;

import java.util.ArrayList;
import java.util.Scanner;

public class Console {

    private ErrorHandling error = new ErrorHandling();
    private Scanner in = new Scanner(System.in);
    private int input;


    public int presentMainMenu() {
        System.out.println("1. Add member");
        System.out.println("2. Delete member");
        System.out.println("3. Change member");
        System.out.println("4. View members compact");
        System.out.println("5. View members verbose");
        System.out.println("6. View member");
        System.out.println("7. Register boat");
        System.out.println("8. Delete boat");
        System.out.println("9. Change boat");
        String menuAlternative = in.nextLine();
        if (isInteger(menuAlternative, 9)){
            return input;
        }else {
            System.out.println("Please provide a Integer.");
            presentMainMenu();
        }

        return 0;
    }

    //Add member functions

    public String presentAddName() {
        //Scanner in = new Scanner(System.in);
        System.out.println("Enter member name:");
        String name = in.nextLine();
        System.out.println(name);
        if (error.checkName(name)){
            return name;
        }else {
            System.out.println("Please provide a name.");
            presentAddName();
        }
        return null;
    }

    public String presentAddPersonalNumber() {
        //Scanner in = new Scanner(System.in);
        System.out.println("Enter members personal number/n use the following format YYMMDD-XXXX");
        String personalNumber = in.nextLine();
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

    public Member presentDeleteMember(ArrayList<Member> members) {
        presentMembers(members);
        System.out.println("Choose a user to delete by entering the corresponding number:");
        String memberLine = in.nextLine();

        if (isInteger(memberLine, members.size())){
            return members.get(input - 1);
        }else {
            System.out.println("Please provide a Integer between 1 and " + members.size() + ".");
            presentChangeMember(members);
        }

        return null;
    }

    //Change member

    public Member presentChangeMember(ArrayList<Member> members) {
        presentMembers(members);
        System.out.println("Choose a member to change by entering the corresponding number:");
        String memberLine = in.nextLine();

        if (isInteger(memberLine, members.size())){
            return members.get(input - 1);
        }else {
            System.out.println("Please provide a Integer between 1 and " + members.size() + ".");
            presentChangeMember(members);
        }

        return null;
    }

    public Member presentViewMember(ArrayList<Member> members) {
        presentMembers(members);
        System.out.println("Choose a member to view by entering the corresponding number:");
        String memberLine = in.nextLine();

        if (isInteger(memberLine, members.size())){
            return members.get(input - 1);
        }else {
            System.out.println("Please provide a Integer between 1 and " + members.size() + ".");
            presentChangeMember(members);
        }

        return null;
    }

    //Register boat

    public Member presentRegisterBoat(ArrayList<Member> members) {
        presentMembers(members);
        System.out.println("Choose a member to register boat for by entering the corresponding number:");
        String memberLine = in.nextLine();

        if (isInteger(memberLine, members.size())){
            return members.get(input - 1);
        }else {
            System.out.println("Please provide a Integer between 1 and " + members.size() + ".");
            presentChangeMember(members);
        }

        return null;
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

    public Member presentMemberToDeleteBoatFrom(ArrayList<Member> members) {
        presentMembers(members);
        System.out.println("Choose a member to delete boat from by entering the corresponding number:");
        String memberLine = in.nextLine();

        if (isInteger(memberLine, members.size())){
            return members.get(input - 1);
        }else {
            System.out.println("Please provide a Integer between 1 and " + members.size() + ".");
            presentMemberToDeleteBoatFrom(members);
        }

        return null;
    }

    public Boat presentDeleteBoat(Member member) {
        presentMemberVerbose(member);
        System.out.println("Choose boat to delete by entering the corresponding number:");
        String memberLine = in.nextLine();

        if (isInteger(memberLine, member.getM_boats().size())){
            return member.getM_boats().get(input - 1);
        }else {
            System.out.println("Please provide a Integer between 1 and " + member.getM_boats().size() + ".");
            presentDeleteBoat(member);
        }

        return null;
    }

    //Change boat

    public Member presentMemberToChangeBoatOn(ArrayList<Member> members) {
        presentMembers(members);
        System.out.println("Choose a member to change boat on by entering the corresponding number:");
        String memberLine = in.nextLine();

        if (isInteger(memberLine, members.size())){
            return members.get(input - 1);
        }else {
            System.out.println("Please provide a Integer between 1 and " + members.size() + ".");
            presentMemberToDeleteBoatFrom(members);
        }

        return null;
    }

    public Boat presentChangeBoat(Member member) {
        presentMemberVerbose(member);
        System.out.println("Choose boat to change by entering the corresponding number:");
        String memberLine = in.nextLine();

        if (isInteger(memberLine, member.getM_boats().size())){
            return member.getM_boats().get(input - 1);
        }else {
            System.out.println("Please provide a Integer between 1 and " + member.getM_boats().size() + ".");
            presentDeleteBoat(member);
        }

        return null;
    }



    private boolean isInteger(String s, int max) {
        try {
            input = Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }

        return input > 0 && input <= max;
    }
}