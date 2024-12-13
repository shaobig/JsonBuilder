package org.shaobig.json.builder;

import org.shaobig.json.builder.object.JsonObject;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        JsonObject jsonObject = new JsonObject.Builder()
                .createNode("a.b.c", "5")
                .createNode("a.b.d", "6")
                .createNode("a.d", "7")
                .createNode("d.a", "8")
                .createNode("d.b", List.of("1", "2", "3"))
                .createJsonObject();
        System.out.println(jsonObject);
        System.out.println(jsonObject.readList("d.b", String.class));
    }

}
