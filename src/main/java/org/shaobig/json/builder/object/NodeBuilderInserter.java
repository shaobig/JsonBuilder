package org.shaobig.json.builder.object;

public interface NodeBuilderInserter<T> {

    JsonObject.Builder insertNode(String path, T entity);

}
