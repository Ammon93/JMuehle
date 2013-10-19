package de.dhbw.muehle.model.theme;

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
		switch (type) {
		case "in":
			try {
				player.play();
				player.setGain(0d);
				Thread.sleep(100);
				
				musicPlayed = true;
				for(double i=0;i<=1;i+=0.01){
					player.setGain(Math.round(i*100d)/100d);
					Thread.sleep(30);
				}
			} catch (BasicPlayerException | InterruptedException e) {e.printStackTrace();}
			break;
		case "out":
			try {							
				for(double i=1;i>=0;i-=0.01){
					player.setGain(Math.round(i*100d)/100d);
					Thread.sleep(30);
				}
				player.stop();
			} catch (BasicPlayerException | InterruptedException e) {e.printStackTrace();}
			break;
		}
	}
	
	
	protected void playMusic(final Sounds enumeration){
		setEnum(soundPfad);
		new Thread(){
			public void run(){
				if(player.getStatus()==BasicPlayer.PLAYING){
					musicPlayed = false;
					fade("out");
				}
				
				try {
					player.open(ClassLoader.getSystemResource(enumeration.getSound()));
					fade("in");
				} catch (BasicPlayerException e) {e.printStackTrace();}
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
			player.open(ClassLoader.getSystemResource(enumeration.getSound()));
			player.play();
		} catch (BasicPlayerException e) {
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
		menue("MENUE"),
		steinSetzen("STEIN"),
		loser1("LOSER001"),
		loser2("LOSER002"),
		winner1("WINNER001"),
		winner2("WINNER002");
		
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