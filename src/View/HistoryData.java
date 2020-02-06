package View;

import ModelView.HistoryView;

import java.awt.event.HierarchyBoundsAdapter;
import java.util.List;

public class HistoryData {

    private String start;
    private String end;
    private List<HistoryView> historyViews;

    public HistoryData(String start, String end, List<HistoryView> historyViews) {
        this.start = start;
        this.end = end;
        this.historyViews = historyViews;

    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public List<HistoryView> getHistoryViews() {
        return historyViews;
    }

    public void setHistoryViews(List<HistoryView> historyViews) {
        this.historyViews = historyViews;
    }
}
