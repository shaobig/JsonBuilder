package org.shaobig.json.builder;

import org.shaobig.json.builder.object.JsonObject;

public class Main {

    public static void main(String[] args) {
        JsonObject jsonObject = new JsonObject.Builder()
                .insertString("a.b.c", "ABRA")
                .insertString("a.b.d", "CADABRA")
                .insertInteger("a.b.e", 55)
                .createJsonObject();
        System.out.println(jsonObject.readString("a.b.c"));
        System.out.println(jsonObject.readInteger("a.b.e"));
    }

}
