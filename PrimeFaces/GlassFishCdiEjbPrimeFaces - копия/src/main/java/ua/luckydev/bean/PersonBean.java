package ua.luckydev.bean;

import org.primefaces.event.ToggleEvent;
import org.primefaces.model.Visibility;
import ua.luckydev.dao.PersonDAO;
import ua.luckydev.entity.Person;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.*;

@ManagedBean(name = "personBean")
@SessionScoped //?!?!?!?!? //Serialisation
//@ViewScoped
public class PersonBean implements Serializable
{
    @ManagedProperty("#{personDAO}")
    PersonDAO personDAO;

    private Person person;
    private List<Person> listPersons;
    
    private List<String> listManagers;
    private List<Boolean> listColumnsIsVisible;
    private List<String> listPositions = new ArrayList<String>();
    private List<String> workersOfManager;

    private final int columnsQuanity = 7; //автоматизировать надо

    @PostConstruct
    public void init()
    {
        listPersons = new ArrayList<Person>();
        listPersons.addAll(personDAO.listPersons());

        listColumnsIsVisible = new ArrayList<Boolean>();

        for (int i = 0; i < columnsQuanity; i++)
        {
            listColumnsIsVisible.add(true);
        }


    }

    
    public List<String> getListManagers()
    {
        listManagers = new ArrayList<String>();
        for (Person person : listPersons)
        {
            if(person.getPosition().equals("Менеджер")) //enum
            {
                listManagers.add(person.getFio());
            }
        }
        return listManagers;
    }

    public List<String> getWorkersOfManagers(String managerFIO)

    {
        workersOfManager = new ArrayList<String>();
        for (Person listWorker : listPersons)
        {
            if(listWorker.getPosition().equals("Рабочий")&&listWorker.getManager().equals(managerFIO)) //enum
            {
                workersOfManager.add(listWorker.getFio());
            }
        }
        return workersOfManager;
    }

    public List<String> getPositions() {  //Рабочий и менеджер надо чтобы были вверху
        for (Person listWorker : listPersons) {
            String pos = listWorker.getPosition();

            if(!listPositions.contains(pos))
            {
                listPositions.add(pos);
            }
        }
        Collections.sort(listPositions);
        return listPositions;
    }

    public List<Boolean> getListWorkersIsVisible() {
        return listColumnsIsVisible;
    }

    public PersonDAO getPersonEntityDAO()  //проверить надо ли
    {
        return personDAO;
    }

    public void setPersonDAO(PersonDAO personDAO)
    {
        this.personDAO = personDAO;
    }

    public Person getPerson()
    {
        return person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }

    public List<Person> getlistPersons()
    {
        return listPersons;
    }


    public void addEvent(String value)  //переименовать типа newPerson
    {
        this.person = new Person();
        person.setPosition(value);
    }

    public void changePosition(String value)
    {
        person.setPosition(value);
    }


    public void actionAddWorker(ActionEvent actionEvent)
    {
        System.out.println(person);
        addPerson();
//        FacesContext context = FacesContext.getCurrentInstance();
//        context.addMessage(null, new FacesMessage("Add person"));
        init();
//        this.person = new Person();
    }

    public void getPersonById(int id)
    {
        this.person = personDAO.getPerson(id); //без this тоже можно
    }

    public void updatePerson(ActionEvent actionEvent)
    {
        personDAO.updatePerson(person);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Personne mise ? jour")); //сообщения зачесать
        init();
    }

    public void delete(Person person)
    {
        System.out.println(person);
        personDAO.deletePerson(person);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Personne supprim?")); //сообщения зачесать
        init();
    }

    public String addPerson()
    {
        // Calling Business Service
        personDAO.addPerson(person); //дублирование убрать
        // Add message
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("The Employee " + this.person.getFio() + " Is Registered Successfully"));
        return ""; //почему Стринг - ?!?!?!
    }

    //для корректной работы функции выбора столбцов
    public void onToggle(ToggleEvent e) {
        listColumnsIsVisible.set((Integer) e.getData(), e.getVisibility() == Visibility.VISIBLE);
    }

    public void deletMessage(ActionEvent actionEvent)
    {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Personne supprim?"));
    }
}