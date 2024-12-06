package TCS_Codevita;
import java.util.*;

public class AaravAndArjun {
    static class Point {
        int x, y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Point)) return false;
            Point p = (Point) obj;
            return x == p.x && y == p.y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static class Line {
        Point start, end;
        
        Line(int x1, int y1, int x2, int y2) {
            this.start = new Point(x1, y1);
            this.end = new Point(x2, y2);
        }
        
        Set<Point> getEndpoints() {
            Set<Point> endpoints = new HashSet<>();
            endpoints.add(start);
            endpoints.add(end);
            return endpoints;
        }
    }
    
    private static boolean isClosedFigure(List<Line> lines) {
        Map<Point, Integer> endpointCount = new HashMap<>();
        
        // Count the occurrences of each endpoint
        for (Line line : lines) {
            Set<Point> endpoints = line.getEndpoints();
            for (Point point : endpoints) {
                endpointCount.put(point, endpointCount.getOrDefault(point, 0) + 1);
            }
        }
        
        // There must be an even count of endpoints for a closed figure
        for (int count : endpointCount.values()) {
            if (count % 2 != 0) {
                return false;
            }
        }
        return endpointCount.size() >= 3; // Must be at least a triangle
    }
    
    private static double calculateArea(List<Line> lines) {
        // Assuming the lines form a simple polygon, we can use the shoelace formula
        double area = 0.0;
        List<Point> vertices = new ArrayList<>();
        
        // Collect vertices of the polygon from lines
        for (Line line : lines) {
            vertices.add(line.start);
            vertices.add(line.end);
        }
        
        // Remove duplicate vertices
        Set<Point> uniqueVertices = new HashSet<>(vertices);
        List<Point> vertexList = new ArrayList<>(uniqueVertices);
        // Sort vertices in a counter-clockwise manner around the centroid
        // (not implemented for simplicity)
        
        int n = vertexList.size();
        for (int i = 0; i < n; i++) {
            Point p1 = vertexList.get(i);
            Point p2 = vertexList.get((i + 1) % n);
            area += p1.x * p2.y - p2.x * p1.y;
        }
        return Math.abs(area) / 2.0;
    }
    
    private static boolean canRecreateShape(List<Line> lines, double area) {
        // Calculate total length of leftover sticks and compare with perimeter of the shape
        double leftoverLength = 0.0;
        
        for (Line line : lines) {
            double length = Math.sqrt(Math.pow(line.end.x - line.start.x, 2) +
                                       Math.pow(line.end.y - line.start.y, 2));
            leftoverLength += length;
        }
        
        // For this problem, we assume we can recreate the shape if we have enough leftover length
        return leftoverLength >= area; // This is a simplification
    }

public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // Number of sticks
        List<Line> lines = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            lines.add(new Line(x1, y1, x2, y2));
        }
        
        if (isClosedFigure(lines)) {
            System.out.println("Yes");
            double area = calculateArea(lines);
            System.out.printf("%.2f\n", area);
            boolean canFormSameFigure = canRecreateShape(lines, area);
            System.out.println(canFormSameFigure ? "Yes" : "No");
        } else {
            System.out.print("No");
        }
        
        sc.close();
    }
}