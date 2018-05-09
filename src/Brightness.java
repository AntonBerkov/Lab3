import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Brightness {
    public void begin() throws  FileNotFoundException {
     Pane pane = new Pane();

        FileInputStream input = new FileInputStream("1.jpg");
        Image image = new Image(input);

        ImageView img = new ImageView(image);
        FileInputStream inpt = new FileInputStream("2.jpg");
        Image image1 = new Image(inpt);
        ImageView img1 = new ImageView(image1);
        BufferedImage imageb = SwingFXUtils.fromFXImage(image, null);
        BufferedImage imageb2 = SwingFXUtils.fromFXImage(image1, null);




        double avg =0;
        int count =0;
        for(int x =0; x< imageb.getWidth(); x++){
            for(int y =0; y<imageb.getHeight();y++){

                int color = imageb.getRGB(x,y);
                imageb2.setRGB(x,y,color);

                int r = (color >>>16)& 0xff;
                int g = (color >>>8)& 0xff;
                int b = (color >>>0)& 0xfff;
                double lum = ((0.2126f*r)+(0.7152f*g)+(0.0722f*b))/255;


            }
        }
        Image card = SwingFXUtils.toFXImage(imageb2, null );
        ImageView img3 = new ImageView(card);
        img3.setLayoutX(0);
        img3.setLayoutY(400);








        img1.setLayoutX(350);
        img1.setLayoutY(0);

        pane.getChildren().addAll(img,img1,img3);
        Scene scene = new Scene(pane,800,600);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

}
