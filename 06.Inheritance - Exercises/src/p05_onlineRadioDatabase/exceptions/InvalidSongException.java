package p05_onlineRadioDatabase.exceptions;

public class InvalidSongException extends IllegalArgumentException {
    public InvalidSongException(String message) {
        super(message);
    }
}
