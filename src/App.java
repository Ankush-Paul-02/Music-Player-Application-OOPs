import java.util.*;

public class App {

    private static ArrayList<Album> albums = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    private static void play(LinkedList<Song> playlist) {
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();

        if (playlist.size() == 0) {
            System.out.println("This playlist has no song!");
        } else {
            System.out.println("Now playing: " + listIterator.next().toString());
            printMenu();
        }

        while (!quit) {
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing: " + listIterator.next().toString());
                    } else {
                        System.out.println("There is no next song available!");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                            forward = false;
                        }
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing: " + listIterator.previous().toString());

                    } else {
                        System.out.println("We are at the first song!");
                        forward = false;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing: " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the playlist!");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing: " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached at the end playlist!");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playlist.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing: " + listIterator.next().toString());
                        } else {
                            if (listIterator.hasPrevious()) {
                                System.out.println("Now playing: " + listIterator.previous().toString());

                            }
                        }
                    }
                default:
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available options press -> ");
        System.out.println(
                "0 -> to quit!\n" + "1 -> to play next song\n" + "2 -> to play previous song\n"
                        + "3 -> to replay the current song\n" + "4 -> list of all songs\n"
                        + "5 -> print all available options\n" + "6 -> delete the current song.");
    }

    public static void printList(LinkedList<Song> playlist) {
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("---------------");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("---------------");
    }

    public static void main(String[] args) throws Exception {

        Album album = new Album("90's hit songs", "Kishor Kumar");

        album.addSong("Tu Tu Hai Wahi", 4.32);
        album.addSong("Neele Neele Amabar Par", 5.12);
        album.addSong("Wada Karo", 6.23);
        album.addSong("Pal Pal Dil K Paas", 4.36);
        albums.add(album);

        album = new Album("Romantic songs", "Arijit Singh");

        album.addSong("Hawayein", 3.56);
        album.addSong("Samjhanwa", 5.22);
        albums.add(album);

        LinkedList<Song> playlist1 = new LinkedList<>();
        albums.get(0).addToPlayList("Tu Tu Hai Wahi", playlist1);
        albums.get(0).addToPlayList("Wada Karo", playlist1);
        albums.get(1).addToPlayList("Hawayein", playlist1);
        albums.get(1).addToPlayList("Samjhanwa", playlist1);

        play(playlist1);

    }
}
