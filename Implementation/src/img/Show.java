package img;

import entitysearch.EntitySearchApi;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.logging.Level;

import static entitysearch.EntitySearchApi.entitySearchFromText;
import static java.util.logging.Logger.getLogger;

public class Show {
    Group group;
    static Label concept;
    static Label conceptMatching;
    static Label metadata;
    static Label description;
    static Image img;
    static ImageView imgview;

    public void showImage(Group group, Stage stage, JSONObject jsonObject, String imgLink) throws JSONException {
        this.group = group;
        this.group.getChildren().remove(concept);

        this.group.getChildren().remove(conceptMatching);

        this.group.getChildren().remove(metadata);

        this.group.getChildren().remove(description);

        this.group.getChildren().remove(img);

        this.group.getChildren().remove(imgview);
        //System.out.println(imgLink);
        //System.out.println(jsonObject.toString());
        concept = new Label("Concept: " + jsonObject.get("Found concept"));
        concept.setLayoutX(30);
        concept.setLayoutY(50);
        conceptMatching = new Label("Concept matching: " + jsonObject.get("Concept matching"));
        conceptMatching.setLayoutX(30);
        conceptMatching.setLayoutY(70);
        metadata = new Label("Metadata: " + jsonObject.get("Metadata"));
        metadata.setLayoutX(30);
        metadata.setLayoutY(90);
        this.group.getChildren().add(concept);
        this.group.getChildren().add(conceptMatching);
        this.group.getChildren().add(metadata);
        //
        try {
            JSONObject obj=entitySearchFromText((String) jsonObject.get("Found concept"));
            String str = (String) obj.get("Description");
            String ans = "";
            int i = 0;
            int lines = 0;
            int cnt = 0;
            while(i < str.length()){
                if(str.charAt(i) == ' '){
                    cnt++;
                }
                if(cnt % 7 == 0 && cnt > 0){
                    ans += '\n';
                    lines++;
                    cnt = 0;
                }
                ans += str.charAt(i);
                i++;
                if(lines > 15){
                    ans += "...";
                    break;
                }
            }
            System.out.println(ans);
            description = new Label("Description: \n " + ans);
            description.setLayoutX(30);
            description.setLayoutY(170);
            this.group.getChildren().add(description);
        } catch (Exception ex) {
            getLogger(EntitySearchApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        //
        System.out.println("Concept : " + jsonObject.get("Found concept") + ";" + "Concept matching : " + jsonObject.get("Concept matching"));
        System.out.println("Metadata : " + jsonObject.get("Metadata") );
        img = new Image(imgLink, 300, 300, true, false);
        imgview = new ImageView(img);
        imgview.setLayoutX(440);
        imgview.setLayoutY(50);
        this.group.getChildren().add(imgview);
    }
}


//http://www.catster.com/wp-content/uploads/2017/08/A-fluffy-cat-looking-funny-surprised-or-concerned.jpg
//http://globalvillageextra.com/en/wp-content/uploads/2017/07/PB1201_STORY_CARO-Authority-HealthyOutside-DOG-20160818.jpg
//https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR1hUwk7vxDr6uy2AuQywLoBxiaf99P9RW5nb3hfXdi4MzK1jrkkQ
