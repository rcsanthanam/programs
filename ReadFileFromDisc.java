/**
Read text file from disc and count the words
*/

import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.function.*;

public class ReadFileFromDisc{
	
	public static void main(String[] args) throws Exception{
		String path = "sample.txt";
		readFile8(path);
	}
	
	public static void readFile8(String path) throws Exception{
		Stream<String> lines = Files.lines(Paths.get(path));
		lines.map(line -> line.split("[\\s\\.]+"))
		     .flatMap(e-> Arrays.stream(e))
			 .filter(Objects::nonNull)
			 .map(item->item.replaceAll("[^A-Za-z0-9]",""))			 
             .filter(Predicate.not(String::isEmpty))
			 .filter(item-> !item.trim().isEmpty())			 
			 .collect(Collectors.toMap(x->x,x->1,Integer::sum,()->new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER)))
             .forEach((k,v)->{
				 System.out.printf("%-10s  %d\n",k,v);
			 });
	}
	
	public static void readFile(String path){
		InputStream in = null;
		Reader r = null;
		BufferedReader br = null;
		try{
			in = new FileInputStream(path);
			r = new InputStreamReader(in,"UTF-8");
			br = new BufferedReader(r);
			
			String line;
			
			while((line = br.readLine()) != null){
				if(line.contains("class")){
					System.out.println("Yes...");
				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
				if(br!=null){
					br.close();
				}
			}catch(Throwable t){
					
				}
			
			try{
				if(r != null){
					r.close();
				}
			}catch(Throwable t){
					
				}
			
			try{
				if(in != null){
					in.close();
				}
			}catch(Throwable t){
					
				}
		}
	}
}
