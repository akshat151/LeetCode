public class IsLinkedListPalindrome {
    //Function to check whether the list is palindrome.
    public static boolean isPalindrome(Node head)
    {
        //Your code here
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(new Node(2)));
    }
}

// Structure of class Node is
class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}

