package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by fredr on 17/09/2016.
 */
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

    public void deleteMember(Member member) {
        members.remove(member);
    }
    @XmlAttribute
    public int getCount() {return count;}

    public void setCount(int count) {this.count = count;}

}

