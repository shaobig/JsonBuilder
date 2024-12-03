package org.shaobig.json.builder.reader;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.object.JsonNodeSetter;

public interface JsonNodePathReader extends PathReader<JsonNode>, JsonNodeSetter {}
