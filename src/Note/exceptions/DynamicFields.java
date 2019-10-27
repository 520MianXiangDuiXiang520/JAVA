package Note.exceptions;
import 上课.interfacedemo.D;

import static junbao.tool.Print.*;
import static junbao.tool.Range.*;

class DynamicFieldsException extends Exception {
}

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

    public Object getField(String id) throws NoSuchFieldError {
        return fields[getFieldNumber(id)][1];
    }

    public Object setField(String id, Object value) throws DynamicFieldsException, NullPointerException {
        if (value == null) {
            DynamicFieldsException dfe = new DynamicFieldsException();
            dfe.initCause(new NullPointerException());
            throw dfe;
        }
        int fieldNumber = hasField(id);
        if(fieldNumber == -1){
            fieldNumber = makeField(id);
        }
        Object result = null;
        try{
            result = getField(id);
        }catch(NoSuchFieldError e){
            throw new RuntimeException(e);
        }
        fields[fieldNumber][1] = value;
        return result;
    }

    public static void main(String[] args) {
        DynamicFields df = new DynamicFields(3);
        coutln(df);
        try{
            df.setField("d", "A value of d");
            df.setField("number", 47);
            df.setField("number2", 48);
            coutln(df);
            df.setField("d","A new field of d");
            df.setField("number3", 11);
            coutln("df: " + df);
            Object field = df.setField("d", null);
        }catch(NoSuchFieldError e){
            e.printStackTrace(System.out);
        }catch (DynamicFieldsException e) {
            e.printStackTrace(System.out);
        }
    }
}
