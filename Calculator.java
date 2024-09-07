import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener {
    // Components of the calculator
    TextField display;
    Button[] numberButtons;
    Button addButton, subButton, mulButton, divButton, equalButton, clearButton;
    Panel panel;
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    // Constructor to set up the calculator GUI
    public Calculator() {
        // Setting up the frame
        setTitle("Simple Calculator");
        setSize(300, 400);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Display field
        display = new TextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Number and operation buttons
        numberButtons = new Button[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new Button(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        addButton = new Button("+");
        subButton = new Button("-");
        mulButton = new Button("*");
        divButton = new Button("/");
        equalButton = new Button("=");
        clearButton = new Button("Clear");

        // Adding ActionListeners to operation buttons
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        equalButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Panel for arranging buttons in grid layout
        panel = new Panel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        // Adding buttons to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(clearButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divButton);

        // Adding the panel to the frame
        add(panel, BorderLayout.CENTER);

        // Adding window listener to close the window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    // Handling button actions
    public void actionPerformed(ActionEvent e) {
        // Handling number button clicks
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                display.setText(display.getText() + i);
            }
        }

        // Handling operation button clicks
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");
        } else if (e.getSource() == subButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
        } else if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
        } else if (e.getSource() == divButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
        } else if (e.getSource() == equalButton) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num2 != 0 ? num1 / num2 : 0; // Avoid division by zero
                    break;
            }
            display.setText(String.valueOf(result));
            num1 = result; // To allow chaining calculations
        } else if (e.getSource() == clearButton) {
            display.setText("");
        }
    }

    // Main method to run the calculator
    public static void main(String[] args) {
        new Calculator();
    }
}
