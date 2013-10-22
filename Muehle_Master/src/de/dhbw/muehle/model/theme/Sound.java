package de.dhbw.muehle.model.theme;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;


public class Sound implements BasicPlayerListener{
	
	private static BasicPlayer player;
	
	private static String soundPfad;
	
	private static boolean musicPlayed;
	private static boolean fading,
						   fadingExt;
	
	
	public Sound() {		
		player = new BasicPlayer();
		player.setSleepTime(1);
		player.addBasicPlayerListener(this);
	}
	
	
	
	private void setEnum(String soundPfad){
		for(Sounds snd : Sounds.values()){
			snd.setSoundVerzeichnis(soundPfad);
		}
	}
	
	
	private void fade(final String type){
		fading = fadingExt = true;
		
		switch (type) {
		case "in":
			try {
				player.play();
				player.setGain(0d);
				Thread.sleep(100);
				
				musicPlayed = true;
				for(double i=0;i<=1.414;i+=0.001){
					if(!fadingExt)
						break;
					
					player.setGain(Math.round(i*100d)/100d);
					Thread.sleep(1);
				}
			} catch (InterruptedException | BasicPlayerException e) {e.printStackTrace();}
			break;
		
		case "out":
			try {
				double actualGain = Math.round((((player.getGainValue()+80d)/86.0206)*1000d)/1000d);
				for(double i=actualGain;i>=0;i-=0.001){
					player.setGain(Math.round(i*100d)/100d);
					Thread.sleep(1);
				}
				player.stop();
			} catch (InterruptedException | BasicPlayerException e) {e.printStackTrace();}
			break;
		}
		
		fading = false;
	}
	
	
	private URL getSoundLocation(Sounds enumeration) throws MalformedURLException{
		String urlString=ClassLoader.getSystemResource(enumeration.getSound()).toString(); 
		return new URL(urlString.replaceFirst("file:", "file:///"));
	}
	
	
	
	protected void playMusic(final Sounds enumeration){
		setEnum(soundPfad);
		new Thread(){
			public void run(){
				if(player.getStatus()==BasicPlayer.PLAYING){
					if(fading)
						fadingExt = false;
					
					while(fading)
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {e.printStackTrace();}
					
					musicPlayed = false;
					fade("out");
				}
				
				try {
					player.open(getSoundLocation(enumeration));
					fade("in");
				} catch (BasicPlayerException | MalformedURLException e) {e.printStackTrace();}
		}}.start();
	}
	
	protected void stopMusic(){
		new Thread(){
			public void run(){
				if(player.getStatus()==BasicPlayer.PLAYING){
					musicPlayed = false;
					fade("out");
				}
		}}.start();
	}
	
	
	protected void playSound(Sounds enumeration){
		setEnum(soundPfad);
		musicPlayed = false;
		
		try {
			player.open(getSoundLocation(enumeration));
			player.play();
		} catch (BasicPlayerException | MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	
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
		if(arg0.getCode()==BasicPlayerEvent.STOPPED && musicPlayed){
			playMusic(Sounds.menue);
		}
	}
	
	
	
	
	public enum Sounds{
		menue("Menue"),
		steinSetzen("Stein"),
		loser("Loser"),
		winner("Winner"),
		error("Disabled");
		
		private String soundVerzeichnis,
					   mp3DateiName;
		
		
		private Sounds(String mp3DateiName){
			this.mp3DateiName = mp3DateiName;
		}
		
		
		private void setSoundVerzeichnis(String soundVerzeichnis){
			this.soundVerzeichnis = soundVerzeichnis;
		}
		
		
		public String getSound(){
			return soundVerzeichnis + "/" + mp3DateiName + ".mp3";
		}
		
		public String getSoundName(){
			return mp3DateiName;
		}
	}
}