package assignment1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageLabelTest extends JFrame implements ActionListener {
    private JLabel label;
    private ImageIcon image1; // Pineapple
    private ImageIcon image2; // Apple
    private ImageIcon image3; // Banana

    public ImageLabelTest() {
        setTitle("이미지 바꾸기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);

        image1 = new ImageIcon("images/pineapple.jpg");
        image2 = new ImageIcon("images/apple.jpg");
        image3 = new ImageIcon("images/banana.jpg");

        label = new JLabel(image2); // 사과가 기본 값

        JButton leftButton = new JButton("Left");
        JButton centerButton = new JButton("Center");
        JButton rightButton = new JButton("Right");

        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setIcon(image1);
            }
        });

        centerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setIcon(image2);
            }
        });

        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setIcon(image3);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(leftButton);
        buttonPanel.add(centerButton);
        buttonPanel.add(rightButton);

        setLayout(new BorderLayout());
        add(label, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // 추상 메소드 구현으로 경고 제거
    }

    public static void main(String[] args) {
        ImageLabelTest t = new ImageLabelTest();
    }
}