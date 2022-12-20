package vetauhoa.validator;
import java.util.List;

public class RandomId {
    public boolean testId(List<String> list, String id){
        for(String x: list){
            if(x.equals(id))return false;
        }
        return true;
    }
}
