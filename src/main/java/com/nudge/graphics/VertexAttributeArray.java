package com.nudge.graphics;

import static org.lwjgl.opengl.GL30.*;

/**
 * @author Frederik Dahl
 * 29/06/2021
 */

public class VertexAttributeArray {

    private final int id;

    public VertexAttributeArray() { id = glGenVertexArrays(); }

    public void bind() { glBindVertexArray(id); }

    public void unbind() { glBindVertexArray(0); }

    public void delete() { glDeleteVertexArrays(id); }

    public int getId() { return id; }

}
