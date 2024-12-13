package org.shaobig.json.builder.object;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.creator.*;
import org.shaobig.json.builder.creator.merger.CopyNodeMerger;
import org.shaobig.json.builder.creator.merger.RecursiveNodeMerger;
import org.shaobig.json.builder.creator.merger.stream.UnknownSizeSpliteratorSupplier;
import org.shaobig.json.builder.object.builder.EntityBuilderCreator;
import org.shaobig.json.builder.object.builder.JsonObjectBuilderCreator;
import org.shaobig.json.builder.object.manager.JsonObjectManager;
import org.shaobig.json.builder.object.manager.NodeCreatorManager;
import org.shaobig.json.builder.object.manager.ValueReaderManager;
import org.shaobig.json.builder.reader.path.JsonPathReader;
import org.shaobig.json.builder.reader.path.NestedJsonPathReader;
import org.shaobig.json.builder.reader.value.EntityListValueReader;
import org.shaobig.json.builder.reader.value.EntityValueReader;
import org.shaobig.json.builder.reader.value.ListValueReader;
import org.shaobig.json.builder.reader.value.ValueReader;
import org.shaobig.json.builder.reader.value.object.reader.EntityObjectReaderSupplier;
import org.shaobig.json.builder.reader.value.object.reader.ListObjectReaderSupplier;

import java.util.List;

public class JsonObject implements NodeCreator, ValueReader, ListValueReader {

    private JsonObjectManager jsonObjectManager;

    public JsonObject(JsonObjectManager jsonObjectManager) {
        this.jsonObjectManager = jsonObjectManager;
    }

    @Override
    public JsonNode createNode(String path, Object object) {
        return getJsonObjectManager().createNode(path, object);
    }

    @Override
    public <T> T readValue(String path, Class<T> valueType) {
        return getJsonObjectManager().readValue(path, valueType);
    }

    @Override
    public <T> List<T> readList(String path, Class<T> classType) {
        return getJsonObjectManager().readList(path, classType);
    }

    public JsonObjectManager getJsonObjectManager() {
        return jsonObjectManager;
    }

    public void setJsonObjectManager(JsonObjectManager jsonObjectManager) {
        this.jsonObjectManager = jsonObjectManager;
    }

    @Override
    public String toString() {
        return getJsonObjectManager().toString();
    }

    public static class Builder implements EntityBuilderCreator, JsonObjectBuilderCreator {

        private JsonObjectManager jsonObjectManager;

        private Builder(JsonObjectManager jsonObjectManager) {
            this.jsonObjectManager = jsonObjectManager;
        }

        public Builder() {
            JsonNode jsonNode = new NewObjectNodeSupplier().supplyNode();
            JsonNodeCreator jsonNodeCreator = new MergeJsonNodeCreator(jsonNode, new RecursiveNodeMerger(new NewObjectNodeSupplier(), new CopyNodeMerger(new UnknownSizeSpliteratorSupplier<>())), new NestedEntityNodeCreator(new NewObjectNodeSupplier(), new EntityNodeCreator(new NewObjectNodeSupplier())));
            JsonPathReader pathReader = new NestedJsonPathReader(jsonNode);
            EntityValueReader valueReader = new EntityValueReader(new EntityObjectReaderSupplier(), pathReader);
            EntityListValueReader listValueReader = new EntityListValueReader(new ListObjectReaderSupplier(), pathReader);
            this.jsonObjectManager = new JsonObjectManager(jsonNode, new NodeCreatorManager(jsonNodeCreator), new ValueReaderManager(valueReader, listValueReader));
        }

        @Override
        public Builder createNode(String path, Object object) {
            getJsonBuilderManager().createNode(path, object);
            return this;
        }

        @Override
        public JsonObject createJsonObject() {
            return new JsonObject(getJsonBuilderManager());
        }

        public JsonObjectManager getJsonBuilderManager() {
            return jsonObjectManager;
        }

        public void setJsonBuilderManager(JsonObjectManager jsonObjectManager) {
            this.jsonObjectManager = jsonObjectManager;
        }

    }

}
