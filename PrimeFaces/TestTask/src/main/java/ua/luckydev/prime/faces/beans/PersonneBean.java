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
import javax.faces.event.ValueChangeEvent;
import javax.swing.event.ChangeListener;
import java.io.Serializable;
import java.util.*;

@ManagedBean(name = "personneBean")
@SessionScoped //?!?!?!?!? //Serialisation
//@ViewScoped
public class PersonneBean implements Serializable
{

    @ManagedProperty("#{serviceImp}")
    ServiceImp serviceImp;
    private Worker worker;
    private List<Worker> listWorkers;
    private List<String> listManagers;
    private List<Boolean> listWorkersIsVisible;

    private List<String> workersOfManager;


    public List<String> getListManagers()

    {
        listManagers = new ArrayList<String>();
        for (Worker worker : listWorkers)
        {
            if(worker.getPosition().equals("Менеджер")) //enum
            {
                listManagers.add(worker.getFio());
            }
        }
        return listManagers;
    }

    public void setListManagers(List<String> listManagers)
    {
        this.listManagers = listManagers;
    }

    public List<String> getWorkersOfManagers(String managerFIO)

    {
        workersOfManager = new ArrayList<String>();
        for (Worker listWorker : listWorkers)
        {
            if(listWorker.getPosition().equals("Рабочий")&&listWorker.getManager().equals(managerFIO)) //enum
            {
                workersOfManager.add(listWorker.getFio());
            }
        }
        return workersOfManager;
    }

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


    public void addEvent(String value)
    {
        System.out.println("value = " + value);
        System.out.println(worker);
        this.worker = new Worker();
        worker.setPosition(value);

    }

//    public void addEvent(ActionEvent actionEvent)
//    {
//        String buttonId = actionEvent.getComponent().getClientId();
//        System.out.println(actionEvent.getComponent());
//        this.worker = new Worker();
//        worker.setPosition(buttonId);
//        System.out.println(worker);
//        System.out.println("911");
//    }

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

    public void onToggle(ToggleEvent e) {
        listWorkersIsVisible.set((Integer) e.getData(), e.getVisibility() == Visibility.VISIBLE);
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