package model;

import java.util.ArrayList;

public class Member {

    private String m_name;
    private ArrayList<Boat> m_boats;
    private String m_memberID;
    private String m_personalNumber;

    public Member(String name, String memberID, String personalNumber) {
        this.m_name = name;
        this.m_memberID = memberID;
        this.m_personalNumber = personalNumber;
        m_boats = new ArrayList<Boat>();
    }


    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public ArrayList<Boat> getM_boats() {
        return m_boats;
    }

    public void setM_boats(ArrayList<Boat> m_boats) {
        this.m_boats = m_boats;
    }

    public String getM_memberID() {
        return m_memberID;
    }

    public void setM_memberID(String m_memberID) {
        this.m_memberID = m_memberID;
    }

    public String getM_personalNumber() {
        return m_personalNumber;
    }

    public void setM_personalNumber(String m_personalNumber) {
        this.m_personalNumber = m_personalNumber;
    }

    @Override
    public String toString() {
        return "MemberID: " + this.m_memberID + "\nName: " + this.m_name + "\nPersonalNumber: " + m_personalNumber;
    }
}

