package org.shaobig.json.builder.reader.value.object.reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

public class EntityObjectReaderSupplier implements ObjectReaderSupplier {

    @Override
    public <T> ObjectReader getObjectReader(Class<T> valueType) {
        return new ObjectMapper().readerFor(valueType);
    }

}
