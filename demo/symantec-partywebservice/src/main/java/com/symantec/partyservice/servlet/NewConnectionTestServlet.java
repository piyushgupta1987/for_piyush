package com.symantec.partyservice.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siperian.sif.client.SiperianClient;
import com.symantec.partyservice.pojo.MdmCredential;
import com.symantec.partyservice.utility.SymantecSIPClient;

public class NewConnectionTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewConnectionTestServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//geting the credential from UI as a POST
		MdmCredential mdmCredential = new MdmCredential();
		mdmCredential.setUsername((String)request.getParameter("username"));
		mdmCredential.setPassword((String)request.getParameter("password"));
		
		//calling the new sifClient method , which will suppose to pick the details from properties file
		SiperianClient sifClient = new SymantecSIPClient()	.getEjbSifClient(mdmCredential);
		
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		if (sifClient != null){
			out.print("<h2> CONNECTION SUCCESSFUL with user : </h2>" + mdmCredential.getUsername());
		}
		else{
			out.print("<h2> Unauthorised user, you don't have sufficient permission for mdm access, please contact the mdm administrator</h2>");
		}
		out.print("<a href ='./index.html'>back to homepage</a>");
		out.print("</body></html>");
	}
}
