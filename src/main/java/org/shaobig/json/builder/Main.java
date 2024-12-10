package org.shaobig.json.builder;

import org.shaobig.json.builder.object.JsonObject;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        JsonObject jsonObject = new JsonObject.Builder()
                .createString("a.b.c", "ABC")
                .createString("a.b.d", "ABD")
                .createInteger("a.b.e", 123)
                .createList("a.b.f", List.of(true, false, true))
                .createJsonObject();
        System.out.println(jsonObject.readList("a.b.f", Boolean.class));
    }

}
