package org.shaobig.json.builder.reader.value;

import java.util.List;

public interface ListValueReader {

    <T> List<T> readList(String path, Class<T> valueType);

}
