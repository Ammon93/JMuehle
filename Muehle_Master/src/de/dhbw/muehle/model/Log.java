package de.dhbw.muehle.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;



import org.joda.time.DateTime;

/** Die Log Klasse schreibt Meldungen aus der Konsole in eine Textdatei.
 * Hier wird später die Fehlerbehebnung stattfinden.
 * @author Kreistschen
 *
 */
	
	public class Log {

		public Log(){
			
		}
		
		public static void log(String value, String classname){
			DateTime date = new DateTime();
			String newvalue = classname + ": " + date.toString()  + ": " + value + "\n";
			System.out.println(newvalue);
			writeout(newvalue);
		}
		
		private static void writeout(String value){
			BufferedWriter writer;
			try {
				writer = new BufferedWriter(new FileWriter("res/Logfile.txt", true));
				writer.write(value);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

