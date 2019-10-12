package studentmanage;

public interface PeopleOperation {
    /**
     * 增删查改接口
     */
    void add(int id, String name);
    void delete(int id);
    void delete(String name);
    People find(int id);
    People find(String name);
    People alter(int id);
    People alter(String name);
}
