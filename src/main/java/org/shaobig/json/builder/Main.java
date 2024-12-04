package org.shaobig.json.builder;

import org.shaobig.json.builder.object.JsonObject;

public class Main {

    public static void main(String[] args) {
        JsonObject jsonObject = new JsonObject.Builder()
                .createString("a.b.c", "ABRA")
                .createString("a.b.d", "CADABRA")
                .createInteger("a.b.e", 55)
                .createJsonObject();
        System.out.println(jsonObject.readString("a.b.c"));
        System.out.println(jsonObject.readInteger("a.b.e"));
    }

}
