package marino.shoppinglist;

import java.util.ArrayList;
import java.util.List;

public class toDoList {

    //***************************
    // Instances
    //***************************
    ArrayList<String> item_list;
    String group_name;

    //****************************
    // Setters
    //****************************

    public void addItem(String item) {
        item_list.add(item);
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    //****************************
    // Getters
    //****************************

    public List<String> getItem_name() {
        return item_list;
    }

    public String getGroup_name() {
        return group_name;
    }

    //****************************
    // Constructor
    //****************************

    toDoList() {
        item_list = new ArrayList<>();
    }
}
