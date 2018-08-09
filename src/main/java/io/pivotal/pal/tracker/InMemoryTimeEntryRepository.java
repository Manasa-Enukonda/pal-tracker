package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private HashMap<Long, TimeEntry> timeEntryMap = new HashMap<>();
    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        long id=timeEntryMap.size()+1;
        timeEntry.setId(id);
        timeEntryMap.put(id,timeEntry);
        return timeEntryMap.get(id);
    }

    @Override
    public TimeEntry find(Long id) {
        return timeEntryMap.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        List<TimeEntry> list = new ArrayList<TimeEntry>(timeEntryMap.values());
        return list;
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        timeEntry.setId(id);
        timeEntryMap.put(id,timeEntry);
        return find(id);
    }

    @Override
    public void delete(Long id)

    {
        timeEntryMap.remove(id);
    }
}

