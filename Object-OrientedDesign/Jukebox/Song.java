package Jukebox;

import java.io.File;

public class Song {
	private String songName;
	private String performer;
	private String album;
	private File file;
	private AudioInputStream audio;

	public Song(String songName, String performer, String album, File file) {
		this.setSongName(songName);
		this.setPerfomer(performer);
		this.setAlbum(album);
		this.setAudioStream(file.getAbsolutePath());
	}

	private void setAudioStream(String filePath) {
		this.setAudio(new AudioInputStream(filePath));
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getPerfomer() {
		return performer;
	}

	public void setPerfomer(String perfomer) {
		this.performer = perfomer;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public AudioInputStream getAudio() {
		return audio;
	}

	public void setAudio(AudioInputStream audio) {
		this.audio = audio;
	}
}
