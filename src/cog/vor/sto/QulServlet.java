package cog.vor.sto;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QulServlet
 */
public class QulServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QulServlet() {
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
		ht.put("ssh root@192.168.1.11 /home/parag/Test/./test1.sh","na-q10qc0-on");/*1*/
		ht.put("ssh root@192.168.1.11 /home/parag/Test/./test2.sh","na-q10qc0-off");/*2*/
		ht.put("ssh root@192.168.1.11 /home/parag/Test/./test3.sh","na-q01q20-on");/*3*/
		ht.put("ssh root@192.168.1.11 /home/parag/Test/./test4.sh","na-q01q20-off");/*4*/
		/*
		ht.put("--Path to execute--","na-q19qc9-on");
		ht.put("--Path to execute--","na-q19qc9-off");
		ht.put("--Path to execute--","na-q04q21-on");
		ht.put("--Path to execute--","na-q04q21-off");
		*/
		
		/*----------------------------------------------------------------------------------*/
		//Controller
		/*
		ht.put("--Path to execute--","c-q10qc0-on");
		ht.put("--Path to execute--","c-q10qc0-off");
		ht.put("--Path to execute--","c-q01q20-on");
		ht.put("--Path to execute--","c-q01q20-off");
		ht.put("--Path to execute--","c-q19qc9-on");
		ht.put("--Path to execute--","c-q19qc9-off");
		ht.put("--Path to execute--","c-q04q21-on");
		ht.put("--Path to execute--","c-q04q21-off");
		*/
		
		/*-----------------------------------------------------------------------------------*/
		//Single Agents
		/*
		ht.put("--Path to execute--","sa-q10-on");
		ht.put("--Path to execute--","sa-q10-off");
		ht.put("--Path to execute--","sa-qc0-on");
		ht.put("--Path to execute--","sa-qc0-off");
		ht.put("--Path to execute--","sa-q19-on");
		ht.put("--Path to execute--","sa-q19-off");
		ht.put("--Path to execute--","sa-qc9-on");
		ht.put("--Path to execute--","sa-qc9-off");
		ht.put("--Path to execute--","sa-q01-on");
		ht.put("--Path to execute--","sa-q01-off");
		ht.put("--Path to execute--","sa-q20-on");
		ht.put("--Path to execute--","sa-q20-off");
		ht.put("--Path to execute--","sa-q04-on");
		ht.put("--Path to execute--","sa-q04-off");
		ht.put("--Path to execute--","sa-q21-on");
		ht.put("--Path to execute--","sa-q21-off");
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
		response.sendRedirect("qul.html");
	}
}
