package com.cajhughes.docutil.view;

import com.cajhughes.docutil.control.EncoderDragDropListener;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.dnd.DropTarget;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EncoderFrame extends JFrame {
    private static final String DocuSignImage = "docusign.png";
    public EncoderFrame() {
        try {
            getContentPane().setPreferredSize(new Dimension(300, 300));
            setAlwaysOnTop(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            setTitle("Base64 Encoder");
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() throws Exception {
        Image docusign = Toolkit.getDefaultToolkit().getImage(getClass().getResource(DocuSignImage));
        setIconImage(docusign);
        JPanel panel = new JPanel();
        JLabel label = new JLabel(new ImageIcon(docusign));
        new DropTarget(label, new EncoderDragDropListener(this));
        panel.add(label);
        add(panel);
        pack();
    }
}
