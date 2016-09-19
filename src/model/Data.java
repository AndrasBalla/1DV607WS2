package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "data")
public class Data {
    private ArrayList<Member> members = new ArrayList<Member>();
    private int count = 0;

    public ArrayList<Member> getMembers() {
        return members;
    }

    @XmlElement(name = "member")
    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public void addMember(Member member) {
        this.members.add(member);
    }

    public void addMember(String name, String personalNumber) {
        Member member = new Member(name, this.getCount(), personalNumber);
        this.members.add(member);
        this.setCount(this.getCount() + 1);
    }

    public void deleteMember(int memberToDelete) {
        this.members.remove(memberToDelete);
    }

    public void changeMember(int memberToChange, String name, String personalNumber) {
        this.members.get(memberToChange - 1).setM_name(name);
        this.members.get(memberToChange - 1).setM_personalNumber(personalNumber);
    }
    @XmlAttribute
    public int getCount() {return count;}

    public void setCount(int count) {this.count = count;}

    public void addBoat(int memberToAddBoatTo, String boatName, int boatLength, String boatLengthUnit, String boatType) {
        Member member = this.members.get(memberToAddBoatTo - 1);
        Boat boat = new Boat(boatName, boatType, boatLength, boatLengthUnit);
        member.addBoat(boat);
    }
}

