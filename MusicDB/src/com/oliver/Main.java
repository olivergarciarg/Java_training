package com.oliver;

import com.oliver.model.Artist;
import com.oliver.model.DataSource;
import com.oliver.model.SongArtist;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        if (!dataSource.open()) {
            System.out.println("can't open datasource");
            return;
        }

        List<Artist> artists = dataSource.queryArtists(DataSource.ORDER_BY_ASC);
        if (artists == null) {
            System.out.println("no artists");
            return;
        }

        for (Artist artist: artists) {
            System.out.println(artist.getId() + " " + artist.getName());
        }

        List<String> albumsForArtist = dataSource.queryForAlbumsForArtist("Iron Maiden", DataSource.ORDER_BY_ASC);
        for (String album: albumsForArtist) {
            System.out.println(album);
        }

        List<SongArtist> songArtists = dataSource.queryArtistForSong("Heartless", DataSource.ORDER_BY_ASC);
        if (songArtists == null) {
            System.out.println("no songs");
            return;
        }

        for (SongArtist songArtist: songArtists) {
            System.out.println(songArtist.getArtistName() + " " + songArtist.getAlbumName() + " " + songArtist.getTrack());
        }

        dataSource.querySongsMetadata();

        int count = dataSource.getCount(DataSource.TABLE_SONGS);
        System.out.println(count);

        dataSource.createViewForSongArtists();

        dataSource.close();
    }
}