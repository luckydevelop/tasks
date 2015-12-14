package ua.luckydev.prime.faces.beans;


import ua.luckydev.model.Worker;
import ua.luckydev.service.WorkerService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class RegisterWorkers {

    @ManagedProperty("#{workerService}")
    WorkerService workerService;

    Worker worker = new Worker();

    public WorkerService getWorkerService() {
        return workerService;
    }

    public void setWorkerService(WorkerService workerService) {
        this.workerService = workerService;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public String persistWorker()
    {
        workerService.addWorker(worker);

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("The Worker "+this.worker.getFIO()+" Is persisted Successfully"));

        return "";
    }


}
