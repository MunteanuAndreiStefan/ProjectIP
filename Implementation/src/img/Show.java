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
    public void showImage(Group group, Stage stage, JSONObject jsonObject, String imgLink) throws JSONException {
        this.group = group;
        //System.out.println(imgLink);
        //System.out.println(jsonObject.toString());
        Label concept = new Label("Concept: " + jsonObject.get("Found concept"));
        concept.setLayoutX(30);
        concept.setLayoutY(50);
        Label conceptMatching = new Label("Concept matching: " + jsonObject.get("Concept matching"));
        conceptMatching.setLayoutX(30);
        conceptMatching.setLayoutY(70);
        Label metadata = new Label("Metadata: " + jsonObject.get("Metadata"));
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
            int cnt = 0;
            while(i < str.length()){
                if(str.charAt(i) == ' '){
                    cnt++;
                }
                if(cnt % 7 == 0 && cnt > 0){
                    ans += '\n';
                    cnt = 0;
                }
                ans += str.charAt(i);
                i++;
            }
            System.out.println(ans);
            Label description = new Label("Description: \n " + ans);
            description.setLayoutX(30);
            description.setLayoutY(170);
            this.group.getChildren().add(description);
        } catch (Exception ex) {
            getLogger(EntitySearchApi.class.getName()).log(Level.SEVERE, null, ex);
        }

        //
        System.out.println("Concept : " + jsonObject.get("Found concept") + ";" + "Concept matching : " + jsonObject.get("Concept matching"));
        System.out.println("Metadata : " + jsonObject.get("Metadata") );
        Image img = new Image(imgLink, 300, 300, true, false);
        ImageView imgview = new ImageView(img);
        imgview.setLayoutX(440);
        imgview.setLayoutY(50);
        this.group.getChildren().add(imgview);
    }
}
