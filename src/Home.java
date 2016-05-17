import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by madeline.marx on 5/16/16.
 */
public class Home extends JFrame {

        JTextField searchTextField;
        JButton searchButton;

        JTextArea outPutBox;
        JScrollPane outPutScrollBar;


        public Home() {


            searchButton = new JButton("Search");
            searchButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    print("Search button pressed");
                    //get search text
                    String input = searchTextField.getText();

                    //parse
                    SearchCriteria criteria = SearchCriteria.builder(input);
                    System.out.println("Searching on criteria: "+criteria.toString());

                    //search
                    SearchUtil su= new SearchUtil();
                    ArrayList<SearchResult> results = new ArrayList<SearchResult>();
                    //If I supply just a title, I want possibly all shows or a movie
                    //title and episodes easy

                    //results.addAll(su.searchYoutube(criteria));



                }

            });

            outPutBox = new JTextArea();
            outPutBox.setEditable(false);
            outPutBox.setPreferredSize(new Dimension(500,500));
            outPutScrollBar = new JScrollPane(outPutBox);

            searchTextField = new JTextField("steven universe s03 e5");











            // add things to window-------------------------------------
            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "boop"));

            JPanel searchPanel = new JPanel(new GridLayout(1,2));
            searchPanel.add(searchTextField);
            searchPanel.add(searchButton);
            searchPanel.setPreferredSize(new Dimension(500, 75));


            panel.add(searchPanel);
            panel.add(outPutScrollBar);

            //setPreferredSize(new Dimension(500, 500));
            //TODO make the output box big, search and button small
            add(panel);
            pack();
            setLocationRelativeTo(null);
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Home().setVisible(true);
                }
            });
        }

        public void print(String toPrint){
            outPutBox.append(toPrint);
            outPutBox.append("\n");
        }

    public void printResults(ArrayList<SearchResult> toPrint){
        for (int i=0;i<toPrint.size();i++){
            outPutBox.append(toPrint.get(i).toString());
            outPutBox.append("\n");
        }

    }



}
