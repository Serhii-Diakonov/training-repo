package com.knubisoft.base.queue;

import com.knubisoft.base.queue.car.Car;
import com.knubisoft.base.queue.car.CarComparator;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class QueueTasksImpl implements QueueTasks {

    @Override
    public Queue<Integer> reverseQueueUsingRecursion(Queue<Integer> queue) {
        if (queue != null && !queue.isEmpty()) {
            Integer buf = queue.remove();
            queue = reverseQueueUsingRecursion(queue);
            queue.add(buf);
            return queue;
        }
        return new LinkedList<>();
    }

    @Override
    public Queue<Integer> reverseFirstKElementsOfQueue(Queue<Integer> queue, int k) {
        if (queue != null && !queue.isEmpty()) {
            Queue<Integer> newQueue = new LinkedList<>();
            for (int i = 0; i < k; i++) {
                newQueue.add(queue.remove());
            }
            newQueue = reverseQueueUsingRecursion(newQueue);
            newQueue.addAll(queue);
            return newQueue;
        }
        return null;
    }

    @Override
    public Queue<Integer> sortQueueOfInt(Queue<Integer> queue) {
        return sortQueueWithStreamAPI(queue);
//        return manualQuickSort(queue);
    }

    private Queue<Integer> sortQueueWithStreamAPI(Queue<Integer> queue) {
        List<Integer> sortedList = queue.stream().sorted().collect(Collectors.toList());
        queue.clear();
        queue.addAll(sortedList);
        return queue;
    }

    private Queue<Integer> manualQuickSort(Queue<Integer> queue) {
        List<Integer> list = new ArrayList<>(queue);
//        quickSort(list);
        return new LinkedList<>(list);
    }

    @Override
    public boolean validParentheses(String parentheses) {
        if (parentheses.length() % 2 == 1) return false;
        char[] chars = parentheses.toCharArray();
        Deque<Character> queue = new LinkedList<>();
        for (char c : chars) {
            if(c == '(' || c == '{' || c == '[') queue.push(c);
            else {
                char queueSymbol = queue.peek();
                if(c == ')' && queueSymbol == '(') queue.pop();
                else if(c == '}' && queueSymbol == '{') queue.pop();
                else if(c == ']' && queueSymbol == '[') queue.pop();
                else return false;
            }
        }
        return queue.size() == 0;
    }

    @Override
    public PriorityQueue<Car> implementPriorityQueueThroughComparator(List<Car> cars) {
        PriorityQueue<Car> prQueue = new PriorityQueue<>(new CarComparator());
        prQueue.addAll(cars);
        return prQueue;
    }

}
