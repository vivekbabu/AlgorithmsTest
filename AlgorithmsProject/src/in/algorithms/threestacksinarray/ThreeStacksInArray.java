package in.algorithms.threestacksinarray;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ThreeStacksInArray {
    private final int stackSize;
    private final int[] buffer;
    private final int[] stackPointers = {-1, -1, -1};

    public ThreeStacksInArray(int stackSize) {
        this.stackSize = stackSize;
        this.buffer = new int[stackSize * 3];
    }

    public void push(int stackNum, int value) {
        if (stackNum < 0 || stackNum > 2) {
            throw new IllegalArgumentException("Invalid stack number: " + stackNum);
        }
        if (stackPointers[stackNum] + 1 >= stackSize) {
            throw new IllegalStateException("Stack " + stackNum + " is full");
        }
        stackPointers[stackNum]++;
        buffer[absTopOfStack(stackNum)] = value;
    }

    public int pop(int stackNum) {
        if (stackNum < 0 || stackNum > 2) {
            throw new IllegalArgumentException("Invalid stack number: " + stackNum);
        }
        if (stackPointers[stackNum] == -1) {
            throw new NoSuchElementException("Stack " + stackNum + " is empty");
        }
        int val = buffer[absTopOfStack(stackNum)];
        buffer[absTopOfStack(stackNum)] = 0;
        stackPointers[stackNum]--;
        return val;
    }

    public int peek(int stackNum) {
        if (stackNum < 0 || stackNum > 2) {
            throw new IllegalArgumentException("Invalid stack number: " + stackNum);
        }
        if (stackPointers[stackNum] == -1) {
            throw new NoSuchElementException("Stack " + stackNum + " is empty");
        }
        return buffer[absTopOfStack(stackNum)];
    }

    public boolean isEmpty(int stackNum) {
        if (stackNum < 0 || stackNum > 2) throw new IllegalArgumentException();
        return stackPointers[stackNum] == -1;
    }

    public List<Integer> getStackElements(int stackNum) {
        if (stackNum < 0 || stackNum > 2) throw new IllegalArgumentException();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= stackPointers[stackNum]; i++) {
            list.add(buffer[stackNum * stackSize + i]);
        }
        return list;
    }

    private int absTopOfStack(int stackNum) {
        return stackNum * stackSize + stackPointers[stackNum];
    }
}
