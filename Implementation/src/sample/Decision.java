package sample;
import javafx.collections.ObservableList;
import javafx.util.Pair;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.*;

public class Decision {
    public Decision() throws IOException, ParseException {
    }

    public Pair<String, Double> check(List<JSONObject> objects, ObservableList<String> items){
        Pair<String, Double> ans;
        Map<String, Double> results = new HashMap<String, Double>();
        Map<String, Integer> count = new HashMap<String, Integer>();
        for(int i=0; i<objects.size(); i++){
            String concept = (String)objects.get(i).get("found concept");
            String percent = (String)objects.get(i).get("Concept matching");
            //System.out.println(concept + " " + percent);
            if(count.containsKey(concept)) {
                Double upd = Math.max(Double.parseDouble(percent), results.get(concept));
                results.put(concept, upd);
                //
                count.put(concept, count.get(concept) + 1);
            } else {
                results.put(concept, Double.parseDouble(percent));
                count.put(concept, 1);
            }
        }
        String winner = null;
        Double winnerePercentage = Double.valueOf(0);
        Set set = results.entrySet();
        Iterator it = set.iterator();
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();
            //System.out.println(entry.getKey() + " " + entry.getValue());
            Double percentageForIt = results.get(entry.getKey());
            if(percentageForIt > winnerePercentage){
                winnerePercentage = percentageForIt;
                winner = (String) entry.getKey();
            }
        }
        ans = new Pair<>(winner, winnerePercentage);
        return ans;
    }
}
