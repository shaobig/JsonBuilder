package org.shaobig.json.builder.reader.path.list;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.reader.path.ChangeableListPathReader;
import org.shaobig.json.builder.reader.path.ChangeablePathReader;
import org.shaobig.json.builder.reader.value.list.ListValueReader;

import java.util.List;

public class ListGenericPathReader implements ChangeableListPathReader {

    private ChangeablePathReader<JsonNode> jsonNodePathReader;
    private ListValueReader listValueReader;

    public ListGenericPathReader(ChangeablePathReader<JsonNode> jsonNodePathReader, ListValueReader listValueReader) {
        this.jsonNodePathReader = jsonNodePathReader;
        this.listValueReader = listValueReader;
    }

    @Override
    public <T> List<T> readList(String path, Class<T> classType) {
        return getListValueReader().readList(getJsonNodePathReader().readPath(path), classType);
    }

    @Override
    public void setJsonNode(JsonNode jsonNode) {
        getJsonNodePathReader().setJsonNode(jsonNode);
    }

    public ChangeablePathReader<JsonNode> getJsonNodePathReader() {
        return jsonNodePathReader;
    }

    public void setJsonNodePathReader(ChangeablePathReader<JsonNode> jsonNodePathReader) {
        this.jsonNodePathReader = jsonNodePathReader;
    }

    public ListValueReader getListValueReader() {
        return listValueReader;
    }

    public void setListValueReader(ListValueReader listValueReader) {
        this.listValueReader = listValueReader;
    }

}
