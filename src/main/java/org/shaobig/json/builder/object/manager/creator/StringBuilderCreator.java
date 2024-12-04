package org.shaobig.json.builder.object.manager.creator;

import org.shaobig.json.builder.object.JsonObject;

public interface StringBuilderCreator {

    JsonObject.Builder createString(String path, String string);

}
