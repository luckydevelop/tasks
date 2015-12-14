package ua.luckydev.prime.faces.beans;

import ua.luckydev.jpa.data.Worker;
import ua.luckydev.spring.service.WorkerService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.util.List;

@ManagedBean(name = "mb")
@SessionScoped
public class TableMB {

    WorkerService workerService;
    private Worker worker;
    private List<Worker> listPersonne;

    public TableMB() {
        worker = new Worker();
    }

    public void addEvent(ActionEvent actionEvent) {
        worker = new Worker();

    }
//    public void deletMessage(ActionEvent actionEvent){
//        FacesContext context = FacesContext.getCurrentInstance();
//        context.addMessage(null, new FacesMessage("Personne supprimé"));
//    }
//
//    public void editEvent(int id) {
//        System.out.print(id);
//        workerService = new WorkerService();
//        worker = workerService.getPersonne(id);
//
//    }
//
//    public void edition(ActionEvent actionEvent) {
//        workerService = new WorkerService();
//        workerService.updatePersonne(worker);
//        FacesContext context = FacesContext.getCurrentInstance();
//        context.addMessage(null, new FacesMessage("Personne mise à jour"));
//    }
//
//    public void ajoutp(ActionEvent actionEvent) {
//        workerService = new WorkerService();
//        workerService.addPersonne(worker);
//        FacesContext context = FacesContext.getCurrentInstance();
//        context.addMessage(null, new FacesMessage("Personne ajouté"));
//        worker = new Worker();
//    }
//
//    public void delet(Worker personne) {
//        workerService = new WorkerService();
//        workerService.deletpersonne(personne);
//        FacesContext context = FacesContext.getCurrentInstance();
//        context.addMessage(null, new FacesMessage("Personne supprimé"));
//
//    }
//
//    public List<Worker> getListWorker() {
//        workerService = new WorkerService();
//        listWorker = workerService.getListPersonne();
//        return listWorker;
//    }
//
//    public void setListWorker(List<Worker> listWorker) {
//        this.listPersonne = listPersonne;
//    }
//
//    public Worker getWorker() {
//        return worker;
//    }
//
//    public void setWorker(Worker worker) {
//        this.worker = worker;
//    }
}