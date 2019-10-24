package edu.jsu.mcis.tas_fa19;

public class Badge {
    
    private String id;
    private String description;

    public Badge(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
    
    public String toString(){
        
        //("#12565C60 (Chapman, Joshua E)"
        StringBuilder s = new StringBuilder();
        s.append("#");
        s.append(id);
        s.append(" (");
        s.append(description);
        s.append(")");
        return s.toString();
        
    }
    
}
