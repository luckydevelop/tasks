package ua.luckydev.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.luckydev.dao.WorkerDAO;
import ua.luckydev.model.Worker;

@Service
public class WorkerService {
    WorkerDAO workerDAO;

    public void setWorkerDAO(WorkerDAO workerDAO) {
        this.workerDAO = workerDAO;
    }

    @Transactional
    public void addWorker(Worker worker)
    {
      workerDAO.addWorker(worker);
    }

}
