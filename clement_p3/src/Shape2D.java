abstract class Shape2D extends Shape {
}

class Square extends Shape2D{

    private static double length;
    private static double area;

    public Square(double x) {
        length = x;
        area = length * length;
    }

    public String getName(){
        return "square";
    }

    public double getArea(){
        return Square.area;
    }
}

class Triangle extends Shape2D{

    private static double length;
    private static double height;
    private static double area;

    public Triangle(double x, double y) {
        length = x;
        height = y;
        area = (length * height) / 2;
    }

    public String getName(){
        return "triangle";
    }

    public double getArea(){
        return Triangle.area;
    }
}

class Circle extends Shape2D{

    private static double radius;
    private static double area;

    public Circle(double x) {
        radius = x;
        area = (Math.PI) * (radius * radius);
    }

    public String getName(){
        return "circle";
    }

    public double getArea(){
        return Circle.area;
    }
}


/*
class Triangle extends Shape{

    public double area = (Shape.length * Shape.height) / 2;

    public String getName(){
        return "triangle";
    }

    public double getArea(){
        return area;
    }
}


class Circle extends Shape{

    public double area = 0;

    public String getName(){
        return "circle";
    }

    public double getArea(){
        return area;
    }
}
*/