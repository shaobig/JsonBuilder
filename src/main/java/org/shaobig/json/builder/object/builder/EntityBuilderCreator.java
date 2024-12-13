package org.shaobig.json.builder.object.builder;

import org.shaobig.json.builder.object.JsonObject;

public interface EntityBuilderCreator {

    JsonObject.Builder createNode(String path, Object object);

}
