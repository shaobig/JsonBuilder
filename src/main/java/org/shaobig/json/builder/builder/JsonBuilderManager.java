package org.shaobig.json.builder.builder;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.shaobig.json.builder.creator.NodeCreator;
import org.shaobig.json.builder.creator.merger.ObjectNodeMergerNodeCreator;

public class JsonBuilderManager implements NodeCreator<Object> {

    private ObjectNodeMergerNodeCreator<Object> objectNodeMergerNodeCreator;

    public JsonBuilderManager(ObjectNodeMergerNodeCreator<Object> objectNodeMergerNodeCreator) {
        this.objectNodeMergerNodeCreator = objectNodeMergerNodeCreator;
    }

    @Override
    public ObjectNode createNode(String path, Object object) {
        return getObjectNodeMergerNodeCreator().createNode(path, object);
    }

    public ObjectNodeMergerNodeCreator<Object> getObjectNodeMergerNodeCreator() {
        return objectNodeMergerNodeCreator;
    }

    public void setObjectNodeMergerNodeCreator(ObjectNodeMergerNodeCreator<Object> objectNodeMergerNodeCreator) {
        this.objectNodeMergerNodeCreator = objectNodeMergerNodeCreator;
    }

}
