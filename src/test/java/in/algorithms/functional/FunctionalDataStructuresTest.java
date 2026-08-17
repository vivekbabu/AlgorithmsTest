package in.algorithms.functional;

import in.algorithms.intsets.Empty;
import in.algorithms.intsets.IntSet;
import in.algorithms.json.*;
import in.algorithms.list.Cons;
import in.algorithms.list.List;
import in.algorithms.list.ListUtils;
import in.algorithms.list.Nil;
import in.algorithms.listfunctions.ListFunctions;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class FunctionalDataStructuresTest {

    @Test
    public void testChurchListConsAndNth() {
        List<Integer> list = new Cons<>(10, new Cons<>(20, new Cons<>(30, new Nil<>())));

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
    public void testListFunctionsMapFilter() {
        java.util.List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        java.util.List<Integer> squares = ListFunctions.map(numbers, x -> x * x);
        Assert.assertEquals(Arrays.asList(1, 4, 9, 16, 25), squares);

        java.util.List<Integer> evens = ListFunctions.filter(numbers, x -> x % 2 == 0);
        Assert.assertEquals(Arrays.asList(2, 4), evens);
    }

    @Test
    public void testImmutableIntSet() {
        IntSet s1 = Empty.INSTANCE;
        Assert.assertFalse(s1.contains(5));

        IntSet s2 = s1.incl(5).incl(10).incl(2);
        Assert.assertTrue(s2.contains(5));
        Assert.assertTrue(s2.contains(10));
        Assert.assertTrue(s2.contains(2));
        Assert.assertFalse(s2.contains(7));

        IntSet s3 = Empty.INSTANCE.incl(7).incl(12);
        IntSet unionSet = s2.union(s3);
        Assert.assertTrue(unionSet.contains(5));
        Assert.assertTrue(unionSet.contains(7));
        Assert.assertTrue(unionSet.contains(12));
    }

    @Test
    public void testJSONAlgebraicDataType() {
        Map<String, JSON> objMap = new LinkedHashMap<>();
        objMap.put("name", new JStr("Antigravity"));
        objMap.put("version", new JNum(2.0));
        objMap.put("active", new JBool(true));
        objMap.put("meta", new JNull());

        JObj jsonObject = new JObj(objMap);
        String renderedObj = JSONOperations.show(jsonObject);
        Assert.assertEquals("{\"name\": \"Antigravity\", \"version\": 2.0, \"active\": true, \"meta\": null}", renderedObj);

        JSeq jsonArray = new JSeq(Arrays.asList(new JStr("A"), new JNum(100.0)));
        Assert.assertEquals("[\"A\", 100.0]", JSONOperations.show(jsonArray));
    }
}
