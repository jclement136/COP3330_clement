abstract class Shape3D extends Shape {
}

class Cube extends Shape3D{

    private static double length;
    private static double area;
    private static double volume;

    public Cube(double x) {
        length = x;
        area = length * length;
        volume = 0;
    }

    public String getName(){
        return "cube";
    }

    public double getArea(){
        return Cube.area;
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
        area = 0;
        volume = 0;
    }

    public String getName(){
        return "pyramid";
    }

    public double getArea(){
        return Pyramid.area;
    }
}

class Sphere extends Shape3D{

    private static double radius;
    private static double area;
    private static double volume;

    public Sphere(double x) {
        radius = x;
        area = 0;
        volume = 0;
    }

    public String getName(){
        return "sphere";
    }

    public double getArea(){
        return Sphere.area;
    }
}



/*
    // Cube volume
    // Pyramid volume
    // Sphere volume

    abstract double getVolume();

    public static class Cube extends Shape2D{

        public double surfaceArea = (Shape.length * Shape.length) * 6;

        public double volume = (Shape.length * Shape.length * Shape.length);

        public String getName(){
            return "cube";
        }

        public double getArea(){
            return surfaceArea;
        }
        public double getVolume(){
            return volume;
        }
    }

    public static class Pyramid extends Shape2D{

        public double surfaceArea = 0;

        public double volume = 0;

        public String getName(){
            return "pyramid";
        }

        public double getArea(){
            return surfaceArea;
        }

        public double getVolume(){
            return volume;
        }
    }

    public static class Sphere extends Shape2D{

        public double surfaceArea = 0;

        public double volume = 0; // radius

        public String getName(){
            return "sphere";
        }

        public double getArea(){
            return surfaceArea;
        }

        public double getVolume(){
            return volume;
        }
    }

*/
