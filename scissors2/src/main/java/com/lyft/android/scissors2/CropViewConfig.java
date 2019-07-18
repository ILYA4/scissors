/*
 * Copyright (C) 2015 Lyft, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lyft.android.scissors2;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

class CropViewConfig {

    public static final float DEFAULT_VIEWPORT_RATIO = 0f;
    public static final float DEFAULT_MAXIMUM_SCALE = 10f;
    public static final float DEFAULT_MINIMUM_SCALE = 0f;
    public static final int DEFAULT_IMAGE_QUALITY = 100;
    public static final int DEFAULT_VIEWPORT_OVERLAY_PADDING = 0;
    public static final int DEFAULT_VIEWPORT_OVERLAY_COLOR = 0xC8000000; // Black with 200 alpha
    public static final int DEFAULT_SHAPE = CropView.Shape.RECTANGLE;
    public static final boolean DEFAULT_GRID_ENABLE = false;
    public static final int DEFAULT_GRID_COLUMNS = 3;
    public static final int DEFAULT_GRID_LINES = 3;
    public static final int DEFAULT_GRID_COLOR = 0xFFFFFFFF;
    public static final int DEFAULT_GRID_OUTLINE_COLOR =  0x80FFFFFF;

    private float viewportRatio = DEFAULT_VIEWPORT_RATIO;
    private float maxScale = DEFAULT_MAXIMUM_SCALE;
    private float minScale = DEFAULT_MINIMUM_SCALE;
    private int viewportOverlayPadding = DEFAULT_VIEWPORT_OVERLAY_PADDING;
    private int viewportOverlayColor = DEFAULT_VIEWPORT_OVERLAY_COLOR;
    private boolean gridEnable = DEFAULT_GRID_ENABLE;
    private int gridColumns = DEFAULT_GRID_COLUMNS;
    private int gridLines = DEFAULT_GRID_LINES;
    private int gridColor = DEFAULT_GRID_COLOR;
    private int gridOutlineColor = DEFAULT_GRID_OUTLINE_COLOR;

    private @CropView.Shape int shape = DEFAULT_SHAPE;

    public int getViewportOverlayColor() {
        return viewportOverlayColor;
    }

    void setViewportOverlayColor(int viewportOverlayColor) {
        this.viewportOverlayColor = viewportOverlayColor;
    }

    public int getViewportOverlayPadding() {
        return viewportOverlayPadding;
    }

    void setViewportOverlayPadding(int viewportOverlayPadding) {
        this.viewportOverlayPadding = viewportOverlayPadding;
    }

    public float getViewportRatio() {
        return viewportRatio;
    }

    void setViewportRatio(float viewportRatio) {
        this.viewportRatio = viewportRatio <= 0 ? DEFAULT_VIEWPORT_RATIO : viewportRatio;
    }

    public float getMaxScale() {
        return maxScale;
    }

    void setMaxScale(float maxScale) {
        this.maxScale = maxScale <= 0 ? DEFAULT_MAXIMUM_SCALE : maxScale;
    }

    public float getMinScale() {
        return minScale;
    }

    void setMinScale(float minScale) {
        this.minScale = minScale <= 0 ? DEFAULT_MINIMUM_SCALE : minScale;
    }

    public boolean isGridEnable() {
        return gridEnable;
    }

    public void setGridEnable(boolean gridEnable) {
        this.gridEnable = gridEnable;
    }

    public int getGridColumns() {
        return gridColumns;
    }

    public void setGridColumns(int gridColumns) {
        this.gridColumns = gridColumns;
    }

    public int getGridLines() {
        return gridLines;
    }

    public void setGridLines(int gridLines) {
        this.gridLines = gridLines;
    }

    public int getGridColor() {
        return gridColor;
    }

    public void setGridColor(int gridColor) {
        this.gridColor = gridColor;
    }

    public int getGridOutlineColor() {
        return gridOutlineColor;
    }

    public void setGridOutlineColor(int gridOutlineColor) {
        this.gridOutlineColor = gridOutlineColor;
    }

    public @CropView.Shape int shape() {
        return shape;
    }

    public void setShape(@CropView.Shape int shape) {
        this.shape = shape;
    }

    public static CropViewConfig from(Context context, AttributeSet attrs) {
        final CropViewConfig cropViewConfig = new CropViewConfig();

        if (attrs == null) {
            return cropViewConfig;
        }

        TypedArray attributes = context.obtainStyledAttributes(
                attrs,
                R.styleable.CropView);

        cropViewConfig.setViewportRatio(
                attributes.getFloat(R.styleable.CropView_cropviewViewportRatio,
                        CropViewConfig.DEFAULT_VIEWPORT_RATIO));

        cropViewConfig.setMaxScale(
                attributes.getFloat(R.styleable.CropView_cropviewMaxScale,
                        CropViewConfig.DEFAULT_MAXIMUM_SCALE));

        cropViewConfig.setMinScale(
                attributes.getFloat(R.styleable.CropView_cropviewMinScale,
                        CropViewConfig.DEFAULT_MINIMUM_SCALE));

        cropViewConfig.setViewportOverlayColor(
            attributes.getColor(R.styleable.CropView_cropviewViewportOverlayColor,
                CropViewConfig.DEFAULT_VIEWPORT_OVERLAY_COLOR));

        cropViewConfig.setViewportOverlayPadding(
            attributes.getDimensionPixelSize(R.styleable.CropView_cropviewViewportOverlayPadding,
                CropViewConfig.DEFAULT_VIEWPORT_OVERLAY_PADDING));

        cropViewConfig.setGridEnable(
                attributes.getBoolean(R.styleable.CropView_cropviewGridEnable,
                        DEFAULT_GRID_ENABLE));

        cropViewConfig.setGridColumns(
                attributes.getInt(R.styleable.CropView_cropviewGridColumns,
                        DEFAULT_GRID_COLUMNS));

        cropViewConfig.setGridLines(
                attributes.getInt(R.styleable.CropView_cropviewGridLines,
                        DEFAULT_GRID_LINES));

        cropViewConfig.setGridColor(
                attributes.getColor(R.styleable.CropView_cropviewGridColor,
                        DEFAULT_GRID_COLOR));

        cropViewConfig.setGridOutlineColor(
                attributes.getColor(R.styleable.CropView_cropviewOutlineColor,
                        DEFAULT_GRID_OUTLINE_COLOR));

        @CropView.Shape int shape = attributes.getInt(
                R.styleable.CropView_cropviewShape, CropViewConfig.DEFAULT_SHAPE);
        cropViewConfig.setShape(shape);

        attributes.recycle();

        return cropViewConfig;
    }
}
