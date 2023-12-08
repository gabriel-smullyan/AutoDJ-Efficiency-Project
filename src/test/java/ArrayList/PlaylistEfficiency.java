package ArrayList;
import org.jfree.data.category.DefaultCategoryDataset;
import java.util.ArrayList;
import edu.ithaca.autodj.*;
import interfaces.*;




public class PlaylistEfficiency {

    public static long timeAddSong(Playlist<Song> playlist, Song song) {
        long startTime = System.nanoTime();
        playlist.addSong(song);
        long endTime = System.nanoTime();
        return endTime - startTime;
        
    }

    public static long timeRemoveSong(Playlist<Song> playlist, Song song) {
        long startTime = System.nanoTime();
        playlist.removeSong(song);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static long averageTimeAddSong(Playlist<Song> playlist, Song song, int numTimes) {
        long totalTime = 0;
        for (int i = 0; i < numTimes; i++) {
            totalTime += timeAddSong(playlist, song);
        }
        return totalTime / numTimes;
    }

    public static long averageTimeRemoveSong(Playlist<Song> playlist, Song song, int numTimes) {
        for (int i=0; i<numTimes; i++){
            playlist.addSong(new Song("Song " + i, "Artist " + i, 100, 0,0 ,0 ,0 ,0 ));
        }
        long totalTime = 0;
        for (int i = numTimes - 1; i < 0; i--) {
            totalTime += timeRemoveSong(playlist, song);
        }
        return totalTime / numTimes;
    }

    public static void addManySongs(int putCount, Playlist<Song> playlist) {
        for (int i=0; i<putCount; i++){
            playlist.addSong(new Song("Song " + i, "Artist " + i, 100, 0,0 ,0 ,0 ,0 ));
        }
    }



    
    public static DefaultCategoryDataset collectArrayListEfficiencyAddData(Playlist<Song> playlist, String playlistImplementationType) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int putCount = 10000;
        int numTimes = 50;
        int numDataPointToPrint = 50;
        System.out.println("Starting " + playlistImplementationType + " add efficiency test");
        for (int i = 0; i < numDataPointToPrint; i++) {
            addManySongs(i, playlist);
            double avgTime = averageTimeAddSong(playlist, new Song("Song " + i, "Artist " + i, 100, 0,0 ,0 ,0 ,0 ), numTimes);
            //System.out.println((i+1)*putCount + " \t\t " + avgTime);     
            String s = avgTime + "";   
            dataset.addValue((i+1)*putCount, playlistImplementationType, s);
        }
        return dataset;
    }

    public static void main(String[] args){
        new EfficiencyChart(collectArrayListEfficiencyAddData(new PlaylistArrayList(), "ArrayListPlaylist"));
        new EfficiencyChart(collectArrayListEfficiencyAddData(new PlaylistLinkedQueue(), "LinkedQueuePlaylist"));
         
    }

}

