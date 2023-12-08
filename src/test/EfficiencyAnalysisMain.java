import EfficiencyChart;
import edu.ithaca.dragon.datastructures.queue.LeftEndListQueue;
import edu.ithaca.dragon.datastructures.queue.RightEndListQueue;
import test.java.LinkedQueue.PlaylistLinkedQueueTest;

public class EfficiencyAnalysisMain {

    private static void createAndShow() {
        /*collectGrabBagPutData(new RandomListGrabBag<>(), "RandomListGrabBag");
        collectGrabBagPutData(new StackGrabBag<>(new RightTopListStack<>()), "RightTopListStackGrabBag");
        collectGrabBagPutData(new StackGrabBag<>(new LeftTopListStack<>()), "LeftTopListStackGrabBag");
        collectGrabBagPutData(new QueueGrabBag<>(new LeftEndListQueue<>()), "LeftEndListQueue");
        collectGrabBagPutData(new QueueGrabBag<>(new RightEndListQueue<>()), "RightEndListQueue");*/

        EfficiencyChart mainPanel = new EfficiencyChart(collectGrabBagPutData(new RandomListGrabBag<>(), "RandomListGrabBag"));
        mainPanel.setPreferredSize(new Dimension(800, 600));
        JFrame frame = new JFrame("DrawGraph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main (String[] args){
        createAndShow();
    }
}
