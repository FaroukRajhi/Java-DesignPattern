// Song class - the element we'll iterate over
public class Song {
    private String title;
    private String artist;
    private int releaseYear;
    
    public Song(String title, String artist, int releaseYear) {
        this.title = title;
        this.artist = artist;
        this.releaseYear = releaseYear;
    }
    
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public int getReleaseYear() { return releaseYear; }
    
    @Override
    public String toString() {
        return String.format("'%s' by %s (%d)", title, artist, releaseYear);
    }
}
