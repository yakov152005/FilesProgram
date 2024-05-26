package FilesBin.PointsProgram;
import java.io.Serializable;

public class Polygon implements Serializable {
    private Point[] allPoints;
    private String color;

    public Polygon(Point[] allPoints, String color){
        this.allPoints = new Point[allPoints.length];
        for (int i = 0; i < this.allPoints.length; i++) {
            this.allPoints[i] = allPoints[i];
        }
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Polygon has ").append(this.allPoints.length).append(" points:").append("\n");
        for (int i = 0; i < this.allPoints.length; i++) {
            stringBuilder.append(this.allPoints[i].toString()).append(",");
        }
        return stringBuilder.toString();
    }
}
