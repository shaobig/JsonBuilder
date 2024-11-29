package org.shaobig.json.builder;

import org.shaobig.json.builder.object.JsonObject;

public class Main {

    public static void main(String[] args) {
        JsonObject jsonObject = new JsonObject.Builder()
                .insertNode("a.b.c", "ABRA")
                .insertNode("a.b.d", "CADABRA")
                .insertNode("a.b.e", 55)
                .insertNode("a.b.f.g.a.b.c", "FFFF")
                .insertNode("a", "FFFF")
                .createJsonObject();
        System.out.println(jsonObject);
    }

}
