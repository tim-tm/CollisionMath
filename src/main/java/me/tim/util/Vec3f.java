/*
 * Copyright (c) Tim Teichmann 2022. None of this code to be reused without my written permission. Intellectual Rights owned by Tim Teichmann.
 */

package me.tim.util;

/**
 * This class was created to properly save and manage three-dimensional coordinates.
 *
 * @author Tim
 * @since Version 0.0.2
 */
public class Vec3f {
    private float x, y, z;

    /**
     * Create a new Vec3 to manage positions.
     *
     * @param x given X-Position
     * @param y given Y-Position
     * @param z given Z-Position
     */
    public Vec3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Copy an existing Vec3.
     *
     * @param vec3f Vector to copy from
     */
    public Vec3f(Vec3f vec3f) {
        this.x = vec3f.getX();
        this.y = vec3f.getY();
        this.z = vec3f.getZ();
    }

    /**
     * Return a new Vec3 with the given positions added. Different parameters for different axis.
     *
     * @param x addition on X-Axis
     * @param y addition on Y-Axis
     * @param z addition on Z-Axis
     * @return new Vec3 with added Positions
     */
    public Vec3f add(float x, float y, float z) {
        return new Vec3f(this.x + x, this.y + y, this.z + z);
    }

    /**
     * Return a new Vec3 with the given positions added. Single parameter for every axis.
     *
     * @param value addition on X, Y and Z-Axis
     * @return new Vec3 with added Positions
     */
    public Vec3f addAll(float value) {
        return new Vec3f(this.x + value, this.y + value, this.z + value);
    }

    /**
     * Get the value of x.
     *
     * @return The value for x.
     */
    public float getX() {
        return x;
    }

    /**
     * Set a new value for x.
     *
     * @param x new x-value
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Get the value of y.
     *
     * @return The value for y.
     */
    public float getY() {
        return y;
    }

    /**
     * Set a new value for y.
     *
     * @param y new y-value
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Get the value of z.
     *
     * @return The value for z.
     */
    public float getZ() {
        return z;
    }

    /**
     * Set a new value for z.
     *
     * @param z new z-value
     */
    public void setZ(float z) {
        this.z = z;
    }
}
