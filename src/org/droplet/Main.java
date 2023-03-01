package org.droplet;

import org.droplet.collection.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(i + "", i);
        }
        System.out.println(list);
    }
}