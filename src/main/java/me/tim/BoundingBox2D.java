/*
 * Copyright (c) Tim Teichmann 2022. None of this code to be reused without my written permission. Intellectual Rights owned by Tim Teichmann.
 */

package me.tim;

import me.tim.util.Vec2f;

/**
 * Save position data of literally anything that's two-dimensional. 
 * 
 * @author Tim
 * @since Version 0.0.1
 */
public class BoundingBox2D {
    private float xPos, width, yPos, height;
    private float diameter;
    private final boolean isCircle;

    /**
     * Constructor to create a BoundingBox that's shaped like a rectangle.
     *
     * @param xPos Rectangle xPosition
     * @param yPos Rectangle yPosition
     * @param width Rectangle width
     * @param height Rectangle height
     */
    public BoundingBox2D(float xPos, float yPos, float width, float height) {
        this.xPos = xPos;
        this.width = width;
        this.yPos = yPos;
        this.height = height;
        this.diameter = 0;
        this.isCircle = false;
    }

    /**
     * Constructor to create a BoundingBox that's circle-shaped.
     *
     * @param xPos Circle xPosition
     * @param yPos Circle yPosition
     * @param diameter Circle diameter (2 * radius)
     */
    public BoundingBox2D(float xPos, float yPos, float diameter) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = 0;
        this.height = 0;
        this.diameter = diameter;
        this.isCircle = true;
    }

    /**
     * Get the Center of this two-dimensional BoundingBox
     *
     * @return new Vec2 -> Targets the Center of the provided BoundingBox
     */
    public Vec2f getCenter() {
        return (
                this.isCircle() ?
                        new Vec2f(this.getXPos(), this.getYPos()).addAll(this.getRadius())
                        : new Vec2f(this.getXPos(), this.getYPos()).add(
                                this.getWidth() / 2f,
                                this.getHeight() / 2f)
        );
    }

    /**
     * @return The xPos
     */
    public float getXPos() {
        return xPos;
    }

    /**
     * Set the value for xPos.
     *
     * @param xPos
     */
    public void setXPos(float xPos) {
        this.xPos = xPos;
    }

    /**
     * @return The width
     */
    public float getWidth() {
        return width;
    }

    /**
     * Set the value for width.
     *
     * @param width
     */
    public void setWidth(float width) {
        this.width = width;
    }

    /**
     * @return The yPos
     */
    public float getYPos() {
        return yPos;
    }

    /**
     * Set the value for yPos.
     *
     * @param yPos
     */
    public void setYPos(float yPos) {
        this.yPos = yPos;
    }

    /**
     * @return The height.
     */
    public float getHeight() {
        return height;
    }

    /**
     * Set the value for height.
     *
     * @param height
     */
    public void setHeight(float height) {
        this.height = height;
    }

    /**
     * @return The diameter.
     */
    public float getDiameter() {
        return diameter;
    }

    /**
     * Set the value for diameter.
     *
     * @param diameter
     */
    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }

    /**
     * @return The radius.
     */
    public float getRadius() {
        return this.diameter / 2f;
    }

    /**
     * @return Is the BoundingBox2D a circle?
     */
    public boolean isCircle() {
        return isCircle;
    }
}
