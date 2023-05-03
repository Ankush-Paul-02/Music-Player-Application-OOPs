import java.util.*;

public class Album {
    public String name;
    public String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    /**
     * 
     * @param title
     * @return wether it is in the songs list or not
     */
    public boolean findSong(String title) {
        for (Song song : songs) {
            if(song.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Add song to the songs list
     * @param title of the song
     * @param duration of the song
     * @return true if added neither false
     */
    public boolean addSong(String title, double duration) {
        if(!findSong(title)) {
            songs.add(new Song(title, duration));
            System.out.println(title + " Successfully added to the list.");
            return true;
        } else {
            System.out.println("Song with this title: " + title + " Already exist in the list.");
            return false;
        }   
    }

    //? Method overloading
    /**
     * Add a song to the playlist
     * @param trackNumber of the song
     * @param playList of songs
     * @return true if added neither false
     */
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber-1;
        if(index > 0 && index <= this.songs.size()) {
            playlist.add(this.songs.get(index));
            return true;
        } 
        System.out.println("This album doesn't have song with the trackNumber: " + trackNumber);
        return false;
    }

    /**
     * Add a song to the playlist
     * @param title of the song
     * @param playlist of songs
     * @return true if added neither false
     */
    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        for (Song song : this.songs) {
            if(song.getTitle().equals(title)) {
                playlist.add(song);
                return true;
            }
        }
        System.out.println("There is no such a song with the title: " + title + " in the album!");
        return false;
    }

}
