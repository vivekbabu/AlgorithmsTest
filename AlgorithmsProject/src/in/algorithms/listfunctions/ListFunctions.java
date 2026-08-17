package in.algorithms.listfunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListFunctions {
    public static <T> List<T> flatten(List<?> list) {
        List<T> flattened = new ArrayList<>();
        for (Object item : list) {
            if (item instanceof List<?>) {
                flattened.addAll(flatten((List<?>) item));
            } else {
                @SuppressWarnings("unchecked")
                T val = (T) item;
                flattened.add(val);
            }
        }
        return flattened;
    }

    public static void main(String[] args) {
        List<?> nested = Arrays.asList(Arrays.asList(1, 1), 2, Arrays.asList(3, Arrays.asList(5, 8)));
        System.out.println("Flattened: " + flatten(nested));
    }
}
