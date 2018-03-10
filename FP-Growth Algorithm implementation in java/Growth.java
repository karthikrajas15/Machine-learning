
package growth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;

public class Growth
{
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {        
        FPGrowth tree = new FPGrowth();
        FPTree root= new FPTree('h');
        try
        {            
            FileReader fr = new FileReader("C:/input.txt");
            PrintStream out = new PrintStream("output.txt");
            BufferedReader br = new BufferedReader(fr);
            String s="";
            char r2[];
            int i=0,j=0,k=0;
            int n=0;
            int countarr[] = new int[50];
            char p[];
            char l[] = new char[50];
            char c[][]=new char[50][12];
            int z[]=new int[50];
            while((s = br.readLine()) != null) 
            {
                r2=s.toCharArray();
                n=r2.length;
                for(j=0;j<n;j++)
                {
                c[i][j]=r2[j];
               //System.out.print(""+c[i][j]);
                if(i==0&&j==0)
                {
                    l[0]=c[i][j];
                }
                else
                {
                    for(k=0;l[k]!='\0';k++)
                    {
                        if(l[k]==c[i][j])
                        {
                            break;
                        }
                        else if(l[k+1]=='\0')
                        {
                            l[k+1]=c[i][j];
                        }
                    }
           
                }
                }
                i++;
                //System.out.print("\n");
            } 
            /*System.out.println("Available letters in the file ");
            for(k=0;l[k]!='\0';k++)
            {
                System.out.println(l[k]);
            }*/          
            //System.out.println("num value"+num);
            for(k=0;l[k]!='\0';k++)
            {
                int count=0;
                i=0;
                while((c[i][0])!= '\0')
                {   
                    for(j=0;j<n;j++)
                    {         
                        if(c[i][j]==l[k])
                        {
                           count++;
                        }
                    }
                    i++;                    
                }
                countarr[k]=count;                                
            }
            /*System.out.println("Counts of l[]");
            for(k=0;l[k]!='\0';k++)
            {
                System.out.println(countarr[k]);
            }*/
            for(i=0;countarr[i]!='\0';i++)
            {
                for(j=i+1;countarr[j]!='\0';j++)
                {
                    if(countarr[i]<countarr[j])
                    {
                        int temp=countarr[i];
                        countarr[i]=countarr[j];
                        countarr[j]=temp;
                        char temp1=l[i];
                        l[i]=l[j];
                        l[j]=temp1;
                    }                      
                }                
            }
            /*System.out.println("reordered countarr");
            for(i=0;countarr[i]!='\0';i++)
            {
                System.out.println(countarr[i]);
            }
            System.out.println("reordered l[]");
            for(i=0;countarr[i]!='\0';i++)
            {
                System.out.println(l[i]);
            }*/
            i=0;
            while((c[i][0])!= '\0')
            {   
                for(j=0;j<n;j++)
                {         
                z[j]=new String(l).indexOf(c[i][j]);
                //System.out.println("index value"+i+z[j]);
                }                
                for (k = 0; k < n; k++) 
                {
                    for (j = k + 1; j < n; j++) 
                    {
                        if (z[k] > z[j]) 
                        {
                            int temp = z[k];
                            char temp1=c[i][k];
                            z[k] = z[j];
                            c[i][k]=c[i][j];
                            z[j] = temp;
                            c[i][j]=temp1;                            
                        }
                    }                
                }
                /*System.out.println("ascending index");
                for(j=0;j<n;j++)
                {
                System.out.println(z[j]);
                }*/
                i++;
            }
            i=0;
            while((c[i][0])!= '\0')
            {   
                tree.root(root);                
                for(j=0;j<n;j++)
                {                    
                    //System.out.println("data"+c[i][j]);
                    tree.addchild(c[i][j]);  
                 
                }
                if(tree.cursor!=null)
                {
                    if(tree.leaf.size()==0)
                        {
                            tree.leaf.add(tree.cursor);
                        }
                    else
                    {
                        int x;
                    for(x=0;x<tree.leaf.size();x++)
                    {
                        
                        if(tree.cursor==tree.leaf.get(x))
                        {
                        x=9999;
                        }
                    }
                    if(x==tree.leaf.size())
                    {
                        tree.leaf.add(tree.cursor);   
                    }
                    }
                }
                i++;
            }
           /*for(int m=0;m<tree.leaf.size();m++)
           {
            System.out.println("the leaf"+tree.leaf.get(m).data);
           }*/
           for(int m=0;m<tree.leaf.size();m++)
           {
               //System.out.println("values"+tree.leaf.get(m).data);
                if(tree.leaf.get(m).count>=2)
                {
                    String freq="";
                    tree.cursor=tree.leaf.get(m);
                    while(tree.cursor.data!='h')
                    {
                        freq=tree.cursor.data+freq;
                    //System.out.println("support values"+tree.cursor.data);
                        tree.cursor=tree.cursor.parent;
                   // tree.cursor=tree.leaf.get(m);
                    }
                    System.out.println("Frequent Patten"+freq);
                    out.println(freq);               
                }
           }
            //System.out.println(root.children.get(0).children.get(1).children.get(1).count);                
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}