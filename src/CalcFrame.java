import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CalcFrame extends JFrame {

    // Components that have unique functionality
    private JTextField resultField;
    private JTextArea displayArea;
    private JButton equals;

    // ButtonGroups - (very useful)
    private JButton[] numberedButtons = new JButton[11];
    private JButton[] operandButtons  = new JButton[8];

    // Defines the dimensions of the frame
    private final int FRAME_WIDTH = 325;
    private final int FRAME_HEIGHT = 325;

    // Defines where on the screen the frame first becomes visible
    private final int X_POINT = 500;
    private final int Y_POINT = 150;

    // Defines the dimensions of the rows and cols of the displayArea (JTextArea)
    private final int AREA_ROWS = 1;
    private final int AREA_COLS = 12;

    // Defines the width of the resultField (JTextField)
    private final int FIELD_WIDTH = AREA_COLS / 2;

    // Defines the dimensions of all the JButtons
    private final int BUTTON_WIDTH = 50;
    private final int BUTTON_HEIGHT = 30;

    // Defines certain visual aspects of the components on screen
    private final Insets insets = new Insets(3, 3, 3, 3);
    private final Border numericalBorder_defaultState = BorderFactory.createEtchedBorder(Color.GRAY, Color.DARK_GRAY); // GRAY, GRAY
    private final Border numericalBorder_hoverState = BorderFactory.createEtchedBorder(Color.GRAY, Color.LIGHT_GRAY);        // GRAY, DARK_GRAY
    private final Border operandBorder_defaultState = BorderFactory.createEtchedBorder(Color.GRAY, Color.DARK_GRAY);   // GRAY, GRAY
    private final Border operandBorder_hoverState = BorderFactory.createEtchedBorder(Color.GRAY, Color.LIGHT_GRAY);          // GRAY, DARK_GRAY
    private final Color backgroundColor = new Color(147, 147, 125); // LIGHT_GRAY < (147, 147, 147)
    private final Color numericalBackgroundColor = new Color(236, 236, 236); // 255, 236, 255
    private final Color foregroundColor = Color.WHITE;
    private final Font font = new Font("Arial", Font.PLAIN, 12);


    public CalcFrame() {
        initFrame();
        initButtonGroupNumbered();
        initButtonGroupOperand();
        setVisible(true);
    }


    private void initFrame() {
        JPanel jPanel = new JPanel(new GridBagLayout());

        // Result Field TextField
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        resultField = new JTextField(FIELD_WIDTH);
        resultField.setEditable(false);
        resultField.setBorder(null);
        resultField.setFont(new Font("Arial", Font.PLAIN, 13));
        resultField.setHorizontalAlignment(JTextField.LEFT);
        jPanel.add(resultField, gbc);

        // Display Area TextArea
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        displayArea = new JTextArea(AREA_ROWS, AREA_COLS);
        displayArea.setLineWrap(true);
        displayArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Arial", Font.PLAIN, 16));
        displayArea.setBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.DARK_GRAY)); // GRAY, LIGHT_GRAY
        jPanel.add(displayArea, gbc);

        // Left Bracket Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 2;
        gbc.gridx = 0;
        jPanel.add(operandButtons[0] = new JButton("("), gbc);

        // Right Bracket Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 2;
        gbc.gridx = 1;
        jPanel.add(operandButtons[1] = new JButton(")"), gbc);

        // Modulus Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 2;
        gbc.gridx = 2;
        jPanel.add(operandButtons[2] = new JButton("%"), gbc);

        // CE Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 2;
        gbc.gridx = 3;
        jPanel.add(operandButtons[3] = new JButton("CE"), gbc);

        // Number Seven Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 3;
        gbc.gridx = 0;
        jPanel.add(numberedButtons[0] = new JButton("7"), gbc);

        // Number Eight Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 3;
        gbc.gridx = 1;
        jPanel.add(numberedButtons[1] = new JButton("8"), gbc);

        // Number Nine Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 3;
        gbc.gridx = 2;
        jPanel.add(numberedButtons[2] = new JButton("9"), gbc);

        // Division Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 3;
        gbc.gridx = 3;
        jPanel.add(operandButtons[4] = new JButton("/"), gbc);

        // Number Four Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 4;
        gbc.gridx = 0;
        jPanel.add(numberedButtons[3] = new JButton("4"), gbc);

        // Number Five Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 4;
        gbc.gridx = 1;
        jPanel.add(numberedButtons[4] = new JButton("5"), gbc);

        // Number Six Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 4;
        gbc.gridx = 2;
        jPanel.add(numberedButtons[5] = new JButton("6"), gbc);

        // Multiplication Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 4;
        gbc.gridx = 3;
        jPanel.add(operandButtons[5] = new JButton("x"), gbc);

        // Number One Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 5;
        gbc.gridx = 0;
        jPanel.add(numberedButtons[6] = new JButton("1"), gbc);

        // Number Two Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 5;
        gbc.gridx = 1;
        jPanel.add( numberedButtons[7] = new JButton("2"), gbc);

        // Number Three Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 5;
        gbc.gridx = 2;
        jPanel.add(numberedButtons[8] = new JButton("3"), gbc);

        // Subtraction Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 5;
        gbc.gridx = 3;
        jPanel.add(operandButtons[6] = new JButton("-"), gbc);

        // Number 0 Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 6;
        gbc.gridx = 0;
        jPanel.add(numberedButtons[9] = new JButton("0"), gbc);

        // Point Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 6;
        gbc.gridx = 1;
        jPanel.add(numberedButtons[10] = new JButton("."), gbc);

        // Equals Button
        class EqualsAction extends AbstractAction {
            public void actionPerformed(ActionEvent actionEvent) {
            //    final boolean acceptableFormat = validateExpression(displayArea.getText());

                    Calculation calc = new Calculation(displayArea.getText());
                    if (!calc.getResult().equals("null")) {
                        resultField.setText(displayArea.getText() + " " + equals.getText() + " ");
                        displayArea.setText(calc.getResult());
                    }

                    else {
                        JOptionPane.showMessageDialog(jPanel, "cannot eval expression", "error - format", JOptionPane.ERROR_MESSAGE);
                    }
            }
        }

        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 6;
        gbc.gridx = 2;
        equals = new JButton("=");
        equals.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        equals.setBackground(new Color(188, 174, 207));
        equals.setFont(font);
        equals.setFocusable(false);
        equals.addActionListener(new EqualsAction());
        equals.setBorder(operandBorder_defaultState);
        equals.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (equals.getModel().isRollover() || equals.getModel().isPressed()) {
                    equals.setBorder(operandBorder_hoverState); // WHITE, WHITE
                } else {
                    equals.setBorder(operandBorder_defaultState);
                }
            }
        });
        equals.getInputMap(JTextField.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "EqualsAction");
        equals.getActionMap().put("EqualsAction", new EqualsAction());
        jPanel.add(equals, gbc);

        // Addition Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 6;
        gbc.gridx = 3;
        jPanel.add(operandButtons[7] = new JButton("+"), gbc);

        add(jPanel);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setMinimumSize(new Dimension(FRAME_WIDTH - 25, FRAME_HEIGHT - 25));
        setLocation(X_POINT, Y_POINT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("myCalculator");

    }


    private void initButtonGroupNumbered() {
        for (JButton currentButton : numberedButtons) {
            currentButton.setBackground(numericalBackgroundColor);
            currentButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
            currentButton.setFont(font);
            currentButton.setFocusable(false);
            currentButton.setBorder(numericalBorder_defaultState);
            currentButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    displayArea.append(currentButton.getText());
                }
            });
            currentButton.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    if (currentButton.getModel().isRollover() || currentButton.getModel().isPressed()) {
                        currentButton.setBorder(numericalBorder_hoverState);
                    } else {
                        currentButton.setBorder(numericalBorder_defaultState);
                    }
                }
            });
        }
    }

    private void initButtonGroupOperand() {
        for (JButton currentButton : operandButtons) {
            currentButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
            currentButton.setBackground(backgroundColor);
            currentButton.setForeground(foregroundColor);
            currentButton.setFont(font);
            currentButton.setFocusable(false);
            currentButton.setBorder(operandBorder_defaultState);
            currentButton.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    if (currentButton.getModel().isRollover() || currentButton.getModel().isPressed()) {
                        currentButton.setBorder(operandBorder_hoverState);
                    } else {
                        currentButton.setBorder(operandBorder_defaultState);
                    }
                }
            });

            /*
              If the currentButton isn't CE or Multiplication then
              add the standard actionListener
             */
            if (!currentButton.getText().equals("CE") &&
                !currentButton.getText().equalsIgnoreCase("x")) {
                currentButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        displayArea.append(currentButton.getText());
                    }
                });
            }

            /*
              If the currentButton is Multiplication then
              add Multiplication case actionListener
             */
            else if (currentButton.getText().equalsIgnoreCase("x")) {
                currentButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        displayArea.append("*");
                    }
                });
            }

            /*
              If the currentButton is any other (CE) then
              add CE case action and changeListeners
             */
            else {
                currentButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (displayArea.getText().length() >= 1) {
                            displayArea.replaceRange("", displayArea.getText().length() - 1, displayArea.getText().length());
                        }
                    }
                });
                Timer trigger = new Timer(125, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        displayArea.setText("");
                    }
                });
                currentButton.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        if (currentButton.getModel().isPressed()) {
                            trigger.start();
                        }

                        else {
                            trigger.stop();
                        }
                    }
                });
            }
        }

    }

    private boolean validateExpression(String input) {
        char[] text = input.toCharArray();
        char[] illegalCharacters = {'+', '-', '*', '/', '%', '.'};
        int counter = 0;
        boolean output = true;

        int leftBracketCont = 0;
        int rightBracketCont = 0;

        if (input.length() == 0) {
            return false;
        }

        if (text[0] == ')' || text[text.length - 1] == '(') {
            return false;
        }

        // If the first element is an operand excluding subtraction, return false
        if (text[0] == '+' || text[0] == '*' || text[0] == '/' || text[0] == '%') {
            return false;
        }

        // If the last element is an operand, return false
        if (text[text.length - 1] == '.' || text[text.length - 1] == '+' || text[text.length - 1] == '-' ||
                text[text.length - 1] == '*' || text[text.length - 1] == '/' || text[text.length - 1] == '%') {
            return false;
        }

        // Loop over resultArea.getText()
        for (int i = 0; i < text.length; i++) {
            // Check for number of brackets
            if (text[i] == '(') {
                leftBracketCont++;
            }

            if (text[i] == ')') {
                rightBracketCont++;
            }

            // Make sure you're within bounds
            if (i < text.length - 1) {
                // If two operands or illegal characters are next to eachother, return false
                for (int j = 0; j < illegalCharacters.length; j++) {
                    if (text[i] == illegalCharacters[j]) {
                        counter++;
                    }

                    // If two operands or illegal characters are next to eachother, return false
                     if (text[i + 1] == illegalCharacters[j]) {
                        counter++;
                    }

                    // Finding () should set output value to false
                    if (text[i] == '(' && text[i + 1] == ')') {
                        return false;
                    }

                    // Two operands next to eachother
                    if (counter == 2) {
                        return false;
                    }
                }
                counter = 0;
            }
        }

        // If the number of leftBrackets aren't equal to the number of right brackets set output value to false
        if (leftBracketCont != rightBracketCont) {
            return false;
        }

        return output;
    }



}
