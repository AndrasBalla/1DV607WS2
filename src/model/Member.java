package model;

import java.util.ArrayList;

public class Member {

    private String m_firstName;
    private String m_lastName;
    private ArrayList<Boat> boats;
    private int memberID;
    private int personalNumber;

    public Member(String m_firstName, String m_lastName, int memberID, int personalNumber) {
        this.m_firstName = m_firstName;
        this.m_lastName = m_lastName;
        this.boats = new ArrayList<>();
        this.memberID = memberID;
        this.personalNumber = personalNumber;
    }

    public Member(){}

    public String getM_firstName() {
        return m_firstName;
    }

    public void setM_firstName(String m_firstName) {
        this.m_firstName = m_firstName;
    }

    public String getM_lastName() {
        return m_lastName;
    }

    public void setM_lastName(String m_lastName) {
        this.m_lastName = m_lastName;
    }

    public ArrayList getBoats() {
        return boats;
    }

    public void setBoats(ArrayList<Boat> boats) {
        this.boats = boats;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public int getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(int personalNumber) {
        this.personalNumber = personalNumber;
    }

    public void addBoat(Boat boat) {
        this.boats.add(boat);
    }

}

