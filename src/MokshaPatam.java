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
        int min_rolls = 0;
        int placement = 0;
        int ladder = getLadderLocation(ladders, placement);
        int ladder_location = 0;
        // Get the coordinate of the ladder we need to get to
        ladder_location = ladders[ladder][0];
        min_rolls += getMinRolls(ladder_location);
        // Get the end point of the ladder
        placement = ladders[ladder][1];
        while(placement < boardsize){
            ladder = getLadderLocation(ladders, placement);
            // Look for next ladder to go on
            if(ladder != 0){
                ladder_location = ladders[ladder][0];
                min_rolls += getMinRolls(ladder_location);
                placement = ladders[ladder][1];
            }
            else{

            }
        }

        return 0;
    }
    // Finds the first ladder we want to go on by finding the biggest difference between all the ladders
    private static int getLadderLocation(int[][] ladders, int placement){
        int biggest_difference = 0;
        int difference = 0;
        int ladder_start = 0;
        for(int i = 0; i < ladders.length;i++){
            for(int j = 0; j < ladders[0].length; j++){
                // Once we are at the value at the end of the ladder
                if(j == 1){
                    // Check if the ladder is available to us
                    if(placement < ladders[i][0]){
                        difference = ladders[i][j] - ladders[i][j - 1];
                        // Find the best ladder
                        if(difference > biggest_difference){
                            biggest_difference = difference;
                            ladder_start = i;
                        }
                    }
                }
            }
        }
        return ladder_start;
    }
    private static int getMinRolls(int destination){
        int rolls = 0;
        int copy_destination = destination;
        int dice = 6;
        while(copy_destination != 0){
            // Roll for six
            rolls += copy_destination / dice;
            copy_destination = destination % dice;
            dice--;
        }
        return rolls;

    }
}
