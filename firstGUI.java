import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class firstGUI {
    int number = 0;
    Long totalNumber = 0L;
    String currCalculation = "";
    String calculations = "";

    enum Operation {
        NULL, PLUS, MINUS, MULT, DIV
    }

    // 0 = null, 1 = plus, 2 = minus, 3 = mult, 4
    Operation prevOp = Operation.NULL;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> new firstGUI());

    }

    public firstGUI() {

        JButton s1080p = new JButton("1920x1080");
        JButton s720p = new JButton("1280x720");
        JButton s360p = new JButton("640x360");
        JButton resetSize = new JButton("Reset Size");
        s1080p.setFont(new Font("", 0, 20));
        s720p.setFont(new Font("", 0, 20));
        s360p.setFont(new Font("", 0, 20));
        resetSize.setFont(new Font("", 0, 20));

        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        controlPanel.add(s1080p);
        controlPanel.add(s720p);
        controlPanel.add(s360p);
        controlPanel.add(resetSize);

        JTextArea someText = new JTextArea();
        someText.setLineWrap(true);
        someText.setWrapStyleWord(true);
        someText.setBackground(Color.LIGHT_GRAY);
        someText.setMargin(new Insets(5, 5, 5, 5));
        someText.setEditable(false);
        someText.setFont(new Font("", 0, 30));

        JTextArea calculationsHistory = new JTextArea();
        calculationsHistory.setLineWrap(true);
        calculationsHistory.setWrapStyleWord(true);
        calculationsHistory.setMargin(new Insets(5, 5, 5, 5));
        calculationsHistory.setEditable(false);

        JPanel someTextPanel = new JPanel(new BorderLayout());
        someTextPanel.add(someText, BorderLayout.WEST);
        someTextPanel.add(calculationsHistory, BorderLayout.EAST);
        someTextPanel.add(new JScrollPane(calculationsHistory), BorderLayout.CENTER);

        Font btFont = new Font("", 0, 20);
        JButton one = new JButton("1");
        one.setFont(btFont);
        JButton two = new JButton("2");
        two.setFont(btFont);
        JButton three = new JButton("3");
        three.setFont(btFont);
        JButton four = new JButton("4");
        four.setFont(btFont);
        JButton five = new JButton("5");
        five.setFont(btFont);
        JButton six = new JButton("6");
        six.setFont(btFont);
        JButton seven = new JButton("7");
        seven.setFont(btFont);
        JButton eight = new JButton("8");
        eight.setFont(btFont);
        JButton nine = new JButton("9");
        nine.setFont(btFont);
        JButton zero = new JButton("0");
        zero.setFont(btFont);

        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton mult = new JButton("*");
        JButton div = new JButton("/");

        JButton eq = new JButton("=");

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.add(one);
        buttonsPanel.add(two);
        buttonsPanel.add(three);
        buttonsPanel.add(four);
        buttonsPanel.add(five);
        buttonsPanel.add(six);
        buttonsPanel.add(seven);
        buttonsPanel.add(eight);
        buttonsPanel.add(nine);
        buttonsPanel.add(zero);

        buttonsPanel.add(plus);
        buttonsPanel.add(minus);
        buttonsPanel.add(mult);
        buttonsPanel.add(div);

        buttonsPanel.add(eq);

        JSplitPane calcPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, someTextPanel, buttonsPanel);
        calcPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        one.addActionListener((e) -> {
            num(1, someText);
        });
        two.addActionListener((e) -> {
            num(2, someText);
        });
        three.addActionListener((e) -> {
            num(3, someText);
        });
        four.addActionListener((e) -> {
            num(4, someText);
        });
        five.addActionListener((e) -> {
            num(5, someText);
        });
        six.addActionListener((e) -> {
            num(6, someText);
        });
        seven.addActionListener((e) -> {
            num(7, someText);
        });
        eight.addActionListener((e) -> {
            num(8, someText);
        });
        nine.addActionListener((e) -> {
            num(9, someText);
        });
        zero.addActionListener((e) -> {
            num(0, someText);
        });
        plus.addActionListener((e) -> {
            plus();
            currCalculation += "+";
        });
        minus.addActionListener((e) -> {
            minus();
            currCalculation += "-";
        });
        mult.addActionListener((e) -> {
            mult();
            currCalculation += "*";
        });
        div.addActionListener((e) -> {
            div();
            currCalculation += "/";
        });

        eq.addActionListener((e) -> {
            switch (prevOp) {
                case PLUS:
                    plus();
                    break;
                case MINUS:
                    minus();
                    break;
                case MULT:
                    mult();
                    break;
                case DIV:
                    div();
                    break;
                default:
                    break;
            }
            currCalculation += "=";
            someText.setText(String.valueOf(totalNumber));
            currCalculation += String.valueOf(totalNumber);
            calculations = currCalculation + "\n" + calculations;
            calculationsHistory.setText(calculations);
            reset();
        });

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(controlPanel, BorderLayout.NORTH);
        mainPanel.add(calcPanel);

        JFrame frame = new JFrame();
        frame.setTitle("First Program");
        frame.setSize(new Dimension(400, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(mainPanel, BorderLayout.CENTER);

        s1080p.addActionListener((e) -> {
            frame.setSize(new Dimension(1920, 1080));
            frame.setLocationRelativeTo(null);
        });
        s720p.addActionListener((e) -> {
            frame.setSize(new Dimension(1280, 720));
            frame.setLocationRelativeTo(null);
        });
        s360p.addActionListener((e) -> {
            frame.setSize(new Dimension(640, 360));
            frame.setLocationRelativeTo(null);
        });
        resetSize.addActionListener((e) -> {
            frame.setSize(new Dimension(400, 500));
            frame.setLocationRelativeTo(null);
        });

    }

    public void num(int num, JTextArea text) {
        if (String.valueOf(number).length() + String.valueOf(num).length() < 9) {
            currCalculation += String.valueOf(num);
            int prevNum = number;
            number = Integer.valueOf(String.valueOf(prevNum) + String.valueOf(num));
            text.setText(String.valueOf(number));
        }

    }

    public void plus() {
        switch (prevOp) {
            case MINUS:
                totalNumber -= number;
                break;
            case DIV:
                totalNumber /= number;
                break;
            case MULT:
                totalNumber *= number;
                break;
            default:
                totalNumber += number;
                break;
        }
        prevOp = Operation.PLUS;
        number = 0;
    }

    public void minus() {
        switch (prevOp) {
            case NULL, PLUS:
                totalNumber += number;
                break;
            case DIV:
                totalNumber /= number;
                break;
            case MULT:
                totalNumber *= number;
                break;
            default:
                totalNumber -= number;
                break;
        }
        prevOp = Operation.MINUS;
        number = 0;
    }

    public void mult() {
        switch (prevOp) {
            case NULL, PLUS:
                totalNumber += number;
                break;
            case MINUS:
                totalNumber -= number;
                break;
            case DIV:
                totalNumber /= number;
                break;
            default:
                totalNumber *= number;
                break;
        }
        prevOp = Operation.MULT;
        number = 0;
    }

    public void div() {
        switch (prevOp) {
            case NULL, PLUS:
                totalNumber += number;
                break;
            case MINUS:
                totalNumber -= number;
                break;
            case MULT:
                totalNumber *= number;
                break;
            default:
                totalNumber /= number;
                break;
        }
        prevOp = Operation.DIV;
        number = 0;
    }

    public void reset() {
        number = 0;
        totalNumber = 0L;
        prevOp = Operation.NULL;
        currCalculation = "";
    }
}