package de.dhbw.muehle.model.theme;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;

/**
 * Diese Klasse stellt die Sounds der Themen und den dazugehörigen Player.
 * 
 * @author Ammon
 */
public class Sound implements BasicPlayerListener{
	
	private static BasicPlayer musicPlayer,
							   soundPlayer;
	
	private static String soundPfad;
	
	private static boolean fading,
						   fadingExt;
	private static boolean playing;
	
	
	/**
	 * Konstruktor
	 */
	public Sound() {		
		musicPlayer = new BasicPlayer();
		musicPlayer.setSleepTime(1);
		musicPlayer.addBasicPlayerListener(this);
		
		soundPlayer = new BasicPlayer();
	}
	
	
	
	/**
	 * Setzt die Enums auf das aktuelle Soundverzeichnis.
	 * 
	 * @param soundPfad
	 */
	private void setEnum(String soundPfad){
		for(Sounds snd : Sounds.values()){
			snd.setSoundVerzeichnis(soundPfad);
		}
	}
	
	
	/**
	 * Erzeugt einen Fade-Effekt für den Sound.
	 * 
	 * @param type String "in" oder "out"
	 */
	private void fade(final String type){
		fading = fadingExt = true;
		
		switch (type) {
		case "in":
			playing = true;
			
			try {
				musicPlayer.play();
				musicPlayer.setGain(0d);
				Thread.sleep(100);
				
				for(double i=0;i<=1.414;i+=0.001){
					if(!fadingExt)
						break;
					
					musicPlayer.setGain(Math.round(i*100d)/100d);
					Thread.sleep(1);
				}
			} catch (InterruptedException | BasicPlayerException e) {e.printStackTrace();}
			break;
		
		case "out":
			playing = false;
			
			try {
				double actualGain = Math.round((((musicPlayer.getGainValue()+80d)/86.0206)*1000d)/1000d);
				for(double i=actualGain;i>=0;i-=0.001){
					musicPlayer.setGain(Math.round(i*100d)/100d);
					Thread.sleep(1);
				}
				musicPlayer.stop();
			} catch (InterruptedException | BasicPlayerException e) {e.printStackTrace();}
			break;
		}
		
		fading = false;
	}
	
	
	private URL getSoundLocation(Sounds enumeration) throws MalformedURLException{
		String urlString=ClassLoader.getSystemResource(enumeration.getSound()).toString(); 
		return new URL(urlString.replaceFirst("file:", "file:///"));
	}
	
	
	
	/**
	 * Spielt die Menümusik ab.
	 * 
	 * @param enumeration
	 */
	protected void playMusic(final Sounds enumeration){
		setEnum(soundPfad);
		new Thread(){
			public void run(){
				if(musicPlayer.getStatus()==BasicPlayer.PLAYING){
					if(fading)
						fadingExt = false;
					
					while(fading)
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {e.printStackTrace();}
					
					if(musicPlayer.getStatus()==BasicPlayer.PLAYING)
						fade("out");
				}
				
				try {
					musicPlayer.open(getSoundLocation(enumeration));
					fade("in");
				} catch (BasicPlayerException | MalformedURLException e) {e.printStackTrace();}
		}}.start();
	}
	
	/**
	 * Stoppt die Menümusik.
	 */
	protected void stopMusic(){
		new Thread(){
			public void run(){
				if(musicPlayer.getStatus()==BasicPlayer.PLAYING)
					fade("out");
		}}.start();
	}
	
	
	/**
	 * Spielt einen Sound ab.
	 * 
	 * @param enumeration
	 */
	protected void playSound(Sounds enumeration){
		setEnum(soundPfad);
		
		try {
			soundPlayer.open(getSoundLocation(enumeration));
			soundPlayer.play();
		} catch (BasicPlayerException | MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Gibt an, ob zur Zeit ein Sound abgespielt wird.
	 * 
	 * @return {@link Boolean}
	 */
	protected boolean isPlaying(){
		return playing;
	}
	
	
	/**
	 * Setzt den Soundpfad.
	 * 
	 * @param soundPfad
	 */
	public static void setSoundPfad(String soundPfad){
		Sound.soundPfad = soundPfad;
	}
	
	
	@Override
	@SuppressWarnings("rawtypes")
	public void opened(Object arg0, Map arg1) {
	}


	@Override
	@SuppressWarnings("rawtypes")
	public void progress(int arg0, long arg1, byte[] arg2, Map arg3) {
	}


	@Override
	public void setController(BasicController arg0) {
	}


	@Override
	public void stateUpdated(BasicPlayerEvent arg0) {
		if(arg0.getCode()==BasicPlayerEvent.STOPPED && playing)
			playMusic(Sounds.menue);
	}
	
	
	
	
	/**
	 * Über diesen {@link Enum} werden alle Sound-Dateien bereitgestellt.
	 * 
	 * @author Ammon
	 */
	public enum Sounds{
		menue("Menue"),
		steinSetzen("Stein"),
		loser("Loser"),
		winner("Winner"),
		error("Disabled");
		
		private String soundVerzeichnis,
					   mp3DateiName;
		
		
		/**
		 * Konstruktor
		 * 
		 * @param mp3DateiName
		 */
		private Sounds(String mp3DateiName){
			this.mp3DateiName = mp3DateiName;
		}
		
		
		/**
		 * Setzt das Soundverzeichnis.
		 * 
		 * @param soundVerzeichnis
		 */
		private void setSoundVerzeichnis(String soundVerzeichnis){
			this.soundVerzeichnis = soundVerzeichnis;
		}
		
		
		/**
		 * Liefert den Pfad zur mp3-Datei.
		 * 
		 * @return {@link String}
		 */
		public String getSound(){
			return soundVerzeichnis + "/" + mp3DateiName + ".mp3";
		}
		
		
		/**
		 * Gibt den Namen des Sounds zurück.
		 * 
		 * @return {@link String}
		 */
		public String getSoundName(){
			return mp3DateiName;
		}
	}
}