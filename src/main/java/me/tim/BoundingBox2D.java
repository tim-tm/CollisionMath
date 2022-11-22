/*
 * Copyright (c) Tim Teichmann 2022. None of this code to be reused without my written permission. Intellectual Rights owned by Tim Teichmann.
 */

package me.tim;

import me.tim.util.Vec2f;

/**
 * Class used to save position data of literally anything that's two-dimensional.
 * (Probably some kind of Rectangles or two-dimensional entities)
 *
 * @author Tim
 * @since 21.11.2022 - Version 1.0
 */
@SuppressWarnings("unused")
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

    public float getXPos() {
        return xPos;
    }

    public void setXPos(float xPos) {
        this.xPos = xPos;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getYPos() {
        return yPos;
    }

    public void setYPos(float yPos) {
        this.yPos = yPos;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getDiameter() {
        return diameter;
    }

    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }

    public float getRadius() {
        return this.diameter / 2f;
    }

    public boolean isCircle() {
        return isCircle;
    }
}
