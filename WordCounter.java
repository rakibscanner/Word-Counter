package Project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WordCounter {

    public static void main(String args[]) {
        JFrame frame = new JFrame("Word Counter");
        JLabel ws, wos, w;
        JTextArea text;
        JLabel input;
        JButton submit, clear;
        JScrollPane scrollPane;

        //create textarea, button, label
        text = new JTextArea("");
        submit = new JButton("SUBMIT");
        clear = new JButton("CLEAR");
        input = new JLabel("Enter your article : ");
        ws = new JLabel("Character with spaces : ");
        wos = new JLabel("Character without spaces : ");
        w = new JLabel("Words : ");

        // create scrollbar
        scrollPane = new JScrollPane(text);
        scrollPane.setBounds(18, 60, 450, 300);

        // set font
        Font txtFont = new Font(Font.SERIF, Font.PLAIN, 16);
        input.setFont(txtFont);
        ws.setFont(txtFont);
        wos.setFont(txtFont);
        w.setFont(txtFont);

        // Set properties
        input.setBounds(10, 25, 200, 30);
        text.setBounds(18, 60, 450, 300);
        ws.setBounds(10, 370, 400, 30);
        wos.setBounds(10, 400, 400, 30);
        w.setBounds(10, 430, 400, 30);
        submit.setBounds(120, 470, 80, 40);
        clear.setBounds(250, 470, 80, 40);

        // text wrap
        text.setLineWrap(true);
        text.setWrapStyleWord(true);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Get text from text area
                String str = text.getText().strip();
                int count = 0, i, word = 0;
                ws.setText("Character with Spaces : " + str.length());

                // count character
                for (i = 0; i < str.length(); i++) {
                    if (str.charAt(i) != ' ') {
                        count++;
                    } else {
                        word++;
                    }
                }

                wos.setText("Character Without Spaces : " + count);
                w.setText("Words : " + (word + 1));
            }
        });

        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Set text from text area
                text.setText("");
                ws.setText("Character with Spaces : ");
                wos.setText("Character Without Spaces : ");
                w.setText("Words : ");
            }
        });

        // Add components to frame
        frame.add(input);
        frame.add(scrollPane);
        frame.add(ws);
        frame.add(wos);
        frame.add(w);
        frame.add(submit);
        frame.add(clear);
        frame.setSize(500, 570);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
