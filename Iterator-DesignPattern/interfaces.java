// Iterator interface

public interface <T>
{
	boolean hasNext();
	T next();
}

// Aggregate Interface
//
public interface Playlist
{
	Iterator<Song> createIterator();
	Iterator<Song> createReverseIterator();
}
