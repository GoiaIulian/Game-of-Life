package sample;


import javafx.scene.shape.Rectangle;

import javafx.scene.paint.Color;


public class Cell extends Rectangle
{
    private Rectangle _body;
    private Color _color;
    private int _status;

    public Cell(Color c, int s)
    {
        _body = new Rectangle();
        _body.setWidth(5);
        _body.setHeight(5);
        _body.setVisible(true);

        _color = c;

        _body.setFill(_color);
        _status = s;

    }


    public Rectangle getBody()
    {
        return _body;
    }

    public void setColor(Color color,int status)
    {
        this._color = color;
        _body.setFill(color);
        _status = status;
    }

    public int getStatus()
    {
        return _status;
    }
}
