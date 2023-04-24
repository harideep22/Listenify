package Listenify;

import java.util.*;

public class Main {
    public static List<Album> albums=new ArrayList<>();
    public static void main(String[] args) {
        Album album=new Album("Old Hindi Songs","Arijit Singh");
        album.addSongToAlbum("Pathaan",4.5);
        album.addSongToAlbum("Channa mereya",3.5);
        album.addSongToAlbum("Naina",5.0);

        albums.add(album);

        album=new Album("New Songs","Pratek kuhad");
        album.addSongToAlbum("Kasoor",4.5);
        album.addSongToAlbum("Tum Mile",3.5);
        album.addSongToAlbum("Baarishein",4.5);

        albums.add(album);

        LinkedList<Song> playList_1=new LinkedList<>();
        albums.get(0).addSongToPlayList("Pathaan",playList_1);
        albums.get(0).addSongToPlayList("Naina",playList_1);
        albums.get(1).addSongToPlayList("Kasoor",playList_1);
        albums.get(1).addSongToPlayList("Baarishein",playList_1);

        // print the playlist that has been added
        play(playList_1);
    }
    public static void play(LinkedList<Song> playList){
        ListIterator<Song> listIterator=playList.listIterator();

        // validation check
        if(playList.size()==0){
            return ;
        }
        Scanner scan=new Scanner(System.in);
        printMenu();
        boolean forward=true;
        System.out.println("Now Playing "+listIterator.next());
        boolean quit=false;
        while(quit==false){
            int choice=scan.nextInt();
            if(playList.size()>0){
                switch(choice) {
                    case 0:
                        quit = true;
                        break;
                    case 1:
                        // to play the next song
                        if (forward == false) {
                            listIterator.next();
                            forward = true;
                        }
                        if (listIterator.hasNext()) {
                            System.out.println(listIterator.next().toString());
                        } else {
                            System.out.println("You are at the last song");
                        }
                        break;
                    case 2:
                        // to play previous song
                        if (forward == true) {
                            listIterator.previous();
                            forward = false;
                        }
                        if (listIterator.hasPrevious()) {
                            System.out.println(listIterator.previous().toString());
                        } else {
                            System.out.println("You are already at the first song");
                        }
                        break;
                    case 3:
                        // replay the current song
                        if (forward == true) {
                            System.out.println(listIterator.previous().toString());
                            forward = false;
                        } else {
                            forward = true;
                            System.out.println(listIterator.next().toString());
                        }
                        break;
                    case 4:
                        printAllSongs(playList);
                        break;
                    case 5:
                        // print menu
                        printMenu();
                        break;
                    case 6:
                        //Delete a song
                        if (playList.size() > 0) {
                            if (forward == true) {
                                System.out.println(listIterator.previous().toString() + " has been removed from playlist");
                                listIterator.next();
                                listIterator.remove();
                                forward = true;
                            } else {
                                System.out.println(listIterator.next().toString() + " has been removed from playlist");
                                listIterator.remove();
                                forward = true;
                            }
                            if (playList.size() > 0 && listIterator.hasPrevious()) {
                                System.out.println(" Now playing " + listIterator.previous().toString());
                                forward = false;
                            } else if (playList.size() > 0 && listIterator.hasNext()) {
                                System.out.println("Now Playing " + listIterator.next().toString());
                                forward = true;
                            }
                        }
                }
            }
            else{
                System.out.println("Play List has no songs");
            }

        }

    }


    private static void printAllSongs(LinkedList<Song> songs){

        // try for each loop
        ListIterator<Song> listIterator= songs.listIterator();
        while(listIterator.hasNext()){
            System.out.println(listIterator.next().toString());
        }
    }
    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println(" 0 - to quit\n"+
                " 1 - to play next song\n"+
                " 2 - to play previous song \n"+
                " 3 - to replay the current song \n"+
                " 4 - list of all songs \n"+
                " 5 - print all available options \n"+
                " 6 - delete current song");
    }









}