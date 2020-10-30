import java.util.*;
import java.lang.*;
import java.io.*;

class Fun 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
        int num_of_tweet=sc.nextInt(); //No. of tweets as an input.
		sc.nextLine();
        String ip="";//String to store concatenation of all the tweets 
		for(int i=0;i<num_of_tweet;i++)
		{
			ip=ip+sc.nextLine()+" ";
		}
        String[] arr=ip.split(" ");//Array to store all the words, separated by space.
        //Hashmap to keep track of the count of each hashtag
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        //extracting hashtag from tweets' text
        for(String x:arr)
        {
            if(x.charAt(0)=='#')
            {
                if(!map.containsKey(x))//if the particular hashtag is seen the first time 
                	map.put(x,1);
                else //if the hashtag is seen before, increase its count
                	map.put(x,map.get(x)+1);
            }
        }
        int mx=-1;//Variable to store the maximum frequency of a hashtag
        for(String i : map.keySet()) 
        {
            mx=Math.max(mx,map.get(i));
        }
        int count=0; //Variable to get only the top 10 hash-tags
        //print the list of top 10 hashtags
        for(int i=mx;i>0;i--)
        {
        	//Using treeset, so that duplicates dont get printed
            TreeSet<String> set=new TreeSet<String>();
            for(String x : map.keySet())
            {
                if(map.get(x)==i) 
                	set.add(x);
            }
            if(set.isEmpty()) 
            	continue;
            else 
            {
                for(String x: set) 
                {
                    count++;//Inceasing the count
                    //Check if top 10 trending hashtags in twitter has exceeded
                    if(count>10) 
                    	break;
                    //Print the hashtags.
                    System.out.println(x);
                }
            }
        }
    }
}
