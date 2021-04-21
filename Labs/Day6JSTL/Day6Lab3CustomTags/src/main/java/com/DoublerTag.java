package com;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class DoublerTag extends SimpleTagSupport {
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    

    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        try {
            out.println("Double of " + number + "is " + (2 * number));
        } catch(IOException exception) {
            exception.printStackTrace();
        }
    }
}