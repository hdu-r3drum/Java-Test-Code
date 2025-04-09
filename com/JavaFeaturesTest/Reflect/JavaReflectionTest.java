package com.javaFeaturesTest.Reflect;

import java.awt.Color;
import java.awt.Container;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.JFrame;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class JavaReflectionTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        // JFrame jframe = new JFrame("Hello, Reflection!");
        // jframe.getContentPane().setBackground(Color.RED);
        // jframe.setLocation(100, 100);
        // jframe.setSize(400, 200);
        // jframe.setVisible(true);
        String[] xmlStrings = xmlParser();
        Class<?> jframeClass = Class.forName("javax.swing.JFrame");
        Constructor<?> ctor = jframeClass.getConstructor(String.class);
        JFrame frame = (JFrame) ctor.newInstance(xmlStrings[0]);
        Method setLocationMethod = jframeClass.getMethod("setLocation", int.class, int.class);
        setLocationMethod.invoke(frame, Integer.valueOf(xmlStrings[1]), Integer.valueOf(xmlStrings[2]));
        Method setSizeMethod = jframeClass.getMethod("setSize", int.class, int.class);
        setSizeMethod.invoke(frame, Integer.valueOf(xmlStrings[3]), Integer.valueOf(xmlStrings[4]));
        Method getContentPaneMethod = jframeClass.getMethod("getContentPane", null);
        Container contentPane = (Container) getContentPaneMethod.invoke(frame, null);
        Method setVisiblMethod = Container.class.getMethod("setVisible", boolean.class);
        setVisiblMethod.invoke(contentPane, false);
        Method setBackgroundMethod = jframeClass.getMethod("setBackground", java.awt.Color.class);
        setBackgroundMethod.invoke(frame, (Color) Color.class.getField(xmlStrings[5].toUpperCase()).get(null));
        Method setDefaultCloseMethod = jframeClass.getMethod("setDefaultCloseOperation", int.class);
        setDefaultCloseMethod.invoke(frame, JFrame.EXIT_ON_CLOSE);
        Method setVisibleMethod = jframeClass.getMethod("setVisible", boolean.class);
        setVisibleMethod.invoke(frame, true);
    }

    static String[] xmlParser() {
        String[] result = new String[6];
        try {
            // 加载 XML 文件
            File xmlFile = new File("window.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // 规范化文档
            doc.getDocumentElement().normalize();

            // 获取 <window> 元素
            NodeList windowList = doc.getElementsByTagName("window");
            if (windowList.getLength() > 0) {
                Element windowElement = (Element) windowList.item(0);

                // 获取窗口标题（属性 title）
                String title = windowElement.getAttribute("title");
                System.out.println("Window title: " + title);
                result[0] = title;

                // 获取 <location> 元素及其属性
                NodeList locationList = windowElement.getElementsByTagName("location");
                if (locationList.getLength() > 0) {
                    Element locationElement = (Element) locationList.item(0);
                    String x = locationElement.getAttribute("x");
                    String y = locationElement.getAttribute("y");
                    System.out.println("Location: x=" + x + ", y=" + y);
                    result[1] = x;
                    result[2] = y;
                }

                // 获取 <size> 元素及其属性
                NodeList sizeList = windowElement.getElementsByTagName("size");
                if (sizeList.getLength() > 0) {
                    Element sizeElement = (Element) sizeList.item(0);
                    String width = sizeElement.getAttribute("width");
                    String height = sizeElement.getAttribute("height");
                    System.out.println("Size: width=" + width + ", height=" + height);
                    result[3] = width;
                    result[4] = height;
                }

                // 获取 <background-color> 元素的文本内容
                NodeList bgList = windowElement.getElementsByTagName("background-color");
                if (bgList.getLength() > 0) {
                    Element bgElement = (Element) bgList.item(0);
                    String bgColor = bgElement.getTextContent().trim();
                    System.out.println("Background Color: " + bgColor);
                    result[5] = bgColor;
                }
            } else {
                System.out.println("没有找到 <window> 元素。");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
