package p05_onlineRadioDatabase;

import p05_onlineRadioDatabase.exceptions.InvalidArtistNameException;
import p05_onlineRadioDatabase.exceptions.InvalidSongNameException;

public class Song {
    private String artistName;
    private String songName;
    private SongLength songLength;

    public Song(String artistName, String songName, String minutes, String seconds) {
        setArtistName(artistName);
        setSongName(songName);
        songLength = new SongLength(minutes, seconds);
    }

    private void setArtistName(String artistName) {
        if (artistName.length() < 3 || artistName.length() > 20) {
            throw new InvalidArtistNameException(InvalidMessagesConstants.INVALID_ARTIST_NAME_MESSAGE);
        }

        this.artistName = artistName;
    }

    private void setSongName(String songName) {
        if (songName.length() < 3 || songName.length() > 20) {
            throw new InvalidSongNameException(InvalidMessagesConstants.INVALID_SONG_NAME_MESSAGE);
        }

        this.songName = songName;
    }

    SongLength getSongLength() { // visible only inside the package
        return this.songLength;
    }
}
