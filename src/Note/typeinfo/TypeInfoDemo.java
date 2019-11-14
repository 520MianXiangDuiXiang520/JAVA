package Note.typeinfo;

import java.util.ArrayList;
import java.util.List;

class PermissionDenied extends Exception {
    public PermissionDenied(String s) {
        super(s);
    }
}

class BasePermission {
    boolean has_permission() {
        return true;
    }
}

class CommonPermission extends BasePermission {
    @Override
    boolean has_permission() {
        return true;
    }
}

class VipPermission extends BasePermission {
    @Override
    boolean has_permission() {
        return false;
    }
}

public class TypeInfoDemo {
    private List<BasePermission> permission_classes = new ArrayList<>();
    public static String[] DEFAULT_PERMISSION_CLASSES = {"Note.typeinfo.CommonPermission"};

    public List<? extends BasePermission> get_permissions() {
        try{
            for (String permission: DEFAULT_PERMISSION_CLASSES
                 ) {
                Class class1 = Class.forName(permission);
                permission_classes.add((BasePermission) class1.newInstance());
            }

        }catch(Exception e) {
            throw new RuntimeException(e);
        }
        return permission_classes;
    }

    public void check_permissions() {
        for (BasePermission bp: get_permissions()
        ) {
            if(!bp.has_permission()){
                throw new RuntimeException(new PermissionDenied("403"));
            }
        }
    }

    public static void main(String[] args) {
        TypeInfoDemo typeInfoDemo = new TypeInfoDemo();
        typeInfoDemo.check_permissions();
    }

}
