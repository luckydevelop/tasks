package ua.luckydev.prime.faces.beans;

import org.primefaces.event.ToggleEvent;
import org.primefaces.model.Visibility;
import ua.luckydev.jpa.data.Worker;
import ua.luckydev.spring.service.ServiceImp;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.*;

@ManagedBean(name = "personneBean")
//@SessionScoped //?!?!?!?!? //Serialisation
@ViewScoped
public class PersonneBean implements Serializable
{

    @ManagedProperty("#{serviceImp}")
    ServiceImp serviceImp;
    private Worker worker;
    private List<Worker> listWorkers;
    private List<Boolean> listWorkersIsVisible;

    private List<String> workersOfManager;


   public List<String> getWorkersOfManagers(String managerFIO)
   //
   // public List<String> getWorkersOfManagers(String managerFIO)
    {
        workersOfManager = new ArrayList<String>();
        System.out.println(managerFIO);
//        workersOfManager.add("1");
//        workersOfManager.add("2");
//        if(managerFIO.equals(null)) return null;


        for (Worker listWorker : listWorkers)
        {
           // if(managerFIO.equals(null)) return null;
            if(listWorker.getPosition().equals("Рабочий")&&listWorker.getManager().equals(managerFIO)) //enum
            {
                workersOfManager.add(listWorker.getFio());
                System.out.println(listWorker.getFio());
            }

        }
        return workersOfManager;
    }

//    public List<String> getWorkersOfManagers()
//    {
//        workersOfManager.add("1");
//        workersOfManager.add("2");
//        return workersOfManager;
//    }
//
//
//    public void setWorkersOfManagers(List<Worker> workersOfManagers)
//    {
//        workersOfManagers = workersOfManagers;
//    }

    private List<String> positions = new ArrayList<String>();

    public List<String> getPositions() {
        for (Worker listWorker : listWorkers) {
            String pos = listWorker.getPosition();

            if(pos.matches(".+")&(!positions.contains(pos)))
            {
                positions.add(pos);
            }
        }
        Collections.sort(positions);
        return positions;
    }



    public void setPositions(List<String> positions) {
        this.positions = positions;
    }

    public List<Boolean> getListWorkersIsVisible() {
        return listWorkersIsVisible;
    }

    public void setListWorkersIsVisible(List<Boolean> listWorkersIsVisible) {
        this.listWorkersIsVisible = listWorkersIsVisible;
    }

    private List<Worker> filteredWorkers;

    public PersonneBean()
    {

    }

    @PostConstruct
    public void init()
    {
        listWorkers = new ArrayList<Worker>();
        listWorkers.addAll(serviceImp.listWorkers());

        listWorkersIsVisible = new ArrayList<Boolean>();
        listWorkersIsVisible.add(true);
        listWorkersIsVisible.add(true);
        listWorkersIsVisible.add(true);
        listWorkersIsVisible.add(true);
        listWorkersIsVisible.add(true);
        listWorkersIsVisible.add(true);
        listWorkersIsVisible.add(true);
    }



    public void onToggle(ToggleEvent e) {
        listWorkersIsVisible.set((Integer) e.getData(), e.getVisibility() == Visibility.VISIBLE);
    }


    public ServiceImp getServiceImp()
    {
        return serviceImp;
    }

    public void setServiceImp(ServiceImp serviceImp)
    {
        this.serviceImp = serviceImp;
    }

    public Worker getWorker()
    {
        return worker;
    }

    public void setWorker(Worker worker)
    {
        this.worker = worker;
    }

    public void setListWorkers(List<Worker> listWorkers)
    {
        this.listWorkers = listWorkers;
    }

    public List<Worker> getListWorkers()
    {
        return listWorkers;
    }


    public void addEvent(ActionEvent actionEvent)
    {
        this.worker = new Worker();
    }

    public void actionAddWorker(ActionEvent actionEvent)
    {
        addWorker();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Рабочий добавлен"));
        init();
        this.worker = new Worker();
    }

    public void editeEvent(int id)
    {
        this.worker = serviceImp.getWorker(id);


    }

    public void updatePerson(ActionEvent actionEvent)
    {
        serviceImp.updateWorker(worker);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Personne mise ? jour"));
        init();
    }

    public void delete(Worker worker)
    {
        System.out.println(worker);
        serviceImp.deleteWorker(worker);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Personne supprim?"));
        init();
    }

    public String addWorker()
    {
        // Calling Business Service
        serviceImp.addWorker(worker);
        // Add message
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("The Employee " + this.worker.getFio() + " Is Registered Successfully"));
        return "";
    }

    public void deletMessage(ActionEvent actionEvent)
    {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Personne supprim?"));
    }
}