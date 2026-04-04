// Concrete Playlist implementation
class MusicPlaylist implements Playlist {
    private List<Song> songs;
    
    public MusicPlaylist() {
        this.songs = new ArrayList<>();
    }
    
    public void addSong(Song song) {
        songs.add(song);
    }
    
    @Override
    public Iterator<Song> createIterator() {
        return new ForwardIterator();
    }
    
    @Override
    public Iterator<Song> createReverseIterator() {
        return new ReverseIterator();
    }
    
    // Forward Iterator (default)
    private class ForwardIterator implements Iterator<Song> {
        private int position = 0;
        
        @Override
        public boolean hasNext() {
            return position < songs.size();
        }
        
        @Override
        public Song next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return songs.get(position++);
        }
    }
    
    // Reverse Iterator
    private class ReverseIterator implements Iterator<Song> {
        private int position = songs.size() - 1;
        
        @Override
        public boolean hasNext() {
            return position >= 0;
        }
        
        @Override
        public Song next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return songs.get(position--);
        }
    }
}
