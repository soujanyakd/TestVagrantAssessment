import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SongPlaylistTest {

    @Test
    public static void verifyUserSongPlaylistTest() {
        //Setting the size of the playlist
        User user = new User(3);
        user.addSongToPlaylist("S1");

        //When same song is added twice to the playlist
        user.addSongToPlaylist("S2");
        user.addSongToPlaylist("S2");
        Assert.assertTrue(user.songsPlaylist.containsAll(List.of("S1", "S2")));

        //When the new song is added to the playlist
        user.addSongToPlaylist("S3");
        Assert.assertTrue(user.songsPlaylist.containsAll(List.of("S1", "S2", "S3")));

        //When the playlist is full and new song is added to the playlist
        user.addSongToPlaylist("S4");
        Assert.assertTrue(user.songsPlaylist.containsAll(List.of("S2", "S3", "S4")));

        //When user plays a song which is already on top of playlist
        user.playSong("S4");
        Assert.assertTrue(user.songsPlaylist.containsAll(List.of("S2", "S3", "S4")));

        //When user plays a song which is present in the playlist
        user.playSong("S2");
        Assert.assertTrue(user.songsPlaylist.containsAll(List.of("S3", "S4", "S2")));

        //When user plays a new song which is not present in the playlist
        user.playSong("S5");
        Assert.assertTrue(user.songsPlaylist.containsAll(List.of("S4", "S2", "S5")));
    }
}