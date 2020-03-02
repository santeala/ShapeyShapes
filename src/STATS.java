public class STATS {

    private static int numFood ;
    private static int numEnemies;
    private static int life = 3;
    private static int level = 1;
    private static int lowSpeed;
    private static int rangeSpeed;

    private static boolean MENU = true;
    private static boolean PAUSE = false;
    private static boolean PLAY = false;

    public static boolean isMENU() {
        return MENU;
    }
    public static void setMENU(boolean MENU) {
        STATS.MENU = MENU;
    }
    public static boolean isPAUSE() {
        return PAUSE;
    }
    public static void setPAUSE(boolean PAUSE) {
        STATS.PAUSE = PAUSE;
    }
    public static boolean isPLAY() {
        return PLAY;
    }
    public static void setPLAY(boolean PLAY) {
        STATS.PLAY = PLAY;
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

    public static void updateLevel(){
        switch(level){
            case 1:
                setNumFood(5);
                setNumEnemies(1);
                setLowSpeed(4);
                setRangeSpeed(4);
                break;
            case 2:
                setNumFood(8);
                setNumEnemies(3);
                setLowSpeed(5);
                setRangeSpeed(7);
        }
    }
}