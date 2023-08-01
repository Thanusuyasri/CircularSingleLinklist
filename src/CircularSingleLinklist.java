import java.util.Scanner;

class  Node{
    int value;
    Node next;
    public  Node(int value)
    {
        this.value = value;
    }
}
public class CircularSingleLinklist {
    Node head;
    Node tail;
    int length;
    CircularSingleLinklist(int value)
    {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        newNode.next = head;
        length = 1;
    }
    public void Append(int value)
    {
        Node newNode = new Node(value);
        if(head == null)
        {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        }
        else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        length++;
    }

    public void Prepend(int value)
    {
        Node newNode = new Node(value);
        if(head == null)
        {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        }
        else {
            tail.next = newNode;
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node RemoveFromEnd()
    {
        if(length == 0)
        {
            return null;
        }
        else {
            Node temp = head;
            if(head != tail)
            {
                while(temp.next != tail)
                {
                    temp = temp.next;
                }
                tail.next = null;
                tail = temp;
                tail.next = head;
            }
            else {
                head = tail = null;
            }
            length--;
            return temp;
        }
    }

    public Node RemoveFromFirst()
    {
        if(length == 0)
        {
            return null;
        }
        Node temp = head;
        head = head.next;
        tail.next = head;
        //temp.next = null;
        length --;
        return temp;
    }

    public void display()
    {
        Node temp = head;
        if(head == null)
        {
            System.out.println("Empty");
        }
        else {
            do{
                System.out.println(temp.value);
                temp = temp.next;
            }while (temp != head);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CircularSingleLinklist circular = new CircularSingleLinklist(4);
        circular.Append(5);
        circular.display();
        circular.Prepend(6);
        circular.display();
        circular.Append(7);
        circular.display();
        circular.Prepend(8);
        circular.display();
        System.out.println("Removed from End:"+circular.RemoveFromEnd().value);
        circular.display();
        System.out.println("Removed from first:"+circular.RemoveFromFirst().value);
        circular.display();
    }
}
