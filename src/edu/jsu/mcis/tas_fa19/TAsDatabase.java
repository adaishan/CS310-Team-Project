package edu.jsu.mcis.tas_fa19;

import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TAsDatabase {
    
    Connection conn;
    
    String url = ("jdbc:mysql://localhost/tas");
    String username = ("root");
    String password = ("CS310");
    
    PreparedStatement pstSelect = null, pstUpdate = null;
    ResultSet resultest = null;
    ResultSetMetaData metadata = null;
    
    String query, key, value;
    
    boolean harresults;
    int resultCount, columnCount, undateCount = 0;
    
    public TAsDatabase() {
        
        try {
            
            System.out.println("Connectiing to " + url + "...");
            
            /* Load the MySQL JDBC Driver */
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            Connection conn = DriverManager.getConnection(url, username, password);
            
            /* Open Connection */
            
            if (conn.isValid(0)) {
                
                /* Connection Open! */
                
                System.out.println("Connected Successfully!");
                
            }
            
        }
        
        catch (Exception e) {
            
            System.err.println(e.toString());
            
        }
        
    }
    
    public void close() throws SQLException {
    
            conn.close();
            
            System.out.println("Connection Closed!");    
        
    }
    
    public Badge getBadge(String badgeid) throws SQLException {
        
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
    
    public Punch getPunch(int punchid) {
        Punch p = null;
        return p;
    }
    
     public Shift getShift(int shiftid) {
        Shift s = null;
        return s;
    }
     
    public Shift getShift(Badge b) {
        Shift s = null;
        return s;
    }
}