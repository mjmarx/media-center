import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by madeline.marx on 5/17/16.
 */
public class SearchCriteria {
    String name;
    String season;
    String episode;
    String searchType;//general or episode

    public SearchCriteria(String name, String season, String episode) {
        this.name = name;
        this.season = season;
        this.episode = episode;
        this.searchType = "episode";
    }

    public SearchCriteria(String name){
        this.name=name;
        this.searchType = "general";
    }

    static SearchCriteria builder(String inputstring){
        //TODO parsley
        String name;
        String season;
        String episode;

        //String[] args = inputstring.split(" ");

        //try to parse out a season
        Pattern seasonPattern = Pattern.compile("se*\\d+");
        Matcher m = seasonPattern.matcher(inputstring);
        if (m.find()){
            season = inputstring.substring(m.start()+1, m.end());
            System.out.println("parsed season:"+season+"'");

            //also can parse out the episode title from here
            name = inputstring.substring(0, m.start()-1);
            System.out.println("parsed name: "+name+"'");

            Pattern episodePattern = Pattern.compile("ep*\\d+");
            m = episodePattern.matcher(inputstring);
            if (m.find()){
                episode = inputstring.substring(m.start()+1, m.end());
                System.out.println("parsed episode: "+episode+"'");

                return new SearchCriteria(name, season, episode);
            }
            else return new SearchCriteria(name);//parsed season but not episode
        }
        else return new SearchCriteria(inputstring);//couldn't parse season





    }

    @Override
    public String toString() {
        //TODO
        if(this.searchType.equals("general"))
            return "General Search: "+this.name;
        return "Episode search: "+name+", Season: "+season+", Episode: "+episode+".";
    }
}
