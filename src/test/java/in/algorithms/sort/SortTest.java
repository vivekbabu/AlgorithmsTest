package in.algorithms.sort;

import org.junit.Test;
import org.junit.Assert;
import scala.collection.JavaConversions;
import java.util.Arrays;
import java.util.List;

public class SortTest {

    @Test
    public void testRadixSort() {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        RadixSort.main(new String[]{});

        // Test sorting method directly
        int[] input = {9, 182, 34, 12, 5, 0, 77, 4};
        RadixSort.radixsort(input, input.length);
        int[] expected = {0, 4, 5, 9, 12, 34, 77, 182};
        Assert.assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeSortWithOrderingScala() {
        MergeSortWithOrdering.main(new String[]{});
    }

    @Test
    public void testMergeSortStrings() {
        List<String> list = Arrays.asList("zebra", "apple", "mango", "banana");
        scala.collection.immutable.List<String> scalaList = JavaConversions.asScalaBuffer(list).toList();

        scala.collection.immutable.List<String> sorted = MergeSortWithOrdering.mergesort(
                scalaList,
                scala.math.Ordering.String$.MODULE$
        );

        List<String> result = JavaConversions.seqAsJavaList(sorted);
        Assert.assertEquals(Arrays.asList("apple", "banana", "mango", "zebra"), result);
    }
}
