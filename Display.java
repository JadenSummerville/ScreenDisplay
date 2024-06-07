import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Display {
    private final JFrame frame;
    public final KeyBoard keyBoard;
    private final JPanel contentPane;
    /**
     * Creates a display screen with the png in the paths imageFilePaths.
     * Uses Jlabels as a return parameter where each image file path
     * leads to that path's corresponding JLabel.
     * 
     * @param Jlabels return parameter. Keys are strings in 'imageFilePaths'.
     * Values are their corresponding JLabels
     * @param imageFilePaths the paths to the pngs we wish to display.
     * @param dimensions arraylist of dimensions of each imageFile path
     * ordered width, height, x, y.
     * @throws RuntimeException Jlabels is not empty.
     * @throws RuntimeException dimensions is not the same length as imageFilePaths.
    */
    public Display(HashMap<String, JLabel> Jlabels, ArrayList<String> imageFilePaths, ArrayList<ArrayList<Integer>> dimensions) {
        if (Jlabels.size() != 0) {
            throw new RuntimeException("Return parameter not empty.");
        }
        if (imageFilePaths.size() != dimensions.size()) {
            throw new RuntimeException("Dimensions not specified or extra dimensions specified.");
        }
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
        for (int i = 0; i != imageFilePaths.size(); i++) {
            Jlabels.put(imageFilePaths.get(i), addImage(imageFilePaths.get(i),
            dimensions.get(i).get(0), dimensions.get(i).get(1), dimensions.get(i).get(2), dimensions.get(i).get(3)));
        }
        //1
        System.out.println(contentPane.getComponentCount());
        frame.setContentPane(contentPane);

        frame.setVisible(true);
    }
    public static <T> ArrayList<T> toArray(T... objects) {
        ArrayList<T> goal = new ArrayList<>();
        for (T obj: objects) {
            goal.add(obj);
        }
        return goal;
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
    /**
     * Set z ordering of this JLabel.
     * 
     * @param jlabel jlabel we wish to adjust location of.
     * @param index index we wish to adjust.
    */
    public void setZOrder(JLabel jlabel, int index) {
        contentPane.setComponentZOrder(jlabel, index);
        contentPane.repaint();
    }
}
