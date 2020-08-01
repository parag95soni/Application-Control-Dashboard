package cog.vor.sto;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProdServlet
 */
public class ProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String button = request.getParameter("button-clicked");
		System.out.println(button);
		
		Hashtable<String, String> ht = new Hashtable<String, String>();
		//Native agents
		ht.put("ssh root@192.168.1.11 /home/parag/Test/./testp1.sh","na-p10pc0-a-on");/*1*/
		ht.put("ssh root@192.168.1.11 /home/parag/Test/./testp2.sh","na-p10pc0-a-off");/*2*/
		ht.put("ssh root@192.168.1.11 /home/parag/Test/./testp3.sh","na-p10pc0-p-on");/*3*/
		ht.put("ssh root@192.168.1.11 /home/parag/Test/./testp4.sh","na-p10pc0-p-off");/*4*/
		/*ht.put("----------------","na-p01p20-a-on");
		ht.put("----------------","na-p01p20-a-off");
		ht.put("----------------","na-p01p20-p-on");
		ht.put("----------------","na-p01p20-p-off");*/
		
		/*----------------------------------------------------------------------------------*/
		//Controller
		/*
		ht.put("----------------","c-p10pc0-a-on");
		ht.put("----------------","c-p10pc0-a-off");
		ht.put("----------------","c-p10pc0-p-on");
		ht.put("----------------","c-p10pc0-p-off");
		ht.put("----------------","c-p01p20-a-on");
		ht.put("----------------","c-p01p20-a-off");
		ht.put("----------------","c-p01p20-p-on");
		ht.put("----------------","c-p01p20-p-off");
		*/
		
		/*-----------------------------------------------------------------------------------*/
		//Single Agents
		/*
		ht.put("--Path to execute--","sa-p10-on");
		ht.put("--Path to execute--","sa-p10-off");
		ht.put("--Path to execute--","sa-pc0-on");
		ht.put("--Path to execute--","sa-pc0-off");
		ht.put("--Path to execute--","sa-p01-on");
		ht.put("--Path to execute--","sa-p01-off");
		ht.put("--Path to execute--","sa-p20-on");
		ht.put("--Path to execute--","sa-p20-off");
		*/
      
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.sendRedirect("prod.html");
	}
}
