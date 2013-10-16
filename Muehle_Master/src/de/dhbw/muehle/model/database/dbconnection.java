package de.dhbw.muehle.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class dbconnection {
	Connection c;
	Statement stmt;
	
	public dbconnection(){
		 Connection c = null;
		 Statement stmt = null;
	}
	
	//Verbindung zur Datenbank aufbauen
		public void databaseconnection(){
		      try {
				Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection("jdbc:sqlite:res/FallstudieMuehle.db");
				  System.out.println("Opened database successfully");
			} catch ( Exception e ) {
			      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			      System.exit(0);
			}
		      
		}
		
// In die Datenbank schreiben
		public void databasewrite(String Name, String posAlt, String posNeu){
			try{
				String sql = "INSERT INTO MUEHLESPIELZUGPROTOKOLL (NAME, POSALT, POSNEU, DATUM) VALUES(?,?,?,?)";
				PreparedStatement stmt = c.prepareStatement(sql);
				stmt.setString(1, Name);
				stmt.setString(2, posAlt);
				stmt.setString(3, posNeu);
				stmt.setDate(4, new java.sql.Date( System.currentTimeMillis() ));	
				stmt.executeUpdate();

			} catch ( Exception e ) {
			      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			      System.exit(0);
			}
		}
	//Aus der Datenbank lesen	
		public void databaseread(){
			try{
				stmt = c.createStatement();
			 ResultSet rs = stmt.executeQuery( "SELECT * FROM MUEHLESPIELZUGPROTOKOLL;" );
		      while ( rs.next() ) {
		    	  int ZugId = rs.getInt("ZugID");
			         String  Spielername = rs.getString("NAME");
			         String  Spielposition_alt = rs.getString("POSALT");
			         String  Spielposition_neu = rs.getString("POSNEU");
			         Date Datum = rs.getDate("DATUM");
			         System.out.println( "ZUGID = " + ZugId );
			         System.out.println( "Spielername = " + Spielername );
			         System.out.println( "Position Alt = " + Spielposition_alt );
			         System.out.println( "Position Neu = " + Spielposition_neu );
			         System.out.println( "Datum = " + Datum );
			         System.out.println();
		      }
		      rs.close();
			} catch ( Exception e ) {
			      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			      System.exit(0);
			}
		}
		//Datenbank schlieﬂen	
		
		public void databaseclose(){
			try {
				stmt.close();
				c.close();
			} catch ( Exception e ) {
			      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			      System.exit(0);
			}
		      
			
		}

}
