package model.services;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import model.lov.HomeOffice2LovImpl;

import model.services.common.AppModule;


import model.views.DepartmentVOImpl;
import model.views.HomeOfficeWeekListVOImpl;

import model.views.HomeOfficeWeekWiseDeptVOImpl;

import oracle.jbo.Row;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewLinkImpl;
import oracle.jbo.server.ViewObjectImpl;

// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Jun 21 23:33:18 BDT 2020
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AppModuleImpl extends ApplicationModuleImpl implements AppModule {
    /**
     * This is the default constructor (do not remove).
     */
    public AppModuleImpl() {
    }


    /**
     * Container's getter for HomeOfficeLov1.
     * @return HomeOfficeLov1
     */
    public ViewObjectImpl getHomeOfficeLov1() {
        return (ViewObjectImpl)findViewObject("HomeOfficeLov1");
    }


    /**
     * Container's getter for EmployeeVO1.
     * @return EmployeeVO1
     */
    public ViewObjectImpl getEmployeeVO1() {
        return (ViewObjectImpl)findViewObject("EmployeeVO1");
    }

    /**
     * Container's getter for HomeOfficeWeekListVO1.
     * @return HomeOfficeWeekListVO1
     */
    public ViewObjectImpl getHomeOfficeWeekListVO1() {
        return (ViewObjectImpl)findViewObject("HomeOfficeWeekListVO1");
    }


    public void setSessionValues(String orgId, String userId, String respId,
                                 String respAppId) {
              
        // System.out.println("========================== in set session values");
       
//         userId = "5219";
//         if(respId==null) respId= "52870";  // 'Home Office All Dept'  responsibility

        if (userId != null) {
            FacesContext fctx = FacesContext.getCurrentInstance();
            ExternalContext ectx = fctx.getExternalContext();
            HttpSession userSession = (HttpSession)ectx.getSession(false);


            userSession.setAttribute("userId", userId);
            userSession.setAttribute("orgId", orgId);
            userSession.setAttribute("respId", respId);

            if (respId != null && respId.equals("52870")) {
                // if responsibility is 'Home Office All Dept' then ignore current employee's people group id
                userSession.setAttribute("empPeopleGroupId", "1");
            } else {
                userSession.setAttribute("empPeopleGroupId",getCurrentEmpPeopleGroupId());
            }

        }
        
    }


    /**
     * Container's getter for EmpHomeOfficeWeekScVO2.
     * @return EmpHomeOfficeWeekScVO2
     */
    public ViewObjectImpl getEmpHomeOfficeWeekScVO1() {
        return (ViewObjectImpl)findViewObject("EmpHomeOfficeWeekScVO1");
    }


   

    /**
     * Container's getter for HomeOfficeWeekListVOvsEmpHomeOfficeWeekScVO_VL1.
     * @return HomeOfficeWeekListVOvsEmpHomeOfficeWeekScVO_VL1
     */
    public ViewLinkImpl getHomeOfficeWeekListVOvsEmpHomeOfficeWeekScVO_VL1() {
        return (ViewLinkImpl)findViewLink("HomeOfficeWeekListVOvsEmpHomeOfficeWeekScVO_VL1");
    }


    /**
     * Container's getter for DepartmentVO1.
     * @return DepartmentVO1
     */
    public ViewObjectImpl getDepartmentVO1() {
        return (ViewObjectImpl)findViewObject("DepartmentVO1");
    }

  

    /**
     * Container's getter for DepartmentVOvsEmpHomeOfficeVL1.
     * @return DepartmentVOvsEmpHomeOfficeVL1
     */
    public ViewLinkImpl getDepartmentVOvsEmpHomeOfficeVL1() {
        return (ViewLinkImpl)findViewLink("DepartmentVOvsEmpHomeOfficeVL1");
    }


    /**
     * Container's getter for HomeOfficeWeekWiseDeptVO1.
     * @return HomeOfficeWeekWiseDeptVO1
     */
    public HomeOfficeWeekWiseDeptVOImpl getHomeOfficeWeekWiseDeptVO1() {
        return (HomeOfficeWeekWiseDeptVOImpl)findViewObject("HomeOfficeWeekWiseDeptVO1");
    }

    /**
     * Container's getter for DepartmentVOvsWeekWiseDeptVO_VL1.
     * @return DepartmentVOvsWeekWiseDeptVO_VL1
     */
    public ViewLinkImpl getDepartmentVOvsWeekWiseDeptVO_VL1() {
        return (ViewLinkImpl)findViewLink("DepartmentVOvsWeekWiseDeptVO_VL1");
    }

   

    /**
     * Container's getter for WeekListVOvsWeekWiseDeptVO_VL1.
     * @return WeekListVOvsWeekWiseDeptVO_VL1
     */
    public ViewLinkImpl getWeekListVOvsWeekWiseDeptVO_VL1() {
        return (ViewLinkImpl)findViewLink("WeekListVOvsWeekWiseDeptVO_VL1");
    }

    /**
     * Container's getter for HomeOfficeWithNoValueLov1.
     * @return HomeOfficeWithNoValueLov1
     */
    public ViewObjectImpl getHomeOfficeWithNoValueLov1() {
        return (ViewObjectImpl)findViewObject("HomeOfficeWithNoValueLov1");
    }

    /**
     * Container's getter for EmploymentCatagoryLov1.
     * @return EmploymentCatagoryLov1
     */
    public ViewObjectImpl getEmploymentCatagoryLov1() {
        return (ViewObjectImpl)findViewObject("EmploymentCatagoryLov1");
    }

    /**
     * Container's getter for HomeOfficeWeekListVO2.
     * @return HomeOfficeWeekListVO2
     */
    public HomeOfficeWeekListVOImpl getHomeOfficeWeekListVO2() {
        return (HomeOfficeWeekListVOImpl)findViewObject("HomeOfficeWeekListVO2");
    }

    /**
     * Container's getter for CopyToWeekListVO1.
     * @return CopyToWeekListVO1
     */
    public ViewObjectImpl getCopyToWeekListVO1() {
        return (ViewObjectImpl)findViewObject("CopyToWeekListVO1");
    }

    /**
     * Container's getter for HomeOffice2Lov1.
     * @return HomeOffice2Lov1
     */
    public HomeOffice2LovImpl getHomeOffice2Lov1() {
        return (HomeOffice2LovImpl)findViewObject("HomeOffice2Lov1");
    }

    /**
     * Container's getter for WeekScDummyVO1.
     * @return WeekScDummyVO1
     */
    public ViewObjectImpl getWeekScDummyVO1() {
        return (ViewObjectImpl)findViewObject("WeekScDummyVO1");
    }

    public Object getCurrentEmpPeopleGroupId() {
        return this.getEmployeeVO1().first().getAttribute("PeopleGroupId");
    }

    /**
     * Container's getter for HomeOfficeWeekWiseDeptVO2.
     * @return HomeOfficeWeekWiseDeptVO2
     */
    public HomeOfficeWeekWiseDeptVOImpl getHomeOfficeWeekWiseDeptVO2() {
        return (HomeOfficeWeekWiseDeptVOImpl)findViewObject("HomeOfficeWeekWiseDeptVO2");
    }

    /**
     * Container's getter for SelectDeselectLOV1.
     * @return SelectDeselectLOV1
     */
    public ViewObjectImpl getSelectDeselectLOV1() {
        return (ViewObjectImpl)findViewObject("SelectDeselectLOV1");
    }
}
