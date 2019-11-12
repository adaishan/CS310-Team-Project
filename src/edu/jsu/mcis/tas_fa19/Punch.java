package edu.jsu.mcis.tas_fa19;
import java.sql.Timestamp;
import java.util.*;
import java.text.*;
/**
 *
 * @author Matthew
 */
public class Punch {
    
    public final String[] punchtypes = new String[]{"Clocked Out", "Clocked In", "Timed Out"};
    
    private int id;
    private String badgeid;
    private int terminalid;
    private int punchtypeid;
    private long originaltimestamp;
    private long adjustedtimestamp;

    public Punch(HashMap<String, String> params) {
        
        this.id = Integer.parseInt(params.get("id"));
        this.terminalid = Integer.parseInt(params.get("terminalid"));
        this.punchtypeid = Integer.parseInt(params.get("punchtypeid"));
        this.badgeid = params.get("badgeid");
        
        this.originaltimestamp = Long.parseLong(params.get("ts"));
        this.adjustedtimestamp = Long.parseLong(params.get("ts"));
        
    }
    
    Punch(Badge badge, int terminalid, int punchtypeid) {
        
        this.badgeid = badge.getId();
        this.terminalid = terminalid;
        this.punchtypeid = punchtypeid;
        
        GregorianCalendar gc = new GregorianCalendar();
        this.originaltimestamp = gc.getTimeInMillis();
        this.adjustedtimestamp = gc.getTimeInMillis();
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBadgeid() {
        return badgeid;
    }

    public void setBadgeid(String badgeid) {
        this.badgeid = badgeid;
    }

    public int getTerminalid() {
        return terminalid;
    }

    public void setTerminalid(int terminalid) {
        this.terminalid = terminalid;
    }

    public int getPunchtypeid() {
        return punchtypeid;
    }

    public void setPunchtypeid(int punchtypeid) {
        this.punchtypeid = punchtypeid;
    }

    public long getOriginaltimestamp() {
        return originaltimestamp;
    }

    public void setOriginaltimestamp(long originaltimestamp) {
        this.originaltimestamp = originaltimestamp;
    }

    
    
    public String printOriginalTimestamp() {
        
        String result = "";

        //"#D2C39273 CLOCKED IN: WED 09/05/2018 07:00:07"
        StringBuilder s = new StringBuilder();
        SimpleDateFormat format = new SimpleDateFormat("EEE MM/dd/yyyy HH:mm:ss");
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(originaltimestamp);
        s.append("#");
        s.append(badgeid);
        s.append(" ").append(punchtypes[punchtypeid]);
        s.append(": ");
        s.append(format.format(gc.getTime()));
        
        result = s.toString().toUpperCase();
        
        System.err.println(result);
        
        return result;
        
       
    }
    
}