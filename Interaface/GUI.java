package Interaface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import Interaface.MenuBar.MenuBar;

public class GUI {

    public static JButton buttonDefault = new JButton("Default");
    public static String imagePath;
    public static ImageIO imageInput;
    public static ImageIO imageOutput;

    public GUI() {
        JFrame mainFrame = new JFrame();

        JPanel subFrame = new JPanel();
        subFrame.setBorder(BorderFactory.createEmptyBorder(20,15,20,15));
        subFrame.setLayout(new GridLayout(1, 2, 30, 0));

        JPanel panelOne = new JPanel(new BorderLayout());
        JLabel labelOne = new JLabel("Input", SwingConstants.CENTER);
        labelOne.setFont(new Font("Arial", Font.PLAIN, 32));
        JButton button1 = new JButton("Teste");
        panelOne.add(labelOne, BorderLayout.NORTH);
        panelOne.add(buttonDefault, BorderLayout.CENTER);

        JPanel panelTwo = new JPanel(new BorderLayout());
        JLabel labelTwo = new JLabel("Output", SwingConstants.CENTER);
        labelTwo.setFont(new Font("Arial", Font.PLAIN, 32));
        panelTwo.add(labelTwo, BorderLayout.NORTH);
        JButton button2 = new JButton("Teste2");
        panelTwo.add(button2, BorderLayout.CENTER);
        subFrame.add(panelOne);
        subFrame.add(panelTwo);


        MenuBar menuBar = new MenuBar();
        mainFrame.add(menuBar, BorderLayout.PAGE_START);
        mainFrame.add(subFrame);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1000, 700);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setTitle("Projeto de Processamento Digital de Imagem");
        mainFrame.setVisible(true);
    }



}
