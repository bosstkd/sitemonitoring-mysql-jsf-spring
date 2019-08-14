package cz.jiripinkas.sitemonitoring.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


import cz.jiripinkas.sitemonitoring.entity.Check;
import cz.jiripinkas.sitemonitoring.service.CheckService;


@ManagedBean
@ViewScoped
public class CheckListController implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{checkService}")
	private CheckService checkService;
	
	private List<Check> checks;
	
	private Check check = new Check();
	
	@PostConstruct
	public void loadChecks() {
		checks = checkService.findAll();
	}
	
	public void save() {
		checkService.save(check);
		check = new Check();
		checks = checkService.findAll();
		FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Check saved!", null));
	}
	
	public void remove(Check check) {
		checkService.remove(check);
		checks = checkService.findAll();
		FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Check removed!", null));
	}
	
	public void clear() {
		check = new Check();
	}

    public CheckService getCheckService() {
        return checkService;
    }

    public void setCheckService(CheckService checkService) {
        this.checkService = checkService;
    }

    public List<Check> getChecks() {
        return checks;
    }

    public void setChecks(List<Check> checks) {
        this.checks = checks;
    }

    public Check getCheck() {
        return check;
    }

    public void setCheck(Check check) {
        this.check = check;
    }
        
        

}
