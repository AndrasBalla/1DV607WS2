package model;

import java.util.ArrayList;

/**
 * Created by fredr on 17/09/2016.
 */
public class Data {
    private ArrayList<Member> members = new ArrayList<Member>();

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public void addMember(Member member) {
        this.members.add(member);
    }
}

