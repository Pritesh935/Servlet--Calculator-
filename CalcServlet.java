//CalcServlet.java
	package com.nit.pc.servlets;

	import java.io.PrintWriter;
	import java.io.IOException;

	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;
	import jakarta.servlet.ServletException;

	public class CalcServlet extends HttpServlet {

		@Override
		protected void service(HttpServletRequest hreq, HttpServletResponse hresp) 
					throws ServletException, IOException {
					
			 //Request processing logic
			String	fno	= hreq.getParameter("fno");
			String	sno	= hreq.getParameter("sno");
			String	button	= hreq.getParameter("button");
			String	res	= "";			
			
			if(button == null) { //for the 1st request
				fno = "";  //replacing null with empty string
				sno = "";  //for diplaying empty text box on browser	
				
			}else { //from the 2nd request onwards
				int a = Integer.parseInt(fno);
				int b = Integer.parseInt(sno);

				switch(button.toUpperCase()) {
				
					case "ADD" : {
						int c = a + b;
						res = "The <strong>addition</strong> result is: <ins>"+c+"</ins>";
						
						break;
					}
					
					case "SUB" : {
						int c = a - b;
						res = "The <strong>substraction</strong> result is: <ins>"+c+"</ins>";
						
						break;
					}
					
					case "MUL" : {
						int c = a * b;
						res = "The <strong>multiplication</strong> result is: <ins>"+c+"</ins>";
						
						break;
					}
					
					case "DIV" : {
						int c = a / b;
						res = "The <strong>division</strong> result is: <ins>"+c+"</ins>";
						
						break;
					}
					default :{
						res = "<span style='color:red'>Unsupported Operation</span><strong>"+button+"</strong>";
					}
				}//switch close
				
			}//else close
			
			//response generation logic
			hresp.setContentType("text/html");
			
			PrintWriter out = hresp.getWriter();
			out.println("<HTML>");
			
			out.println("  <HEAD>");
			out.println("     <link rel='icon' href='./calc.png'/>");
			out.println("     <title>Online Calculator</title>");
			out.println("  </HEAD>");
			
			out.println("  <BODY>");

			out.println("	 <form action='./cs' method='GET'>");
			out.println("     Enter FNO <input type='text' name='fno' value='"+fno+"'> </br>");
			out.println("     Enter SNO <input type='text' name='sno' value='"+sno+"'> </br>");
			out.println("     <input type='submit' name='button' value='Add'> ");
			out.println("     <input type='submit' name='button' value='Sub'> ");
			out.println("     <input type='submit' name='button' value='Mul'> ");
			out.println("     <input type='submit' name='button' value='Div'> ");
			out.println("     <input type='reset' name='button' value='Reset'> ");
			out.println("    </form>");
			
			out.println(res);	
			
			out.println("  </BODY>");

			out.println("</HTML>");
					
		}//service close

	}//class close
