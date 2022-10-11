import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame extends JFrame
{
   final private Font mainFont = new Font("Mona Lisa Solid ITC TT", Font.BOLD, 18);
   JTextField tfXRange;
   JLabel lbWelcome;

   public void initialize()
   {
      //Form Panel
      /*ImageIcon imageHappy = new ImageIcon("C:\\Users\\olive\\OneDrive\\Documents\\brookshirehappy.jpg");
      JLabel lbHappy = new JLabel(imageHappy); 
jdk      lbHappy.setBounds(10, 10, 400, 400);
      lbHappy.setVisible(false);
   
      //ImageIcon imageMad = new ImageIcon("C:\\Users\\olive\\OneDrive\\Documents\\brookshiremad.jpg");
      JLabel lbMad = new JLabel(imageMad); 
      lbMad.setBounds(10, 10, 400, 400);
      lbMad.setVisible(false);
      */
      JLabel lbXDistance = new JLabel("X Distance (cm)");
      lbXDistance.setFont(mainFont);
   
      double height = 101.1 - 14.5;
      JLabel lbGivens = new JLabel("Angle: 70, Height: " + height);
      lbGivens.setFont(mainFont);
   
      tfXRange = new JTextField();
      tfXRange.setFont(mainFont);
   
      JPanel formPanel = new JPanel();
      formPanel.setLayout(new GridLayout(4, 1, 5, 5));
      formPanel.setOpaque(false);
      formPanel.add(lbXDistance);
      formPanel.add(tfXRange);
      formPanel.add(lbGivens);
      
      //Welcome Label
      lbWelcome = new JLabel();
      lbWelcome.setFont(mainFont);
   
      //Buttons Panel
      JButton btnOK = new JButton("Calculate");
      btnOK.setFont(mainFont);
      btnOK.addActionListener(
         e -> {
            String StringXRange = tfXRange.getText();
            double xRange = Double. parseDouble(StringXRange);
            double angle = 70;
            double initialVelocity = ((Math.pow(xRange, 2))*4.9);
         //System.out.println(initialVelocity);
            initialVelocity /= Math.pow(Math.cos(Math.toRadians(angle)),2);
         //System.out.println(initialVelocity);
            initialVelocity /= (xRange * Math.tan(Math.toRadians(angle))+ height);
         //System.out.println(initialVelocity);
            initialVelocity = Math.sqrt(initialVelocity);
            initialVelocity /= 10;
            initialVelocity = Math.floor(initialVelocity * 100) / 100;
            lbWelcome.setText("The initial velocity needs to be " + initialVelocity + "m/second");    
         });
   
      JButton btnClear = new JButton("Clear");
      btnClear.setFont(mainFont);
      btnClear.addActionListener(
         new ActionListener(){
         
            @Override
            public void actionPerformed(ActionEvent e) {
               tfXRange.setText("");
               lbWelcome.setText("");
               //lbHappy.setVisible(false);
               //lbMad.setVisible(false);
            }
         
         });
      JButton btnHit = new JButton("Bullseye?");
      btnHit.setBackground(Color.green);
      btnHit.setFont(mainFont);
      btnHit.addActionListener(
         new ActionListener(){
         
            @Override
            public void actionPerformed(ActionEvent e) {
               //lbHappy.setVisible(true);
            }
         
         });
      JButton btnMiss = new JButton("Miss?");
      btnMiss.setBackground(Color.red);
      btnMiss.setFont(mainFont);
      btnMiss.addActionListener(
         new ActionListener(){
         
            @Override
            public void actionPerformed(ActionEvent e) {
              // lbMad.setVisible(true);
            }
         
         });
   
      JPanel buttonsPanel = new JPanel();
      buttonsPanel.setLayout(new GridLayout(2, 2, 5, 5));
      buttonsPanel.setOpaque(false);
      buttonsPanel.add(btnOK);
      buttonsPanel.add(btnClear);
      buttonsPanel.add(btnHit);
      buttonsPanel.add(btnMiss);
   
      JPanel mainPanel = new JPanel();
      mainPanel.setLayout(new BorderLayout());
      mainPanel.setBackground(new Color(254, 236, 200));
      mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      //mainPanel.add(lbHappy, BorderLayout.CENTER);
      //mainPanel.add(lbMad, BorderLayout.CENTER);
      mainPanel.add(formPanel, BorderLayout.NORTH);
      mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
      mainPanel.add(lbWelcome, BorderLayout.CENTER);
   
   
      add(mainPanel);
   
      setTitle("Projectile Prediction Oliver Ohrt");
      setSize(500,500);
      setMinimumSize(new Dimension(300,400));
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      setVisible(true);
   }

   public static void main(String[] args) {
      MainFrame myFrame = new MainFrame();
      myFrame.initialize();
   }
}
