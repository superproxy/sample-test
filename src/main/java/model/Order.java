package model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<String> items = new ArrayList<String>();


    public void addItem(String item) {
        items.add(item);
    }

    public String[] getItems() {
        return items.toArray(new String[0]);
    }

}
