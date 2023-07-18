package com.utp.proyectodealgoritmos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;

/**
 * BinaryTreeViewer draws binary trees using Swing.
 * Draw the tree using {@link #display(Object)}
 * @author Gahwon Lee
 */
public class BinaryTreeViewer {
    /**
     * Minimum width of each node
     */
    public static final double MIN_WIDTH = 20;
    /**
     * Height of node
     */
    public static final double HEIGHT = 20;
    /**
     * Maximum height of edge
     */
    public static final double MAX_HEIGHT_SEPARATION = 80;
    
    // functions to call to extract data
    private Function<Object, Object> getData;
    private Function<Object, Object> getLeft;
    private Function<Object, Object> getRight;
    
    // frame to display tree on
    private JFrame frame;
    private JPanel panel;
    
    /**
     * Constructs a Binary Tree Viewer by parsing these instance variables (can be
     * private)
     * <p>
     * Data is parsed from the instance variable {@code data},
     * left child is parsed from the instance variable {@code left},
     * right child is parsed from the instance variable {@code right}
     */
    public BinaryTreeViewer() {
        this("data");
    }
    
    /**
     * Constructs a Binary Tree Viewer by parsing these instance variables (can be
     * private)
     * <p>
     * left child is parsed from the instance variable {@code left},
     * right child is parsed from the instance variable {@code right}
     * @param dataName Data is parsed from this instance variable
     */
    public BinaryTreeViewer(String dataName) {
        this(dataName, "left", "right");
    }
    
    /**
     * Constructs a Binary Tree Viewer by parsing these instance variables (can be
     * private)
     * <p>
     * Data is parsed from the instance variable {@code data}
     * @param leftChildName  left child is parsed from this instance variable
     * @param rightChildName right child is parsed from this instance variable
     */
    public BinaryTreeViewer(String leftChildName, String rightChildName) {
        this("data", leftChildName, rightChildName);
    }
    
    /**
     * Constructs a Binary Tree Viewer by parsing these instance variables (can be
     * private)
     * @param dataName       Data is parsed from this instance variable
     * @param leftChildName  left child is parsed from this instance variable
     * @param rightChildName right child is parsed from this instance variable
     */
    public BinaryTreeViewer(String dataName, String leftChildName, String rightChildName) {
        setDataVariable(dataName);
        setLeftChildVariable(leftChildName);
        setRightChildVariable(rightChildName);
    }
    
    /**
     * Draws the tree
     * @param rootNode root node of the tree
     */
    public void display(Object rootNode) {
        display(rootNode, 1280, 720);
    }
    
    /**
     * Draws the tree
     * @param rootNode root node of the tree
     * @param width    width of the window to display
     * @param height   height of the window to display
     */
    public void display(Object rootNode, int width, int height) {
        
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(width, height));
        
        Graphics2D g2 = createDrawable(width, height);
        
        // anti aliasing
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(1.1f));
        
        frame = new JFrame("Binary Tree Viewer");
        frame.setResizable(false);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.toFront();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        // draw tree
        try {
            drawTree(g2, width, height, rootNode);
            panel.repaint();
        }
        catch (Exception e) {
            exitFrame();
            e.printStackTrace();
        }
    }
    
    /**
     * Creates a new image where the tree will be drawn
     * @param width  width of image
     * @param height height of image
     * @return graphics that you can draw on to affect the image
     */
    private Graphics2D createDrawable(int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        panel.removeAll();
        panel.add(new JLabel(new ImageIcon(image)));
        return (Graphics2D) image.getGraphics();
    }
    
    /**
     * Draws the edges and the nodes of the tree
     * @param g        graphics to draw to
     * @param width    width of graphics
     * @param height   height of graphics
     * @param rootNode root node of tree
     */
    private void drawTree(Graphics2D g, int width, int height, Object rootNode) {
        // calculate spacing
        TreeMap<Fraction, DrawableNode> nodes = new TreeMap<>();
        int maxDepth = parseTree(nodes, rootNode, new Fraction(0, 1), new Fraction(2048, 1),
            1, null, g);
        double offsetX = 0;
        double startX = 0;
        double deltaX = (nodes.size() > 20) ? 1 : 1.5;
        int middle = nodes.size() / 2;
        for (Map.Entry<Fraction, DrawableNode> entry : nodes.entrySet()) {
            entry.getValue().setX(startX);
            if (middle == 0)
                offsetX = width / 2 - startX;
            middle--;
            startX += entry.getValue().getWidth() * deltaX;
        }
        
        double deltaY = Math.min(height / (maxDepth + 1), MAX_HEIGHT_SEPARATION);
        
        // draw edges
        g.setColor(Color.BLACK);
        for (Map.Entry<Fraction, DrawableNode> entry : nodes.entrySet()) {
            DrawableNode to = entry.getValue();
            DrawableNode from = to.getFrom();
            if (from != null) {
                g.draw(new Line2D.Double(to.getX() + offsetX, to.getY(deltaY), from.getX() + offsetX,
                    from.getY(deltaY)));
            }
        }
        
        // draw nodes
        for (Map.Entry<Fraction, DrawableNode> entry : nodes.entrySet()) {
            entry.getValue().drawNode(g, offsetX, deltaY);
        }
    }
    
    /**
     * Helper method to order nodes from left to right to figure out spacing
     * @param nodes  nodes sorted by order from left to right
     * @param node   current node being sorted
     * @param center position where the node will be added
     * @param delta  x distance from this to children
     * @param depth  depth of current node in tree
     * @param from   parent node
     * @param g      graphics to calculate width of data
     * @return maximum depth
     */
    private int parseTree(TreeMap<Fraction, DrawableNode> nodes, Object node, Fraction center,
                          Fraction delta, int depth, DrawableNode from, Graphics2D g) {
        if (node == null)
            return depth;
        DrawableNode drawableNode = new DrawableNode(depth, getData.apply(node), from, g);
        nodes.put(center, drawableNode);
        Object left = getLeft.apply(node);
        Fraction nextDelta = delta.divide(2);
        int maxDepth = depth;
        if (left != null) {
            maxDepth = parseTree(nodes, left, center.subtract(delta), nextDelta, depth + 1,
                drawableNode, g);
        }
        Object right = getRight.apply(node);
        if (right != null) {
            maxDepth = Math.max(maxDepth, parseTree(nodes, right, center.add(delta), nextDelta,
                depth + 1, drawableNode, g));
        }
        return maxDepth;
    }
    
    /**
     * Holds drawing info for a node
     */
    private class DrawableNode {
        /**
         * Depth of node in tree
         */
        private int depth;
        /**
         * Width of the rectangle to draw the value in
         */
        private double width;
        /**
         * Text value to draw within rectangle
         */
        private String text;
        /**
         * X position of the node, set using {@link #setX(double)}
         */
        private double x;
        /**
         * Parent node (to draw edges)
         */
        private DrawableNode from;
        
        /**
         * Constructs a new drawable node
         * @param depth depth of node
         * @param value value to convert to a string
         * @param from  parent node or null if root
         * @param g     graphics to use when getting the drawing width of the value
         */
        public DrawableNode(int depth, Object value, DrawableNode from, Graphics2D g) {
            this.depth = depth;
            this.text = String.valueOf(value);
            this.from = from;
            width = Math.max(MIN_WIDTH, 2 + g.getFontMetrics().charsWidth(text.toCharArray(), 0, text.length()));
        }
        
        /**
         * Draws the node
         * @param g      graphics to draw on
         * @param offset offset in x position of node
         */
        public void drawNode(Graphics2D g, double offset, double deltaY) {
            FontMetrics metrics = g.getFontMetrics();
            String text = String.valueOf(this.text);
            
            RoundRectangle2D.Double rect = new RoundRectangle2D.Double(x + offset - width / 2,
                getY(deltaY) - HEIGHT / 2, width, HEIGHT, width / 4, HEIGHT / 4);
            g.setColor(Color.WHITE);
            g.fill(rect);
            g.setColor(Color.BLACK);
            g.draw(rect);
            
            double xx = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
            double yy = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
            
            g.drawString(text, doubleToInt(xx), doubleToInt(yy));
        }
        
        public double getX() {
            return x;
        }
        
        public void setX(double x) {
            this.x = x;
        }
        
        private double getY(double deltaY) {
            return depth * deltaY;
        }
        
        public double getWidth() {
            return width;
        }
        
        public DrawableNode getFrom() {
            return from;
        }
        
        @Override
        public String toString() {
            return text + "$" + depth;
        }
    }
    
    /**
     * Object to prevent floating point precision error. This Fraction is immutable
     */
    private static class Fraction implements Comparable<Fraction> {
        /**
         * Numerator value
         */
        private final int num;
        /**
         * Denominator value
         */
        private final int den;
        
        /**
         * Constructs a new Fraction
         * @param num numerator
         * @param den denominator
         */
        public Fraction(int num, int den) {
            this.num = num;
            this.den = den;
            if (den < 0) {
                num *= -1;
                den *= -1;
            }
        }
        
        /**
         * this + other
         * @param other fraction to add to this
         * @return this + other
         */
        public Fraction add(Fraction other) {
            int lcm = lcm(den, other.den);
            return new Fraction(num * (lcm / den) + other.num * (lcm / other.den), lcm).reduce();
        }
        
        /**
         * this - other
         * @param other fraction to subtract from this
         * @return this - other
         */
        public Fraction subtract(Fraction other) {
            int lcm = lcm(den, other.den);
            return new Fraction(num * (lcm / den) - other.num * (lcm / other.den), lcm).reduce();
        }
        
        /**
         * this * (1 / num)
         * @param num number to divide this by
         * @return this / num
         */
        public Fraction divide(int num) {
            return new Fraction(this.num, den * num).reduce();
        }
        
        /**
         * Reduces the fraction (does not mutate this)
         * @return reduced fraction
         */
        public Fraction reduce() {
            int num = Math.abs(this.num);
            int den = Math.abs(this.den);
            
            int gcd;
            if (num > den)
                gcd = gcd(num, den);
            else if (num < den)
                gcd = gcd(den, num);
            else
                gcd = 1;
            
            return new Fraction(this.num / gcd, this.den / gcd);
        }
        
        /**
         * Greatest common denominator of two integers
         * @param a first integer
         * @param b second integer
         * @return greatest common denominator of a and b
         */
        public int gcd(int a, int b) {
            while (b > 0) {
                int t = b;
                b = a % b;
                a = t;
            }
            return Math.abs(a);
        }
        
        /**
         * Least common multiple of two integers
         * @param a first integer
         * @param b second integer
         * @return least common multiple of a and b
         */
        public int lcm(int a, int b) {
            return Math.abs(b / gcd(a, b) * a);
        }
        
        @Override
        public String toString() {
            return num + "/" + den;
        }
        
        @Override
        public int compareTo(Fraction o) {
            return subtract(o).num;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            
            Fraction reduced = reduce();
            Fraction other = ((Fraction) o).reduce();
            
            return reduced.num == other.num && reduced.den == other.den;
        }
    }
    
    /**
     * Use this method if you want this to get the data from an instance variable (which
     * can be private)
     * @param variableName name of variable to get in the node class
     * @return this for chaining
     */
    public BinaryTreeViewer setDataVariable(String variableName) {
        setDataFunction(new ValueFunction(variableName) {
            @Override
            public Object apply(Object o) {
                try {
                    Field data = o.getClass().getDeclaredField(getValue());
                    data.setAccessible(true);
                    return data.get(o);
                    
                }
                catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                throw new IllegalArgumentException("Exception when accessing data of node. Make sure data variable name "
                    + getValue() + " is spelled correctly.");
            }
        });
        return this;
    }
    
    /**
     * Use this method if you want this to get the data from a method. The method must
     * return the data and not take any parameters
     * @param methodName name of method to call in the node class
     * @return this for chaining
     */
    public BinaryTreeViewer setDataMethod(String methodName) {
        methodName = methodName.replaceAll("[()]", "");
        setDataFunction(new ValueFunction(methodName) {
            @Override
            public Object apply(Object o) {
                try {
                    Method method = o.getClass().getDeclaredMethod(getValue());
                    method.setAccessible(true);
                    return method.invoke(o);
                }
                catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                throw new IllegalArgumentException("Exception when accessing method. Make sure the method name "
                    + getValue() + " is spelled correctly, has no parameters, and returns an object.");
            }
        });
        return this;
    }
    
    /**
     * Use this method if you want this to get the data from a function. The function
     * passes in a node and expects its data
     * @param getData function to use when extracting data
     * @return this for chaining
     */
    public BinaryTreeViewer setDataFunction(Function<Object, Object> getData) {
        this.getData = getData;
        return this;
    }
    
    /**
     * Use this method if you want this to get the left child from an instance variable
     * (which can be private)
     * @param variableName name of variable to get in the node class
     * @return this for chaining
     */
    public BinaryTreeViewer setLeftChildVariable(String variableName) {
        setLeftChildFunction(new ValueFunction(variableName) {
            @Override
            public Object apply(Object o) {
                try {
                    Field left = o.getClass().getDeclaredField(getValue());
                    left.setAccessible(true);
                    return left.get(o);
                    
                }
                catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                throw new IllegalArgumentException("Exception when accessing data of node. Make sure left child variable name "
                    + getValue() + " is spelled correctly.");
            }
        });
        return this;
    }
    
    /**
     * Use this method if you want this to get the left child from a method. The method
     * must return the left child node and not take any parameters
     * @param methodName name of method to call in the node class
     * @return this for chaining
     */
    public BinaryTreeViewer setLeftChildMethod(String methodName) {
        methodName = methodName.replaceAll("[()]", "");
        setLeftChildFunction(new ValueFunction(methodName) {
            @Override
            public Object apply(Object o) {
                try {
                    Method method = o.getClass().getDeclaredMethod(getValue());
                    method.setAccessible(true);
                    return method.invoke(o);
                }
                catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                throw new IllegalArgumentException("Exception when accessing method. Make sure the method name "
                    + getValue() + " is spelled correctly, has no parameters, and returns an object.");
            }
        });
        return this;
    }
    
    /**
     * Use this method if you want this to get the left child from a function. The
     * function passes in a node and expects its left child node
     * @param getLeft function to use when extracting left child node
     * @return this for chaining
     */
    public BinaryTreeViewer setLeftChildFunction(Function<Object, Object> getLeft) {
        this.getLeft = getLeft;
        return this;
    }
    
    /**
     * Use this method if you want this to get the right child from an instance variable
     * (which can be private)
     * @param variableName name of variable to get in the node class
     * @return this for chaining
     */
    public BinaryTreeViewer setRightChildVariable(String variableName) {
        setRightChildFunction(new ValueFunction(variableName) {
            @Override
            public Object apply(Object o) {
                try {
                    Field right = o.getClass().getDeclaredField(getValue());
                    right.setAccessible(true);
                    return right.get(o);
                    
                }
                catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                throw new IllegalArgumentException("Exception when accessing data of node. Make sure right child variable name "
                    + getValue() + " is spelled correctly.");
            }
        });
        return this;
    }
    
    /**
     * Use this method if you want this to get the right child from a method. The method
     * must return the right child node and not take any parameters
     * @param methodName name of method to call in the node class
     * @return this for chaining
     */
    public BinaryTreeViewer setRightChildMethod(String methodName) {
        methodName = methodName.replaceAll("[()]", "");
        setRightChildFunction(new ValueFunction(methodName) {
            @Override
            public Object apply(Object o) {
                try {
                    Method method = o.getClass().getDeclaredMethod(getValue());
                    method.setAccessible(true);
                    return method.invoke(o);
                }
                catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                throw new IllegalArgumentException("Exception when accessing method. Make sure the method name "
                    + getValue() + " is spelled correctly, has no parameters, and returns an object.");
            }
        });
        return this;
    }
    
    /**
     * Use this method if you want this to get the right child from a function. The
     * function passes in a node and expects its right child node
     * @param getRight function to use when extracting right child node
     * @return this for chaining
     */
    public BinaryTreeViewer setRightChildFunction(Function<Object, Object> getRight) {
        this.getRight = getRight;
        return this;
    }
    
    /**
     * Implementation of Function that takes in a value during construction
     */
    private static abstract class ValueFunction implements Function<Object, Object> {
        private String value;
        
        public ValueFunction(String value) {
            this.value = value;
        }
        
        public String getValue() {
            return value;
        }
    }
    
    /**
     * Exits the frame. Use in case of any exception
     */
    private void exitFrame() {
        if (frame != null)
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
    
    /**
     * Converts a double to an integer by calling {@link Math#round(double)}
     * @param d double to convert to integer
     * @return integer version of the double
     */
    private int doubleToInt(double d) {
        return (int) Math.round(d);
    }
}
