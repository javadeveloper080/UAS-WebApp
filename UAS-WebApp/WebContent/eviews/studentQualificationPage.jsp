<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>



<section id="container" >
    
    
    <!-- **********************************************************************************************************************************************************
    MAIN CONTENT
    *********************************************************************************************************************************************************** -->
    <!--main content start-->
    <section id="main-content">
        <section class="wrapper">
            
            <!-- BASIC FORM ELEMENTS -->
            <div class="row mt">
                <div class="col-lg-12">
                    <div class="form-panel">
                        <h5><Strong>Manage Student Qualification</Strong> </h5>
                                <html:form  styleClass="" action="/studentQlfAction?method=studentQualificationPage" method="post" styleId="studentQlfForm">
                            
                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <html:text name="studentQlfForm" property="searchText" styleId="searchText" styleClass="form-control" />
                                        <html:button property="searchButton" styleClass="btn-theme" value="Search" onclick="checkValidStudentRollNumber();" />
                                    </div>
                                </div>
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <label for="rollNum">Student Roll Number & Full Name.</label>
                                        <html:text name="studentQlfForm" property="rollNum" styleId="rollNum"  readonly="true"/>
                                        <html:text name="studentQlfForm" property="studentFullName" styleId="studentFullName"  readonly="true"/>
                                    </div>
                                </div>         
                            </div>
                            
                            <hr />
                            <!--Secondary Education starts-->
                              <h5><p ><em><strong style="color:blue"><bean:write name="studentQlfForm" property="statusMessage" /></strong></em></p></h5>
                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Secondary Name Institution  : <html:text  property="secondaryInstitutionName"  styleId="secondaryInstitutionName"   styleClass="form-control"/>
                                    </div>
                                </div>
                                
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Secondary Medium  : <html:text  property="sMedium"  styleId="sMedium"   styleClass="form-control"/>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Secondary Division  : <html:text  property="sdivision"  styleId="sdivision"   styleClass="form-control"/>
                                    </div>
                                </div>
                                
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Secondary Percentage : <html:text  property="spercentage"  styleId="spercentage"   styleClass="form-control" />
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Secondary Year Of Pass :  <html:text  property="syearOfPass"  styleId="syearOfPass"   styleClass="form-control"/>
                                    </div>
                                </div>
                            </div>
                            <!--Secondary Education Ends-->
                            
                            
                            
                            <hr />
                            <!--Inter Education Starts-->
                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Inter Name Institution  : <html:text  property="intrInstitutionName"  styleId="intrInstitutionName"   styleClass="form-control"/>
                                    </div>
                                </div>
                                
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Inter Medium  : <html:text  property="intrMedium"  styleId="intrMedium"   styleClass="form-control"/>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Inter Division  : <html:text  property="intrDivision"  styleId="intrDivision"   styleClass="form-control"/>
                                    </div>
                                </div>
                                
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Inter Percentage : <html:text  property="intrPercentage"  styleId="intrPercentage"   styleClass="form-control" />
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Inter Year Of Pass :  <html:text  property="intrYearOfPass"  styleId="intrYearOfPass"   styleClass="form-control"/>
                                    </div>
                                </div>
                            </div>
                            <!--Inter Education Ends-->
                            
                            <hr />
                            
                            <!--Diploma Education Starts-->
                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Diploma Name Institution  : <html:text  property="dipNameInstitution"  styleId="dipNameInstitution"   styleClass="form-control"/>
                                    </div>
                                </div>
                                
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Diploma Medium  : <html:text  property="dipMedium"  styleId="dipMedium"   styleClass="form-control"/>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Diploma Division  : <html:text  property="dipDivision"  styleId="dipDivision"   styleClass="form-control"/>
                                    </div>
                                </div>
                                
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Diploma Percentage : <html:text  property="dipPercentage"  styleId="dipPercentage"   styleClass="form-control" />
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Diploma Year Of Pass :  <html:text  property="dipYearOfPass"  styleId="dipYearOfPass"   styleClass="form-control"/>
                                    </div>
                                </div>
                            </div>
                            <!--Diploma Education Ends-->
                            <hr />
                            <!--Degree Education Starts-->
                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Degree Name Institution  : <html:text  property="degNameInstitution"  styleId="degNameInstitution"   styleClass="form-control"/>
                                    </div>
                                </div>
                                
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Degree Medium  : <html:text  property="degMedium"  styleId="degMedium"   styleClass="form-control"/>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Degree Division  : <html:text  property="degDivision"  styleId="degDivision"   styleClass="form-control"/>
                                    </div>
                                </div>
                                
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Degree Percentage : <html:text  property="degPercentage"  styleId="degPercentage"   styleClass="form-control" />
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Degree Year Of Pass :  <html:text  property="degYearOfPass"  styleId="degYearOfPass"   styleClass="form-control"/>
                                    </div>
                                </div>
                                
                            </div>
                            
                            <!--Degree Education Ends-->
                            
                            <!--html:text  property="branchName" size="30" styleId="description"  maxlength="100" /-->
                            <html:hidden name="studentQlfForm" property="id" styleId="id"/>
                            <html:hidden name="studentQlfForm" property="studentId" styleId="studentId"/>
                            <html:hidden name="studentQlfForm" property="pageName" styleId="pageName" />
                            <div align="center">
                                <html:button property="addBtn" styleClass="btn-theme" value="Apply" onclick="validateForm();" />
                                <html:button property="rsetBtn" styleClass="btn-theme" value="Reset" onclick="reset();" />
                            </div> 
                            
                            
                        </html:form>
                    </div>
                </div><!-- col-lg-12-->      	
            </div><!-- /row -->
            
        </section><! --/wrapper -->
    </section><!-- /MAIN CONTENT -->
    
    
    
    <!--main content end-->
    
</section>



<!--script for this page-->

<script>


    function validateForm() {
        // get the form values
        var intrInstitutionName = document.getElementById('intrInstitutionName').value;
        var intrMedium = document.getElementById('intrMedium').value;
        var intrDivision = document.getElementById('intrDivision').value;
        var intrPercentage = document.getElementById('intrPercentage').value;
        var intrYearOfPass = document.getElementById('intrYearOfPass').value;
        var secondaryInstitutionName = document.getElementById('secondaryInstitutionName').value;
        var sMedium = document.getElementById('sMedium').value;
        var sdivision = document.getElementById('sdivision').value;
        if (intrInstitutionName === null || intrInstitutionName === "") {
            alert("Please Enter Inter Institution Name");
            document.getElementById('intrInstitutionName').cfocus();
            return false;
        }

        else if (intrMedium === null || intrMedium === "") {
            alert("Please Enter Inter Medium");
            document.getElementById('intrMedium').focus();
            return false;
        }
        else if (intrDivision === null || intrDivision === "") {
            alert("Please Enter Inter Division");
            document.getElementById('intrDivision').focus();
            return false;
        }
        if (intrPercentage === null || intrPercentage === "") {
            alert("Please Enter Inter Percentage");
            document.getElementById('intrPercentage').focus();
            return false;
        }
        if (intrYearOfPass === null || intrYearOfPass === "") {
            alert("Please Enter Inter Year Of Pass");
            document.getElementById('intrYearOfPass').focus();
            return false;
        }
        if (secondaryInstitutionName === null || secondaryInstitutionName === "") {
            alert("Please Enter Secondary Institution Name");
            document.getElementById('secondaryInstitutionName').focus();
            return false;
        }
        if (sMedium === null || sMedium === "") {
            alert("Please Enter Second Medium");
            document.getElementById('sMedium').focus();
            return false;
        }
        if (sdivision === null || sdivision === "") {
            alert("Please Select gender type");
            document.getElementById('sdivision').focus();
            return false;
        }

        submitForm();

    }

    function submitForm() {
        var id = document.getElementById('id').value;
        if (id != null && id > 0) {
            document.getElementById('pageName').value = "SubmitEditType"
        } else {
            document.getElementById('pageName').value = "SubmitAddType"
        }
        document.getElementById('searchText').value =document.getElementById('rollNum').value ;
        document.studentQlfForm.action = "studentQlfAction.do?method=studentQualificationPage";
        document.studentQlfForm.submit();
    }


    function reset() {
        document.getElementById("studentQlfForm").reset();
    }
    
    function checkValidStudentRollNumber() {
        var   searchText= document.getElementById('searchText').value;
        if (searchText== null || searchText =="") {
            alert("Please Enter Roll Number in Search Box");
            document.getElementById('searchText').focus();
            return false;
        }
            
        alert('Search with RollNum : '+searchText);
				
        $.ajax({
            type: "POST",
            url: "/UAMS-WebApp/studentAction.do?method=findByStudentRollNumber",
            data: {
                "rollNum": searchText
            },
                    
            success: function(response){
                if(response=='false'){
                    alert('There is No Student found with this RollNumber :'+searchText);
                    document.getElementById('rollNum').focus();
                    return false;
                }
                else{
                    searchForm();
                }
            }
        });
    }
            
    function searchForm(){	
        document.studentQlfForm.action="studentQlfAction.do?method=studentQualificationPage";
        document.studentQlfForm.submit();
    }
</script>

