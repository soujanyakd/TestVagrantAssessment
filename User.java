import java.util.ArrayList;
import java.util.List;

public class User {
    public List<String> songsPlaylist;
    private int songPlaylistSize;

    public User(int playlistSize) {
        this.songsPlaylist = new ArrayList<>(playlistSize);
        this.songPlaylistSize = playlistSize;
    }

    public List<String> addSongToPlaylist(String songName) {
        if (isSongPresentInPlaylist(songName)) {
            return this.songsPlaylist;
        } else if (this.songsPlaylist.size() < this.songPlaylistSize) {
            this.songsPlaylist.add(songName);
            return this.songsPlaylist;
        }
        deleteLeastPlayedSong();
        this.songsPlaylist.add(songName);
        return this.songsPlaylist;
    }

    private List<String> moveSongToTopOfThePlaylist(String songName) {
        String songToBePlayed;
        for (int index = this.songsPlaylist.indexOf(songName); index < this.songsPlaylist.size() - 1; index++) {
            songToBePlayed = this.songsPlaylist.get(index);
            this.songsPlaylist.set(index, this.songsPlaylist.get(index + 1));
            this.songsPlaylist.set(index + 1, songToBePlayed);
        }
        return this.songsPlaylist;
    }

    public List<String> playSong(String songName) {
        if (isSongPresentInPlaylist(songName)) {
            return moveSongToTopOfThePlaylist(songName);
        }
        return addSongToPlaylist(songName);
    }

    private List<String> deleteLeastPlayedSong() {
        this.songsPlaylist.remove(0);
        return this.songsPlaylist;
    }

    private boolean isSongPresentInPlaylist(String SongName) {
        return this.songsPlaylist.contains(SongName);
    }
}

