package DTO;

import java.sql.Date;

public class BoardDTO {
		private int bnumber;
		private String bwriter;
		private String btitle;
		private String bcontents;
		private Date bdate;
		private int bhits;
		private String bfilename;
		private String bpassword;
		
		public BoardDTO() {
			
		}

		public int getBnumber() {
			return bnumber;
		}

		public void setBnumber(int bnumber) {
			this.bnumber = bnumber;
		}

		public String getBwriter() {
			return bwriter;
		}

		public void setBwriter(String bwriter) {
			this.bwriter = bwriter;
		}

		public String getBtitle() {
			return btitle;
		}

		public void setBtitle(String btitle) {
			this.btitle = btitle;
		}

		public String getBcontents() {
			return bcontents;
		}

		public void setBcontents(String bcontents) {
			this.bcontents = bcontents;
		}

		public Date getBdate() {
			return bdate;
		}

		public void setBdate(Date bdate) {
			this.bdate = bdate;
		}

		public int getBhits() {
			return bhits;
		}

		public void setBhits(int bhits) {
			this.bhits = bhits;
		}

		public String getBfilename() {
			return bfilename;
		}

		public void setBfilename(String bfilename) {
			this.bfilename = bfilename;
		}

		public String getBpassword() {
			return bpassword;
		}

		public void setBpassword(String bpassword) {
			this.bpassword = bpassword;
		}

		public BoardDTO(int bnumber, String bwriter, String btitle, String bcontents, Date bdate, int bhits,
				String bfilename, String bpassword) {
			super();
			this.bnumber = bnumber;
			this.bwriter = bwriter;
			this.btitle = btitle;
			this.bcontents = bcontents;
			this.bdate = bdate;
			this.bhits = bhits;
			this.bfilename = bfilename;
			this.bpassword = bpassword;
		}

		@Override
		public String toString() {
			return "BoardDTO [bnumber=" + bnumber + ", bwriter=" + bwriter + ", btitle=" + btitle + ", bcontents="
					+ bcontents + ", bdate=" + bdate + ", bhits=" + bhits + ", bfilename=" + bfilename + ", bpassword="
					+ bpassword + "]";
		}

}