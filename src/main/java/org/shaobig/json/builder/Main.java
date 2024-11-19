package org.shaobig.json.builder;

import org.shaobig.json.builder.builder.JsonObject;

public class Main {

    public static void main(String[] args) {
        JsonObject jsonObject = new JsonObject.Builder()
                .insertNode("a.b.c", "OBJ1")
                .insertNode("a.b.d", "OBJ2")
                .insertNode("a.b.e", 55)
                .createJsonObject();
        System.out.println(jsonObject);
    }

}
