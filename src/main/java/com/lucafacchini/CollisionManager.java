package com.lucafacchini;

public class CollisionManager {

    public CollisionManager() {}

    public boolean isColliding(Tile tile1, Tile tile2) {
        return tile1.x == tile2.x && tile1.y == tile2.y;
    }
}
