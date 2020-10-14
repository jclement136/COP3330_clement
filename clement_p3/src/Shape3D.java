abstract class Shape3D extends Shape {
}

class Cube extends Shape3D{

    private static double length;
    private static double area;
    private static double volume;

    public Cube(double x) {
        length = x;
        area = (length * length) * 6;
        volume = length * length * length;
    }

    public String getName(){
        return "cube";
    }

    public double getArea(){
        return Cube.area;
    }

    public double getVolume(){
        return Cube.volume;
    }
}

class Pyramid extends Shape3D{

    private static double length;
    private static double width;
    private static double height;
    private static double area;
    private static double volume;

    public Pyramid(double x, double y, double z) {
        length = x;
        width = y;
        height = z;

        double value1 = length * width;
        double value2 = length * (Math.sqrt((width / 2.00) * (width / 2.00)));
        double value3 = width * (Math.sqrt((width / 2.00) * (width / 2.00)));

        area = value1 + value2 + value3;
        volume = ((length * width) * height) / 3.00;
    }

    public String getName(){
        return "pyramid";
    }

    public double getArea(){
        return Pyramid.area;
    }

    public double getVolume(){
        return Pyramid.volume;
    }
}

class Sphere extends Shape3D{

    private static double radius;
    private static double area;
    private static double volume;

    public Sphere(double x) {
        radius = x;
        area = 4.0 * Math.PI * (radius * radius);
        volume = (4.0 / 3.0) * Math.PI * (radius * radius * radius);
    }

    public String getName(){
        return "sphere";
    }

    public double getArea(){
        return Sphere.area;
    }

    public double getVolume(){
        return Sphere.volume;
    }
}