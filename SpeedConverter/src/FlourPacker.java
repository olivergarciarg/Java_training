public class FlourPacker {
    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (bigCount<0 || smallCount<0 || goal<0) {
            return false;
        }
        int bigNeeded = goal / 5;
        int smallNeeded = goal % 5;
        int newGoal;
        if (bigNeeded > bigCount) {
            newGoal = goal - smallCount;
            bigNeeded = newGoal / 5;
            if (newGoal <= 5 * bigCount){
                return true;
            }
            return false;
        } else if (smallNeeded > smallCount) {
            return false;
        }
        return true;
    }
}
