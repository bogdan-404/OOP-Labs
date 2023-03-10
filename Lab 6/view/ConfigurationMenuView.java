package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class ConfigurationMenuView {
    private static final int FRAME_WIDTH = 500, FRAME_HEIGHT = 550;

    private int pharmacies = 1, products = 1, minutes = 10, robberProbability = 1;
    private boolean running = true;
    private JButton button1 = new JButton("Add 10 Minutes");
    private JButton button2 = new JButton("Add Pharmacy");
    private JButton button3 = new JButton("Add Product");
    private JButton button4 = new JButton("Add 1 Percent");
    private JButton button5 = new JButton("Save Configuration");

    private JLabel label1 = new JLabel("Runtime: 10 minutes");
    private JLabel label2 = new JLabel("No of pharmacies: 1");
    private JLabel label3 = new JLabel("No of products: 1");
    private JLabel label4 = new JLabel("Robber Probability: 1%");

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();

    public ConfigurationMenuView() {

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        panel.setLayout(null);
        frame.add(panel);
        frame.setTitle("Configuration Menu");

        panel.add(label1);
        label1.setBounds(50, 0, 600, 50);
        panel.add(label2);
        label2.setBounds(50, 100, 600, 50);
        panel.add(label3);
        label3.setBounds(50, 200, 600, 50);
        panel.add(label4);
        label4.setBounds(50, 300, 600, 50);

        panel.add(button1);
        button1.setBounds(230, 10, 200, 30);
        panel.add(button2);
        button2.setBounds(230, 110, 200, 30);
        panel.add(button3);
        button3.setBounds(230, 210, 200, 30);
        panel.add(button4);
        button4.setBounds(230, 310, 200, 30);
        panel.add(button5);
        button5.setBounds(120, 410, 200, 30);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                minutes += 10;
                label1.setText("Runtime: " + minutes + " minutes");
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pharmacies++;
                label2.setText("No of pharmacies: " + pharmacies);
            }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                products++;
                label3.setText("No of products: " + products);
            }
        });
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (robberProbability < 100) {
                    robberProbability++;

                }
                label4.setText("Robber Probability: " + robberProbability + "%");
            }
        });
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                running = false;
                frame.setVisible(false);
            }
        });

    }

    public boolean getRunning() {
        return this.running;
    }

    public int getPharmacies() {
        return this.pharmacies;
    }

    public int getRuntime() {
        return this.minutes;
    }

    public int getProducts() {
        return this.products;
    }

    public int getProbability() {
        return this.robberProbability;
    }
}
