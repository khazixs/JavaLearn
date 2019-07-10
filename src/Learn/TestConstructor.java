package Learn;

class Point {
    double x, y;
    //构造器名字应该与类名相同，有返回值但不能使用return返回某个值，在不定义构造函数的情况下，系统会默认添加无参构造函数
    Point(double _x, double _y) {
        x = _x;
        y = _y;
    }

    double getDistance(Point p) {
        return Math.sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y));
    }

}

public class TestConstructor{
    public static void main(String[] args) {
        Point p = new Point(3.0,4.0);//构造器
        Point origin = new Point(0.0,0.0);

        System.out.println(p.getDistance(origin));
    }
}