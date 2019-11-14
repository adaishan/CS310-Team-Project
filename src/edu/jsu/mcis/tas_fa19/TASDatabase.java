package edu.jsu.mcis.tas_fa19;

import java.sql.*;
import java.util.HashMap;

public class TASDatabase {
    
    private Connection conn;
    
    public TASDatabase() {
        
        try {
            
                
            String url = ("jdbc:mysql://localhost/tas");
            String username = ("root");
            String password = ("CS488");
            
            System.out.println("Connectiing to " + url + "...");
            
            /* Load the MySQL JDBC Driver */
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            conn = DriverManager.getConnection(url, username, password);
            
            /* Open Connection */
            
            if (conn.isValid(0)) {
                
                /* Connection Open! */
                
                System.out.println("Connected Successfully!");
                
            }
            
        }
        
        catch (Exception e) { e.printStackTrace(); }
        
    }
    
    public void close() throws SQLException {
    
        conn.close();

        System.out.println("Connection Closed!");    
        
    }
    
    public Badge getBadge(String badgeid) {
        
        boolean hasresults;
        String query;
        ResultSet resultset = null;
        PreparedStatement ps = null;
        
        String description = null;
        
        try {
            
            query = "SELECT * FROM badge WHERE id = ?";
            ps = conn.prepareStatement(query);
            
            ps.setString(1,badgeid);
            
            hasresults = ps.execute();
            
            if(hasresults) {
                
                resultset= ps.getResultSet();
                
                while(resultset.next()) {
                    description = resultset.getString("description");
                }
                
            }
            
        }
        
        catch(Exception e) { System.err.println(e.toString()); }
      
        Badge b = new Badge(badgeid, description);
        
        return b;
        
    }
    
    public Punch getPunch(int id) {
        
        Punch p = null;
        
        try {
            
            String query = "SELECT *, UNIX_TIMESTAMP(originaltimestamp) * 1000 AS ts FROM punch WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, id);
            
            boolean hasresults = ps.execute();
            
            if(hasresults) {
                
                ResultSet resultset = ps.getResultSet();
                
                if (resultset.next()) {
                    
                    HashMap<String, String> params = new HashMap<>();
                    
                    params.put("id", String.valueOf(id));
                    params.put("badgeid", resultset.getString("badgeid"));
                    params.put("terminalid", String.valueOf(resultset.getInt("terminalid")));
                    params.put("punchtypeid", String.valueOf(resultset.getInt("punchtypeid")));
                    params.put("ts", String.valueOf(resultset.getLong("ts")));
                    
                    p = new Punch(params);
                    
                }
                
                resultset.close();
                
            }
            
            ps.close();
            
        }
        catch (Exception e) { e.printStackTrace(); }
        
        return p;
        
    }
    
     public Shift getShift(int shiftid) {
        Shift s = null;
        
        // i made the hashmap like the one for badge
        try {
        
         HashMap<String, String> parameters = new HashMap<>();
                    
                    parameters.put("id", String.valueOf(resultset.getInt("id")));
                    parameters.put("description", resultset.getString("description"));
                    parameters.put("start", String.valueOf(resultset.getInt("start")));
                    parameters.put("stop", String.valueOf(resultset.getInt("stop")));
                    parameters.put("lunchstart", String.valueOf(resultset.getInt("lunchstart")));
                    parameters.put("lunchstop", String.valueOf(resultset.getInt("lunchstop")));
                    parameters.put("interval", String.valueOf(resultset.getInt("interval")));
                    parameters.put("graceperiod", String.valueOf(resultset.getInt("graceperiod")));
                    parameters.put("dock", String.valueOf(resultset.getInt("dock")));
                    parameters.put("lunchdeduct", String.valueOf(resultset.getInt("lunchdeduct")));
                    
                    s = new Shift (params);
                            }
        catch (Exception e) { e.printStackTrace(); }
        
        return s;
    }
       
     
    public Shift getShift(Badge b) {
        Shift s = null;
        return s;
    }
    
}