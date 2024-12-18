package io.shaobig.json.builder.reader.path;

import com.fasterxml.jackson.databind.JsonNode;

public interface PathReader {

    JsonNode readPath(String path);

}
