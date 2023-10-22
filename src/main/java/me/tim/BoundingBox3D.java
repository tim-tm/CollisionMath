/*
 * Copyright (c) Tim Teichmann 2022. None of this code to be reused without my written permission. Intellectual Rights owned by Tim Teichmann.
 */

package me.tim;

import me.tim.util.Vec3f;

/**
 * Class used to save position data of literally anything that's three-dimensional.
 * (Probably some entity or just a cube)
 *
 * @author Tim
 * @since 22.11.2022 - Version 0.0.2
 */
@SuppressWarnings("unused")
public class BoundingBox3D {
    private float minX, minY, minZ, maxX, maxY, maxZ;
    private float diameter;
    private final boolean isSphere;

    /**
     * Create a new BoundingBox3D (rectangle shaped) to manage it in your code.
     *
     * @param minX the X-Position with a different name
     * @param minY the Y-Position with a different name
     * @param minZ the Z-Position with a different name
     * @param maxX the end X-Position of the Object (minX + width)
     * @param maxY the end Y-Position of the Object (minY + height)
     * @param maxZ the end Z-Position of the Object (minZ + depth)
     */
    public BoundingBox3D(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        this.minX = minX;
        this.minY = minY;
        this.minZ = minZ;
        this.maxX = maxX;
        this.maxY = maxY;
        this.maxZ = maxZ;
        this.isSphere = false;
    }

    /**
     * Create a new BoundingBox3D (shaped like a sphere) to manage it in your code.
     *
     * @param xPos center X-Position of the sphere
     * @param yPos center Y-Position of the sphere
     * @param zPos center Z-Position of the sphere
     * @param diameter diameter of the sphere
     */
    public BoundingBox3D(float xPos, float yPos, float zPos, float diameter) {
        this.minX = xPos - diameter / 2f;
        this.minY = yPos - diameter / 2f;
        this.minZ = zPos - diameter / 2f;
        this.maxX = this.minX + diameter;
        this.maxY = this.minY + diameter;
        this.maxZ = this.minZ + diameter;
        this.isSphere = true;
    }

    /**
     * Get the Center of this three-dimensional BoundingBox
     *
     * @return new Vec3 -> Targets the Center of the provided BoundingBox
     */
    public Vec3f getCenter() {
        return (
                this.isSphere() ?
                    new Vec3f(this.getMinX(), this.getMinY(), this.getMaxZ()).addAll(this.getRadius())
                    :   new Vec3f(this.getMinX(), this.getMinY(), this.getMinZ()).add(
                            this.getMaxX() - this.getMinX(),
                            this.getMaxY() - this.getMinY(),
                            this.getMaxZ() - this.getMinZ())
        );
    }

    public boolean isSphere() {
        return isSphere;
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

    public float getMinX() {
        return minX;
    }

    public void setMinX(float minX) {
        this.minX = minX;
    }

    public float getMinY() {
        return minY;
    }

    public void setMinY(float minY) {
        this.minY = minY;
    }

    public float getMinZ() {
        return minZ;
    }

    public void setMinZ(float minZ) {
        this.minZ = minZ;
    }

    public float getMaxX() {
        return maxX;
    }

    public void setMaxX(float maxX) {
        this.maxX = maxX;
    }

    public float getMaxY() {
        return maxY;
    }

    public void setMaxY(float maxY) {
        this.maxY = maxY;
    }

    public float getMaxZ() {
        return maxZ;
    }

    public void setMaxZ(float maxZ) {
        this.maxZ = maxZ;
    }
}
