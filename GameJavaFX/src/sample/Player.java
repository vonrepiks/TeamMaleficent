/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.util.ArrayList;

/**
 *
 * @author cvetan
 */
public class Player extends Sprite {

    protected String name;
    public ArrayList<Sprite> inventory;

    public Player(String name) {
        this.name = name;
    }

}
