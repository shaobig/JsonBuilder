package org.shaobig.json.builder.creator;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.factory.ClassNodeCreatorEntityFactory;
import org.shaobig.json.builder.factory.EntityFactory;

public class FactoryNodeCreator<T> implements NodeCreator<T> {

    private EntityFactory<NodeCreator<T>> nodeCreatorEntityFactory;

    public FactoryNodeCreator(EntityFactory<NodeCreator<T>> nodeCreatorEntityFactory) {
        this.nodeCreatorEntityFactory = nodeCreatorEntityFactory;
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public JsonNode createNode(String path, T object) {
        setNodeCreatorEntityFactory(new ClassNodeCreatorEntityFactory<>((Class<T>) object.getClass()));
        return getNodeCreatorEntityFactory().createEntity().createNode(path, object);
    }

    public EntityFactory<NodeCreator<T>> getNodeCreatorEntityFactory() {
        return nodeCreatorEntityFactory;
    }

    public void setNodeCreatorEntityFactory(EntityFactory<NodeCreator<T>> nodeCreatorEntityFactory) {
        this.nodeCreatorEntityFactory = nodeCreatorEntityFactory;
    }

}
