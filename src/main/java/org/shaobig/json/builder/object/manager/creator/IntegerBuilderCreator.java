package org.shaobig.json.builder.object.manager.creator;

import org.shaobig.json.builder.object.JsonObject;

public interface IntegerBuilderCreator {

    JsonObject.Builder createInteger(String path, Integer integer);

}
