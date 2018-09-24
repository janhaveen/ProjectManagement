<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Projects</title>
    <link rel="shortcut icon" href="../../../img/TitleImage.png">
</head>
<body class="fixed-sn white-skin">
    <%@ include file="../../Header.jsp" %>
 <!--Main Navigation-->
 <!--Main layout-->
 <main>
  <div class="container">
     <div class="container-fluid">
      	<%@include file="ProjectList.jsp" %>  
       	 <%@include file="ProjectForm.jsp" %>  
       	 <%@include file="ProjectView.jsp" %> 
         <%@include file="DeleteProject.jsp" %>
     </div>
   </div>
 </main>
 <script type="text/javascript" src="../JavaScripts/Projects.js"></script>
 <script type="text/javascript" src="../JavaScripts/ProjectList.js"></script>
 <!-- <script type="text/javascript" src="../JavaScripts/DropDowns.js"></script> -->
 <script type="text/javascript" src="../../../js/General/DropDownForLegend.js"></script>
 <script type="text/javascript" src="../../../js/General/DropDownForEmployee.js"></script>
 
 <script>
     $(document).ready(function() {
         $('#datatables').DataTable();
     });
     // Material Select Initialization
     $(document).ready(function() {
         //$('select[name="datatables_length"]').material_select();
     });
     // Data Picker Initialization
     //('.datepicker').pickadate();
 </script>
</body>
</html>