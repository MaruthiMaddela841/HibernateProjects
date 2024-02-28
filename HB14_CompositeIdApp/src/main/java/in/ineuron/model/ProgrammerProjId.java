package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ProgrammerProjId implements Serializable{

	private static final long serialVersionUID = 1L;
		private Integer pid;
		private Integer ProjId;
		
		public Integer getPid() {
			return pid;
		}

		public void setPid(Integer pid) {
			this.pid = pid;
		}

		public Integer getProjId() {
			return ProjId;
		}

		public void setProjId(Integer projId) {
			ProjId = projId;
		}

		@Override
		public String toString() {
			return "ProgrammerProjId [pid=" + pid + ", ProjId=" + ProjId + "]";
		}
		
		
}
