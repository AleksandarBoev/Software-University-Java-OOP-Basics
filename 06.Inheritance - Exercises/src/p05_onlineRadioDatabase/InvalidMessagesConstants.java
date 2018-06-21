package p05_onlineRadioDatabase;

public final class InvalidMessagesConstants {
    public static final String INVALID_ARTIST_NAME_MESSAGE = "Artist name should be between 3 and 20 symbols.";
    public static final String INVALID_SONG_NAME_MESSAGE = "Song name should be between 3 and 30 symbols.";
    public static final String INVALID_SONG_LENGTH_MESSAGE = "Invalid song length.";
    public static final String INVALID_SONG_MINUTES_MESSAGE = "Song minutes should be between 0 and 14.";
    public static final String INVALID_SONG_SECONDS_MESSAGE = "Song seconds should be between 0 and 59.";

    private InvalidMessagesConstants() { // an instance can't be created --> only the static members will be used

    }
}
