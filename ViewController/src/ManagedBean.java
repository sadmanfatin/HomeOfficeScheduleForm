
import java.lang.reflect.InvocationTargetException;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.event.ValueChangeEvent;

import model.services.AppModuleImpl;

import model.views.EmpHomeOfficeWeekScVORowImpl;

import model.views.HomeOfficeWeekListVORowImpl;

import oracle.adf.model.BindingContainer;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.data.RichColumn;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.AttributeDef;
import oracle.jbo.JboException;
import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSet;
import oracle.jbo.ViewObject;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.DBTransaction;
import oracle.jbo.uicli.binding.JUCtrlListBinding;


public class ManagedBean {
    private RichTable employeeHomeOfficeDaysOfMonthTable;
    private RichColumn d1;
    private RichColumn d2;
    private RichColumn d3;
    private RichColumn d4;
    private RichColumn d5;
    private RichColumn d6;
    private RichColumn d7;
  
    public java.util.Date currentDate;
    public int currentHour;
    private DateFormat columnHeaderFormatter =
        new SimpleDateFormat("E, MMM dd, yyyy");

    private RichDocument onPageLoad;

   // Map<String, String> dayWiseDate ;

   Map<String, String>  dayWiseDate= new LinkedHashMap<String,String>();

    private RichSelectOneChoice d3333bind;
    private RichCommandButton submitToHeadButton;
    private RichCommandButton submitToHrButton;
    private RichSelectOneChoice allEmployeeValueForWeekChoice;
    private RichSelectOneChoice singleEmployeeValueForWeekChoice;
    private RichOutputText currentWeekId;
    private RichOutputText hodValue;
    private RichSelectOneChoice employmentCatagoryChoice;
    private RichInputText FirstSubmissionToHr;
    private RichCommandButton copyFromPrevWeekButton;
    private RichSelectOneChoice weekCopyTo;
    private RichCommandButton copyFromWeekButton;
  


    public ManagedBean() {
        //  AppModuleImpl appM  = getAppModuleImpl();
        System.out.println("Managed bean initialized  mmm");
        setHomeOfficeCurrentWeek();
        populateDayWsieDateMap();
       
    }

    AppModuleImpl appM = getAppModuleImpl();

    public AppModuleImpl getAppModuleImpl() {
        DCBindingContainer bindingContainer =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        //BindingContext bindingContext = BindingContext.getCurrent();
        DCDataControl dc =
            bindingContainer.findDataControl("AppModuleDataControl"); // Name of application module in datacontrolBinding.cpx
        AppModuleImpl appM = (AppModuleImpl)dc.getDataProvider();
        return appM;
    }


    public void setEmployeeHomeOfficeDaysOfMonthTable(RichTable employeeHomeOfficeDaysOfMonthTable) {
        this.employeeHomeOfficeDaysOfMonthTable =
                employeeHomeOfficeDaysOfMonthTable;
    }

    public RichTable getEmployeeHomeOfficeDaysOfMonthTable() {
        return employeeHomeOfficeDaysOfMonthTable;
    }

    public void setD1(RichColumn d1) {
        this.d1 = d1;
    }

    public RichColumn getD1() {
        return d1;
    }

    public void setD2(RichColumn d2) {
        this.d2 = d2;
    }

    public RichColumn getD2() {
        return d2;
    }

    public void setD3(RichColumn d3) {
        this.d3 = d3;
    }

    public RichColumn getD3() {
        return d3;
    }

    public void setD4(RichColumn d4) {
        this.d4 = d4;
    }

    public RichColumn getD4() {
        return d4;
    }

    public void setD5(RichColumn d5) {
        this.d5 = d5;
    }

    public RichColumn getD5() {
        return d5;
    }

    public void setD6(RichColumn d6) {
        this.d6 = d6;
    }

    public RichColumn getD6() {
        return d6;
    }

    public void setD7(RichColumn d7) {
        this.d7 = d7;
    }

    public RichColumn getD7() {
        return d7;
    }

    public void onPageLoad(PhaseEvent phaseEvent) {
        // Add event code here...

        if (!AdfFacesContext.getCurrentInstance().isPostback()) {

            System.out.println("========================== in on page load mmm");
         
         
         
           // setHomeOfficeCurrentWeek();            
          //     populateDayWsieDateMap();
         
            setEmpHomeOfficeWeekScColHeader();
           
            restricEmpHomeOfficeWeekScEntry();
            
            restrictCopyFromWeek();

            filterCopyToWeekListVo();
            
            
            createCurrentWeekAndDaySc();
            
            updateHolidayForCurrentWeek();
            
        }

    }

    private void populateDayWsieDateMap() {


        java.util.Date dateVal;
        DateFormat formatter = new SimpleDateFormat("E, MMM dd, yyyy");
        Calendar calendar = Calendar.getInstance();
        String day;

        //   System.out.println("------- time :"+Calendar.getInstance().getTime()) ;

        //  day = formatter.format(dateVal );
        // calendar.set(Calendar.DAY_OF_MONTH, 6);

        //default month and year if month and yaer sent 0 as argument

        Date firstDayOfWeek;
        int dayNo;
        firstDayOfWeek =
                (Date)appM.getHomeOfficeWeekListVO1().getCurrentRow().getAttribute("StartDate");
        calendar.setTime(firstDayOfWeek.getValue());
         dayNo = calendar.get(Calendar.DAY_OF_MONTH);

        for (int i = 1; i <= 7; i++) {

            // calendar.set(calendar.DAY_OF_MONTH, i+dayNo);
            dateVal = calendar.getTime();
            day = formatter.format(dateVal);
            this.dayWiseDate.put("D" + i, day);
            calendar.add(calendar.DAY_OF_MONTH, 1);
        }


        Iterator it = dayWiseDate.keySet().iterator();

//        while (it.hasNext()) {
//            String key;
//            key = (String)it.next();
//            System.out.print("key  " + key);
//            System.out.print("value " + dayWiseDate.get(key));
//            System.out.println();
//        }


    }


    private void setEmpHomeOfficeWeekScColHeader()  {

        Iterator it = this.dayWiseDate.keySet().iterator();

        java.lang.reflect.Method method;
        String key, value, methodName;
        RichColumn richColumn;
        while (it.hasNext()) {
            key = (String)it.next();
            value = dayWiseDate.get(key);


            try {
                methodName = "get" + key;
                method = this.getClass().getMethod(methodName);

              //  System.out.println("method name : " + method);
                //  System.out.println("header text "+value);

                richColumn = (RichColumn)method.invoke(this);
                // richColumn.setInlineStyle("");

                richColumn.setHeaderText(value);
                //  System.out.println("richColumn.getHeaderText() after set "+richColumn.getHeaderText());

            } catch (Exception e) {
                e.printStackTrace();

            }


        }

    }


    private void setHomeOfficeCurrentWeek() {

        ViewObject weekListVo = appM.getHomeOfficeWeekListVO1();
        weekListVo.setRangeSize(100);

        if (weekListVo.getCurrentRow()== null ) {
            System.out.println("weekListVo.getCurrentRow() == null");  
            oracle.jbo.domain.Number weekId = getTodayWeekId();
            Key key = new Key(new oracle.jbo.domain.Number[] { weekId });

            Row[] rows = weekListVo.findByKey(key, 1);

            System.out.println(rows.length);
            Row row = rows[0];

            weekListVo.setCurrentRow(row);
        }
        else{
              
         System.out.println("weekListVo.getCurrentRow() != null");  
               
        }

    }

    private oracle.jbo.domain.Number getTodayWeekId() {

        oracle.jbo.domain.Number weekId;
        int val = 0;
        String query =
            "select max(Week_id) week_id from  XX_HOME_OFFICE_WEEK_LIST \n" +
            "where start_date  <= sysdate";


        ResultSet rs;

        try {
            rs =
 appM.getDBTransaction().createStatement(0).executeQuery(query);
            if (rs.next()) {
                val = rs.getInt("week_id");
            }
            rs.close();
        } catch (SQLException e) {

            throw new JboException(e);
        }

        return new oracle.jbo.domain.Number(val);


    }

    public void weekRangeValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        
        
        // this method sets vo current row with new value
       setValueToEL("#{bindings.HomeOfficeWeekListVO1.inputValue}",
                          valueChangeEvent.getNewValue()); //Updates the model
      //  String value = (String)resolveExpression("#{bindings.HomeOfficeWeekListVO1.attributeValue}");
          
        System.out.println("current  weekId :"+ appM.getHomeOfficeWeekListVO1().getCurrentRow().getAttribute("WeekId"));
      
            //setHomeOfficeCurrentWeek();
          //  setHomeOfficeWeekListVoCurrentRow(value);
        
            populateDayWsieDateMap();
        
            setEmpHomeOfficeWeekScColHeader();
      
            restricEmpHomeOfficeWeekScEntry();
            
           restrictCopyFromWeek();
        
          filterCopyToWeekListVo();
        
          createCurrentWeekAndDaySc();
        
        updateHolidayForCurrentWeek();

    }

/*     private void setHomeOfficeWeekListVoCurrentRow(String value) {

        ViewObject weekListVo = appM.getHomeOfficeWeekListVO1();
        weekListVo.setRangeSize(100);

        oracle.jbo.domain.Number weekId = getWeekId(value);
        Key key = new Key(new oracle.jbo.domain.Number[] { weekId });

        Row[] rows = weekListVo.findByKey(key, 1);

        System.out.println(rows.length);
        Row row = rows[0];
        weekListVo.setCurrentRow(row);

    } */


   /*  private oracle.jbo.domain.Number getWeekId(String value) {
        System.out.println(value);
        oracle.jbo.domain.Number weekId;
        int val = 0;
        String query = "select Week_id  from  XX_HOME_OFFICE_WEEK_LIST \n" +
            " where  TO_CHAR(START_DATE , 'MON dd, yyyy')||' - '||TO_CHAR(END_DATE , 'MON dd, yyyy') = '" +
            value + "'";
        ResultSet rs;

        try {
            rs =
 appM.getDBTransaction().createStatement(0).executeQuery(query);
            if (rs.next()) {
                val = rs.getInt("Week_id");
            }
            rs.close();
        } catch (SQLException e) {

            throw new JboException(e);
        }
        return new oracle.jbo.domain.Number(val);

    } */

    public Object resolveExpression(String el) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();
        ExpressionFactory expressionFactory =
            facesContext.getApplication().getExpressionFactory();
        ValueExpression valueExp =
            expressionFactory.createValueExpression(elContext, el,
                                                    Object.class);
        return valueExp.getValue(elContext);
    }

    public void setValueToEL(String el, Object val) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();
        ExpressionFactory expressionFactory =
            facesContext.getApplication().getExpressionFactory();
        ValueExpression exp =
            expressionFactory.createValueExpression(elContext, el,
                                                    Object.class);
        exp.setValue(elContext, val);
    }


    private void restricEmpHomeOfficeWeekScEntry() {
        System.out.println("In  restricEmpHomeOfficeWeekScEntry() method ");
        Iterator it = this.dayWiseDate.keySet().iterator();
        //  java.lang.reflect.Method method;
        String key, value;

        java.util.Date date;
        boolean columnEditable;

        while (it.hasNext()) {

            key = (String)it.next();
            value = dayWiseDate.get(key);


            try {

                date = this.columnHeaderFormatter.parse(value);
           
                columnEditable = checkColumnDateEditable(date);
                

                restrictColumnChoiceList(key, columnEditable);


            } catch (Exception e) {
                
                System.out.println("exception occured  111 ");
                e.printStackTrace();

            }

        }

    }

    public void testMethod(ActionEvent actionEvent) {

     //  this.sendMailOnSubmitToHr();
        
        
    }

    public void departmentLovValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        // this method sets vo current row with new value
        setValueToEL("#{bindings.DepartmentVO1.inputValue}",
                          valueChangeEvent.getNewValue()); //Updates the model
        //  String value = (String)resolveExpression("#{bindings.HomeOfficeWeekListVO1.attributeValue}");
          
        
        createCurrentWeekAndDaySc();
        updateHolidayForCurrentWeek();
        
    }


    //    private void setAllEmployeeWeekListVlue(int Value) {
    ////
    //        String cohiseListValue="";
    //        switch (Value) {
    //        case 0: cohiseListValue = "";
    //        break;
    //        case 1:   cohiseListValue = "CO Office";
    //        break;
    //        case 2:   cohiseListValue = "Other Office";
    //        break;
    //        case 3:   cohiseListValue = "Leave";
    //        break;
    //        case 4:   cohiseListValue = "Home Office";
    //        break;
    //        default:
    //
    //        }
    //
    //        String deptartment = (String)appM.getDepartmentVO1().getCurrentRow().getAttribute("Departments");
    //
    //        RowSet rs = (RowSet)appM.getHomeOfficeWeekListVO1().getCurrentRow().getAttribute("EmpHomeOfficeWeekScVO");
    //      //  Row row;
    //
    ////        System.out.println("rs.getAllRowsInRange().length :"+ rs.getAllRowsInRange().length);
    ////        System.out.println("rs.getRowCount() :"+ rs.getRowCount());
    ////        System.out.println("rs.getFetchedRowCount() :"+ rs.getFetchedRowCount());
    //
    //        Row[] rows = rs.getFilteredRows("Dept",deptartment );
    //
    //      //  System.out.println("rows.length"+rows.length);
    //
    //      Iterator it   = this.dayWiseDate.keySet().iterator();;
    //      //  java.lang.reflect.Method method;
    //      String key, value;
    //
    //     java.util.Date date;
    //      boolean columnEditable;
    //
    //        for(Row row: rows){
    //            System.out.println("row = "+row.getAttribute(0)+"  "+row.getAttribute(1)+"  "+ row.getAttribute(2));
    //
    //           it= this.dayWiseDate.keySet().iterator();
    //            while (it.hasNext()){
    //
    //                key = (String)it.next();
    //
    //                value = dayWiseDate.get(key);
    //                System.out.println("key = "+ key+ "value ="+value);
    //
    //                try {
    //                    date = this.columnHeaderFormatter.parse(value);
    //                    columnEditable  = checkColumnDateEditable(date );
    //                    System.out.println("key = "+ key+ "value ="+value+ " column editable = "+columnEditable );
    //
    //                    if(columnEditable){
    //                        row.setAttribute(key,cohiseListValue  );
    //                        System.out.println(" row.getAttribute(key )= " +  row.getAttribute(key ));
    //                    }
    //
    //                } catch (Exception e) {
    //                    e.printStackTrace();
    //
    //                }
    //            }
    //
    //        }
    //
    //        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getEmployeeHomeOfficeDaysOfMonthTable());
    //
    //    }


    public void officeTypeValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...

                RichColumn Richcolumn;
                Richcolumn = (RichColumn)valueChangeEvent.getComponent().getParent();
                String columnName, dateValue;
                int choice =Integer.parseInt(valueChangeEvent.getNewValue().toString())  ;
                
                columnName=  Richcolumn.getSortProperty(); // get the attribute name of view object
                dateValue= Richcolumn.getHeaderText();
                String choiceVlaue = this.getChoiceListValue(choice ,dateValue  );
                 
                 
                ViewObject weekScVo = appM.getEmpHomeOfficeWeekScVO1();
        

                AdfFacesContext.getCurrentInstance().addPartialTarget(this.d1);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.d2);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.d3);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.d4);    
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.d5);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.d6);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.d7); 
        
    }


    public static oracle.jbo.domain.Date castUtilDateToJboDate(java.util.Date date) {
        oracle.jbo.domain.Date jboDate = null;
        if (date != null) {
            jboDate =
                    new oracle.jbo.domain.Date(new java.sql.Date(date.getTime()));
        }
        return jboDate;
    }


  

    public void submitToHead(ActionEvent actionEvent) {
        // Add event code here...

        appM.getHomeOfficeWeekWiseDeptVO1().getCurrentRow().setAttribute("SubmittedToHead",
                                                                         "y");
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getSubmitToHeadButton());
        
        sendEmailOnSubmitToHead();
        
        appM.getDBTransaction().commit();

    }

    public void setSubmitToHeadButton(RichCommandButton submitToHeadButton) {
        this.submitToHeadButton = submitToHeadButton;
    }

    public void submitToHr(ActionEvent actionEvent) {
        // Add event code here...
//        System.out.println("===================   in submit to hr ");
      
      boolean checkeditableColumnNull =    isEditableColumnNull();
        
       if (checkeditableColumnNull) {
            showMessage("Any day's value can't be empty for any employee !", "info");
            return;
        }
       
       
        appM.getHomeOfficeWeekWiseDeptVO1().getCurrentRow().setAttribute("SubmittedToHr","y");
        appM.getHomeOfficeWeekWiseDeptVO1().getCurrentRow().setAttribute("SubmittedToHead","y");
        appM.getHomeOfficeWeekWiseDeptVO1().getCurrentRow().setAttribute("FirstSubmissionToHr","y");
         
         sendEmailOnSubmitToHr();
          
         approveWeekSchedule();
         
        appM.getDBTransaction().commit();
         
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getSubmitToHrButton());
       

        //        ViewObject vo = appM.getEmpHomeOfficeWeekScVO1();
        //
        //        System.out.println( "1= "+ vo.getAllRowsInRange().length);
        //
        //        RowSet empHomeOfficeWkkeScRowSet ;
        //        empHomeOfficeWkkeScRowSet=(RowSet)appM.getHomeOfficeWeekListVO1().getCurrentRow().getAttribute("EmpHomeOfficeWeekScVO");
        //
        //        System.out.println(empHomeOfficeWkkeScRowSet.getAllRowsInRange().length);
        //
        //        System.out.println(empHomeOfficeWkkeScRowSet.getRowCount());
        //
        //        System.out.println(empHomeOfficeWkkeScRowSet.getRangeSize());
        //
        //        System.out.println(empHomeOfficeWkkeScRowSet.getFilteredRows("Dept", appM.getDepartmentVO1().getCurrentRow().getAttribute("Departments")));

    }


    public RichCommandButton getSubmitToHeadButton() {
        return submitToHeadButton;
    }

    public void setSubmitToHrButton(RichCommandButton submitToHrButton) {
        this.submitToHrButton = submitToHrButton;
    }

    public RichCommandButton getSubmitToHrButton() {
        return submitToHrButton;
    }

    public void setAllEmployeeValueforWeek(ActionEvent actionEvent) {
        // Add event code here...
          
        // System.out.println(" ========= in setAllEmployeeValueforWeek  ");

        int choiceValue =
            Integer.parseInt(this.allEmployeeValueForWeekChoice.getValue().toString());
        String homeOfficeCohiceListValue = getChoiceListValue(choiceValue);

        setValueForAllEmpAllDay( homeOfficeCohiceListValue );
        

    }

    public void setAllEmployeeValueForWeekChoice(RichSelectOneChoice allEmployeeValueForWeekChoice) {
        this.allEmployeeValueForWeekChoice = allEmployeeValueForWeekChoice;
    }

    public RichSelectOneChoice getAllEmployeeValueForWeekChoice() {
        return allEmployeeValueForWeekChoice;
    }

    private boolean checkColumnDateEditable(java.util.Date columnHeaderDate) {
     //  System.out.println("-------------- in checkColumnDateEditable");
      // System.out.println("==========   check column editable method ");
        java.util.Date currentDate = this.getCurrentDate();
        double currentHour = this.getCurrentHour();
       
//        System.out.println("-------------- date "+date );
//        System.out.println("-------------- current date "+currentDate );
      
//     System.out.println("-------------- current hour "+currentHour);
      
          Calendar c = Calendar.getInstance();
          c.setTime(columnHeaderDate);
           int dayNum = 0 ;
           dayNum  =c.get(Calendar.DAY_OF_WEEK);
           
//      System.out.println("-------------- day num "+dayNum); 
       
//         System.out.println(columnHeaderDate); 
//         System.out.println(c.getTime()); 
//         System.out.println(c.get(Calendar.DAY_OF_WEEK));
         
//       return true;
         
//        if(c.get(Calendar.DAY_OF_WEEK) ==7){
//            // satday 
//            return false;
//        }

      if (columnHeaderDate.before(currentDate)){
           // System.out.println("date.before(currentDate)");
            return false;
        }
        else if (columnHeaderDate.after(currentDate)){
          //  System.out.println("date.after(currentDate)");
            return true;
        }
            
        else if (columnHeaderDate.equals(currentDate) && dayNum == 6){
          // for friday
              if(currentHour < 8.00) {
                 // System.out.println(" ======   columnHeaderDate.equals(currentDate) &&  dayNum == 6  && currentHour < 8.00   ");
                  return true ;
              }else{
                //  System.out.println(" ======   columnHeaderDate.equals(currentDate) &&  dayNum == 6  && currentHour > 8.00   ");
                 return false ;
              }
             
         //   System.out.println("date.equals(currentDate) && currentHour >= 8");
           
        }
            
        else if (columnHeaderDate.equals(currentDate) &&  dayNum != 6 ){
          //for day other than friday
       //     System.out.println("date.equals(currentDate) && currentHour < 8");
               if(currentHour < 8.30) {
                  //System.out.println(" ======   columnHeaderDate.equals(currentDate) &&  dayNum != 6  && currentHour < 8.30   ");
                   return true ;
               }else{
                 //  System.out.println(" ======   columnHeaderDate.equals(currentDate) &&  dayNum != 6  && currentHour > 8.30  ");
                  return false ;
               }
        }
           
        else
            return false;
   
    }

    public java.util.Date getCurrentDate() {

        try {
            return currentDate =
                    this.columnHeaderFormatter.parse(columnHeaderFormatter.format(new java.util.Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;

    }

    public double getCurrentHour() {
        //        System.out.println("---------------  in  getCurrentHour()");
                 double currentHour=0.0;
                 double currentMinute = 0.0;
                    
                currentHour = Calendar.getInstance().get(Calendar.getInstance().HOUR_OF_DAY);
                currentMinute = Calendar.getInstance().get(Calendar.getInstance().MINUTE);
        //        System.out.println("---------------   currentHou "+  currentHour);
        //        System.out.println("---------------   currentmin "+  currentMinute);
                
                currentHour = currentHour +  (currentMinute)/ 100;
                
                return currentHour;
    }


    private void restrictColumnChoiceList(String key, boolean columnEditable) {
        boolean readOnlyValue = !columnEditable;
        RichColumn richColumn = null;
        RichSelectOneChoice choiceList = null;
        List<UIComponent> childdrenUiComponents = null;
        String methodName;
        java.lang.reflect.Method method = null;
        methodName = "get" + key;

        try {
            method = this.getClass().getMethod(methodName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            richColumn = (RichColumn)method.invoke(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        childdrenUiComponents = richColumn.getChildren();
        for (UIComponent uic : childdrenUiComponents) {
            if (uic.getClass().getSimpleName().equals("RichSelectOneChoice")) {
                choiceList = (RichSelectOneChoice)uic;
                choiceList.setReadOnly(readOnlyValue);
                
            }
        }
    }

                                       
    private void updateWeekScVoRow(Row empHomeOfficeWeekScVoRow, String homeOfficeCohiceListValue) {
            //   System.out.println("====================== updateWeekScVoRow");
               
        Iterator it = this.dayWiseDate.keySet().iterator();
        //  java.lang.reflect.Method method;
        String key, value;
        java.util.Date columnHeaderDate;
        boolean columnEditable;
//        System.out.println("row = " + empHomeOfficeWeekScVoRow.getAttribute(0) + "  " +
//                           empHomeOfficeWeekScVoRow.getAttribute(1) + "  " + empHomeOfficeWeekScVoRow.getAttribute(2));

        it = this.dayWiseDate.keySet().iterator();
        
        empHomeOfficeWeekScVoRow.setAttribute("SetAllDayValue", homeOfficeCohiceListValue);
        while (it.hasNext()) {

            key = (String)it.next();
            String weekScCurrentDayValue = null; 
            try {
              weekScCurrentDayValue = empHomeOfficeWeekScVoRow.getAttribute(key).toString();
            } catch (Exception e) {
                
                weekScCurrentDayValue = "";
                // TODO: Add catch code
             //   e.printStackTrace();
            }
            
            value = dayWiseDate.get(key);
         //   System.out.println("key = " + key + "value =" + value);

            try {
                columnHeaderDate = this.columnHeaderFormatter.parse(value);
                columnEditable = checkColumnDateEditable(columnHeaderDate);
               // System.out.println("key = " + key + "value =" + value + " column editable = " + columnEditable);

                if (columnEditable) {
                    
                    //initial plan : saturday and holiday will not be changed by set all day button
                    if( !key.equals("D7") && !weekScCurrentDayValue.equals("Holiday")  ){

                        empHomeOfficeWeekScVoRow.setAttribute(key, homeOfficeCohiceListValue);
                        //System.out.println(" row.getAttribute(key)= " + empHomeOfficeWeekScVoRow.getAttribute(key));                    
                        
                    }
                    
        
                }

            } catch (Exception e) {
                e.printStackTrace();

            }
        }


    }

    private String getChoiceListValue(int choiceValue , String dateValue) {
        String cohiseListValue = "";
     
        
        switch (choiceValue) {
        case 0:
            cohiseListValue = "CO Office";
            break;
        case 1:
            cohiseListValue = "Other Office";
            break;
        case 2:
            cohiseListValue = "Leave";
            break;
        case 3:
            cohiseListValue = "Home Office";
            break;
        case 4:
            if (dateValue.substring(0, 3).equals("Sat") ){
                cohiseListValue = "Weekly Holiday";
                break;
            }
            else  {
                cohiseListValue = "Holiday";
                break;
            }
            
        default:
            ;
        }

        return cohiseListValue;

    }
    
    private String getChoiceListValue(int choiceValue ) {
        String cohiseListValue = "";
        
        
        switch (choiceValue) {
        case 0:
            cohiseListValue = "CO Office";
            break;
        case 1:
            cohiseListValue = "Other Office";
            break;
        case 2:
            cohiseListValue = "Leave";
            break;
        case 3:
            cohiseListValue = "Home Office";
            break;
        default:
        }

        return cohiseListValue;

    }
    
    
    
    

    public void setSingleEmployeeValueForWeekChoice(RichSelectOneChoice singleEmployeeValueForWeekChoice) {
        this.singleEmployeeValueForWeekChoice =
                singleEmployeeValueForWeekChoice;
    }

    public RichSelectOneChoice getSingleEmployeeValueForWeekChoice() {
        return singleEmployeeValueForWeekChoice;
    }

    public void singleEmpAllDayValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...

        System.out.println("in set single setSingleEmployeeValueforWeek");

        int choiceValue =
            Integer.parseInt(this.singleEmployeeValueForWeekChoice.getValue().toString());
        String homeOfficeCohiceListValue = getChoiceListValue(choiceValue);

        System.out.println("homeOfficeCohiceListValue " +
                           homeOfficeCohiceListValue);

        Row row = appM.getEmpHomeOfficeWeekScVO1().getCurrentRow();

        System.out.println(row.getAttribute(0) + " " + row.getAttribute(0) +
                           " " + row.getAttribute(0) + " " +
                           row.getAttribute(0));

        updateWeekScVoRow(row, homeOfficeCohiceListValue);


    }




    public void setAllDayValueForEmp(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        //System.out.println("in set single setAllDayValueForEmp");

        int choiceValue =
        Integer.parseInt(this.singleEmployeeValueForWeekChoice.getValue().toString());
        //get the string value from choice list
        String homeOfficeCohiceListValue = getChoiceListValue(choiceValue);

//        System.out.println("homeOfficeCohiceListValue " +homeOfficeCohiceListValue);

        Row empHomeOfficeWeekScVoRow = appM.getEmpHomeOfficeWeekScVO1().getCurrentRow();

//        System.out.println(row.getAttribute(0) + " " + row.getAttribute(0) +
//                           " " + row.getAttribute(0) + " " +
//                           row.getAttribute(0));

        updateWeekScVoRow(empHomeOfficeWeekScVoRow, homeOfficeCohiceListValue);
    }

    public void setCurrentWeekId(RichOutputText currentWeekId) {
        this.currentWeekId = currentWeekId;
    }

    public RichOutputText getCurrentWeekId() {
        return currentWeekId;
    }

    public Map<String, String> getDayWiseDate() {
        return dayWiseDate;
    }

    public void setHodValue(RichOutputText hodValue) {
        this.hodValue = hodValue;
    }

    public RichOutputText getHodValue() {
        return hodValue;
    }

    public void submit(ActionEvent actionEvent) {
        // Add event code here...
     
     
          if(this.getHodValue().getValue().equals("Not HOD") && this.getFirstSubmissionToHr().getValue().equals("y")){
              
              int currentUser;
              try {
                 currentUser =  Integer.parseInt(appM.getEmployeeVO1().getCurrentRow().getAttribute("UserId").toString());
            } catch (NullPointerException e) {
                // TODO: Add catch code
                e.printStackTrace();
                currentUser=0;
            }
            
              if (currentUser ==1545 ){
                  // onln allow for user Syed Harun to save     (requirement provided by Shakhawat Hossain )
                 // System.out.println("  entered in syed allowed for harun ");
                 appM.getDBTransaction().commit();
              }
              else{
                  this.showMessage("Change by Non-HOD user only allowed before first submission to HR by HOD", "error");
                  return;
              }

        }
        
        appM.getDBTransaction().commit();
    }
    
    public  void showMessage(String messege , String severity ) {
        
        
        FacesMessage fm = new FacesMessage(messege);
        
        if(severity.equals("info")){
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
        }
        else if(severity.equals("warn")){
            fm.setSeverity(FacesMessage.SEVERITY_WARN);
        }
        else if(severity.equals("error")){
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
        }
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);
        
    }


    private void sendEmailOnSubmitToHr() {
        
      String testRecipient = (String)appM.getEmployeeVO1().getCurrentRow().getAttribute("EmailAddress"); 
        ArrayList<String> emailReceipents = new ArrayList<String>() ;
            
        
        // email ID of  Sender. 
        String sender = (String)appM.getEmployeeVO1().getCurrentRow().getAttribute("EmailAddress");
        
        
        ArrayList<String> weekScheduleTableHeader = new ArrayList<String>();
        ArrayList<ArrayList<String>> weekScheduleTableRows= new ArrayList<ArrayList<String>>();
        ArrayList<String> weekScheduleTableRow;
        String[] tableRow ; 
        
        weekScheduleTableHeader.add("Emp No");
        weekScheduleTableHeader.add("Full Name");
        weekScheduleTableHeader.add("CO Office Total");
        
         for (Map.Entry<String,String> entry : this.getDayWiseDate().entrySet())  {
             weekScheduleTableHeader.add(entry.getValue());
         }
        
         
         Row[] rows ; 
        EmpHomeOfficeWeekScVORowImpl EmpHomeOfficeWeekScRow;
         
        rows = appM.getEmpHomeOfficeWeekScVO1().getAllRowsInRange();
         
         
         for(Row row : rows){
             EmpHomeOfficeWeekScRow = (EmpHomeOfficeWeekScVORowImpl)row;
             weekScheduleTableRow = new ArrayList<String>();
             weekScheduleTableRow.add(EmpHomeOfficeWeekScRow.getEmpNo().toString());
             weekScheduleTableRow.add(EmpHomeOfficeWeekScRow.getFullName());
             weekScheduleTableRow.add(EmpHomeOfficeWeekScRow.getEmpWeeklyCoOfficeCount().toString());
             weekScheduleTableRow.add(EmpHomeOfficeWeekScRow.getD1());
             weekScheduleTableRow.add(EmpHomeOfficeWeekScRow.getD2());
             weekScheduleTableRow.add(EmpHomeOfficeWeekScRow.getD3());
             weekScheduleTableRow.add(EmpHomeOfficeWeekScRow.getD4());
             weekScheduleTableRow.add(EmpHomeOfficeWeekScRow.getD5());
             weekScheduleTableRow.add(EmpHomeOfficeWeekScRow.getD6());
             weekScheduleTableRow.add(EmpHomeOfficeWeekScRow.getD7());
             weekScheduleTableRows.add(weekScheduleTableRow);
             
             if(EmpHomeOfficeWeekScRow.getEmailAddress() != null){
                 emailReceipents.add(EmpHomeOfficeWeekScRow.getEmailAddress());
             }
          
             
         }
             
         
         Map<String, String> mailDetail = new HashMap<String,String>();
        
          HTMLTableBuilder tableBuilder = new HTMLTableBuilder();
          tableBuilder.buildHtmlTable(weekScheduleTableHeader,weekScheduleTableRows);
           String htmlTable =tableBuilder.getHtmlTable();
           
         System.out.println(tableBuilder.getHtmlTable() );  
        //  this.showMessage(tableBuilder.getHtmlTable() , "info");
     
         
               mailDetail.put("Subject", "Weekly Office Schedule");
               mailDetail.put("BodyText", "Weekly Office Schedule: Week No- "+
                                           appM.getHomeOfficeWeekListVO1().getCurrentRow().getAttribute("WeekRange"));
               mailDetail.put("WeekTable",htmlTable ) ;

         
//             emailReceipents =  new ArrayList<String>() ; 
//             emailReceipents.add(testRecipient);
         
       for(String  emailReceipent: emailReceipents){
         
        EmailSender.sendMail(mailDetail ,sender, emailReceipent  );
         
         }
       
      //  EmailSender.sendMail(mailDetail ,"sadman_fatin@mj-group.com", "sadman_fatin@mj-group.com");
       
    
    }

    public void testMethod2(ActionEvent actionEvent) {
        // Add event code here...
//        ViewObject dayScVo = appM.getEmpHomeOfficeDayScVO1();
//       
//       System.out.println(" dayScVo.getAllRowsInRange().length()  "+ dayScVo.getAllRowsInRange().length);
//        System.out.println("  dayScVo.getFetchedRowCount()  "+  dayScVo.getFetchedRowCount());
//        System.out.println("   dayScVo.getRowCount()  "+   dayScVo.getRowCount());
//        System.out.println("   dayScVo.getEstimatedRowCount() "+   dayScVo.getEstimatedRowCount());
//        System.out.println("   dayScVo.getRowSet().getEstimatedRowCount() "+   dayScVo.getRowSet().getEstimatedRowCount());        
//        System.out.println("   dayScVo.getRowSet().getFetchedRowCount() "+   dayScVo.getRowSet().getFetchedRowCount());
//        System.out.println("   dayScVo.getRowSet().getAllRowsInRange().length"+   dayScVo.getRowSet().getAllRowsInRange().length);
//        
//      RowSet rs = (RowSet)appM.getEmpHomeOfficeWeekScVO1().getCurrentRow().getAttribute("EmpHomeOfficeDayScVO");
//        
//        System.out.println("   rs.getAllRowsInRange().length"+   rs.getAllRowsInRange().length);
//        System.out.println("    rs.getFetchedRowCount()"+   rs.getFetchedRowCount());
//        System.out.println("    rs.getEstimatedRowCount()"+   rs.getEstimatedRowCount());
//        
//       
//         System.out.println("  dayScVo.getCurrentRow().getKey()"+   dayScVo.getCurrentRow().getKey().toString()); 
//          
//        
    }

    private void approveWeekSchedule() {
        
    String weekId =  appM.getHomeOfficeWeekListVO1().getCurrentRow().getAttribute("WeekId").toString();
    String currentDept = (String)appM.getDepartmentVO1().getCurrentRow().getAttribute("Departments");    
        
        String statement = "BEGIN apps.APPROVE_HOME_OFFICE_WEEK_DEPT(:1,:2); END;";
        CallableStatement cs =  appM.getDBTransaction().createCallableStatement(statement, 1);
        
        
        try {
            cs.setInt(1, Integer.parseInt(weekId));
            cs.setString(2,currentDept);
            cs.execute();
        }
        catch(Exception e){
            e.printStackTrace();
            ;
        }               
  
    }

    private void sendEmailOnSubmitToHead() {
        
        
        
        String testRecipient = (String)appM.getEmployeeVO1().getCurrentRow().getAttribute("EmailAddress"); 
          ArrayList<String> emailReceipents = new ArrayList<String>() ;
            String hdfRecipient ; 
          
          // email ID of  Sender. 
          String sender = (String)appM.getEmployeeVO1().getCurrentRow().getAttribute("EmailAddress");
          
          
          ArrayList<String> weekScheduleTableHeader = new ArrayList<String>();
          ArrayList<ArrayList<String>> weekScheduleTableRows= new ArrayList<ArrayList<String>>();
          ArrayList<String> weekScheduleTableRow;
          String[] tableRow ; 
          
          weekScheduleTableHeader.add("Emp No");
          weekScheduleTableHeader.add("Full Name");
          weekScheduleTableHeader.add("CO Office Total");
          
           for (Map.Entry<String,String> entry : this.getDayWiseDate().entrySet())  {
               weekScheduleTableHeader.add(entry.getValue());
           }
          
         Row[] rows ; 
        EmpHomeOfficeWeekScVORowImpl EmpHomeOfficeWeekScRow;
        
        rows = appM.getEmpHomeOfficeWeekScVO1().getAllRowsInRange();
           
           for(Row row : rows){
               EmpHomeOfficeWeekScRow = (EmpHomeOfficeWeekScVORowImpl)row;
               weekScheduleTableRow = new ArrayList<String>();
               weekScheduleTableRow.add(EmpHomeOfficeWeekScRow.getEmpNo().toString());
               weekScheduleTableRow.add(EmpHomeOfficeWeekScRow.getFullName());
               weekScheduleTableRow.add(EmpHomeOfficeWeekScRow.getEmpWeeklyCoOfficeCount().toString());
               weekScheduleTableRow.add(EmpHomeOfficeWeekScRow.getD1());
               weekScheduleTableRow.add(EmpHomeOfficeWeekScRow.getD2());
               weekScheduleTableRow.add(EmpHomeOfficeWeekScRow.getD3());
               weekScheduleTableRow.add(EmpHomeOfficeWeekScRow.getD4());
               weekScheduleTableRow.add(EmpHomeOfficeWeekScRow.getD5());
               weekScheduleTableRow.add(EmpHomeOfficeWeekScRow.getD6());
               weekScheduleTableRow.add(EmpHomeOfficeWeekScRow.getD7());
               weekScheduleTableRows.add(weekScheduleTableRow);
               
               hdfRecipient = EmpHomeOfficeWeekScRow.getHodValue();
               if(hdfRecipient.equals("HOD") && EmpHomeOfficeWeekScRow.getEmailAddress() != null ){
                   emailReceipents.add(EmpHomeOfficeWeekScRow.getEmailAddress()); 
               }
              
               
           }
               
           
           Map<String, String> mailDetail = new HashMap<String,String>();
          
            HTMLTableBuilder tableBuilder = new HTMLTableBuilder();
            tableBuilder.buildHtmlTable(weekScheduleTableHeader,weekScheduleTableRows);
             String htmlTable =tableBuilder.getHtmlTable();
             
           System.out.println(tableBuilder.getHtmlTable() );  
          //  this.showMessage(tableBuilder.getHtmlTable() , "info");
        
           
          mailDetail.put("Subject", "Updated Week Schedule of Week "+ appM.getHomeOfficeWeekListVO1().getCurrentRow().getAttribute("WeekRange"));
          mailDetail.put("BodyText", "Week Schedule of week: "+ appM.getHomeOfficeWeekListVO1().getCurrentRow().getAttribute("WeekRange")+" has been submitted by "+
             appM.getEmployeeVO1().getCurrentRow().getAttribute("FullName"));
          mailDetail.put("WeekTable",htmlTable ) ;
           
        //             emailReceipents =  new ArrayList<String>() ;
        //             emailReceipents.add(testRecipient);
           
         for(String  emailReceipent: emailReceipents){
           
         EmailSender.sendMail(mailDetail ,sender, emailReceipent  );
           
           }
         
    //    EmailSender.sendMail(mailDetail ,"sadman_fatin@mj-group.com", "sadman_fatin@mj-group.com");
        
    }
    
    
    public void clearAllEmpValueForWeek(ActionEvent actionEvent) {
        // Add event code here...
            
        setValueForAllEmpAllDay(null);    
            
       
    }


    public void employmentCatagoryValueChangeListener(ValueChangeEvent valueChangeEvent) {
      // Add event code here...
      //  System.out.println("---------- in employmentCatagoryValueChangeListener ");
        String employmentCatagory;
      //  System.out.println("------------  "+ valueChangeEvent.getNewValue());
        System.out.println(appM.getEmploymentCatagoryLov1().getCurrentRow().getAttribute("EmploymentCatagory") ); 
        
        setValueToEL("#{bindings.EmploymentCatagoryLov1.inputValue}",  valueChangeEvent.getNewValue());
          
        employmentCatagory = (String)appM.getEmploymentCatagoryLov1().getCurrentRow().getAttribute("EmploymentCatagory");               
        ViewObject homeOfficWeekScVo = appM.getEmpHomeOfficeWeekScVO1();        
        homeOfficWeekScVo.setNamedWhereClauseParam("p_employment_catagory", employmentCatagory);        
        homeOfficWeekScVo.executeQuery();
        
      //  appM.getHomeOfficeWeekListVO1().executeQuery();
        
        
        
        
        System.out.println(homeOfficWeekScVo.getAllRowsInRange().length);
            
        
        
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getEmployeeHomeOfficeDaysOfMonthTable());
        
    }

    public void setEmploymentCatagoryChoice(RichSelectOneChoice employmentCatagoryChoice) {
        this.employmentCatagoryChoice = employmentCatagoryChoice;
    }

    public RichSelectOneChoice getEmploymentCatagoryChoice() {
        return employmentCatagoryChoice;
    }

    public void setFirstSubmissionToHr(RichInputText firstSubmissionToHr) {
        this.FirstSubmissionToHr = firstSubmissionToHr;
    }

    public RichInputText getFirstSubmissionToHr() {
        return FirstSubmissionToHr;
    }

    private boolean isEditableColumnNull() {
        
        
        String currentDept = (String)appM.getDepartmentVO1().getCurrentRow().getAttribute("Departments");  
        
        String key, value;     
          Iterator ita ;
        
         RowSet rs = (RowSet)appM.getHomeOfficeWeekListVO1().getCurrentRow().getAttribute("EmpHomeOfficeWeekScVO");
        //  System.out.println();
         java.util.Date    date = null;
        boolean columnEditable;
        
             Row[] rows =  rs.getFilteredRows("Dept", currentDept );
             for(Row row : rows){
                 
        //   System.out.println("======  row " + row.getAttribute("EmpNo")+", "+ row.getAttribute("FullName"));
             ita= this.getDayWiseDate().keySet().iterator();        
             while(ita.hasNext()){
                 key = (String)ita.next();
                 value = dayWiseDate.get(key);                
                 try {
                     date = this.columnHeaderFormatter.parse(value);
                 } catch (ParseException e) {
                     ;
                 }
                 columnEditable  = checkColumnDateEditable(date);
        //                 System.out.println("======  key ,value, columnEditable  :" + key+", "+ value+ " "+ columnEditable );
                 
                 if( columnEditable && row.getAttribute(key)==null){
                     return true ;
                    
                    
                 }
             }
              
              
         }
        
        return false;  
     
    }

    public void copyPreviousWeekSc(ActionEvent actionEvent) {
//        // Add event code here...
    ViewObject weekListVo = appM.getHomeOfficeWeekListVO1();
        
    ViewObject weekScVo = appM.getEmpHomeOfficeWeekScVO1();
    
    
    int copyToWeekId=0, copyFromWeekId=0;
    String department=null, employmentCatagory = null;
    
    
    copyToWeekId =  Integer.parseInt(weekListVo.getCurrentRow().getAttribute("WeekId").toString()) ;
    copyFromWeekId = copyToWeekId-1;
    department=  appM.getDepartmentVO1().getCurrentRow().getAttribute("Departments").toString();
    employmentCatagory = appM.getEmploymentCatagoryLov1().getCurrentRow().getAttribute("EmploymentCatagory").toString();
    
    System.out.println("copyToWeekId "+copyToWeekId+ " copyFromWeekId "+ copyFromWeekId+ " department "+ department+ " employmentCatagory "+ employmentCatagory);
    
    
        
        String stmt =  "BEGIN   APPS.XX_COPY_HOME_OFF_WEEK_SC(:1,:2,:3,:4); end;";

        //   System.out.println("Procedure Code");
                           
        CallableStatement cs = appM.getDBTransaction().createCallableStatement(stmt, 1);
          
           
        try {
            cs.setInt(1, copyFromWeekId );
            cs.setInt(2, copyToWeekId );
            cs.setString(3, department );
            cs.setString(4, employmentCatagory );
              
            cs.execute();
            cs.close();
            
            weekScVo.executeQuery();
            
        } catch (Exception e) {
           e.printStackTrace();
        }
       
       AdfFacesContext.getCurrentInstance().addPartialTarget(this.getEmployeeHomeOfficeDaysOfMonthTable());
       
    }
    
   
    
    public boolean hasCurrentWeekStarted(){
        java.util.Date firstDayOfSelectedWeek=null;
      String   firstDayOfWeekValue =null;
         firstDayOfWeekValue = dayWiseDate.get("D1");

      //   System.out.println("firstDayOfWeekValue  "+ firstDayOfWeekValue);
        try {
            firstDayOfSelectedWeek = this.columnHeaderFormatter.parse(firstDayOfWeekValue);
        } catch (ParseException e) {
            ;
        }
      //  System.out.println(" firstDayOfSelectedWeek "+  firstDayOfSelectedWeek);
        
        boolean weekStarted=false;
      weekStarted  = !checkColumnDateEditable(firstDayOfSelectedWeek);
       
        System.out.println("weekStarted   "+ weekStarted );
       
       return weekStarted ;
       
       
    }

    public void setCopyFromPrevWeekButton(RichCommandButton copyFromPrevWeekButton) {
        this.copyFromPrevWeekButton = copyFromPrevWeekButton;
    }

    public RichCommandButton getCopyFromPrevWeekButton() {
        return copyFromPrevWeekButton;
    }

    private void restrictCopyFromWeek() {
        System.out.println("has current week started "+hasCurrentWeekStarted());
        
        getCopyFromPrevWeekButton().setDisabled(hasCurrentWeekStarted());
        
        getweekCopyTo().setDisabled(hasCurrentWeekStarted());
        getCopyFromWeekButton().setDisabled(hasCurrentWeekStarted());
        AdfFacesContext.getCurrentInstance().addPartialTarget(getCopyFromPrevWeekButton());
        AdfFacesContext.getCurrentInstance().addPartialTarget(getweekCopyTo());
        AdfFacesContext.getCurrentInstance().addPartialTarget(getCopyFromWeekButton());
        
    }

    public void setweekCopyTo(RichSelectOneChoice weekCopyTo) {
        this.weekCopyTo = weekCopyTo;
    }

    public RichSelectOneChoice getweekCopyTo() {
        return weekCopyTo;
    }

  
    private void filterCopyToWeekListVo() {
        int selectedWeekId =Integer.parseInt(appM.getHomeOfficeWeekListVO1().getCurrentRow().getAttribute("WeekId").toString()) ;
        
        ViewObject vo = appM.getCopyToWeekListVO1();
        
        vo.setNamedWhereClauseParam("p_week_id", selectedWeekId);
        vo.executeQuery();
    }

    public void copyToWeek(ActionEvent actionEvent) {
        // Add event code here...
        // Add event code here...
        ViewObject weekListVo = appM.getHomeOfficeWeekListVO1();
            
        ViewObject weekScVo = appM.getEmpHomeOfficeWeekScVO1();
        
        ViewObject  weekListVo2 =appM.getCopyToWeekListVO1();
        
    
        
        int copyToWeekId=0, copyFromWeekId=0;
        String department=null, employmentCatagory = null;
        
        
        copyToWeekId =  Integer.parseInt(weekListVo.getCurrentRow().getAttribute("WeekId").toString()) ;
        
        copyFromWeekId = Integer.parseInt(weekListVo2.getCurrentRow().getAttribute("WeekId").toString()) ;
        
        // System.out.println();
        
        int userId = 0 ;
        userId = Integer.parseInt(appM.getEmployeeVO1().getCurrentRow().getAttribute("UserId").toString()) ;
        
        
        department=  appM.getDepartmentVO1().getCurrentRow().getAttribute("Departments").toString();
        employmentCatagory = appM.getEmploymentCatagoryLov1().getCurrentRow().getAttribute("EmploymentCatagory").toString();
        
        System.out.println("copyToWeekId "+copyToWeekId+ " copyFromWeekId "+ copyFromWeekId+ " department "+ department+ " employmentCatagory "+ employmentCatagory);
        
            String stmt =  "BEGIN   APPS.XX_COPY_HOME_OFF_WEEK_SC(:1,:2,:3,:4,:5); end;";

            //   System.out.println("Procedure Code");
                               
            CallableStatement cs = appM.getDBTransaction().createCallableStatement(stmt, 1);
                           
            try {
                cs.setInt(1, copyFromWeekId );
                cs.setInt(2, copyToWeekId );
                cs.setString(3, department );
                cs.setString(4, employmentCatagory );  
                cs.setInt(5, userId );
                cs.execute();
                cs.close();
                
              
                
            } catch (Exception e) {
                
               e.printStackTrace();
            }
          weekScVo.executeQuery();
         
        updateHolidayForCurrentWeek();
           
           AdfFacesContext.getCurrentInstance().addPartialTarget(this.getEmployeeHomeOfficeDaysOfMonthTable());


        //          appM.getDBTransaction().commit();
        
    }

    public void setCopyFromWeekButton(RichCommandButton copyFromWeekButton) {
        this.copyFromWeekButton = copyFromWeekButton;
    }

    public RichCommandButton getCopyFromWeekButton() {
        return copyFromWeekButton;
    }


    
    public void refreshQueryKeepingCurrentRow(ViewObject viewObject )  {
        
        
         Row currentRow;
         Key currentRowKey;
         
         // added on 7.jan.18 to handle exception if view object has no current row
        try{
           currentRow = viewObject.getCurrentRow();
           currentRowKey = currentRow.getKey();
        }
        catch(Exception e){
            return;
        }
        
     
       
      
       int rangePosOfCurrentRow = viewObject.getRangeIndexOf(currentRow);
       int rangeStartBeforeQuery = viewObject.getRangeStart();
       viewObject.executeQuery();
       viewObject.setRangeStart(rangeStartBeforeQuery);
       /*
        * In 10.1.2, there is this convenience method we could use
        * instead of the remaining lines of code
        *
        *  findAndSetCurrentRowByKey(currentRowKey,rangePosOfCurrentRow);
        *  
        */
       
         
       Row[] rows = viewObject.findByKey(currentRowKey, 1);
       if (rows != null && rows.length == 1)
       {
          viewObject.scrollRangeTo(rows[0], rangePosOfCurrentRow);
          viewObject.setCurrentRowAtRangeIndex(viewObject.getRangeIndexOf(rows[0]));
       }
       
               
     }
    
    
    private void createCurrentWeekAndDaySc() {
        
        
        
        ViewObject weekListVo = appM.getHomeOfficeWeekListVO1();
            
        ViewObject weekScVo = appM.getEmpHomeOfficeWeekScVO1();
           
        int weekId=0; 
        String department=null, employmentCatagory = null;
        
        
         weekId =  Integer.parseInt(weekListVo.getCurrentRow().getAttribute("WeekId").toString()) ;
            
         System.out.println("Week id "+weekId ); 
            
            
        try {
            
            department=  appM.getDepartmentVO1().getCurrentRow().getAttribute("Departments").toString();
           
            
        } catch (NullPointerException e) {
            // TODO: Add catch code
          //  e.printStackTrace();
            department=  appM.getDepartmentVO1().first().getAttribute("Departments").toString();
        
            
        }
        
     
        
        System.out.println("department "+ department );
        
        
        
        String stmt =  "BEGIN   APPS.XX_CREATE_HOME_OFF_WEEK_DAY_SC(:1,:2); end;";

        //   System.out.println("Procedure Code");
                           
        CallableStatement cs = appM.getDBTransaction().createCallableStatement(stmt, 1);
       
        try {
            cs.setInt(1, weekId );
           cs.setString(2, department );
          
           cs.execute();
            cs.close();
        appM.getDBTransaction().commit();

        } catch (Exception e) {
           e.printStackTrace();
        }
        
        
        weekScVo.executeQuery();
        
        
        
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getEmployeeHomeOfficeDaysOfMonthTable());
        
        
        
    }
    
    private void setValueForAllEmpAllDay(String homeOfficeCohiceListValue) {
        
      
        
        String deptartment =
            (String)appM.getDepartmentVO1().getCurrentRow().getAttribute("Departments");

        RowSet empHomeOfficeWeekScVoRs =
            (RowSet)appM.getHomeOfficeWeekListVO1().getCurrentRow().getAttribute("EmpHomeOfficeWeekScVO");
        //  Row row;

        //        System.out.println("rs.getAllRowsInRange().length :"+ rs.getAllRowsInRange().length);
        //        System.out.println("rs.getRowCount() :"+ rs.getRowCount());
        //        System.out.println("rs.getFetchedRowCount() :"+ rs.getFetchedRowCount());

        Row[] empHomeOfficeWeekScVoRows ;
       empHomeOfficeWeekScVoRows = empHomeOfficeWeekScVoRs.getFilteredRows("Dept", deptartment);

        //  System.out.println("rows.length"+empHomeOfficeWeekScVoRows.length);
          
        empHomeOfficeWeekScVoRows = appM.getEmpHomeOfficeWeekScVO1().getAllRowsInRange();
       // System.out.println("rows.length"+empHomeOfficeWeekScVoRows.length);

        for (Row empHomeOfficeWeekScVoRow : empHomeOfficeWeekScVoRows) {
           // System.out.println("-------------------   home offfice week sc row :" + empHomeOfficeWeekScVoRow.getAttribute("FullName"));
            updateWeekScVoRow(empHomeOfficeWeekScVoRow, homeOfficeCohiceListValue);
        }
        
        appM.getEmpHomeOfficeWeekScVO1().executeQuery();



        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getEmployeeHomeOfficeDaysOfMonthTable());
        

        
        
    }
    
    private void updateHolidayForCurrentWeek() {
          
          
          
          
          ViewObject weekListVo = appM.getHomeOfficeWeekListVO1();
              
          ViewObject weekScVo = appM.getEmpHomeOfficeWeekScVO1();
             
          int weekId=0; 
          String department=null, employmentCatagory = null;
          
          
           weekId =  Integer.parseInt(weekListVo.getCurrentRow().getAttribute("WeekId").toString()) ;
              
         //  System.out.println("Week id "+weekId ); 
              
              
          try {
              
              department=  appM.getDepartmentVO1().getCurrentRow().getAttribute("Departments").toString();
             
              
          } catch (NullPointerException e) {
              // TODO: Add catch code
            //  e.printStackTrace();
              department=  appM.getDepartmentVO1().first().getAttribute("Departments").toString();
          
              
          }
          
          
          
          System.out.println("department "+ department );
          
          
          
          String stmt =  "BEGIN   APPS.XX_UPDATE_HOME_OFFICE_HOLIDAY(:1,:2); end;";

          //   System.out.println("Procedure Code");
                             
          CallableStatement cs = appM.getDBTransaction().createCallableStatement(stmt, 1);
          
          try {
              cs.setInt(1, weekId );
             cs.setString(2, department );
            
             cs.execute();
              cs.close();
          appM.getDBTransaction().commit();

          } catch (Exception e) {
             e.printStackTrace();
          }
          
          
          weekScVo.executeQuery();
          
          
          
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.getEmployeeHomeOfficeDaysOfMonthTable());
          
          
          
          
      }
    
    
}
