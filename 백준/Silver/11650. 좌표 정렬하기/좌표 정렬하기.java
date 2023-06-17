import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfPoint = sc.nextInt();
        ArrayList points = new ArrayList<Point>();
        for (int i = 0; i < numOfPoint; i++) {
            int tempX = sc.nextInt();
            int tempY = sc.nextInt();
            points.add(new Point(tempX, tempY));
        }
        Collections.sort(points);
        Iterator iterator= points.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
class Point implements Comparable<Point> {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) {
            return this.y - o.y;
        } else {
            return this.x - o.x;
        }
    }
    @Override
    public String toString() {
        return x+" "+y;
    }
}