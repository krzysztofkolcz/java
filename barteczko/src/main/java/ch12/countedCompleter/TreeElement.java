package ch12.countedCompleter;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class TreeElement {
    private String name;
    private int sleepTime;
    private List<TreeElement> childs;

    public TreeElement(String name, int sleepTime) {
        this.name = name;
        this.sleepTime = sleepTime;
        this.childs = new ArrayList<>();
    }

    public void addChild(TreeElement element){
        childs.add(element);
    }


}
