package com.oliver.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\005_Java_training\\MusicDB\\src\\" + DB_NAME;

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";
    public static final String COLUMN_ALBUM_ID_F = TABLE_ALBUMS + "._id";
    public static final String COLUMN_ALBUM_NAME_F = TABLE_ALBUMS + ".name";
    public static final String COLUMN_ALBUM_ARTIST_F = TABLE_ALBUMS + ".artist";
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";
    public static final String COLUMN_ARTIST_ID_F = TABLE_ARTISTS + "._id";
    public static final String COLUMN_ARTIST_NAME_F = TABLE_ARTISTS + ".name";
    public static final int INDEX_ARTIST_ID = 1;
    public static final int INDEX_ARTIST_NAME = 2;

    public static final String TABLE_SONGS = "SONGS";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";
    public static final String COLUMN_SONG_ID_F = TABLE_SONGS + "._id";
    public static final String COLUMN_SONG_TRACK_F = TABLE_SONGS + ".track";
    public static final String COLUMN_SONG_TITLE_F = TABLE_SONGS + ".title";
    public static final String COLUMN_SONG_ALBUM_F = TABLE_SONGS + ".album";
    public static final int INDEX_SONG_ID = 1;
    public static final int INDEX_SONG_TRACK = 2;
    public static final int INDEX_SONG_TITLE = 3;
    public static final int INDEX_SONG_ALBUM = 3;

    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;

    public static final String QUERY_ALBUMS_BY_ARTIST_START = "SELECT " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME +
            " FROM " + TABLE_ALBUMS + " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." +
            COLUMN_ALBUM_ARTIST + "=" + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID + " WHERE " + TABLE_ARTISTS + "." +
            COLUMN_ARTIST_NAME + "=\"";
    public static final String QUERY_ALBUMS_BY_ARTIST_END = "\"";

    public static final String QUERY_ALBUMS_BY_ARTIST_SORT = " ORDER BY " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " COLLATE NOCASE ";

    public static final String QUERY_ARTIST_FOR_SONG_START = "SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
            TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + "," +
            TABLE_SONGS + "." + COLUMN_SONG_TRACK +
            " FROM " + TABLE_SONGS +
            " INNER JOIN " + TABLE_ALBUMS +
            " ON " + TABLE_SONGS + "." + COLUMN_SONG_ALBUM + "=" + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID +
            " INNER JOIN " + TABLE_ARTISTS +
            " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + "=" + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID +
            " WHERE " + TABLE_SONGS + "." + COLUMN_SONG_TITLE + "=\"";
    public static final String QUERY_ARTIST_FOR_SONG_END = "\"";

    public static final String QUERY_ARTIST_FOR_SONG_SORT = " ORDER BY " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
            TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " COLLATE NOCASE ";

    public static final String TABLE_ARTIST_SONG_VIEW = "artist_list";
    public static final String CREATE_ARTIST_FOR_SONG_VIEW = "CREATE VIEW IF NOT EXISTS " + TABLE_ARTIST_SONG_VIEW +
            " AS SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
            TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " AS album, " + TABLE_SONGS + "." + COLUMN_SONG_TRACK + ", " +
            TABLE_SONGS + "." + COLUMN_SONG_TITLE + " FROM " + TABLE_SONGS + " INNER JOIN " + TABLE_ALBUMS + " ON " +
            TABLE_SONGS + "." + COLUMN_SONG_ALBUM + "=" + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID + " INNER JOIN " +
            TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + "=" +
            TABLE_ARTISTS + "." + COLUMN_ARTIST_ID + " ORDER BY " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
            TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + ", " + TABLE_SONGS + "." + COLUMN_SONG_TRACK + ";";

    public static final String QUERY_VIEW_SONG_INFO_PREP = "SELECT " + COLUMN_ARTIST_NAME + ", " +
            COLUMN_SONG_ALBUM + ", " + COLUMN_SONG_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW +
            " WHERE " + COLUMN_SONG_TITLE + "=?";

    public static final String INSERT_ARTIST = "INSERT INTO " + TABLE_ARTISTS + "(" + COLUMN_ARTIST_NAME + ") VALUES(?)";
    public static final String INSERT_ALBUM = "INSERT INTO " + TABLE_ALBUMS +
            "(" + COLUMN_ALBUM_NAME + "," + COLUMN_ARTIST_NAME + ") VALUES(?,?)";
    public static final String INSERT_SONGS = "INSERT INTO " + TABLE_SONGS +
            "(" + COLUMN_SONG_TRACK + "," + COLUMN_SONG_TITLE + "," + COLUMN_SONG_ALBUM + ") VALUES(?,?,?)";

    public static final String QUERY_ARTIST = "SELECT " + COLUMN_ARTIST_ID + " FROM " + TABLE_ARTISTS + " WHERE " +
            COLUMN_ARTIST_NAME_F + "=?";
    public static final String QUERY_ALBUM = "SELECT " + COLUMN_ALBUM_ID + " FROM " + TABLE_ALBUMS + " WHERE " +
            COLUMN_ALBUM_NAME + "=?";

    private Connection conn;

    private PreparedStatement querySongInfoView;
    private PreparedStatement insertIntoArtists;
    private PreparedStatement insertIntoAlbums;
    private PreparedStatement insertIntoSongs;

    private PreparedStatement queryArtist;
    private PreparedStatement queryAlbum;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            querySongInfoView = conn.prepareStatement(QUERY_VIEW_SONG_INFO_PREP);
            insertIntoArtists = conn.prepareStatement(INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
            insertIntoAlbums = conn.prepareStatement(INSERT_ALBUM, Statement.RETURN_GENERATED_KEYS);
            insertIntoSongs = conn.prepareStatement(INSERT_SONGS);
            queryArtist = conn.prepareStatement(QUERY_ARTIST);
            queryAlbum = conn.prepareStatement(QUERY_ALBUM);

            return true;
        } catch(SQLException e) {
            System.out.println("couldn't connect " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if (querySongInfoView != null) {
                querySongInfoView.close();
            }
            if (insertIntoArtists != null) {
                insertIntoArtists.close();
            }
            if (insertIntoAlbums != null) {
                insertIntoAlbums.close();
            }
            if (insertIntoSongs != null) {
                insertIntoSongs.close();
            }
            if (queryArtist != null) {
                queryArtist.close();
            }
            if (queryAlbum != null) {
                queryAlbum.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("couldn't close connection " + e.getMessage());
        }
    }

    public List<Artist> queryArtistsOld() {
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM " + TABLE_ARTISTS);

            List<Artist> artists = new ArrayList<>();
            while (resultSet.next()) {
                Artist artist = new Artist();
                artist.setId(resultSet.getInt(COLUMN_ARTIST_ID));
                artist.setName(resultSet.getString(COLUMN_ARTIST_NAME));
                artists.add(artist);
            }

            return artists;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                System.out.println("error closing resultSet");
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("error closing statement");
            }
        }
    }

    public List<Artist> queryArtists(int sortOrder) {
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_ARTISTS);
        if (sortOrder != ORDER_BY_NONE) {
            sb.append(" ORDER BY ");
            sb.append(COLUMN_ARTIST_NAME);
            sb.append(" COLLATE NOCASE ");
            sb.append(sortOrder == ORDER_BY_ASC? "ASC": "DESC");
        }
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sb.toString());) {

            List<Artist> artists = new ArrayList<>();
            while (resultSet.next()) {
                Artist artist = new Artist();
//                artist.setId(resultSet.getInt(COLUMN_ARTIST_ID));
//                artist.setName(resultSet.getString(COLUMN_ARTIST_NAME));
                artist.setId(resultSet.getInt(INDEX_ARTIST_ID));
                artist.setName(resultSet.getString(INDEX_ARTIST_NAME));
                artists.add(artist);
            }

            return artists;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public List<String> queryForAlbumsForArtist(String artist, int sortOrder) {
        StringBuilder sb = new StringBuilder(QUERY_ALBUMS_BY_ARTIST_START);
        sb.append(artist);
        sb.append(QUERY_ALBUMS_BY_ARTIST_END);

        if (sortOrder != ORDER_BY_NONE) {
            sb.append(QUERY_ALBUMS_BY_ARTIST_SORT);
            sb.append(sortOrder == ORDER_BY_ASC? "ASC": "DESC");
        }
        System.out.println("SQL " + sb.toString());

        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sb.toString());) {

            List<String> albums = new ArrayList<>();
            while (resultSet.next()) {
                albums.add(resultSet.getString(1));
            }

            return albums;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public List<SongArtist> queryArtistForSong(String songName, int sortOrder) {
        StringBuilder sb = new StringBuilder(QUERY_ARTIST_FOR_SONG_START);
        sb.append(songName);
        sb.append(QUERY_ARTIST_FOR_SONG_END);

        if (sortOrder != ORDER_BY_NONE) {
            sb.append(QUERY_ARTIST_FOR_SONG_SORT);
            sb.append(sortOrder == ORDER_BY_ASC? "ASC": "DESC");
        }
        System.out.println("SQL " + sb.toString());

        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sb.toString());) {

            List<SongArtist> songArtists = new ArrayList<>();
            while (resultSet.next()) {
                SongArtist songArtist = new SongArtist();
                songArtist.setArtistName(resultSet.getString(1));
                songArtist.setAlbumName(resultSet.getString(2));
                songArtist.setTrack(resultSet.getInt(3));
                songArtists.add(songArtist);
            }

            return songArtists;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public void querySongsMetadata() {
        String sql = "SELECT * FROM " + TABLE_SONGS;

        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData meta = resultSet.getMetaData();
            int numColumns = meta.getColumnCount();
            for (int i = 1; i<=numColumns; i++) {
                System.out.printf("Column %d in the somgs table is %s\n", i, meta.getColumnName(i));
            }
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
        }
    }

    public int getCount(String table) {
        String sql = "SELECT COUNT(*) AS count, MIN(_id) as min_id FROM " + table;
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
//            int count =  resultSet.getInt(1);
            int count =  resultSet.getInt("count");
            return count;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return 0;
        }
    }

    public boolean createViewForSongArtists() {
        try (Statement statement = conn.createStatement()) {
            statement.execute(CREATE_ARTIST_FOR_SONG_VIEW);
            return true;
        } catch (SQLException e) {
            System.out.println("Create view failed: " + e.getMessage());
            return false;
        }
    }

    public List<SongArtist> querySongInfoView(String title) {
        try {
            querySongInfoView.setString(1, title);
            ResultSet resultSet = querySongInfoView.executeQuery();

            List<SongArtist> songArtists = new ArrayList<>();
            while (resultSet.next()) {
                SongArtist songArtist = new SongArtist();
                songArtist.setArtistName(resultSet.getString(1));
                songArtist.setAlbumName(resultSet.getString(2));
                songArtist.setTrack(resultSet.getInt(3));
                songArtists.add(songArtist);
            }

            return songArtists;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    private int insertArtist(String name) throws SQLException {
        queryArtist.setString(1, name);
        ResultSet resultSet = queryArtist.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        } else {
            insertIntoArtists.setString(1,name);
            int affectedRows = insertIntoArtists.executeUpdate();
            if (affectedRows != 1){
                throw new SQLException("could not insert artist");
            }
            ResultSet generatedKeys = insertIntoArtists.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("could get id for artist");
            }
        }
    }

    private int insertAlbum(String name, int artistId) throws SQLException {
        queryAlbum.setString(1, name);
        ResultSet resultSet = queryAlbum.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        } else {
            insertIntoAlbums.setString(1,name);
            insertIntoAlbums.setInt(2,artistId);
            int affectedRows = insertIntoAlbums.executeUpdate();
            if (affectedRows != 1){
                throw new SQLException("could not insert album");
            }
            ResultSet generatedKeys = insertIntoAlbums.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("could get id for album");
            }
        }
    }

    public void insertSong(String title, String artist, String album, int track) {
        try {
            conn.setAutoCommit(false);
            int artistId = insertArtist(artist);
            int albumId = insertAlbum(album, artistId);

            insertIntoSongs.setInt(1, track);
            insertIntoSongs.setString(2, title);
            insertIntoSongs.setInt(3, albumId);
            int affectedRows = insertIntoSongs.executeUpdate();
            if (affectedRows == 1){
                conn.commit();
            } else {
                throw new SQLException("song insert failed");
            }
        } catch (Exception e) {
            System.out.println("Insert song failed " + e.getMessage());
            try {
                System.out.println("rollback");
                conn.rollback();
            } catch (SQLException e2) {
                System.out.println("rollback failed " + e2.getMessage());
            }
        } finally {
            try {
                System.out.println("autocommit = true");
                conn.setAutoCommit(true);
            } catch (SQLException e3) {
                System.out.println("autocommit = true FAILED");
            }
        }
    }
}
