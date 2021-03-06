package model.entities;

import java.sql.SQLException;

import java.util.Map;

import model.services.AppModuleImpl;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.share.ADFContext;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Jul 01 15:40:46 BDT 2020
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class EmpHomeOfficeWeekScEOImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        EmpNo {
            public Object get(EmpHomeOfficeWeekScEOImpl obj) {
                return obj.getEmpNo();
            }

            public void put(EmpHomeOfficeWeekScEOImpl obj, Object value) {
                obj.setEmpNo((Number)value);
            }
        }
        ,
        D1 {
            public Object get(EmpHomeOfficeWeekScEOImpl obj) {
                return obj.getD1();
            }

            public void put(EmpHomeOfficeWeekScEOImpl obj, Object value) {
                obj.setD1((String)value);
            }
        }
        ,
        D2 {
            public Object get(EmpHomeOfficeWeekScEOImpl obj) {
                return obj.getD2();
            }

            public void put(EmpHomeOfficeWeekScEOImpl obj, Object value) {
                obj.setD2((String)value);
            }
        }
        ,
        D3 {
            public Object get(EmpHomeOfficeWeekScEOImpl obj) {
                return obj.getD3();
            }

            public void put(EmpHomeOfficeWeekScEOImpl obj, Object value) {
                obj.setD3((String)value);
            }
        }
        ,
        D4 {
            public Object get(EmpHomeOfficeWeekScEOImpl obj) {
                return obj.getD4();
            }

            public void put(EmpHomeOfficeWeekScEOImpl obj, Object value) {
                obj.setD4((String)value);
            }
        }
        ,
        D5 {
            public Object get(EmpHomeOfficeWeekScEOImpl obj) {
                return obj.getD5();
            }

            public void put(EmpHomeOfficeWeekScEOImpl obj, Object value) {
                obj.setD5((String)value);
            }
        }
        ,
        D6 {
            public Object get(EmpHomeOfficeWeekScEOImpl obj) {
                return obj.getD6();
            }

            public void put(EmpHomeOfficeWeekScEOImpl obj, Object value) {
                obj.setD6((String)value);
            }
        }
        ,
        WeekId {
            public Object get(EmpHomeOfficeWeekScEOImpl obj) {
                return obj.getWeekId();
            }

            public void put(EmpHomeOfficeWeekScEOImpl obj, Object value) {
                obj.setWeekId((Number)value);
            }
        }
        ,
        D7 {
            public Object get(EmpHomeOfficeWeekScEOImpl obj) {
                return obj.getD7();
            }

            public void put(EmpHomeOfficeWeekScEOImpl obj, Object value) {
                obj.setD7((String)value);
            }
        }
        ,
        Remarks {
            public Object get(EmpHomeOfficeWeekScEOImpl obj) {
                return obj.getRemarks();
            }

            public void put(EmpHomeOfficeWeekScEOImpl obj, Object value) {
                obj.setRemarks((String)value);
            }
        }
        ,
        LastUpdatedBy {
            public Object get(EmpHomeOfficeWeekScEOImpl obj) {
                return obj.getLastUpdatedBy();
            }

            public void put(EmpHomeOfficeWeekScEOImpl obj, Object value) {
                obj.setLastUpdatedBy((Number)value);
            }
        }
        ,
        LastUpdateDate {
            public Object get(EmpHomeOfficeWeekScEOImpl obj) {
                return obj.getLastUpdateDate();
            }

            public void put(EmpHomeOfficeWeekScEOImpl obj, Object value) {
                obj.setLastUpdateDate((Date)value);
            }
        }
        ,
        HeadApproved {
            public Object get(EmpHomeOfficeWeekScEOImpl obj) {
                return obj.getHeadApproved();
            }

            public void put(EmpHomeOfficeWeekScEOImpl obj, Object value) {
                obj.setHeadApproved((String)value);
            }
        }
        ,
        SendMail {
            public Object get(EmpHomeOfficeWeekScEOImpl obj) {
                return obj.getSendMail();
            }

            public void put(EmpHomeOfficeWeekScEOImpl obj, Object value) {
                obj.setSendMail((String)value);
            }
        }
        ,
        HomeOfficeWeekListEO {
            public Object get(EmpHomeOfficeWeekScEOImpl obj) {
                return obj.getHomeOfficeWeekListEO();
            }

            public void put(EmpHomeOfficeWeekScEOImpl obj, Object value) {
                obj.setHomeOfficeWeekListEO((EntityImpl)value);
            }
        }
        ,
        EmpHomeOfficeDayScEO {
            public Object get(EmpHomeOfficeWeekScEOImpl obj) {
                return obj.getEmpHomeOfficeDayScEO();
            }

            public void put(EmpHomeOfficeWeekScEOImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(EmpHomeOfficeWeekScEOImpl object);

        public abstract void put(EmpHomeOfficeWeekScEOImpl object,
                                 Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int EMPNO = AttributesEnum.EmpNo.index();
    public static final int D1 = AttributesEnum.D1.index();
    public static final int D2 = AttributesEnum.D2.index();
    public static final int D3 = AttributesEnum.D3.index();
    public static final int D4 = AttributesEnum.D4.index();
    public static final int D5 = AttributesEnum.D5.index();
    public static final int D6 = AttributesEnum.D6.index();
    public static final int WEEKID = AttributesEnum.WeekId.index();
    public static final int D7 = AttributesEnum.D7.index();
    public static final int REMARKS = AttributesEnum.Remarks.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDATE = AttributesEnum.LastUpdateDate.index();
    public static final int HEADAPPROVED = AttributesEnum.HeadApproved.index();
    public static final int SENDMAIL = AttributesEnum.SendMail.index();
    public static final int HOMEOFFICEWEEKLISTEO = AttributesEnum.HomeOfficeWeekListEO.index();
    public static final int EMPHOMEOFFICEDAYSCEO = AttributesEnum.EmpHomeOfficeDayScEO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public EmpHomeOfficeWeekScEOImpl() {
    }


   // AppModuleImpl appM  = getAppModuleImpl();


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("model.entities.EmpHomeOfficeWeekScEO");
        }
        return mDefinitionObject;
    }

    public AppModuleImpl getAppModuleImpl() {
    DCBindingContainer bindingContainer =
     (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    //BindingContext bindingContext = BindingContext.getCurrent();
    DCDataControl dc =
     bindingContainer.findDataControl("AppModuleDataControl"); // Name of application module in datacontrolBinding.cpx
    AppModuleImpl appM = (AppModuleImpl)dc.getDataProvider();
    return appM;
    }


    /**
     * Gets the attribute value for EmpNo, using the alias name EmpNo.
     * @return the EmpNo
     */
    public Number getEmpNo() {
        return (Number)getAttributeInternal(EMPNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for EmpNo.
     * @param value value to set the EmpNo
     */
    public void setEmpNo(Number value) {
        setAttributeInternal(EMPNO, value);
    }


    /**
     * Gets the attribute value for D1, using the alias name D1.
     * @return the D1
     */
    public String getD1() {
        return (String)getAttributeInternal(D1);
    }

    /**
     * Sets <code>value</code> as the attribute value for D1.
     * @param value value to set the D1
     */
    public void setD1(String value) {
        setAttributeInternal(D1, value);
    }

    /**
     * Gets the attribute value for D2, using the alias name D2.
     * @return the D2
     */
    public String getD2() {
        return (String)getAttributeInternal(D2);
    }

    /**
     * Sets <code>value</code> as the attribute value for D2.
     * @param value value to set the D2
     */
    public void setD2(String value) {
        setAttributeInternal(D2, value);
    }

    /**
     * Gets the attribute value for D3, using the alias name D3.
     * @return the D3
     */
    public String getD3() {
        return (String)getAttributeInternal(D3);
    }

    /**
     * Sets <code>value</code> as the attribute value for D3.
     * @param value value to set the D3
     */
    public void setD3(String value) {
        setAttributeInternal(D3, value);
    }

    /**
     * Gets the attribute value for D4, using the alias name D4.
     * @return the D4
     */
    public String getD4() {
        return (String)getAttributeInternal(D4);
    }

    /**
     * Sets <code>value</code> as the attribute value for D4.
     * @param value value to set the D4
     */
    public void setD4(String value) {
        setAttributeInternal(D4, value);
    }

    /**
     * Gets the attribute value for D5, using the alias name D5.
     * @return the D5
     */
    public String getD5() {
        return (String)getAttributeInternal(D5);
    }

    /**
     * Sets <code>value</code> as the attribute value for D5.
     * @param value value to set the D5
     */
    public void setD5(String value) {
        setAttributeInternal(D5, value);
    }

    /**
     * Gets the attribute value for D6, using the alias name D6.
     * @return the D6
     */
    public String getD6() {
        return (String)getAttributeInternal(D6);
    }

    /**
     * Sets <code>value</code> as the attribute value for D6.
     * @param value value to set the D6
     */
    public void setD6(String value) {
        setAttributeInternal(D6, value);
    }

    /**
     * Gets the attribute value for WeekId, using the alias name WeekId.
     * @return the WeekId
     */
    public Number getWeekId() {
        return (Number)getAttributeInternal(WEEKID);
    }

    /**
     * Sets <code>value</code> as the attribute value for WeekId.
     * @param value value to set the WeekId
     */
    public void setWeekId(Number value) {
        setAttributeInternal(WEEKID, value);
    }


    /**
     * Gets the attribute value for D7, using the alias name D7.
     * @return the D7
     */
    public String getD7() {
        return (String)getAttributeInternal(D7);
    }

    /**
     * Sets <code>value</code> as the attribute value for D7.
     * @param value value to set the D7
     */
    public void setD7(String value) {
        setAttributeInternal(D7, value);
    }

    /**
     * Gets the attribute value for Remarks, using the alias name Remarks.
     * @return the Remarks
     */
    public String getRemarks() {
        return (String)getAttributeInternal(REMARKS);
    }

    /**
     * Sets <code>value</code> as the attribute value for Remarks.
     * @param value value to set the Remarks
     */
    public void setRemarks(String value) {
        setAttributeInternal(REMARKS, value);
    }

    /**
     * Gets the attribute value for LastUpdatedBy, using the alias name LastUpdatedBy.
     * @return the LastUpdatedBy
     */
    public Number getLastUpdatedBy() {
        return (Number)getAttributeInternal(LASTUPDATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for LastUpdatedBy.
     * @param value value to set the LastUpdatedBy
     */
    public void setLastUpdatedBy(Number value) {
        setAttributeInternal(LASTUPDATEDBY, value);
    }


    /**
     * Gets the attribute value for LastUpdateDate, using the alias name LastUpdateDate.
     * @return the LastUpdateDate
     */
    public Date getLastUpdateDate() {
        return (Date)getAttributeInternal(LASTUPDATEDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for LastUpdateDate.
     * @param value value to set the LastUpdateDate
     */
    public void setLastUpdateDate(Date value) {
        setAttributeInternal(LASTUPDATEDATE, value);
    }

    /**
     * Gets the attribute value for HeadApproved, using the alias name HeadApproved.
     * @return the HeadApproved
     */
    public String getHeadApproved() {
        return (String)getAttributeInternal(HEADAPPROVED);
    }

    /**
     * Sets <code>value</code> as the attribute value for HeadApproved.
     * @param value value to set the HeadApproved
     */
    public void setHeadApproved(String value) {
        setAttributeInternal(HEADAPPROVED, value);
    }

    /**
     * Gets the attribute value for SendMail, using the alias name SendMail.
     * @return the SendMail
     */
    public String getSendMail() {
        return (String)getAttributeInternal(SENDMAIL);
    }

    /**
     * Sets <code>value</code> as the attribute value for SendMail.
     * @param value value to set the SendMail
     */
    public void setSendMail(String value) {
        setAttributeInternal(SENDMAIL, value);
    }

    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value,
                                         AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }

    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getHomeOfficeWeekListEO() {
        return (EntityImpl)getAttributeInternal(HOMEOFFICEWEEKLISTEO);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setHomeOfficeWeekListEO(EntityImpl value) {
        setAttributeInternal(HOMEOFFICEWEEKLISTEO, value);
    }


    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getEmpHomeOfficeDayScEO() {
        return (RowIterator)getAttributeInternal(EMPHOMEOFFICEDAYSCEO);
    }


    /**
     * @param empNo key constituent
     * @param weekId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number empNo, Number weekId) {
        return new Key(new Object[]{empNo, weekId});
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
    }

    /**
     * Add locking logic here.
     */
    public void lock() {
        super.lock();
    }

    /**
     * Custom DML update/insert/delete logic here.
     * @param operation the operation type
     * @param e the transaction event
     */
    protected void doDML(int operation, TransactionEvent e) {
        
        Map sessionScope = ADFContext.getCurrent().getSessionScope();
        String user="" ;
        try {
           user=  (String)sessionScope.get("userId");
        } catch (Exception e1) {
            // TODO: Add catch code
            e1.printStackTrace();
        }
        String currentDept = (String)this.getAppModuleImpl().getDepartmentVO1().getCurrentRow().getAttribute("Departments");
         
        
        
        Key  key = new  Key(new Object[]{ currentDept, this.getWeekId()});
        
        
        String hodValue = (String)this.getAppModuleImpl().getEmployeeVO1().getCurrentRow().getAttribute("HodValue");
        
        
        ViewObject weekWiseDeptVo2 =  this.getAppModuleImpl().getHomeOfficeWeekWiseDeptVO2();
        
        Row[]  weekWiseDeptVo2Rows = weekWiseDeptVo2.findByKey(key, 1);    
         Row weewWiseDeptVo2Row = weekWiseDeptVo2Rows[0];
         
        //  System.out.println("Document No -->" + getSrNoString());
        
        if (DML_UPDATE == operation) {
            try {
                setLastUpdateDate((Date)Date.getCurrentDate());
                setLastUpdatedBy(new oracle.jbo.domain.Number(user));
              //  System.out.println("Level Update "+(user));
               setHeadApproved("n");
                
               // System.out.println("dml done in emp home office week sc");
                
                if(hodValue != null &&   hodValue.equals("HOD")){
                   
                   weewWiseDeptVo2Row.setAttribute("SubmittedToHr", "n");
                }
                else{
                   weewWiseDeptVo2Row.setAttribute("SubmittedToHead", "n");
                     weewWiseDeptVo2Row.setAttribute("SubmittedToHr", "n");
                }                        
            
                this.getAppModuleImpl().getHomeOfficeWeekWiseDeptVO1().executeQuery();
                
                                
                                     
                
            } catch (SQLException f) {
                System.out.println(f.getMessage());
            }
        } else if (DML_INSERT == operation) {
            

        }

        super.doDML(operation, e);
        
        
    }
}
