package com.symantec.partyservice.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.siperian.sif.client.SiperianClient;
import com.symantec.partyservice.utility.SymantecSIPClient;

public class OldConnectionTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger(getClass().getName());

	public OldConnectionTestServlet() {
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			log.info(">>>>>> LOG TEST<<<<<<<<<<<<<<<<<<");
			process(request, response);
		} catch (Exception e) {
			log.error("ERROR OCCURED " + e.getMessage());
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		try {
			log.info(">>>>>> LOG TEST<<<<<<<<<<<<<<<<<<");
			process(request, response);
		} catch (Exception e) {
			log.error("ERROR OCCURED " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void process(HttpServletRequest req, HttpServletResponse res)	throws Exception {
		PrintWriter out = res.getWriter();
		SiperianClient sifClient = new SymantecSIPClient()	.getEjbSiperianClientTEST();
		out.print("<html><body>");
		if (sifClient != null){
			out.print("<h2> CONNECTION SUCCESSFUL</h2>");
		}
		else{
			out.print("<h2> SOME PROBLEM IS THERE , NOT ABLE TO CONNECTC</h2>");
		}
		out.print("<a href ='./index.html'>back to homepage</a>");
		out.print("</body></html>");
	}
}
