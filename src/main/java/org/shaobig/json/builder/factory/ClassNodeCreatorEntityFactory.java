package org.shaobig.json.builder.factory;

import org.shaobig.json.builder.creator.IntegerNodeCreator;
import org.shaobig.json.builder.creator.NodeCreator;
import org.shaobig.json.builder.creator.StringNodeCreator;

import java.util.Map;
import java.util.Optional;

public class ClassNodeCreatorEntityFactory<T> implements EntityFactory<NodeCreator<T>> {

    private static final Map<Class<?>, NodeCreator<?>> CLASS_VALUE_CREATOR_MAP;

    static {
        CLASS_VALUE_CREATOR_MAP = Map.ofEntries(
                Map.entry(String.class, new StringNodeCreator()),
                Map.entry(Integer.class, new IntegerNodeCreator())
        );
    }

    private Class<T> classType;

    public ClassNodeCreatorEntityFactory(Class<T> classType) {
        this.classType = classType;
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public NodeCreator<T> createEntity() {
        return (NodeCreator<T>) Optional.ofNullable(CLASS_VALUE_CREATOR_MAP.get(getClassType())).orElseThrow(() -> new RuntimeException(String.format("The ValueCreator for the '%s' is not supported", getClassType())));
    }

    public Class<T> getClassType() {
        return classType;
    }

    public void setClassType(Class<T> classType) {
        this.classType = classType;
    }

}
