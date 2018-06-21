package p05_onlineRadioDatabase;

import p05_onlineRadioDatabase.exceptions.InvalidSongLengthException;
import p05_onlineRadioDatabase.exceptions.InvalidSongMinutesException;
import p05_onlineRadioDatabase.exceptions.InvalidSongSecondsException;

public class SongLength {
    private int minutes;
    private int seconds;

    public SongLength(String minutes, String seconds) {
        setMinutes(minutes);
        setSeconds(seconds);
    }

    public int getMinutes() {
        return this.minutes;
    }

    private void setMinutes(String minutes) {
        if (!minutes.matches("\\d+")) {
            throw new InvalidSongLengthException(InvalidMessagesConstants.INVALID_SONG_LENGTH_MESSAGE);
        }

        int minutesInteger = Integer.parseInt(minutes);
        if (minutesInteger < 0 || minutesInteger > 14) {
            throw new InvalidSongMinutesException(InvalidMessagesConstants.INVALID_SONG_MINUTES_MESSAGE);
        }

        this.minutes = minutesInteger;
    }

    public int getSeconds() {
        return this.seconds;
    }

    private void setSeconds(String seconds) {
        if (!seconds.matches("\\d+")) {
            throw new InvalidSongLengthException(InvalidMessagesConstants.INVALID_SONG_LENGTH_MESSAGE);
        }

        int secondsInteger = Integer.parseInt(seconds);
        if (secondsInteger < 0 || secondsInteger > 59) {
            throw new InvalidSongSecondsException(InvalidMessagesConstants.INVALID_SONG_SECONDS_MESSAGE);
        }

        this.seconds = secondsInteger;
    }

    public int getTotalSeconds() {
        return this.minutes * 60 + this.seconds;
    }
}
