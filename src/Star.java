import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Star
{

    double x;
    double y;
    double z;
    Circle body;
    Color color = Color.SNOW;
    double r = 3;
    public static ArrayList<Star> stars = new ArrayList<>();

    public Star()
    {
        x = Utils.getRandom(-Main.width / 2, Main.width / 2);
        y = Utils.getRandom(-Main.height / 2, Main.height / 2);
        z = Utils.getRandom(Main.width);
        double sx = Utils.map(x / z, 0, 1, 0, Main.width);
        double sy = Utils.map(y / z, 0, 1, 0, Main.height);
        r = Utils.map(z, 0, Main.width, 5, 0);
        color = Color.gray(Utils.map(z, 0, Main.width, 1, 0.7));
        body = new Circle(sx + Main.width / 2, sy + Main.height / 2, r, color);
        stars.add(this);
    }

    public void update()
    {
        z = z - Main.speed;
        if (z < 1)
        {
            z = Main.width;
            x = Utils.getRandom(-Main.width / 2, Main.width / 2);
            y = Utils.getRandom(-Main.height / 2, Main.height / 2);
        }

        double sx = Utils.map(x / z, 0, 1, 0, Main.width);
        double sy = Utils.map(y / z, 0, 1, 0, Main.height);
        body.setCenterX(sx + Main.width / 2);
        body.setCenterY(sy + Main.height / 2);
        r = Utils.map(z, 0, Main.width, 5, 0);
        body.setRadius(r);
        color = Color.gray(Utils.map(z, 0, Main.width, 1, 0.7));
        body.setFill(color);
    }

    public Node getBody()
    {
        return this.body;
    }
}
