package com.workintech.softwareCompany;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }

    public Set<Task> getTasks(String taskOwner){
        if(taskOwner.toLowerCase().equals("bob")){
            return bobsTasks;
        }
        if(taskOwner.toLowerCase().equals("ann")){
            return annsTasks;
        }
        if(taskOwner.toLowerCase().equals("carol")){
            return carolsTasks;
        }
        if(taskOwner.toLowerCase().equals("all")){
            return getUnion(bobsTasks, annsTasks, carolsTasks);
        }
        return new HashSet<>();


    }
    public Set<Task> getUnion(Set<Task>... tasks){
        Set<Task> totals = new LinkedHashSet<>();
        for(Set<Task> taskSet: tasks) {
            totals.addAll(taskSet);
        }
        return totals;
    }
    public Set<Task> getIntersect(Set<Task> first, Set<Task> second){
        Set<Task> intersection = new HashSet<>(first);
        intersection.retainAll(second);
        return intersection;

    }
    public Set<Task> getDifference(Set<Task> first, Set<Task> second){
        Set<Task> differences = new HashSet<>(first);
        differences.removeAll(second);
        return differences;

    }
}
