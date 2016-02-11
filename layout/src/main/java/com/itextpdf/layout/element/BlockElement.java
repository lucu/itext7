package com.itextpdf.layout.element;

import com.itextpdf.kernel.pdf.tagutils.IAccessibleElement;
import com.itextpdf.layout.Property;
import com.itextpdf.layout.renderer.BlockRenderer;

/**
 * A {@link BlockElement} will try to take up as much horizontal space as
 * available to it on the canvas or page. The concept is comparable to the block
 * element in HTML. Also like in HTML, the visual representation of the object
 * can be delimited by padding, a border, and/or a margin.
 * 
 * @param <T> the type of the implementation
 */
public abstract class BlockElement<T extends BlockElement> extends AbstractElement<T> implements IElement<T>, IAccessibleElement {

    /**
     * Creates a BlockElement.
     */
    public BlockElement() {
    }

    /**
     * Gets the current left margin width of the element.
     * @return the left margin width, as a <code>float</code>
     */
    public Float getMarginLeft() {
        return getProperty(Property.MARGIN_LEFT);
    }

    /**
     * Sets the left margin width of the element.
     * @param value the new left margin width
     * @return this element
     */
    public T setMarginLeft(float value) {
        return setProperty(Property.MARGIN_LEFT, value);
    }

    /**
     * Gets the current right margin width of the element.
     * @return the right margin width, as a <code>float</code>
     */
    public Float getMarginRight() {
        return getProperty(Property.MARGIN_RIGHT);
    }

    /**
     * Sets the right margin width of the element.
     * @param value the new right margin width
     * @return this element
     */
    public T setMarginRight(float value) {
        return setProperty(Property.MARGIN_RIGHT, value);
    }

    /**
     * Gets the current top margin width of the element.
     * @return the top margin width, as a <code>float</code>
     */
    public Float getMarginTop() {
        return getProperty(Property.MARGIN_TOP);
    }

    /**
     * Sets the top margin width of the element.
     * @param value the new top margin width
     * @return this element
     */
    public T setMarginTop(float value) {
        return setProperty(Property.MARGIN_TOP, value);
    }

    /**
     * Gets the current bottom margin width of the element.
     * @return the bottom margin width, as a <code>float</code>
     */
    public Float getMarginBottom() {
        return getProperty(Property.MARGIN_BOTTOM);
    }

    /**
     * Sets the bottom margin width of the element.
     * @param value the new bottom margin width
     * @return this element
     */
    public T setMarginBottom(float value) {
        return setProperty(Property.MARGIN_BOTTOM, value);
    }

    /**
     * Sets all margins around the element to the same width.
     * 
     * @param commonMargin the new margin width
     * @return this element
     */
    public T setMargin(float commonMargin) {
        return setMargins(commonMargin, commonMargin, commonMargin, commonMargin);
    }

    /**
     * Sets the margins around the element to a series of new widths.
     * 
     * @param marginTop the new margin top width
     * @param marginRight the new margin right width
     * @param marginBottom the new margin bottom width
     * @param marginLeft the new margin left width
     * @return this element
     */
    public T setMargins(float marginTop, float marginRight, float marginBottom, float marginLeft) {
        return (T) setMarginTop(marginTop).setMarginRight(marginRight).setMarginBottom(marginBottom).setMarginLeft(marginLeft);
    }
    
    /**
     * Gets the current left padding width of the element.
     * @return the left padding width, as a <code>float</code>
     */
    public Float getPaddingLeft() {
        return getProperty(Property.PADDING_LEFT);
    }

    /**
     * Sets the left padding width of the element.
     * @param value the new left padding width
     * @return this element
     */
    public T setPaddingLeft(float value) {
        return setProperty(Property.PADDING_LEFT, value);
    }

    /**
     * Gets the current right padding width of the element.
     * @return the right padding width, as a <code>float</code>
     */
    public Float getPaddingRight() {
        return getProperty(Property.PADDING_RIGHT);
    }

    /**
     * Sets the right padding width of the element.
     * @param value the new right padding width
     * @return this element
     */
    public T setPaddingRight(float value) {
        return setProperty(Property.PADDING_RIGHT, value);
    }

    /**
     * Gets the current top padding width of the element.
     * @return the top padding width, as a <code>float</code>
     */
    public Float getPaddingTop() {
        return getProperty(Property.PADDING_TOP);
    }

    /**
     * Sets the top padding width of the element.
     * @param value the new top padding width
     * @return this element
     */
    public T setPaddingTop(float value) {
        return setProperty(Property.PADDING_TOP, value);
    }

    /**
     * Gets the current bottom padding width of the element.
     * @return the bottom padding width, as a <code>float</code>
     */
    public Float getPaddingBottom() {
        return getProperty(Property.PADDING_BOTTOM);
    }

    /**
     * Sets the bottom padding width of the element.
     * @param value the new bottom padding width
     * @return this element
     */
    public T setPaddingBottom(float value) {
        return setProperty(Property.PADDING_BOTTOM, value);
    }

    /**
     * Sets all paddings around the element to the same width.
     * 
     * @param commonPadding the new padding width
     * @return this element
     */
    public T setPadding(float commonPadding) {
        return setPaddings(commonPadding, commonPadding, commonPadding, commonPadding);
    }

    /**
     * Sets the paddings around the element to a series of new widths.
     * 
     * @param paddingTop the new padding top width
     * @param paddingRight the new padding right width
     * @param paddingBottom the new padding bottom width
     * @param paddingLeft the new padding left width
     * @return this element
     */
    public T setPaddings(float paddingTop, float paddingRight, float paddingBottom, float paddingLeft) {
        return (T) setPaddingTop(paddingTop).setPaddingRight(paddingRight).setPaddingBottom(paddingBottom).setPaddingLeft(paddingLeft);
    }

    public T setVerticalAlignment(Property.VerticalAlignment verticalAlignment) {
        return setProperty(Property.VERTICAL_ALIGNMENT, verticalAlignment);
    }

    /**
     * Sets a ratio which determines in which proportion will word spacing and character spacing
     * be applied when horizontal alignment is justified.
     * @param ratio the ratio coefficient. It must be between 0 and 1, inclusive.
     *              It means that <b>ratio</b> part of the free space will
     *              be compensated by word spacing, and <b>1-ratio</b> part of the free space will
     *              be compensated by character spacing.
     *              If <b>ratio</b> is 1, additional character spacing will not be applied.
     *              If <b>ratio</b> is 0, additional word spacing will not be applied.
     */
    public T setSpacingRatio(float ratio) {
        return setProperty(Property.SPACING_RATIO, ratio);
    }

    @Override
    public <T> T getDefaultProperty(Property property) {
        switch (property) {
            case KEEP_TOGETHER:
                return (T) Boolean.valueOf(false);
            default:
                return super.getDefaultProperty(property);
        }
    }

    /**
     * Returns whether the {@link BlockElement} should be kept together as much
     * as possible.
     * @return the current value of the {@link Property#KEEP_TOGETHER} property
     */
    public Boolean isKeepTogether() {
        return getProperty(Property.KEEP_TOGETHER);
    }

    /**
     * Sets whether the {@link BlockElement} should be kept together as much
     * as possible.
     * @param keepTogether the new value of the {@link Property#KEEP_TOGETHER} property
     * @return this element
     */
    public T setKeepTogether(boolean keepTogether) {
        return setProperty(Property.KEEP_TOGETHER, keepTogether);
    }

    /**
     * Sets the rotation angle.
     * 
     * @param angle the new rotation angle, as a <code>float</code>
     * @return this element
     */
    public T setRotationAngle(float angle) {
        setProperty(Property.ROTATION_ANGLE, angle);
        return (T) this;
    }

    /**
     * Sets the rotation angle.
     * 
     * @param angle the new rotation angle, as a <code>double</code>
     * @return this element
     */
    public T setRotationAngle(double angle) {
        setProperty(Property.ROTATION_ANGLE, (float) angle);
        return (T) this;
    }

    @Override
    protected BlockRenderer makeNewRenderer() {
        return new BlockRenderer(this);
    }
}