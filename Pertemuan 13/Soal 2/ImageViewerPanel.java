/**
 * @author Farrel Aqilla Novianto
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class ImageViewerPanel{
  private ImageManager imageManager;
  private JLabel imageLabel;
  private JFrame frame;
  private JLabel statusLabel;
  
  public ImageViewerPanel(){
    imageManager = new ImageManager();
    createAndShowGUI();
  }
  
  public void createAndShowGUI(){
    frame = new JFrame("Image Viewer");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());
    
    imageLabel = new JLabel("No Image Loaded", SwingConstants.CENTER);
    imageLabel.setPreferredSize(new Dimension(600, 400));
    imageLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
    
    JScrollPane scrollPane = new JScrollPane(imageLabel);
    frame.add(scrollPane, BorderLayout.CENTER);
    
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout());
    
    JButton btnOpen = new JButton("Open Image");
    btnOpen.addActionListener(new OpenImageListener());
    
    JButton btnPrevious = new JButton("Previous");
    btnPrevious.addActionListener(new PreviousListener());
    
    JButton btnNext = new JButton("Next");
    btnNext.addActionListener(new NextListener());
    
    JButton btnZoomIn = new JButton("Zoom In");
    btnZoomIn.addActionListener(new ZoomInListener());
    
    JButton btnZoomOut = new JButton("Zoom Out");
    btnZoomOut.addActionListener(new ZoomOutListener());
    
    JButton btnClear = new JButton("Clear");
    btnClear.addActionListener(new ClearListener());
    
    buttonPanel.add(btnOpen);
    buttonPanel.add(btnPrevious);
    buttonPanel.add(btnNext);
    buttonPanel.add(btnZoomIn);
    buttonPanel.add(btnZoomOut);
    buttonPanel.add(btnClear);
    
    frame.add(buttonPanel, BorderLayout.NORTH);
    
    statusLabel = new JLabel("Ready");
    statusLabel.setBorder(BorderFactory.createEtchedBorder());
    frame.add(statusLabel, BorderLayout.SOUTH);
    
    frame.setSize(700, 550);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
  
  private void updateImage(){
    ImageIcon icon = imageManager.getCurrentImage();
    if(icon != null){
      imageLabel.setIcon(icon);
      imageLabel.setText("");
      statusLabel.setText("Image: " + imageManager.getCurrentImageName() + " (" + (imageManager.getCurrentIndex() + 1) + "/" + imageManager.getImageCount() + ")");
    }
    else{
      imageLabel.setIcon(null);
      imageLabel.setText("No Image Loaded");
      statusLabel.setText("Ready");
    }
  }
  
  private class OpenImageListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
        "Image Files", "jpg", "jpeg", "png", "gif", "bmp"));
      
      int result = fileChooser.showOpenDialog(frame);
      if(result == JFileChooser.APPROVE_OPTION){
        File selectedFile = fileChooser.getSelectedFile();
        if(imageManager.loadImage(selectedFile.getAbsolutePath())){
          updateImage();
        }
        else{
          JOptionPane.showMessageDialog(frame, "Failed to load image!", "Error", JOptionPane.ERROR_MESSAGE);
        }
      }
    }
  }
  
  private class PreviousListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      imageManager.previousImage();
      updateImage();
    }
  }
  
  private class NextListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      imageManager.nextImage();
      updateImage();
    }
  }
  
  private class ZoomInListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      imageManager.zoomIn();
      updateImage();
    }
  }
  
  private class ZoomOutListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      imageManager.zoomOut();
      updateImage();
    }
  }
  
  private class ClearListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      imageManager.clearImages();
      updateImage();
    }
  }
}