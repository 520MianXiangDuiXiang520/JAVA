package Note.strings;

public class WhitherStringBuilder {
    public String implicit(String[] fields) {
        String s = "";
        for(int i = 0;i<fields.length;i++){
            s += fields[i];
        }
        return s;
    }

    public String explicit(String[] fields){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0;i<fields.length;i++){
            stringBuffer.append(fields[i]);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        WhitherStringBuilder wsb = new WhitherStringBuilder();
        String [] strings = {"abc", "def", "ghi"};
        wsb.explicit(strings);
        wsb.implicit(strings);
    }
}
