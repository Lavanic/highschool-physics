import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RingofFire extends JFrame
 {
    final private Font mainFont = new Font("Mona Lisa Solid ITC TT", Font.BOLD, 18);
    JTextField tfTheta;
    JTextField tfVelocity;
    JLabel lbWelcome;

    public void initialize()
    {
        //Form Panel
        JLabel lbAngle = new JLabel("Enter the initial angle (degrees)");
        lbAngle.setFont(mainFont);

        JLabel lbVelocity = new JLabel("Enter the initial velocity (m/s)");
        lbVelocity.setFont(mainFont);

        JLabel lbGivens = new JLabel("initial height: 0.146");
        lbGivens.setFont(mainFont);

        tfVelocity = new JTextField();
        tfVelocity.setFont(mainFont);

        tfTheta = new JTextField();
        tfTheta.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 1, 5, 5));
        formPanel.setOpaque(false);
        formPanel.add(lbAngle);
        formPanel.add(tfTheta);
        formPanel.add(lbVelocity);
        formPanel.add(tfVelocity);
        
        //Welcome Label
        lbWelcome = new JLabel();
        lbWelcome.setFont(mainFont);

        //Buttons Panel
        JButton btnOK = new JButton("Calculate");
        btnOK.setFont(mainFont);
        btnOK.setBackground(Color.white);
        btnOK.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                String StringtfTheta = tfTheta.getText();
                double theta = Double.parseDouble(StringtfTheta);
                String StringtfVelocity = tfVelocity.getText();
                double velocity = Double.parseDouble(StringtfVelocity);
                double height = 0.146;

                double yCord = (Math.pow(velocity, 2) * Math.pow(Math.sin(Math.toRadians(theta)), 2));
                yCord /= (9.81 *2);
                yCord += height; 
                yCord = Math.floor(yCord * 1000) / 1000;

                double xCord = (Math.pow(velocity, 2) * Math.sin(Math.toRadians(2 * theta)));
                xCord /= 9.81;
                xCord /= 2;
                xCord = Math.floor(xCord * 1000) / 1000;

                lbWelcome.setText("Ring Cords = (" + xCord + ", " + yCord + ")");    
            }
            
        });

        JButton btnClear = new JButton("Clear");
        btnClear.setFont(mainFont);
        btnClear.setBackground(Color.white);

        btnClear.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                tfTheta.setText("");
                tfVelocity.setText("");
                lbWelcome.setText("");
            }
            
        });
        /*
        JButton btnHit = new JButton("Bullseye?");
        btnHit.setBackground(Color.green);
        btnHit.setFont(mainFont);
        btnHit.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                lbHappy.setVisible(true);

            }
            
        });
        JButton btnMiss = new JButton("Miss?");
        btnMiss.setBackground(Color.red);
        btnMiss.setFont(mainFont);
        btnMiss.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                lbMad.setVisible(true);
            }
            
        });
        */
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(2, 2, 5, 5));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(btnOK);
        buttonsPanel.add(btnClear);
        //buttonsPanel.add(btnHit);
        //buttonsPanel.add(btnMiss);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(250, 128, 114));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //mainPanel.add(lbHappy, BorderLayout.CENTER);
        //mainPanel.add(lbMad, BorderLayout.CENTER);
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
        mainPanel.add(lbWelcome, BorderLayout.CENTER);
        add(mainPanel);

        setTitle("Ring of Fire");
        setSize(500,500);
        setMinimumSize(new Dimension(300,400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        RingofFire myFrame = new RingofFire();
        myFrame.initialize();
    }
}
