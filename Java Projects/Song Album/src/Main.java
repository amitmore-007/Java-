import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArrayList<Album> albums = new ArrayList<>(List.of());

        Album album = new Album("Humsafar","Arijit Singh");
        album.addSong("Faya Koon",3.5);
        album.addSong("Counting Stars",4.5);
        album.addSong("Unstoppable",2.5);
        album.addSong("Yugat Mandli",3.4);
        album.addSong("Unholy",4.3);
        album.addSong("Aint Worried",3.3);
        album.addSong("Shoorveer",3.6);

        albums.add(album);
        System.out.println(albums);

        LinkedList<Song> playlist = new LinkedList<>();
        albums.get(0).addToPlayList("Believer",playlist);
        albums.get(0).addToPlayList("Uptown",playlist);
        System.out.println(playlist);





    }
}