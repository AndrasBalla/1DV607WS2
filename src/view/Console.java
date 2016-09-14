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

    Scanner in = new Scanner(System.in);

    public int presentMainMenu() {
        System.out.println("1. add member");
        int menuAlternative = in.nextInt();
        return menuAlternative;
    }

    public String presentAddUser() {
        System.out.println("First Name");
        String firstName = in.next();
        return firstName;
    }

    public boolean wantsToQuit() {
        return GetInputChar() == 'q';
    }
}