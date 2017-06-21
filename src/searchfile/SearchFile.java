package searchfile;

import java.io.*;

/**
 *
 * @author KG
 * 
 * This is a practice program. It reads lines in a text file and returns the lines that match the phrase of user input.
 * 
 * 1. Program reads an input file
 * 2. Save data to memory
 * 3. Program accepts input from User
 * 4. Program compares user inputed string to file data stored in memory
 * 5. Return lines that contain the phrase and:
 * 6. Return contents of lines that contain the phrase and:
 * 7. Return the number of times the phrase appears
 * 
 * improvements: I think the two classes might be redundant.
 *               The user should be able to specify the file path.
 *               The amount of lines to search should also be specified by the user.
 */
public class SearchFile {
    
    String searchString;
    
    public void userInputStream() {
        InputStreamReader userStream = new InputStreamReader(System.in);
        BufferedReader inputReader = new BufferedReader(userStream);
        
        try {
            this.searchString = inputReader.readLine(); //get user input and save it to memory
        }
        catch (IOException e){
            System.out.println(e.getMessage());
            this.searchString = "unable to capture user search input";
        }
    }
    
    public static void main(String[] args) {
       
        SearchFile mysearch = new SearchFile(); //new instance of Search File
        
        MyFile file = new MyFile(); //new instance of MyFile
        
        file.fileLocate("F:\\__development\\test.txt"); //todo: ask for path from user
        
        try {
            file.fileRead(); //read the file specified in the path and put it in memory
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        //begin user input
        System.out.println("Input a search phrase:");
        mysearch.userInputStream();

        int totalLinesFound = 0; //counter for total lines that match the search phrase
        
        //loop through lines and return matching lines
        for (int i = 0; i < 30; i++) {
            String line;
            line = file.fileContents.get(i);
            if(line.contains(mysearch.searchString)) {
                System.out.println("Line " + ( i + 1 ) + ": " + line);
                totalLinesFound++;
            }
        }
        
        System.out.println("Search complete. " + totalLinesFound + " lines were found containing the phrase: " +mysearch.searchString + ".");
    }
}
