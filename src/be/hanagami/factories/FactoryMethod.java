package be.hanagami.factories;

//enum CoordinateSystem
//{
//    CARTESIAN,
//    POLAR
//}
class Point
{
    private double x, y;

    //ugly and need explication
//    public Point(double a, double b, //names do not communicate intent
//                  CoordinateSystem cs)
//    {
//        switch (cs)
//        {
//            case CARTESIAN:
//                this.x = a;
//                this.y = b;
//                break;
//            case POLAR:
//                x = a * Math.cos(b);
//                y = a * Math.sin(b);
//                break;
//        }
//    }


    protected Point(double x, double y) {
        this.x = x;
        this.y = y;
    }


    // illegal
//    public Point(double x, double y)
//    {
//        this.x = x;
//        this.y = y;
//    }
//    public Point(double rho, double theta)
//    {
//        x = rho * Math.cos(theta);
////        y = rho * Math.sin(theta);
//    }

    public static class Factory //nested class
    {
        public static Point newCartisianPoint(double x, double y)
        {
            return new Point(x, y);
        }

        public static Point newPolarPoint(double rho, double theta)
        {
            return new Point(rho*Math.cos(theta),
                    rho*Math.sin(theta));
        }
    }
}
class Demo
{
    public static void main(String[] args) {
        // without PointFactory class
        //Point point = Point.newPolarPoint(2, 3);

        // without nested class
//        Point point = PointFactory.newCartisianPoint(2,3);
//        Point point1 = new Point(4, 5);

        Point point = Point.Factory.newCartisianPoint(3, 4);
    }
}