import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class WordleTR implements ActionListener {

    JFrame jFrame;
    JTextField textField, tf1 = new JTextField(), tf2 = new JTextField(), tf3 = new JTextField(), tf4 = new JTextField(), tf5 = new JTextField(), tf6 = new JTextField(), tf7 = new JTextField(), tf8 = new JTextField(), tf9 = new JTextField(), tf10 = new JTextField(), tf11 = new JTextField(), tf12 = new JTextField(), tf13 = new JTextField(), tf14 = new JTextField(), tf15 = new JTextField(), tf16 = new JTextField(), tf17 = new JTextField(), tf18 = new JTextField(), tf19 = new JTextField(), tf20 = new JTextField(), tf21 = new JTextField(), tf22 = new JTextField(), tf23 = new JTextField(), tf24 = new JTextField(), tf25 = new JTextField();
    JButton button = new JButton("Kontrol Et");
    int hp = 5;
    String[] words = {"anime", "çanta", "tahta", "çekiç", "radyo", "kağıt", "sehpa", "dolap", "kalem", "kaşık", "bıçak", "tabak", "tablo", "lamba", "tepsi", "kilit", "rende", "ayraç", "makas", "kazak", "hırka", "ceket", "kemer", "fular", "kaban", "yılan", "köpek", "domuz", "kumru", "akrep", "serçe", "tavuk", "horoz", "hindi", "şahin", "koyun", "katır", "geyik", "kirpi", "sadık", "zayıf", "sakin", "yalın", "alçak", "rezil", "ebedi", "ezeli", "vazıh", "fakir", "asabi", "ferah", "güzel", "nadir", "nazik", "kibar", "sabit", "yakın", "derin", "temiz", "gizli", "kutlu", "kolay", "basit", "beşir", "gamlı", "latif", "içsel", "zebun", "cimri", "biber", "helva", "gazoz", "hurma", "salça", "ceviz", "badem", "kekik", "armut", "marul", "soğan", "kiraz", "çilek", "vişne", "kavun", "bamya", "susam", "tahin", "reçel", "ayran", "gurur", "kibir", "sinir", "ahlak", "madde", "anlam", "namus", "efsun", "hitap", "kelam", "kanıt", "delil", "batıl", "yalan", "doğru", "yüzey", "çıkış", "giriş", "defin", "kabir", "gömüt", "mezar", "bahçe", "hotel", "antre", "salon", "kiler", "banyo", "beton", "doruk", "dahil", "davul", "kabul", "diğer", "öteki", "daima", "şimdi", "yarın", "bugün", "evvel", "sonra", "kayıt", "satır", "mısra", "roman"};
    String selectedWord;
    ArrayList<Integer> intArray = new ArrayList<>();

    WordleTR() {
        Random random = new Random();
        int x = random.nextInt(words.length);
        selectedWord = words[x];
        jFrame = new JFrame("Wordle-TR");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textField = new JTextField();
        textField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if (textField.getText().length() >= 5 && !(evt.getKeyChar() == KeyEvent.VK_DELETE || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
                    evt.consume();
                }
            }
        });
        button.addActionListener(this);
        setBounds();
        setFonts();
        setAlignments();
        setEditable();
        setBGAndFG();
        addToJFrame();
        jFrame.setSize(290, 380);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }


    public static void main(String[] args) {
        new WordleTR();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        hp--;
        String text = textField.getText();
        if (e.getSource() == button) {
            textField.setText("");
            if (hp == 4) {
                setTF(text, tf1, tf2, tf3, tf4, tf5);
            } else if (hp == 3) {
                setTF(text, tf6, tf7, tf8, tf9, tf10);
            } else if (hp == 2) {
                setTF(text, tf11, tf12, tf13, tf14, tf15);
            } else if (hp == 1) {
                setTF(text, tf16, tf17, tf18, tf19, tf20);
            } else if (hp == 0) {
                setTF(text, tf21, tf22, tf23, tf24, tf25);
                textField.setEditable(false);
                button.setEnabled(false);
                textField.setText(selectedWord);
            }
        }
        if (intArray.contains(0) && intArray.contains(1) && intArray.contains(2) && intArray.contains(3) && intArray.contains(4)) {
            textField.setEditable(false);
            button.setEnabled(false);
            textField.setText(selectedWord);
        }
    }

    public void setTF(String text, JTextField tf1, JTextField tf2, JTextField tf3, JTextField tf4, JTextField tf5) {
        tf1.setText(String.valueOf(text.charAt(0)));
        tf2.setText(String.valueOf(text.charAt(1)));
        tf3.setText(String.valueOf(text.charAt(2)));
        tf4.setText(String.valueOf(text.charAt(3)));
        tf5.setText(String.valueOf(text.charAt(4)));

        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (text.charAt(i) == selectedWord.charAt(j) && !characters.contains(text.charAt(i))) {
                    characters.add(text.charAt(i));
                }
            }
        }
        for (char c : characters) {
            if (c == text.charAt(0)) {
                tf1.setBackground(Color.decode("#917f2f"));
            } else if (c == text.charAt(1)) {
                tf2.setBackground(Color.decode("#917f2f"));
            } else if (c == text.charAt(2)) {
                tf3.setBackground(Color.decode("#917f2f"));
            } else if (c == text.charAt(3)) {
                tf4.setBackground(Color.decode("#917f2f"));
            } else if (c == text.charAt(4)) {
                tf5.setBackground(Color.decode("#917f2f"));
            }
        }

        if (text.charAt(0) == selectedWord.charAt(0)) {
            tf1.setBackground(Color.decode("#42713e"));
            intArray.add(0);
        }
        if (text.charAt(1) == selectedWord.charAt(1)) {
            tf2.setBackground(Color.decode("#42713e"));
            intArray.add(1);
        }
        if (text.charAt(2) == selectedWord.charAt(2)) {
            tf3.setBackground(Color.decode("#42713e"));
            intArray.add(2);
        }
        if (text.charAt(3) == selectedWord.charAt(3)) {
            tf4.setBackground(Color.decode("#42713e"));
            intArray.add(3);
        }
        if (text.charAt(4) == selectedWord.charAt(4)) {
            tf5.setBackground(Color.decode("#42713e"));
            intArray.add(4);
        }
    }

    public void setBounds() {
        textField.setBounds(20, 50, 120, 30);
        button.setBounds(150, 50, 100, 30);
        tf1.setBounds(50, 100, 30, 30);
        tf2.setBounds(85, 100, 30, 30);
        tf3.setBounds(120, 100, 30, 30);
        tf4.setBounds(155, 100, 30, 30);
        tf5.setBounds(190, 100, 30, 30);
        tf6.setBounds(50, 140, 30, 30);
        tf7.setBounds(85, 140, 30, 30);
        tf8.setBounds(120, 140, 30, 30);
        tf9.setBounds(155, 140, 30, 30);
        tf10.setBounds(190, 140, 30, 30);
        tf11.setBounds(50, 180, 30, 30);
        tf12.setBounds(85, 180, 30, 30);
        tf13.setBounds(120, 180, 30, 30);
        tf14.setBounds(155, 180, 30, 30);
        tf15.setBounds(190, 180, 30, 30);
        tf16.setBounds(50, 220, 30, 30);
        tf17.setBounds(85, 220, 30, 30);
        tf18.setBounds(120, 220, 30, 30);
        tf19.setBounds(155, 220, 30, 30);
        tf20.setBounds(190, 220, 30, 30);
        tf21.setBounds(50, 260, 30, 30);
        tf22.setBounds(85, 260, 30, 30);
        tf23.setBounds(120, 260, 30, 30);
        tf24.setBounds(155, 260, 30, 30);
        tf25.setBounds(190, 260, 30, 30);
    }

    public void setBGAndFG() {
        jFrame.getContentPane().setBackground(Color.decode("#0e0f10"));
        button.setBackground(Color.decode("#2c3032"));
        Color color = new Color(208, 204, 198);
        button.setForeground(color);
        for (JTextField jTextField : Arrays.asList(textField, tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, tf11, tf12, tf13, tf14, tf15, tf16, tf17, tf18, tf19, tf20, tf21, tf22, tf23, tf24, tf25)) {
            jTextField.setBackground(Color.decode("#2c3032"));
        }
        for (JTextField jTextField : Arrays.asList(textField, tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, tf11, tf12, tf13, tf14, tf15, tf16, tf17, tf18, tf19, tf20, tf21, tf22, tf23, tf24, tf25)) {
            jTextField.setForeground(Color.decode("#d0ccc6"));
        }
    }

    public void setFonts() {
        Font font = new Font("Arial", Font.PLAIN, 24);
        Font font2 = new Font("Arial", Font.BOLD, 24);
        Font font3 = new Font("Arial", Font.BOLD, 12);
        textField.setFont(font);
        button.setFont(font3);
        for (JTextField jTextField : Arrays.asList(textField, tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, tf11, tf12, tf13, tf14, tf15, tf16, tf17, tf18, tf19, tf20, tf21, tf22, tf23, tf24, tf25)) {
            jTextField.setFont(font2);
        }
    }

    public void setAlignments() {
        for (JTextField jTextField : Arrays.asList(textField, tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, tf11, tf12, tf13, tf14, tf15, tf16, tf17, tf18, tf19, tf20, tf21, tf22, tf23, tf24, tf25)) {
            jTextField.setHorizontalAlignment(SwingConstants.CENTER);
        }
    }

    public void setEditable() {
        for (JTextField jTextField : Arrays.asList(tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, tf11, tf12, tf13, tf14, tf15, tf16, tf17, tf18, tf19, tf20, tf21, tf22, tf23, tf24, tf25)) {
            jTextField.setEditable(false);
        }
    }

    public void addToJFrame() {
        for (JTextField jTextField : Arrays.asList(textField, tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, tf11, tf12, tf13, tf14, tf15, tf16, tf17, tf18, tf19, tf20, tf21, tf22, tf23, tf24, tf25)) {
            jFrame.add(jTextField);
        }
        jFrame.add(button);
    }

}
