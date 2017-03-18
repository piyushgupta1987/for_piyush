package com.symantec.partyservice.pojo;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

public class SiperianSystemObjects {
	
		protected String pkeySrcObject;
		protected Date lastUpdateDate;
				
		public String getPkeySrcObject() {
			return pkeySrcObject;
		}
		public void setPkeySrcObject(String pkeySrcObject) {
			this.pkeySrcObject = pkeySrcObject;
		}
		
		public Date getLastUpdateDate() {
			return lastUpdateDate;
		}
		public void setLastUpdateDate(Date lastUpdateDate) {
			this.lastUpdateDate = lastUpdateDate;
		}
		@Override
		public String toString() {
			return "SiperianSystemObjects [pkeySrcObject=" + pkeySrcObject
					+ ", lastUpdateDate=" + lastUpdateDate + "]";
		}
				
	}
