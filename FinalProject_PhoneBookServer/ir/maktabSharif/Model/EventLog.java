package ir.maktabSharif.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "eventlogtable")
public class EventLog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "eventLogId")
	private int eventLogId;

	
	@Column(name = "logType")
	private String logType;

	@Column(name = "eventDescription")
	private String eventDescription;

	public int getEventLogId() {
		return eventLogId;
	}

	public void setEventLogId(int eventLogId) {
		this.eventLogId = eventLogId;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

}
