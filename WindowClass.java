package fractal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowClass extends JFrame {
    private JTextField[] vertexFields;
    private JTextField levelField;
    private JPanel drawingPanel;

    public WindowClass() {
        setTitle("Fractal Drawer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(5, 2));

        vertexFields = new JTextField[6];
        for (int i = 0; i < 6; i++) {
            vertexFields[i] = new JTextField(5);
            controlPanel.add(new JLabel("Vertex " + (i + 1) + ":"));
            controlPanel.add(vertexFields[i]);
        }

        controlPanel.add(new JLabel("Level:"));
        levelField = new JTextField(5);
        controlPanel.add(levelField);

        JButton drawButton = new JButton("Draw");
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawFractal();
            }
        });
        controlPanel.add(drawButton);

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearDrawing();
            }
        });
        controlPanel.add(clearButton);

        add(controlPanel, BorderLayout.NORTH);

        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
            }
        };
        add(drawingPanel, BorderLayout.CENTER);
    }

    private void drawFractal() {
        try {
            int[] coords = new int[6];
            for (int i = 0; i < 6; i++) {
                coords[i] = Integer.parseInt(vertexFields[i].getText());
            }
            int level = Integer.parseInt(levelField.getText());

            PointClass p1 = new PointClass(coords[0], coords[1]);
            PointClass p2 = new PointClass(coords[2], coords[3]);
            PointClass p3 = new PointClass(coords[4], coords[5]);
            TriangleClass initialTriangle = new TriangleClass(p1, p2, p3);

            Graphics g = drawingPanel.getGraphics();
            drawFractalRecursive(g, initialTriangle, level);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid integers for coordinates and level.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void drawFractalRecursive(Graphics g, TriangleClass triangle, int level) {
        if (level == 0) {
            triangle.draw(g);
        } else {
            triangle.draw(g);
            TriangleClass t1 = new TriangleClass(triangle.getP1(), triangle.getMid1(), triangle.getMid3());
            TriangleClass t2 = new TriangleClass(triangle.getMid1(), triangle.getP2(), triangle.getMid2());
            TriangleClass t3 = new TriangleClass(triangle.getMid3(), triangle.getMid2(), triangle.getP3());
            drawFractalRecursive(g, t1, level - 1);
            drawFractalRecursive(g, t2, level - 1);
            drawFractalRecursive(g, t3, level - 1);
        }
    }

    private void clearDrawing() {
        drawingPanel.repaint();
    }
}

