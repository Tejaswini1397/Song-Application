import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import static java.lang.System.exit;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Album album1=new Album("Butt Boma","Arman Malik");

        Album album2=new Album("Doorie","Atif Aslam");

        album1.addSong("Butta Boma",4.5);
        album1.addSong("kesriya",4.1);

        album2.addSong("doorie",3.2);
        album2.addSong("kuch is tarah",3.5);
        if(album1.findSong("abc")){
            System.out.println("abc is present");
        }else{
            System.out.println("abc is not present");
        }

        if(album2.findSong("kuch is tarah")){
            System.out.println("kuch is tarah song is present");
        }else{
            System.out.println("kuch is tarah song is not present");
        }
        //create list
        LinkedList<Song>myPlayList=new LinkedList<>();
        album1.addToPlayListFromAlbum("kesriya",myPlayList);
        album1.addToPlayListFromAlbum(1,myPlayList);

        album2.addToPlayListFromAlbum("kuch is tarah",myPlayList);
        album2.addToPlayListFromAlbum(1,myPlayList);

        //wrong song amd index
        album1.addToPlayListFromAlbum(5,myPlayList);
        album2.addToPlayListFromAlbum("random",myPlayList);

        play(myPlayList);
    }

    public static void play(LinkedList<Song>myPlaylist){
        ListIterator<Song>itr=myPlaylist.listIterator();
        //if list is empty
        if(!itr.hasNext()){
            System.out.println("Your Playlist is Empty");
            return;
        }
        System.out.println("Now Playing : ");
        System.out.println(itr.next());
        boolean wasNext=true;

        printMenu();
        Scanner sc=new Scanner(System.in);
        boolean quite= false;


        boolean quit =false;
        while(true){
            System.out.println("Please Enter Your option");
            int option=sc.nextInt();
            switch(option){
                case 1:
                    if(wasNext==false){
                        itr.next();
                        wasNext=true;
                    }
                    if(itr.hasNext()){
                        System.out.println("Now Playing: ");
                        System.out.println(itr.next());
                        wasNext=true;
                    }else{
                        System.out.println("You have reached the end of the playlist");
                    }
                    break;
                case 2:
                    if(wasNext==true){
                        itr.previous();
                        wasNext=false;
                    }
                    if(itr.hasPrevious()){
                    System.out.println("Now Playing: ");
                    System.out.println(itr.previous());
                    wasNext=false;
                }else{
                        System.out.println("You have reached the end of the playlist");
                    }
                    break;
                case 3:
                    if(wasNext==true){
                        if(itr.hasPrevious()){
                            System.out.println("Now Playing: ");
                            System.out.println(itr.previous());
                            wasNext=false;
                        }
                    }else{
                        if(itr.hasNext()){
                            System.out.println("Now Plating: ");
                            System.out.println(itr.next());
                            wasNext=true;
                        }
                    }
                    break;
                case 4:
                    printSong(myPlaylist);
                    break;
                case 5:
                    if(myPlaylist.size()>0) {
                        itr.remove();
                    }else
                    System.out.println("Your PlayList is Empty");
                    quit=true;
                    break;
                case 6:
                    printMenu();
                    break;
                case 7:
                    exit(0);
            }
        }
    }
    public static void printSong(LinkedList<Song>myPlayList){
        for(Song s:myPlayList){
            System.out.println(s);
        }
        return;
    }
    public static void printMenu(){
        System.out.println("1. Play Next Song");
        System.out.println("2 Play previous Song");
        System.out.println("3. Repeat the current song");
        System.out.println("4. Show all Song int the Playlist");
        System.out.println("5. Delete the current song ");
        System.out.println("6. Show the Menu again");
        System.out.println("7. Exit");
    }
}