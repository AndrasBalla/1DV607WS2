package controller;

import model.Data;
import model.Member;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


/**
 * Created by Spiks on 17/09/2016.
 */
public class Database {
    private static final String FILE_NAME = "src/controller/members.xml";

    public Data readXml(){
        try{
            JAXBContext context = JAXBContext.newInstance(Data.class);
            Unmarshaller un = context.createUnmarshaller();
            System.out.println(this.getClass().getResource("/books.xml"));
            Data temp = (Data) un.unmarshal(new File(FILE_NAME));
            return temp;
        } catch(JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeXml(Data data){
        try {
            JAXBContext context = JAXBContext.newInstance(Data.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Write to System.out for debugging
            m.marshal(data, System.out);

            // Write to File
            m.marshal(data, new File(FILE_NAME));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
