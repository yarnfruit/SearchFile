package searchfile;

import java.io.*;
import java.util.*;

/**
 *
 * @author KG
 */
class MyFile {

        ArrayList<String> fileContents = new ArrayList(); //container for file contents
        String filePath; //container for file path

        public void fileLocate(String path) {//pass in a string and assing it to the filePath to be used to look at the file
            this.filePath = path;
        }

        public void fileRead() throws IOException {
            FileReader fileRead = new FileReader(this.filePath); //read the bytes from the text file
            BufferedReader contentRead = new BufferedReader(fileRead); //read the lines from the text 

            for (int i=0; i < 30; i++) {
                this.fileContents.add(contentRead.readLine());
            }
        }

    }
