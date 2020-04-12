package Note.concurrency;

public class Demo09 {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 100; i++) {
            stringBuffer.append('a');
        }
    }
}
