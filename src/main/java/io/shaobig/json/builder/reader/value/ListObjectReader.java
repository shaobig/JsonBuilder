package io.shaobig.json.builder.reader.value;

import java.util.List;

public interface ListObjectReader {

    <T> List<T> readList(String path, Class<T> valueType);

}
