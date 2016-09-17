package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by fredr on 17/09/2016.
 */
@XmlRootElement(name = "catalog")
public class Data {
    private ArrayList<Member> members = new ArrayList<Member>();

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

    public void deleteMember(Member member) {
        members.remove(member);
    }
}

