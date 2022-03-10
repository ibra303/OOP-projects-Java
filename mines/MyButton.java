package mines;

import javafx.scene.control.Button;
//put x and y
public class MyButton extends Button {
    private int x;
    private int y;

    public MyButton(String str, int x, int y) {
        super(str);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
