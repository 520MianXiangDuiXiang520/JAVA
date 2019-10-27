package Note.exceptions;
import static junbao.tool.Print.*;
import static junbao.tool.Range.*;

class DynamicFieldsException extends Exception {}

public class DynamicFields {
    private Object [][] fields;
    public DynamicFields (int initialSize) {
        fields = new Object[initialSize][2];
        for(int i: range(initialSize)){
            fields[i] = new Object[] {null, null};
        }
    }

    public String toString(){
        StringBuffer result = new StringBuffer();
        for(Object[] obj: fields){
            result.append(obj[0]);
            result.append(": ");
            result.append(obj[1]);
            result.append("\n");
        }
        return result.toString();
    }

    private int hasField(String id){
        for(int i = 0; i < fields.length; i++){
            if(id.equals(fields[i][0]))
                return i;
        }
        return -1;
    }

    private int getFieldNumber(String id) throws NoSuchFieldError {
        int fieldNum = hasField(id);
        if(fieldNum == -1)
            throw new NoSuchFieldError();
        return fieldNum;
    }

    private int makeField(String id) {
        for(int i=0; i<fields.length; i++) {
            if (fields[i][0] == null) {
                fields[i][0] = id;
                return i;
            }
        }
        Object [][] tmp = new Object[fields.length + 1][2];
        for(int i=0; i<fields.length; i++ ){
            tmp[i] = fields[i];
        }
        for(int i = fields.length; i < tmp.length; i++){
            tmp[i] = new Object[] {null, null};
        }
        fields = tmp;
        return makeField(id);
    }
}
