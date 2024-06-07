import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

class Display {
    private final JFrame frame;
    public final KeyBoard keyBoard;
    private final JPanel contentPane;
    Display(HashMap<String, JLabel> Jlabels, String... imageFilePaths) {
        frame = new JFrame();
        keyBoard = new KeyBoard();
        //
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.addKeyListener(keyBoard);
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        gd.setFullScreenWindow(frame);
        
        contentPane = new JPanel(null);
        contentPane.setOpaque(false);
        //1
        for (int i = 0; i != imageFilePaths.length; i++) {
            Jlabels.put(imageFilePaths[i], addImage(imageFilePaths[i], 1500, 900, 0, 0));
        }
        //1
        System.out.println(contentPane.getComponentCount());
        frame.setContentPane(contentPane);

        frame.setVisible(true);
    }
    private JLabel addImage(String filepath, int width, int height, int x, int y) {
        ImageIcon icon = new ImageIcon(filepath);
        JLabel imageLabel = new JLabel();
        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        imageLabel.setIcon(scaledIcon);
        imageLabel.setBounds(x, y, width, height);
        contentPane.add(imageLabel);
        return imageLabel;
    }
}