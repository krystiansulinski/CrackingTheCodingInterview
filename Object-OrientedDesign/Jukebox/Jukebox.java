/*
 * 7.3 Jukebox
 * 
 * Design a musical jukebox using object-oriented principles.
 */

package Jukebox;

import java.awt.Button;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jukebox {
	Map<String, Song> songs = new HashMap<>();
	List<Button> buttons = new ArrayList<>();

	public Jukebox() {
		if (songs.size() == 0) {
			songs.put("A1",
					new Song("Imagine", "John Lennon", "Imagine", new File("/Users/username/audioFile/imagine.wav")));
			songs.put("A2", new Song("Bohemian Rapsody", "Queen", "A Night at the Opera",
					new File("/Users/username/audioFile/bohemianRapsody.wav")));

			buttons.add((new Button("A1")));
			buttons.add((new Button("A2")));
		}
	}

	public void addSongs(Map<String, Song> songs) {
		this.songs.putAll(songs);
		for (String label : songs.keySet()) {
			buttons.add(new Button(label));
		}
	}

	public void removeSongs(Map<String, Song> songs) {
		for (String label : songs.keySet()) {
			this.songs.remove(label);
			buttons.remove(label);
		}
	}

	public void selectSong(List<Button> buttons) {
		StringBuilder songId = new StringBuilder();

		for (Button button : buttons) {
			songId.append(button.getLabel());
		}

		Song song = songs.get(songId);
		if (song != null) {
			play(song);
		} else {
			resetSelectedButtons();
		}
	}

	public void play(Song song) {
		AudioInputStream audio = song.getAudio();
		audio.play();
	}
	
	public void stop(Song song) {
		song.getAudio().stop();
	}

	public void resetSelectedButtons() {
	}
}
