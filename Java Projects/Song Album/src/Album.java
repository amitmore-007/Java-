import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist){
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration){

        if(findSong(title) == null){
            songs.add(new Song(title,duration));
            return true;

        }
        return false;


    }

    private Song findSong(String title){
        for(int i = 0; i < songs.size(); i++){
            Song song = songs.get(i);
            if(song.getTitle().equals(title)){
                System.out.println("Song is already in the playlist");
                return song;

            }

        }
        return null;


    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist){
        int index = trackNumber - 1;
        if(index >= 0 && index <= songs.size()){
              playlist.add(songs.get(index));
              return true;
        }
        return false;

    }


    public boolean addToPlayList(String title, LinkedList<Song> playlist){
        Song checkedSong = findSong(title);
        if(checkedSong == null){
            return false;

        }
        return playlist.add(checkedSong);
    }

}