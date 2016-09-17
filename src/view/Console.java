package view;

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
        System.out.println("4. View member");
        System.out.println("5. Register boat");
        System.out.println("6. Delete boat");
        System.out.println("7. Change boat");
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
}