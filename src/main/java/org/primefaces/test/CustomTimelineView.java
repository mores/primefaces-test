package org.primefaces.test;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.timeline.TimelineModificationEvent;
import org.primefaces.model.timeline.TimelineEvent;
import org.primefaces.model.timeline.TimelineModel;

@ManagedBean(name = "customTimelineView")
@ViewScoped
public class CustomTimelineView implements Serializable {

    private TimelineModel model;
    private Date start;
    private Date end;

    @PostConstruct
    public void init() {
        // set initial start / end dates for the axis of the timeline
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        Date now = new Date();

        cal.setTimeInMillis(now.getTime() - 4 * 60 * 60 * 1000);
        start = cal.getTime();

        cal.setTimeInMillis(now.getTime() + 8 * 60 * 60 * 1000);
        end = cal.getTime();

        // groups
        String[] NAMES = new String[] {"User 1", "User 2", "User 3", "User 4"};

        // create timeline model
        model = new TimelineModel();

	int dbId = 1;
        for (String name : NAMES) {
            now = new Date();
            Date end = new Date(now.getTime() - 12 * 60 * 60 * 1000);

            for (int i = 0; i < 5; i++) {
                Date start = new Date(end.getTime() + Math.round(Math.random() * 5) * 60 * 60 * 1000);
                end = new Date(start.getTime() + Math.round(4 + Math.random() * 5) * 60 * 60 * 1000);

                long r = Math.round(Math.random() * 2);
                String availability = (r == 0 ? "Unavailable" : (r == 1 ? "Available" : "Maybe"));

                // create an event with content, start / end dates, editable flag, group name and custom style class

		TimelineEventObject teo = new TimelineEventObject();
		teo.setName("DataBase Id: " + dbId);
		teo.setLine2(availability);

                TimelineEvent event = new TimelineEvent(teo, start, end, true, name, availability.toLowerCase());
                model.add(event);

		dbId++;
            }
        }
    }

    public TimelineModel getModel() {
        return model;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public void onDelete(TimelineModificationEvent event) {
	System.out.println("onDelete");
    }

    public void onEdit(TimelineModificationEvent event) {
	System.out.println("onEdit");
    }
}
