package org.shaobig.json.builder.object.manager.reader;

import org.shaobig.json.builder.EntityFactory;
import org.shaobig.json.builder.reader.path.ChangeableListPathReader;
import org.shaobig.json.builder.reader.path.GenericPathReader;

public class GenericPathReaderManagerEntityFactory implements EntityFactory<GenericPathReaderManager> {

    private EntityFactory<GenericPathReader<String>> stringGenericPathReaderEntityFactory;
    private EntityFactory<GenericPathReader<Integer>> integerGenericPathReaderEntityFactory;
    private EntityFactory<ChangeableListPathReader> changeableListPathReaderEntityFactory;

    public GenericPathReaderManagerEntityFactory(EntityFactory<GenericPathReader<String>> stringGenericPathReaderEntityFactory, EntityFactory<GenericPathReader<Integer>> integerGenericPathReaderEntityFactory, EntityFactory<ChangeableListPathReader> changeableListPathReaderEntityFactory) {
        this.stringGenericPathReaderEntityFactory = stringGenericPathReaderEntityFactory;
        this.integerGenericPathReaderEntityFactory = integerGenericPathReaderEntityFactory;
        this.changeableListPathReaderEntityFactory = changeableListPathReaderEntityFactory;
    }

    @Override
    public GenericPathReaderManager createEntity() {
        return new GenericPathReaderManager(getStringGenericPathReaderEntityFactory().createEntity(), getIntegerGenericPathReaderEntityFactory().createEntity(), getChangeableListPathReaderEntityFactory().createEntity());
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

    public EntityFactory<ChangeableListPathReader> getChangeableListPathReaderEntityFactory() {
        return changeableListPathReaderEntityFactory;
    }

    public void setChangeableListPathReaderEntityFactory(EntityFactory<ChangeableListPathReader> changeableListPathReaderEntityFactory) {
        this.changeableListPathReaderEntityFactory = changeableListPathReaderEntityFactory;
    }

}
