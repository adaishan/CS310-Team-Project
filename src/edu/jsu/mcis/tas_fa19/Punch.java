package edu.jsu.mcis.tas_fa19;
import java.util.*;
import java.text.*;
/**
 *
 * @author Matthew
 */
public class Punch {
    
    private int ID;
    private String badgeID;
    private int terminalID;
    private int punch_typeID;
    private GregorianCalendar original_time_stamp = new GregorianCalendar();

    public int getID() {
        return ID;
    }

    public String getBadgeID() {
        return badgeID;
    }

    public int getTerminalID() {
        return terminalID;
    }

    public int getPunch_typeID() {
        return punch_typeID;
    }

    public GregorianCalendar getOriginal_time_stamp() {
        return original_time_stamp;
    }
    
    public String toString(){

        //("#12565C60 (Chapman, Joshua E)"
        StringBuilder s = new StringBuilder();
        s.append("#");
        s.append(ID);
        s.append(" (");
        s.append(terminalID);
        s.append(")");
        s.append(badgeID);
        s.append(original_time_stamp);
        s.append(punch_typeID);
        return s.toString();
        
        

    }
    
    }
    
