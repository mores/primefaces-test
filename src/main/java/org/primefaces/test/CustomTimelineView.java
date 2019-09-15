package org.primefaces.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
    private Map<String,String> colors;

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
        String[] NAMES = new String[] {"User 1", "User 2", "User 3", "User 4", "User 5", "User 6"};

        // create timeline model
        model = new TimelineModel();

	colors = new HashMap<>();
	colors.put("unavailable", "#F03030");
	colors.put("available", "#1AA11A" );
	colors.put("maybe", "#FFA500" );
	colors.put("ready", "#150578" );
	colors.put("call", "#78C0E0" );
	colors.put("order", "#AAA95A");

	int job = 1; 
        for (String name : NAMES) {
            now = new Date();
            Date end = new Date(now.getTime() - 12 * 60 * 60 * 1000);

            for (int i = 0; i < 15; i++) {
                Date start = new Date(end.getTime() + Math.round(Math.random() * 5) * 60 * 60 * 1000);
                end = new Date(start.getTime() + Math.round(4 + Math.random() * 5) * 60 * 60 * 1000);

                int r = (int)Math.round(Math.random() * 5);
		ArrayList<String> keyList = new ArrayList<String>(colors.keySet());

                // create an event with content, start / end dates, editable flag, group name and custom style class
                TimelineEvent event = new TimelineEvent("Job: " + job, start, end, true, name, keyList.get(r));
                model.add(event);

		job++;
            }
        }
    }

    public String getCss() {

	    String css = "";
	    for (Map.Entry<String, String> entry : colors.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();

		    css = css + "div." + key + " {\n";
		    css = css + "background: " + value + " none !important;\n";
		    css = css + "}\n";
	    }

	    return css;
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
