import javax.print.attribute.standard.JobKOctets;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import static java.awt.event.KeyEvent.VK_ENTER;
import static java.awt.event.KeyEvent.VK_EQUALS;

public class Gui {
    private String result;
    public Gui() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(400, 70);

        frame.add(panel);

        JTextField expInput = new JTextField(15);
        JLabel show_result = new JLabel();
        JButton submit = new JButton("=");


        expInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == VK_EQUALS) {
                    getResult(e, expInput, show_result);
                } else if (e.getKeyChar() == VK_ENTER) {
                    getResult(e, expInput, show_result);
                }
            }
        });


        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calculator calculator = new Calculator();
                result = calculator.evalExp(expInput.getText());
                System.out.println(expInput.getText());
                System.out.println(result);
                show_result.setText(result);
            }
        });
        panel.add(expInput);
        panel.add(submit);
        panel.add(show_result);

        frame.setVisible(true);

    }
    private void getResult(KeyEvent e, JTextField expInput, JLabel show_result) {
        Calculator calculator = new Calculator();
        result = calculator.evalExp(expInput.getText());
        System.out.println(expInput.getText());
        System.out.println(result);
        show_result.setText(result);
        e.consume();
    }

    public static void main(String[] args) {
        new Gui();
        ArrayList<String> test = new ArrayList<String>(){
            {
                add("4.7+3.0*5.5");
                add("4.7 + 3.0 * -5.5");
                add("4.7+-3.0*5.5");
                add("1+(2*-3)+-4");
                add("(1+2)*3*(4/2)");
                add("(1+2)*(3*4)/+2");
                add("1^(2*3)-1");
                add("(2+3)^2");
                add("(2+3)^-2");
                add("8%3");
                add("(2+3)%2");
            }
        };
        ArrayList<String> ans = new ArrayList<String>(){
            {
                add("21.2");
                add("-11.8");
                add("-11.8");
                add("-9.0");
                add("18.0");
                add("18.0");
                add("0.0");
                add("25.0");
                add("0.04");
                add("2.0");
                add("1.0");
            }
        };
        Calculator calculator = new Calculator();
        for(int i = 0; i < ans.size(); ++i){
            System.out.println(test.get(i) + " = " + calculator.evalExp(test.get(i)) + "  correct answer : " + ans.get(i));
        }
    }

}
