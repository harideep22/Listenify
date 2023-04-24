package Listenify;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    public String albumName;
    public String artistName;
    public List<Song> songList;

    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.songList = new ArrayList<>();
    }

    public boolean findSong(String title){
        for(Song song:this.songList){
            if((song.title).equals(title)){
                return true;
            }
        }
        return false;
    }

    public String addSongToAlbum(String title,double duration){
        // check whether the song is currently in the album. else add it to album.
        if(findSong(title)){
            return "Song is already present in the album";
        }
        else{
            Song newSong=new Song(title,duration);
            songList.add(newSong);
            return "New Song has been added Successfully";
        }
    }

    public String addSongToPlaylist(int trackNo, LinkedList<Song>playList){
        // track no is a no in a songList
        int index=trackNo-1;
        if(index>=0 && index<this.songList.size()) {
            Song song = this.songList.get(index);
            playList.add(song);
            return "Song has been added successfully";
        }
        return "Invalid track no";
    }

    public String addSongToPlayList(String title,LinkedList<Song>playList){
        //find the song and put it in the playlist
        for(Song song:this.songList){
            if(song.title==title){
                playList.add(song);
                return "Song has been added Successfully";
            }
        }
        return "Song is not found";
    }
}
