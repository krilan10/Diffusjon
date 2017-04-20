/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diffusjon;

/**
 *
 * @author Mikael
 */

public class LoggInfo {
    private int step;
    private int xCoordinate;
    private int yCoordinate;


    public LoggInfo(int step, int xCoordinate, int yCoordinate) {
        this.step = step;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;


    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }



}
