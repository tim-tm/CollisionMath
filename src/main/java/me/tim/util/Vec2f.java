/*
 * Copyright (c) Tim Teichmann 2022. None of this code to be reused without my written permission. Intellectual Rights owned by Tim Teichmann.
 */

package me.tim.util;

/**
 * This class was created to properly save and manage two-dimensional coordinates;
 *
 * @author Tim
 * @since 22.11.2022 - Version 1.1
 */
@SuppressWarnings("unused")
public class Vec2f {
    private float x, y;

    /**
     * Create a new Vec2 to manage positions.
     *
     * @param x given X-Position
     * @param y given Y-Position
     */
    public Vec2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Copy an existing Vec2.
     *
     * @param vec2f Vector to copy from
     */
    public Vec2f(Vec2f vec2f) {
        this.x = vec2f.getX();
        this.y = vec2f.getY();
    }

    /**
     * Return a new Vec2 with the given positions added.
     * Different parameters for different axis.
     *
     * @param x addition on X-Axis
     * @param y addition on Y-Axis
     * @return new Vec2 with added Positions
     */
    public Vec2f add(float x, float y) {
        return new Vec2f(this.x + x, this.y + y);
    }

    /**
     * Return a new Vec2 with the given positions added.
     * Single parameter for every axis.
     *
     * @param value addition on X and Y-Axis
     * @return new Vec2 with added Positions
     */
    public Vec2f addAll(float value) {
        return new Vec2f(this.x + value, this.y + value);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
