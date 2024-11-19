package org.shaobig.json.builder.factory;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.shaobig.json.builder.creator.NodeCreator;

public class GenericFactoryNodeCreator<T> extends FactoryNodeCreator<T> {

    public GenericFactoryNodeCreator(EntityFactory<NodeCreator<T>> nodeCreatorEntityFactory) {
        super(nodeCreatorEntityFactory);
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public ObjectNode createNode(String path, T object) {
        setNodeCreatorEntityFactory(new ClassNodeCreatorEntityFactory<>((Class<T>) object.getClass()));
        return getNodeCreatorEntityFactory().createEntity().createNode(path, object);
    }

}
