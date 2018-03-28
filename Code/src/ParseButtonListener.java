import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

import java.util.regex.*;

/**
 * Used for interacting with  the GUI when text is entered
 * @author aaron
 *
 */
public class ParseButtonListener implements ActionListener {
	/**
	 * All the back end logic for interacting with  the lexicon
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String input = Parser.input.getText();
		String output = " S [NP [ ";		
		/**
		 * make sure the user enters an input
		 */
		if(input.equals("")){
			JOptionPane.showMessageDialog(null, ""
					+ "			Please enter in some text", 
					"Oops", JOptionPane.PLAIN_MESSAGE);
		}
		else{
				/********************************/
			
			Scanner fileReaderScan = null;
			StringTokenizer tokens = new StringTokenizer(input);
			ArrayList<String> categoryList = new ArrayList<String>();

			/**
			 * traverse each token from the input
			 */
			while(tokens.hasMoreTokens()){
				fileReaderScan = new Scanner(getClass().getResourceAsStream("lexicon.txt"));

				String thisToken = tokens.nextToken();
				
				/**
				 * Traverse lines in the lexicon.txt
				 */
				while(fileReaderScan.hasNextLine())
				{	
						//Tokenize the words of each line in the lexicon.txt
						String scan = fileReaderScan.nextLine().toString();
						StringTokenizer lexiconTokens = new StringTokenizer(scan);

						/**
						 * traverse the tokens and add them to the list of POS categories
						 */
						while(lexiconTokens.hasMoreTokens()){
							if(thisToken.equals(lexiconTokens.nextToken())){
								
								String thisLexToken = lexiconTokens.nextToken();
								categoryList.add(thisLexToken);
								output += " [" + thisLexToken + " " + thisToken + " ]";
							}	
						}
				}
			}
			fileReaderScan.close();
			
			
			String posTags = "";
			for(int i = 0; i < categoryList.size(); i++){
				posTags += categoryList.get(i) + " ";
			}
			
			System.out.println(posTags);
			/********************************/
			

			if(posTags.equals("DT N V DT ADJ N ")){
				Parser.acceptable.setText("<html>Result - Acceptable Regular Expression: <b>True</b></html>" );
				
				Parser.output.setText(output + "]");
				
			}else{
				Parser.acceptable.setText("<html>Result - Acceptable Regular Expression: <b>False</b></html>" );
					
				Parser.output.setText(output + "]");
			}
		}	
	}
}
