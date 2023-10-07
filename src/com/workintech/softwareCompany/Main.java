package com.workintech.softwareCompany;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Task task1 = new Task("Java Collection", "write list description", "Ann", Priority.LOW, Status.IN_QUEUE);
        Task task2 = new Task("Java Collection", "Set list description", "Ann", Priority.MED, Status.ASSIGNED);
        Task task3 = new Task("Java Collection", "Map list description", "Bob", Priority.HIGH, Status.IN_QUEUE);
        Task task4 = new Task("Java Collection", "Write Queue Interface", "Carol", Priority.LOW, Status.ASSIGNED);
        Task task5 = new Task("Java Collection", "Write Stack Interface", "Carol ", Priority.MED, Status.IN_QUEUE);
        Task task6 = new Task("Java Collection", "what is abstract class", "Dogancan ", Priority.MED, Status.IN_QUEUE);

        Set<Task> totalTasks = new HashSet<>();
        totalTasks.add(task1);
        totalTasks.add(task2);
        totalTasks.add(task3);
        totalTasks.add(task4);
        totalTasks.add(task5);
        totalTasks.add(task6);

        Set<Task> annsTasks = new LinkedHashSet<>();
        annsTasks.add(task1);
        annsTasks.add(task2);

        Set<Task> bobsTasks = new LinkedHashSet<>();
        bobsTasks.add(task3);


        Set<Task> carolsTasks = new LinkedHashSet<>();
        carolsTasks.add(task4);
        carolsTasks.add(task5);

        Set<Task> unassignedTasks = new LinkedHashSet<>();
        unassignedTasks.add(task6);

        TaskData taskData = new TaskData(annsTasks, bobsTasks, carolsTasks, unassignedTasks);
        System.out.println("********************************");
        System.out.println("ALL TASKS: ");
        System.out.println(taskData.getTasks("all").size());
        System.out.println("*********************************");
        System.out.println("ANNS TASKS: " +  taskData.getAnnsTasks());
        System.out.println("BOBS TASKS: " +  taskData.getBobsTasks());
        System.out.println("CAROL TASKS: " +  taskData.getCarolsTasks() );
        System.out.println("*********************************");
        System.out.println(taskData.getDifference(totalTasks, taskData.getTasks("All")));
        System.out.println("*********************************");
        System.out.println("Ann+Carol"+ taskData.getIntersect(annsTasks, carolsTasks));
        System.out.println("BOB+CAROL :" + taskData.getIntersect(bobsTasks, carolsTasks));
        System.out.println("ANN+BOB :" + taskData.getIntersect(annsTasks, bobsTasks));


    }
}