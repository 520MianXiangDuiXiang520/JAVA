package 上课.jxgl;

import java.util.ArrayList;

public class Manage implements ManageInterface {
    public ArrayList<Things> list;
    Manage(ArrayList al){
        list = al;
    }

    @Override
    public void add(Things obj) {
        list.add(obj);
        System.out.println("添加成功");
    }

    @Override
    public Things find(Things obj) {
        boolean isHave = false;
        for(Things object: list){
            if (object == obj){
                isHave = true;
                return object;
            }

        }
        if(! isHave)
            System.out.println("没有找到！");
        return null;
    }

    @Override
    public Things find(int id) {
        boolean isHave = false;
        for(Things object: list){
            if (object.id == id){
                isHave = true;
                return object;
            }

        }
        if(! isHave)
            System.out.println("没有找到！");
        return null;
    }

    @Override
    public Things find(String name) {
        boolean isHave = false;
        for(Things object: list){
            if (object.name == name){
                isHave = true;
                return object;
            }

        }
        if(! isHave)
            System.out.println("没有找到！");
        return null;
    }

    @Override
    public void delete(Things obj) {
        if(list.contains(obj)){
            list.remove(obj);
            System.out.println("删除成功！");
        } else {
            System.out.println("没有找到！");
        }
    }

    @Override
    public void delete(int id) {
        Things findThings = find(id);
        if(findThings != null)
            delete(findThings);
    }

    @Override
    public void delete(String name) {
        Things findThings = find(name);
        if(findThings != null)
            delete(findThings);
    }

    @Override
    public void getInfo(Things obj) {
        Things findThings = find(obj);
        if(findThings != null)
            System.out.println(findThings.id + "   " + findThings.name);
        else
            System.out.println("没找到");
    }

    @Override
    public void getInfo(int id) {
        Things findThings = find(id);
        if(findThings != null)
            this.getInfo(findThings);
    }

    @Override
    public void getInfo(String name) {
        Things findThings = find(name);
        if(findThings != null)
            this.getInfo(findThings);
    }

    @Override
    public void alert(Things obj, String newName) {
        if(list.contains(obj)){
            int index = list.indexOf(obj);
            Things things = (Things) list.get(index);
            things.name = newName;
        }
    }

    @Override
    public void alert(int id, String newName) {
        Things findThings = find(id);
        if(findThings != null)
            alert(findThings, newName);
    }

    @Override
    public void alert(String name, String newName) {
        Things findThings = find(name);
        if(findThings != null)
            alert(findThings, newName);
    }

    @Override
    public void printAll() {
        System.out.println(list);
    }
}
