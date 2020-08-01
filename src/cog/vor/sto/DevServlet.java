package cog.vor.sto;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DevServlet
 */
public class DevServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String button = request.getParameter("button-clicked");
		System.out.println(button);
		
		Hashtable<String, String> ht = new Hashtable<String, String>();
		  
		ht.put("ssh root@192.168.1.11 /home/parag/Test/./test1.sh","on-con");
		ht.put("ssh root@192.168.1.11 /home/parag/Test/./test2.sh","off-con");
		ht.put("ssh root@192.168.1.11 /home/parag/Test/./test3.sh","on-ubro");
		ht.put("ssh root@192.168.1.11 /home/parag/Test/./test4.sh","off-ubro");
		/*ht.put("E","na-q19qc9-on");
		ht.put("F","na-q19qc9-off");*/
      
        System.out.println("does hash table has " +button+ " as value : " + ht.containsValue(button));
      
        //finding key corresponding to value in hashtable - one to one mapping
		String key= null;
        String value=button;
        for(Map.Entry<String,String> entry: ht.entrySet()){
            if(value.equals(entry.getValue())){
                key = entry.getKey();
                break; //breaking because its one to one map
            }
        }
        System.out.println("go to following path : "+ key );
		
		try
		{
			Process process = Runtime.getRuntime().exec(key);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.sendRedirect("dev.html");
	}
}
