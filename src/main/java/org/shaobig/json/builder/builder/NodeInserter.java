package org.shaobig.json.builder.builder;

public interface NodeInserter {

    JsonObject.Builder insertNode(String path, Object object);

}
