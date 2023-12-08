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

    public static long timeAddSongToStart(Playlist<Song> playlist, Song song) {
        long startTime = System.nanoTime();
        playlist.addSongToStart(song);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static long averageTimeAddSongToStart(Playlist<Song> playlist, Song song, int numTimes) {
        long totalTime = 0;
        for (int i = 0; i < numTimes; i++) {
            totalTime += timeAddSongToStart(playlist, song);
        }
        return totalTime / numTimes;
    }





    
    public static DefaultCategoryDataset collectPlaylistEfficiencyAddData(Playlist<Song> playlist, String playlistImplementationType) {
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
    public static long timeTotalDuration(Playlist<Song> playlist) {
        long startTime = System.nanoTime();
        playlist.totalDuration();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static long averageTimeTotalDuration(Playlist<Song> playlist, int numTimes) {
        long totalTime = 0;
        for (int i = 0; i < numTimes; i++) {
            totalTime += timeTotalDuration(playlist);
        }
        return totalTime / numTimes;
    }

    public static DefaultCategoryDataset collectPlaylistEfficiencyTotalDurationData(Playlist<Song> playlist, String playlistImplementationType) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int putCount = 10000;
        int numTimes = 50;
        int numDataPointToPrint = 50;
        System.out.println("Starting " + playlistImplementationType + " total duration efficiency test");
        for (int i = 0; i < numDataPointToPrint; i++) {
            addManySongs(i, playlist);
            double avgTime = averageTimeTotalDuration(playlist, numTimes);
            System.out.println((i+1)*putCount + " \t\t " + avgTime);     
            String s = avgTime + "";   
            dataset.addValue((i+1)*putCount, playlistImplementationType, s);
        }
        return dataset;
    }
    public static DefaultCategoryDataset collectPlaylistEfficiencyRemoveData(Playlist<Song> playlist, String playlistImplementationType) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int putCount = 10000;
        int numTimes = 50;
        int numDataPointToPrint = 50;
        System.out.println("Starting " + playlistImplementationType + " remove efficiency test");
        for (int i = 0; i < numDataPointToPrint; i++) {
            addManySongs(i, playlist);
            double avgTime = averageTimeRemoveSong(playlist, new Song("Song " + i, "Artist " + i, 100, 0,0 ,0 ,0 ,0 ), numTimes);
            System.out.println((i+1)*putCount + " \t\t " + avgTime);     
            String s = avgTime + "";   
            dataset.addValue((i+1)*putCount, playlistImplementationType, s);
        }
        return dataset;
    }

    public static DefaultCategoryDataset collectPlaylistEfficiencyAddToStartData(Playlist<Song> playlist, String playlistImplementationType) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int putCount = 10000;
        int numTimes = 50;
        int numDataPointToPrint = 50;
        System.out.println("Starting " + playlistImplementationType + " add to start efficiency test");
        for (int i = 0; i < numDataPointToPrint; i++) {
            addManySongs(i, playlist);
            double avgTime = averageTimeAddSongToStart(playlist, new Song("Song " + i, "Artist " + i, 100, 0,0 ,0 ,0 ,0 ), numTimes);
            System.out.println((i+1)*putCount + " \t\t " + avgTime);     
            String s = avgTime + "";   
            dataset.addValue((i+1)*putCount, playlistImplementationType, s);
        }
        return dataset;
    }

    public static long timePlayNext(Playlist<Song> playlist) {
        long startTime = System.nanoTime();
        playlist.playNext();
        long endTime = System.nanoTime();
        return endTime - startTime;
    
    }

    public static long averageTimePlayNext(Playlist<Song> playlist, int numTimes) {
        long totalTime = 0;
        for (int i = 0; i < numTimes; i++) {
            totalTime += timePlayNext(playlist);
        }
        return totalTime / numTimes;
    }

    public static DefaultCategoryDataset collectPlaylistEfficiencyPlayNextData(Playlist<Song> playlist, String playlistImplementationType) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int putCount = 10000;
        int numTimes = 50;
        int numDataPointToPrint = 50;
        System.out.println("Starting " + playlistImplementationType + " playNext efficiency test");
        for (int i = 0; i < numDataPointToPrint; i++) {
            addManySongs(i, playlist);
            double avgTime = averageTimePlayNext(playlist, numTimes);
            System.out.println((i+1)*putCount + " \t\t " + avgTime);     
            String s = avgTime + "";   
            dataset.addValue((i+1)*putCount, playlistImplementationType, s);
        }
        return dataset;
    }

    public static long timeGetSize(Playlist<Song> playlist) {
        long startTime = System.nanoTime();
        playlist.getSize();
        long endTime = System.nanoTime();
        return endTime - startTime;
        }

    public static double averageTimeGetSize(Playlist<Song> playlist, int numTimes) {
        long totalTime = 0;
        for (int i = 0; i < numTimes; i++) {
            totalTime += timePlayNext(playlist);
        }
        return totalTime / numTimes;
        }

    public static DefaultCategoryDataset collectPlaylistEfficiencyGetSizeData(Playlist<Song> playlist, String playlistImplementationType) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int putCount = 10000;
        int numTimes = 50;
        int numDataPointToPrint = 50;
        System.out.println("Starting " + playlistImplementationType + " getSize efficiency test");
        for (int i = 0; i < numDataPointToPrint; i++) {
            addManySongs(i, playlist);
            double avgTime = averageTimeGetSize(playlist, numTimes);
            System.out.println((i+1)*putCount + " \t\t " + avgTime);
            String s = avgTime + "";
            dataset.addValue((i+1)*putCount, playlistImplementationType, s);
        }
        return dataset;
    }



    public static void timeAllSongs(Playlist<Song> playlist) {
        long startTime = System.nanoTime();
        playlist.allSongs();
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }

    public static void averageTimeAllSongs(Playlist<Song> playlist, int numTimes) {
        long totalTime = 0;
        for (int i = 0; i < numTimes; i++) {
            totalTime += timePlayNext(playlist);
        }
        System.out.println(totalTime / numTimes);
    }



    public static void main(String[] args){
        new EfficiencyChart(collectPlaylistEfficiencyAddData(new PlaylistArrayList(), "ArrayListPlaylist-Add"));
        new EfficiencyChart(collectPlaylistEfficiencyAddData(new PlaylistLinkedQueue(), "LinkedQueuePlaylist-Add"));
        new EfficiencyChart(collectPlaylistEfficiencyRemoveData(new PlaylistArrayList(), "ArrayListPlaylist-Remove"));
        new EfficiencyChart(collectPlaylistEfficiencyRemoveData(new PlaylistLinkedQueue(), "LinkedQueuePlaylist-Remove"));
        new EfficiencyChart(collectPlaylistEfficiencyAddToStartData(new PlaylistArrayList(), "ArrayListPlaylist-AddToStart"));
        new EfficiencyChart(collectPlaylistEfficiencyAddToStartData(new PlaylistLinkedQueue(), "LinkedQueuePlaylist-AddToStart"));
        new EfficiencyChart(collectPlaylistEfficiencyPlayNextData(new PlaylistArrayList(), "ArrayListPlaylist-PlayNext"));
        new EfficiencyChart(collectPlaylistEfficiencyPlayNextData(new PlaylistLinkedQueue(), "LinkedQueuePlaylist-PlayNext"));
        new EfficiencyChart(collectPlaylistEfficiencyTotalDurationData(new PlaylistArrayList(), "ArrayListPlaylist-TotalDuration"));
        new EfficiencyChart(collectPlaylistEfficiencyTotalDurationData(new PlaylistLinkedQueue(), "LinkedQueuePlaylist-TotalDuration"));
        new EfficiencyChart(collectPlaylistEfficiencyGetSizeData(new PlaylistArrayList(), "ArrayListPlaylist-GetSize"));
        new EfficiencyChart(collectPlaylistEfficiencyGetSizeData(new PlaylistLinkedQueue(), "LinkedQueuePlaylist-GetSize"));

    }

}

