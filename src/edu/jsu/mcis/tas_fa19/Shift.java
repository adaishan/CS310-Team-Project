package edu.jsu.mcis.tas_fa19;

import java.time.LocalTime;

public class Shift {
    
    private int id;
    private String description;
    private LocalTime start;
    private LocalTime stop;
    private int shiftduration;
    private int interval;
    private int graceperiod;
    private int dock;
    private LocalTime lunchstart;
    private LocalTime lunchstop;
    private int lunchdeduct;
    private int lunchduration;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getStop() {
        return stop;
    }
    
    public int shiftduration() {
        return shiftduration;
    }

    public int getInterval() {
        return interval;
    }

    public int getGraceperiod() {
        return graceperiod;
    }

    public int getDock() {
        return dock;
    }

    public LocalTime getLunchstart() {
        return lunchstart;
    }

    public LocalTime getLunchstop() {
        return lunchstop;
    }

    public int getLunchdeduct() {
        return lunchdeduct;
    }

    public int getLunchduration() {
        return lunchduration;
    }
   
    
    public Shift(int id, String description, LocalTime start, LocalTime stop, int shiftduration, int interval, int graceperiod, int dock, LocalTime lunchstart, LocalTime lunchstop, int lunchdeduct, int lunchduration) {
        this.id = id;
        this.description = description;
        this.start = start;
        this.stop = stop;
        this.shiftduration = shiftduration;
        this.interval = interval;
        this.graceperiod = graceperiod;
        this.dock = dock;
        this.lunchstart = lunchstart;
        this.lunchstop = lunchstop;
        this.lunchdeduct = lunchdeduct;
        this.lunchduration = lunchduration;
    }
    
    //assertEquals("Shift 1: 07:00 - 15:30 (510 minutes); Lunch: 12:00 - 12:30 (30 minutes)", s1.toString());
    
    public String toString(){
        
    StringBuilder s = new StringBuilder();
    s.append (description);
    s.append (": ");
    s.append (start);
    s.append (" - ");
    s.append (stop);
    s.append (" (");
    s.append (shiftduration);
    s.append (" minutes");
    s.append (") ");
    s.append ("; ");
    s.append ("Lunch: ");
    s.append (lunchstart);
    s.append (" - ");
    s.append (lunchstop);
    s.append (" (");
    s.append (lunchduration);
    s.append (" minutes");
    s.append (") ");
    return s.toString();
        
    }
}