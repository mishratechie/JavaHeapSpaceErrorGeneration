package withStringArray;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
 
public class JavaHeapSpaceErrorProduce {
 
  public static void main(String argv[]) throws IOException {
   
	  
	  JavaHeapSpaceErrorProduce r=new JavaHeapSpaceErrorProduce();
	 	 
	  String outputarray = null;
	  LinkedHashMap <String, String> valueDetails = new LinkedHashMap <String, String>();
	  
	  //project
	  valueDetails.put("/report/summary/project", "@name");
	 //users
	  valueDetails.put("/report/populations_statistics/global_statistics/statistic[8]","@value");
	  
	  //zone statistc
	  valueDetails.put("/report/zones_statistics/global_statistics/statistic[7]", "@value");
	  valueDetails.put("/report/zones_statistics/global_statistics/statistic[8]", "@value");
	    
	  valueDetails.put("/report/zones_statistics/global_statistics/statistic[11]", "@value");
	  valueDetails.put("/report/zones_statistics/global_statistics/statistic[10]", "@value");
	  valueDetails.put("/report/zones_statistics/global_statistics/statistic[12]", "@value");
	  //Average request response time
	  valueDetails.put("/report/dashboards/dashboard[1]/graph[2]/statistic-item", "@avg");
	  //Average page response time
	  valueDetails.put("/report/dashboards/dashboard[1]/graph[1]/statistic-item", "@avg");
	  //Average throughput
	  valueDetails.put("/report/zones_statistics/global_statistics/statistic[6]", "@value");
	  valueDetails.put("/report/zones_statistics/global_statistics/statistic[6]", "@unit");
	  //Average hits per second
	  valueDetails.put("/report/zones_statistics/global_statistics/statistic[2]", "@value");
	  
	  //port1
	  valueDetails.put("/report/servers/server[1]", "@host");
	  valueDetails.put("/report/servers/server[1]", "@port");
	  //port2
	  valueDetails.put("/report/servers/server[2]", "@host");
	  valueDetails.put("/report/servers/server[2]", "@port");
	  
	  
	  
	  System.out.println("Total valueDetails: " + valueDetails.size());
  
	  File file = new File("test.txt");  
	  FileOutputStream fis = new FileOutputStream(file);  
	  PrintStream out = new PrintStream(fis);  
	  System.setOut(out);  
	  
	  for(String key: valueDetails.keySet())
	  {
		  
		  outputarray=r.printshow(key, valueDetails.get(key)); 
		  System.out.println(outputarray);
		 
		 
	  }
	  
	r.readfile();
		
	
      

		// Clear all values.
		valueDetails.clear();
		    
		 // Equals to zero.
		System.out.println("After clear operation, size: " + valueDetails.size()); 
		 
	  
	  // best site to get xpath generated http://xmlgrid.net/ -use firefox
	  
  }
  
  public void readfile() throws IOException{
	  
	  
	  BufferedReader br = new BufferedReader(new FileReader("test.txt"));
      String line = "";
      StringTokenizer st = null;
      int lineNumber = 0; 
      int tokenNumber = 0;
     
		while ((line = br.readLine()) != null) {
		    lineNumber++;
		    System.out.println(br.readLine());
		    
		  }
  }
  
public String printshow(String cs,String cs2){
	String Finaloutput = null;
	
	try {

		

	        XPathFactory xPathFactory = XPathFactory.newInstance();
	        XPath xPath = xPathFactory.newXPath();

	        InputSource doc = new InputSource(new InputStreamReader(new FileInputStream(new File("report-Jul-23-15_19.xml"))));

	        XPathExpression xPathExpression = xPath.compile(cs);

	        NodeList elem1List = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
	        xPathExpression = xPath.compile(cs2);


	        for (int i = 0; i < elem1List.getLength(); i++)
	        {
	            //System.out.println(xPathExpression.evaluate(elem1List.item(i), XPathConstants.STRING));
	        	Finaloutput = (String) xPathExpression.evaluate(elem1List.item(i), XPathConstants.STRING);
	        }


	        }
	  
	  		
	        catch (XPathExpressionException e)
	        {	            
	            e.printStackTrace();
	        } catch (FileNotFoundException e) {
	         
	            e.printStackTrace();
	        }
	return Finaloutput;
	
}

}