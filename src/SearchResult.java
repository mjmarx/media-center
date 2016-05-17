/**
 * Created by madeline.marx on 5/17/16.
 */
public class SearchResult {
    String name;
    String url;
    String titleText;


    @Override
    public String toString() {
        return titleText+" "+url;
    }
}
