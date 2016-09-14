package model;

public class Boat {

    private String m_boatName;
    private String m_boatType;
    private int m_length;
    private String m_lengthUnit;

    public Boat(String m_boatName, String m_boatType, int m_length, int m_lengthUnit) {
        this.m_boatName = m_boatName;
        this.m_boatType = m_boatType;
        this.m_length = m_length;
        this.m_lengthUnit = m_lengthUnit;
    }

    public String getM_boatName() {
        return m_boatName;
    }

    public void setM_boatName(String m_boatName) {
        this.m_boatName = m_boatName;
    }

    public int getM_length() {
        return m_length;
    }

    public void setM_length(int m_length) {
        this.m_length = m_length;
    }

    public int getM_lengthUnit() {
        return m_lengthUnit;
    }

    public void setM_lengthUnit(int m_lengthUnit) {
        if (m_lengthUnit.eEquals("m" || "f")) {
            this.m_lengthUnit = m_lengthUnit;
        } else {
            this.m_lengthUnit = "undefined";
        }
    }
}

