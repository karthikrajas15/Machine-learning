
package growth;

import java.util.ArrayList;

public class FPTree 
{
     FPTree(char item) 
     {
        data = item;
        children = new ArrayList<>();
        count=0;
     }
 char data;
 ArrayList<FPTree> children;
 FPTree parent;
 int count;
}