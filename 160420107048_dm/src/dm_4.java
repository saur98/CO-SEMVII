import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class dm_4 {

	FileReader fin;
	FileWriter fout;
	BufferedReader bin;
	BufferedWriter bout;
	String[] cols;
	ArrayList<String[]> dataList;
	String line = null;
	int binsize,nbin;
	ArrayList<Integer> data;
	ArrayList<Double> finaldata;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new dm_4();

	}
	
	public dm_4() throws IOException
	{
		fileRead();
		System.out.println(dataList);
		data = new ArrayList<>();
		for(String val:dataList.get(0))
			data.add(Integer.valueOf(val));
		Collections.sort(data);
		//System.out.println(data);
		int length = data.size();
		int min=length;
		for(int i=1;i<length/2;i++)
		{
			if(length%i==0)
			{
				int check=Math.abs(length/i-i);
				if(min>check)
				{	
					min=check;
					binsize=i;
					nbin=length/i;
				}
			}
		}
		//System.out.println(binsize);
		normalizeBins(2);
	}
	
	private void normalizeBins(int choice) 
	{
		if(choice==0)
		{
			finaldata=new ArrayList<>();
			for(int i=0;i<binsize*nbin;)
			{
				int sum=0;
				for(int j=0;j<binsize;j++)
					sum+=data.get(i++);
				//System.out.println(sum/binsize);
				for(int j=0;j<binsize;j++)
					finaldata.add((double)sum/(double)binsize);
			}
			System.out.println(finaldata);
		}
		else if(choice==1)
		{
			finaldata=new ArrayList<>();
			if(binsize%2==0)
			{
				for(int i=0;i<binsize*nbin;i+=binsize)
				{
					double median = (data.get(i+binsize/2-1)+data.get(i+binsize/2))/2;
					
					for(int j=0;j<binsize;j++)
						finaldata.add(median);
					//System.out.println(median);
				}
			}
			else
			{
				for(int i=0;i<binsize*nbin;i+=binsize)
				{
					double median = data.get(i+binsize/2);
					for(int j=0;j<binsize;j++)
						finaldata.add(median);
					//System.out.println(median);
				}
			}
			System.out.println(finaldata);
			
		}
		
		
		else
		{
			finaldata=new ArrayList<>();
			for(int i=0;i<nbin;i++)
			{
				for(int j=0;j<binsize;j++)
				{
					//System.out.println(i*binsize);
					if(j==0)
						finaldata.add((double)data.get(i*binsize+j));
					else if(j==(binsize-1))
						finaldata.add((double)data.get(i*binsize+j));
					else
					{
						if(data.get(i*binsize+j)-data.get(i*binsize)>data.get(i*binsize+binsize-1)-data.get(i*binsize+j) )
							finaldata.add((double)data.get(i*binsize+binsize-1));
						else
							finaldata.add((double)data.get(i*binsize));
					}
					
				}
			}
			System.out.println(finaldata);
		}
	}
	
	private void fileRead() throws IOException {
		int i = 0;
		dataList = new ArrayList<>();
		fin = new FileReader(new File("assets/input.data"));
		bin = new BufferedReader(fin);

		while ((line = bin.readLine()) != null) {
			cols = line.split(",");
			//System.out.println(cols);
			dataList.add(cols);

		}
		// TODO Auto-generated method stub

	}

}
