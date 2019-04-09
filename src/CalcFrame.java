import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CalcFrame extends JFrame {
    private JPanel jPanel;
    private JTextField resultField;
    private JTextArea displayArea;
    private JButton numberZero;
    private JButton numberOne;
    private JButton numberTwo;
    private JButton numberThree;
    private JButton numberFour;
    private JButton numberFive;
    private JButton numberSix;
    private JButton numberSeven;
    private JButton numberEight;
    private JButton numberNine;
    private JButton point;
    private JButton leftBracket;
    private JButton rightBracket;
    private JButton equals;
    private JButton modulos;
    private JButton CE;
    private JButton division;
    private JButton multiplication;
    private JButton subtraction;
    private JButton addition;

    private final int FRAME_WIDTH = 325;
    private final int FRAME_HEIGHT = 325;

    private final int X_POINT = 500;
    private final int Y_POINT = 150;

    private final int AREA_ROWS = 1;
    private final int AREA_COLS = 12;

    private final int FIELD_WIDTH = AREA_COLS / 2;

    private final int BUTTON_WIDTH = 50;
    private final int BUTTON_HEIGHT = 30;

    private final Insets insets = new Insets(4, 4, 4, 4);
    private final Border numericalBorder_defaultState = BorderFactory.createEtchedBorder(Color.GRAY, Color.DARK_GRAY); // GRAY, GRAY
    private final Border numericalBorder_hoverState = BorderFactory.createEtchedBorder(Color.GRAY, Color.GRAY);        // GRAY, DARK_GRAY
    private final Border operandBorder_defaultState = BorderFactory.createEtchedBorder(Color.GRAY, Color.DARK_GRAY);   // GRAY, GRAY
    private final Border operandBorder_hoverState = BorderFactory.createEtchedBorder(Color.GRAY, Color.GRAY);          // GRAY, DARK_GRAY
    private final Color backgroundColor = Color.LIGHT_GRAY; // 225, 232, 176
    private final Color numericalBackgroundColor = new Color(255, 236, 255);
    private final Font font = new Font("Arial", Font.PLAIN, 12);

    public CalcFrame() {
        initFrame();
    }

    private void initFrame() {
        jPanel = new JPanel(new GridBagLayout());

        // Result Field TextField
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        jPanel.add(resultField = new JTextField(FIELD_WIDTH), gbc);
        resultField.setEditable(false);
        resultField.setBorder(null);
        resultField.setFont(font);
        resultField.setHorizontalAlignment(JTextField.LEFT);

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
        leftBracket = new JButton("(");
        leftBracket.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        leftBracket.setBackground(backgroundColor);
        leftBracket.setFont(font);
        leftBracket.setFocusable(false);
        leftBracket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.append(leftBracket.getText());
            }
        });
        leftBracket.setBorder(operandBorder_defaultState);
        leftBracket.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (leftBracket.getModel().isRollover() || leftBracket.getModel().isPressed()) {
                    leftBracket.setBorder(operandBorder_hoverState);
                } else {
                    leftBracket.setBorder(operandBorder_defaultState);
                }
            }
        });
        jPanel.add(leftBracket, gbc);

        // Right Bracket Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 2;
        gbc.gridx = 1;
        rightBracket = new JButton(")");
        rightBracket.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        rightBracket.setBackground(backgroundColor);
        rightBracket.setFont(font);
        rightBracket.setFocusable(false);
        rightBracket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.append(rightBracket.getText());
            }
        });
        rightBracket.setBorder(operandBorder_defaultState);
        rightBracket.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (rightBracket.getModel().isRollover() || rightBracket.getModel().isPressed()) {
                    rightBracket.setBorder(operandBorder_hoverState);
                } else {
                    rightBracket.setBorder(operandBorder_defaultState);
                }
            }
        });
        jPanel.add(rightBracket, gbc);

        // Modulus Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 2;
        gbc.gridx = 2;
        modulos = new JButton("%");
        modulos.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        modulos.setBackground(backgroundColor);
        modulos.setFont(font);
        modulos.setFocusable(false);
        modulos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.append(modulos.getText());
            }
        });
        modulos.setBorder(operandBorder_defaultState);
        modulos.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (modulos.getModel().isRollover() || modulos.getModel().isPressed()) {
                    modulos.setBorder(operandBorder_hoverState);
                } else {
                    modulos.setBorder(operandBorder_defaultState);
                }
            }
        });
        jPanel.add(modulos, gbc);

        // CE Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 2;
        gbc.gridx = 3;
        CE = new JButton("CE");
        CE.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        CE.setBackground(backgroundColor);
        CE.setFont(font);
        CE.setFocusable(false);
        CE.addActionListener(new ActionListener() {
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
        CE.setBorder(operandBorder_defaultState);
        CE.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (CE.getModel().isPressed()) {
                    CE.setBorder(operandBorder_hoverState);
                    trigger.start();
                } else if (CE.getModel().isRollover()) {
                    CE.setBorder(operandBorder_hoverState);
                    trigger.stop();
                } else {
                    CE.setBorder(operandBorder_defaultState);
                    trigger.stop();
                }
            }
        });
        jPanel.add(CE, gbc);

        // Number Seven Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 3;
        gbc.gridx = 0;
        numberSeven = new JButton("7");
        numberSeven.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        numberSeven.setBackground(numericalBackgroundColor);
        numberSeven.setFont(font);
        numberSeven.setFocusable(false);
        numberSeven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.append(numberSeven.getText());
            }
        });
        numberSeven.setBorder(numericalBorder_defaultState);
        numberSeven.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (numberSeven.getModel().isRollover() || numberSeven.getModel().isPressed()) {
                    numberSeven.setBorder(numericalBorder_hoverState);
                } else {
                    numberSeven.setBorder(numericalBorder_defaultState);
                }
            }
        });

        jPanel.add(numberSeven, gbc);

        // Number Eight Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 3;
        gbc.gridx = 1;
        numberEight = new JButton("8");
        numberEight.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        numberEight.setBackground(numericalBackgroundColor);
        numberEight.setFont(font);
        numberEight.setFocusable(false);
        numberEight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.append(numberEight.getText());
            }
        });
        numberEight.setBorder(numericalBorder_defaultState);
        numberEight.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (numberEight.getModel().isRollover() || numberEight.getModel().isPressed()) {
                    numberEight.setBorder(numericalBorder_hoverState);
                } else {
                    numberEight.setBorder(numericalBorder_defaultState);
                }
            }
        });
        jPanel.add(numberEight, gbc);

        // Number Nine Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 3;
        gbc.gridx = 2;
        numberNine = new JButton("9");
        numberNine.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        numberNine.setBackground(numericalBackgroundColor);
        numberNine.setFont(font);
        numberNine.setFocusable(false);
        numberNine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.append(numberNine.getText());
            }
        });
        numberNine.setBorder(numericalBorder_defaultState);
        numberNine.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (numberNine.getModel().isRollover() || numberNine.getModel().isPressed()) {
                    numberNine.setBorder(numericalBorder_hoverState);
                } else {
                    numberNine.setBorder(numericalBorder_defaultState);
                }
            }
        });
        jPanel.add(numberNine, gbc);

        // Division Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 3;
        gbc.gridx = 3;
        division = new JButton("/");
        division.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        division.setBackground(backgroundColor);
        division.setFont(font);
        division.setFocusable(false);
        division.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.append(division.getText());
            }
        });
        division.setBorder(operandBorder_defaultState);
        division.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (division.getModel().isRollover() || division.getModel().isPressed()) {
                    division.setBorder(operandBorder_hoverState);
                } else {
                    division.setBorder(operandBorder_defaultState);
                }
            }
        });
        jPanel.add(division, gbc);

        // Number Four Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 4;
        gbc.gridx = 0;
        numberFour = new JButton("4");
        numberFour.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        numberFour.setBackground(numericalBackgroundColor);
        numberFour.setFont(font);
        numberFour.setFocusable(false);
        numberFour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.append(numberFour.getText());
            }
        });
        numberFour.setBorder(numericalBorder_defaultState);
        numberFour.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (numberFour.getModel().isRollover() || numberFour.getModel().isPressed()) {
                    numberFour.setBorder(numericalBorder_hoverState);
                } else {
                    numberFour.setBorder(numericalBorder_defaultState);
                }
            }
        });
        jPanel.add(numberFour, gbc);

        // Number Five Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 4;
        gbc.gridx = 1;
        numberFive = new JButton("5");
        numberFive.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        numberFive.setBackground(numericalBackgroundColor);
        numberFive.setFont(font);
        numberFive.setFocusable(false);
        numberFive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.append(numberFive.getText());
            }
        });
        numberFive.setBorder(numericalBorder_defaultState);
        numberFive.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (numberFive.getModel().isRollover() || numberFive.getModel().isPressed()) {
                    numberFive.setBorder(numericalBorder_hoverState);
                } else {
                    numberFive.setBorder(numericalBorder_defaultState);
                }
            }
        });
        jPanel.add(numberFive, gbc);

        // Number Six Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 4;
        gbc.gridx = 2;
        numberSix = new JButton("6");
        numberSix.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        numberSix.setBackground(numericalBackgroundColor);
        numberSix.setFont(font);
        numberSix.setFocusable(false);
        numberSix.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.append(numberSix.getText());
            }
        });
        numberSix.setBorder(numericalBorder_defaultState);
        numberSix.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (numberSix.getModel().isRollover() || numberSix.getModel().isPressed()) {
                    numberSix.setBorder(numericalBorder_hoverState);
                } else {
                    numberSix.setBorder(numericalBorder_defaultState);
                }
            }
        });
        jPanel.add(numberSix, gbc);

        // Multiplication Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 4;
        gbc.gridx = 3;
        multiplication = new JButton("x");
        multiplication.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        multiplication.setBackground(backgroundColor);
        multiplication.setFont(font);
        multiplication.setFocusable(false);
        multiplication.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.append("*");
            }
        });
        multiplication.setBorder(operandBorder_defaultState);
        multiplication.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (multiplication.getModel().isRollover() || multiplication.getModel().isPressed()) {
                    multiplication.setBorder(operandBorder_hoverState);
                } else {
                    multiplication.setBorder(operandBorder_defaultState);
                }
            }
        });
        jPanel.add(multiplication, gbc);

        // Number One Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 5;
        gbc.gridx = 0;
        numberOne = new JButton("1");
        numberOne.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        numberOne.setBackground(numericalBackgroundColor);
        numberOne.setFont(font);
        numberOne.setFocusable(false);
        numberOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.append(numberOne.getText());
            }
        });
        numberOne.setBorder(numericalBorder_defaultState);
        numberOne.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (numberOne.getModel().isRollover() || numberOne.getModel().isPressed()) {
                    numberOne.setBorder(numericalBorder_hoverState);
                } else {
                    numberOne.setBorder(numericalBorder_defaultState);
                }
            }
        });
        jPanel.add(numberOne, gbc);

        // Number Two Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 5;
        gbc.gridx = 1;
        numberTwo = new JButton("2");
        numberTwo.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        numberTwo.setBackground(numericalBackgroundColor);
        numberTwo.setFont(font);
        numberTwo.setFocusable(false);
        numberTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.append(numberTwo.getText());
            }
        });
        numberTwo.setBorder(numericalBorder_defaultState);
        numberTwo.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (numberTwo.getModel().isRollover() || numberTwo.getModel().isPressed()) {
                    numberTwo.setBorder(numericalBorder_hoverState);
                } else {
                    numberTwo.setBorder(numericalBorder_defaultState);
                }

            }
        });
        jPanel.add(numberTwo, gbc);

        // Number Three Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 5;
        gbc.gridx = 2;
        numberThree = new JButton("3");
        numberThree.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        numberThree.setBackground(numericalBackgroundColor);
        numberThree.setFont(font);
        numberThree.setFocusable(false);
        numberThree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.append(numberThree.getText());
            }
        });
        numberThree.setBorder(numericalBorder_defaultState);
        numberThree.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (numberThree.getModel().isRollover() || numberThree.getModel().isPressed()) {
                    numberThree.setBorder(numericalBorder_hoverState);
                } else {
                    numberThree.setBorder(numericalBorder_defaultState);
                }
            }
        });
        jPanel.add(numberThree, gbc);

        // Subtraction Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 5;
        gbc.gridx = 3;
        subtraction = new JButton("-");
        subtraction.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        subtraction.setBackground(backgroundColor);
        subtraction.setFont(font);
        subtraction.setFocusable(false);
        subtraction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.append(subtraction.getText());
            }
        });
        subtraction.setBorder(operandBorder_defaultState);
        subtraction.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (subtraction.getModel().isRollover() || subtraction.getModel().isPressed()) {
                    subtraction.setBorder(operandBorder_hoverState);
                } else {
                    subtraction.setBorder(operandBorder_defaultState);
                }
            }
        });
        jPanel.add(subtraction, gbc);


        // Number 0 Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 6;
        gbc.gridx = 0;
        numberZero = new JButton("0");
        numberZero.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        numberZero.setBackground(numericalBackgroundColor);
        numberZero.setFont(font);
        numberZero.setFocusable(false);
        numberZero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.append(numberZero.getText());
            }
        });
        numberZero.setBorder(numericalBorder_defaultState);
        numberZero.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (numberZero.getModel().isRollover() || numberZero.getModel().isPressed()) {
                    numberZero.setBorder(numericalBorder_hoverState);
                } else {
                    numberZero.setBorder(numericalBorder_defaultState);
                }
            }
        });
        jPanel.add(numberZero, gbc);

        // Point Button
        gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridy = 6;
        gbc.gridx = 1;
        point = new JButton(".");
        point.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        point.setBackground(numericalBackgroundColor);
        point.setFont(new Font(font.getName(), Font.BOLD, font.getSize()));
        point.setFocusable(false);
        point.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.append(point.getText());
            }
        });
        point.setBorder(numericalBorder_defaultState);
        point.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (point.getModel().isRollover() || point.getModel().isPressed()) {
                    point.setBorder(numericalBorder_hoverState);
                } else {
                    point.setBorder(numericalBorder_defaultState);
                }
            }
        });
        jPanel.add(point, gbc);

        // Equals Button
        class EqualsAction extends AbstractAction {
            public void actionPerformed(ActionEvent actionEvent) {
                final boolean acceptableFormat = validateExpression(displayArea.getText());

                if (acceptableFormat) {
                    Calculation calc = new Calculation(displayArea.getText());
                    resultField.setText(displayArea.getText() + " " + equals.getText() + " ");
                    displayArea.setText(String.valueOf(calc.getResult()));
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
        addition = new JButton("+");
        addition.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        addition.setBackground(backgroundColor);
        addition.setFont(font);
        addition.setFocusable(false);
        addition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.append(addition.getText());
            }
        });
        addition.setBorder(operandBorder_defaultState);
        addition.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (addition.getModel().isRollover() || addition.getModel().isPressed()) {
                    addition.setBorder(operandBorder_hoverState);
                } else {
                    addition.setBorder(operandBorder_defaultState);
                }
            }
        });
        jPanel.add(addition, gbc);


        add(jPanel);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setMinimumSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setLocation(X_POINT, Y_POINT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("myCalculator V1.0");
        setVisible(true);

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

        // If the first element is an operand, return false
        if (text[0] == '+' || text[0] == '-' || text[0] == '*' || text[0] == '/' || text[0] == '%') {
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
