package de.hsrm.ads;

import java.util.Stack;

public class StackSort {

    public static void quicksort(Stack<Integer> stack) {
        // get pivot
        int pivot = stack.pop();

        // left and right stack
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();

        // empty stack into left and right
        while (!stack.empty()) {
            // get pin
            int pin = stack.pop();
            if (pin <= pivot) {
                left.push(pin);
            } else {
                right.push(pin);
            }
        }

        // sort left and right if they are greater than one element
        if (left.size() > 1)
            quicksort(left);
        if (right.size() > 1)
            quicksort(right);

        // Reverse left and right
        Stack<Integer> rleft = new Stack<>();
        Stack<Integer> rright = new Stack<>();
        while (!left.empty())
            rleft.push(left.pop());
        while (!right.empty())
            rright.push(right.pop());

        // combine rleft, rright and pivot to stack
        while (!rright.empty())
            stack.push(rright.pop());
        stack.push(pivot);
        while (!rleft.empty())
            stack.push(rleft.pop());
    }


    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(2);
        s.push(1);
        s.push(4);
        s.push(5);
        s.push(3);

        quicksort(s);
        // Sollte 1,2,3,4 ausgeben.
        while (!s.empty()) {
            System.out.println(s.pop());
        }
    }

}