package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import model.Slot;
import util.XLException;

//TODO move to another package
public class XLBufferedReader extends BufferedReader {
    public XLBufferedReader(String name) throws FileNotFoundException {
        super(new FileReader(name));
    }

    // TODO Change Object to something appropriate
    public void load(Map<String, Slot> map) {
        try {
            while (ready()) {
                String string = readLine();
                int i = string.indexOf('=');
                String address = string.substring(0, i);
                String data = string.substring(i+1, string.length());
                map.put(address, SlotFactory.build(data));
                
            }
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
    }
}
