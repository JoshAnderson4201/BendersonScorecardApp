package com.example.ja160637.bendersonscorecard;

/**
 * Created by retre on 3/25/2018.
 */

public class HoleInfo
{
    //Arrays of data from Cable Hollow (yardage array is from white tees)
    private int[] holeNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 23, 14, 15, 16, 17, 18};
    private int[] pars = {4, 3, 4, 4, 3, 5, 4, 4, 5, 4, 4, 4, 5, 4, 4, 4, 3, 5};
    private int[] yardages = {335, 141, 322, 370, 198, 480, 425, 346, 515, 310, 275, 356, 526, 320, 391, 330, 175, 505};

    //All of the getters will take the hole number as a parameter
    public int getHoleNumber(int hole)
    {
        return holeNumbers[hole - 1];
    }

    //All of the getters will take the hole number as a parameter
    public int getHolePar(int hole)
    {
        return pars[hole - 1];
    }

    //All of the getters will take the hole number as a parameter
    public int getHoleYardage(int hole)
    {
        return yardages[hole - 1];
    }

    
}
