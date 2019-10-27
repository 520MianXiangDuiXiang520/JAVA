package 上课.jxgl;

public interface ManageInterface {
    void add(Things obj);

    Things find(Things obj);
    Things find(int id);
    Things find(String name);

    void delete(Things obj);
    void delete(int id);
    void delete(String name);

    void getInfo(Things obj);
    void getInfo(int id);
    void getInfo(String name);

    void alert(Things obj, String newName);
    void alert(int id, String newName);
    void alert(String name, String newName);

    void printAll();
}
