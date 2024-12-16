package io.shaobig.json.builder.object.builder;

import io.shaobig.json.builder.object.JsonObject;

public interface EntityBuilderCreator {

    JsonObject.Builder createObject(String path, Object object);

}
