public class Program
{
    public static void main(String[] args) {
        var p1 = new Point();
        var p2 = new Point(1,2);

        var r = Point.distance(p1, p2);
    }
}
