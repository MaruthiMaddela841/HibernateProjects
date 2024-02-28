package in.ineuron.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		//@SequenceGenerator(name="gen1",sequenceName="JPA_SID_SEQ",inititalValue=5,allocationSize=5)->for orcale
		//@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)-> for oracle
		private Integer sid;
		@Column(name="stdName",length=20)
		private String sname;
		@Column(name="stdAddress",length=20)
		private String saddress;
		@Column(name="stdAge")
		private Integer sage;
		
		
		public Student() {
			System.out.println("Hibernate uses zero argument constructor internally..");
		}
		public Integer getSid() {
			return sid;
		}
		public void setSid(Integer sid) {
			this.sid = sid;
		}
		public String getSname() {
			return sname;
		}
		public void setSname(String sname) {
			this.sname = sname;
		}
		public String getSaddress() {
			return saddress;
		}
		public void setSaddress(String saddress) {
			this.saddress = saddress;
		}
		public Integer getSage() {
			return sage;
		}
		public void setSage(Integer sage) {
			this.sage = sage;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "ID:"+sid+",SNAME:"+sname+",ADDR:"+saddress+",SAGE"+sage;
		}
		
		

}
