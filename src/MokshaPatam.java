import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
 *
 */

public class MokshaPatam {

    /**
     * TODO: Complete this function, fewestMoves(), to return the minimum number of moves
     *  to reach the final square on a board with the given size, ladders, and snakes.
     */
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {
        int currentNode = 0;
        int node = 0;
        Queue queue = new LinkedList<Integer>();
        queue.add(1);
        // Array to save the number rolls it takes to get to a node, also to see if we have visited a node
        int[] numRolls = new int[boardsize];
        // Array of ladders and snakes where the index is the starting node and value is ending node
        int[] snakesAndLadders = new int[boardsize + 1];
        for (int i = 0; i < ladders.length; i++) {
            snakesAndLadders[ladders[i][0]] = ladders[i][1];
        }
        for (int i = 0; i < snakes.length; i++) {
            snakesAndLadders[snakes[i][0]] = snakes[i][1];
        }
        // Breadth-First_Search
        while (!queue.isEmpty()) {
            // Cast into Integer because it is returning an object
            currentNode = (int) queue.remove();
            // For loop to check all nodes for each dice roll
            for (int diceRoll = 1; diceRoll < 7; diceRoll++) {
                node = currentNode + diceRoll;
                if (node == boardsize) {
                    return numRolls[currentNode - 1] + 1;
                }
                // Check if the node is a snake or ladder
                if (snakesAndLadders[node] != 0) {
                    node = snakesAndLadders[node];
                }
                // Check node to see if they are unvisited
                if (numRolls[node - 1] == 0) {
                    // Once we reach the end of the board we return number of rolls it took to get there
                    if (node == boardsize) {
                        return numRolls[currentNode - 1] + 1;
                    }
                    // Save the number of rolls
                    numRolls[node - 1] += numRolls[currentNode - 1] + 1;
                    // Add to queue
                    queue.add(node);
                }
            }
        }
        return -1;
    }
}