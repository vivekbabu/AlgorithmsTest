package in.algorithms;

import in.algorithms.bst.BSTTest;
import in.algorithms.concurrency.ConcurrencyTest;
import in.algorithms.decomposition.DecompositionPatternsTest;
import in.algorithms.dp.DynamicProgrammingTest;
import in.algorithms.expression.ExpressionEvaluationTest;
import in.algorithms.functional.FunctionalDataStructuresTest;
import in.algorithms.graphs.GraphAndGridTest;
import in.algorithms.heap.HeapTest;
import in.algorithms.higherorder.HigherOrderFunctionsTest;
import in.algorithms.linkedlist.LinkedListTest;
import in.algorithms.math.MathAndArrayTest;
import in.algorithms.maximumdifference.MaximumDifferenceTest;
import in.algorithms.queue.QueueTest;
import in.algorithms.sort.SortTest;
import in.algorithms.stack.StackTest;
import in.algorithms.strings.ReverseByWordTest;
import in.algorithms.strings.StringAlgorithmsTest;
import in.algorithms.tree.TreeTest;
import in.designpatterns.CommandExampleTest;
import in.designpatterns.DesignPatternsTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BSTTest.class,
        TreeTest.class,
        QueueTest.class,
        StackTest.class,
        LinkedListTest.class,
        DynamicProgrammingTest.class,
        GraphAndGridTest.class,
        SortTest.class,
        StringAlgorithmsTest.class,
        ReverseByWordTest.class,
        HeapTest.class,
        ExpressionEvaluationTest.class,
        FunctionalDataStructuresTest.class,
        HigherOrderFunctionsTest.class,
        MathAndArrayTest.class,
        MaximumDifferenceTest.class,
        DecompositionPatternsTest.class,
        DesignPatternsTest.class,
        CommandExampleTest.class,
        ConcurrencyTest.class
})
public class MasterTestSuite {
}
