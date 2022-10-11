package pages.utils;


import java.util.*;

public final class CollectionUtils {
    public static final String DEFAULT_SEPARATOR = ", ";
    public static final String DEFAULT_START = "[";
    public static final String DEFAULT_END = "]";

    private CollectionUtils() {
    }

    public static <T> List<List<T>> split(List<T> list, int chunkSize) {
        List<List<T>> chunks = new ArrayList();

        List nextChunk;
        for (nextChunk = list; chunkSize < nextChunk.size(); nextChunk = nextChunk.subList(chunkSize, nextChunk.size())) {
            chunks.add(nextChunk.subList(0, chunkSize));
        }

        if (nextChunk.size() != 0) {
            chunks.add(nextChunk);
        }

        return chunks;
    }

    public static <T> T getRandomElement(List<T> list) {
        return isEmpty(list) ? null : list.get((new Random()).nextInt(list.size()));
    }

    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }


    public static <Input, Output, CollectionOutput extends Collection<Output>> CollectionOutput collect(Collection<Input> input, CollectionOutput output, Transformer<Input, Output> transformer) {
        Iterator var3 = input.iterator();

        while (var3.hasNext()) {
            Input object = (Input) var3.next();
            output.add(transformer.transform(object));
        }

        return output;
    }

    public static <Input> void each(Collection<Input> collection, Performer<Input> performer) {
        Iterator var2 = collection.iterator();

        while (var2.hasNext()) {
            Input o = (Input) var2.next();
            performer.dO(o);
        }

    }

    public interface Performer<Input> {
        void dO(Input var1);
    }

    public interface Transformer<Input, Output> {
        Output transform(Input var1);
    }
}
