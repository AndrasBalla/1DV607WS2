package controller;

import model.Data;
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Database {
    private static final String FILE_NAME = "src/controller/members.xml";

    /**
     * Method to load in the content of the database file.
     * @return Object Data.
     */
    public Data readXml(){
        try{
            JAXBContext context = JAXBContext.newInstance(Data.class);
            Unmarshaller un = context.createUnmarshaller();
            Data temp = (Data) un.unmarshal(new File(FILE_NAME));
            return temp;
        } catch(JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Takes the object data and updates the file accordingly.
     * @param data
     */
    public void writeXml(Data data){
        try {
            JAXBContext context = JAXBContext.newInstance(Data.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Write to System.out for debugging
            //m.marshal(data, System.out);

            // Write to File
            m.marshal(data, new File(FILE_NAME));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
