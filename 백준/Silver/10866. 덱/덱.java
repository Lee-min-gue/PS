import java.util.Scanner;
public class Main {

    public static int[] queue;
    public static int size = 0;
    static int front ;
    static int back ;
    static boolean First=false;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = in.nextInt();
        front=N;
        back=N;


        queue = new int[N*2+1];

        for (int i = 0; i < N; i++) {

            String str = in.next();

            switch (str) {

                case "push_front":
                    push_front(in.nextInt());
                    break;
                case "push_back":
                    push_back(in.nextInt());
                    break;
                case "pop_front":
                    sb.append(pop_front()).append('\n');
                    break;
                case "pop_back":
                    sb.append(pop_back()).append('\n');
                    break;

                case "size":
                    sb.append(size()).append('\n');
                    break;

                case "empty":
                    sb.append(empty()).append('\n');
                    break;

                case "front":
                    sb.append(front()).append('\n');
                    break;

                case "back":
                    sb.append(back()).append('\n');
                    break;
            }

        }
        System.out.println(sb);
    }

    public static void push_front(int item) {
        if(First==false){
            queue[front] = item;
            size++;
            First=true;
        }
        else {
            queue[--front] = item;
            size++;
        }

    }
    public static void push_back(int item) {
        if(First==false){
            queue[back] = item;
            size++;
            First=true;
        }
        else{
            queue[++back] = item;
            size++;
        }
    }

    public static int pop_front() {
        if (size == 0) {
            return -1;
        } else {
            int res = queue[front];
            queue[front] = 0;
            size--;
            if(size==0){
                First=false;
            }
            if(First==true){
                front++;
            }
            return res;
        }
    }
    public static int pop_back() {
        if (size == 0) {
            return -1;
        } else {
            int res = queue[back];
            queue[back] = 0;
            size--;
            if(size==0){
                First=false;
            }
            if(First==true){
                back--;
            }
            return res;
        }
    }
    public static int size() {
        return size;
    }

    public static int empty() {
        if (size == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int front() {
        if (size == 0) {
            return -1;
        } else {
            return queue[front];
        }
    }

    public static int back() {
        if (size == 0) {
            return -1;
        } else {
            return queue[back];
        }
    }
}