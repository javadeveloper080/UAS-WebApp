<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

<section id="container">


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
						<h5>
							<Strong>Manage Generated Letters</Strong>
						</h5>
						<html:form styleClass="" action="/letterTemplateAction"
							method="post" styleId="letterTemplateForm">




							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<label for="letterTemplateId">Letter Template</label>
										<html:select property="letterTemplateId"
											styleId="letterTemplateId" styleClass="form-control">
											<html:option styleClass="form-control" value=""></html:option>
											<html:optionsCollection name="letterTemplateForm"
												property="letterTemplateList" label="code" value="id" />
										</html:select>
										<html:button property="searchButton" styleClass="btn-theme"
											value="Retrieve Letters" onclick="retrieveLetters();" />
									</div>
								</div>


							</div>

						</html:form>
					</div>
				</div>
				<!-- col-lg-12-->
			</div>
			<!-- /row -->


			<!-- GRID ELEMENTS -->
			<div class="row mt">
				<div class="col-md-12">
					<div class="content-panel">
						<table class="table table-striped table-advance table-hover">
							<h4>Template Generated Letters Table</h4>
							<hr>

							<thead>
								<tr>
									<th scope="col"><i>Student Roll Number</i></th>
									<th scope="col"><i>Letter template code</i></th>
									<th scope="col"><i>Letter template description</i></th>
									<th scope="col"><i>Download genrated letter</i></th>
								</tr>
							</thead>

							<tbody>
								<logic:notEmpty name="letterTemplateForm"
									property="generatedTemplateList">
									<logic:iterate id="genrateTable" name="studentAddressForm"
										property="generatedTemplateList"
										type="org.edu.uams.server.pojo.GeneratedLetterEntity">
										<tr>
											<td><bean:write name="genrateTable"
													property="student.rollNum" /></td>

											<td><bean:write name="genrateTable"
													property="letterTemplate.code" /></td>

											<td><bean:write name="genrateTable"
													property="letterTemplate.description" /></td>

											<td><button class="btn btn-primary btn-xs"
													onclick='downloadTemplate(${genrateTable.documentId});'>
													<i class="fa fa-pencil"></i>
												</button></td>
										</tr>
									</logic:iterate>
								</logic:notEmpty>
							</tbody>
						</table>
					</div>
					<!-- /content-panel -->
				</div>
				<!-- /col-md-12 -->
			</div>
			<!-- /row -->





		</section>
		<! --/wrapper -->
	</section>
	<!-- /MAIN CONTENT -->








	<!--main content end-->

</section>



<!--script for this page-->

<script>
            
           

            
        function retrieveLetters(){	
            var letterTemplateId =document.getElementById('letterTemplateId').value;	
            document.letterTemplateForm.action="letterTemplateAction.do?method=generatedLetterPage&letterTemplateId="+letterTemplateId;
            document.letterTemplateForm.submit();
        }
        
        function downloadTemplate(documentId)
        {	
        alert('Download document');
        document.letterTemplateForm.action="letterTemplateAction.do?method=downloadFile&documentId="+documentId;
        document.letterTemplateForm.submit();
        }
       
    </script>


