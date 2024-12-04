package org.shaobig.json.builder.object;

import org.shaobig.json.builder.EntityFactory;
import org.shaobig.json.builder.reader.GenericPathReader;

public class GenericPathReaderManagerEntityFactory implements EntityFactory<GenericPathReaderManager> {

    private EntityFactory<GenericPathReader<String>> stringGenericPathReaderEntityFactory;
    private EntityFactory<GenericPathReader<Integer>> integerGenericPathReaderEntityFactory;

    public GenericPathReaderManagerEntityFactory(EntityFactory<GenericPathReader<String>> stringGenericPathReaderEntityFactory, EntityFactory<GenericPathReader<Integer>> integerGenericPathReaderEntityFactory) {
        this.stringGenericPathReaderEntityFactory = stringGenericPathReaderEntityFactory;
        this.integerGenericPathReaderEntityFactory = integerGenericPathReaderEntityFactory;
    }

    @Override
    public GenericPathReaderManager createEntity() {
        return new GenericPathReaderManager(getStringGenericPathReaderEntityFactory().createEntity(), getIntegerGenericPathReaderEntityFactory().createEntity());
    }

    public EntityFactory<GenericPathReader<String>> getStringGenericPathReaderEntityFactory() {
        return stringGenericPathReaderEntityFactory;
    }

    public void setStringGenericPathReaderEntityFactory(EntityFactory<GenericPathReader<String>> stringGenericPathReaderEntityFactory) {
        this.stringGenericPathReaderEntityFactory = stringGenericPathReaderEntityFactory;
    }

    public EntityFactory<GenericPathReader<Integer>> getIntegerGenericPathReaderEntityFactory() {
        return integerGenericPathReaderEntityFactory;
    }

    public void setIntegerGenericPathReaderEntityFactory(EntityFactory<GenericPathReader<Integer>> integerGenericPathReaderEntityFactory) {
        this.integerGenericPathReaderEntityFactory = integerGenericPathReaderEntityFactory;
    }

}
