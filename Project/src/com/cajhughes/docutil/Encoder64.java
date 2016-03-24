package com.cajhughes.docutil;

import com.cajhughes.docutil.view.EncoderFrame;
import javax.swing.UIManager;

public class Encoder64 {
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
