public class STATS {

    private static int numFood ;
    private static int numEnemies;
    private static int life = 3;
    private static int level = 1;
    private static int lowSpeed;
    private static int rangeSpeed;
    private static int newFood = 2;

    private static boolean MENU = true;
    private static boolean PLAY = false;
    private static boolean END = false;

    public static boolean isMENU() {
        return MENU;
    }
    public static void setMENU(boolean MENU) {
        STATS.MENU = MENU;
    }
    public static boolean isPLAY() {
        return PLAY;
    }
    public static void setPLAY(boolean PLAY) {
        STATS.PLAY = PLAY;
    }
    public static boolean isEND() {
        return END;
    }
    public static void setEND(boolean END) {
        STATS.END = END;
    }

    public static int getNumFood() {
        return numFood;
    }

    public static void setNumFood(int numFood) {
        STATS.numFood = numFood;
    }

    public static int getNumEnemies() {
        return numEnemies;
    }

    public static void setNumEnemies(int numEnemies) {
        STATS.numEnemies = numEnemies;
    }

    public static int getLife() {
        return life;
    }

    public static void setLife(int life) {
        STATS.life = life;
    }

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        STATS.level = level;
    }

    public static int getLowSpeed() {
        return lowSpeed;
    }

    public static void setLowSpeed(int lowSpeed) {
        STATS.lowSpeed = lowSpeed;
    }

    public static int getRangeSpeed() {
        return rangeSpeed;
    }

    public static void setRangeSpeed(int rangeSpeed) {
        STATS.rangeSpeed = rangeSpeed;
    }

    public static int getNewFood() {
        return newFood;
    }

    public static void setNewFood(int newFood) {
        STATS.newFood = newFood;
    }

    public static void updateLevel(){
        switch(level){
            case 1:
                setNumFood(5);
                setNumEnemies(1);
                setLowSpeed(4);
                setRangeSpeed(4);
                break;
            case 2:
                setNumFood(7);
                setNumEnemies(2);
                setLowSpeed(1);
                setRangeSpeed(1);
                break;
            case 3:
                setNumFood(8);
                setNumEnemies(3);
                setLowSpeed(1);
                setRangeSpeed(1);
        }
    }
}