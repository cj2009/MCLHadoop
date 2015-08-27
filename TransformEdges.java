/*
 * This class takes a raw input file (a list of edges) and transforms the 
 * vertices into integers. In the input, the vertices can be strings of any 
 * format, such as IDs, hex values or anything else, and the output will be a 
 * list of edges consisting of integers only.

 * The mapping is performed as follows: An emtpy hashtable is initialized, and 
 * an integer counter is also initialized to 0. For each edge we process, we 
 * take both of its vertices v1 and v2 and put them in the hashtable, 
 * incrementing the counter each time. If a vertex was previously added to the 
 * hashtable, then we don't add it again. This way, in the end, every single 
 * vertex will have a unique integer corresponding to it.

 */
package transformedges;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * @author hduser
 */
public class TransformEdges {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        // This is the input file:
        String fileName = "edges.txt";
        Path path = Paths.get(fileName);
        BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8);


        // This is the output file:
        File file = new File("new_edges.txt");
        // If file doesnt exist, then create it
        if (!file.exists()) {
                file.createNewFile();
        }
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        
        
        
        String line = null;
        String v1, v2;
        String str[];
        long counter = 0;
        HashMap<String, String> hashtable = new HashMap<>();
        
        while ((line = br.readLine()) != null) {
            if (line.contains(" "))
                str = line.split(" ");
            else
                str = line.split("\t");
            
            if (!hashtable.containsKey(str[0])) {
                hashtable.put(str[0], counter + "");
                counter++;
            }
                
            
            if (!hashtable.containsKey(str[1])) {
                hashtable.put(str[1], counter + "");
                counter++;
            }

            // output the new edge:
            v1 = hashtable.get(str[0]);
            v2 = hashtable.get(str[1]);
            if (v1.compareTo(v2) < 0)
                bw.write(v1 + "\t" + v2 + "\n");
            else
                bw.write(v2 + "\t" + v1 + "\n");
            
        }
        
        bw.close();
        
        System.out.println(counter + " vertices in total.");
        
    }
    
}

