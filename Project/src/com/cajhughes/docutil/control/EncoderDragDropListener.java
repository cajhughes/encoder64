package com.cajhughes.docutil.control;

import com.cajhughes.docutil.model.FileEncoder;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.File;
import java.util.List;
import javax.swing.JFrame;

public class EncoderDragDropListener implements DropTargetListener {
    private JFrame window;

    public EncoderDragDropListener(JFrame frame) {
        this.window = frame;
    }

    @Override
    public void drop(DropTargetDropEvent event) {
        event.acceptDrop(DnDConstants.ACTION_COPY);
        window.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        Transferable transferable = event.getTransferable();
        DataFlavor[] flavors = transferable.getTransferDataFlavors();
        for (DataFlavor flavor: flavors) {
            try {
                if (flavor.isFlavorJavaFileListType()) {
                    @SuppressWarnings("unchecked")
                    List<File> files = (List<File>)transferable.getTransferData(flavor);
                    if (files.size() == 1) {
                        for (File file: files) {
                            StringSelection selection = new StringSelection(FileEncoder.getBase64Encoding(file));
                            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                            clipboard.setContents(selection, selection);
                        }
                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        window.setCursor(Cursor.getDefaultCursor());
        event.dropComplete(true);
    }

    @Override
    public void dragEnter(DropTargetDragEvent event) {
    }

    @Override
    public void dragExit(DropTargetEvent event) {
    }

    @Override
    public void dragOver(DropTargetDragEvent event) {
    }

    @Override
    public void dropActionChanged(DropTargetDragEvent event) {
    }
}