/**
 * @author Farrel Aqilla Novianto
 */
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.awt.Image;

public class ImageData{
  private String filePath;
  private String fileName;
  private ImageIcon originalIcon;
  
  public ImageData(String filePath){
    this.filePath = filePath;
    File file = new File(filePath);
    this.fileName = file.getName();
    this.originalIcon = new ImageIcon(filePath);
  }
  
  public String getFilePath(){
    return filePath;
  }
  
  public String getFileName(){
    return fileName;
  }
  
  public ImageIcon getOriginalIcon(){
    return originalIcon;
  }
  
  public ImageIcon getScaledIcon(double scale){
    int width = (int)(originalIcon.getIconWidth() * scale);
    int height = (int)(originalIcon.getIconHeight() * scale);
    Image scaledImage = originalIcon.getImage().getScaledInstance(
      width, height, Image.SCALE_SMOOTH);
    return new ImageIcon(scaledImage);
  }
}

class ImageManager{
  private List<ImageData> images;
  private int currentIndex;
  private double zoomLevel;
  
  public ImageManager(){
    images = new ArrayList<>();
    currentIndex = -1;
    zoomLevel = 1.0;
  }
  
  public boolean loadImage(String filePath){
    try{
      ImageData imageData = new ImageData(filePath);
      images.add(imageData);
      currentIndex = images.size() - 1;
      zoomLevel = 1.0;
      return true;
    }
    catch(Exception e){
      return false;
    }
  }
  
  public void nextImage(){
    if(!images.isEmpty()){
      currentIndex = (currentIndex + 1) % images.size();
      zoomLevel = 1.0;
    }
  }
  
  public void previousImage(){
    if(!images.isEmpty()){
      currentIndex = (currentIndex - 1 + images.size()) % images.size();
      zoomLevel = 1.0;
    }
  }
  
  public void zoomIn(){
    if(zoomLevel < 3.0){
      zoomLevel += 0.25;
    }
  }
  
  public void zoomOut(){
    if(zoomLevel > 0.25){
      zoomLevel -= 0.25;
    }
  }
  
  public ImageIcon getCurrentImage(){
    if(currentIndex >= 0 && currentIndex < images.size()){
      return images.get(currentIndex).getScaledIcon(zoomLevel);
    }
    return null;
  }
  
  public String getCurrentImageName(){
    if(currentIndex >= 0 && currentIndex < images.size()){
      return images.get(currentIndex).getFileName();
    }
    return "";
  }
  
  public int getCurrentIndex(){
    return currentIndex;
  }
  
  public int getImageCount(){
    return images.size();
  }
  
  public void clearImages(){
    images.clear();
    currentIndex = -1;
    zoomLevel = 1.0;
  }
}