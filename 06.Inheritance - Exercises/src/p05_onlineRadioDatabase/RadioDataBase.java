package p05_onlineRadioDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RadioDataBase {
    private List<Song> songs;

    public RadioDataBase() {
        this.songs = new ArrayList<>();
    }

    public List<Song> getSongs() {
        return Collections.unmodifiableList(this.songs);
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public String getTotalDuration() {
        int totalSeconds = 0;
        for (Song song : this.songs) {
            totalSeconds += song.getSongLength().getTotalSeconds();
        }

        int hours = totalSeconds / 3600;
        totalSeconds %= 3600;
        int minutes = totalSeconds / 60;
        totalSeconds %= 60;
        int seconds = totalSeconds;

        return String.format("%dh %dm %ds", hours, minutes, seconds);
    }
}
