package org.shaobig.json.builder;

import org.shaobig.json.builder.object.JsonObject;

public class Main {

    public static void main(String[] args) {
        JsonObject jsonObject = new JsonObject.Builder()
                .insertNode("a.b.c", "ABRA")
                .insertNode("a.b.d", "CADABRA")
                .insertNode("a.b.e", 55)
                .createJsonObject();
        System.out.println(jsonObject.readString("a.b.c"));
    }

}
