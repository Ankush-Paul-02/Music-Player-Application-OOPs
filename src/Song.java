public class Song {
    private String title;
    private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    /**
     * Title of the song
     * @return the title of the song
     */
    public String getTitle() {
        return title;
    }

    /**
     * Duration of the song
     * @return the duration of the song
     */
    public double getDuration() {
        return duration;
    }

    /**
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "Song{ title: '" + title + ", duration: " + duration + " }";
    }
    
}
