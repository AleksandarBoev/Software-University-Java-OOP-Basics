package p05_onlineRadioDatabase;

import p05_onlineRadioDatabase.exceptions.InvalidSongException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfInputs = Integer.parseInt(reader.readLine());

        //3
        //ABBA;Mamma Mia;3:35
        //Nasko Mentata;Shopskata salata;4:123
        //Nasko Mentata;Shopskata salata;4:12

        RadioDataBase radioDataBase = new RadioDataBase();

        for (int i = 0; i < numberOfInputs; i++) {
            String[] tokens = reader.readLine().split(";");

            String artistName = tokens[0];
            String songName = tokens[1];
            String songLengthInfo = tokens[2];

            String minutes = songLengthInfo.split(":")[0];
            String seconds = songLengthInfo.split(":")[1];

            try {
                Song song = new Song(artistName, songName, minutes, seconds);
                System.out.println("Song added.");
                radioDataBase.addSong(song);
            } catch (InvalidSongException ise) {
                System.out.println(ise.getMessage());
            }
        }

        System.out.printf("Songs added: %d%n", radioDataBase.getSongs().size());
        System.out.printf("Playlist length: %s", radioDataBase.getTotalDuration());

        //main ends here
    }
}
