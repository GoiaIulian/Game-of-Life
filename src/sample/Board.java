package sample;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.util.Random;


public class Board extends GridPane
{
    GridPane _board;
    Cell [][] _matrix = new Cell[100][100];
    int [][] _aux = new int[100][100];
    int sum;

    public Board()
    {
        _board = new GridPane();
        _board.setVgap(1);
        _board.setHgap(1);
        _board.setVisible(true);
        _board.setCache(true);
        _board.setGridLinesVisible(false);
        populate();

        for (int i=0;i<100;i++)
            for (int j=0;j<100;j++)
            {
                _board.add(_matrix[i][j].getBody(),j,i);
            }
    }

    public void setRandomSeed()
    {
        Random r = new Random();
        //random generate

        for (int i = 1; i < 99; i++)
            for (int j = 1; j < 99; j++)
            {
                if ((byte) r.nextInt(2) == 0)
                {
                    _matrix[i][j].setColor(Color.WHITE, 0);
                } else
                    _matrix[i][j].setColor(Color.BLACK, 1);
            }
        swap();
    }

    public void setPentadecatlonSeed()
    {
        //Pentadecathlon


        for (int i =43;i<59;i++)
            _matrix[50][i].setColor(Color.BLACK,1);

        swap();
    }

    public void squareSeed()
    {
        for(int i=30;i<61;i++)
            for(int j=30;j<61;j++)
                _matrix[i][j].setColor(Color.BLACK, 1);
        swap();
    }

    public void swap()
    {
        for (int i=0;i<100;i++)
            for (int j=0;j<100;j++)
            {
                _aux[i][j] = _matrix[i][j].getStatus();
            }
    }

    public boolean neighboors(int i,int j)
    {
        sum=0;

        sum=_aux[i-1][j-1]+
                _aux[i-1][j]+
                _aux[i-1][j+1]+
                _aux[i][j-1]+
                _aux[i][j+1]+
                _aux[i+1][j-1]+
                _aux[i+1][j]+
                _aux[i+1][j+1];

        if(sum > 3)
        {
            return false;
        }
        else if (sum < 2)
        {
            return false;
        }
        else if(sum == 3)
        {
            return true;
        }
        else if (_aux[i][j]==1 && sum==2)
        {
            return true;
        }
        else
            return false;
    }
    public void nextGeneration()
    {
        swap();
        for (int i=1;i<99;i++)
            for (int j=1;j<99;j++)
            {
                if (neighboors(i,j))
                    _matrix[i][j].setColor(Color.BLACK,1);
                else
                    _matrix[i][j].setColor(Color.WHITE,0);
            }
    }

    public void populate()
    {
        for (int i=0;i<100;i++)
            for (int j=0;j<100;j++)
                _matrix[i][j] = new Cell(Color.WHITE, 0);
    }

    public void line()
    {
        for (int i=1;i<99;i++)
        {
            _matrix[50][i].setColor(Color.BLACK, 1);
            _matrix[51][i].setColor(Color.BLACK,1);
        }
    }

    public void clear()
    {
        for (int i=0;i<100;i++)
            for (int j=0;j<100;j++)
                _matrix[i][j].setColor(Color.WHITE, 0);
    }

    public void setGosperGliderGunSeed()
    {
        _matrix[20][19].setColor(Color.BLACK,1);
        _matrix[20][20].setColor(Color.BLACK,1);
        _matrix[21][19].setColor(Color.BLACK,1);
        _matrix[21][20].setColor(Color.BLACK,1);

        _matrix[18][53].setColor(Color.BLACK,1);
        _matrix[18][54].setColor(Color.BLACK,1);
        _matrix[19][53].setColor(Color.BLACK,1);
        _matrix[19][54].setColor(Color.BLACK,1);

        _matrix[20][29].setColor(Color.BLACK,1);
        _matrix[20][35].setColor(Color.BLACK,1);
        _matrix[19][30].setColor(Color.BLACK,1);
        _matrix[19][34].setColor(Color.BLACK,1);
        _matrix[18][31].setColor(Color.BLACK,1);
        _matrix[18][32].setColor(Color.BLACK,1);
        _matrix[21][29].setColor(Color.BLACK,1);
        _matrix[22][29].setColor(Color.BLACK,1);
        _matrix[21][33].setColor(Color.BLACK,1);
        _matrix[21][35].setColor(Color.BLACK,1);
        _matrix[21][36].setColor(Color.BLACK,1);
        _matrix[22][35].setColor(Color.BLACK,1);
        _matrix[23][34].setColor(Color.BLACK,1);
        _matrix[23][30].setColor(Color.BLACK,1);
        _matrix[24][31].setColor(Color.BLACK,1);
        _matrix[24][32].setColor(Color.BLACK,1);

        _matrix[20][39].setColor(Color.BLACK,1);
        _matrix[20][40].setColor(Color.BLACK,1);
        _matrix[19][39].setColor(Color.BLACK,1);
        _matrix[19][40].setColor(Color.BLACK,1);
        _matrix[18][39].setColor(Color.BLACK,1);
        _matrix[18][40].setColor(Color.BLACK,1);
        _matrix[21][41].setColor(Color.BLACK,1);
        _matrix[21][43].setColor(Color.BLACK,1);
        _matrix[22][43].setColor(Color.BLACK,1);
        _matrix[17][41].setColor(Color.BLACK,1);
        _matrix[17][43].setColor(Color.BLACK,1);
        _matrix[16][43].setColor(Color.BLACK,1);

    }


    public void setInfiniteGrowthSeed()
    {
        _matrix[50][40].setColor(Color.BLACK,1);
        _matrix[50][41].setColor(Color.BLACK,1);
        _matrix[50][42].setColor(Color.BLACK,1);
        _matrix[50][43].setColor(Color.BLACK,1);
        _matrix[50][44].setColor(Color.BLACK,1);
        _matrix[50][45].setColor(Color.BLACK,1);
        _matrix[50][46].setColor(Color.BLACK,1);
        _matrix[50][47].setColor(Color.BLACK,1);

        _matrix[50][49].setColor(Color.BLACK,1);
        _matrix[50][50].setColor(Color.BLACK,1);
        _matrix[50][51].setColor(Color.BLACK,1);
        _matrix[50][52].setColor(Color.BLACK,1);
        _matrix[50][53].setColor(Color.BLACK,1);

        _matrix[50][57].setColor(Color.BLACK,1);
        _matrix[50][58].setColor(Color.BLACK,1);
        _matrix[50][59].setColor(Color.BLACK,1);

        _matrix[50][66].setColor(Color.BLACK,1);
        _matrix[50][67].setColor(Color.BLACK,1);
        _matrix[50][68].setColor(Color.BLACK,1);
        _matrix[50][69].setColor(Color.BLACK,1);
        _matrix[50][70].setColor(Color.BLACK,1);
        _matrix[50][71].setColor(Color.BLACK,1);
        _matrix[50][72].setColor(Color.BLACK,1);

        _matrix[50][74].setColor(Color.BLACK,1);
        _matrix[50][75].setColor(Color.BLACK,1);
        _matrix[50][76].setColor(Color.BLACK,1);
        _matrix[50][77].setColor(Color.BLACK,1);
        _matrix[50][78].setColor(Color.BLACK,1);

    }

}
