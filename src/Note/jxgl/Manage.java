package Note.jxgl;

import java.util.ArrayList;

public class Manage {
    ArrayList<Person> list;
    Manage(ArrayList al){
        list = al;
    }
    public void add(Person person){
        list.add(person);
    }

    protected Person find(Person per){
        /**
         * 通过对象查找
         */
        boolean isHave = false;
        for(Person person: list){
            if (person == per){
                isHave = true;
                return person;
            }

        }
        if(! isHave)
            System.out.println("没有找到！");
        return null;
    }

    protected Person find(int id){
        /**
         * 通过id查找
         */
        boolean isHave = false;
        for(Person person: list){
            if (person.id == id){
                isHave = true;
                return person;
            }

        }
        if(! isHave)
            System.out.println("没有找到！");
        return null;
    }

    protected Person find(String name){
        /**
         * 通过name查找
         */
        boolean isHave = false;
        for(Person person: list){
            if (person.name == name){
                isHave = true;
                return person;
            }
        }
        if(!isHave)
            System.out.println("没有找到！");
        return null;
    }

    public void delete(Person person){
        /**
         * 通过对象删除
         */
        if(list.contains(person)){
            list.remove(person);
            System.out.println("删除成功！");
        } else {
            System.out.println("没有找到！");
        }
    }

    public void delete(int id){
        /**
         * 通过id删除
         */
        Person findPerson = find(id);
        if(findPerson != null)
            delete(findPerson);
    }

    public void delete(String name){
        /**
         * 通过name删除
         */
        Person findPerson = find(name);
        if(findPerson != null)
            delete(findPerson);
    }

    public void getInfo(Person person){
        /**
         * 通过对象打印详细信息
         */
        Person findPerson = find(person);
        if(findPerson != null)
            System.out.println(findPerson.id + "   " + findPerson.name);
        else
            System.out.println("没找到");
    }

    public void getInfo(String name){
        /**
         * 通过name打印详细信息
         */
        Person findPerson = find(name);
        if(findPerson != null)
            getInfo(findPerson);
    }

    public void getInfo(int id){
        /**
         * 通过id打印详细信息
         */
        Person findPerson = find(id);
        if(findPerson != null)
            getInfo(findPerson);
    }

    public void alter(Person person, String newName){
        /**
         * 通过对象修改信息（修改name）
         */
        if(list.contains(person)){
            int index = list.indexOf(person);
            Person person1 = (Person)list.get(index);
            person1.name = newName;
        }
    }

    public void alert(int id,String newName){
        /**
         * 通过id修改信息（修改name）
         */
        Person findPerson = find(id);
        if(findPerson != null)
            alter(findPerson, newName);
    }

    public void alert(String name, String newName){
        /**
         * 通过name修改信息（修改name）
         */
        Person findPerson = find(name);
        if(findPerson != null)
            alter(findPerson, newName);
    }

    public void printAll(){
        /**
         * 打印所有人
         */
        System.out.println(list);
    }
}
