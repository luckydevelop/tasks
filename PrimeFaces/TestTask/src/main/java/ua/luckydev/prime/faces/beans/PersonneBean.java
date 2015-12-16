package ua.luckydev.prime.faces.beans;

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
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "personneBean")
//@SessionScoped //?!?!?!?!? //Serialisation
@ViewScoped
public class PersonneBean implements Serializable
{

    @ManagedProperty("#{serviceImp}")
    ServiceImp serviceImp;
    private Worker worker;
    private List<Worker> listWorkers;

    public PersonneBean()
    {

    }

    @PostConstruct
    public void init()
    {
        listWorkers = new ArrayList<Worker>();
        listWorkers.addAll(serviceImp.listWorkers());
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