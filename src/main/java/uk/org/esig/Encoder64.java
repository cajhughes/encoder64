package uk.org.esig;

import uk.org.esig.view.EncoderFrame;
import javax.swing.UIManager;

class Encoder64 {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            EncoderFrame frame = new EncoderFrame();
            frame.setVisible(true);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
