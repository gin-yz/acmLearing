package com.cjs.homeworkOJ.homeworkDemo;

import java.util.*;

public class KthClosestTest {

    public static void main(String[] args) {
        Point point = new Point();

        Scanner scanner = new Scanner(System.in);
        List<Point> pointList = new ArrayList<>();

        while (scanner.hasNext()){
//            String line = scanner.nextLine();
//            String[] s = line.split(" ");
//            point.x = Integer.parseInt(s[0]);
//            point.y = Integer.parseInt(s[1]);
//            pointList.add(point);
            System.out.println(scanner.nextLine());        }

//        System.out.println(KClosest(pointList,2));

    }

    public static List<Point> KClosest(List<Point> input, int k) {
        List<Point> res = new LinkedList<Point>();
        PriorityQueue<Point> pq = new PriorityQueue<Point>(10, new Comparator<Point>() {
            public int compare(Point a, Point b) {
                return (b.x * b.x + b.y * b.y) - (a.x * a.x + a.y * a.y);
            }
        });

        for (Point each : input) {
            pq.offer(each);
            if (pq.size() > k) pq.poll();
        }
        while (!pq.isEmpty()) {
            res.add(0, pq.poll());
        }
        return res;
    }
    static class Point{
        public int x;
        public int y;
    }
}
