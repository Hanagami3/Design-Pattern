package be.hanagami.prototype;

// Given the following class definitions, you are asked to implement Line.deepCopy()
// to perform a deep copy of the current Line  object.

//correction en dessous
class Point
{
    public int x, y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

class Line {
    public Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line deepCopy(Line other) {
        //TODO
        return null;
    }
}














//    public Line deepCopy(Line other)
//    {
//        Point newStart = new Point(start.x, start.y);
//        Point newEnd = new Point(end.x, end.y);
//
//        return new Line(newStart, newEnd);
//    }

