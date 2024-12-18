package io.shaobig.json.builder.reader.value.object.reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

public class ListObjectReaderSupplier implements ObjectReaderSupplier {

    @Override
    public <T> ObjectReader getObjectReader(Class<T> valueType) {
        return new ObjectMapper().readerForListOf(valueType);
    }

}
