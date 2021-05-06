package model.views;

import model.entities.EmpHomeOfficeWeekScEOImpl;

import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Jun 23 11:54:07 BDT 2020
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class EmpHomeOfficeWeekScVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        D1 {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getD1();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setD1((String)value);
            }
        }
        ,
        D2 {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getD2();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setD2((String)value);
            }
        }
        ,
        D3 {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getD3();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setD3((String)value);
            }
        }
        ,
        D4 {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getD4();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setD4((String)value);
            }
        }
        ,
        D5 {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getD5();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setD5((String)value);
            }
        }
        ,
        D6 {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getD6();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setD6((String)value);
            }
        }
        ,
        D7 {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getD7();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setD7((String)value);
            }
        }
        ,
        EmpNo {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getEmpNo();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setEmpNo((Number)value);
            }
        }
        ,
        WeekId {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getWeekId();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setWeekId((Number)value);
            }
        }
        ,
        Remarks {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getRemarks();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setRemarks((String)value);
            }
        }
        ,
        HeadApproved {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getHeadApproved();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setHeadApproved((String)value);
            }
        }
        ,
        FullName {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getFullName();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setFullName((String)value);
            }
        }
        ,
        GradeId {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getGradeId();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setGradeId((Number)value);
            }
        }
        ,
        Position {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getPosition();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setPosition((String)value);
            }
        }
        ,
        Ssc {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getSsc();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setSsc((String)value);
            }
        }
        ,
        Section {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getSection();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setSection((String)value);
            }
        }
        ,
        Dept {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getDept();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setDept((String)value);
            }
        }
        ,
        Org {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getOrg();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setOrg((String)value);
            }
        }
        ,
        EmailAddress {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getEmailAddress();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setEmailAddress((String)value);
            }
        }
        ,
        HodValue {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getHodValue();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setHodValue((String)value);
            }
        }
        ,
        EmploymentCategory {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getEmploymentCategory();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setEmploymentCategory((String)value);
            }
        }
        ,
        EmpWeeklyHomeOfficeCount {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getEmpWeeklyHomeOfficeCount();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setEmpWeeklyHomeOfficeCount((Number)value);
            }
        }
        ,
        SetAllDayValue {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getSetAllDayValue();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setSetAllDayValue((String)value);
            }
        }
        ,
        EmpWeeklyCoOfficeCount {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getEmpWeeklyCoOfficeCount();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setEmpWeeklyCoOfficeCount((Number)value);
            }
        }
        ,
        EmpHomeOfficeDayScVO {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getEmpHomeOfficeDayScVO();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        HomeOfficeLov1 {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getHomeOfficeLov1();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        EmploymentCatagoryLov1 {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getEmploymentCatagoryLov1();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        HomeOfficeForSaturdayLov1 {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getHomeOfficeForSaturdayLov1();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        HomeOffice2Lov1 {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getHomeOffice2Lov1();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        HomeOfficeWithNoValueLov1 {
            public Object get(EmpHomeOfficeWeekScVORowImpl obj) {
                return obj.getHomeOfficeWithNoValueLov1();
            }

            public void put(EmpHomeOfficeWeekScVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(EmpHomeOfficeWeekScVORowImpl object);

        public abstract void put(EmpHomeOfficeWeekScVORowImpl object,
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


    public static final int D1 = AttributesEnum.D1.index();
    public static final int D2 = AttributesEnum.D2.index();
    public static final int D3 = AttributesEnum.D3.index();
    public static final int D4 = AttributesEnum.D4.index();
    public static final int D5 = AttributesEnum.D5.index();
    public static final int D6 = AttributesEnum.D6.index();
    public static final int D7 = AttributesEnum.D7.index();
    public static final int EMPNO = AttributesEnum.EmpNo.index();
    public static final int WEEKID = AttributesEnum.WeekId.index();
    public static final int REMARKS = AttributesEnum.Remarks.index();
    public static final int HEADAPPROVED = AttributesEnum.HeadApproved.index();
    public static final int FULLNAME = AttributesEnum.FullName.index();
    public static final int GRADEID = AttributesEnum.GradeId.index();
    public static final int POSITION = AttributesEnum.Position.index();
    public static final int SSC = AttributesEnum.Ssc.index();
    public static final int SECTION = AttributesEnum.Section.index();
    public static final int DEPT = AttributesEnum.Dept.index();
    public static final int ORG = AttributesEnum.Org.index();
    public static final int EMAILADDRESS = AttributesEnum.EmailAddress.index();
    public static final int HODVALUE = AttributesEnum.HodValue.index();
    public static final int EMPLOYMENTCATEGORY = AttributesEnum.EmploymentCategory.index();
    public static final int EMPWEEKLYHOMEOFFICECOUNT = AttributesEnum.EmpWeeklyHomeOfficeCount.index();
    public static final int SETALLDAYVALUE = AttributesEnum.SetAllDayValue.index();
    public static final int EMPWEEKLYCOOFFICECOUNT = AttributesEnum.EmpWeeklyCoOfficeCount.index();
    public static final int EMPHOMEOFFICEDAYSCVO = AttributesEnum.EmpHomeOfficeDayScVO.index();
    public static final int HOMEOFFICELOV1 = AttributesEnum.HomeOfficeLov1.index();
    public static final int EMPLOYMENTCATAGORYLOV1 = AttributesEnum.EmploymentCatagoryLov1.index();
    public static final int HOMEOFFICEFORSATURDAYLOV1 = AttributesEnum.HomeOfficeForSaturdayLov1.index();
    public static final int HOMEOFFICE2LOV1 = AttributesEnum.HomeOffice2Lov1.index();
    public static final int HOMEOFFICEWITHNOVALUELOV1 = AttributesEnum.HomeOfficeWithNoValueLov1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public EmpHomeOfficeWeekScVORowImpl() {
    }

    /**
     * Gets EmpHomeOfficeWeekScEO entity object.
     * @return the EmpHomeOfficeWeekScEO
     */
    public EmpHomeOfficeWeekScEOImpl getEmpHomeOfficeWeekScEO() {
        return (EmpHomeOfficeWeekScEOImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for D1 using the alias name D1.
     * @return the D1
     */
    public String getD1() {
        return (String) getAttributeInternal(D1);
    }

    /**
     * Sets <code>value</code> as attribute value for D1 using the alias name D1.
     * @param value value to set the D1
     */
    public void setD1(String value) {
        setAttributeInternal(D1, value);
    }

    /**
     * Gets the attribute value for D2 using the alias name D2.
     * @return the D2
     */
    public String getD2() {
        return (String) getAttributeInternal(D2);
    }

    /**
     * Sets <code>value</code> as attribute value for D2 using the alias name D2.
     * @param value value to set the D2
     */
    public void setD2(String value) {
        setAttributeInternal(D2, value);
    }

    /**
     * Gets the attribute value for D3 using the alias name D3.
     * @return the D3
     */
    public String getD3() {
        return (String) getAttributeInternal(D3);
    }

    /**
     * Sets <code>value</code> as attribute value for D3 using the alias name D3.
     * @param value value to set the D3
     */
    public void setD3(String value) {
        setAttributeInternal(D3, value);
    }

    /**
     * Gets the attribute value for D4 using the alias name D4.
     * @return the D4
     */
    public String getD4() {
        return (String) getAttributeInternal(D4);
    }

    /**
     * Sets <code>value</code> as attribute value for D4 using the alias name D4.
     * @param value value to set the D4
     */
    public void setD4(String value) {
        setAttributeInternal(D4, value);
    }

    /**
     * Gets the attribute value for D5 using the alias name D5.
     * @return the D5
     */
    public String getD5() {
        return (String) getAttributeInternal(D5);
    }

    /**
     * Sets <code>value</code> as attribute value for D5 using the alias name D5.
     * @param value value to set the D5
     */
    public void setD5(String value) {
        setAttributeInternal(D5, value);
    }

    /**
     * Gets the attribute value for D6 using the alias name D6.
     * @return the D6
     */
    public String getD6() {
        return (String) getAttributeInternal(D6);
    }

    /**
     * Sets <code>value</code> as attribute value for D6 using the alias name D6.
     * @param value value to set the D6
     */
    public void setD6(String value) {
        setAttributeInternal(D6, value);
    }

    /**
     * Gets the attribute value for D7 using the alias name D7.
     * @return the D7
     */
    public String getD7() {
       // return "Weekly Holiday" ;
        return (String) getAttributeInternal(D7);
    }

    /**
     * Sets <code>value</code> as attribute value for D7 using the alias name D7.
     * @param value value to set the D7
     */
    public void setD7(String value) {
        setAttributeInternal(D7, value);
    }


    /**
     * Gets the attribute value for EMP_NO using the alias name EmpNo.
     * @return the EMP_NO
     */
    public Number getEmpNo() {
        return (Number) getAttributeInternal(EMPNO);
    }

    /**
     * Sets <code>value</code> as attribute value for EMP_NO using the alias name EmpNo.
     * @param value value to set the EMP_NO
     */
    public void setEmpNo(Number value) {
        setAttributeInternal(EMPNO, value);
    }


    /**
     * Gets the attribute value for WEEK_ID using the alias name WeekId.
     * @return the WEEK_ID
     */
    public Number getWeekId() {
        return (Number) getAttributeInternal(WEEKID);
    }

    /**
     * Sets <code>value</code> as attribute value for WEEK_ID using the alias name WeekId.
     * @param value value to set the WEEK_ID
     */
    public void setWeekId(Number value) {
        setAttributeInternal(WEEKID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute EmpWeeklyHomeOfficeCount.
     * @return the EmpWeeklyHomeOfficeCount
     */
    public Number getEmpWeeklyHomeOfficeCount() {
        int count=0;
       
        
        if(  this.getD1() != null &&  this.getD1().equals("Home Office"))
        count++;
        if( this.getD2() != null && this.getD2().equals("Home Office"))
        count++;
        if(this.getD3() != null && this.getD3().equals("Home Office"))
        count++;        
        if(this.getD4() != null && this.getD4().equals("Home Office"))
        count++;
        if(this.getD5() != null && this.getD5().equals("Home Office"))
        count++;
        if(this.getD6() != null && this.getD6().equals("Home Office"))
        count++;
        
        
        return new Number(count);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute EmpWeeklyHomeOfficeCount.
     * @param value value to set the  EmpWeeklyHomeOfficeCount
     */
    public void setEmpWeeklyHomeOfficeCount(Number value) {
        setAttributeInternal(EMPWEEKLYHOMEOFFICECOUNT, value);
    }

    /**
     * Gets the attribute value for the calculated attribute SetAllDayValue.
     * @return the SetAllDayValue
     */
    public String getSetAllDayValue() {
        return (String) getAttributeInternal(SETALLDAYVALUE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute SetAllDayValue.
     * @param value value to set the  SetAllDayValue
     */
    public void setSetAllDayValue(String value) {
        setAttributeInternal(SETALLDAYVALUE, value);
//        this.setD1(value);
//        this.setD2(value);
//        this.setD3(value);
//        this.setD4(value);
//        this.setD5(value);
//        this.setD6(value);
       
    }

    /**
     * Gets the attribute value for REMARKS using the alias name Remarks.
     * @return the REMARKS
     */
    public String getRemarks() {
        return (String) getAttributeInternal(REMARKS);
    }

    /**
     * Sets <code>value</code> as attribute value for REMARKS using the alias name Remarks.
     * @param value value to set the REMARKS
     */
    public void setRemarks(String value) {
        setAttributeInternal(REMARKS, value);
    }

    /**
     * Gets the attribute value for the calculated attribute FullName.
     * @return the FullName
     */
    public String getFullName() {
        return (String) getAttributeInternal(FULLNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute FullName.
     * @param value value to set the  FullName
     */
    public void setFullName(String value) {
        setAttributeInternal(FULLNAME, value);
    }

    /**
     * Gets the attribute value for the calculated attribute GradeId.
     * @return the GradeId
     */
    public Number getGradeId() {
        return (Number) getAttributeInternal(GRADEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute GradeId.
     * @param value value to set the  GradeId
     */
    public void setGradeId(Number value) {
        setAttributeInternal(GRADEID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Position.
     * @return the Position
     */
    public String getPosition() {
        return (String) getAttributeInternal(POSITION);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Position.
     * @param value value to set the  Position
     */
    public void setPosition(String value) {
        setAttributeInternal(POSITION, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Ssc.
     * @return the Ssc
     */
    public String getSsc() {
        return (String) getAttributeInternal(SSC);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Ssc.
     * @param value value to set the  Ssc
     */
    public void setSsc(String value) {
        setAttributeInternal(SSC, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Section.
     * @return the Section
     */
    public String getSection() {
        return (String) getAttributeInternal(SECTION);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Section.
     * @param value value to set the  Section
     */
    public void setSection(String value) {
        setAttributeInternal(SECTION, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Dept.
     * @return the Dept
     */
    public String getDept() {
        return (String) getAttributeInternal(DEPT);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Dept.
     * @param value value to set the  Dept
     */
    public void setDept(String value) {
        setAttributeInternal(DEPT, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Org.
     * @return the Org
     */
    public String getOrg() {
        return (String) getAttributeInternal(ORG);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Org.
     * @param value value to set the  Org
     */
    public void setOrg(String value) {
        setAttributeInternal(ORG, value);
    }

    /**
     * Gets the attribute value for the calculated attribute EmailAddress.
     * @return the EmailAddress
     */
    public String getEmailAddress() {
        return (String) getAttributeInternal(EMAILADDRESS);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute EmailAddress.
     * @param value value to set the  EmailAddress
     */
    public void setEmailAddress(String value) {
        setAttributeInternal(EMAILADDRESS, value);
    }

    /**
     * Gets the attribute value for the calculated attribute HodValue.
     * @return the HodValue
     */
    public String getHodValue() {
        return (String) getAttributeInternal(HODVALUE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute HodValue.
     * @param value value to set the  HodValue
     */
    public void setHodValue(String value) {
        setAttributeInternal(HODVALUE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute EmploymentCategory.
     * @return the EmploymentCategory
     */
    public String getEmploymentCategory() {
        return (String) getAttributeInternal(EMPLOYMENTCATEGORY);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute EmploymentCategory.
     * @param value value to set the  EmploymentCategory
     */
    public void setEmploymentCategory(String value) {
        setAttributeInternal(EMPLOYMENTCATEGORY, value);
    }

    /**
     * Gets the attribute value for the calculated attribute EmpWeeklyCoOfficeCount.
     * @return the EmpWeeklyCoOfficeCount
     */
    public Number getEmpWeeklyCoOfficeCount() {
        int count=0;        
        if(  this.getD1() != null &&  this.getD1().equals("CO Office"))
        count++;
        if( this.getD2() != null && this.getD2().equals("CO Office"))
        count++;
        if(this.getD3() != null && this.getD3().equals("CO Office"))
        count++;        
        if(this.getD4() != null && this.getD4().equals("CO Office"))
        count++;
        if(this.getD5() != null && this.getD5().equals("CO Office"))
        count++;
        if(this.getD6() != null && this.getD6().equals("CO Office"))
        count++;
                
        return new Number(count);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute EmpWeeklyCoOfficeCount.
     * @param value value to set the  EmpWeeklyCoOfficeCount
     */
    public void setEmpWeeklyCoOfficeCount(Number value) {
        setAttributeInternal(EMPWEEKLYCOOFFICECOUNT, value);
    }

    /**
     * Gets the attribute value for HEAD_APPROVED using the alias name HeadApproved.
     * @return the HEAD_APPROVED
     */
    public String getHeadApproved() {
        return (String) getAttributeInternal(HEADAPPROVED);
    }

    /**
     * Sets <code>value</code> as attribute value for HEAD_APPROVED using the alias name HeadApproved.
     * @param value value to set the HEAD_APPROVED
     */
    public void setHeadApproved(String value) {
        setAttributeInternal(HEADAPPROVED, value);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link EmpHomeOfficeDayScVO.
     */
    public RowIterator getEmpHomeOfficeDayScVO() {
        return (RowIterator)getAttributeInternal(EMPHOMEOFFICEDAYSCVO);
    }

    /**
     * Gets the view accessor <code>RowSet</code> HomeOfficeLov1.
     */
    public RowSet getHomeOfficeLov1() {
        return (RowSet)getAttributeInternal(HOMEOFFICELOV1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> EmploymentCatagoryLov1.
     */
    public RowSet getEmploymentCatagoryLov1() {
        return (RowSet)getAttributeInternal(EMPLOYMENTCATAGORYLOV1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> HomeOfficeForSaturdayLov1.
     */
    public RowSet getHomeOfficeForSaturdayLov1() {
        return (RowSet)getAttributeInternal(HOMEOFFICEFORSATURDAYLOV1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> HomeOffice2Lov1.
     */
    public RowSet getHomeOffice2Lov1() {
        return (RowSet)getAttributeInternal(HOMEOFFICE2LOV1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> HomeOfficeWithNoValueLov1.
     */
    public RowSet getHomeOfficeWithNoValueLov1() {
        return (RowSet)getAttributeInternal(HOMEOFFICEWITHNOVALUELOV1);
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
}
