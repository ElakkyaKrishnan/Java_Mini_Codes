import java.awt.*;
import java.awt.event.*;

public class calculator extends Frame implements ActionListener{

TextField input;
Button bt0,bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,add,sub,mul,div,equal,reset;

calculator(){
    //input field
    input = new TextField();
    //button creation
    bt0 = new Button("0");
    bt0.addActionListener(this);
    bt1 = new Button("1");
    bt1.addActionListener(this);
    bt2 = new Button("2");
    bt2.addActionListener(this);
    bt3 = new Button("3");
    bt3.addActionListener(this);
    bt4 = new Button("4");
    bt4.addActionListener(this);
    bt5 = new Button("5");
    bt5.addActionListener(this);
    bt6 = new Button("6");
    bt6.addActionListener(this);
    bt7 = new Button("7");
    bt7.addActionListener(this);
    bt8 = new Button("8");
    bt8.addActionListener(this);
    bt9 = new Button("9");
    bt9.addActionListener(this);
    add = new Button("+");
    add.addActionListener(this);
    sub = new Button("-");
    sub.addActionListener(this);
    mul = new Button("*");
    mul.addActionListener(this);
    div = new Button("/");
    div.addActionListener(this);
    equal = new Button("=");
    equal.addActionListener(this);
    reset = new Button("c");
    reset.addActionListener(this);

    //setting boundaries
    input.setBounds(60,50,190,30);
    bt7.setBounds(60,90,40,40);
    bt8.setBounds(110,90,40,40);
    bt9.setBounds(160,90,40,40);
    sub.setBounds(210,90,40,40);

    bt4.setBounds(60,140,40,40);
    bt5.setBounds(110,140,40,40);
    bt6.setBounds(160,140,40,40);
    add.setBounds(210,140,40,40);

    bt1.setBounds(60,190,40,40);
    bt2.setBounds(110,190,40,40);
    bt3.setBounds(160,190,40,40);
    mul.setBounds(210,190,40,40);

    bt0.setBounds(60,240,40,40);
    equal.setBounds(110,240,40,40);
    reset.setBounds(160,240,40,40);
    div.setBounds(210,240,40,40);


    //add buttons in container
    add(input);
    add(bt0);
    add(bt1);
    add(bt2);
    add(bt3);
    add(bt4);
    add(bt5);
    add(bt6);
    add(bt7);
    add(bt8);
    add(bt9);
    add(add);
    add(sub);
    add(mul);
    add(div);
    add(equal);
    add(reset);
   

    //basic btn attributes
    setLayout(null);
    setTitle("calculator");
    setSize(500,500);
    setVisible(true);
    
}

public void actionPerformed(ActionEvent e){
    String expression = input.getText();

    // If the display initially shows 0 and number is pressed, clear 0
    if(expression.equals("0")) {
        expression = "";
    }

    // Digits
    if(e.getSource() == bt0){
        expression += "0";
    }
    if(e.getSource() == bt1){
        expression += "1";
    }
    if(e.getSource() == bt2){
        expression += "2";
    }
    if(e.getSource() == bt3){
        expression += "3";
    }
    if(e.getSource() == bt4) {
        expression += "4";
    }
    if(e.getSource() == bt5){
        expression += "5";
    }
    if(e.getSource() == bt6){
        expression += "6";
    }
    if(e.getSource() == bt7){
        expression += "7";
    }
    if(e.getSource() == bt8){
        expression += "8";
    }
    if(e.getSource() == bt9){
        expression += "9";
    }

    // Operators
    if(e.getSource() == add || e.getSource() == sub || e.getSource() == mul || e.getSource() == div){
        if(expression.isEmpty()) return; // prevent starting with operator

        char lastChar = expression.charAt(expression.length() - 1);
        String newOp = "";

        if(e.getSource() == add) {
            newOp = "+";
        }
        if(e.getSource() == sub){
            newOp = "-";
        }
        if(e.getSource() == mul){
            newOp = "*";
        }
        if(e.getSource() == div) {
            newOp = "/";
        }

        // Replace if last is operator
        if(lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/') {
            expression = expression.substring(0, expression.length() - 1) + newOp;
        } else {
            expression += newOp;
        }
    }

    // Reset
    if(e.getSource() == reset){
        expression = "0";
    }

    // Evaluate manually
    if(e.getSource() == equal){
        try {
            // Basic left-to-right evaluation (no operator precedence)
            java.util.StringTokenizer tokens = new java.util.StringTokenizer(expression, "+-*/", true);
            int result = 0;
            String currentOp = "+";
            while (tokens.hasMoreTokens()) {
                String token = tokens.nextToken().trim();
                if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                    currentOp = token;
                } else {
                    int num = Integer.parseInt(token);
                    switch (currentOp) {
                        case "+": result += num; break;
                        case "-": result -= num; break;
                        case "*": result *= num; break;
                        case "/": result /= num; break;
                    }
                }
            }

            expression = String.valueOf(result);
        } catch (Exception ex){
            expression = "Error";
        }
    }

    input.setText(expression);
}





public static void main (String[] args){
    new calculator();

}
}
