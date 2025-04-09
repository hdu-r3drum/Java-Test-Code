package com.simpleProject.PhysicsEngine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

class Body {
    // 小球在屏幕中的绝对位置和速度（单位：像素，秒）
    double x, y;
    double vx, vy;
    double radius;

    public Body(double x, double y, double vx, double vy, double radius) {
        this.x = x; 
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.radius = radius;
    }

    // 使用欧拉积分更新速度和位置
    public void update(double dt) {
        x += vx * dt;
        y += vy * dt;
    }
}

class PhysicsEnginePanel extends JPanel implements ActionListener {
    private List<Body> bodies = new ArrayList<>();
    private Timer timer;
    // 每帧间隔，单位秒
    private final double dt = 0.016;
    // 模拟重力（像素/秒²），向下为正
    private final double gravity = 500;
    // 碰撞反弹系数
    private final double bounceFactor = 0.8;

    public PhysicsEnginePanel() {
        // 面板尺寸（这个尺寸是逻辑上窗口内显示区域的尺寸）
        this.setPreferredSize(new Dimension(400, 400));
        this.setBackground(Color.WHITE);
        // 初始化一个小球，其位置为屏幕坐标
        // 假设初始时窗口位于屏幕(300,200)，我们就用这个坐标作为初始值
        bodies.add(new Body(350, 250, 50, 0, 20));
        timer = new Timer((int)(dt * 1000), this);
        timer.start();
    }

    // 获取当前面板在屏幕中的位置
    private Point getPanelScreenLocation() {
        Point p = this.getLocation();
        SwingUtilities.convertPointToScreen(p, this.getParent());
        return p;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 获取面板当前在屏幕中的位置
        Point panelScreen = getPanelScreenLocation();
        g.setColor(Color.BLUE);
        for (Body body : bodies) {
            // 物体的绝对屏幕坐标转换为相对于面板的坐标
            int drawX = (int)(body.x - panelScreen.x - body.radius);
            int drawY = (int)(body.y - panelScreen.y - body.radius);
            int diameter = (int)(body.radius * 2);
            g.fillOval(drawX, drawY, diameter, diameter);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updatePhysics();
        repaint();
    }

    // 更新物理状态
    private void updatePhysics() {
        // 获取当前面板在屏幕中的位置
        Point panelScreen = getPanelScreenLocation();
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        // 计算当前面板的屏幕边界
        int leftBound = panelScreen.x;
        int rightBound = panelScreen.x + panelWidth;
        int topBound = panelScreen.y;
        int bottomBound = panelScreen.y + panelHeight;

        for (Body body : bodies) {
            // 应用重力，加速作用于垂直方向
            body.vy += gravity * dt;
            // 更新小球的屏幕位置
            body.update(dt);
            // 碰撞检测：以屏幕为参考系
            // 如果小球超出面板左边界
            if (body.x - body.radius < leftBound) {
                body.x = leftBound + body.radius;
                body.vx = -body.vx * bounceFactor;
            }
            // 超出右边界
            if (body.x + body.radius > rightBound) {
                body.x = rightBound - body.radius;
                body.vx = -body.vx * bounceFactor;
            }
            // 超出上边界
            if (body.y - body.radius < topBound) {
                body.y = topBound + body.radius;
                body.vy = -body.vy * bounceFactor;
            }
            // 超出下边界
            if (body.y + body.radius > bottomBound) {
                body.y = bottomBound - body.radius;
                body.vy = -body.vy * bounceFactor;
            }
        }
    }
}

public class Simple2DPhysicsEngine {
    public static void main(String[] args) {
        JFrame frame = new JFrame("2D Physics Engine with Window Drag");
        final PhysicsEnginePanel enginePanel = new PhysicsEnginePanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(enginePanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // 为了展示效果，可以增加一个拖动监听器，窗口拖动时会自动更新显示（实际拖动时，窗口位置改变后，getPanelScreenLocation() 会返回新的值）
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                // 窗口移动时，重新绘制
                enginePanel.repaint();
            }
        });
    }
}
