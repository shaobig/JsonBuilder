package org.shaobig.json.builder.object.builder;

import org.shaobig.json.builder.object.JsonObject;

import java.util.List;

public interface ListBuilderCreator {

    JsonObject.Builder createList(String path, List<?> list);

}
