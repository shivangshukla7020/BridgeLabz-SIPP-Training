import java.util.*;

class QueueAssignments {
    // Reverse a queue
    public static <T> void reverseQueue(Queue<T> q) {
        if (q.isEmpty()) return;
        T front = q.remove();
        reverseQueue(q);
        q.add(front);
    }

    // Generate first N binary numbers
    public static List<String> generateBinary(int n) {
        List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add("1");
        while (n-- > 0) {
            String s = q.remove();
            res.add(s);
            q.add(s + "0");
            q.add(s + "1");
        }
        return res;
    }

    // Hospital triage (PriorityQueue)
    static class Patient {
        String name; int severity;
        Patient(String n, int s) { name = n; severity = s; }
    }
    public static void hospitalTriage(List<Patient> patients) {
        PriorityQueue<Patient> pq = new PriorityQueue<>((a,b)->b.severity - a.severity);
        pq.addAll(patients);
        while(!pq.isEmpty()) System.out.println(pq.remove().name);
    }

    // Stack using queues
    static class StackUsingQueues {
        Queue<Integer> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        void push(int x) {
            q2.add(x);
            while (!q1.isEmpty()) q2.add(q1.remove());
            Queue<Integer> tmp = q1; q1 = q2; q2 = tmp;
        }
        int pop() { return q1.remove(); }
        int top() { return q1.peek(); }
    }

    // Circular buffer
    static class CircularBuffer {
        int[] arr; int head=0, size=0;
        CircularBuffer(int cap){ arr=new int[cap]; }
        void add(int x){
            arr[(head+size)%arr.length]=x;
            if(size<arr.length) size++;
            else head=(head+1)%arr.length;
        }
        List<Integer> getBuffer(){
            List<Integer> res=new ArrayList<>();
            for(int i=0;i<size;i++) res.add(arr[(head+i)%arr.length]);
            return res;
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>(Arrays.asList(10,20,30));
        reverseQueue(q); System.out.println(q);
        System.out.println(generateBinary(5));
        hospitalTriage(Arrays.asList(new Patient("John",3), new Patient("Alice",5), new Patient("Bob",2)));
        StackUsingQueues s = new StackUsingQueues();
        s.push(1);s.push(2);s.push(3);System.out.println(s.pop());
        CircularBuffer cb = new CircularBuffer(3);
        cb.add(1);cb.add(2);cb.add(3);cb.add(4);System.out.println(cb.getBuffer());
    }
}
