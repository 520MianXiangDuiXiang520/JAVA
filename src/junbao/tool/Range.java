package junbao.tool;

public class Range {

    // 0-stop
    public static int[] range (int stop){
        int[] result = new int[stop];
        for(int i=0;i < stop; i++){
            result[i] = i;
        }
        return result;
    }

    // start-stop
    public static int[] range (int start, int stop){
        int length = stop - start;
        int[] result = new int[length];
        for(int i = 0; i < length; i++){
            result[i] = i + start;
        }
        return result;
    }

    // start-stop step = x
    public static int[] range (double start, double stop,double step){
        int length = (int)Math.round((stop - start) / step) ;
        int[] result = new int[length];
        for(int i = 0; i < length; i++){
            result[i] = (i * (int)step) + (int)start;
        }
        return result;
    }
}
