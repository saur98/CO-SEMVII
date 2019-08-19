import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

public class dm_7 {

	int choice = 0;
	FileReader fin;
	FileWriter fout;
	BufferedReader bin;
	BufferedWriter bout;
	String[] cols;
	ArrayList<String[]> dataList;
	Double initalData[][];
	String line = null;
	int missingCol[];
	float nmin,nmax;
	Hashtable<String, Float> finaldata;
	String[] finaldatas;
	float[] values;

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//System.out.println("hi");
		new dm_7();

	}
	
	public dm_7() throws IOException
	{
		fileRead();
		int flag=0;
		for(String val:dataList.get(1))
		{
			if(flag==1)
				nmin=Integer.valueOf(val);
			else if(flag==2)
				nmax=Integer.valueOf(val);	
			flag++;
		}
		//nmin=Integer.valueOf(dataList[1][1]);
		//nmax=dataList[1][2];
		evaluate();
		
		int i=0;
		finaldatas=new String[finaldata.size()];
		values=new float[finaldata.size()];
		while(finaldata.size()!=0)
		{
			float maxValues=nmin;
			String key="";
			for (String data : finaldata.keySet()) {
				if (finaldata.get(data) > maxValues) {
					//System.out.println(maxValues);
					maxValues = finaldata.get(data);
					key=data;
				}
			}
			
			//System.out.println(key);
			finaldatas[i]=key;
			values[i]=maxValues;
			i++;
			finaldata.remove(key);
			
			//System.out.println(" ");
		}
		
		
		//Collections.sort(finaldata);
		//System.out.println(finaldata);
		for (i=0;i<finaldatas.length;i++)
		{
			System.out.println(finaldatas[i]+" "+values[i]);
		}
	}
	
	private void fileRead() throws IOException {
		dataList = new ArrayList<>();
		fin = new FileReader(new File("assets/range.data"));
		bin = new BufferedReader(fin);

		while ((line = bin.readLine()) != null) {
			cols = line.split(",");
			//System.out.println(cols);
			dataList.add(cols);

		}
		// TODO Auto-generated method stub

	}
	
	private void evaluate() throws IOException {
		int flag=0;
		finaldata = new Hashtable<String, Float>();
		for(String[] rows:dataList)
		{
			if(flag<2)
				flag++;
			else
			{
				fin = new FileReader(new File("assets/"+rows[0]+".data"));
				bin = new BufferedReader(fin);
				while ((line = bin.readLine()) != null) {
					cols=line.split(",");
					float newval = ((Float.valueOf(cols[1])-Float.valueOf(rows[1]))/(Float.valueOf(rows[2])-Float.valueOf(rows[1])))*(nmax-nmin)+nmin;
					//String[] values = new String[2];
					//System.out.println(cols[1]+" "+rows[1]+" "+rows[2]+" "+nmin+" "+nmax+newval);
					//values[0]=cols[0];
					//values[1]=String.valueOf(newval);
					//System.out.println(values[0]+" "+values[1]);
					finaldata.put(cols[0],newval);
					
				}
			}
		}
	}

}
