package in.algorithms.math;

import org.junit.Test;
import org.junit.Assert;
import in.algorithms.nextbiggernumber.NextBiggerNumber;
import in.algorithms.alternate.AlternateNumbers;
import in.algorithms.secondfrequentnumberinalist.SecondFrequentNumberInAList;
import in.algorithms.wateralotter.WaterAlotter;
import scala.collection.JavaConversions;
import java.util.Arrays;
import java.util.List;

public class MathAndArrayTest {

    @Test
    public void testNextBiggerNumber() {
        NextBiggerNumber.getNextBiggerNumber(1234L);
        NextBiggerNumber.getNextBiggerNumber(4321L);
        NextBiggerNumber.getNextBiggerNumber(534976L);
    }

    @Test
    public void testAlternateNumbers() {
        AlternateNumbers alternater = new AlternateNumbers();

        Integer[] arr = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        alternater.alternateTheNumbers(arr);

        Assert.assertNotNull(arr);
    }

    @Test
    public void testSecondFrequentNumber() {
        List<Object> nums = Arrays.asList((Object) 2, 3, 4, 5, 1, 1, 1, 2, 3, 3, 2, 1, 3, 3, 3, 2, 2, 1, 2, 1, 1, 1);
        scala.Tuple2<Object, Object> result = SecondFrequentNumberInAList.secondFrequentNumberInAList(
                JavaConversions.asScalaBuffer(nums).toList()
        );
        Assert.assertNotNull(result);
    }

    @Test
    public void testWaterAllotterCascade() {
        WaterAlotter allotter = new WaterAlotter();
        allotter.allotWater(10, 5, 1);
    }
}
