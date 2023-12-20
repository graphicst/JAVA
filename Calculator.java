package assignment1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private JPanel panel;
    private JTextField tField;
    private JButton[] buttons;
    private String[] labels = {
            "Backspace", "", "", "CE", "C", "Sin",
            "7", "8", "9", "/", "sqrt", "Log",
            "4", "5", "6", "x", "%", "Abs",
            "1", "2", "3", "-", "1/x", "",
            "0", "+/-", ".", "+", "=", ""
    };

    private double currentInput = 0;
    private double memoryValue = 0;
    private char operation = ' ';

    public Calculator() {

        tField = new JTextField(35);
        panel = new JPanel();
        tField.setText("0.");
        tField.setEnabled(false);

        panel.setLayout(new GridLayout(0, 6, 3, 3));
        buttons = new JButton[30];
        int index = 0;

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 6; col++) {
                buttons[index] = new JButton(labels[index]);
                buttons[index].addActionListener(new CalculatorButtonActionListener());
                if (col >= 3)
                    buttons[index].setForeground(Color.red);
                else
                    buttons[index].setForeground(Color.blue);
                buttons[index].setBackground(Color.yellow);
                panel.add(buttons[index]);
                index++;
            }
        }

        add(tField, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        setVisible(true);
        pack();
    }

    private class CalculatorButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String buttonText = source.getText();

            if (buttonText.isEmpty()) {
                // 버튼에 아무 내용이 없는 경우 무시
                return;
            }

            switch (buttonText) {
                case "C":
                    tField.setText("0.");
                    currentInput = 0;
                    memoryValue = 0;
                    operation = ' ';
                    break;
                case "CE":
                    handleCE();
                    break;
                case "=":
                    calculateResult();
                    operation = ' ';
                    break;
                case "+":
                case "-":
                case "x":
                case "/":
                case "%":
                    handleOperation(buttonText.charAt(0));
                    break;
                case "sqrt":
                    currentInput = Math.sqrt(currentInput);
                    displayResult();
                    break;
                case "Sin":
                    currentInput = Math.sin(currentInput);
                    displayResult();
                    break;
                case "Log":
                    currentInput = Math.log10(currentInput);
                    displayResult();
                    break;
                case "Abs":
                    currentInput = Math.abs(currentInput);
                    displayResult();
                    break;
                case "Backspace":
                    handleBackspace();
                    break;
                case "+/-":
                    handlePlusMinus();
                    break;
                case "1/x":
                    handleInverse();
                    break;
                default:
                    handleDigitInput(buttonText);
                    break;
            }
        }

        private void handleDigitInput(String digit) {
            if (tField.getText().equals("0.") || tField.getText().equals("0")) {
                tField.setText(digit);
            } else {
                tField.setText(tField.getText() + digit);
            }
            currentInput = Double.parseDouble(tField.getText());
        }

        private void handleOperation(char newOperation) {
            if (operation != ' ') {
                calculateResult();
            }
            operation = newOperation;
            memoryValue = currentInput;
            tField.setText("0.");
        }
        

        private void calculateResult() {
            switch (operation) {
                case '+':
                    currentInput = memoryValue + currentInput;
                    break;
                case '-':
                    currentInput = memoryValue - currentInput;
                    break;
                case 'x':
                    currentInput = memoryValue * currentInput;
                    break;
                case '/':
                    if (currentInput != 0) {
                        currentInput = memoryValue / currentInput;
                    } else {
                        tField.setText("Error");
                    }
                    break;
                case '%':
                    currentInput = memoryValue % currentInput;
                    break;
            }
            displayResult();
        }

        private void displayResult() {
            tField.setText(Double.toString(currentInput));
        }

        private void handleBackspace() {
            String currentText = tField.getText();
            if (currentText.length() > 1) {
                // 현재 입력값이 한 자리 이상일 때 마지막 문자 제거
                tField.setText(currentText.substring(0, currentText.length() - 1));
                currentInput = Double.parseDouble(tField.getText());
            } else {
                // 현재 입력값이 한 자리일 때는 0으로 초기화
                tField.setText("0.");
                currentInput = 0;
            }
        }

        private void handleCE() {
            String currentText = tField.getText();
            if (!currentText.isEmpty() && !currentText.equals("0.")) {
                // 현재 입력값이 비어 있지 않거나 "0."가 아닌 경우에만 지우기
                tField.setText("0.");
                currentInput = 0;
            }
        }

        private void handlePlusMinus() {
            String currentText = tField.getText();
            if (!currentText.equals("0.") && !currentText.equals("0")) {
                // 현재 입력값이 0이 아닌 경우에만 부호 변경
                if (currentText.charAt(0) == '-') {
                    // 이미 음수인 경우 양수로 변경
                    tField.setText(currentText.substring(1));
                } else {
                    // 양수인 경우 음수로 변경
                    tField.setText("-" + currentText);
                }
                currentInput = Double.parseDouble(tField.getText());
            }
        }

        private void handleInverse() {
            if (currentInput != 0) {
                currentInput = 1 / currentInput;
                displayResult();
            } else {
                tField.setText("Error");
            }
        }
    }
    
    

    public static void main(String args[]) {
        Calculator s = new Calculator();
    }
}