package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "boat")
@XmlType(propOrder = {"m_boatName", "m_boatType", "m_length", "m_lengthUnit"})
public class Boat {

    private String m_boatName;
    private String m_boatType;
    private int m_length;
    private String m_lengthUnit;

    public Boat(String m_boatName, String m_boatType, int m_length, String m_lengthUnit) {
        this.m_boatName = m_boatName;
        this.m_boatType = m_boatType;
        this.m_length = m_length;
        this.m_lengthUnit = m_lengthUnit;
    }

    public Boat(){}

    public String getM_boatName() {
        return m_boatName;
    }
    @XmlElement
    public void setM_boatName(String m_boatName) {
        this.m_boatName = m_boatName;
    }

    public String getM_boatType() {return m_boatType;}
    @XmlElement
    public void setM_boatType(String m_boatType) {this.m_boatType = m_boatType;}

    public int getM_length() {
        return m_length;
    }
    @XmlElement
    public void setM_length(int m_length) {
        this.m_length = m_length;
    }

    public String getM_lengthUnit() {
        return m_lengthUnit;
    }
    @XmlElement
    public void setM_lengthUnit(String m_lengthUnit) {
        if (m_lengthUnit.equals("m")||m_lengthUnit.equals("f")) {
            this.m_lengthUnit = m_lengthUnit;
        } else {
            this.m_lengthUnit = "undefined";
        }
    }
}

