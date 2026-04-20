package com.billGenerator;

import javax.swing.*;
import java.awt.*;

public class PizzaUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Pizza Bill Generator");
        frame.setSize(450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridLayout(0, 1));

        JPanel categoryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel categoryLabel = new JLabel("Select Category: ");
        JRadioButton basePizza = new JRadioButton("Base Pizza");
        JRadioButton deluxPizza = new JRadioButton("Delux Pizza");

        ButtonGroup categoryGroup = new ButtonGroup();
        categoryGroup.add(basePizza);
        categoryGroup.add(deluxPizza);

        categoryPanel.add(categoryLabel);
        categoryPanel.add(basePizza);
        categoryPanel.add(deluxPizza);

        JPanel typePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel typeLabel = new JLabel("Select Type: ");
        JRadioButton veg = new JRadioButton("Veg");
        JRadioButton nonVeg = new JRadioButton("Non-Veg");

        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(veg);
        typeGroup.add(nonVeg);

        typePanel.add(typeLabel);
        typePanel.add(veg);
        typePanel.add(nonVeg);

        JPanel extrasPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel extrasLabel = new JLabel("Extras: ");
        JCheckBox cheese = new JCheckBox("Cheese");
        JCheckBox toppings = new JCheckBox("Toppings");
        JCheckBox takeaway = new JCheckBox("Takeaway");

        extrasPanel.add(extrasLabel);
        extrasPanel.add(cheese);
        extrasPanel.add(toppings);
        extrasPanel.add(takeaway);

        // 🔹 Button + Bill Area
        JButton generateBill = new JButton("Generate Bill");
        JTextArea billArea = new JTextArea();
        billArea.setEditable(false);

        frame.add(categoryPanel);
        frame.add(typePanel);
        frame.add(extrasPanel);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        generateBill.setPreferredSize(new Dimension(150, 30)); 
        buttonPanel.add(generateBill);
        
        frame.add(buttonPanel);

        JPanel billPanel = new JPanel(new BorderLayout());
        billArea.setPreferredSize(new Dimension(350, 150)); 
        JScrollPane scrollPane = new JScrollPane(billArea);
        billPanel.add(scrollPane, BorderLayout.CENTER);

        frame.add(billPanel);

        // Button Logic
        generateBill.addActionListener(e -> {

            boolean isVeg = veg.isSelected();
            Pizza pizza;

            if (deluxPizza.isSelected()) {
                pizza = new DeluxPizza(isVeg);
            } else {
                pizza = new Pizza(isVeg);

                if (cheese.isSelected()) {
                    pizza.addExtraCheese();
                }
                if (toppings.isSelected()) {
                    pizza.addExtraToppings();
                }
            }

            if (takeaway.isSelected()) {
                pizza.takeAway();
            }

            billArea.setText(pizza.getBill());
        });

        frame.setVisible(true);
    }
}