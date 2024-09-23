package DSA.DataStructures.StacksAndQueues;

public class InbuiltExamples {
    public static void main(String[] args) throws CustomStackException {
        // Stack<Integer> stack = new Stack<>();
        // stack.push(0);
        // stack.push(1);
        // stack.push(2);
        // stack.push(3);
        // System.out.println(stack);
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // System.out.println(stack);

        // Queue<Integer> queue = new LinkedList<>();
        // queue.add(0);
        // queue.add(1);
        // queue.add(2);
        // queue.add(3);
        // System.out.println(queue);
        // System.out.println(queue.remove());
        // System.out.println(queue.remove());
        // System.out.println(queue);

        // Deque<Integer> deque = new ArrayDeque<>();
        // deque.addFirst(0);
        // deque.addFirst(1);
        // deque.addFirst(2);
        // deque.addLast(3);
        // deque.addLast(4);
        // deque.addLast(5);
        // deque.add(6);
        // deque.add(6);
        // System.out.println(deque);
        // deque.removeFirst();
        // deque.removeFirst();
        // deque.removeLast();
        // deque.removeLast();
        // deque.remove();
        // System.out.println(deque);

        // CustomStack stack = new CustomStack();
        // stack.push(0);
        // stack.push(1);
        // stack.push(2);
        // stack.push(3);
        // stack.push(4);
        // stack.push(5);
        // stack.push(6);
        // System.out.println(stack);
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());

        // CustomQueue que = new CustomQueue();
        // que.insert(0);
        // que.insert(1);
        // que.insert(2);
        // que.insert(3);
        // que.insert(4);
        // que.insert(5);
        // System.out.println(que);
        // System.out.println(que.remove());
        // System.out.println(que.remove());
        // System.out.println(que.remove());
        // System.out.println(que.remove());
        // System.out.println(que.remove());
        // System.out.println(que.remove());
        // System.out.println(que);
        // System.out.println(que.remove());

        CircularQueue que = new DynamicCircularQueue();
        que.insert(1);
        que.insert(2);
        que.insert(3);
        que.insert(4);
        que.insert(5);
        System.out.println(que);
        System.out.println(que.remove());
        System.out.println(que);
        que.insert(6);
        que.insert(6);
        que.insert(6);
        que.insert(6);
        que.insert(6);
        que.insert(6);
        que.insert(6);
        System.out.println(que);
        System.out.println(que.remove());
        System.out.println(que.remove());
        System.out.println(que.remove());
        System.out.println(que.remove());
        System.out.println(que.remove());
        System.out.println(que.remove());
        System.out.println(que);
    }
}
