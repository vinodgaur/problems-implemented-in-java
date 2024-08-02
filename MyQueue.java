import java.util.*;

public class MyQueue {
    private Deque<Integer> stack1 = new ArrayDeque<>();
    private Deque<Integer> stack2 = new ArrayDeque<>();


    public MyQueue() {
        
    }
    
    public void push(int x) {
        if(stack1.size()==0){
            while(stack2.size()!=0){
                stack1.addLast(stack2.removeLast());
            }
        }
            stack1.addLast(x);
        //} else 
            //stack2.addLast(x);
    }
    
    public int pop() {
        if(stack2.size()==0){
            while(stack1.size()!=0){
                stack2.addLast(stack1.removeLast());
            }
            
        }
        if(stack2.size()!=0)
                return stack2.removeLast();
        return 0;
    }
    
    public int peek() {
        if(stack2.size()==0){
            while(stack1.size()!=0){
                stack2.addLast(stack1.removeLast());
            }
            
        }
        if(stack2.size()!=0)
                return stack2.getLast();
        return 0;
    }
    
    public boolean empty() {
        if(stack1.size()==0 && stack2.size()==0)
            return true;
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */