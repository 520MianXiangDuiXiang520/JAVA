package studentmanage;
import java.util.Scanner;

public class Teacher {
    private String name;
    private int teacherId;
    public static Teacher [] teacherTable  = new Teacher[100];
    public static int teacherCount = 0;

    Teacher(String name, int id){
        this.name = name;
        this.teacherId = id;
    }

    public String toString(){
        return this.teacherId + "   " + this.name;
    }

    public static void add(int id, String name) {
        teacherTable[teacherCount ++] = new Teacher(name, id);
    }

    public static void delete(int id) {
        for(Teacher tea: teacherTable){
            if(tea == null)
                continue;
            if(tea.teacherId == id){
//                System.out.println(tea);
                tea = null;
                break;
            }
        }
    }

    public static void delete(String name) {
        for(int i = 0; i<teacherTable.length; i++){
            if(teacherTable[i] == null)
                continue;
            if(teacherTable[i].name == name){
                System.out.println("find");
                teacherTable[i] = null;
                break;
            }
            if(i == teacherTable.length){
                System.out.println("没有这位老师");
            }
        }

    }

    public static Teacher find(int id) {
        for(Teacher tea: teacherTable){
            if(tea == null)
                continue;
            if(tea.teacherId == id){
                return tea;
            }
        }
        System.out.println("没有这位老师");
        return null;
    }

    public static Teacher find(String name) {
        for(Teacher tea: teacherTable){
            if(tea == null)
                continue;
            if(tea.name == name){
                return tea;
            }
        }
        System.out.println("没有这位老师");
        return null;
    }

    public static Teacher alter(int id) {
        Teacher tea = find(id);
        if(tea != null){
            System.out.println("请输入修改后的名字");
            Scanner input = new Scanner(System.in);
            String newName = input.nextLine();
            tea.name = newName;
            return tea;
        } else
            return null;
    }

    public static Teacher alter(String name) {
        Teacher tea = find(name);
        if(tea != null){
            System.out.println("请输入修改后的名字");
            Scanner input = new Scanner(System.in);
            String newName = input.nextLine();
            tea.name = newName;
            return tea;
        } else
            return null;
    }

    public static void printAll(){
        for(Teacher tea: teacherTable){
            if(tea == null)
                continue;
            System.out.println(tea);
        }
    }

    public static void show(){
        System.out.println("***** 教师管理 *****");
        System.out.println("请输入操作");
        System.out.println("*** 1. 增加 ***");
        System.out.println("*** 2. 删除 ***");
        System.out.println("*** 3. 查找 ***");
        System.out.println("*** 4. 修改 ***");
    }

    public static void main(String[] args) {
        while (true) {
            Scanner input = new Scanner(System.in);
            show();
            int choise = input.nextInt();
            switch (choise){
                case 1:
                    System.out.println("请输入教师 id");
                    Scanner idInput = new Scanner(System.in);
                    int addId = idInput.nextInt();
                    System.out.println("请输入教师姓名");
                    Scanner nameInput = new Scanner(System.in);
                    String addName = nameInput.nextLine();
                    add(addId, addName);
                    break;
                case 2:
                    System.out.println("要删除哪位老师？");
                    Scanner deInput = new Scanner(System.in);
                    try{
                        int deleteId = deInput.nextInt();
                        delete(deleteId);
                    }catch (Exception e){
                        String deleteName = deInput.nextLine();
                        delete(deleteName);
                    }
                    break;
                case 3:
                    System.out.println("要查找哪位老师？");
                    Scanner findInput = new Scanner(System.in);
                    try{
                        int findId = findInput.nextInt();
                        System.out.println(find(findId));
                    }catch (Exception e){
                        String findName = findInput.nextLine();
                        System.out.println(find(findName));
                    }
                    break;
                case 4:
                    break;
                case 5:
                    printAll();
                    break;
            }
        }
    }
}
