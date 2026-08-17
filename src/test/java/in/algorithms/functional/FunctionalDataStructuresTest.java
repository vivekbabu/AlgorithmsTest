package in.algorithms.functional;

import org.junit.Test;
import org.junit.Assert;
import in.algorithms.list.Cons;
import in.algorithms.list.Nil;
import in.algorithms.list.ListUtils;
import in.algorithms.intsets.Empty$;
import in.algorithms.intsets.IntSet;
import in.algorithms.json.JStr;
import in.algorithms.json.JNum;
import in.algorithms.json.JSeq;
import in.algorithms.json.JSONOperations;
import scala.collection.JavaConversions;
import java.util.Arrays;

public class FunctionalDataStructuresTest {

    @Test
    public void testChurchListConsAndNth() {
        in.algorithms.list.List<Integer> list =
                new Cons<Integer>(10,
                        new Cons<Integer>(20,
                                new Cons<Integer>(30,
                                        new Nil<Integer>())));

        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(Integer.valueOf(10), list.head());
        Assert.assertEquals(Integer.valueOf(20), list.tail().head());
        Assert.assertEquals(Integer.valueOf(30), list.tail().tail().head());
        Assert.assertTrue(list.tail().tail().tail().isEmpty());

        Assert.assertEquals(Integer.valueOf(10), ListUtils.nth(0, list));
        Assert.assertEquals(Integer.valueOf(20), ListUtils.nth(1, list));
        Assert.assertEquals(Integer.valueOf(30), ListUtils.nth(2, list));
    }

    @Test
    public void testImmutableIntSet() {
        IntSet s1 = Empty$.MODULE$;
        Assert.assertFalse(s1.contains(5));

        IntSet s2 = s1.incl(5).incl(10).incl(2);
        Assert.assertTrue(s2.contains(5));
        Assert.assertTrue(s2.contains(10));
        Assert.assertTrue(s2.contains(2));
        Assert.assertFalse(s2.contains(7));

        IntSet s3 = Empty$.MODULE$.incl(7).incl(12);
        IntSet unionSet = s2.union(s3);
        Assert.assertTrue(unionSet.contains(5));
        Assert.assertTrue(unionSet.contains(7));
        Assert.assertTrue(unionSet.contains(12));
    }

    @Test
    public void testJSONAlgebraicDataType() {
        JSeq jsonArray = new JSeq(
                JavaConversions.asScalaBuffer(
                        Arrays.asList(
                                (in.algorithms.json.JSON) new JStr("Antigravity"),
                                (in.algorithms.json.JSON) new JNum(42.0)
                        )
                ).toList()
        );

        String rendered = JSONOperations.show(jsonArray);
        Assert.assertNotNull(rendered);
    }
}
