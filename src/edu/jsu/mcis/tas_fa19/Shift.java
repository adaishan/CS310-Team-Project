package edu.jsu.mcis.tas_fa19;

import java.time.LocalTime;
import java.util.HashMap;
import java.sql.Time;
import java.time.temporal.ChronoUnit;

public class Shift {
    
    private int id, interval, graceperiod, lunchdeduct, dock;
    private String description;
    private LocalTime start, stop, lunchstart, lunchstop;

    
    public Shift(HashMap<String, Object> params) {
        
        this.id = Integer.parseInt((String)params.get("id"));
        this.interval = Integer.parseInt((String)params.get("interval"));
        this.graceperiod = Integer.parseInt((String)params.get("graceperiod"));
        this.dock = Integer.parseInt((String)params.get("dock"));
        this.lunchdeduct = Integer.parseInt((String)params.get("lunchdeduct"));
        
        this.start = ((Time)params.get("start")).toLocalTime();
        this.stop = ((Time)params.get("stop")).toLocalTime();
        this.lunchstart = ((Time)params.get("lunchstart")).toLocalTime();
        this.lunchstop = ((Time)params.get("lunchstop")).toLocalTime();
        
        this.description = (String)params.get("description");
        
        
    }
    
    //assertEquals("Shift 1: 07:00 - 15:30 (510 minutes); Lunch: 12:00 - 12:30 (30 minutes)", s1.toString());
    
    public String toString() {
        
        // "Shift 1: 07:00 - 15:30 (510 minutes); Lunch: 12:00 - 12:30 (30 minutes)"
        
        StringBuilder s = new StringBuilder();
        s.append (description);
        s.append (": ");
        s.append (String.format("%02d", start.getHour())).append(":").append(String.format("%02d", start.getMinute()));
        s.append (" - ");
        s.append (String.format("%02d", stop.getHour())).append(":").append(String.format("%02d", stop.getMinute()));
        s.append (" (");
        s.append ( ChronoUnit.MINUTES.between(start, stop) );
        s.append (" minutes").append (")").append("; ").append ("Lunch: ");
        s.append (String.format("%02d", lunchstart.getHour())).append(":").append(String.format("%02d", lunchstart.getMinute()));
        s.append (" - ");
        s.append (String.format("%02d", lunchstop.getHour())).append(":").append(String.format("%02d", lunchstop.getMinute()));
        s.append (" (");
        s.append ( ChronoUnit.MINUTES.between(lunchstart, lunchstop) );
        s.append (" minutes");
        s.append (")");
        
        return s.toString();
        
    }
}
