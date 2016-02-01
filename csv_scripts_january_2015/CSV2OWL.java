
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CSV2OWL
{
    public static void main(String[] args) throws IOException
    {
        
        try {
	    
	    String param = args[0];
            
            String inputCSV = "/home/danae/INTRA/taxonomy/IMPRESS_"+param+".csv";
            String outfile = "/home/danae/INTRA/taxonomy/IMPRESS_"+param+".owl";
            String csvLine;
            String impressURL = "http://fp7-impress.eu/";
            String impressNamespace = "impr"+param;
            String declarations = "<?xml version=\"1.0\"?>\n" +
                    "<!DOCTYPE rdf:RDF [\n" +
                    "     <!ENTITY rdfs \"http://www.w3.org/2000/01/rdf-schema#\" >\n" +
                    "     <!ENTITY owl \"http://www.w3.org/2002/07/owl#\" >\n" +
                    "     <!ENTITY xsd \"http://www.w3.org/2001/XMLSchema#\" >\n" +
                    "     <!ENTITY impr"+param+" \"" + impressURL + param+"/\" >\n" +
                    "     <!ENTITY rdf \"http://www.w3.org/1999/02/22-rdf-syntax-ns#\">\n" +
                    "]>\n\n" +
                    
                    
                "<rdf:RDF xmlns=\"http://fp7-impress.eu/"+param+"/\"\n" +
                "     xml:base=\"http://fp7-impress.eu/"+param+"/\"\n" +
                "     xmlns:rdfs=\"http://www.w3.org/2000/01/rdf-schema#\"\n" +
                "     xmlns:owl=\"http://www.w3.org/2002/07/owl#\"\n" +
                "     xmlns:xsd=\"http://www.w3.org/2001/XMLSchema#\"\n" +
                "     xmlns:impr"+param+"=\"" + impressURL + param+"/\"\n" +                    
                "     xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\">\n";

            Hashtable<String,String> namesMatrix = loadClassNames(inputCSV);            
            
            PrintWriter pw = new PrintWriter(outfile);
            BufferedReader br = null;

            br = new BufferedReader(new FileReader(inputCSV));
            br.readLine(); // ignore header line in csv
            br.readLine(); // ignore 1st line since all are read firstly in loadClassesNames
            String[] csvArray = null;
            
            pw.println(declarations);
            pw.flush();
            
            while ((csvLine = br.readLine()) != null)
            {
                csvArray = csvLine.split(",");                
                
                pw.println("<owl:Class rdf:about=\"" + "&" + impressNamespace + ";" + generateEntityName(csvArray[2]) + "\">");
                pw.println("\t<rdfs:subClassOf rdf:resource=\"" + "&" + impressNamespace + ";" + namesMatrix.get(csvArray[1])  + "\"/>");

                if(csvArray.length > 2)
                    pw.println("\t<rdfs:label>"   + generateEntityName(csvArray[2])  + "</rdfs:label>");
                if(csvArray.length > 3)
                    pw.println("\t<rdfs:comment>" + csvArray[3]  + "</rdfs:comment>");
                
                pw.println("</owl:Class>");
                pw.flush();
                
            }   
            
            pw.println("</rdf:RDF>");
            pw.close();
            br.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSV2OWL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Hashtable<String,String> loadClassNames(String inputCSV) throws IOException
    {
            Hashtable<String,String> namesMatrix = new Hashtable<>();
            BufferedReader br = null;
            String csvLine;            

            br = new BufferedReader(new FileReader(inputCSV));
            br.readLine();
            csvLine = br.readLine();
            String[] csvArray = csvLine.split(",");
            
            //namesMatrix.put(csvArray[0], csvArray[2].replace(" ", "_"));
            namesMatrix.put(csvArray[0], generateEntityName(csvArray[2]));
            
            while ((csvLine = br.readLine()) != null)
            {
                csvArray = csvLine.split(",");
                System.err.println(csvLine + " " + csvArray.length);                
                //namesMatrix.put(csvArray[0], csvArray[2].replace(" ", "_")); 
                namesMatrix.put(csvArray[0], generateEntityName(csvArray[2]));
                System.err.println(csvLine + " " + generateEntityName(csvArray[2]));
            }   
            
            br.close();
            
            return namesMatrix;
    }
    
    public static String generateEntityName(String source){
    
      StringBuffer res = new StringBuffer();

      String[] strArr = source.split(" ");
      for (String str : strArr) {
	  char[] stringArray = str.trim().toCharArray();
	  
	  if(stringArray.length>0){
	    stringArray[0] = Character.toUpperCase(stringArray[0]);
	  }
	  
	  str = new String(stringArray);

	  res.append(str);
      }
      
      return res.toString().trim();  
    
    
    }
}
