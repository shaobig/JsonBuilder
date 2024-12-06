package org.shaobig.json.builder.object.manager.creator;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public interface ListNodeCreator {

    JsonNode createList(String path, List<?> list);

}
