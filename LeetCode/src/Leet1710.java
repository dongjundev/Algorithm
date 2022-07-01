import java.util.*;

public class Leet1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int sum = 0;

        Arrays.sort(boxTypes, (o1, o2) -> {
            return o2[1] - o1[1];
        });

        for (int[] boxOne : boxTypes){
            if(truckSize<boxOne[0]){
                sum += truckSize*boxOne[1];
                return sum;
            }

            sum += boxOne[0] * boxOne[1];
            truckSize -= boxOne[0];
        }

        return sum;
    }
}
