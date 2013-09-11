package de.dhbw.muehle.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;



import org.joda.time.DateTime;

/** Die Log Klasse schreibt Meldungen aus der Konsole in eine Textdatei.
 * Hier wird sp�ter die Fehlerbehebnung stattfinden.
 * @author Kreistschen
 *
 */
	
	public class Log {

		public Log(){
			
		}
		
		public static void log(String message, String classname){
			DateTime date = new DateTime();
			String logMessage = classname + ": " + date.toString()  + ": " + message + "\n";
			System.out.println(logMessage);
			writeout(logMessage);
		}
		
		private static void writeout(String str){
			BufferedWriter writer;
			try {
				writer = new BufferedWriter(new FileWriter("res/Logfile.txt", true));
				writer.write(str);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

