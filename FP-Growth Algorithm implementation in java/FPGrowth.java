package growth;

import java.util.ArrayList;

public class FPGrowth 
{
    FPTree cursor;
    FPTree parent;
    FPTree temp;
    FPTree node;
    ArrayList<FPTree> leaf =new ArrayList();
    int i=0,j=0;    
    public void root(FPTree root)
    {
        
        cursor=root;
        //cursor.parent=null;
        //cursor.children=null;
    }           
    public void addchild(char dat)
    {
        temp= new FPTree(dat);
        node=temp;
        if(cursor.children.isEmpty())
        {               
            cursor.children.add(node);
            cursor.children.get(0).parent=cursor;
          //System.out.println("test"+cursor.data+"node"+cursor.children.get(0)+"parent"+cursor.parent.get(0));
            cursor=cursor.children.get(0);
          //System.out.println(node.data+"--"+cursor.data);
            cursor.count++;
          //System.out.println("--"+cursor.count);
        }
        else 
        {
            //System.out.println("children size"+cursor.children.size());
            for(j=0;j<cursor.children.size();j++)
            { 
           //System.out.println(node.data+"--"+cursor.children.get(j).data);
                if(node.data==cursor.children.get(j).data)
                {
                    //cursor.parent.add(cursor);
                    cursor=cursor.children.get(j);                    
                    cursor.count++;
                    j=99999;
                    break;
                }        
            }//System.out.println("j is"+j);
            //System.out.println("j="+j+","+cursor.children.size());
            if(j==cursor.children.size())
            {
               //System.out.println("test2"+cursor.data+"=="+node.data);
              //cursor.parent.add(cursor);
               cursor.children.add(node);
               cursor.children.get(j).parent=cursor;
               cursor=cursor.children.get(j);
               cursor.count++;
            }           
        }        
    }    
}